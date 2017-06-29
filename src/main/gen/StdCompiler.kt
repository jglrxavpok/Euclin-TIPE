import euclin.compiler.EuclinCompiler
import java.io.File
import java.nio.charset.Charset

object StdCompiler {

    private val output = File(".", "runtime/std")

    @JvmStatic fun main(args: Array<String>) {
        val stdFolder = File(".", "src/main/euclin/lang/")
        compileAllIn(stdFolder)
    }

    private fun compileAllIn(folder: File) {
        val list = folder.listFiles()
        for(file in list) {
            if(file.isDirectory) {
                compileAllIn(file)
            } else if(file.name.endsWith(".euclin")) {
                val compiledCode = EuclinCompiler.compile(read(file), file.path)
                val destination = File(output, file.path)
                if(!destination.parentFile.exists())
                    destination.parentFile.mkdirs()
                destination.outputStream().use {
                    it.write(compiledCode)
                    it.flush()
                }
            }
        }
    }

    private fun read(file: File): String {
        return file.readText(Charset.forName("UTF-8"))
    }
}