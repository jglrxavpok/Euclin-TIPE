package euclin.compiler.types

import euclin.compiler.TypedMember
import euclin.compiler.functions.FunctionSignature
import euclin.compiler.type
import org.jglr.inference.types.FunctionType
import org.jglr.inference.types.PolymorphicType
import org.jglr.inference.types.TupleType
import org.jglr.inference.types.TypeDefinition

// Types de base de la JVM
val Int32Type = NativeType("euclin.std.Int32", ASMType.INT_TYPE)
val Real32Type = NativeType("euclin.std.Real32", ASMType.FLOAT_TYPE)
val BooleanType = NativeType("euclin.std.Boolean", ASMType.BOOLEAN_TYPE)
val Int8Type = NativeType("euclin.std.Int8", ASMType.BYTE_TYPE)
val Real64Type = NativeType("euclin.std.Real64", ASMType.DOUBLE_TYPE)
val Int16Type = NativeType("euclin.std.Int16", ASMType.SHORT_TYPE)
val Int64Type = NativeType("euclin.std.Int64", ASMType.LONG_TYPE)
val CharType = NativeType("euclin.std.Char", ASMType.CHAR_TYPE)
val JVMVoid = NativeType("void", ASMType.VOID_TYPE)

val WildcardType: TypeDefinition = PolymorphicType()
val UnitType: TypeDefinition = BasicType("euclin.std.UnitObject")
val StringType: TypeDefinition = ObjectType("java.lang.String", WildcardType)

val BasicTypes = listOf(Int32Type, Real32Type, BooleanType, Int8Type, Real64Type, Int16Type, Int64Type, CharType, UnitType, StringType, WildcardType)

val Int32PointType = TupleType(arrayOf(Int32Type, Int32Type)) // TODO: 'Generic' types ?
val Int64PointType = TupleType(arrayOf(Int64Type, Int64Type))
val Real32PointType = TupleType(arrayOf(Real32Type, Real32Type))
val Real64PointType = TupleType(arrayOf(Real64Type, Real64Type))

val ShapeType: TypeDefinition = BasicType("euclin.std.Shape")

class NativeType(name: String, val backing: ASMType): BasicType(name) {
    fun getDescriptor() = backing.descriptor

    override fun equals(other: Any?): Boolean {
        if(super.equals(other))
            return true
        if(other is NativeType)
            return other.backing == backing
        return false
    }
}

class ObjectType(val name: String, val parent: TypeDefinition): TypeDefinition() {
    override fun toString(): String {
        return name
    }

    override fun equals(other: Any?): Boolean {
        if(super.equals(other))
            return true
        if (other is ObjectType) {
            return other.name == name && other.parent == parent
        }
        return false
    }

    override fun compare(other: TypeDefinition, firstCall: Boolean): Int {
        if(this == other)
            return 0
        if(parent == other)
            return -1
        if(other is BasicType) {
            if(parent >= other)
                return 1
            if(parent <= other)
                return -1
        }
        if(other is ObjectType) {
            if(other.parent >= parent)
                return -1
            if(parent >= other.parent)
                return 1
        }
        if(!firstCall) {
            return -other.compare(this, firstCall = false)
        }
        throw IllegalArgumentException("Cannot compare types $this and $other")
    }
}

open class BasicType(private val toString: String): TypeDefinition() {
    override fun toString(): String {
        return toString
    }

