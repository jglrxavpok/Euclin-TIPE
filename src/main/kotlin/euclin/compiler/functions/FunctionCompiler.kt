package euclin.compiler.functions

import euclin.compiler.*
import org.antlr.v4.runtime.tree.TerminalNode
import org.jglr.inference.types.FunctionType
import org.jglr.inference.types.TypeDefinition
import euclin.compiler.grammar.EuclinBaseVisitor
import euclin.compiler.grammar.EuclinParser
import euclin.compiler.types.*
import euclin.compiler.lambda.LambdaCompiler
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.*
import org.objectweb.asm.Opcodes.*
import java.util.*
import java.lang.invoke.MethodHandles
import java.lang.invoke.CallSite
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodType

open class FunctionCompiler(private val parentContext: Context): EuclinBaseVisitor<Unit>() {

    val classWriter = parentContext.classWriter
    val functionSignature = parentContext.currentFunction
    val availableFunctions = parentContext.availableFunctions
    val lambdaExpressions = parentContext.lambdaExpressions
    private val translator = parentContext.translator
    private val constantChecker = parentContext.constantChecker
    private val localVariableIDs: HashMap<String, Int>
        get() = parentContext.localVariableIDs
    private val localVariableTypes: HashMap<String, TypeDefinition>
        get() = parentContext.localVariableTypes
    private val funcMatcher = parentContext.functionMatcher

    internal val writer: MethodVisitor
    private val typeStack = Stack<TypeDefinition>()
    private var localIndex = 0
    private val startLabel = Label()
    private val endLabel = Label()

    private val isMainFunction = functionSignature.name == "__main"

    init {
        var access = ACC_FINAL or ACC_PUBLIC
        if(functionSignature.static)
            access = access or ACC_STATIC
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

        compileAssert(rightType == leftType, functionSignature.ownerClass, ctx) { "Les éléments d'un couple doivent avoir le même type!" }

        // TODO: autres types
        // crée un nouvel objet couple:
        val baseType = leftType
        val type = if(baseType == IntType) IntPointType else RealPointType
        with(writer) {
            val asmType = basicType(type)
            val descriptor = methodType(listOf(TypedMember("first", baseType), TypedMember("second", baseType)), JVMVoid).descriptor
            visitTypeInsn(NEW, asmType.internalName) // on crée l'objet
            visitInsn(DUP) // on duplique l'objet créé (permet de le réutiliser après)
            visit(left)
            visit(right)
            visitMethodInsn(INVOKESPECIAL, asmType.internalName, "<init>", descriptor, false)// on l'initialise
        }
        // on retire les types des éléments du couple
        typeStack.pop()
        typeStack.pop()
        typeStack.push(type)
    }

    override fun visitFunctionDeclaration(ctx: EuclinParser.FunctionDeclarationContext) {
        compileError("Il est interdit d'avoir des déclarations de fonctions dans des fonctions!", functionSignature.ownerClass, ctx)
    }

