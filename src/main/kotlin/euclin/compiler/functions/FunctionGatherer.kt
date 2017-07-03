package euclin.compiler.functions

import euclin.compiler.Context
import euclin.compiler.TypedMember
import org.jglr.inference.types.FunctionType
import org.jglr.inference.types.TupleType
import org.jglr.inference.types.TypeDefinition
import euclin.compiler.grammar.EuclinBaseVisitor
import euclin.compiler.grammar.EuclinParser
import euclin.compiler.types.TypeConverter
import java.util.*

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

// Définit la signature d'une fonction (nom, arguments, type de retour, la classe dans laquelle elle est et sa pureté)
class FunctionSignature(val name: String, val arguments: List<TypedMember>, val returnType: TypeDefinition, val ownerClass: String, val static: Boolean) {

    fun toType(): TypeDefinition {
        if(arguments.size == 1)
            return FunctionType(arguments[0].second, returnType)
        return FunctionType(TupleType(arguments.map { it.second }.toTypedArray()), returnType)
    }

    override fun equals(other: Any?): Boolean {
        if(other is FunctionSignature)
            return name == other.name && areListEqual(arguments, other.arguments) && returnType == other.returnType && ownerClass == other.ownerClass && static == other.static && pure == other.pure
        return super.equals(other)
    }

    private fun <T> areListEqual(listA: List<T>, listB: List<T>): Boolean {
        if(listA.size != listB.size)
            return false
        listA.forEachIndexed { index, elem -> if(elem != listB[index]) return false }
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        for(elem in arguments)
            result = 31 * result + elem.hashCode()
        result = 31 * result + returnType.hashCode()
        result = 31 * result + ownerClass.hashCode()
        result = 31 * result + static.hashCode()
        result = 31 * result + pure.hashCode()
        return result
    }

    var pure: Boolean = false
}