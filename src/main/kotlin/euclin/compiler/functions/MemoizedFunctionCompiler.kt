package euclin.compiler.functions

import euclin.compiler.Context
import euclin.compiler.TypedMember
import org.jglr.inference.types.TypeDefinition
import euclin.compiler.grammar.EuclinParser
import euclin.compiler.name
import euclin.compiler.type
import euclin.compiler.types.*
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes.*

object MemoizedFunctionCompiler {
    fun compile(functionCodeBlock: EuclinParser.FunctionCodeBlockContext, context: Context) {

        val classWriter = context.classWriter
        val signature: FunctionSignature = context.currentFunction
        val fieldName = "${signature.name}\$cache"
        createCacheField(fieldName, classWriter)
        createCacheInitialization(fieldName, signature, context)

        val computeFunction = FunctionSignature("${signature.name}\$compute", signature.arguments, signature.returnType, signature.ownerClass, signature.static)
        val computeContext = context.withSignature(computeFunction)
        val functionCompiler = FunctionCompiler(computeContext)
        functionCompiler.visit(functionCodeBlock)

        createCacheSeekMethod(fieldName, signature, classWriter)
    }

    private fun createCacheSeekMethod(fieldName: String, signature: FunctionSignature, classWriter: ClassWriter) {
        val writer = classWriter.visitMethod(ACC_PUBLIC or ACC_STATIC, signature.name, methodType(signature.arguments, signature.returnType).descriptor, null, emptyArray())
        with(writer) {
            val arguments = signature.arguments
            val start = Label()
            val end = Label()
            val internalClassName = ASMType.getObjectType(signature.ownerClass.replace(".", "/")).internalName

            val computeBranch = Label()
            val arrayIndex = totalSize(arguments)
            val resultIndex = arrayIndex+1
            visitCode()
            visitLabel(start)
            /*
            args = Object[] {arg1, arg2...}
            if(cache.has(args))
                return cache.get(args)
            value = f$compute(arg1, arg2, ...)
            cache.set(args, value)
            return value
             */
            // on crée le tableau des arguments
            val argCount = signature.arguments.size
            visitLdcInsn(argCount)
            visitTypeInsn(ANEWARRAY, "java/lang/Object")
            visitVarInsn(ASTORE, arrayIndex)
            // on charge les arguments
            var localVarIndex = 0
            var localArrayIndex = 0
            for(arg in arguments) {
                visitVarInsn(ALOAD, arrayIndex)
                visitLdcInsn(localArrayIndex++)
                visitVarInsn(correctOpcode(ILOAD, arg.type), localVarIndex)
                convertToObjectTypeIfNeeded(writer, arg.type)
                visitInsn(AASTORE)
                localVarIndex += FunctionCompiler.localSizeOf(arg.type)
                println(">> ${arg.type}, post index: $localVarIndex")
            }

            // on vérifie si le cache a déjà la valeur
            visitFieldInsn(GETSTATIC, internalClassName, fieldName, "Leuclin/intrisincs/MemoizationCache;")
            visitVarInsn(ALOAD, arrayIndex)
            visitMethodInsn(INVOKEVIRTUAL, "euclin/intrisincs/MemoizationCache", "has", "([Ljava/lang/Object;)Z", false)
            visitJumpInsn(IFEQ, computeBranch) // s'il n'y a pas la valeur

            // on charge la valeur et on renvoit s'il y a la valeur
            visitFieldInsn(GETSTATIC, internalClassName, fieldName, "Leuclin/intrisincs/MemoizationCache;")
            visitVarInsn(ALOAD, arrayIndex)
            visitMethodInsn(INVOKEVIRTUAL, "euclin/intrisincs/MemoizationCache", "get", "([Ljava/lang/Object;)Ljava/lang/Object;", false)
            //visitJumpInsn(GOTO, end)
            convertToNativeTypeIfNeeded(writer, signature.returnType)
            visitInsn(correctOpcode(IRETURN, signature.returnType))

            // sinon on la calcule
            visitLabel(computeBranch)

            localVarIndex = 0
            for(arg in arguments) {
                visitVarInsn(correctOpcode(ILOAD, arg.second), localVarIndex)
                localVarIndex += FunctionCompiler.localSizeOf(arg.type)
            }
            visitMethodInsn(INVOKESTATIC, internalClassName, "${signature.name}\$compute", methodType(signature.arguments, signature.returnType).descriptor, false)

            // On sauvegarde la valeur:
            visitVarInsn(correctOpcode(ISTORE, signature.returnType), resultIndex)
            visitFieldInsn(GETSTATIC, internalClassName, fieldName, "Leuclin/intrisincs/MemoizationCache;")
            visitVarInsn(ALOAD, arrayIndex)
            visitVarInsn(correctOpcode(ILOAD, signature.returnType), resultIndex)
            convertToObjectTypeIfNeeded(writer, signature.returnType)
            visitMethodInsn(INVOKEVIRTUAL, "euclin/intrisincs/MemoizationCache", "set", "([Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", false)

            visitVarInsn(correctOpcode(ILOAD, signature.returnType), resultIndex)
            visitInsn(correctOpcode(IRETURN, signature.returnType))

            visitLabel(end)

            localVarIndex = 0
            for (arg in arguments) {
                visitParameter(arg.name, ACC_FINAL)
                visitLocalVariable(arg.name, basicType(arg.type).descriptor, null, start, end, localVarIndex)
                localVarIndex += FunctionCompiler.localSizeOf(arg.type)
            }
            visitLocalVariable("\$argArray", "[Ljava/lang/Object;", null, start, end, arrayIndex)
            visitLocalVariable("\$result", basicType(signature.returnType).descriptor, null, start, end, resultIndex)
            visitMaxs(0, 0)
            visitEnd()
        }
    }

