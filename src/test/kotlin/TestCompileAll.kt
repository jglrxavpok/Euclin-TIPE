import java.io.File

object TestCompileAll {

    @JvmStatic fun main(args: Array<String>) {
        val files = File(".", "/src/test/resources/").listFiles().filterNot { it.isDirectory }
        for(f in files) {
            TestBase.compileAndCheck(f.name.substringBeforeLast(".")) // on compile le fichier (son nom est le sous-String avant le dernier point, qui le sépare de l'extension)
        }
    }
}