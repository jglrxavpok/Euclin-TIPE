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

fun TypeDefinition.listStaticFields(): MutableList<TypedMember> {
    if(this in typeStaticFields)
        return typeStaticFields[this]!!
    val list = mutableListOf<TypedMember>()
    typeStaticFields[this] = list
    return list
}

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
            this.toASM().descriptor.shortenType()
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
fun TypeDefinition.correctOpcode(baseOpcode: Int) = this.toASM().getOpcode(baseOpcode)