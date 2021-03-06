package euclin.compiler.functions

import euclin.compiler.Context
import euclin.compiler.grammar.EuclinParser
import euclin.compiler.types.toASM
import org.objectweb.asm.Opcodes.*

class MainFunctionCompiler(parentContext: Context): FunctionCompiler(parentContext) {

    override val isMainFunction: Boolean = true

    override fun visitFunctionDeclaration(ctx: EuclinParser.FunctionDeclarationContext) {
        // On ne fait rien
    }

    fun compileMainFunction(code: EuclinParser.CodeBlockContext) {
        compileFuncHeader()
        code.instructions().forEach {
            addLineInfos(it)
            super.visit(it)
        }
        writer.visitInsn(RETURN)
        compileFuncFooter()

        for(field in parentContext.fields) {
            val type = field.type
            classWriter.visitField(ACC_STATIC or ACC_PRIVATE, field.name, type.toASM().descriptor, null, null)
        }
    }
}