package euclin.compiler

import euclin.compiler.expressions.ExpressionTranslator
import euclin.compiler.functions.FunctionMatcher
import euclin.compiler.functions.FunctionSignature
import euclin.compiler.types.BasicType
import euclin.compiler.types.TypeConverter
import org.jglr.inference.types.TypeDefinition
import org.objectweb.asm.ClassWriter

data class Context(val currentClass: String, val classWriter: ClassWriter, val availableFunctions: FunctionList) {

    lateinit var currentFunction: FunctionSignature
    val localVariableTypes = hashMapOf<String, TypeDefinition>()
    val localVariableIDs = hashMapOf<String, Int>()
    val fields = mutableListOf<TypedMember>()
    val lambdaExpressions = hashMapOf<String, FunctionSignature>()

    val translator: ExpressionTranslator = ExpressionTranslator(this)
    val functionMatcher = FunctionMatcher(this)
    val constantChecker = ConstantChecker(this)
    val typeConverter = TypeConverter(this)
    private val knownTypes = hashMapOf<String, TypeDefinition>()

    fun withSignature(newSignature: FunctionSignature): Context = copy().apply { currentFunction = newSignature }

    fun copy(): Context {
        val copy = Context(currentClass, classWriter, availableFunctions)
        copy.currentFunction = currentFunction
        copy.localVariableTypes.putAll(localVariableTypes)
        copy.localVariableIDs.putAll(localVariableIDs)
        copy.lambdaExpressions.putAll(lambdaExpressions)
        copy.fields.addAll(fields)
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
        if(knownTypes.containsKey(text))
            return knownTypes[text]!!

        val value = BasicType(text)
        knownTypes[text] = value
        return value
    }
}