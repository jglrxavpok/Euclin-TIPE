package org.jglrxavpok.euclin.types

import org.jglr.inference.TypeInferer
import org.jglr.inference.expressions.*
import org.jglr.inference.expressions.Function
import org.jglr.inference.types.TypeDefinition
import org.jglrxavpok.euclin.FunctionSignature
import org.jglrxavpok.euclin.grammar.EuclinBaseVisitor
import org.jglrxavpok.euclin.grammar.EuclinParser

class ExpressionTranslator(val availableFunctions: Map<String, FunctionSignature>) : EuclinBaseVisitor<Expression>() {

    private var lambdaVar = Variable("_") of RealType
    private val True = Literal(true, BooleanType)
    private val False = Literal(false, BooleanType)
    private val inferer = TypeInferer()
    val variableTypes = hashMapOf<String, TypeDefinition>()

    fun translateLambdaExpression(functionExpression: EuclinParser.ExpressionContext): Function {
        val previousVar = lambdaVar
        lambdaVar = Variable("_") of RealType
        val result = Function("lambda_${System.currentTimeMillis()}", lambdaVar, translate(functionExpression))
        lambdaVar = previousVar
        inferer.infer(result)
        return result
    }

    fun translate(ctx: EuclinParser.ExpressionContext): Expression {
        val result = visit(ctx)
        inferer.infer(result)
        return result
    }

    override fun visitLambdaVarExpr(ctx: EuclinParser.LambdaVarExprContext?): Expression {
        return lambdaVar
    }

    override fun visitCallExpr(ctx: EuclinParser.CallExprContext): Expression {
        val call = ctx.functionCall()
        val arguments = call.expression().map { visit(it) }
        val funcName = call.Identifier().text
        val signature = availableFunctions[funcName]!!
        val f = function(signature)
        if(arguments.size == 1)
            return f(arguments[0])
        return f(Tuple(*arguments.toTypedArray()))
    }

    override fun visitFloatExpr(ctx: EuclinParser.FloatExprContext): Expression {
        return Literal(ctx.FloatNumber().text.toFloat(), RealType)
    }

    override fun visitLambdaFunctionExpr(ctx: EuclinParser.LambdaFunctionExprContext): Expression {
        return translateLambdaExpression(ctx.expression())
    }

    override fun visitVarExpr(ctx: EuclinParser.VarExprContext): Expression {
        val name = ctx.Identifier().text
        if(variableTypes.containsKey(name)) // est-ce une variable locale ?
            return Variable(name) of variableTypes[name]!!
        else if(availableFunctions.containsKey(name)) // est-ce une fonction ?
            return function(availableFunctions[name]!!)
        else
            error("Unknown variable $name") // non c'est un symbole inconnu!
    }

    override fun visitIntExpr(ctx: EuclinParser.IntExprContext): Expression {
        return Literal(ctx.Integer().text.toInt(), IntType)
    }

    override fun visitCoupleExpr(ctx: EuclinParser.CoupleExprContext): Expression {
        return Tuple(visit(ctx.couple().expression(0)), visit(ctx.couple().expression(1)))
    }

    override fun visitBoolTrueExpr(ctx: EuclinParser.BoolTrueExprContext): Expression {
        return True
    }

    override fun visitBoolFalseExpr(ctx: EuclinParser.BoolFalseExprContext?): Expression {
        return False
    }

    override fun visitDivExpr(ctx: EuclinParser.DivExprContext): Expression {
        return visit(ctx.expression(0)) / visit(ctx.expression(1)) // Gauche + droite
    }

    override fun visitMultExpr(ctx: EuclinParser.MultExprContext): Expression {
        return visit(ctx.expression(0)) * visit(ctx.expression(1)) // Gauche + droite
    }

    override fun visitSubExpr(ctx: EuclinParser.SubExprContext): Expression {
        return visit(ctx.expression(0)) - visit(ctx.expression(1)) // Gauche + droite
    }

    override fun visitAddExpr(ctx: EuclinParser.AddExprContext): Expression {
        return visit(ctx.expression(0)) + visit(ctx.expression(1)) // Gauche + droite
    }

    private fun function(signature: FunctionSignature): Function {
        // on ne convertit pas à un tuple si on a qu'un seul argument!
        if(signature.arguments.size == 1) {
            val arg = signature.arguments[0]
            return Function(signature.name, Variable(arg.first) of arg.second, OpaqueExpression("${signature.name}(*)") of signature.returnType)
        }
        val arguments = signature.arguments.map { Variable(it.first) of it.second }
        return Function(signature.name, Tuple(*arguments.toTypedArray()), OpaqueExpression("${signature.name}(*)") of signature.returnType)
    }
}