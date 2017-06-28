package euclin.compiler.functions

import euclin.compiler.CompileError
import euclin.compiler.FunctionList
import euclin.compiler.expressions.ExpressionTranslator
import euclin.compiler.grammar.EuclinBaseVisitor
import euclin.compiler.grammar.EuclinParser

/**
 * Vérifie qu'une fonction est bien pure, quand elle l'indique.
 * Conditions: n'appeler que des fonctions elles-aussi pures
 */
class FunctionPurityInquisition(val availableFunctions: FunctionList, val translator: ExpressionTranslator): EuclinBaseVisitor<Boolean>() {

    private val funcMatcher = FunctionMatcher(availableFunctions, translator, emptyMap())

    override fun defaultResult(): Boolean {
        return true
    }

    override fun visitDeclareVarInstruction(ctx: EuclinParser.DeclareVarInstructionContext?): Boolean {
        return false
    }

    override fun visitAssignVarInstruction(ctx: EuclinParser.AssignVarInstructionContext?): Boolean {
        return false
    }

    override fun visitFunctionCall(call: EuclinParser.FunctionCallContext): Boolean {
        try {
            val signature = funcMatcher.visit(call.functionIdentifier())
            return signature.pure && call.expression().all { visit(it) }
        } catch (e: CompileError) {
            return false
        }
    }
}