package euclin.compiler

import org.jglr.inference.types.FunctionType
import org.jglr.inference.types.TupleType
import org.jglr.inference.types.TypeDefinition
import euclin.compiler.grammar.EuclinBaseVisitor
import euclin.compiler.grammar.EuclinParser
import euclin.compiler.types.TypeConverter

class FunctionGatherer(val ownerClass: String): EuclinBaseVisitor<FunctionSignature>() {

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
        val arguments = ctx.parameter().map { Argument(it.Identifier().text, toType(it.type())) }
        val returnType = toType(ctx.type())
        return FunctionSignature(name, arguments, returnType, ownerClass)
    }

    private fun toType(type: EuclinParser.TypeContext): TypeDefinition {
        return TypeConverter.visit(type)
    }
}

// Un argument est un nom (String) + un type (String)
typealias Argument = Pair<String, TypeDefinition>

// Définit la signature d'une fonction (nom, arguments, type de retour, la classe dans laquelle elle est et sa pureté)
data class FunctionSignature(val name: String, val arguments: List<Argument>, val returnType: TypeDefinition, val ownerClass: String) {

    fun toType(): TypeDefinition {
        if(arguments.size == 1)
            return FunctionType(arguments[0].second, returnType)
        return FunctionType(TupleType(arguments.map { it.second }.toTypedArray()), returnType)
    }

    var pure: Boolean = false
    var cached: Boolean = false
}