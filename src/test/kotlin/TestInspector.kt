import euclin.compiler.types.*
import euclin.std.Console

object TestInspector {

    @JvmStatic fun main(args: Array<String>) {
        val consoleType = BasicType("euclin.std.Console")
        TypeInspector.inspect(Console::class.java, consoleType)

        println(consoleType.listFields())
        println(consoleType.listMethods())
        println(consoleType.listStaticMethods())
    }
}