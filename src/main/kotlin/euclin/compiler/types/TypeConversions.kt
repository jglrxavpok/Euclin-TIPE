package euclin.compiler.types

import euclin.compiler.EuclinCompiler.OBJECT_TYPE
import euclin.compiler.TypedMember
import org.jglr.inference.types.FunctionType
import org.jglr.inference.types.TupleType
import org.jglr.inference.types.TypeDefinition

typealias ASMType = org.objectweb.asm.Type

private val RealPointASMType = ASMType.getObjectType("euclin/std/RealPoint")
private val IntegerPointASMType = ASMType.getObjectType("euclin/std/IntPoint")
private val UnitASMType = ASMType.getObjectType("euclin/std/UnitObject")

fun methodType(arguments: List<TypedMember>, returnType: TypeDefinition): ASMType {
    return ASMType.getMethodType(basicType(returnType), *(arguments.map { basicType(it.second) }.toTypedArray()))
}

fun basicType(type: TypeDefinition): ASMType {
    return when(type) {
        IntType -> ASMType.INT_TYPE
        RealType -> ASMType.FLOAT_TYPE
        UnitType -> UnitASMType
        RealPointType -> RealPointASMType
        IntPointType -> IntegerPointASMType
        JVMVoid -> ASMType.VOID_TYPE
        WildcardType -> OBJECT_TYPE
        BooleanType -> ASMType.BOOLEAN_TYPE
        is FunctionType -> generateFunctionObjectType(type)
        // TODO: Autres types?
        else -> ASMType.getObjectType(type.toString().replace(".", "/"))
    }
}

fun generateFunctionObjectType(type: FunctionType): ASMType {

    fun shorten(name: String): String {
        return name.substringAfterLast("/").substringBeforeLast(";") // on prend le dernier morceau et on retire le point-virgule
    }

    val argumentTypes: String
    if(type.argumentType is TupleType) {
        val tuple = type.argumentType as TupleType
        if(tuple.elementTypes.isEmpty())
            argumentTypes = "__"
        else {
            val descriptorList = tuple.elementTypes.map { shorten(basicType(it).descriptor) }
            argumentTypes = "_" + descriptorList.reduce { acc, s -> acc + s } + "_"
        }
    } else {
        argumentTypes = shorten(basicType(type.argumentType).descriptor)
    }
    val returnType = shorten(basicType(type.returnType).descriptor)

    return ASMType.getObjectType("euclin/std/functions/Func${argumentTypes}2$returnType")
}

/**
 * Convertit un nom 'plat (eg. euclin.std.Math) en nom interne pour la JVM (eg. euclin/std/Math)
 */
fun toInternalName(flatName: String): String {
    return flatName.replace(".", "/")
}