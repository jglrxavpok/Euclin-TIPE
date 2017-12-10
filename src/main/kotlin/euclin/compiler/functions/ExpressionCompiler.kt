package euclin.compiler.functions

import euclin.compiler.*
import euclin.compiler.grammar.EuclinBaseVisitor
import euclin.compiler.grammar.EuclinParser
import euclin.compiler.types.*
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.TerminalNode
import org.jglr.inference.expressions.OpaqueExpression
import org.jglr.inference.types.FunctionType
import org.jglr.inference.types.TypeDefinition
import org.objectweb.asm.Handle
import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes
import java.lang.invoke.CallSite
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import java.util.*

abstract class ExpressionCompiler(val parentContext: Context): EuclinBaseVisitor<Unit>() {
    val classWriter = parentContext.classWriter
    val functionSignature = parentContext.currentFunction
    val availableFunctions = parentContext.availableFunctions
    protected val translator = parentContext.translator
    protected val constantChecker = parentContext.constantChecker
    protected val localVariableIDs: HashMap<String, Int>
        get() = parentContext.localVariableIDs
    protected val localVariableTypes: HashMap<String, TypeDefinition>
        get() = parentContext.localVariableTypes
    protected val funcMatcher = parentContext.functionMatcher

    protected val typeStack = Stack<TypeDefinition>()
    protected var localIndex = 0
    protected val startLabel = Label()
    protected val endLabel = Label()

    protected open val isMainFunction = false

    internal lateinit var writer: MethodVisitor

    protected fun TypeDefinition.popFromStack() {
        if(this == Real64Type || this == Int64Type)
            writer.visitInsn(Opcodes.POP2)
        else
            writer.visitInsn(Opcodes.POP)
    }

    override fun visitIntExpr(ctx: EuclinParser.IntExprContext) {
        val int = ctx.Integer().text.toLong()
        writer.visitLdcInsn(int) // on charge la valeur
        typeStack.push(Int64Type)
    }

    override fun visitFloatExpr(ctx: EuclinParser.FloatExprContext) {
        val float = ctx.FloatNumber().text.toDouble()
        writer.visitLdcInsn(float) // on charge la valeur
        typeStack.push(Real64Type)
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
        val type = when(baseType) {
            Real64Type -> Real64PointType
            Real32Type -> Real32PointType

            Int64Type -> Int64PointType
            Int32Type -> Int32PointType
            else -> compileError("Impossible de créer un couple ($leftType, $rightType)", parentContext.currentClass, ctx)
        }
        with(writer) {
            val asmType = type.toASM()
            val descriptor = methodType(listOf(TypedMember("first", baseType), TypedMember("second", baseType)), JVMVoid).descriptor
            visitTypeInsn(Opcodes.NEW, asmType.internalName) // on crée l'objet
            visitInsn(Opcodes.DUP) // on duplique l'objet créé (permet de le réutiliser après)
            visit(left)
            visit(right)
            visitMethodInsn(Opcodes.INVOKESPECIAL, asmType.internalName, "<init>", descriptor, false)// on l'initialise
        }
        // on retire les types des éléments du couple
        typeStack.pop()
        typeStack.pop()
        typeStack.push(type)
    }

    /**
     * Compiles a chain of identifiers to a chain of 'getfield' opcodes
     */
    protected fun compileAccessChain(chain: List<TerminalNode>) {
        val first = chain[0].text
        val lineNumber = chain[0].symbol.line
        if( ! localVariableTypes.containsKey(first)) {
            val field = parentContext.field(first)
            if(field != null) {
                writer.visitFieldInsn(Opcodes.GETSTATIC, parentContext.currentClass.toInternalName(), first, field.type.toASM().descriptor)
                typeStack.push(field.type)
            } else {
                if (parentContext.knowsType(first))
                    return // on appelle une méthode ou un champ statique appartenant à un type connu
                compileError("Aucune variable du nom de $first", lineNumber, functionSignature.ownerClass)
            }
        } else {
            val type = localVariableTypes[first]!!
            writer.visitVarInsn(type.correctOpcode(Opcodes.ILOAD), localVariableIDs[first]!!)
            typeStack.push(type)
        }
        compileSubAccessChain(chain.drop(1))
    }

