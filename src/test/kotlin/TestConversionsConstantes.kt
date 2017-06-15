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


object TestConversionsConstantes {

    @JvmStatic fun main(args: Array<String>) {
        TestBase.compileAndCheck("TestConversionConstantesVersFonctions")
    }
}