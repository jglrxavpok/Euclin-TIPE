import euclin.intrisincs.MemoizationCache
import org.junit.Test

class TestMemoizationCache {

    @Test
    fun testSingleArgument() {
        val cache = MemoizationCache(1)
        cache.set(arrayOf("Testabc"), "Mon texte")

        assert(cache.has(arrayOf("Testabc"))) { "Le cache ne connait pas la clé donnée" }
        val cached = cache.get(arrayOf("Testabc"))
        assert(cached == "Mon texte") { "Le cache n'a pas la bonne valeur, la valeur est: $cached" }
    }

    @Test
    fun testMultipleArguments() {
        val cache = MemoizationCache(5)
        val args = arrayOf("Dzd", 45, Unit, TestMemoizationCache::class, this::testMultipleArguments)
        cache.set(args, "Mon texte")

        assert(cache.has(args)) { "Le cache ne connait pas la clé donnée" }
        val cached = cache.get(args)
        assert(cached == "Mon texte") { "Le cache n'a pas la bonne valeur, la valeur est: $cached" }
    }

    @Test(expected = AssertionError::class)
    fun invalidArgumentCount() {
        val cache = MemoizationCache(5)
        val args = arrayOf("Dzd")
        cache.set(args, "Mon texte")
    }
}