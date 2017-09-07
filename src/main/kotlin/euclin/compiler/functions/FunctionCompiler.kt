package euclin.compiler.functions

import euclin.compiler.*
import org.antlr.v4.runtime.tree.TerminalNode
import org.jglr.inference.types.FunctionType
import org.jglr.inference.types.TypeDefinition
import euclin.compiler.grammar.EuclinParser
import euclin.compiler.types.*
import org.jglr.inference.types.TupleType
import org.objectweb.asm.*
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.signature.SignatureVisitor
import org.objectweb.asm.signature.SignatureWriter

open class FunctionCompiler(parentContext: Context, synthetic: Boolean = false, accessRestriction: Int = ACC_PUBLIC): OperationsCompiler(parentContext) {

    init {
        var access = /*ACC_FINAL or */accessRestriction
        if(functionSignature.static)
            access = access or ACC_STATIC
        if(synthetic)
            access = access or ACC_SYNTHETIC
        val methodType = methodType(functionSignature.arguments, functionSignature.returnType)
        val description = methodType.descriptor
        writer = classWriter.visitMethod(access, functionSignature.name, description, generateGenericSignature(functionSignature), emptyArray())
    }

    override fun visitTerminal(node: TerminalNode) {
        super.visitTerminal(node)
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
                    try {
                        actuallyValid = expected >= actual
                        visit(argumentContext)
                        typeStack.pop()
                    } catch (e: Exception) {
                        // shhh
                    }
                    if(!actuallyValid && expected is FunctionType) {
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
            visitMethodInsn(opcode, function.ownerClass.toInternalName(), function.name, descriptor, false)

            // les méthodes ayant 'void' en type de retour n'ajoutent rien sur le stack
            if(function.returnType != JVMVoid)
                typeStack.push(function.returnType)
        }
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
            writer.visitVarInsn(type.correctOpcode(ILOAD), id)
            typeStack.push(type)
        } else {
            val field = parentContext.field(name)
            if (field != null) {
                writer.visitFieldInsn(GETSTATIC, parentContext.currentClass.toInternalName(), name, field.type.toASM().descriptor)
                typeStack.push(field.type)
            }
        }
    }

    private fun createConstantFunction(constantExpr: EuclinParser.ExpressionContext): FunctionSignature {
        constantChecker.assertConstant(constantExpr)

        val returnInstructionWrapper = EuclinParser.ReturnFuncInstructionContext(EuclinParser.FunctionInstructionsContext())
        returnInstructionWrapper.addChild(constantExpr)

        val lambdaExpr = EuclinParser.LambdaFunctionExprContext(EuclinParser.ExpressionContext())
        lambdaExpr.addChild(returnInstructionWrapper)

        val lambda = parentContext.lambdaCompiler.visitLambdaFunctionExpr(lambdaExpr)
        return lambda.apiSignature
    }

    override fun visitLambdaFunctionExpr(ctx: EuclinParser.LambdaFunctionExprContext) {
        val lambdaCompiler = parentContext.lambdaCompiler
        val lambda = lambdaCompiler.visitLambdaFunctionExpr(ctx)
        compileMethodReference(lambda.apiSignature, lambda.usedLocals, lambda.implementationSignature)
    }

    override fun visitReturnFuncInstruction(ctx: EuclinParser.ReturnFuncInstructionContext) {
        visit(ctx.expression()) // compile l'expression
        val inferredType = typeStack.pop()
        try {
            if(inferredType > functionSignature.returnType)
                compileError("La valeur de retour n'est pas compatible avec celui de la signature de la fonction ($inferredType > ${functionSignature.returnType})", functionSignature.ownerClass, ctx)
        } catch (e: IllegalArgumentException) {
            compileError("La valeur de retour n'est pas compatible avec celui de la signature de la fonction ($inferredType != ${functionSignature.returnType})", functionSignature.ownerClass, ctx)
        }
        writer.visitInsn(functionSignature.returnType.correctOpcode(IRETURN))
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
                                    actual.popFromStack()
                                    loadUnitOnStack()
                                    writer.visitInsn(ARETURN)
                                } else {
                                    compileError("Incompatibilité de types lors de l'insertion automatique de 'return' $expected (${expected.hashCode()}) != $actual (${actual.hashCode()}) (${functionSignature.name})", functionSignature.ownerClass, it)
                                }
                            } else { // tout va bien
                                writer.visitInsn(functionSignature.returnType.correctOpcode(IRETURN))
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
                        val type = typeStack.pop()
                        type.popFromStack()
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
                visitLocalVariable(name, type.toASM().descriptor, null, startLabel, endLabel, id)
            }
            visitMaxs(0, 0) // nécessaire pour qu'ASM puisse calculer les stacks et les frames
            visitEnd()
        }
    }

    internal fun compileFuncHeader() {
        with(writer) {
            for (arg in functionSignature.arguments) {
                val (name, type) = arg
                visitParameter(name, Opcodes.ACC_FINAL)
                localVariableIDs[name] = localIndex
                localVariableTypes[name] = type
                localIndex += type.localSize

            }
            visitCode()
            visitLabel(startLabel)
        }
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
        if(isMainFunction) {
            visit(expression)
            val type = typeStack.pop()
            val declaredField = TypedMember(name, type)
            parentContext.fields += declaredField

            writer.visitFieldInsn(PUTSTATIC, parentContext.currentClass.toInternalName(), name, type.toASM().descriptor)
        } else {
            val type = translator.translate(expression).type
            val varID = localIndex
            localIndex += type.localSize
            localVariableIDs[name] = varID
            localVariableTypes[name] = type

            storeValue(expression, type, varID)
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
        writer.visitFieldInsn(PUTFIELD, targetType.toASM().internalName, field.name, value.type.toASM().descriptor)
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
                writer.visitFieldInsn(PUTSTATIC, parentContext.currentClass.toInternalName(), name, field.type.toASM().descriptor)
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
        writer.visitVarInsn(type.correctOpcode(ISTORE), varID) // et on la stocke dans la variable
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
        val code = ctx.functionInstructions()
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

    private fun compileInstructions(code: List<EuclinParser.FunctionInstructionsContext>) {
        for(instruction in code) {
            addLineInfos(instruction)
            visit(instruction) // on compile l'instruction

            // on vide le stack si nécessaire
            if (typeStack.isNotEmpty()) {
                compileAssert(typeStack.size == 1, functionSignature.ownerClass, instruction) { "Il ne doit y avoir qu'une seule valeur sur le stack à la fin d'une instruction!" }
                typeStack.pop().popFromStack()
            }
        }
    }

    override fun visitIfBranchingInstruction(ctx: EuclinParser.IfBranchingInstructionContext) {
        val conditionExpr = ctx.expression()
        val condition = translator.translate(conditionExpr)
        compileAssert(condition.type == BooleanType, functionSignature.ownerClass, ctx) { "La condition doit être un booléen!" }
        val code = ctx.functionInstructions()
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
                compileInstructions(elseBlock.functionInstructions())
            }

            visitLabel(endLabel)
        }
    }

    override fun visitDeclareStructInstruction(ctx: EuclinParser.DeclareStructInstructionContext) {
        // on ignore
    }

    override fun visitNewObjectExpr(ctx: EuclinParser.NewObjectExprContext) {
        val type = parentContext.typeConverter.convertBasic(ctx.Identifier().text)
        val internalName = type.toASM().internalName
        val args = ctx.expression().map { translator.translate(it).type }
        val cons = type.constructor(args) ?: compileError("Aucun constructeur correspondant à $args dans $type", parentContext.currentClass, ctx)
        writer.visitTypeInsn(NEW, internalName)
        writer.visitInsn(DUP)

        ctx.expression().forEach(this::visit)
        writer.visitMethodInsn(INVOKESPECIAL, internalName, "<init>", methodType(cons.arguments, JVMVoid).descriptor, false)
        typeStack.push(type)
    }

    override fun visitImportInstruction(ctx: EuclinParser.ImportInstructionContext?) {
        // on ignore
    }

    /**
     * Le compileur s'en fiche du retypage, c'est à TypeInferer de gérer
     */
    override fun visitLoadAndRetypeExpr(ctx: EuclinParser.LoadAndRetypeExprContext) {
        visit(ctx.expression())
    }

    override fun visitArrayStoreInstruction(ctx: EuclinParser.ArrayStoreInstructionContext) {
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
            compileAssert(arrayType.isIntType(maxBitSize = 32), parentContext.currentClass, ctx) { "L'indice doit être un entier!" }
        }
        val elementType = (arrayType as ArrayType).elementType
        visit(ctx.expression(2))
        val valueType = typeStack.pop()
        compileAssert(elementType >= valueType, parentContext.currentClass, ctx) { "La valeur ($valueType) donnée ne rentre pas dans le tableau d'éléments du type $elementType" }
        writer.visitInsn(elementType.correctOpcode(IASTORE))
    }

    companion object {
        fun convertNativeTypeToBoxed(writer: MethodVisitor, type: NativeType) {
            val boxedType = "java/lang/" + boxedName(type)
            writer.visitMethodInsn(INVOKESTATIC, boxedType, "valueOf", "(${type.getDescriptor()})L$boxedType;", false)
        }

        fun convertBoxedObjectToNativeType(writer: MethodVisitor, type: NativeType) {
            val boxedType = "java/lang/" + boxedName(type)
            writer.visitTypeInsn(CHECKCAST, boxedType) // conversion en type Boxed
            val smallName = smallName(type)
            writer.visitMethodInsn(INVOKEVIRTUAL, boxedType, "${smallName}Value", "()${type.getDescriptor()}", false)
        }

        private fun boxedName(type: NativeType): String {
            return when(type) {
                Int32Type -> "Integer"
                Real32Type -> "Float"
                Real64Type -> "Double"
                CharType -> "Character"
                Int16Type -> "Short"
                Int64Type -> "Long"
                BooleanType -> "Boolean"
                Int8Type -> "Byte"
                JVMVoid -> "Void"
                else -> throw IllegalArgumentException(type.toString())
            }
        }

        private fun smallName(type: NativeType): String {
            return when(type) {
                CharType -> "char"
                Int32Type -> "int"
                else -> boxedName(type).toLowerCase()
            }
        }

        fun generateGenericSignature(functionSignature: FunctionSignature): String {
            with(SignatureWriter()) {
                for((_, type) in functionSignature.arguments) {
                    val param = visitParameterType()
                    signatureVisitType(type, param)
                }

                signatureVisitType(functionSignature.returnType, visitReturnType())
                val result = toString()
                return result
            }
        }

        private fun signatureVisitType(type: TypeDefinition, visitor: SignatureVisitor, isTypeArgument: Boolean = false) {
            if (type is NativeType) {
                if(isTypeArgument) {
                    val boxedName = FunctionCompiler.boxedName(type)
                    visitor.visitClassType("java/lang/"+boxedName.replace(".", "/"))
                    visitor.visitEnd()
                } else {
                    visitor.visitBaseType(type.backing.descriptor[0])
                }
            } else {
                if(type is FunctionType) {
                    val javaName = javaTypeName(type)
                    visitor.visitClassType(javaName.replace(".", "/"))
                    val typeArgument = visitor.visitTypeArgument('=')
                    when {
                        javaName.endsWith("Function") || javaName.endsWith("Consumer") || javaName.endsWith("Predicate") -> {
                            if(javaName.contains("Bi")) {
                                val argTuple = type.argumentType as TupleType
                                signatureVisitType(argTuple.elementTypes[0], typeArgument, isTypeArgument = true)
                                signatureVisitType(argTuple.elementTypes[1], typeArgument, isTypeArgument = true)
                            } else {
                                signatureVisitType(type.argumentType, typeArgument, isTypeArgument = true)
                            }
                        }
                    }
                    if( ! javaName.endsWith("Predicate") && ! javaName.endsWith("Consumer")) {
                        signatureVisitType(type.returnType, typeArgument, isTypeArgument = true)
                    }
                    typeArgument.visitEnd()
                } else if (type is ArrayType) {
                    visitor.visitArrayType()
                    visitor.visitClassType(type.elementType.toASM().internalName)
                    visitor.visitEnd()
                } else {
                    visitor.visitClassType(type.toASM().internalName)
                    visitor.visitEnd()
                }
            }
        }
    }
}