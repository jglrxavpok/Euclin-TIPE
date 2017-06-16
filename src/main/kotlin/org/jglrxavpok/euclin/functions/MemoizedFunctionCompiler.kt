package org.jglrxavpok.euclin.functions

import org.jglr.inference.types.TypeDefinition
import org.jglrxavpok.euclin.*
import org.jglrxavpok.euclin.grammar.EuclinParser
import org.jglrxavpok.euclin.types.*
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes.*

object MemoizedFunctionCompiler {
    fun compile(functionCodeBlock: EuclinParser.FunctionCodeBlockContext, classWriter: ClassWriter, signature: FunctionSignature,
                availableFunctions: Map<String, FunctionSignature>, lambdaExpressions: Map<String, FunctionSignature>) {

        val fieldName = "${signature.name}\$cache"
        createCacheField(fieldName, classWriter)
        createCacheInitialization(fieldName, signature, classWriter)

        val computeFunction = FunctionSignature("${signature.name}\$compute", signature.arguments, signature.returnType, signature.ownerClass)
        val functionCompiler = FunctionCompiler(classWriter, computeFunction, availableFunctions, lambdaExpressions)
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
            val arrayIndex = arguments.size
            for ((index, arg) in arguments.withIndex()) {
                visitParameter(arg.first, ACC_FINAL)
                visitLocalVariable(arg.first, basicType(arg.second).descriptor, null, start, end, index)
            }
            visitLocalVariable("\$argArray", "[Ljava/lang/Object;", null, start, end, arrayIndex)
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
            for((index, arg) in arguments.withIndex()) {
                visitVarInsn(ALOAD, arrayIndex)
                visitLdcInsn(index)
                visitVarInsn(correctOpcode(ILOAD, arg.second), index)
                convertToObjectTypeIfNeeded(writer, arg.second)
                visitInsn(AASTORE)
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
            for((index, arg) in arguments.withIndex())
                visitVarInsn(correctOpcode(ILOAD, arg.second), index)
            visitMethodInsn(INVOKESTATIC, internalClassName, "${signature.name}\$compute", methodType(signature.arguments, signature.returnType).descriptor, false)
            visitInsn(correctOpcode(IRETURN, signature.returnType))

            visitLabel(end)
            //visitInsn(correctOpcode(IRETURN, signature.returnType))
            visitMaxs(0, 0)
            visitEnd()
        }
    }

    private fun convertToObjectTypeIfNeeded(writer: MethodVisitor, type: TypeDefinition) {
        when(type) {
            RealType -> {
                writer.visitMethodInsn(INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;", false)
            }
            BooleanType -> {
                writer.visitMethodInsn(INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;", false)
            }
            IntType -> {
                writer.visitMethodInsn(INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;", false)
            }
        }
    }

    private fun convertToNativeTypeIfNeeded(writer: MethodVisitor, type: TypeDefinition) {
        when(type) {
            RealType -> {
                writer.visitTypeInsn(CHECKCAST, "java/lang/Float") // conversion en Float
                writer.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Float", "floatValue", "()F", false)
            }
            IntType -> {
                writer.visitTypeInsn(CHECKCAST, "java/lang/Integer") // conversion en Integer
                writer.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I", false)
            }
            BooleanType -> {
                writer.visitTypeInsn(CHECKCAST, "java/lang/Boolean") // conversion en Boolean
                writer.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Boolean", "booleanValue", "()Z", false)
            }
        }
    }

    // TODO: Copie de FunctionCompiler
    fun correctOpcode(baseOpcode: Int, type: TypeDefinition): Int {
        return basicType(type).getOpcode(baseOpcode)
    }

    private fun createCacheInitialization(fieldName: String, signature: FunctionSignature, classWriter: ClassWriter) {
        // TODO: Voir s'il faut initialiser d'autres valeurs dans <clinit>
        val mWriter = classWriter.visitMethod(ACC_STATIC, "<clinit>", "()V", null, emptyArray())
        with(mWriter) {
            visitCode()
            visitTypeInsn(NEW, "euclin/intrisincs/MemoizationCache")
            visitInsn(DUP)
            visitLdcInsn(signature.arguments.size)
            visitMethodInsn(INVOKESPECIAL, "euclin/intrisincs/MemoizationCache", "<init>", "(I)V", false)
            visitFieldInsn(PUTSTATIC, ASMType.getObjectType(signature.ownerClass.replace(".", "/")).internalName, fieldName, "Leuclin/intrisincs/MemoizationCache;")
            visitInsn(RETURN)
            visitMaxs(0, 0)
            visitEnd()
        }

    }

    private fun createCacheField(fieldName: String, classWriter: ClassWriter) {
        classWriter.visitField(ACC_STATIC or ACC_FINAL or ACC_PRIVATE, fieldName, "Leuclin/intrisincs/MemoizationCache;", null, null)
    }
}