package euclin.compiler.expressions

import euclin.compiler.*
import euclin.compiler.functions.FunctionSignature
import euclin.compiler.grammar.EuclinBaseVisitor
import euclin.compiler.grammar.EuclinParser
import euclin.compiler.grammar.EuclinVisitor
import euclin.compiler.types.*
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.ParseTree
import org.jglr.inference.expressions.Expression
import org.jglr.inference.expressions.Tuple
import org.jglr.inference.expressions.Variable
import org.jglr.inference.types.FunctionType
import org.jglr.inference.types.TupleType
import org.jglr.inference.types.TypeDefinition
import org.objectweb.asm.Opcodes

class BlockTranslator(val context: Context): ExpressionTranslator(context) {

    private lateinit var lambdaParameter: () -> TypedMember
    private var lambdaArgument = UnitType
    private var finalReturnType: TypeDefinition? = null
    private val lambdaLocalVars = hashMapOf<String, TypeDefinition>()
    private val usedLocals = hashMapOf<String, TypeDefinition>()
    private val currentArguments = mutableListOf<() -> TypedMember>()

    /**
     * Renvoit un couple composé de l'argument du bloc et du type de retour (en quelque sorte)
     */
    fun translate(instructions: MutableList<EuclinParser.FunctionInstructionsContext>): BlockExpression {
        lambdaArgument = UnitType
        lambdaLocalVars.clear()
        usedLocals.clear()
        currentArguments.clear()
        finalReturnType = null
        updateLambdaParam()
        translateSub(instructions)
        val block = BlockExpression(usedLocals.keys.toList())
        for (argSupplier in currentArguments) {
            block.arguments.add(argSupplier())
        }
        block of finalReturnType!!
        return block
    }

    private fun translateSub(instructions: MutableList<EuclinParser.FunctionInstructionsContext>) {
        val inferer = parentContext.translator.inferer
        instructions.forEach {
            val result = visit(it)
            inferer.infer(result)
        }
        if(finalReturnType == null) {
            val last = instructions.last()
            // TODO
            //  ?: compileError("Aucune expression valide pour un retour", context.currentClass, last)
            finalReturnType = visit(last).type
        }
        updateLambdaParam()
    }

    override fun visitDeclareStructInstruction(ctx: EuclinParser.DeclareStructInstructionContext): Expression {
        compileError("Impossible de définir une structure dans une fonction lambda!", context.currentClass, ctx)
    }

    override fun visitDeclareFuncInstruction(ctx: EuclinParser.DeclareFuncInstructionContext): Expression {
        compileError("Impossible de définir une autre fonction dans une fonction lambda!", context.currentClass, ctx)
    }

    override fun visitVarExpr(ctx: EuclinParser.VarExprContext): Expression {
        val name = ctx.Identifier().text
        return loadName(name, ctx)
    }

    private fun loadName(name: String, ctx: ParserRuleContext): Expression {
        if( ! lambdaLocalVars.containsKey(name)) { // on va gérer la closure, ie rajouter des arguments à la fonction si besoin
            val variableTypes = context.localVariableTypes
            val availableFunctions = context.availableFunctions
            if(variableTypes.containsKey(name)) {
                val varType = variableTypes[name]!!
                if(name !in usedLocals) {
                    // on rajoute le type de la variable aux paramètres de notre lambda
                    lambdaArgument = when(lambdaArgument) {
                        UnitType -> varType
                        is TupleType -> TupleType(arrayOf(*(lambdaArgument as TupleType).elementTypes, varType))
                        else -> TupleType(arrayOf(lambdaArgument, varType))
                    }
                    usedLocals[name] = varType
                    updateLambdaParam()
                }
                return Variable(name) of varType
            } else if(availableFunctions.containsKey(name)) { // si on ne connait pas de fonction
                return function(availableFunctions[name] ?: compileError("Pas de variable trouvée avec le nom $name", context.currentClass, ctx))
            } else {
                val field = context.field(name)
                if(field != null) {
                    return Variable(name) of field.type
                } else { // et si on ne connait pas de field
                    compileError("Unknown variable $name", context.currentClass, ctx) // erreur!
                }
            }
        }
        return Variable(name) of lambdaLocalVars[name]!!
    }

    override fun visitAccessExpr(ctx: EuclinParser.AccessExprContext): Expression {
        val chain = ctx.Identifier()
        val first = visit(ctx.expression())
        return subAccessExpr(first, chain, ctx)
    }

    override fun visitReturnFuncInstruction(ctx: EuclinParser.ReturnFuncInstructionContext): Expression {
        val expr = visit(ctx.expression())
        if(finalReturnType == null)
            finalReturnType = expr.type
        else
            finalReturnType = maxOf(expr.type, finalReturnType!!)
        return expr
    }

