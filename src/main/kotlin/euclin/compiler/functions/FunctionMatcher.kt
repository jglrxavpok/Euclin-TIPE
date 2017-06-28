package euclin.compiler.functions

import euclin.compiler.FunctionList
import euclin.compiler.compileError
import euclin.compiler.expressions.ExpressionTranslator
import euclin.compiler.grammar.EuclinBaseVisitor
import euclin.compiler.grammar.EuclinParser
import euclin.compiler.name
import euclin.compiler.type
import euclin.compiler.types.listFields
import euclin.compiler.types.listMethods
import euclin.compiler.types.listStaticMethods
import org.antlr.v4.runtime.tree.TerminalNode
import org.jglr.inference.types.TypeDefinition

class FunctionMatcher(val availableFunctions: FunctionList, val translator: ExpressionTranslator, val localVariableTypes: Map<String, TypeDefinition>): EuclinBaseVisitor<FunctionSignature>() {

    override fun visitDirectFunctionIdentifier(ctx: EuclinParser.DirectFunctionIdentifierContext): FunctionSignature {
        val name = ctx.Identifier().text
        val signature = availableFunctions[name] ?: compileError("Pas de fonction trouvée avec le nom $name", "?", ctx)
        return signature
    }

    override fun visitMemberFunctionIdentifier(ctx: EuclinParser.MemberFunctionIdentifierContext): FunctionSignature {
        val identifierList = ctx.Identifier()
        var deepest = typeOf(identifierList[0], null)
        for(id in identifierList.drop(1).dropLast(1)) { // on regarde les identifiants qui sont nécessairement des membres
            deepest = typeOf(id, deepest)
        }
        val funcName = identifierList.last().text
        val method = deepest.listMethods().find { it.name == funcName }
                ?: deepest.listStaticMethods().find { it.name == funcName }
                ?: compileError("Aucune fonction du nom $funcName dans le type $deepest", "?", ctx)
        return method
    }

    private fun typeOf(identifier: TerminalNode, parent: TypeDefinition?): TypeDefinition {
        val name = identifier.text
        if(parent == null) {
            // TODO: Autoriser les noms de classe (eg. 'Console.writeln' devrait être valide)
            if(localVariableTypes.containsKey(name)) {
                val type = localVariableTypes[name]!!
                return type
            } else {
                compileError("Aucune variable du nom $name", identifier.symbol.line, "?")
            }
        } else {
            if(parent.listFields().any { it.name == name }) { // si un des champs a le bon nom
                return parent.listFields().find { it.name == name }!!.type
            } else {
                compileError("Aucun membre du nom de $name dans le type $parent", identifier.symbol.line, "?")
            }
        }
    }

}