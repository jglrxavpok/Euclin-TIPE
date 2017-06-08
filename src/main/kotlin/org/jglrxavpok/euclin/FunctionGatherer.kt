package org.jglrxavpok.euclin

import org.jglr.inference.types.FunctionType
import org.jglr.inference.types.TupleType
import org.jglr.inference.types.TypeDefinition
import org.jglrxavpok.euclin.grammar.EuclinBaseVisitor
import org.jglrxavpok.euclin.grammar.EuclinParser
import org.jglrxavpok.euclin.types.BasicType
import org.jglrxavpok.euclin.types.IntType
import org.jglrxavpok.euclin.types.RealPointType

class FunctionGatherer(val ownerClass: String): EuclinBaseVisitor<FunctionSignature>() {

    fun gather(code: EuclinParser.CodeBlockContext): Map<String, FunctionSignature> {
        val result = hashMapOf<String, FunctionSignature>()
        code.instructions().filterIsInstance<EuclinParser.DeclareFuncInstructionContext>().map { it.functionDeclaration() }  // on récupére les déclarations de fonctions
                .forEach { result[it.Identifier().text] = it.accept(this) } // on assigne à chaque nom de fonction sa signature
        return result
    }

    override fun visitFunctionDeclaration(ctx: EuclinParser.FunctionDeclarationContext): FunctionSignature {
        val name = ctx.Identifier().text
        // on convertit les 'parameter' en arguments en décomposant selon le nom et le type
        val arguments = ctx.parameter().map { Argument(it.Identifier().text, toType(it.type().text)) }
        val returnType = toType(ctx.type().text)
        return FunctionSignature(name, arguments, returnType, ownerClass)
    }

    // FIXME: Meilleure conversion vers les Type (autoriser les couples, par exemple)
    private fun toType(text: String): TypeDefinition {
        return when(text) {
            "Int" -> IntType
            "Float" -> RealPointType
            else -> BasicType(text)
        }
    }
}

// Un argument est un nom (String) + un type (String)
typealias Argument = Pair<String, TypeDefinition>
data class FunctionSignature(val name: String, val arguments: List<Argument>, val returnType: TypeDefinition, val ownerClass: String) {

    fun toType(): TypeDefinition {
        if(arguments.size == 1)
            return FunctionType(arguments[0].second, returnType)
        return FunctionType(TupleType(arguments.map { it.second }.toTypedArray()), returnType)
    }
}