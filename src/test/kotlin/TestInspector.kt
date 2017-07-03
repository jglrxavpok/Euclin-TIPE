import euclin.compiler.Context
import euclin.compiler.types.*
import euclin.std.Console
import euclin.std.points.Int64Point
import org.objectweb.asm.ClassWriter

object TestInspector {

    @JvmStatic fun main(args: Array<String>) {
        val consoleType = BasicType("euclin.std.Console")
        val context = Context("?", ClassWriter(0), hashMapOf())
        TypeInspector.inspect(Console::class.java, consoleType, context)

        println(consoleType.listFields())
        println(consoleType.listMethods())
        println(consoleType.listStaticMethods())

        TypeInspector.inspect(Int64Point::class.java, Int64PointType, context)
        println(Int64PointType.listFields())
        println(Int64PointType.listMethods())
        println(Int64PointType.listStaticMethods())

    }
}