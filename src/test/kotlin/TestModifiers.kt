import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import euclin.compiler.grammar.EuclinLexer
import euclin.compiler.grammar.EuclinParser
import org.junit.Test

class TestModifiers {

    @Test
    fun testPure() {
        val declaration = parser("TestFoncModifiers").functionDeclaration()

    }

    private fun parser(file: String): EuclinParser {
        val sourceCode = javaClass.getResourceAsStream("/$file.euclin").bufferedReader().use { it.readText() } // ferme le flux après
        val lexer = EuclinLexer(CharStreams.fromString(sourceCode, file+".euclin"))
        return EuclinParser(CommonTokenStream(lexer))
    }
}