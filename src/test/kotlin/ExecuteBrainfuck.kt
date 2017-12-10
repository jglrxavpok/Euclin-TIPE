import TestBase.compileAndCheck
import euclin.compiler.EuclinCompiler
import euclin.intrisincs.EuclinApplication

object ExecuteBrainfuck : ExecuteTest() {

    @JvmStatic fun main(args: Array<String>) {
        compileAndCheck("Brainfuck")
        compileAndExecute("Brainfuck")
    }
}