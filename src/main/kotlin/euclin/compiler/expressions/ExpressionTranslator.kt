package euclin.compiler.expressions

import euclin.compiler.*
import org.jglr.inference.TypeInferer
import org.jglr.inference.expressions.*
import org.jglr.inference.expressions.Function
import euclin.compiler.functions.FunctionSignature
import euclin.compiler.functions.FunctionMatcher
import euclin.compiler.grammar.EuclinBaseVisitor
import euclin.compiler.grammar.EuclinParser
import euclin.compiler.types.*
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.tree.TerminalNode
import org.jglr.inference.ImpossibleUnificationExpression

open class ExpressionTranslator(val parentContext: Context) : EuclinBaseVisitor<Expression>() {

    var lambdaVar = Variable("_")
    private val availableFunctions = parentContext.availableFunctions
    private val variableTypes = parentContext.localVariableTypes
    private val True = Literal(true, BooleanType)
    private val False = Literal(false, BooleanType)
    private val UnitValue = Literal(Unit, UnitType)
    internal val inferer = TypeInferer()
    private val EmptyArray = { OpaqueExpression("[]") of ArrayType(WildcardType) }
    private val alreadyTranslated = hashMapOf<ParserRuleContext, Expression>()
    private val funcMatcher: FunctionMatcher
        get() = parentContext.functionMatcher

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

    override fun visit(tree: ParseTree): Expression {
        if(tree is EuclinParser.ExpressionContext)
            return translate(tree)
        return super.visit(tree)
    }

    fun translateLambdaExpression(functionExpression: MutableList<EuclinParser.FunctionInstructionsContext>): Function {
        val previousVar = lambdaVar
        lambdaVar = Variable("_")
        val block = parentContext.blockTranslator.translate(functionExpression)
        val resultArg = if(block.arguments.size == 1) {
            OpaqueExpression(block.arguments[0].name) of block.arguments[0].type
        } else {
            Tuple(*block.arguments.map { OpaqueExpression(it.name) of it.type }.toTypedArray())
        }
        val result = Function("lambda_${System.currentTimeMillis()}", resultArg, block)
        lambdaVar = previousVar
        inferer.infer(result)
        return result
    }

    fun translate(ctx: EuclinParser.ExpressionContext): Expression {
        if(alreadyTranslated.containsKey(ctx)) // on évite de recalculer les résultats
            return alreadyTranslated[ctx]!!
        val result = super.visit(ctx)
        inferer.infer(result)
        return result
    }

    override fun visitAccessExpr(ctx: EuclinParser.AccessExprContext): Expression {
        val chain = ctx.Identifier()
        if(ctx.expression() is EuclinParser.VarExprContext) {
            val varContext = ctx.expression() as EuclinParser.VarExprContext
            val name = varContext.Identifier().text
            if(parentContext.knowsType(name)) {
                val type = parentContext.type(name)
                return subAccessExpr(OpaqueExpression("static instance") of type, chain, ctx)
            }
        }
        val first = translate(ctx.expression())
        return subAccessExpr(first, chain, ctx)
    }

    internal fun subAccessExpr(first: Expression, chain: MutableList<TerminalNode>, parentContext: ParserRuleContext): Expression {
        var deepest = first
        for(id in chain) { // on regarde les identifiants qui sont nécessairement des membres
            val name = id.text
            val fields = deepest.type.listFields() + deepest.type.listStaticFields()
            val parent = deepest
            val field = fields.find { it.name == name }
            deepest = AccessExpression(parent, field?.name
                    ?: compileError("Aucun membre du nom de $name dans ${deepest.type}", this.parentContext.currentClass, parentContext))
            deepest of field.type
        }
        return deepest
    }

    override fun visitLambdaVarExpr(ctx: EuclinParser.LambdaVarExprContext): Expression {
        return lambdaVar
    }

    override fun visitCallExpr(ctx: EuclinParser.CallExprContext): Expression {
        val call = ctx.functionCall()
        val arguments = call.expression().map { visit(it) }
        val signature = funcMatcher.visit(call.functionIdentifier())
        val f = function(signature)
        if(arguments.size == 1)
            return f(arguments[0])
        return f(Tuple(*arguments.toTypedArray()))
    }

    override fun visitFloatExpr(ctx: EuclinParser.FloatExprContext): Expression {
        return Literal(ctx.FloatNumber().text.toDouble(), Real64Type)
    }

