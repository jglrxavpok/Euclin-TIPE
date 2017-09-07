package euclin.compiler.types

import euclin.compiler.TypedMember
import euclin.compiler.functions.FunctionSignature
import euclin.compiler.shortenType
import org.jglr.inference.types.FunctionType
import org.jglr.inference.types.TupleType
import org.jglr.inference.types.TypeDefinition


// Extensions pour définir une structure associée à un type
private val typeFields = hashMapOf<TypeDefinition, MutableList<TypedMember>>()
private val typeStaticFields = hashMapOf<TypeDefinition, MutableList<TypedMember>>()
private val typeMethods = hashMapOf<TypeDefinition, MutableList<FunctionSignature>>()
private val typeConstructors = hashMapOf<TypeDefinition, MutableList<FunctionSignature>>()
private val typeStaticMethods = hashMapOf<TypeDefinition, MutableList<FunctionSignature>>()

private fun <T> TypeDefinition.listMembers(map: MutableMap<TypeDefinition, MutableList<T>>): MutableList<T> {
    if(this in map)
        return map[this]!!
    val list = mutableListOf<T>()
    map[this] = list
    return list
}

fun TypeDefinition.listStaticFields(): MutableList<TypedMember> {
    return listMembers(typeStaticFields)
}

fun TypeDefinition.listFields(): MutableList<TypedMember> {
    if(this is ArrayType)
        return mutableListOf(TypedMember("length", Int32Type))
    return listMembers(typeFields)
}

fun TypeDefinition.listConstructors(): MutableList<FunctionSignature> {
    return listMembers(typeConstructors)
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
    return listMembers(typeMethods)
}

fun TypeDefinition.listStaticMethods(): MutableList<FunctionSignature> {
    return listMembers(typeStaticMethods)
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

fun TypeDefinition.generateShortName(): String =
        if(this is TupleType) {
            val tuple = this
            if(tuple.elementTypes.isEmpty())
                "__"
            else {
                val descriptorList = tuple.elementTypes.map { it.toASM().descriptor.shortenType() }
                "_" + descriptorList.reduce { acc, s -> acc + s } + "_"
            }
        } else {
            toASM().descriptor.shortenType()
        }

/**
 * Nombres de cellules utilisées pour stocker cette variable sur la JVM
 */
val TypeDefinition.localSize: Int
    get() =
        when(this) {
            Real64Type, Int64Type -> 2
            else -> 1
        }

/**
 * Corrige l'instruction donnée pour coller au type
 */
fun TypeDefinition.correctOpcode(baseOpcode: Int) = toASM().getOpcode(baseOpcode)