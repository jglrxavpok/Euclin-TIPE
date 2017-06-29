package euclin.compiler

import euclin.compiler.functions.*
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.jglr.inference.types.FunctionType
import euclin.compiler.grammar.EuclinLexer
import euclin.compiler.grammar.EuclinParser
import euclin.compiler.types.*
import euclin.compiler.lambda.LambdaCompiler
import euclin.intrisincs.EuclinApplication
import euclin.intrisincs.MemoizationCache
import euclin.std.*
import euclin.std.functions.FuncF2F
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Opcodes.*
import java.io.File

object EuclinCompiler {

    val OBJECT_TYPE: ASMType = ASMType.getType(Object::class.java)

    fun compile(sourceCode: String, filename: String, isApplication: Boolean = true): ByteArray {
        val startTime = System.nanoTime()

        // Inspection de la librairie standard
        inspectStandardLibrary()

        // création du lexer et du parser
        val lexer = EuclinLexer(CharStreams.fromString(sourceCode, filename))
        val parser = EuclinParser(CommonTokenStream(lexer))

        val code = parser.codeBlock() // on récupère le corps du code

        val classWriter = ClassWriter(ClassWriter.COMPUTE_FRAMES) // laisse ASM générer les frames et maxs
        val className = filename.substringAfterLast(File.separator).substringBefore(".")+ if(isApplication) "Application" else "" // dernier fichier du chemin et on retire l'extension
        val classType = ASMType.getObjectType(className)
        classWriter.visit(V1_8, ACC_PUBLIC, classType.internalName, null, OBJECT_TYPE.internalName, arrayOf("euclin/intrisincs/EuclinApplication"))

        val context = Context(className, classWriter, hashMapOf())
        val functionGatherer = FunctionGatherer(context)

        // on récupère la liste des signatures (ou têtes) de fonctions présentes dans le code
        val functions = functionGatherer.gather(code).toMutableMap()

        // on y ajoute les fonctions de la bibliothèque standard
        addStandardFunctions(functions)
        context.availableFunctions.putAll(functions)

        // on génére le code des lambda-fonctions

        val lambdaExpressions = compileLambdas(code, context)
        context.lambdaExpressions.putAll(lambdaExpressions)

        // on génére la fonction principale
        val mainSignature = FunctionSignature("__main", emptyList(), JVMVoid, className, static = false)
        context.currentFunction = mainSignature
        val mainCompiler = MainFunctionCompiler(context.clearLocals())
        mainCompiler.compileMainFunction(code)

        // on génére les fonctions
        compileFunctions(code, context)

        // on génère un constructeur basique
        val constructor = classWriter.visitMethod(ACC_PUBLIC, "<init>", "()V", null, emptyArray())
        with(constructor) {
            visitCode()
            visitVarInsn(ALOAD, 0) // load 'this'
            visitMethodInsn(INVOKESPECIAL, OBJECT_TYPE.internalName, "<init>", "()V", false) // 'super.<init>()'
            visitInsn(RETURN)
            visitMaxs(0,0)
            visitEnd()
        }

        classWriter.visitEnd()
        val endTime = System.nanoTime()
        val elapsedTime = (endTime - startTime) / 1000000.0f
        println("Compiled $filename in $elapsedTime ms")
        return classWriter.toByteArray()
    }

    private fun inspectStandardLibrary() {
        // TODO: + de classes?
        TypeInspector.inspect(IntPoint::class.java, IntPointType)
        TypeInspector.inspect(RealPoint::class.java, RealPointType)
        TypeInspector.inspect(UnitObject::class.java, UnitType)
        TypeInspector.inspect(Console::class.java, BasicType("euclin.std.Console"))
        TypeInspector.inspect(MathFunctions::class.java, BasicType("euclin.std.MathFunctions"))
        TypeInspector.inspect(EuclinApplication::class.java, BasicType("euclin.intrisincs.EuclinApplication"))
        TypeInspector.inspect(MemoizationCache::class.java, BasicType("euclin.intrisincs.MemoizationCache"))

        val types = mutableListOf(RealType, RealPointType, IntType, IntPointType, UnitType)

        val rootFolder = File("./src/main/euclin/lang/euclin/std/functions")
        rootFolder.mkdirs()
        for(argument in types) {
            for (returnType in types) {
                val funcType = FunctionType(argument, returnType)
                val correspondingType = basicType(FunctionType(argument, returnType)).internalName
                val name = correspondingType.substringAfterLast("/")
                val clazz = Class.forName("euclin.std.functions.$name")
                TypeInspector.inspect(clazz, funcType)
            }
        }
    }

    private fun addStandardFunctions(functions: MutableMap<String, FunctionSignature>) {
        val circleFunction = FunctionSignature("circle", listOf(
                TypedMember("center", FunctionType(RealType, RealPointType)),
                TypedMember("radius", FunctionType(RealType, RealType))
        ), ObjectType("Circle", ShapeType), "euclin.std.Geometry", static = true)

        val sinFunction = FunctionSignature("sin", listOf(
                TypedMember("angle", RealType)
        ), RealType, "euclin.std.MathFunctions", static = true)

        val cosFunction = FunctionSignature("cos", listOf(
                TypedMember("angle", RealType)
        ), RealType, "euclin.std.MathFunctions", static = true)

        val tanFunction = FunctionSignature("tan", listOf(
                TypedMember("angle", RealType)
        ), RealType, "euclin.std.MathFunctions", static = true)

        val writeFunction = FunctionSignature("write", listOf(
                TypedMember("text", StringType)
        ), JVMVoid, "euclin.std.Console", static = true)

        val writelnFunction = FunctionSignature("writeln", listOf(
                TypedMember("text", StringType)
        ), JVMVoid, "euclin.std.Console", static = true)

        functions["sin"] = sinFunction
        functions["cos"] = cosFunction
        functions["tan"] = tanFunction
        functions["circle"] = circleFunction
        functions["write"] = writeFunction
        functions["writeln"] = writelnFunction
    }

    private fun compileLambdas(code: EuclinParser.CodeBlockContext, context: Context): Map<String, FunctionSignature> {
        val lambdaCompiler = LambdaCompiler(context)
        return lambdaCompiler.compileLambdas(code)
    }

    private fun compileFunctions(code: EuclinParser.CodeBlockContext, context: Context) {
        val inquisition = FunctionPurityInquisition(context)
        val declarations = code.instructions().filterIsInstance<EuclinParser.DeclareFuncInstructionContext>().map { it.functionDeclaration() } // on récupére les déclarations de fonctions
        for(func in declarations) {
            val funcName = func.Identifier().text
            val signature = context.availableFunctions[funcName] ?: error("Aucune signature correspondante") // renvoit une erreur si on ne trouve pas la signature correspondant au nom
            // (ne devrait jamais arriver)

            context.currentFunction = signature
            context.clearLocals()

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
                MemoizedFunctionCompiler.compile(func.functionCodeBlock(), context)
            } else {
                val funcCompiler = FunctionCompiler(context)
                funcCompiler.visit(func.functionCodeBlock())
            }
        }
    }

    private fun modifiersHave(func: EuclinParser.FunctionDeclarationContext, modifier: String): Boolean {
        return func.modifiers().any { it.text == modifier }
    }

}