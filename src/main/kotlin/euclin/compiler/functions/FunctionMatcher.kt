package euclin.compiler.functions

import euclin.compiler.*
import euclin.compiler.grammar.EuclinBaseVisitor
import euclin.compiler.grammar.EuclinParser
import euclin.compiler.types.listFields
import euclin.compiler.types.listMethods
import euclin.compiler.types.listStaticMethods
import org.antlr.v4.runtime.tree.TerminalNode
import org.jglr.inference.types.TypeDefinition
import java.util.*

class FunctionMatcher(val parentContext: Context): EuclinBaseVisitor<FunctionSignature>() {

    val availableFunctions = parentContext.availableFunctions
    val localVariableTypes = parentContext.localVariableTypes

    override fun visitDirectFunctionIdentifier(ctx: EuclinParser.DirectFunctionIdentifierContext): FunctionSignature {
        val name = ctx.Identifier().text
        if(localVariableTypes.containsKey(name)) {
            val localType = localVariableTypes[name]!!
            if(localType.listMethods().any{ it.name == "invoke" }) {
                val method = localType.listMethods().find { it.name == "invoke" }!!
                return FunctionSignature("invoke", method.arguments, method.returnType, method.ownerClass, static = false)
            }
            compileError("Le type $localType n'a pas de méthode 'invoke'!", parentContext.currentClass, ctx)
        }
        if(availableFunctions.containsKey(name)) {
            val signature = availableFunctions[name]!!
            return signature
        }

        val field = parentContext.field(name)
        if(field != null) {
            if(field.type.listMethods().any{ it.name == "invoke" }) {
                val method = field.type.listMethods().find { it.name == "invoke" }!!
                return FunctionSignature("invoke", method.arguments, method.returnType, method.ownerClass, static = false)
            }
            compileError("Le type ${field.type} n'a pas de méthode 'invoke'!", parentContext.currentClass, ctx)
        }
        compileError("Pas de fonction trouvée avec le nom $name", parentContext.currentClass, ctx)
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
                ?: compileError("Aucune fonction du nom $funcName dans le type $deepest", parentContext.currentClass, ctx)
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
                val field = parentContext.field(name)
                if(field != null)
                    return field.type
                if(parentContext.knowsType(name)) {
                    return parentContext.type(name)
                }
                parentContext.knownTypes.forEach { t, u ->
                    println("known: $t = $u")
                }
                parentContext.importedTypes.forEach { t, u ->
                    println("imported: $t = $u")
                }
                compileError("Aucune variable du nom $name", identifier.symbol.line, parentContext.currentClass)
            }
        } else {
            if(parent.listFields().any { it.name == name }) { // si un des champs a le bon nom
                return parent.listFields().find { it.name == name }!!.type
            } else {
                compileError("Aucun membre du nom de $name dans le type $parent", identifier.symbol.line, parentContext.currentClass)
            }
        }
    }

}