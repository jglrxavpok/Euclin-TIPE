package euclin.compiler

import euclin.compiler.grammar.EuclinParser
import euclin.compiler.types.BasicType
import euclin.compiler.types.basicType
import euclin.compiler.types.listFields
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Opcodes.*
import java.io.File

class StructureCompiler(val parentContext: Context) {

    fun compileStructs(code: EuclinParser.CodeBlockContext): Map<String, ByteArray> {
        val result = hashMapOf<String, ByteArray>()
        code.instructions().filterIsInstance<EuclinParser.DeclareStructInstructionContext>().forEach { compile(it.structureDeclaration(), result) }
        return result
    }

    private fun compile(ctx: EuclinParser.StructureDeclarationContext, result: HashMap<String, ByteArray>) {
        val name = ctx.Identifier().text
        val writer = ClassWriter(ClassWriter.COMPUTE_FRAMES)
        writer.visit(V1_8, ACC_PUBLIC, name, null, "java/lang/Object", emptyArray())

        val correspondingType = BasicType(name)

        for(p in ctx.parameter()) {
            val name = p.Identifier().text
            val type = parentContext.typeConverter.visit(p.type())
            writer.visitField(ACC_PUBLIC, name, basicType(type).descriptor, null, null)

            correspondingType.listFields() += TypedMember(name, type)
        }

        val cons = writer.visitMethod(ACC_PUBLIC, "<init>", "()V", null, emptyArray())
        with(cons) {
            cons.visitCode()
            visitVarInsn(ALOAD, 0)
            visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false)
            visitInsn(RETURN)
            visitMaxs(0, 0)
            visitEnd()
        }

        writer.visitEnd()

        result[name] = writer.toByteArray()
        parentContext.registerType(name, correspondingType)
    }
}