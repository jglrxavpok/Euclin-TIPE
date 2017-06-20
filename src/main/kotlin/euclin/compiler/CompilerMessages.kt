package euclin.compiler

import org.antlr.v4.runtime.ParserRuleContext

fun compileError(message: String, line: Int, filename: String): Nothing {
    throw CompileError(message, line, filename)
}

fun compileError(message: String, filename: String, ruleContext: ParserRuleContext): Nothing {
    val lineNumber = ruleContext.start?.line ?: -1
    compileError(message, lineNumber, filename)
}

fun compileWarning(message: String, line: Int, filename: String) {
    println("Warning in $filename at line $line: $message")
}

fun compileWarning(message: String, filename: String, ruleContext: ParserRuleContext) {
    val lineNumber = ruleContext.start?.line ?: -1
    compileWarning(message, lineNumber, filename)
}

fun compileAssert(condition: Boolean, line: Int, filename: String, lazyMessage: () -> String) {
    if( ! condition)
        compileError(lazyMessage(), line, filename)
}

fun compileAssert(condition: Boolean, filename: String, ruleContext: ParserRuleContext, lazyMessage: () -> String) {
    val lineNumber = ruleContext.start?.line ?: -1
    compileAssert(condition, lineNumber, filename, lazyMessage)
}

fun compileAssert(condition: Boolean, line: Int, filename: String, message: String) {
    compileAssert(condition, line, filename) { message }
}

class CompileError(message: String, line: Int, filename: String) : Exception(createMessage(message, line, filename))
private fun createMessage(message: String, line: Int, filename: String): String {
    return "Error in $filename at line $line: $message"
}
