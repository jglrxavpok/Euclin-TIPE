package euclin.compiler.functions

import euclin.compiler.Context
import euclin.compiler.FunctionList
import euclin.compiler.grammar.EuclinParser
import org.objectweb.asm.ClassWriter

class MainFunctionCompiler(parentContext: Context): FunctionCompiler(parentContext) {
    override fun visitFunctionDeclaration(ctx: EuclinParser.FunctionDeclarationContext) {
        // On ne fait rien
    }
}