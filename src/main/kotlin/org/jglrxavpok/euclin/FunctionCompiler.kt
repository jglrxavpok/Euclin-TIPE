package org.jglrxavpok.euclin

import org.antlr.v4.runtime.tree.TerminalNode
import org.jglr.inference.types.FunctionType
import org.jglr.inference.types.TypeDefinition
import org.jglrxavpok.euclin.grammar.EuclinBaseVisitor
import org.jglrxavpok.euclin.grammar.EuclinParser
import org.jglrxavpok.euclin.lambda.LambdaCompiler
import org.jglrxavpok.euclin.types.*
import org.objectweb.asm.*
import org.objectweb.asm.Opcodes.*
import java.util.*
import java.lang.invoke.MethodHandles
import java.lang.invoke.CallSite
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodType


class FunctionCompiler(val classWriter: ClassWriter, val functionSignature: FunctionSignature, val availableFunctions: Map<String, FunctionSignature>, val lambdaExpressions: Map<String, FunctionSignature>): EuclinBaseVisitor<Unit>() {

    private val writer: MethodVisitor
    private val translator = ExpressionTranslator(availableFunctions)
    private val constantChecker = ConstantChecker(availableFunctions)
    private val typeStack = Stack<TypeDefinition>()
    private val localVariableIDs = hashMapOf<String, Int>()
    private val localVariableTypes = hashMapOf<String, TypeDefinition>()
    private var localIndex = 0
    private val startLabel = Label()
    private val endLabel = Label()

    init {
        val access = ACC_FINAL or ACC_PUBLIC or ACC_STATIC
        val methodType = methodType(functionSignature.arguments, functionSignature.returnType)
        val description = methodType.descriptor
        writer = classWriter.visitMethod(access, functionSignature.name, description, null, emptyArray())
    }

    override fun visitTerminal(node: TerminalNode) {
        super.visitTerminal(node)
    }

    /**
     * Corriges l'instruction donnée pour coller au type
     */
    fun correctOpcode(baseOpcode: Int, type: TypeDefinition): Int {
        return basicType(type).getOpcode(baseOpcode)
    }

    override fun visitIntExpr(ctx: EuclinParser.IntExprContext) {
        val int = ctx.Integer().text.toInt()
        writer.visitLdcInsn(int) // on charge la valeur
        typeStack.push(IntType)
    }

    override fun visitFloatExpr(ctx: EuclinParser.FloatExprContext) {
        val float = ctx.FloatNumber().text.toFloat()
        writer.visitLdcInsn(float) // on charge la valeur
        typeStack.push(RealType)
    }

    override fun visitCoupleExpr(ctx: EuclinParser.CoupleExprContext) {
        val couple = ctx.couple()

        val left = couple.expression(0)
        val right = couple.expression(1)

        val leftType = translator.translate(left).type
        val rightType = translator.translate(right).type

        assert(rightType == leftType) { "Les éléments d'un couple doivent avoir le même type!" }

        // TODO: autres types
        // crée un nouvel objet couple:
        val baseType = leftType
        val type = if(baseType == IntType) IntPointType else RealPointType
        with(writer) {
            val asmType = basicType(type)
            val descriptor = methodType(listOf(Argument("first", baseType), Argument("second", baseType)), UnitType).descriptor
            visitTypeInsn(NEW, asmType.internalName) // on crée l'objet
            visitInsn(DUP) // on duplique l'objet créé (permet de le réutiliser après)
            visit(left)
            visit(right)
            visitMethodInsn(INVOKESPECIAL, asmType.internalName, "<init>", descriptor, false)// on l'initialise
        }
        typeStack.push(type)
    }

    override fun visitFunctionDeclaration(ctx: EuclinParser.FunctionDeclarationContext) {
        error("Il est interdit d'avoir des déclarations de fonctions dans des fonctions!")
    }

    override fun visitFunctionCall(call: EuclinParser.FunctionCallContext) {
        with(writer) {
            val function = availableFunctions[call.Identifier().text] ?: error("Aucune fonction correspondante!")

            // on compile les arguments de la fonction
            for (index in 0 until function.arguments.size) {
                val (argName, expected) = function.arguments[index]
                val argumentContext = call.expression(index)
                val translated = translator.translate(argumentContext)
                val actual = translated.type
                if (expected != actual) {
                    var actuallyValid = false
                    if(expected is FunctionType) {
                        if(expected.returnType == actual) { // si la conversion constante=>fonction est possible
                            val constantExpr = call.expression(index)
                            compileMethodReference(createConstantFunction(constantExpr)) // alors on référence la fonction correspondant
                            actuallyValid = true
                        }
                    }
                    if(!actuallyValid)
                        error("Appel d'une fonction avec le mauvais type d'arguments! $expected != $actual dans ${call.text} pour l'argument $argName")
                } else {
                    visit(argumentContext) // compile the argument
                    typeStack.pop() // on retire directement car on s'en fiche en fait ici
                    // TODO vérifier si il y a une méthode plus propre
                }
            }

            val descriptor = methodType(function.arguments, function.returnType).descriptor
            visitMethodInsn(INVOKESTATIC, toInternalName(function.ownerClass), function.name, descriptor, false)

            typeStack.push(function.returnType)
        }
    }

    private fun createConstantFunction(constantExpr: EuclinParser.ExpressionContext): FunctionSignature {
        constantChecker.assertConstant(constantExpr)
        return compileLambda(constantExpr)
    }

