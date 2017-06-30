import euclin.compiler.EuclinCompiler
import euclin.intrisincs.EuclinApplication

open class ExecuteTest {

    fun compileAndExecute(name: String) {
        val sourceCode = javaClass.getResourceAsStream("/$name.euclin").bufferedReader().use { it.readText() } // ferme le flux après
        val className = "${name}Application"
        val data = EuclinCompiler.compile(sourceCode, "$name.euclin")[className]!!

        // on cherche la méthode dans ClassLoader pour charger une classe
        val defineClass = ClassLoader::class.java.getDeclaredMethod("defineClass", String::class.java, ByteArray::class.java, Integer.TYPE, Integer.TYPE)
        defineClass.isAccessible = true // on se donne les droits d'accès
        defineClass(this.javaClass.classLoader, className, data, 0, data.size) // on définit la classe

        // on charge la classe, on crée une instance et on appelle la méthode principale
        val clazz = Class.forName(className)
        val app = clazz.newInstance() as EuclinApplication
        app._main()
    }
}