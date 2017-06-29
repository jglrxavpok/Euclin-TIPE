import euclin.compiler.EuclinCompiler
import euclin.intrisincs.EuclinApplication

object ExecuteHelloWorld {

    @JvmStatic fun main(args: Array<String>) {
        val sourceCode = javaClass.getResourceAsStream("/HelloWorld.euclin").bufferedReader().use { it.readText() } // ferme le flux après
        val data = EuclinCompiler.compile(sourceCode, "HelloWorld.euclin")

        // on cherche la méthode dans ClassLoader pour charger une classe
        val defineClass = ClassLoader::class.java.getDeclaredMethod("defineClass", String::class.java, ByteArray::class.java, Integer.TYPE, Integer.TYPE)
        defineClass.isAccessible = true // on se donne les droits d'accès
        defineClass(this.javaClass.classLoader, "HelloWorld", data, 0, data.size) // on définit la classe

        // on charge la classe, on crée une instance et on appelle la méthode principale
        val clazz = Class.forName("HelloWorld")
        val app = clazz.newInstance() as EuclinApplication
        app.__main()
    }
}