    private fun totalSize(arguments: List<TypedMember>): Int {
        if(arguments.isEmpty())
            return 0
        return arguments.map(TypedMember::type)
                .map(FunctionCompiler.Companion::localSizeOf)
                .sum()
    }

    private fun convertToObjectTypeIfNeeded(writer: MethodVisitor, type: TypeDefinition) {
       /* when(type) {
            Real32Type -> {
                writer.visitMethodInsn(INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;", false)
            }
            BooleanType -> {
                writer.visitMethodInsn(INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;", false)
            }
            IntType -> {
                writer.visitMethodInsn(INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;", false)
            }
        }*/
        if(type is NativeType)
            FunctionCompiler.convertNativeTypeToBoxed(writer, type)
    }

    private fun convertToNativeTypeIfNeeded(writer: MethodVisitor, type: TypeDefinition) {
        if(type is NativeType)
            FunctionCompiler.convertBoxedObjectToNativeType(writer, type)
    }

    // TODO: Copie de FunctionCompiler
    fun correctOpcode(baseOpcode: Int, type: TypeDefinition): Int {
        return basicType(type).getOpcode(baseOpcode)
    }

    private fun createCacheInitialization(fieldName: String, signature: FunctionSignature, context: Context) {
        context.staticInit += {
            visitTypeInsn(NEW, "euclin/intrisincs/MemoizationCache")
            visitInsn(DUP)
            visitLdcInsn(signature.arguments.size)
            visitMethodInsn(INVOKESPECIAL, "euclin/intrisincs/MemoizationCache", "<init>", "(I)V", false)
            visitFieldInsn(PUTSTATIC, ASMType.getObjectType(signature.ownerClass.replace(".", "/")).internalName, fieldName, "Leuclin/intrisincs/MemoizationCache;")
        }
    }

    private fun createCacheField(fieldName: String, classWriter: ClassWriter) {
        classWriter.visitField(ACC_STATIC or ACC_FINAL or ACC_PRIVATE, fieldName, "Leuclin/intrisincs/MemoizationCache;", null, null)
    }
}