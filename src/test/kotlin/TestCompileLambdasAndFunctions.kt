import org.jglrxavpok.euclin.EuclinCompiler
import org.junit.Assert.assertTrue
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.util.CheckClassAdapter
import org.objectweb.asm.util.TraceClassVisitor
import java.io.File
import java.io.FileOutputStream
import java.io.PrintWriter
import java.io.StringWriter


object TestCompileLambdasAndFunctions {

    @JvmStatic fun main(args: Array<String>) {
        val sourceCode = javaClass.getResourceAsStream("/TestLambdas.euclin").bufferedReader().use { it.readText() } // ferme le flux après
        val data = EuclinCompiler.compile(sourceCode, "TestLambdas.euclin")

        FileOutputStream(File("runtime/tests", "TestLambdas.class")).use {
            it.write(data)
            it.flush()
            it.close()
        }

        val reader = ClassReader(data)
        val cw = ClassWriter(reader, ClassWriter.COMPUTE_MAXS)
        val cv = CheckClassAdapter(cw)
        reader.accept(cv, 0)

        // Permet de vérifier que le code généré est valide
        val sw = StringWriter()
        val pw = PrintWriter(sw)
        CheckClassAdapter.verify(ClassReader(cw.toByteArray()), true, pw)
        println(sw.toString())
        reader.accept(TraceClassVisitor(PrintWriter(System.out)), 0)
    }
}