    protected fun compileSubAccessChain(chain: List<TerminalNode>) {
        val lineNumber = if(chain.isEmpty()) -1 else chain[0].symbol.line
        for(id in chain) { // on regarde les identifiants qui sont nécessairement des membres
            val deepest = typeStack.pop()
            val name = id.text
            if(deepest is ArrayType && name == "length") {
                writer.visitInsn(Opcodes.ARRAYLENGTH)
                typeStack.push(Int32Type)
            } else if(deepest.listStaticFields().any { it.name == name }) {
                deepest.popFromStack()
                val child = deepest.listStaticFields().find { it.name == name }!!.type
                writer.visitFieldInsn(Opcodes.GETSTATIC, deepest.toASM().internalName, name, child.toASM().descriptor)
                typeStack.push(child)
            } else {
                val fields = deepest.listFields()
                val child = fields.find { it.name == name }?.type ?: compileError("Aucun membre du nom de $name dans $deepest", lineNumber, functionSignature.ownerClass)
                writer.visitFieldInsn(Opcodes.GETFIELD, deepest.toASM().internalName, name, child.toASM().descriptor)
                typeStack.push(child)
            }
        }
    }

    override fun visitAccessExpr(ctx: EuclinParser.AccessExprContext) {
        if(ctx.expression() is EuclinParser.VarExprContext) {
            val varContext = ctx.expression() as EuclinParser.VarExprContext
            val name = varContext.Identifier().text
            if(parentContext.knowsType(name)) {
                val type = parentContext.type(name)
                typeStack.push(type)
                val chain = ctx.Identifier()
                compileSubAccessChain(chain)
                return
            }
        }
        visit(ctx.expression())
        val chain = ctx.Identifier()
        compileSubAccessChain(chain)
    }

    override fun visitLambdaVarExpr(ctx: EuclinParser.LambdaVarExprContext) {
        val index = functionSignature.arguments.indexOfFirst { it.name == "_" }
        var actualIndex = 0
        for(arg in 0 until index) {
            actualIndex += functionSignature.arguments[arg].type.localSize
        }
        val type = functionSignature.arguments[index].type
        writer.visitVarInsn(type.correctOpcode(Opcodes.ILOAD), index)
        typeStack.push(type)
    }

    override fun visitVarExpr(ctx: EuclinParser.VarExprContext) {
        val name = ctx.Identifier().text
        loadName(name, ctx)
    }

    private fun loadName(name: String, ctx: ParserRuleContext) {
        if(localVariableIDs.containsKey(name)) { // c'est bien une variable
            val varType = localVariableTypes[name]!!
            val id = localVariableIDs[name]!!
            writer.visitVarInsn(varType.correctOpcode(Opcodes.ILOAD), id)
            typeStack.push(varType)
        } else {
            val field = parentContext.field(name)
            if(field != null) {
                writer.visitFieldInsn(Opcodes.GETSTATIC, parentContext.currentClass.toInternalName(), name, field.type.toASM().descriptor)
                typeStack.push(field.type)
            } else if(availableFunctions.containsKey(name)) { // ça peut être une fonction utilisée comme valeur, on vérifie
                val func = availableFunctions[name]!!
                compileMethodReference(func)
            } else {
                compileError("Aucune variable du nom de $name", parentContext.currentClass, ctx)
            }
        }
    }

    /**
     * Compiles une référence vers une méthode à l'aide de 'invokedynamic'. Permet de transformer des méthodes en objects Function utilisables par le reste du code
     */
    protected fun compileMethodReference(signature: FunctionSignature, localVarUsed: List<String> = emptyList(), lambdaImplementationSignature: FunctionSignature = signature) {
        for(name in localVarUsed) { // on charge les potentielles variables locales à utiliser
            val type = localVariableTypes[name]!!
            val id = localVariableIDs[name]!!
            writer.visitVarInsn(type.correctOpcode(Opcodes.ILOAD), id)
        }

        // sorte de pointeur vers la méthode
        val methodHandle = lambdaImplementationSignature.toHandle()
        val mt = MethodType.methodType(CallSite::class.java,
                MethodHandles.Lookup::class.java, String::class.java, MethodType::class.java, MethodType::class.java, MethodHandle::class.java, MethodType::class.java)
        val bootstrapHandle = Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", mt.toMethodDescriptorString())

        // /!\ signatureType et funcType ne sont pas du même type! (l'un TypeDefinition et l'autre ASMType)
        val signatureType = signature.toType()
        val returnType = BasicType(javaTypeName(signatureType as FunctionType))
        val funcType = methodType(signature.arguments, signature.returnType)
        writer.visitInvokeDynamicInsn(interfaceFunctionName(signatureType), methodType(returnType, localVarUsed.map { localVariableTypes[it]!! }).descriptor, bootstrapHandle, funcType, methodHandle, funcType)
        typeStack.push(signatureType) // on crée le type correspondant à notre signature de fonction
    }

    override fun visitBoolTrueExpr(ctx: EuclinParser.BoolTrueExprContext?) {
        loadBooleanRaw(true)
        typeStack.push(BooleanType)
    }

