package org.jglrxavpok.euclin.types

import org.jglr.inference.TypeInferer
import org.jglr.inference.expressions.Variable
import org.jglr.inference.types.TupleType
import org.jglr.inference.types.TypeDefinition
import org.jglrxavpok.euclin.FunctionSignature
import org.jglrxavpok.euclin.grammar.EuclinBaseVisitor
import org.jglrxavpok.euclin.grammar.EuclinParser

class EuclinTypeInferer(val availableFunctions: Map<String, FunctionSignature>) : EuclinBaseVisitor<TypeDefinition>() {

    val localTypes = mutableMapOf<String, TypeDefinition>()
    val inferer = TypeInferer()

    fun inferExpression(expressionContext: EuclinParser.ExpressionContext): TypeDefinition {
        return expressionContext.accept(this)
    }

    // TODO

    override fun visitLambdaFunctionExpr(ctx: EuclinParser.LambdaFunctionExprContext): TypeDefinition {
        val argument = Variable("_")
        return super.visitLambdaFunctionExpr(ctx)
    }

    override fun visitCoupleExpr(ctx: EuclinParser.CoupleExprContext): TypeDefinition {
        return TupleType(arrayOf(visit(ctx.couple().expression(0)), visit(ctx.couple().expression(1)))) // on crée un type couple avec les membres du couple
    }

    override fun visitCallExpr(ctx: EuclinParser.CallExprContext): TypeDefinition {
        val call = ctx.functionCall()
        val name = call.Identifier().text
        val function = availableFunctions[name] ?: error("Aucune fonction correspondant au nom $name")
        return function.returnType
    }

    override fun visitVarExpr(ctx: EuclinParser.VarExprContext): TypeDefinition {
        return localTypes[ctx.Identifier().text]!!
    }

    override fun visitLambdaVarExpr(ctx: EuclinParser.LambdaVarExprContext): TypeDefinition {
        return RealType
    }

    override fun visitIntExpr(ctx: EuclinParser.IntExprContext): TypeDefinition {
        return IntType
    }

    override fun visitFloatExpr(ctx: EuclinParser.FloatExprContext): TypeDefinition {
        return RealType
    }

    override fun visitUnitExpr(ctx: EuclinParser.UnitExprContext?): TypeDefinition {
        return UnitType
    }
}