    override fun visitFunctionCall(call: EuclinParser.FunctionCallContext) {
        with(writer) {

            visit(call.functionIdentifier()) // on charge l'instance s'il faut
            val function = funcMatcher.visit(call.functionIdentifier())
            if( ! function.static)
                typeStack.pop()

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
                            typeStack.pop() // on retire l'argument de la pile
                        }
                    }
                    if(!actuallyValid)
                        compileError("Appel d'une fonction avec le mauvais type d'arguments! $expected != $actual dans ${call.text} pour l'argument $argName", functionSignature.ownerClass, argumentContext)
                } else {
                    visit(argumentContext) // compile l'argument
                    typeStack.pop() // on retire directement car on s'en fiche en fait ici
                }
            }

            val descriptor = methodType(function.arguments, function.returnType).descriptor
            val opcode = if(function.static) INVOKESTATIC else INVOKEVIRTUAL
            visitMethodInsn(opcode, toInternalName(function.ownerClass), function.name, descriptor, false)

            // les méthodes ayant 'void' en type de retour n'ajoutent rien sur le stack
            if(function.returnType != JVMVoid)
                typeStack.push(function.returnType)
        }
    }

    override fun visitAccessExpr(ctx: EuclinParser.AccessExprContext) {
        visit(ctx.expression())
        val chain = ctx.Identifier()
        compileSubAccessChain(chain)
    }

    override fun visitMemberFunctionIdentifier(ctx: EuclinParser.MemberFunctionIdentifierContext) {
        val identifierList = ctx.Identifier()
        compileAccessChain(identifierList.dropLast(1))
    }

    override fun visitDirectFunctionIdentifier(ctx: EuclinParser.DirectFunctionIdentifierContext) {
        val name = ctx.Identifier().text
        if(localVariableTypes.containsKey(name)) {
            val type = localVariableTypes[name]!!
            val id = localVariableIDs[name]!!
            writer.visitVarInsn(correctOpcode(ILOAD, type), id)
            typeStack.push(type)
        } else {
            val field = parentContext.field(name)
            if (field != null) {
                writer.visitFieldInsn(GETSTATIC, parentContext.currentClass, name, basicType(field.type).descriptor)
                typeStack.push(field.type)
            }
        }
    }

    /**
     * Compiles a chain of identifiers to a chain of 'getfield' opcodes
     */
    private fun compileAccessChain(chain: List<TerminalNode>) {
        val first = chain[0].text
        val lineNumber = chain[0].symbol.line
        val type = localVariableTypes[first] ?: compileError("Aucune variable du nom de $first", lineNumber, functionSignature.ownerClass)
        writer.visitVarInsn(correctOpcode(ILOAD, type), localVariableIDs[first]!!)
        typeStack.push(type)
        compileSubAccessChain(chain.drop(1))
    }

    private fun compileSubAccessChain(chain: List<TerminalNode>) {
        val lineNumber = if(chain.isEmpty()) -1 else chain[0].symbol.line
        for(id in chain) { // on regarde les identifiants qui sont nécessairement des membres
            val deepest = typeStack.pop()
            val name = id.text
            val fields = deepest.listFields()
            val parent = deepest
            val child = fields.find { it.name == name }?.type ?: compileError("Aucun membre du nom de $name dans $deepest", lineNumber, functionSignature.ownerClass)
            writer.visitFieldInsn(GETFIELD, basicType(parent).internalName, name, basicType(child).descriptor)
            typeStack.push(child)
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
        val name = LambdaCompiler.generateLambdaName(functionExpression, parentContext) +"\$constant"
        val lambdaSignature = FunctionSignature(name, listOf(TypedMember("_", RealType)), returnType, functionSignature.ownerClass, static = true)
        val functionBody = LambdaCompiler.generateLambdaBody(functionExpression)

        val funcCompiler = FunctionCompiler(parentContext.withSignature(lambdaSignature).clearLocals())
        funcCompiler.visitFunctionCodeBlock(functionBody)
        return lambdaSignature
    }

    override fun visitLambdaVarExpr(ctx: EuclinParser.LambdaVarExprContext?) {
        writer.visitVarInsn(correctOpcode(ILOAD, RealType), 0) // on charge le 1er argument de la fonction
        typeStack.push(RealType)
    }

    override fun visitVarExpr(ctx: EuclinParser.VarExprContext) {
        val name = ctx.Identifier().text
        if(localVariableIDs.containsKey(name)) { // c'est bien une variable
            val varType = localVariableTypes[name]!!
            val id = localVariableIDs[name]!!
            writer.visitVarInsn(correctOpcode(ILOAD, varType), id)
            typeStack.push(varType)
        } else {
            val field = parentContext.field(name)
            if(field != null) {
                writer.visitFieldInsn(GETSTATIC, parentContext.currentClass, name, basicType(field.type).descriptor)
                typeStack.push(field.type)
            } else if(availableFunctions.containsKey(name)) { // ça peut être une fonction utilisée comme valeur, on vérifie
                val func = availableFunctions[name]!!
                compileMethodReference(func)
            }
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
        writer.visitInvokeDynamicInsn("invoke", methodType(emptyList(), signatureType).descriptor, bootstrapHandle, funcType, methodHandle, funcType)
        typeStack.push(signature.toType()) // on crée le type correspondant à notre signature de fonction
    }

    override fun visitLambdaFunctionExpr(ctx: EuclinParser.LambdaFunctionExprContext) {
        compileMethodReference(lambdaExpressions[ctx.expression().text]!!)
    }

    override fun visitReturnFuncInstruction(ctx: EuclinParser.ReturnFuncInstructionContext) {
        super.visitReturnFuncInstruction(ctx) // compile l'expression
        val inferredType = typeStack.pop()
        if(inferredType > functionSignature.returnType)
            compileError("La valeur de retour n'est pas compatible avec celui de la signature de la fonction ($inferredType > ${functionSignature.returnType})", functionSignature.ownerClass, ctx)
        writer.visitInsn(correctOpcode(IRETURN, functionSignature.returnType))
        compileAssert(typeStack.isEmpty(), functionSignature.ownerClass, ctx) { "La pile n'était pas vide au retour, il reste au moins: ${typeStack.peek()}" }
    }

    override fun visitFunctionCodeBlock(ctx: EuclinParser.FunctionCodeBlockContext) {
        compileFuncHeader()
        with(writer) {

            val lastIndex = ctx.functionInstructions().size - 1
            ctx.functionInstructions().forEachIndexed { index, it ->
                addLineInfos(it)
                visit(it)

                // insertion automatique de return si on est à la fin de la fonction
                if (index == lastIndex) {
                    if (it !is EuclinParser.ReturnFuncInstructionContext) {
                        if (typeStack.isNotEmpty()) {
                            compileAssert(typeStack.size == 1, functionSignature.ownerClass, it)
                            { "Il ne doit y avoir qu'une seule valeur sur le stack pour insérer automatiquement un 'return'! (il y en avait ${typeStack.size})" }
                            val expected = functionSignature.returnType
                            val actual = typeStack.pop() // on retire l'élement de la pile

                            // la première condition permet d'éviter les exceptions dûes à l'impossibilité de la comparaison dans certains cas
                            if (expected != actual || expected < actual) { // le type actuel ne peut rentrer dans le type attendu
                                if (expected == UnitType) { // on ne s'occupe pas de la dernière valeur
                                    // on retire l'élément, on charge Unit et on le renvoit
                                    writer.visitInsn(POP)
                                    loadUnitOnStack()
                                    writer.visitInsn(ARETURN)
                                } else {
                                    compileError("Incompatibilité de types lors de l'insertion automatique de 'return' $expected != $actual (${functionSignature.name})", functionSignature.ownerClass, it)
                                }
                            } else { // tout va bien
                                writer.visitInsn(correctOpcode(IRETURN, functionSignature.returnType))
                            }
                        } else { // si on est pas une instruction 'return' et que le stack est vide
                            compileAssert(functionSignature.returnType == UnitType, functionSignature.ownerClass, ctx)
                            { "Aucune valeur renvoyée pour une fonction qui n'est pas une 'Unit function'! ${it.text} ${it.javaClass} ${ctx.text}" }
                            loadUnitOnStack()
                            writer.visitInsn(ARETURN) // on renvoit le Unit
                        }
                    }
                } else {
                    // s'il reste des valeurs sur le stack à la fin de l'instruction, on les retire
                    while (typeStack.isNotEmpty()) {
                        writer.visitInsn(POP)
                        typeStack.pop()
                    }
                }
            }
        }

        compileFuncFooter()
    }

    internal fun compileFuncFooter() {
        with(writer) {
            visitLabel(endLabel)

            val names = localVariableTypes.keys
            for(name in names) {
                val id = localVariableIDs[name]!!
                val type = localVariableTypes[name]!!
                visitLocalVariable(name, basicType(type).descriptor, null, startLabel, endLabel, id)
            }
            visitMaxs(0, 0) // nécessaire pour qu'ASM puisse calculer les stacks et les frames
            visitEnd()
        }
    }

    internal fun compileFuncHeader() {
        with(writer) {
            for ((index, arg) in functionSignature.arguments.withIndex()) {
                val (name, type) = arg
                visitParameter(name, Opcodes.ACC_FINAL)
                localVariableIDs[name] = index
                localVariableTypes[name] = type
            }
            visitCode()
            visitLabel(startLabel)
        }
    }

    internal fun addLineInfos(ctx: ParserRuleContext) {
        if(ctx.start != null) { // si on a bien une info sur la ligne dans le code source
            val label = Label()
            writer.visitLabel(label)
            writer.visitLineNumber(ctx.start.line, label)
        }
    }

    override fun visitBoolTrueExpr(ctx: EuclinParser.BoolTrueExprContext?) {
        loadBooleanRaw(true)
        typeStack.push(BooleanType)
    }

    override fun visitBoolFalseExpr(ctx: EuclinParser.BoolFalseExprContext?) {
        loadBooleanRaw(false)
        typeStack.push(BooleanType)
    }

    override fun visitUnitExpr(ctx: EuclinParser.UnitExprContext) {
        loadUnitOnStack()
        typeStack.push(UnitType)
    }

    override fun visitStringExpr(ctx: EuclinParser.StringExprContext) {
        val str = ctx.StringConstant().text
        val content = str.substring(1, str.length-1) // on retire les guillemets qui entourent le texte
        writer.visitLdcInsn(content)
        typeStack.push(StringType)
    }

    fun loadUnitOnStack() {
        // Kotlin compile les singletons en des champs statiques nommés 'INSTANCE'
        writer.visitFieldInsn(GETSTATIC, "euclin/std/UnitObject", "INSTANCE", "Leuclin/std/UnitObject;")
    }

    override fun visitAddExpr(ctx: EuclinParser.AddExprContext) {
        val left = ctx.expression(0)
        val right = ctx.expression(1)
        if(translator.translate(left).type == StringType) { // on veut concaténer deux String
            // exemple de code décompilé:
            /* val builder: StringBuilder =
            StringBuilder(<left>)
                .append(<right>)
                .toString()

             */

            with(writer) {
                val stringBuilderInternalName = "java/lang/StringBuilder"
                visitTypeInsn(NEW, stringBuilderInternalName)

                visitInsn(DUP) // on duplique deux fois le builder: pour <init>, pour 'append' et pour 'toString()'
                visitInsn(DUP)

                // compilation du membre gauche et appel de constructeur
                visit(left)
                visitMethodInsn(INVOKESPECIAL, stringBuilderInternalName, "<init>", "(Ljava/lang/String;)V", false)

                // compilation membre droite + appel à 'append'
                visit(right)
                visitMethodInsn(INVOKEVIRTUAL, stringBuilderInternalName, "append", "(Ljava/lang/String;)L$stringBuilderInternalName;", false) // le builder se renvoit lui-même

                // renvoi du résultat
                visitMethodInsn(INVOKESPECIAL, stringBuilderInternalName, "toString", "()Ljava/lang/String;", false)
            }

            // on retire les termes du stack
            typeStack.pop()
            typeStack.pop()
            typeStack.push(StringType)
        } else {
            compileOperation(left, right, IADD, "plus")
        }
    }

    override fun visitSubExpr(ctx: EuclinParser.SubExprContext) {
        val left = ctx.expression(0)
        val right = ctx.expression(1)
        compileOperation(left, right, ISUB, "minus")
    }

    override fun visitMultExpr(ctx: EuclinParser.MultExprContext) {
        val left = ctx.expression(0)
        val right = ctx.expression(1)
        compileOperation(left, right, IMUL, "times")
    }

    override fun visitDivExpr(ctx: EuclinParser.DivExprContext) {
        val left = ctx.expression(0)
        val right = ctx.expression(1)
        compileOperation(left, right, IDIV, "div")
    }

    /**
     * Compiles les deux termes et crées les instructions pour construire le résultat
     */
    private fun compileOperation(left: EuclinParser.ExpressionContext, right: EuclinParser.ExpressionContext, opcode: Int, functionName: String) {
        val leftExpr = translator.translate(left)
        val rightExpr = translator.translate(right)
        compileAssert(leftExpr.type == rightExpr.type, functionSignature.ownerClass, left) { "Les valeurs doivent être du même type! ${leftExpr.type} != ${rightExpr.type}" }
        visit(left)
        visit(right)
        when(leftExpr.type) {
            RealType, IntType -> writer.visitInsn(correctOpcode(opcode, leftExpr.type))

            // cet appel de fonction fonctionne car l'instance de l'objet sur laquelle on agit est considérée comme 'left'
            RealPointType -> writer.visitMethodInsn(INVOKEVIRTUAL, "euclin/std/RealPoint", functionName, "(Leuclin/std/RealPoint;)Leuclin/std/RealPoint;", false)
            IntPointType -> writer.visitMethodInsn(INVOKEVIRTUAL, "euclin/std/IntPoint", functionName, "(Leuclin/std/IntPoint;)Leuclin/std/IntPoint;", false)
            else -> compileError("Impossible d'ajouter deux valeurs du type ${leftExpr.type}", functionSignature.ownerClass, left)
        }

        // on retire les termes
        typeStack.pop()
        typeStack.pop()
        // on ajoute le type du résultat (on pourrait juste retirer un élément, mais cela ne serait pas clair et on laisse ainsi la possibilité de casts implicites)
        typeStack.push(leftExpr.type)
    }

    override fun visitDeclareVarInstruction(ctx: EuclinParser.DeclareVarInstructionContext) {
        visit(ctx.variableDeclaration())
    }

    override fun visitAssignVarInstruction(ctx: EuclinParser.AssignVarInstructionContext) {
        visit(ctx.variableAssign())
    }

    override fun visitVariableDeclaration(ctx: EuclinParser.VariableDeclarationContext) {
        val name = ctx.Identifier().text
        if(localVariableIDs.containsKey(name))
            compileError("Il y a déjà une variable appelée $name!", functionSignature.ownerClass, ctx)
        if(parentContext.field(name) != null)
            compileWarning("La variable $name obscure le champ du même nom", parentContext.currentClass, ctx)

        val expression = ctx.expression()
        val value = translator.translate(expression)

        if(isMainFunction) {
            val declaredField = TypedMember(name, value.type)
            parentContext.fields += declaredField

            visit(expression)
            writer.visitFieldInsn(PUTSTATIC, parentContext.currentClass, name, basicType(value.type).descriptor)
            typeStack.pop()
        } else {
            val varID = localIndex++
            localVariableIDs[name] = varID
            localVariableTypes[name] = value.type

            storeValue(expression, value.type, varID)
        }
    }

    override fun visitMemberAssign(ctx: EuclinParser.MemberAssignContext) {
        visit(ctx.expression(0))
        val chain = ctx.Identifier().dropLast(1)
        compileSubAccessChain(chain)

        val targetName = ctx.Identifier().last().text
        val targetType = typeStack.pop()
        val field = targetType.listFields().find { it.name == targetName } ?: compileError("Aucun membre du nom de $targetName dans $targetType", functionSignature.ownerClass, ctx)
        visit(ctx.expression(1))
        val value = translator.translate(ctx.expression(1))
        writer.visitFieldInsn(PUTFIELD, basicType(targetType).internalName, field.name, basicType(value.type).descriptor)
        typeStack.pop()
    }

    override fun visitVariableAssign(ctx: EuclinParser.VariableAssignContext) {
        val name = ctx.Identifier().text
        val expression = ctx.expression()
        val value = translator.translate(expression)

        if(localVariableTypes.containsKey(name)) {
            val localType = localVariableTypes[name]!!
            compileAssert(localType >= value.type, functionSignature.ownerClass, ctx) { "Impossible de stocker une valeur de type ${value.type} dans une variable de type $localType" }

            val varID = localVariableIDs[name]!!
            storeValue(expression, localType, varID)
        } else {
            val field = parentContext.field(name)
            if(field != null) {
                visit(expression)
                writer.visitFieldInsn(PUTSTATIC, parentContext.currentClass, name, basicType(field.type).descriptor)
                compileAssert(field.type >= value.type, functionSignature.ownerClass, ctx) { "Impossible de stocker une valeur de type ${value.type} dans un champ de type ${field.type}" }
                typeStack.pop()
            } else {
                compileError("Aucune variable du nom de $name", parentContext.currentClass, ctx)
            }
        }
    }

    private fun storeValue(expression: EuclinParser.ExpressionContext, type: TypeDefinition, varID: Int) {
        visit(expression) // on compile la valeur
        typeStack.pop()
        writer.visitVarInsn(correctOpcode(ISTORE, type), varID) // et on la stocke dans la variable
    }

    override fun visitTransformBlock(ctx: EuclinParser.TransformBlockContext) {
        writer.visitMethodInsn(INVOKESTATIC, "euclin/std/Geometry", "pushTransform", "()V", false)
        visit(ctx.codeBlock())
        writer.visitMethodInsn(INVOKESTATIC, "euclin/std/Geometry", "popTransform", "()V", false)
    }

    override fun visitWhileLoopInstruction(ctx: EuclinParser.WhileLoopInstructionContext) {
        val conditionExpr = ctx.expression()
        val condition = translator.translate(conditionExpr)
        compileAssert(condition.type == BooleanType, functionSignature.ownerClass, ctx) { "La condition doit être un booléen!" }
        val code = ctx.instructions()
        val conditionLabel = Label()
        val endLabel = Label()

        with(writer) {
            visitLabel(conditionLabel)
            visit(conditionExpr) // la condition
            visitJumpInsn(IFEQ, endLabel) // si la condition = false alors on va à 'endLabel'
            typeStack.pop()

            compileInstructions(code)

            visitJumpInsn(GOTO, conditionLabel) // on retourne au début de la boucle

            visitLabel(endLabel)
            // fin
        }
    }

    private fun compileInstructions(code: List<EuclinParser.InstructionsContext>) {
        for(instruction in code) {
            addLineInfos(instruction)
            visit(instruction) // on compile l'instruction

            // on vide le stack si nécessaire
            if (typeStack.isNotEmpty()) {
                compileAssert(typeStack.size == 1, functionSignature.ownerClass, instruction) { "Il ne doit y avoir qu'une seule valeur sur le stack à la fin d'une instruction!" }
                typeStack.pop()
                writer.visitInsn(POP)
            }
        }
    }

    override fun visitIfBranchingInstruction(ctx: EuclinParser.IfBranchingInstructionContext) {
        val conditionExpr = ctx.expression()
        val condition = translator.translate(conditionExpr)
        compileAssert(condition.type == BooleanType, functionSignature.ownerClass, ctx) { "La condition doit être un booléen!" }
        val code = ctx.instructions()
        val endLabel = Label()
        val elseStartLabel = Label()

        val hasElseBlock = ctx.elseBlock() != null

        with(writer) {
            visit(conditionExpr)
            visitJumpInsn(IFEQ, if(hasElseBlock) elseStartLabel else endLabel) // soit on va dans le bloc else, soit on va à la fin (parce qu'il n'y a pas de else)
            typeStack.pop()

            compileInstructions(code)
            visitJumpInsn(GOTO, endLabel) // on a fini le code dans le 'if', on va à la fin

            if(hasElseBlock) {
                val elseBlock = ctx.elseBlock()
                visitLabel(elseStartLabel)
                compileInstructions(elseBlock.instructions())
            }

            visitLabel(endLabel)
        }
    }

    // Opérateurs de comparaison
    private fun compare(left: EuclinParser.ExpressionContext, right: EuclinParser.ExpressionContext, jumpOpcode: Int) {
        val valueType = translator.translate(left).type

        compileAssert(valueType == RealType || valueType == IntType || valueType == StringType, functionSignature.ownerClass, left)
            { "On ne peut comparer que les types String, Int et Real!" }

        val trueLabel = Label()
        val endLabel = Label()
        with(writer) {
            visit(left)
            visit(right)
            typeStack.pop()
            typeStack.pop()

            // /!\ Astuce: la comparaison va nous donner un nombre que l'on va ensuite comparer à 0
            if(valueType == RealType) { // c'est un float
                visitInsn(FCMPL) // on compare
                visitIntInsn(BIPUSH, 0)
                visitInsn(SWAP)
            } else if(valueType == StringType) {
                visitMethodInsn(INVOKEINTERFACE, "java/lang/String", "compareTo", "(Ljava/lang/Object;)I", true)
                visitIntInsn(BIPUSH, 0)
            }

            visitJumpInsn(jumpOpcode, trueLabel) // c'est une valeur > donc on charge 'true'
            loadBooleanRaw(false)
            visitJumpInsn(GOTO, endLabel)

            visitLabel(trueLabel)
            loadBooleanRaw(true)

            visitLabel(endLabel)
        }

        typeStack.push(BooleanType)
    }

    override fun visitGreaterExpr(ctx: EuclinParser.GreaterExprContext) {
        val left = ctx.expression(0)
        val right = ctx.expression(1)

        compare(left, right, IF_ICMPGT)
    }

    override fun visitGreaterEqualExpr(ctx: EuclinParser.GreaterEqualExprContext) {
        val left = ctx.expression(0)
        val right = ctx.expression(1)

        compare(left, right, IF_ICMPGE)
    }

    override fun visitLessExpr(ctx: EuclinParser.LessExprContext) {
        val left = ctx.expression(0)
        val right = ctx.expression(1)

        compare(left, right, IF_ICMPLT)
    }

    override fun visitLessEqualExpr(ctx: EuclinParser.LessEqualExprContext) {
        val left = ctx.expression(0)
        val right = ctx.expression(1)

        compare(left, right, IF_ICMPLE)
    }

    override fun visitEquality(ctx: EuclinParser.EqualityContext) {
        val left = ctx.expression(0)
        val right = ctx.expression(1)

        val leftType = translator.translate(left).type
        val rightType = translator.translate(right).type
        if(leftType == StringType && rightType == StringType) {
            compareStrings(left, right, negate=false)
        } else {
            compare(left, right, IF_ICMPEQ)
        }
    }

    override fun visitInequality(ctx: EuclinParser.InequalityContext) {
        val left = ctx.expression(0)
        val right = ctx.expression(1)

        val leftType = translator.translate(left).type
        val rightType = translator.translate(right).type
        if(leftType == StringType && rightType == StringType) {
            compareStrings(left, right, negate=true)
        } else {
            compare(left, right, IF_ICMPNE)
        }
    }

    private fun compareStrings(left: EuclinParser.ExpressionContext, right: EuclinParser.ExpressionContext, negate: Boolean) {
        with(writer) {
            visit(left)
            visit(right)
            typeStack.pop()
            typeStack.pop()

            // on utilise la méthode de comparaison de la classe String
            visitMethodInsn(INVOKEINTERFACE, "java/lang/String", "equals", "(Ljava/lang/Object;)Z", true)
            if(negate)
                negateBoolean()
        }

        typeStack.push(BooleanType)
    }

    // Fin des opérateurs de comparaison

    private fun negateBoolean() {
        val negateEnd = Label()
        val branchFalse = Label()
        writer.visitJumpInsn(IFNE, branchFalse)
        loadBooleanRaw(true)
        writer.visitJumpInsn(GOTO, negateEnd)

        writer.visitLabel(branchFalse)
        loadBooleanRaw(false)
        writer.visitLabel(negateEnd)
    }

    /**
     * Ne charge pas la valeur dans 'typeStack'
     */
    private fun loadBooleanRaw(value: Boolean) {
        writer.visitIntInsn(BIPUSH, if(value) 1 else 0) // la JVM préfère ça au 'LDC' pour les booléens
    }
}