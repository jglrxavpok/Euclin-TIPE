package euclin.compiler

import euclin.compiler.expressions.BlockTranslator
import euclin.compiler.expressions.ExpressionTranslator
import euclin.compiler.functions.FunctionMatcher
import euclin.compiler.functions.FunctionSignature
import euclin.compiler.lambda.LambdaCompiler
import euclin.compiler.types.BasicType
import euclin.compiler.types.ObjectType
import euclin.compiler.types.TypeConverter
import euclin.compiler.types.WildcardType
import org.jglr.inference.types.TypeDefinition
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

data class Context(val currentClass: String, val classWriter: ClassWriter, val availableFunctions: FunctionList) {

    lateinit var currentFunction: FunctionSignature
    val localVariableTypes = hashMapOf<String, TypeDefinition>()
    val localVariableIDs = hashMapOf<String, Int>()
    val fields = mutableListOf<TypedMember>()

    val translator = ExpressionTranslator(this)
    val blockTranslator = BlockTranslator(this)
    val functionMatcher = FunctionMatcher(this)
    val constantChecker = ConstantChecker(this)
    val typeConverter = TypeConverter(this)
    val lambdaCompiler = LambdaCompiler(this)
    internal val knownTypes = hashMapOf<String, TypeDefinition>()
    internal val importedTypes = hashMapOf<String, TypeDefinition>()
    val staticInit = mutableListOf<MethodVisitor.() -> Unit>()

    init {
        knownTypes += "java.lang.Object" to WildcardType
    }

    fun withSignature(newSignature: FunctionSignature): Context = copy().apply { this.currentFunction = newSignature }

    fun copy(): Context {
        val copy = Context(currentClass, classWriter, availableFunctions)
        copy.currentFunction = currentFunction
        copy.localVariableTypes.putAll(localVariableTypes)
        copy.localVariableIDs.putAll(localVariableIDs)
        copy.fields.addAll(fields)
        copy.importedTypes.putAll(importedTypes)
        copy.knownTypes.putAll(knownTypes)
        return copy
    }

    fun clearLocals(): Context {
        localVariableTypes.clear()
        localVariableIDs.clear()
        return this
    }

    fun field(name: String): TypedMember? {
        return fields.find { it.name == name }
    }

    fun type(text: String): TypeDefinition {
        if(importedTypes.containsKey(text))
            return importedTypes[text]!!
        if(knownTypes.containsKey(text))
            return knownTypes[text]!!

        val value = ObjectType(text, WildcardType)
        knownTypes[text] = value
        return value
    }

    fun registerType(name: String, type: TypeDefinition) {
        knownTypes[name] = type
    }

    fun importType(name: String, type: TypeDefinition) {
        importedTypes[name] = type
    }

    fun knowsType(name: String): Boolean {
        return importedTypes.containsKey(name) || knownTypes.containsKey(name)
    }

    fun createStaticBlock() {
        if(staticInit.isEmpty())
            return
        val writer = classWriter.visitMethod(Opcodes.ACC_STATIC, "<clinit>", "()V", null, emptyArray())
        writer.visitCode()
        staticInit.forEach { block -> block.invoke(writer) }
        writer.visitInsn(Opcodes.RETURN)
        writer.visitMaxs(0, 0)
        writer.visitEnd()
    }
}