package euclin.compiler

import euclin.compiler.grammar.EuclinBaseVisitor
import euclin.compiler.grammar.EuclinParser

/**
 * Vérifies si une expression donnée est constante (ie tous les appels de fonctions sont faits vers des fonctions *pures* et les arguments sont constants)
 *
 * -> Parcours en profondeur de l'arbre de parsing
 */
class ConstantChecker(val parentContext: Context): EuclinBaseVisitor<Boolean>() {

    private val funcMatcher = parentContext.functionMatcher

    fun assertConstant(constantExpr: EuclinParser.ExpressionContext) {
        compileAssert(visit(constantExpr), parentContext.currentClass, constantExpr) { "L'expression '${constantExpr.text}' n'est pas une constante" }
    }

    override fun visitBoolTrueExpr(ctx: EuclinParser.BoolTrueExprContext?): Boolean {
        return true
    }

    override fun visitBoolFalseExpr(ctx: EuclinParser.BoolFalseExprContext?): Boolean {
        return true
    }

    override fun visitFunctionCall(call: EuclinParser.FunctionCallContext): Boolean {
        val signature = funcMatcher.visit(call.functionIdentifier())
        return signature.pure && call.expression().all { visit(it) }
    }

    override fun visitCoupleExpr(ctx: EuclinParser.CoupleExprContext): Boolean {
        return visit(ctx.couple())
    }

    override fun visitCouple(ctx: EuclinParser.CoupleContext): Boolean {
        return visit(ctx.expression(0)) && visit(ctx.expression(1))
    }

    override fun visitLambdaVarExpr(ctx: EuclinParser.LambdaVarExprContext?): Boolean {
        return false
    }

    override fun visitFloatExpr(ctx: EuclinParser.FloatExprContext?): Boolean {
        return true
    }

    override fun visitIntExpr(ctx: EuclinParser.IntExprContext?): Boolean {
        return true
    }

    override fun visitStringExpr(ctx: EuclinParser.StringExprContext?): Boolean {
        return true
    }

    override fun visitSubExpr(ctx: EuclinParser.SubExprContext): Boolean {
        return visit(ctx.expression(0)) && visit(ctx.expression(1))
    }

    override fun visitGreaterExpr(ctx: EuclinParser.GreaterExprContext): Boolean {
        return visit(ctx.expression(0)) && visit(ctx.expression(1))
    }

    override fun visitGreaterEqualExpr(ctx: EuclinParser.GreaterEqualExprContext): Boolean {
        return visit(ctx.expression(0)) && visit(ctx.expression(1))
    }

    override fun visitAddExpr(ctx: EuclinParser.AddExprContext): Boolean {
        return visit(ctx.expression(0)) && visit(ctx.expression(1))
    }

    override fun visitWrappedExpr(ctx: EuclinParser.WrappedExprContext): Boolean {
        return visit(ctx.expression())
    }

    override fun visitLessExpr(ctx: EuclinParser.LessExprContext): Boolean {
        return visit(ctx.expression(0)) && visit(ctx.expression(1))
    }

    override fun visitLessEqualExpr(ctx: EuclinParser.LessEqualExprContext): Boolean {
        return visit(ctx.expression(0)) && visit(ctx.expression(1))
    }

    override fun visitDivExpr(ctx: EuclinParser.DivExprContext): Boolean {
        return visit(ctx.expression(0)) && visit(ctx.expression(1))
    }

    override fun visitUnitExpr(ctx: EuclinParser.UnitExprContext): Boolean {
        return true
    }

    override fun visitEquality(ctx: EuclinParser.EqualityContext): Boolean {
        return visit(ctx.expression(0)) && visit(ctx.expression(1))
    }

    override fun visitInequality(ctx: EuclinParser.InequalityContext): Boolean {
        return visit(ctx.expression(0)) && visit(ctx.expression(1))
    }

    override fun aggregateResult(aggregate: Boolean, nextResult: Boolean): Boolean {
        return aggregate && nextResult // On vérifie que *tous* les éléments sont purs
    }

    override fun defaultResult(): Boolean {
        return false
    }
}