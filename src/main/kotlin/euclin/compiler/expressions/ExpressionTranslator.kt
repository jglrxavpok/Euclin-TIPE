package euclin.compiler.expressions

import org.jglr.inference.TypeInferer
import org.jglr.inference.expressions.*
import org.jglr.inference.expressions.Function
import org.jglr.inference.types.TypeDefinition
import euclin.compiler.FunctionSignature
import euclin.compiler.compileError
import euclin.compiler.grammar.EuclinBaseVisitor
import euclin.compiler.grammar.EuclinParser
import euclin.compiler.types.*
import org.antlr.v4.runtime.ParserRuleContext
import org.jglr.inference.ImpossibleUnificationExpression

class ExpressionTranslator(val availableFunctions: Map<String, FunctionSignature>) : EuclinBaseVisitor<Expression>() {

    private var lambdaVar = Variable("_") of RealType
    private val True = Literal(true, BooleanType)
    private val False = Literal(false, BooleanType)
    private val UnitValue = Literal(Unit, UnitType)
    private val inferer = TypeInferer()
    private val alreadyTranslated = hashMapOf<ParserRuleContext, Expression>()
    val variableTypes = hashMapOf<String, TypeDefinition>()

    init {
        with(inferer) {
            // Ceci rajoute un nouveau type d'expression à l'inféreur de types: les comparaisons entre deux valeurs (<, <=, >, >=, ==, !=)
            defineProcessingOf<ComparisonExpression> {
                infer(it.left)
                infer(it.right)
                if(it.left.type != it.right.type) { // on vérifie que les deux membres sont bien du même type
                    throw ImpossibleUnificationExpression("Les comparaisons doivent être faites avec des termes de même type! (${it.left.type} != ${it.right.type})")
                }
            }
        }
    }

    fun translateLambdaExpression(functionExpression: EuclinParser.ExpressionContext): Function {
        val previousVar = lambdaVar
        lambdaVar = Variable("_") of RealType
        val result = Function("lambda_${System.currentTimeMillis()}", lambdaVar, translate(functionExpression))
        lambdaVar = previousVar
        inferer.infer(result)
        return result
    }

    fun translate(ctx: EuclinParser.ExpressionContext): Expression {
        if(alreadyTranslated.containsKey(ctx)) // on évite de recalculer les résultats
            return alreadyTranslated[ctx]!!
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
        val signature = availableFunctions[funcName] ?: compileError("Pas de fonction trouvée pour le nom $funcName", "?", ctx)
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
            return Variable(name) of (variableTypes[name] ?: compileError("Pas de variable trouvée avec le nom $name", "?", ctx))
        else if(availableFunctions.containsKey(name)) // est-ce une fonction ?
            return function(availableFunctions[name] ?: compileError("Pas de variable trouvée avec le nom $name", "?", ctx))
        else
            compileError("Unknown variable $name", "?", ctx) // non c'est un symbole inconnu!
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

    override fun visitStringExpr(ctx: EuclinParser.StringExprContext): Expression {
        return Literal(ctx.StringConstant().text, StringType)
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

    override fun visitWrappedExpr(ctx: EuclinParser.WrappedExprContext): Expression {
        return visit(ctx.expression())
    }

    override fun visitUnitExpr(ctx: EuclinParser.UnitExprContext?): Expression {
        return UnitValue
    }

    // Opérateurs de comparaison
    override fun visitLessEqualExpr(ctx: EuclinParser.LessEqualExprContext): Expression {
        val left = visit(ctx.expression(0))
        val right = visit(ctx.expression(1))
        return LessEqualThan(left, right)
    }

    override fun visitLessExpr(ctx: EuclinParser.LessExprContext): Expression {
        val left = visit(ctx.expression(0))
        val right = visit(ctx.expression(1))
        return LessThan(left, right)
    }

    override fun visitEquality(ctx: EuclinParser.EqualityContext): Expression {
        val left = visit(ctx.expression(0))
        val right = visit(ctx.expression(1))
        return EqualTo(left, right)
    }

    override fun visitInequality(ctx: EuclinParser.InequalityContext): Expression {
        val left = visit(ctx.expression(0))
        val right = visit(ctx.expression(1))
        return DifferentFrom(left, right)
    }

    override fun visitGreaterExpr(ctx: EuclinParser.GreaterExprContext): Expression {
        val left = visit(ctx.expression(0))
        val right = visit(ctx.expression(1))
        return GreaterThan(left, right)
    }

    override fun visitGreaterEqualExpr(ctx: EuclinParser.GreaterEqualExprContext): Expression {
        val left = visit(ctx.expression(0))
        val right = visit(ctx.expression(1))
        return GreaterEqualThan(left, right)
    }
    // Fin des opérateurs de comparaison
}