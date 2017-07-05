package euclin.compiler.lambda

import euclin.compiler.Context
import euclin.compiler.TypedMember
import euclin.compiler.expressions.BlockExpression
import euclin.compiler.functions.FunctionCompiler
import euclin.compiler.functions.FunctionSignature
import euclin.compiler.grammar.EuclinBaseVisitor
import euclin.compiler.grammar.EuclinParser
import euclin.compiler.types.Real64Type
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Opcodes

class LambdaCompiler(val parentContext: Context) {

    private val ownerClass = parentContext.currentClass
    private val translator = parentContext.translator
    private val alreadyCompiled = hashMapOf<String, FunctionSignature>()

    fun visitLambdaFunctionExpr(ctx: EuclinParser.LambdaFunctionExprContext): Triple<FunctionSignature, List<String>, FunctionSignature> {
        val functionInstructions = ctx.functionInstructions()

        // on ne compile pas deux fois la même fonction!
        /* TODO if(alreadyCompiled.containsKey(functionExpression.text)) {
            return alreadyCompiled[functionExpression.text]!!
        }*/
        val function = translator.translateLambdaExpression(functionInstructions)
        val block = function.expression as BlockExpression
        val returnType = block.type

        println(">>> ${block.usedLocals}")
        println(">>> ${block.arguments}")
        val name = generateLambdaName(parentContext)
        val lambdaImplementationSignature = FunctionSignature(name, block.usedLocals.map {
            println("local>> $it")
            TypedMember(it, parentContext.localVariableTypes[it]!!)
        }.drop(0) + block.arguments, returnType, ownerClass, static = true)
        println("ARGUMENTS-----")
        lambdaImplementationSignature.arguments.forEach{println(it)}
        val functionBody = generateLambdaBody(functionInstructions, ctx)

        // TODO: alreadyCompiled[functionInstructions.text] = lambdaImplementationSignature

        val funcCompiler = FunctionCompiler(parentContext.withSignature(lambdaImplementationSignature).clearLocals(), synthetic = true, accessRestriction = Opcodes.ACC_PRIVATE)
        funcCompiler.visitFunctionCodeBlock(functionBody)
        val lambdaSignature = FunctionSignature(name, block.arguments, returnType, ownerClass, static = true)
        return Triple(lambdaSignature, block.usedLocals, lambdaImplementationSignature)
    }

    companion object {

        private var lambdaID = 1

        fun generateLambdaName(context: Context): String {
            // si l'expression n'est que '_', on change le nom
            val name = "lambda\$$lambdaID"
            lambdaID++
            return name + "$${context.currentFunction.name}"
        }

        fun generateLambdaBody(instructions: MutableList<EuclinParser.FunctionInstructionsContext>, parent: ParserRuleContext): EuclinParser.FunctionCodeBlockContext {
            val result = EuclinParser.FunctionCodeBlockContext(parent, 1)

            for(instruction in instructions) {
                result.addChild(instruction)
            }
            return result
        }
    }
}