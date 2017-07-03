package euclin.compiler.types

import euclin.compiler.EuclinCompiler.OBJECT_TYPE
import euclin.compiler.TypedMember
import euclin.compiler.functions.FunctionSignature
import org.jglr.inference.types.FunctionType
import org.jglr.inference.types.TupleType
import org.jglr.inference.types.TypeDefinition

typealias ASMType = org.objectweb.asm.Type

private val RealPoint64ASMType = ASMType.getObjectType("euclin/std/points/Real64Point")
private val IntegerPoint64ASMType = ASMType.getObjectType("euclin/std/points/Int64Point")
private val RealPoint32ASMType = ASMType.getObjectType("euclin/std/points/Real32Point")
private val IntegerPoint32ASMType = ASMType.getObjectType("euclin/std/points/Int32Point")
private val UnitASMType = ASMType.getObjectType("euclin/std/UnitObject")

fun methodType(method: FunctionSignature): ASMType {
    return methodType(method.arguments, method.returnType)
}

fun methodType(arguments: List<TypedMember>, returnType: TypeDefinition): ASMType {
    return ASMType.getMethodType(basicType(returnType), *(arguments.map { basicType(it.second) }.toTypedArray()))
}

fun basicType(type: TypeDefinition): ASMType {
    return when(type) {
        UnitType -> UnitASMType
        Real32PointType -> RealPoint32ASMType
        Int32PointType -> IntegerPoint32ASMType
        Real64PointType -> RealPoint64ASMType
        Int64PointType -> IntegerPoint64ASMType
        WildcardType -> OBJECT_TYPE
        is NativeType -> type.backing
        is FunctionType -> generateFunctionObjectType(type)
        // TODO: Autres types?
        else -> ASMType.getObjectType(type.toString().replace(".", "/"))
    }
}

private fun shorten(name: String): String {
    return name.substringAfterLast("/").substringBeforeLast(";") // on prend le dernier morceau et on retire le point-virgule
}

fun generateFunctionObjectType(type: FunctionType): ASMType {

    val argumentTypes: String = generateShortName(type.argumentType)
    val returnType = shorten(basicType(type.returnType).descriptor)

    return ASMType.getObjectType("euclin/std/functions/Func${argumentTypes}2$returnType")
}

fun generateShortName(type: TypeDefinition): String {
    return if(type is TupleType) {
        val tuple = type
        if(tuple.elementTypes.isEmpty())
            "__"
        else {
            val descriptorList = tuple.elementTypes.map { shorten(basicType(it).descriptor) }
            "_" + descriptorList.reduce { acc, s -> acc + s } + "_"
        }
    } else {
        shorten(basicType(type).descriptor)
    }
}

/**
 * Convertit un nom 'plat (eg. euclin.std.Math) en nom interne pour la JVM (eg. euclin/std/Math)
 */
fun toInternalName(flatName: String): String {
    return flatName.replace(".", "/")
}