package euclin.compiler

import euclin.compiler.functions.*
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.jglr.inference.types.FunctionType
import euclin.compiler.grammar.EuclinLexer
import euclin.compiler.grammar.EuclinParser
import euclin.compiler.types.*
import euclin.intrisincs.EuclinApplication
import euclin.intrisincs.MemoizationCache
import euclin.std.*
import euclin.std.points.Int32Point
import euclin.std.points.Int64Point
import euclin.std.points.Real32Point
import euclin.std.points.Real64Point
import org.antlr.v4.runtime.tree.TerminalNode
import org.jglr.inference.types.TypeDefinition
import org.objectweb.asm.Opcodes.*
import java.io.File
import java.io.FileInputStream

object EuclinCompiler {

    val OBJECT_TYPE: ASMType = ASMType.getType(Object::class.java)
    var stdLocation = File("runtime/std")

    fun compile(sourceCode: String, filename: String, isApplication: Boolean = true, sourceRoot: File = File(".")): Map<String, ByteArray> {
        val startTime = System.nanoTime()

        // Inspection de la librairie standard

        // création du lexer et du parser
        val lexer = EuclinLexer(CharStreams.fromString(sourceCode, filename))
        val parser = EuclinParser(CommonTokenStream(lexer))

        val code = parser.codeBlock() // on récupère le corps du code

        val className = filename.substringBefore(".").replace(File.separator, ".")+ if(isApplication) "Application" else "" // dernier fichier du chemin et on retire l'extension
        val inputFolder = filename.substringBeforeLast(File.separator)
        val classWriter = EuclinClassWriter() // laisse ASM générer les frames et maxs
        val classType = ASMType.getObjectType(className.replace(".", "/"))
        val interfaces = if(isApplication) arrayOf("euclin/intrisincs/EuclinApplication") else emptyArray()
        classWriter.visit(V1_8, ACC_PUBLIC, classType.internalName, null, OBJECT_TYPE.internalName, interfaces)

        val context = Context(className, classWriter, hashMapOf())
        inspectStandardLibrary(context)
        classWriter.context = context
        resolveImports(code, context, listOf(stdLocation, sourceRoot))
        val structures = StructureCompiler(context).compileStructs(code, inputFolder)
        val functionGatherer = FunctionGatherer(context)

        // on récupère la liste des signatures (ou têtes) de fonctions présentes dans le code
        val functions = functionGatherer.gather(code).toMutableMap()

        // on y ajoute les fonctions de la bibliothèque standard
        addStandardFunctions(functions)
        context.availableFunctions.putAll(functions)

        // on génére le code des lambda-fonctions

        // on génére la fonction principale
        val mainFunctionName = if(isApplication) "_main" else "_init"
        val mainSignature = FunctionSignature(mainFunctionName, emptyList(), JVMVoid, className, static = ! isApplication)
        context.currentFunction = mainSignature
        val mainCompiler = MainFunctionCompiler(context.clearLocals())
        mainCompiler.compileMainFunction(code)

        // on génére les fonctions
        compileFunctions(code, context)

        // on génère un constructeur basique
        if(isApplication) {
            val constructor = classWriter.visitMethod(ACC_PUBLIC, "<init>", "()V", null, emptyArray())
            with(constructor) {
                visitCode()
                visitVarInsn(ALOAD, 0) // load 'this'
                visitMethodInsn(INVOKESPECIAL, OBJECT_TYPE.internalName, "<init>", "()V", false) // 'super.<init>()'
                visitInsn(RETURN)
                visitMaxs(0,0)
                visitEnd()
            }
        }


        if(!isApplication) {
            context.staticInit += {
                visitMethodInsn(INVOKESTATIC, className.toInternalName(), "_init", "()V", false)
            }
        }
        context.createStaticBlock()

        classWriter.visitEnd()
        val endTime = System.nanoTime()
        val elapsedTime = (endTime - startTime) / 1000000.0f
        println("Compiled $filename in $elapsedTime ms")
        return structures + (className to classWriter.toByteArray())
    }

    /**
     * Ordre:
     * 1. 'Classpath'
     * 2. On tente de charger depuis le classpath du compileur
     */
    private fun resolveImports(code: EuclinParser.CodeBlockContext, context: Context, classpath: List<File>) {
        code.instructions().filterIsInstance<EuclinParser.ImportInstructionContext>().map(EuclinParser.ImportInstructionContext::importDeclaration).forEach {
            val importedName = it.Identifier().map(TerminalNode::getText).reduce { acc, s -> acc+"."+s }
            val isRenamed = it.renamming() != null
            val usageName = if(isRenamed) it.renamming().Identifier().text else it.Identifier().last().text
            importIfNecessary(importedName, usageName, classpath, context)
        }

        code.instructions().filterIsInstance<EuclinParser.ImportMethodInstructionContext>()
                .map(EuclinParser.ImportMethodInstructionContext::methodImportDeclaration)
                .forEach {
            if(it is EuclinParser.BasicMethodImportContext) {
                val importedName = it.Identifier().map(TerminalNode::getText).reduce { acc, s -> acc+"."+s }
                val isRenamed = it.renamming() != null
                val funcName = it.Identifier().last().text
                val usageName = if(isRenamed) it.renamming().Identifier().text else funcName
                val owner = importedName.substringBeforeLast(".")
                val type = importIfNecessary(owner, owner, classpath, context)

                val actualFunction = type.listStaticMethods().find { it.name == funcName }
                if(actualFunction != null) {
                    context.availableFunctions[usageName] = actualFunction
                } else {
                    compileError("Aucune fonction du nom de $funcName dans le type $type", context.currentClass, it)
                }

            } else if(it is EuclinParser.ImportAllMethodsContext) {
                val importedName = it.Identifier().map(TerminalNode::getText).reduce { acc, s -> acc+"."+s }
                val type = importIfNecessary(importedName, importedName, classpath, context)
                type.listStaticMethods().forEach {
                    context.availableFunctions[it.name] = it
                }
            }
        }
    }