    override fun equals(other: Any?): Boolean {
        if(super.equals(other))
            return true
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
private val typeConstructors = hashMapOf<TypeDefinition, MutableList<FunctionSignature>>()
private val typeStaticMethods = hashMapOf<TypeDefinition, MutableList<FunctionSignature>>()

fun TypeDefinition.listFields(): MutableList<TypedMember> {
    if(this in typeFields)
        return typeFields[this]!!
    val list = mutableListOf<TypedMember>()
    typeFields[this] = list
    return list
}

fun TypeDefinition.listConstructors(): MutableList<FunctionSignature> {
    if(this in typeConstructors)
        return typeConstructors[this]!!
    val list = mutableListOf<FunctionSignature>()
    typeConstructors[this] = list
    return list
}

fun TypeDefinition.listMethods(): MutableList<FunctionSignature> {
    if(this is FunctionType) {
        val arguments = if(this.argumentType is TupleType) {
            val tuple = this.argumentType as TupleType
            if(tuple.elementTypes.isEmpty()) {
                emptyList<TypeDefinition>()
            } else {
                tuple.elementTypes.toList()
            }
        } else {
            listOf(argumentType)
        }
        val methodName = interfaceFunctionName(this)
        return mutableListOf(FunctionSignature(methodName, arguments.mapIndexed { index, type -> TypedMember("arg$index", type) },
                this.returnType, javaTypeName(this), static = false))
    }
    if(this in typeMethods)
        return typeMethods[this]!!
    val list = mutableListOf<FunctionSignature>()
    typeMethods[this] = list
    return list
}

/**
 * Renvoit le nom de la seule méthode disponible dans ce type (dépend des arguments et du type de retour)
 */
fun interfaceFunctionName(functionType: FunctionType): String {
    val javaName = javaTypeName(functionType)
    return if(javaName.endsWith("Supplier")) {
        "get"
    } else if(javaName.endsWith("Predicate")) {
        "test"
    } else if(javaName.endsWith("Function")) {
        "apply"
    } else {
        "accept"
    }
}

fun javaTypeName(type: FunctionType): String {
    return if(type.argumentType is TupleType) {
        val tuple = type.argumentType as TupleType
        if(tuple.elementTypes.isEmpty()) {
            "java.util.function.Supplier"
        } else {
            val baseName = when(type.returnType) {
                JVMVoid -> "Consumer"
                BooleanType -> "Predicate"
                else -> "Function"
            }
            when(tuple.elementTypes.size) {
                1 -> "java.util.function.$baseName"
                2 -> "java.util.function.Bi$baseName"
                else -> TODO("Lambdas with more than 2 arguments are not supported yet")
            }
        }
    } else {
        javaTypeName(FunctionType(TupleType(arrayOf(type.argumentType)), type.returnType))
    }
}

fun TypeDefinition.listStaticMethods(): MutableList<FunctionSignature> {
    if(this in typeStaticMethods)
        return typeStaticMethods[this]!!
    val list = mutableListOf<FunctionSignature>()
    typeStaticMethods[this] = list
    return list
}

fun TypeDefinition.constructor(arguments: List<TypeDefinition>): FunctionSignature? {
    for(cons in listConstructors()) {
        if(cons.arguments.size != arguments.size)
            continue
        var fit = true
        arguments.forEachIndexed { index, actual ->
            val expected = cons.arguments[index].type
            if(actual != expected) {
                try {
                    if(actual >= expected) {
                        fit = false
                        return@forEachIndexed
                    }
                } catch (e: Exception) {
                    // on ignore toute erreur due à une comparaison impossible
                    fit = false
                    return@forEachIndexed
                }
            }
        }
        if(fit)
            return cons
    }
    return null
}

fun TypeDefinition.isFloatType(maxBitSize: Int = 64): Boolean {
    val toCheck = mutableListOf<NativeType>()
    if(maxBitSize >= 32)
        toCheck += Real32Type
    if(maxBitSize >= 64)
        toCheck += Real64Type
    return this in toCheck
}

fun TypeDefinition.isIntType(maxBitSize: Int = 64): Boolean {
    val toCheck = mutableListOf<NativeType>()
    if(maxBitSize >= 8)
        toCheck += Int8Type
    if(maxBitSize >= 16)
        toCheck += Int16Type
    if(maxBitSize >= 32)
        toCheck += Int32Type
    if(maxBitSize >= 64)
        toCheck += Int64Type
    return this in toCheck
}