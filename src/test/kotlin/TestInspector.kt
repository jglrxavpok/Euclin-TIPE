import euclin.compiler.Context
import euclin.compiler.types.*
import euclin.std.Console
import euclin.std.IntPoint
import org.objectweb.asm.ClassWriter

object TestInspector {

    @JvmStatic fun main(args: Array<String>) {
        val consoleType = BasicType("euclin.std.Console")
        val context = Context("?", ClassWriter(0), hashMapOf())
        TypeInspector.inspect(Console::class.java, consoleType, context)

        println(consoleType.listFields())
        println(consoleType.listMethods())
        println(consoleType.listStaticMethods())

        TypeInspector.inspect(IntPoint::class.java, IntPointType, context)
        println(IntPointType.listFields())
        println(IntPointType.listMethods())
        println(IntPointType.listStaticMethods())

    }
}