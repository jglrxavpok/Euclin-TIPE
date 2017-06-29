package euclin.compiler.lambda

import euclin.compiler.Context
import euclin.compiler.FunctionList
import euclin.compiler.TypedMember
import euclin.compiler.functions.FunctionCompiler
import euclin.compiler.functions.FunctionSignature
import euclin.compiler.compileError
import euclin.compiler.grammar.EuclinBaseVisitor
import euclin.compiler.grammar.EuclinParser
import euclin.compiler.expressions.ExpressionTranslator
import euclin.compiler.types.RealType
import org.objectweb.asm.ClassWriter

class LambdaCompiler(val parentContext: Context):
    EuclinBaseVisitor<FunctionSignature?>() {

    private val classWriter: ClassWriter = parentContext.classWriter
    private val ownerClass: String = parentContext.currentClass
    private val availableFunctions: FunctionList = parentContext.availableFunctions
    private val translator = parentContext.translator
    private var resultMap = hashMapOf<String, FunctionSignature>()
    private val alreadyCompiled = hashMapOf<String, FunctionSignature>()

    fun compileLambdas(code: EuclinParser.CodeBlockContext): Map<String, FunctionSignature> {
        resultMap = hashMapOf()
        code.instructions().forEach { it.accept(this) }
        return resultMap
    }

    override fun visitLambdaFunctionExpr(ctx: EuclinParser.LambdaFunctionExprContext): FunctionSignature? {
        val functionExpression = ctx.expression()

        // on ne compile pas deux fois la même fonction!
        if(alreadyCompiled.containsKey(functionExpression.text)) {
            resultMap[functionExpression.text] = alreadyCompiled[functionExpression.text] ?: compileError("Pas de lambda correspondant à ${functionExpression.text}", ownerClass, ctx)
            return alreadyCompiled[functionExpression.text]
        }
        val function = translator.translateLambdaExpression(functionExpression)
        val returnType = function.expression.type

        val name = generateLambdaName(functionExpression, parentContext)
        val lambdaSignature = FunctionSignature(name, listOf(TypedMember("_", RealType)), returnType, ownerClass, static = true)
        val functionBody = generateLambdaBody(functionExpression)

        alreadyCompiled[functionExpression.text] = lambdaSignature
        resultMap[functionExpression.text] = lambdaSignature

        val funcCompiler = FunctionCompiler(parentContext.withSignature(lambdaSignature))
        funcCompiler.visitFunctionCodeBlock(functionBody)
        return lambdaSignature
    }

    override fun visitFunctionDeclaration(ctx: EuclinParser.FunctionDeclarationContext): FunctionSignature? {
        val name = ctx.Identifier().text
        parentContext.currentFunction = parentContext.availableFunctions[name]!!
        return super.visitFunctionDeclaration(ctx)
    }

    companion object {

        private var lambdaID = 1

        fun generateLambdaName(functionExpression: EuclinParser.ExpressionContext, context: Context): String {
            // si l'expression n'est que '_', on change le nom
            val name = if (functionExpression.text.trim() == "_") "lambda\$identity" else "lambda\$$lambdaID"
            lambdaID++
            return name + "$${context.currentFunction.name}"
        }

        fun generateLambdaBody(instruction: EuclinParser.ExpressionContext): EuclinParser.FunctionCodeBlockContext {
            val result = EuclinParser.FunctionCodeBlockContext(null, 0)
            val instructions = EuclinParser.FunctionInstructionsContext()
            //result.addChild(instructions)

            val returnInstructionWrapper = EuclinParser.ReturnFuncInstructionContext(instructions)
            returnInstructionWrapper.addChild(instruction)

            result.addChild(returnInstructionWrapper)
            return result
        }
    }
}