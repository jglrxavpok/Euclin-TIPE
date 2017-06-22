package euclin.compiler.types

import euclin.compiler.functions.Argument
import euclin.compiler.functions.FunctionSignature
import org.jglr.inference.types.TupleType
import org.jglr.inference.types.TypeDefinition

// On précise TypeDefinition pour que le reste du code n'ait pas accès à BasicType
val IntType: TypeDefinition = BasicType("euclin.std.Int")
val RealType: TypeDefinition = BasicType("euclin.std.Real")
val BooleanType: TypeDefinition = BasicType("euclin.std.Boolean")
val UnitType: TypeDefinition = BasicType("euclin.std.UnitObject")
val StringType: TypeDefinition = BasicType("java.lang.String")
val JVMVoid: TypeDefinition = BasicType("void")

val IntPointType = TupleType(arrayOf(IntType, IntType)) // TODO: 'Generic' types ?
val RealPointType = TupleType(arrayOf(RealType, RealType))

val ShapeType: TypeDefinition = BasicType("euclin.std.Shape")

class ObjectType(val name: String, val parent: TypeDefinition): TypeDefinition() {
    override fun toString(): String {
        return name
    }

}

class BasicType(private val toString: String): TypeDefinition() {
    override fun toString(): String {
        return toString
    }

    override fun equals(other: Any?): Boolean {
        return toString() == other.toString()
    }

    override fun compare(other: TypeDefinition, firstCall: Boolean): Int {
        if(this == other)
            return 0
        if(firstCall)
            return -other.compare(this, false)
        throw IllegalArgumentException("Cannot compare basic types $this and $other")
    }

    override fun hashCode(): Int {
        return toString.hashCode()
    }
}

// Extensions pour définir une structure associée à un type
fun TypeDefinition.listFields(): List<Argument> {
    return emptyList()
}

fun TypeDefinition.listMethods(): List<FunctionSignature> {
    return emptyList()
}