package euclin.compiler.functions

import euclin.compiler.Context
import euclin.compiler.grammar.EuclinParser
import euclin.compiler.name
import euclin.compiler.type
import euclin.compiler.types.basicType
import org.objectweb.asm.Opcodes.*

class MainFunctionCompiler(val parentContext: Context): FunctionCompiler(parentContext) {
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
            classWriter.visitField(ACC_STATIC or ACC_PRIVATE, field.name, basicType(field.type).descriptor, null, null)
        }
    }
}