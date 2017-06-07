package org.jglrxavpok.euclin

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.jglr.inference.types.FunctionType
import org.jglrxavpok.euclin.grammar.EuclinLexer
import org.jglrxavpok.euclin.grammar.EuclinParser
import org.jglrxavpok.euclin.lambda.LambdaCompiler
import org.jglrxavpok.euclin.types.ObjectType
import org.jglrxavpok.euclin.types.RealPointType
import org.jglrxavpok.euclin.types.RealType
import org.jglrxavpok.euclin.types.ShapeType
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Opcodes.*

object EuclinCompiler {

    val OBJECT_TYPE = ASMType.getType(Object::class.java)

    fun compile(sourceCode: String, filename: String): ByteArray {
        val classWriter = ClassWriter(ClassWriter.COMPUTE_FRAMES) // laisse ASM générer les frames et maxs
        val className = filename.replace("/", ".").substringBeforeLast(".")
        val classType = ASMType.getObjectType(className)
        classWriter.visit(V1_8, ACC_PUBLIC, classType.internalName, null, OBJECT_TYPE.internalName, emptyArray())

        val functionGatherer = FunctionGatherer(className)

        // création du lexer et du parseur
        val lexer = EuclinLexer(CharStreams.fromString(sourceCode, filename))
        val parser = EuclinParser(CommonTokenStream(lexer))

        val code = parser.codeBlock() // on récupère le corps du code

        // on récupère la liste des signatures (ou têtes) de fonctions présentes dans le code
        val functions = functionGatherer.gather(code).toMutableMap()

        // on y ajoute les fonctions de la bibliothèque standard
        val circleFunction = FunctionSignature("circle", listOf(
                Argument("center", FunctionType(RealType, RealPointType)),
                Argument("radius", FunctionType(RealType, RealType))
                ), ObjectType("Circle", ShapeType), "euclin.std.Geometry")
        val sinFunction = FunctionSignature("sin", listOf(
                Argument("angle", RealType)
        ), RealType, "euclin.std.MathFunctions")
        functions["circle"] = circleFunction
        functions["sin"] = sinFunction

        // on génére le code des lambda-fonctions
        val lambdaExpressions = compileLambdas(classWriter, code, className, functions)

        // on génére les fonctions
        compileFunctions(classWriter, code, functions, lambdaExpressions)

        // on génére la fonction principale
        // TODO

        classWriter.visitEnd()
        return classWriter.toByteArray()
    }

    private fun compileLambdas(classWriter: ClassWriter, code: EuclinParser.CodeBlockContext, ownerClass: String, functions: Map<String, FunctionSignature>): Map<String, FunctionSignature> {
        val lambdaCompiler = LambdaCompiler(classWriter, ownerClass, functions)
        return lambdaCompiler.compileLambdas(code)
    }

    private fun compileFunctions(classWriter: ClassWriter, code: EuclinParser.CodeBlockContext, availableFunctions: Map<String, FunctionSignature>, lambdaExpressions: Map<String, FunctionSignature>) {
        val declarations = code.instructions().filterIsInstance<EuclinParser.DeclareFuncInstructionContext>().map { it.functionDeclaration() } // on récupére les déclarations de fonctions
        for(func in declarations) {
            val funcName = func.Identifier().text
            val signature = availableFunctions[funcName] ?: error("Aucune signature correspondante") // renvoit une erreur si on ne trouve pas la signature correspondant au nom
            // (ne devrait jamais arriver)

            val funcCompiler = FunctionCompiler(classWriter, signature, availableFunctions, lambdaExpressions)
            func.functionCodeBlock().accept(funcCompiler)
        }
    }

}