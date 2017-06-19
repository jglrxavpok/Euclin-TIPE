package euclin.compiler.functions

import euclin.compiler.FunctionSignature
import euclin.compiler.grammar.EuclinBaseVisitor
import euclin.compiler.grammar.EuclinParser

/**
 * Vérifie qu'une fonction est bien pure, quand elle l'indique.
 * Conditions: n'appeler que des fonctions elles-aussi pures
 */
class FunctionPurityInquisition(val availableFunctions: Map<String, FunctionSignature>): EuclinBaseVisitor<Boolean>() {

    override fun defaultResult(): Boolean {
        return true
    }

    override fun visitFunctionCall(call: EuclinParser.FunctionCallContext): Boolean {
        val name = call.Identifier().text
        val signature = availableFunctions[name] ?: error("Pas de fonction trouvée avec le nom $name")
        return signature.pure && call.expression().all { visit(it) }
    }
}