import euclin.compiler.types.*
import euclin.std.Console
import euclin.std.IntPoint

object TestInspector {

    @JvmStatic fun main(args: Array<String>) {
        val consoleType = BasicType("euclin.std.Console")
        TypeInspector.inspect(Console::class.java, consoleType)

        println(consoleType.listFields())
        println(consoleType.listMethods())
        println(consoleType.listStaticMethods())

        TypeInspector.inspect(IntPoint::class.java, IntPointType)
        println(IntPointType.listFields())
        println(IntPointType.listMethods())
        println(IntPointType.listStaticMethods())

    }
}