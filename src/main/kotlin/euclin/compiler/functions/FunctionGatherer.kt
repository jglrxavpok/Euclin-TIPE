package euclin.compiler.functions

import euclin.compiler.Context
import euclin.compiler.TypedMember
import org.jglr.inference.types.TypeDefinition
import euclin.compiler.grammar.EuclinBaseVisitor
import euclin.compiler.grammar.EuclinParser

class FunctionGatherer(val parentContext: Context): EuclinBaseVisitor<FunctionSignature>() {

    val ownerClass: String = parentContext.currentClass

    fun gather(code: EuclinParser.CodeBlockContext): Map<String, FunctionSignature> {
        val result = hashMapOf<String, FunctionSignature>()
        code.instructions().filterIsInstance<EuclinParser.DeclareFuncInstructionContext>().map { it.functionDeclaration() }  // on récupére les déclarations de fonctions
                .forEach {
                    val name = it.Identifier().text
                    result[name] = visit(it)
                } // on assigne à chaque nom de fonction sa signature
        return result
    }

    override fun visitFunctionDeclaration(ctx: EuclinParser.FunctionDeclarationContext): FunctionSignature {
        val name = ctx.Identifier().text
        // on convertit les 'parameter' en arguments en décomposant selon le nom et le type
        val arguments = ctx.parameter().map { TypedMember(it.Identifier().text, toType(it.type())) }
        val returnType = toType(ctx.type())
        return FunctionSignature(name, arguments, returnType, ownerClass, static = true) // TODO: Make those functions not static ?
    }

    private fun toType(type: EuclinParser.TypeContext): TypeDefinition {
        return parentContext.typeConverter.visit(type)
    }
}