package euclin.compiler.functions

import euclin.compiler.Context
import euclin.compiler.compileAssert
import euclin.compiler.compileError
import euclin.compiler.grammar.EuclinParser
import euclin.compiler.types.*
import org.objectweb.asm.Label
import org.objectweb.asm.Opcodes

abstract class OperationsCompiler(parentContext: Context): ExpressionCompiler(parentContext) {

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
                visitTypeInsn(Opcodes.NEW, stringBuilderInternalName)

                visitInsn(Opcodes.DUP) // on duplique deux fois le builder: pour <init>, pour 'append' et pour 'toString()'
                visitInsn(Opcodes.DUP)

                // compilation du membre gauche et appel de constructeur
                visit(left)
                visitMethodInsn(Opcodes.INVOKESPECIAL, stringBuilderInternalName, "<init>", "(Ljava/lang/String;)V", false)

                // compilation membre droite + appel à 'append'
                visit(right)
                visitMethodInsn(Opcodes.INVOKEVIRTUAL, stringBuilderInternalName, "append", "(Ljava/lang/String;)L$stringBuilderInternalName;", false) // le builder se renvoit lui-même

                // renvoi du résultat
                visitMethodInsn(Opcodes.INVOKESPECIAL, stringBuilderInternalName, "toString", "()Ljava/lang/String;", false)
            }

            // on retire les termes du stack
            typeStack.pop()
            typeStack.pop()
            typeStack.push(StringType)
        } else {
            compileOperation(left, right, Opcodes.IADD, "plus")
        }
    }

    override fun visitSubExpr(ctx: EuclinParser.SubExprContext) {
        val left = ctx.expression(0)
        val right = ctx.expression(1)
        compileOperation(left, right, Opcodes.ISUB, "minus")
    }

    override fun visitMultExpr(ctx: EuclinParser.MultExprContext) {
        val left = ctx.expression(0)
        val right = ctx.expression(1)
        compileOperation(left, right, Opcodes.IMUL, "times")
    }

    override fun visitDivExpr(ctx: EuclinParser.DivExprContext) {
        val left = ctx.expression(0)
        val right = ctx.expression(1)
        compileOperation(left, right, Opcodes.IDIV, "div")
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
        val memberType = leftExpr.type
        when(memberType) {
            Real32Type, Int32Type, Real64Type, Int64Type, BooleanType, CharType, Int16Type, Int8Type -> writer.visitInsn(memberType.correctOpcode(opcode))

        // cet appel de fonction fonctionne car l'instance de l'objet sur laquelle on agit est considérée comme 'left'
        /*Real32PointType -> writer.visitMethodInsn(INVOKEVIRTUAL, "euclin/std/points/Real64Point", functionName, "(Leuclin/std/points/Real64Point;)Leuclin/std/points/Real64Point;", false)
        Int32PointType -> writer.visitMethodInsn(INVOKEVIRTUAL, "euclin/std/points/Int64Point", functionName, "(Leuclin/std/points/Int64Point;)Leuclin/std/points/Int64Point;", false)*/
            else -> {
                val potentialMethods = memberType.listMethods().filter { it.name == functionName }
                        .filter { it.arguments.size == 1 && it.arguments[0].type == memberType }
                if(potentialMethods.size != 1)
                    compileError("Impossible d'ajouter deux valeurs du type $memberType ${potentialMethods.size}", functionSignature.ownerClass, left)
                writer.visitMethodInsn(Opcodes.INVOKEVIRTUAL, memberType.toASM().internalName, functionName, methodType(potentialMethods[0]).descriptor, false)
            }
        }

        // on retire les termes
        typeStack.pop()
        typeStack.pop()
        // on ajoute le type du résultat (on pourrait juste retirer un élément, mais cela ne serait pas clair et on laisse ainsi la possibilité de casts implicites)
        typeStack.push(leftExpr.type)
    }

    // Opérateurs de comparaison
    private fun compare(left: EuclinParser.ExpressionContext, right: EuclinParser.ExpressionContext, jumpOpcode: Int) {
        val valueType = translator.translate(left).type

        val comparisonMethod = valueType.listMethods().find { it.name == "compareTo" && it.arguments.size == 1 && it.arguments[0].type == WildcardType && it.returnType == Int32Type }
        compileAssert(comparisonMethod != null || valueType in listOf(Int16Type, Int8Type, Int32Type, Int64Type, Real32Type, Real64Type, StringType), functionSignature.ownerClass, left) // TODO: Supporter long/double etc.
        { "On ne peut comparer que les types ayant une méthode compareTo ou les types Int et Real! (C'était $valueType)" }

        val trueLabel = Label()
        val endLabel = Label()
        with(writer) {
            visit(left)
            visit(right)
            typeStack.pop()
            typeStack.pop()

            // /!\ Astuce: la comparaison va nous donner un nombre que l'on va ensuite comparer à 0
            if(valueType != Int32Type && valueType != Int16Type && valueType != Int8Type) {
                if(valueType == Real32Type) { // c'est un float
                    visitInsn(Opcodes.FCMPL) // on compare
                    visitIntInsn(Opcodes.BIPUSH, 0)
                    visitInsn(Opcodes.SWAP)
                } else if(valueType == Real64Type) { // c'est un double
                    visitInsn(Opcodes.DCMPL) // on compare
                    visitIntInsn(Opcodes.BIPUSH, 0)
                    visitInsn(Opcodes.SWAP)
                } else if(valueType == Int64Type) { // c'est un long
                    visitInsn(Opcodes.LCMP) // on compare
                    visitIntInsn(Opcodes.BIPUSH, 0)
                    visitInsn(Opcodes.SWAP)
                } else if(valueType == StringType) {
                    visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/lang/String", "compareTo", "(Ljava/lang/Object;)I", true)
                    visitIntInsn(Opcodes.BIPUSH, 0)
                } else {
                    // TODO ça peut planter si elle provient d'une interface
                    visitMethodInsn(Opcodes.INVOKEVIRTUAL, valueType.toASM().internalName, "compareTo", "(Ljava/lang/Object;)I", true)
                    visitIntInsn(Opcodes.BIPUSH, 0)
                }
            }

            visitJumpInsn(jumpOpcode, trueLabel) // c'est une valeur > donc on charge 'true'
            loadBooleanRaw(false)
            visitJumpInsn(Opcodes.GOTO, endLabel)

            visitLabel(trueLabel)
            loadBooleanRaw(true)

            visitLabel(endLabel)
        }

        typeStack.push(BooleanType)
    }

    override fun visitGreaterExpr(ctx: EuclinParser.GreaterExprContext) {
        val left = ctx.expression(0)
        val right = ctx.expression(1)

        compare(left, right, Opcodes.IF_ICMPGT)
    }

    override fun visitGreaterEqualExpr(ctx: EuclinParser.GreaterEqualExprContext) {
        val left = ctx.expression(0)
        val right = ctx.expression(1)

        compare(left, right, Opcodes.IF_ICMPGE)
    }

    override fun visitLessExpr(ctx: EuclinParser.LessExprContext) {
        val left = ctx.expression(0)
        val right = ctx.expression(1)

        compare(left, right, Opcodes.IF_ICMPLT)
    }

    override fun visitLessEqualExpr(ctx: EuclinParser.LessEqualExprContext) {
        val left = ctx.expression(0)
        val right = ctx.expression(1)

        compare(left, right, Opcodes.IF_ICMPLE)
    }

    override fun visitEquality(ctx: EuclinParser.EqualityContext) {
        val left = ctx.expression(0)
        val right = ctx.expression(1)

        val leftType = translator.translate(left).type
        val rightType = translator.translate(right).type
        if(leftType is ObjectType && rightType is ObjectType) {
            compareObjects(leftType, left, right, negate=false)
        } else {
            compare(left, right, Opcodes.IF_ICMPEQ)
        }
    }

    override fun visitInequality(ctx: EuclinParser.InequalityContext) {
        val left = ctx.expression(0)
        val right = ctx.expression(1)

        val leftType = translator.translate(left).type
        val rightType = translator.translate(right).type
        if(leftType is ObjectType && rightType is ObjectType) {
            compareObjects(leftType, left, right, negate=true)
        } else {
            compare(left, right, Opcodes.IF_ICMPNE)
        }
    }

    private fun compareObjects(objectType: ObjectType, left: EuclinParser.ExpressionContext, right: EuclinParser.ExpressionContext, negate: Boolean) {
        with(writer) {
            visit(left)
            visit(right)
            typeStack.pop()
            typeStack.pop()

            // on utilise la méthode de comparaison de la classe String
            visitMethodInsn(Opcodes.INVOKEINTERFACE, objectType.toASM().internalName, "equals", "(Ljava/lang/Object;)Z", true)
            if(negate)
                negateBoolean()
        }

        typeStack.push(BooleanType)
    }

    // Fin des opérateurs de comparaison
}