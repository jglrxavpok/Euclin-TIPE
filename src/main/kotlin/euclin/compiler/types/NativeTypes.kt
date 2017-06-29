package euclin.compiler.types

import euclin.compiler.TypedMember
import euclin.compiler.functions.FunctionSignature
import org.jglr.inference.types.PolymorphicType
import org.jglr.inference.types.TupleType
import org.jglr.inference.types.TypeDefinition

// On précise TypeDefinition pour que le reste du code n'ait pas accès à BasicType
val IntType: TypeDefinition = BasicType("euclin.std.Int")
val RealType: TypeDefinition = BasicType("euclin.std.Real")
val BooleanType: TypeDefinition = BasicType("euclin.std.Boolean")
val UnitType: TypeDefinition = BasicType("euclin.std.UnitObject")
val StringType: TypeDefinition = BasicType("java.lang.String")
val JVMVoid: TypeDefinition = BasicType("void")
val WildcardType: TypeDefinition = PolymorphicType()

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
private val typeFields = hashMapOf<TypeDefinition, MutableList<TypedMember>>()
private val typeMethods = hashMapOf<TypeDefinition, MutableList<FunctionSignature>>()
private val typeStaticMethods = hashMapOf<TypeDefinition, MutableList<FunctionSignature>>()

fun TypeDefinition.listFields(): MutableList<TypedMember> {
    if(this in typeFields)
        return typeFields[this]!!
    val list = mutableListOf<TypedMember>()
    typeFields[this] = list
    return list
}

fun TypeDefinition.listMethods(): MutableList<FunctionSignature> {
    if(this in typeMethods)
        return typeMethods[this]!!
    val list = mutableListOf<FunctionSignature>()
    typeMethods[this] = list
    return list
}

fun TypeDefinition.listStaticMethods(): MutableList<FunctionSignature> {
    if(this in typeStaticMethods)
        return typeStaticMethods[this]!!
    val list = mutableListOf<FunctionSignature>()
    typeStaticMethods[this] = list
    return list
}