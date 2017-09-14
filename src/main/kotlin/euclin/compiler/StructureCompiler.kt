package euclin.compiler

import euclin.compiler.functions.FunctionCompiler
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
        val className = (inputFolder+File.separator+smallName).replace(File.separator, ".")
        val writer = ClassWriter(ClassWriter.COMPUTE_FRAMES)
        writer.visit(V1_8, ACC_PUBLIC, className.replace(".", "/"), null, "java/lang/Object", emptyArray())

        val correspondingType = ObjectType(className, WildcardType)
        parentContext.registerType(className, correspondingType)
        parentContext.importType(smallName, correspondingType)

        for(p in ctx.parameter()) {
            val name = p.Identifier().text
            val type = parentContext.typeConverter.visit(p.type())
            writer.visitField(ACC_PUBLIC, name, type.toASM().descriptor, null, null)

            correspondingType.listFields() += TypedMember(name, type)
        }

        createLinks(ctx.linkage(), correspondingType, className, writer) // on crée les liens avec les méthodes référencées

        with(writer.visitMethod(ACC_PUBLIC, "<init>", "()V", null, emptyArray())) {
            visitCode()
            visitVarInsn(ALOAD, 0)
            visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false)
            visitInsn(RETURN)
            visitMaxs(0, 0)
            visitEnd()
        }

        correspondingType.listConstructors() += FunctionSignature("<init>", emptyList(), JVMVoid, className, static = false)

        writer.visitEnd()

        result[className] = writer.toByteArray()
    }

    private fun createLinks(links: List<EuclinParser.LinkageContext>, correspondingType: ObjectType, className: String, writer: ClassWriter) {
        for(link in links) {
            val methodName = link.Identifier().text
            val arguments = link.type().dropLast(1).map { parentContext.typeConverter.visit(it) }
            compileAssert(arguments.isNotEmpty() && arguments[0] == correspondingType, parentContext.currentClass, link) { "Le premier argument doit être du même type que la structure!" }
            val returnType = parentContext.typeConverter.visit(link.type().last())

            val argumentMembers = arguments.drop(1).mapIndexed { index, definition -> TypedMember("arg$index", definition) }
            val signature = FunctionSignature(methodName, argumentMembers, returnType, className, static = false)
            with(writer.visitMethod(ACC_PUBLIC, methodName, methodType(signature).descriptor, FunctionCompiler.generateGenericSignature(signature), emptyArray())) {
                visitCode()
                var localIndex = 0
                for(arg in arguments) { // charge les arguments. Faire ainsi va aussi charger la structure ciblée avec 'ALOAD 0' ('this')
                    visitVarInsn(arg.correctOpcode(org.objectweb.asm.Opcodes.ILOAD), localIndex)
                    localIndex += arg.localSize
                }
                visitMethodInsn(org.objectweb.asm.Opcodes.INVOKESTATIC, parentContext.currentClass.toInternalName(), methodName, euclin.compiler.types.methodType(returnType, arguments).descriptor, false)
                if(returnType == euclin.compiler.types.JVMVoid)
                    visitInsn(org.objectweb.asm.Opcodes.RETURN)
                else
                    visitInsn(returnType.correctOpcode(org.objectweb.asm.Opcodes.IRETURN))
                visitMaxs(0, 0)
                visitEnd()
            }

            correspondingType.listMethods() += signature
        }
    }
}