    override fun visitLambdaVarExpr(ctx: EuclinParser.LambdaVarExprContext): Expression {
        if(currentArguments.none { it().name == "_" })
            currentArguments += lambdaParameter
        return super.visitLambdaVarExpr(ctx)
    }

    override fun visitExpressionInstruction(ctx: EuclinParser.ExpressionInstructionContext): Expression {
        return translate(ctx.expression())
    }

    override fun visitDeclareVarInstruction(ctx: EuclinParser.DeclareVarInstructionContext): Expression {
        val name = ctx.variableDeclaration().Identifier().text
        if(lambdaLocalVars.containsKey(name))
            compileError("Il y a déjà une variable appelée $name!", parentContext.currentClass, ctx)
        if(parentContext.field(name) != null)
            compileWarning("La variable $name obscure le champ du même nom", parentContext.currentClass, ctx)

        val expression = ctx.variableDeclaration().expression()
        val type = translate(expression).type
        lambdaLocalVars[name] = type
        return Variable(name) of type
    }

    override fun visitAssignVarInstruction(ctx: EuclinParser.AssignVarInstructionContext): Expression {
        val name = ctx.variableAssign().Identifier().text

        if(lambdaLocalVars.containsKey(name)) {
            return Variable(name) of lambdaLocalVars[name]!!
        } else {
            val field = parentContext.field(name) ?: compileError("Aucune variable du nom de $name", parentContext.currentClass, ctx)
            return Variable(name) of field.type
        }
    }

    override fun visitIfBranchingInstruction(ctx: EuclinParser.IfBranchingInstructionContext): Expression {
        visit(ctx.expression())
        val result = translateSub(ctx.functionInstructions())
        if(ctx.elseBlock() != null) {
            translateSub(ctx.elseBlock().functionInstructions())
        }
        return lambdaVar // FIXME: expression spéciale à créer
    }

    override fun visitLoadAndRetypeExpr(ctx: EuclinParser.LoadAndRetypeExprContext): Expression {
        val type = parentContext.typeConverter.visit(ctx.type())
        val expr = visit(ctx.expression())
        return expr of type
    }

    override fun visitCallExpr(ctx: EuclinParser.CallExprContext): Expression {
        val call = ctx.functionCall()
        val id = call.functionIdentifier()
        if(id !is EuclinParser.DirectFunctionIdentifierContext) {
            visit(id)
            return super.visitCallExpr(ctx)
        }
        val name = id.text
        if( ! lambdaLocalVars.containsKey(name)) { // on va gérer la closure, ie rajouter des arguments à la fonction si besoin
            val variableTypes = context.localVariableTypes
            if (variableTypes.containsKey(name)) {
                val varType = variableTypes[name]!!
                if(varType !is FunctionType && varType.listMethods().none { it.name == "invoke" }) {
                    compileError("Le type $varType n'a pas de méthode 'invoke'!", parentContext.currentClass, ctx)
                }
                if (name !in usedLocals) {
                    // on rajoute le type de la variable aux paramètres de notre lambda
                    lambdaArgument = when (lambdaArgument) {
                        UnitType -> varType
                        is TupleType -> TupleType(arrayOf(*(lambdaArgument as TupleType).elementTypes, varType))
                        else -> TupleType(arrayOf(lambdaArgument, varType))
                    }
                    usedLocals[name] = varType
                    updateLambdaParam()
                }
            }
            return super.visitCallExpr(ctx)
        } else {
            val varType = lambdaLocalVars[name]!!
            val arguments = call.expression().map { visit(it) }
            val signature = if(varType is FunctionType) {
                varType.listMethods()[0]
            } else {
                if(varType.listMethods().none { it.name == "invoke" }) {
                    compileError("Le type $varType n'a pas de méthode 'invoke'!", parentContext.currentClass, ctx)
                }
                val method = varType.listMethods().find { it.name == "invoke" }!!
                FunctionSignature("invoke", method.arguments, method.returnType, method.ownerClass, static = false)
            }

            val f = function(signature)
            if(arguments.size == 1)
                return f(arguments[0])
            return f(Tuple(*arguments.toTypedArray()))
        }
    }

    override fun visitMemberFunctionIdentifier(ctx: EuclinParser.MemberFunctionIdentifierContext): Expression {
        loadName(ctx.Identifier()[0].text, ctx)
        return lambdaVar
    }

    private fun updateLambdaParam() {
        lambdaParameter = { TypedMember("_", lambdaVar.type) }
    }
}

class BlockExpression(val usedLocals: List<String>): Expression() {
    val arguments = mutableListOf<TypedMember>()

    override val stringRepresentation: String
        get() = "{Block}"

}