import euclin.compiler.EuclinCompiler
import euclin.intrisincs.EuclinApplication

object ExecuteHelloWorld: ExecuteTest() {

    @JvmStatic fun main(args: Array<String>) {
        compileAndExecute("HelloWorld")
    }
}