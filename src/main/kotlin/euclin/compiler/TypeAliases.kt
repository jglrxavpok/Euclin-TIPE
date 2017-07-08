package euclin.compiler

import euclin.compiler.functions.FunctionSignature
import org.jglr.inference.types.TypeDefinition

/**
 * Un argument est un nom (String) + un type (String)
 */
data class TypedMember(val name: String, val type: TypeDefinition)

internal typealias FunctionList = HashMap<String, FunctionSignature>