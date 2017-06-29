package euclin.compiler.types

import euclin.compiler.Context
import euclin.compiler.compileAssert
import org.jglr.inference.types.FunctionType
import org.jglr.inference.types.TupleType
import org.jglr.inference.types.TypeDefinition
import euclin.compiler.grammar.EuclinBaseVisitor
import euclin.compiler.grammar.EuclinParser

class TypeConverter(val parentContext: Context): EuclinBaseVisitor<TypeDefinition>() {

    override fun visitBasicType(type: EuclinParser.BasicTypeContext): TypeDefinition {
        return convertBasic(type.text)
    }

    fun convertBasic(text: String): TypeDefinition {
        return when(text) {
        // Types de bases d'Euclin
            "Int" -> IntType
            "Real" -> RealType
            "Unit" -> UnitType
            "String" -> StringType
            else -> parentContext.type(text)
        }
    }

    override fun visitWildcardType(ctx: EuclinParser.WildcardTypeContext?): TypeDefinition {
        return WildcardType
    }

    override fun visitCoupleType(ctx: EuclinParser.CoupleTypeContext): TypeDefinition {
        val left = visit(ctx.type(0))
        val right = visit(ctx.type(1))

        // TODO: Supporter plus que ces types
        compileAssert(left == right, "?", ctx) { "Les deux types d'un couple doivent être les mêmes (pour l'instant)" }
        if(left == IntType)
            return IntPointType
        return RealPointType
    }

    override fun visitFunctionType(ctx: EuclinParser.FunctionTypeContext): TypeDefinition {
        val argCount = ctx.type().size-1
        val argument: TypeDefinition
        if(argCount == 1) {
            argument = visit(ctx.type(0))
        } else {
            argument = TupleType(ctx.type().subList(0, argCount).map { visit(it) }.toTypedArray())
        }
        val returnType = visit(ctx.type(argCount)) // le dernier type de la liste est le type de retour
        return FunctionType(argument, returnType)
    }
}