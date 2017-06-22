package euclin.compiler

import euclin.compiler.functions.FunctionSignature
import org.jglr.inference.types.TypeDefinition

/**
 * Un argument est un nom (String) + un type (String)
 */
typealias TypedMember = Pair<String, TypeDefinition>
val TypedMember.name
    get() = this.first
val TypedMember.type
    get() = this.second

internal typealias FunctionList = Map<String, FunctionSignature>