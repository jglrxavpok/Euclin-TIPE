package euclin.compiler.types

import euclin.compiler.Context
import euclin.compiler.compileAssert
import euclin.compiler.compileError
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
            "Int32" -> Int32Type
            "Real32" -> Real32Type
            "Unit" -> UnitType
            "String" -> StringType
            "Char", "Character" -> CharType
            "Real", "Real64" -> Real64Type
            "Int", "Int64" -> Int64Type
            "Int16", "Short" -> Int16Type
            "Int8", "Byte" -> Int8Type
            "Boolean", "Bool" -> BooleanType
            else -> parentContext.getTypeOrCreate(text)
        }
    }

    override fun visitArrayType(ctx: EuclinParser.ArrayTypeContext): TypeDefinition {
        return ArrayType(visit(ctx.type()))
    }

    override fun visitWildcardType(ctx: EuclinParser.WildcardTypeContext?): TypeDefinition {
        return WildcardType
    }

    override fun visitCoupleType(ctx: EuclinParser.CoupleTypeContext): TypeDefinition {
        val left = visit(ctx.type(0))
        val right = visit(ctx.type(1))

        compileAssert(left == right, "?", ctx) { "Les deux types d'un couple doivent être les mêmes (pour l'instant)" }
        // TODO: Supporter plus que ces types
        return when(left) {
            Real32Type -> Real32PointType
            Real64Type -> Real64PointType

            Int32Type -> Int32PointType
            Int64Type -> Int64PointType

            else -> compileError("Type couple non supporté: ($left, $right)", parentContext.currentClass, ctx)
        }
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