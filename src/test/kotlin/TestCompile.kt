import org.jglrxavpok.euclin.EuclinCompiler
import org.objectweb.asm.ClassReader
import org.objectweb.asm.util.TraceClassVisitor
import java.io.File
import java.io.FileOutputStream
import java.io.PrintWriter


object TestCompile {

    @JvmStatic fun main(args: Array<String>) {
        val sourceCode = javaClass.getResourceAsStream("/Test.euclin").bufferedReader().use { it.readText() } // ferme le flux après
        val data = EuclinCompiler.compile(sourceCode, "Test.euclin")

        FileOutputStream(File("runtime/tests", "TestEuclin.class")).use {
            it.write(data)
            it.flush()
            it.close()
        }

        val reader = ClassReader(data)
        reader.accept(TraceClassVisitor(PrintWriter(System.out)), 0)
    }
}