    /**
     * Importe et charges le type correspondant (si présent dans le classpath)
     */
    private fun importIfNecessary(importedName: String, usageName: String, classpath: List<File>, context: Context): TypeDefinition {
        if(context.knowsType(usageName))
            return context.type(usageName)
        val destination = ObjectType(importedName, WildcardType)
        var found = false
        for(c in classpath) {
            val candidate = File(c, importedName.replace(".", File.separator)+".class")
            if(candidate.exists()) {
                found = true
                val data = FileInputStream(candidate).buffered().use { it.readBytes() }
                TypeInspector.inspect(data, destination, context)
                break
            }
        }

        if( ! found) {
            try {
                val c = Class.forName(importedName)
                TypeInspector.inspect(c, destination, context)
                found = true
            } catch (e: ClassNotFoundException) {
                compileError("Aucun fichier correspondant trouvé pour $importedName", -1, context.currentClass)
            }
        }

        if(found) {
            context.registerType(importedName, destination)
            context.importType(usageName, destination)
        }
        return destination
    }

    private fun inspectStandardLibrary(context: Context) {
        // TODO: + de classes?
        TypeInspector.inspect(Int32Point::class.java, Int32PointType, context)
        TypeInspector.inspect(Real32Point::class.java, Real32PointType, context)
        TypeInspector.inspect(Int64Point::class.java, Int64PointType, context)
        TypeInspector.inspect(Real64Point::class.java, Real64PointType, context)

        TypeInspector.inspect(UnitObject::class.java, UnitType, context)
        TypeInspector.inspect(String::class.java, StringType, context)
        TypeInspector.inspect(Console::class.java, BasicType("euclin.std.Console"), context)
        TypeInspector.inspect(MathFunctions::class.java, BasicType("euclin.std.MathFunctions"), context)
        TypeInspector.inspect(EuclinApplication::class.java, BasicType("euclin.intrisincs.EuclinApplication"), context)
        TypeInspector.inspect(MemoizationCache::class.java, BasicType("euclin.intrisincs.MemoizationCache"), context)
    }

    private fun addStandardFunctions(functions: MutableMap<String, FunctionSignature>) {
        val circleFunction = FunctionSignature("circle", listOf(
                TypedMember("center", FunctionType(Real64Type, Real64PointType)),
                TypedMember("radius", FunctionType(Real64Type, Real64Type))
        ), ObjectType("Circle", ShapeType), "euclin.std.Geometry", static = true)

        val sin32Function = FunctionSignature("sin32", listOf(
                TypedMember("angle", Real32Type)
        ), Real32Type, "euclin.std.MathFunctions", static = true)

        val cos32Function = FunctionSignature("cos32", listOf(
                TypedMember("angle", Real32Type)
        ), Real32Type, "euclin.std.MathFunctions", static = true)

        val tan32Function = FunctionSignature("tan32", listOf(
                TypedMember("angle", Real32Type)
        ), Real32Type, "euclin.std.MathFunctions", static = true)

        val sinFunction = FunctionSignature("sin", listOf(
                TypedMember("angle", Real64Type)
        ), Real64Type, "java.lang.Math", static = true)

        val cosFunction = FunctionSignature("cos", listOf(
                TypedMember("angle", Real64Type)
        ), Real64Type, "java.lang.Math", static = true)

        val tanFunction = FunctionSignature("tan", listOf(
                TypedMember("angle", Real64Type)
        ), Real64Type, "java.lang.Math", static = true)

        val writeFunction = FunctionSignature("write", listOf(
                TypedMember("text", StringType)
        ), JVMVoid, "euclin.std.Console", static = true)

        val writelnFunction = FunctionSignature("writeln", listOf(
                TypedMember("text", StringType)
        ), JVMVoid, "euclin.std.Console", static = true)

        functions["sin"] = sinFunction
        functions["cos"] = cosFunction
        functions["tan"] = tanFunction
        functions["sin32"] = sin32Function
        functions["cos32"] = cos32Function
        functions["tan32"] = tan32Function
        functions["circle"] = circleFunction
        functions["write"] = writeFunction
        functions["writeln"] = writelnFunction
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