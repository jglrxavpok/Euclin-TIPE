package euclin.compiler.types

import euclin.compiler.Context
import euclin.compiler.TypedMember
import euclin.compiler.functions.FunctionSignature
import org.jglr.inference.types.TypeDefinition
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.FieldVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type

class TypeInspectorVisitor(val destination: TypeDefinition, val context: Context) : ClassVisitor(ASM5) {

    private lateinit var currentClass: String

    override fun visit(version: Int, access: Int, name: String, signature: String?, superName: String?, interfaces: Array<out String>?) {
        currentClass = name.replace("/", ".")
        super.visit(version, access, name, signature, superName, interfaces)
    }

    override fun visitField(access: Int, name: String, desc: String, signature: String?, value: Any?): FieldVisitor? {
        if(access and ACC_STATIC != 0)
            destination.listFields() += TypedMember(name, convertBaseDesc(desc))
        return super.visitField(access, name, desc, signature, value)
    }

    override fun visitMethod(access: Int, name: String, desc: String, signature: String?, exceptions: Array<out String>?): MethodVisitor? {
        val isStatic = access and ACC_STATIC != 0
        val methodType = convertMethodDesc(desc)
        val toModify = if(isStatic) destination.listStaticMethods() else destination.listMethods()
        val args = methodType.first.mapIndexed { index, type ->
            TypedMember("arg$index", type)
        }
        val function = FunctionSignature(name, args, methodType.second, currentClass, isStatic)
        if(name != "<init>") {
            toModify += function
        } else {
            destination.listConstructors() += function
        }
        return super.visitMethod(access, name, desc, signature, exceptions)
    }

    private fun convertMethodDesc(desc: String): Pair<List<TypeDefinition>, TypeDefinition> {
        val asmType = ASMType.getMethodType(desc)
        val args = asmType.argumentTypes.map { convertBaseDesc(it.descriptor) }
        val returnType = convertBaseDesc(asmType.returnType.descriptor)
        return Pair(args, returnType)
    }

    private fun convertBaseDesc(desc: String): TypeDefinition {
        val asmType = ASMType.getType(desc)
        return when(asmType) {
            Type.INT_TYPE -> IntType
            Type.BOOLEAN_TYPE -> BooleanType
            Type.FLOAT_TYPE -> RealType
            Type.VOID_TYPE -> JVMVoid

            else ->
                if(desc.startsWith("L"))
                    convertObjectDesc(desc.substring(1).dropLast(1))
                else
                    BasicType("Native$desc")
        }
    }

    fun convertObjectDesc(internalName: String): TypeDefinition {
        return context.typeConverter.convertBasic(internalName.replace("/", "."))
    }
}
