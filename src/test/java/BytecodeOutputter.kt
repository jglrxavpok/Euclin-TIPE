import org.objectweb.asm.ClassReader
import org.objectweb.asm.util.TraceClassVisitor
import java.io.File
import java.io.FileInputStream
import java.io.PrintWriter

object BytecodeOutputter {

    @JvmStatic fun main(args: Array<String>) {
        val data = FileInputStream(File(".",  "build/classes/test/TestBytecode.class")).use { it.readBytes() }
        val reader = ClassReader(data)
        reader.accept(TraceClassVisitor(PrintWriter(System.out)), 0)
    }
}