    override fun visitBoolFalseExpr(ctx: EuclinParser.BoolFalseExprContext?) {
        loadBooleanRaw(false)
        typeStack.push(BooleanType)
    }

    protected fun negateBoolean() {
        val negateEnd = Label()
        val branchFalse = Label()
        writer.visitJumpInsn(Opcodes.IFNE, branchFalse)
        loadBooleanRaw(true)
        writer.visitJumpInsn(Opcodes.GOTO, negateEnd)

        writer.visitLabel(branchFalse)
        loadBooleanRaw(false)
        writer.visitLabel(negateEnd)
    }

    /**
     * Ne charge pas la valeur dans 'typeStack'
     */
    protected fun loadBooleanRaw(value: Boolean) {
        writer.visitIntInsn(Opcodes.BIPUSH, if(value) 1 else 0) // la JVM préfère ça au 'LDC' pour les booléens
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
        writer.visitFieldInsn(Opcodes.GETSTATIC, "euclin/std/UnitObject", "INSTANCE", "Leuclin/std/UnitObject;")
    }

    internal fun addLineInfos(ctx: ParserRuleContext) {
        if(ctx.start != null) { // si on a bien une info sur la ligne dans le code source
            val label = Label()
            writer.visitLabel(label)
            writer.visitLineNumber(ctx.start.line, label)
        }
    }

    override fun visitArrayExpr(ctx: EuclinParser.ArrayExprContext) {
        val elements = ctx.expression()
        val type = translator.translate(ctx).type as ArrayType
        val length = elements.size
        val elementType = type.elementType
        with(writer) {
            visitIntInsn(Opcodes.SIPUSH, length)
            if(elementType is NativeType) {
                val arrayType = when(elementType) {
                    Int8Type -> Opcodes.T_BYTE
                    BooleanType -> Opcodes.T_BOOLEAN
                    Int16Type -> Opcodes.T_SHORT
                    Int32Type -> Opcodes.T_INT
                    Int64Type -> Opcodes.T_LONG
                    Real32Type -> Opcodes.T_FLOAT
                    Real64Type -> Opcodes.T_DOUBLE
                    CharType -> Opcodes.T_CHAR
                    else -> TODO()
                }
                visitIntInsn(Opcodes.NEWARRAY, arrayType)
            } else {
                visitTypeInsn(Opcodes.ANEWARRAY, "java/lang/Object")
            }

            visitInsn(Opcodes.DUP)

            for((index, elem) in elements.withIndex()) {
                visitIntInsn(Opcodes.SIPUSH, index)
                visit(elem)
                typeStack.pop()
                visitInsn(elementType.correctOpcode(Opcodes.IASTORE))
                visitInsn(Opcodes.DUP)
            }
        }
        typeStack.push(type)
    }

    override fun visitAccessArrayExpr(ctx: EuclinParser.AccessArrayExprContext) {
        visit(ctx.expression(0))
        val arrayType = typeStack.pop()
        compileAssert(arrayType is ArrayType, parentContext.currentClass, ctx) { "L'accès doit se faire avec un tableau" }
        visit(ctx.expression(1))
        val indexType = typeStack.pop()
        if(indexType == Int64Type) {
            compileWarning("L'indice va être implicitement converti en Int32", parentContext.currentClass, ctx)
            compileNativeCast(Int64Type, Int32Type, ctx.start?.line ?: -1)
            //typeStack.push(Int32Type)
        } else {
            compileAssert(indexType.isIntType(maxBitSize = 32), parentContext.currentClass, ctx) { "L'indice doit être un entier! (était $indexType)" }
        }
        val elementType = (arrayType as ArrayType).elementType
        writer.visitInsn(elementType.correctOpcode(Opcodes.IALOAD))
        typeStack.push(elementType)
    }

    override fun visitCastExpr(ctx: EuclinParser.CastExprContext) {
        val expression = ctx.expression()
        val currentType = translator.translate(expression).type
        val targetType = parentContext.typeConverter.visit(ctx.type())
        if(targetType == currentType) {
            compileWarning("Useless cast", parentContext.currentClass, ctx)
            return
        }

        visit(expression)
        typeStack.pop()
        typeStack.push(targetType)

        if(targetType == StringType) { // il suffit d'appeler String.valueOf
            val descriptor = when(currentType) {
                is NativeType -> currentType.getDescriptor()
                else -> "Ljava/lang/Object;"
            }
            writer.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/String", "valueOf", "($descriptor)Ljava/lang/String;", false)
        } else if(targetType is NativeType) {
            val line = ctx.start?.line ?: -1
            if(currentType is NativeType) {
                compileNativeCast(currentType, targetType, line)
            } else {
                FunctionCompiler.convertBoxedObjectToNativeType(writer, targetType)
            }
        } else {
            if(currentType is NativeType) {
                FunctionCompiler.convertNativeTypeToBoxed(writer, currentType)
            }
            writer.visitTypeInsn(Opcodes.CHECKCAST, targetType.toASM().internalName)
        }
    }

