package euclin.compiler.types

import euclin.compiler.EuclinCompiler.OBJECT_TYPE
import euclin.compiler.TypedMember
import euclin.compiler.functions.FunctionSignature
import euclin.compiler.shortenType
import org.jglr.inference.types.FunctionType
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
    return methodType(returnType, arguments.map { it.type })
}

fun methodType(returnType: TypeDefinition, arguments: List<TypeDefinition>): ASMType {
    return ASMType.getMethodType(returnType.toASM(), *(arguments.map { it.toASM() }.toTypedArray()))
}

fun generateFunctionObjectType(type: FunctionType): ASMType {

    val argumentTypes: String = type.argumentType.generateShortName()
    val returnType = type.returnType.toASM().descriptor.shortenType()

    return ASMType.getObjectType("euclin/std/functions/Func${argumentTypes}2$returnType")
}

fun TypeDefinition.toASM(): ASMType {
    return when(this) {
        UnitType -> UnitASMType
        Real32PointType -> RealPoint32ASMType
        Int32PointType -> IntegerPoint32ASMType
        Real64PointType -> RealPoint64ASMType
        Int64PointType -> IntegerPoint64ASMType
        WildcardType -> OBJECT_TYPE
        is ArrayType -> ASMType.getType("["+(elementType.toASM().descriptor))
        is NativeType -> backing
        is FunctionType -> ASMType.getObjectType(javaTypeName(this).replace(".", "/"))//generateFunctionObjectType(type)
    // TODO: Autres types?
        else -> ASMType.getObjectType(toString().replace(".", "/"))
    }
}