    override fun visitLambdaFunctionExpr(ctx: EuclinParser.LambdaFunctionExprContext): Expression {
        return translateLambdaExpression(ctx.functionInstructions())
    }

    override fun visitVarExpr(ctx: EuclinParser.VarExprContext): Expression {
        val name = ctx.Identifier().text
        return visitName(name, ctx)
    }

    private fun visitName(name: String, ctx: ParserRuleContext): Expression {
        if(variableTypes.containsKey(name)) // est-ce une variable locale ?
            return Variable(name) of (variableTypes[name] ?: compileError("Pas de variable trouvée avec le nom $name", parentContext.currentClass, ctx))
        else if(availableFunctions.containsKey(name)) // est-ce une fonction ?
            return function(availableFunctions[name] ?: compileError("Pas de variable trouvée avec le nom $name", parentContext.currentClass, ctx))
        else {
            val field = parentContext.field(name)
            if(field != null) {
                return Variable(name) of field.type
            } else {
                compileError("Unknown variable $name", parentContext.currentClass, ctx) // non c'est un symbole inconnu!
            }
        }
    }

    override fun visitIntExpr(ctx: EuclinParser.IntExprContext): Expression {
        return Literal(ctx.Integer().text.toLong(), Int64Type)
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

    internal fun function(signature: FunctionSignature): Function {
        // on ne convertit pas à un tuple si on a qu'un seul argument!
        if(signature.arguments.size == 1) {
            val arg = signature.arguments[0]
            return Function(signature.name, Variable(arg.name) of arg.type, OpaqueExpression("${signature.name}(*)") of signature.returnType)
        }
        val arguments = signature.arguments.map { Variable(it.name) of it.type }
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

    override fun visitNewObjectExpr(ctx: EuclinParser.NewObjectExprContext): Expression {
        val type = parentContext.typeConverter.convertBasic(ctx.Identifier().text)
        val args = ctx.expression().map { visit(it) }
        val constructor = type.constructor(args.map(Expression::type))
        if(constructor != null) {
            return OpaqueExpression("new $type($constructor)") of type
        }
        compileError("Aucun constructeur correspondant à $args dans $type", parentContext.currentClass, ctx)
    }

    override fun visitCastExpr(ctx: EuclinParser.CastExprContext): Expression {
        return CastExpression(visit(ctx.expression()), parentContext.typeConverter.visit(ctx.type()))
    }

    /**
     * Retypes the expression, only useful for lambdas right now
     */
    override fun visitLoadAndRetypeExpr(ctx: EuclinParser.LoadAndRetypeExprContext): Expression {
        val type = parentContext.typeConverter.visit(ctx.type())
        return visit(ctx.expression()) of type
    }

    override fun visitArrayExpr(ctx: EuclinParser.ArrayExprContext): Expression {
        if(ctx.expression().isEmpty()) {
            if (ctx.parent != null && ctx.parent is EuclinParser.LoadAndRetypeExprContext) { // permet de créer des tableaux vides avec un type choisi
                val parent = ctx.parent as EuclinParser.LoadAndRetypeExprContext
                val type = parentContext.typeConverter.visit(parent.type())
                return EmptyArray() of type
            } else {
                return EmptyArray()
            }
        }
        val elements = ctx.expression()
                .map(this::translate)
                .map(Expression::type)
                .toTypedArray()
        val arrayType = ArrayType(elements.max()!!) // <- On prend le type qui peut contenir tous les autres
        return OpaqueExpression(ctx.text) of arrayType
    }

    override fun visitAccessArrayExpr(ctx: EuclinParser.AccessArrayExprContext): Expression {
        val array = translate(ctx.expression(0))
        val index = translate(ctx.expression(1))
        compileAssert(array.type is ArrayType, parentContext.currentClass, ctx) { "L'expression doit être un tableau!" }
        compileAssert(index.type.isIntType(), parentContext.currentClass, ctx) { "L'indice doit être un entier!" }
        return AccessExpression(array, index.toString()) of (array.type as ArrayType).elementType
    }

    override fun visitNewArrayExpr(ctx: EuclinParser.NewArrayExprContext): Expression {
        val arrayType = parentContext.typeConverter.visit(ctx.type()) // on converti le noeud 'type' en TypeDefinition
        return OpaqueExpression(ctx.expression().text) of ArrayType(arrayType) // on renvoie un tableau du bon type
    }

    override fun visitCharExpr(ctx: EuclinParser.CharExprContext): Expression {
        return OpaqueExpression(ctx.text) of CharType
    }
}