    protected fun compileNativeCast(current: NativeType, target: NativeType, lineInFile: Int) {
        fun unsupportedCast() {
            compileError("Cast impossible de $current à $target", lineInFile, parentContext.currentClass)
        }
        if(current == target) // on a rien à faire ici
            return

        if(current == BooleanType || current == Int16Type || current == Int8Type || current == CharType) {
            compileNativeCast(Int32Type, target, lineInFile) // ces types ne sont que des entiers pour la JVM
            return
        }
        with(writer) {
            when(current.backing.descriptor) {
                "I" -> {
                    when(target.backing.descriptor) {
                        "F" -> visitInsn(Opcodes.I2F)
                        "D" -> visitInsn(Opcodes.I2D)
                        "J" -> visitInsn(Opcodes.I2L)
                        "B" -> visitInsn(Opcodes.I2B)
                        "S" -> visitInsn(Opcodes.I2S)
                        "C" -> visitInsn(Opcodes.I2C)
                        else -> unsupportedCast()
                    }
                }
                "F" -> {
                    when(target.backing.descriptor) {
                        "I" -> visitInsn(Opcodes.F2I)
                        "D" -> visitInsn(Opcodes.F2D)
                        "J" -> visitInsn(Opcodes.F2L)
                        "B", "S", "C" -> {
                            visitInsn(Opcodes.F2I)
                            compileNativeCast(Int32Type, target, lineInFile)
                        }
                        else -> unsupportedCast()
                    }
                }
                "D" -> when(target.backing.descriptor) {
                    "F" -> visitInsn(Opcodes.D2F)
                    "I" -> visitInsn(Opcodes.D2I)
                    "J" -> visitInsn(Opcodes.D2L)
                    "B", "S", "C" -> {
                        visitInsn(Opcodes.D2I)
                        compileNativeCast(Int32Type, target, lineInFile)
                    }
                    else -> unsupportedCast()
                }
                "J" -> when(target.backing.descriptor) {
                    "F" -> visitInsn(Opcodes.L2F)
                    "D" -> visitInsn(Opcodes.L2D)
                    "I" -> visitInsn(Opcodes.L2I)
                    "B", "S", "C" -> {
                        visitInsn(Opcodes.L2I)
                        compileNativeCast(Int32Type, target, lineInFile)
                    }
                    else -> unsupportedCast()
                }
                else -> unsupportedCast()
            }
        }
    }

    override fun visitCharExpr(ctx: EuclinParser.CharExprContext) {
        val char = ctx.CharConstant().text[1]
        writer.visitLdcInsn(char)
        typeStack.push(CharType)
    }

    override fun visitNewArrayExpr(ctx: EuclinParser.NewArrayExprContext) {
        val arrayType = translator.translate(ctx).type as ArrayType
        // compile 'length'
        visit(ctx.expression())
        val indexType = typeStack.pop()
        if(indexType == Int64Type) {
            compileWarning("La taille du tableau va être implicitement converti en Int32", parentContext.currentClass, ctx)
            compileNativeCast(Int64Type, Int32Type, ctx.start?.line ?: -1)
            //typeStack.push(Int32Type)
        } else {
            compileAssert(arrayType.isIntType(maxBitSize = 32), parentContext.currentClass, ctx) { "La taille du tableau doit être un entier!" }
        }
        val elementType = arrayType.elementType
        with(writer) {
            if(elementType is NativeType) {
                val arrayTypeASM = when(elementType) {
                    Int8Type -> Opcodes.T_BYTE
                    BooleanType -> Opcodes.T_BOOLEAN
                    Int16Type -> Opcodes.T_SHORT
                    Int32Type -> Opcodes.T_INT
                    Int64Type -> Opcodes.T_LONG
                    Real32Type -> Opcodes.T_FLOAT
                    Real64Type -> Opcodes.T_DOUBLE
                    CharType -> Opcodes.T_CHAR
                    else -> TODO()
                }
                visitIntInsn(Opcodes.NEWARRAY, arrayTypeASM)
            } else {
                visitTypeInsn(Opcodes.ANEWARRAY, elementType.toASM().internalName)
            }

        }
        typeStack.push(arrayType)
    }
}