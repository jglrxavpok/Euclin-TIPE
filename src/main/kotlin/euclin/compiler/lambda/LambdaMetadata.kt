package euclin.compiler.lambda

import euclin.compiler.functions.FunctionSignature

data class LambdaMetadata(val apiSignature: FunctionSignature, val usedLocals: List<String>, val implementationSignature: FunctionSignature)