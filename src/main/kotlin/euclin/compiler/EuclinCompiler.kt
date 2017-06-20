package euclin.compiler

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.jglr.inference.types.FunctionType
import euclin.compiler.functions.MemoizedFunctionCompiler
import euclin.compiler.functions.FunctionPurityInquisition
import euclin.compiler.grammar.EuclinLexer
import euclin.compiler.grammar.EuclinParser
import euclin.compiler.types.*
import euclin.compiler.lambda.LambdaCompiler
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Opcodes.*
import java.io.File

object EuclinCompiler {

    val OBJECT_TYPE = ASMType.getType(Object::class.java)

    fun compile(sourceCode: String, filename: String): ByteArray {
        val startTime = System.nanoTime()
        val classWriter = ClassWriter(ClassWriter.COMPUTE_FRAMES) // laisse ASM générer les frames et maxs
        val className = filename.substringAfterLast(File.separator).substringBefore(".") // dernier fichier du chemin et on retire l'extension
        val classType = ASMType.getObjectType(className)
        classWriter.visit(V1_8, ACC_PUBLIC, classType.internalName, null, OBJECT_TYPE.internalName, emptyArray())

        val functionGatherer = FunctionGatherer(className)

        // création du lexer et du parser
        val lexer = EuclinLexer(CharStreams.fromString(sourceCode, filename))
        val parser = EuclinParser(CommonTokenStream(lexer))

        val code = parser.codeBlock() // on récupère le corps du code

        // on récupère la liste des signatures (ou têtes) de fonctions présentes dans le code
        val functions = functionGatherer.gather(code).toMutableMap()

        // on y ajoute les fonctions de la bibliothèque standard
        addStandardFunctions(functions)

        // on génére le code des lambda-fonctions
        val lambdaExpressions = compileLambdas(classWriter, code, className, functions)

        // on génére les fonctions
        compileFunctions(classWriter, code, functions, lambdaExpressions)

        // on génére la fonction principale
        // TODO

        classWriter.visitEnd()
        val endTime = System.nanoTime()
        val elapsedTime = (endTime - startTime) / 1000000.0f
        println("Compiled $filename in $elapsedTime ms")
        return classWriter.toByteArray()
    }

    private fun addStandardFunctions(functions: MutableMap<String, FunctionSignature>) {
        val circleFunction = FunctionSignature("circle", listOf(
                Argument("center", FunctionType(RealType, RealPointType)),
                Argument("radius", FunctionType(RealType, RealType))
        ), ObjectType("Circle", ShapeType), "euclin.std.Geometry")

        val sinFunction = FunctionSignature("sin", listOf(
                Argument("angle", RealType)
        ), RealType, "euclin.std.MathFunctions")

        val cosFunction = FunctionSignature("cos", listOf(
                Argument("angle", RealType)
        ), RealType, "euclin.std.MathFunctions")

        val tanFunction = FunctionSignature("tan", listOf(
                Argument("angle", RealType)
        ), RealType, "euclin.std.MathFunctions")

        val writeFunction = FunctionSignature("write", listOf(
                Argument("text", StringType)
        ), JVMVoid, "euclin.std.Console")

        val writelnFunction = FunctionSignature("writeln", listOf(
                Argument("text", StringType)
        ), JVMVoid, "euclin.std.Console")

        functions["sin"] = sinFunction
        functions["cos"] = cosFunction
        functions["tan"] = tanFunction
        functions["circle"] = circleFunction
        functions["write"] = writeFunction
        functions["writeln"] = writelnFunction
    }

    private fun compileLambdas(classWriter: ClassWriter, code: EuclinParser.CodeBlockContext, ownerClass: String, functions: Map<String, FunctionSignature>): Map<String, FunctionSignature> {
        val lambdaCompiler = LambdaCompiler(classWriter, ownerClass, functions)
        return lambdaCompiler.compileLambdas(code)
    }

    private fun compileFunctions(classWriter: ClassWriter, code: EuclinParser.CodeBlockContext, availableFunctions: Map<String, FunctionSignature>, lambdaExpressions: Map<String, FunctionSignature>) {
        val inquisition = FunctionPurityInquisition(availableFunctions)
        val declarations = code.instructions().filterIsInstance<EuclinParser.DeclareFuncInstructionContext>().map { it.functionDeclaration() } // on récupére les déclarations de fonctions
        for(func in declarations) {
            val funcName = func.Identifier().text
            val signature = availableFunctions[funcName] ?: error("Aucune signature correspondante") // renvoit une erreur si on ne trouve pas la signature correspondant au nom
            // (ne devrait jamais arriver)

            if(modifiersHave(func, "pure") && modifiersHave(func, "impure")) {
                compileError("A function cannot be both pure and impure", signature.ownerClass, func)
            }

            val isPure = inquisition.visit(func)
            signature.pure = isPure
            if(modifiersHave(func, "pure")) {
                if( ! isPure) {
                    compileError("Function '$funcName' is declared pure but is not", signature.ownerClass, func)
                }
            }
            if(modifiersHave(func, "impure")) {
                signature.pure = false
            }
            if(modifiersHave(func, "memoized")) {
                signature.pure = true // Les fonctions avec un cache renvoient par définition toujours le même résultat pour les mêmes arguments
                MemoizedFunctionCompiler.compile(func.functionCodeBlock(), classWriter, signature, availableFunctions, lambdaExpressions)
            } else {
                val funcCompiler = FunctionCompiler(classWriter, signature, availableFunctions, lambdaExpressions)
                funcCompiler.visit(func.functionCodeBlock())
            }
        }
    }

    private fun modifiersHave(func: EuclinParser.FunctionDeclarationContext, modifier: String): Boolean {
        return func.modifiers().any { it.text == modifier }
    }

}