    private fun compileLambda(functionExpression: EuclinParser.ExpressionContext): FunctionSignature {
        val function = translator.translateLambdaExpression(functionExpression)
        val returnType = function.expression.type

        // si l'expression n'est que '_', on change le nom
        val name = LambdaCompiler.generateLambdaName(functionExpression)+"\$constant"
        val lambdaSignature = FunctionSignature(name, listOf(Argument("_", RealType)), returnType, functionSignature.ownerClass) // TODO: Meilleur nom?
        val functionBody = generateLambdaBody(functionExpression)

        val funcCompiler = FunctionCompiler(classWriter, lambdaSignature, availableFunctions, lambdaExpressions)
        funcCompiler.visitFunctionCodeBlock(functionBody)
        return lambdaSignature
    }

    fun generateLambdaBody(instruction: EuclinParser.ExpressionContext): EuclinParser.FunctionCodeBlockContext {
        val result = EuclinParser.FunctionCodeBlockContext(null, -1)
        val instructions = EuclinParser.FunctionInstructionsContext()
        result.addChild(instructions)

        val returnInstructionWrapper = EuclinParser.ReturnFuncInstructionContext(instructions)
        returnInstructionWrapper.addChild(instruction)

        instructions.addChild(returnInstructionWrapper)
        return result
    }

    override fun visitLambdaVarExpr(ctx: EuclinParser.LambdaVarExprContext?) {
        writer.visitVarInsn(correctOpcode(ILOAD, RealType), 0) // on charge le 1er argument de la fonction
        typeStack.push(RealType)
    }

    override fun visitInstructionFuncInstruction(ctx: EuclinParser.InstructionFuncInstructionContext) {
        val label = Label()
        writer.visitLineNumber(ctx.start.line, label)
        writer.visitLabel(label)
        super.visitInstructionFuncInstruction(ctx) // visite les instructions
    }

    override fun visitVarExpr(ctx: EuclinParser.VarExprContext) {
        val name = ctx.Identifier().text
        if(localVariableIDs.containsKey(name)) { // c'est bien une variable
            val varType = localVariableTypes[name]!!
            val id = localVariableIDs[name]!!
            writer.visitVarInsn(correctOpcode(ILOAD, varType), id)
            typeStack.push(varType)
        } else if(availableFunctions.containsKey(name)) { // ça peut être une fonction utilisée comme valeur, on vérifie
            val func = availableFunctions[name]!!
            compileMethodReference(func)
        }
    }

    private fun toHandle(func: FunctionSignature): Handle {
        return Handle(H_INVOKESTATIC, toInternalName(func.ownerClass), func.name, methodType(func.arguments, func.returnType).descriptor)
    }

    /**
     * Compiles une référence vers une méthode à l'aide de 'invokedynamic'. Permet de transformer des méthodes en objects Function utilisables par le reste du code
     */
    private fun compileMethodReference(signature: FunctionSignature) {
        // sorte de pointeur vers la méthode
        val methodHandle = toHandle(signature)
        val mt = MethodType.methodType(CallSite::class.java,
                MethodHandles.Lookup::class.java, String::class.java, MethodType::class.java, MethodType::class.java, MethodHandle::class.java, MethodType::class.java)
        val bootstrapHandle = Handle(H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", mt.toMethodDescriptorString())

        // /!\ signatureType et funcType ne sont pas du même type! (l'un TypeDefinition et l'autre ASMType)
        val signatureType = signature.toType()
        val funcType = methodType(signature.arguments, signature.returnType)
        writer.visitInvokeDynamicInsn("apply", methodType(emptyList(), signatureType).descriptor, bootstrapHandle, funcType, methodHandle, funcType)
        typeStack.push(signature.toType()) // on crée le type correspondant à notre signature de fonction
    }

    override fun visitLambdaFunctionExpr(ctx: EuclinParser.LambdaFunctionExprContext) {
        compileMethodReference(lambdaExpressions[ctx.expression().text]!!)
    }

    override fun visitReturnFuncInstruction(ctx: EuclinParser.ReturnFuncInstructionContext) {
        super.visitReturnFuncInstruction(ctx) // compile l'expression
        val inferredType = typeStack.pop()
        if(inferredType > functionSignature.returnType)
            error("La valeur de retour n'est pas compatible avec celui de la signature de la fonction ($inferredType > ${functionSignature.returnType})")
        writer.visitInsn(correctOpcode(IRETURN, functionSignature.returnType))
        assert(typeStack.isEmpty()) { "La pile n'était pas vide au retour" }
    }

    override fun visitFunctionCodeBlock(ctx: EuclinParser.FunctionCodeBlockContext) {
        with(writer) {
            for((name, type) in functionSignature.arguments) {
                visitParameter(name, Opcodes.ACC_FINAL)
                localVariableIDs[name] = localIndex
                localVariableTypes[name] = type
                visitLocalVariable(name, basicType(type).descriptor, null, startLabel, endLabel, localIndex++)
                translator.variableTypes[name] = type
            }
            visitCode()
            visitLabel(startLabel)
            visitChildren(ctx) // on visite les enfants
            visitLabel(endLabel)
            visitMaxs(0, 0) // nécessaire pour qu'ASM puisse calculer les stacks et les frames
            visitEnd()
        }
    }

    override fun visitBoolTrueExpr(ctx: EuclinParser.BoolTrueExprContext?) {
        writer.visitLdcInsn(true)
        typeStack.push(BooleanType)
    }

    override fun visitBoolFalseExpr(ctx: EuclinParser.BoolFalseExprContext?) {
        writer.visitLdcInsn(false)
        typeStack.push(BooleanType)
    }
}