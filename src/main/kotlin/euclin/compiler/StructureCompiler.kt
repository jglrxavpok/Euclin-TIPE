package euclin.compiler

import euclin.compiler.functions.FunctionSignature
import euclin.compiler.grammar.EuclinParser
import euclin.compiler.types.*
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Opcodes.*
import java.io.File

class StructureCompiler(val parentContext: Context) {

    fun compileStructs(code: EuclinParser.CodeBlockContext, inputFolder: String): Map<String, ByteArray> {
        val result = hashMapOf<String, ByteArray>()
        code.instructions().filterIsInstance<EuclinParser.DeclareStructInstructionContext>().forEach { compile(it.structureDeclaration(), result, inputFolder) }
        return result
    }

    private fun compile(ctx: EuclinParser.StructureDeclarationContext, result: HashMap<String, ByteArray>, inputFolder: String) {
        val smallName = ctx.Identifier().text
        val name = (inputFolder+File.separator+smallName).replace(File.separator, ".")
        val writer = ClassWriter(ClassWriter.COMPUTE_FRAMES)
        writer.visit(V1_8, ACC_PUBLIC, name.replace(".", "/"), null, "java/lang/Object", emptyArray())

        val correspondingType = ObjectType(name, WildcardType)
        parentContext.registerType(name, correspondingType)
        parentContext.importType(smallName, correspondingType)

        for(p in ctx.parameter()) {
            val name = p.Identifier().text
            val type = parentContext.typeConverter.visit(p.type())
            writer.visitField(ACC_PUBLIC, name, type.toASM().descriptor, null, null)

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

        correspondingType.listConstructors() += FunctionSignature("<init>", emptyList(), JVMVoid, name, static = false)

        writer.visitEnd()

        result[name] = writer.toByteArray()
    }
}