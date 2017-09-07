package euclin.intrisincs

class MemoizationCache(val argCount: Int) {

    private val mainMap = hashMapOf<Any, Any>()

    fun has(arguments: Array<out Any>): Boolean {
        var currentMap = mainMap
        for(i in 0 until (arguments.size-1)) {
            val arg = arguments[i]
            if( ! currentMap.containsKey(arg))
                return false
            currentMap = currentMap[arg] as HashMap<Any, Any>
        }
        return currentMap.containsKey(arguments[argCount-1])
    }

    @Suppress("UNCHECKED_CAST")
    fun get(arguments: Array<out Any>): Any? {
        assert(arguments.size == argCount)
        var currentMap = mainMap
        (0 until (arguments.size-1))
                .map { arguments[it] }
                .forEach { currentMap = currentMap[it] as HashMap<Any, Any> }
        return currentMap[arguments[argCount-1]]
    }

    fun set(arguments: Array<out Any>, value: Any) {
        assert(arguments.size == argCount)
        var currentMap = mainMap
        for(i in 0 until (arguments.size-1)) {
            val arg = arguments[i]
            if( ! currentMap.containsKey(arg)) {
                currentMap[arg] = hashMapOf<Any, Any>()
            }
            currentMap = currentMap[arg] as HashMap<Any, Any>
        }
        currentMap[arguments[argCount-1]] = value
    }
}