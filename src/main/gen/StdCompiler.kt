import euclin.compiler.EuclinCompiler
import java.io.File
import java.nio.charset.Charset

object StdCompiler {

    private val output = File(".", "runtime/std")
    private val stdFolder = File(".", "src/main/euclin/lang/")

    @JvmStatic fun main(args: Array<String>) {
        compileAllIn(stdFolder)
    }

    private fun compileAllIn(folder: File) {
        val list = folder.listFiles()
        for(file in list) {
            if(file.isDirectory) {
                compileAllIn(file)
            } else if(file.name.endsWith(".euclin")) {
                val filename = file.path.replace(stdFolder.path+File.separator, "")
                val results = EuclinCompiler.compile(read(file), filename, isApplication = false)
                for((className, compiledCode) in results) {
                    val destination = File(output, "${className.replace(".", File.separator)}.class")
                    if(!destination.parentFile.exists())
                        destination.parentFile.mkdirs()
                    destination.outputStream().use {
                        it.write(compiledCode)
                        it.flush()
                    }
                }
            }
        }
    }

    private fun read(file: File): String {
        return file.readText(Charset.forName("UTF-8"))
    }
}