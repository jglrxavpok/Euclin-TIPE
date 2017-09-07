package euclin.compiler

fun String.shortenType(): String {
    return substringAfterLast("/").substringBeforeLast(";") // on prend le dernier morceau et on retire le point-virgule
}

/**
 * Convertit un nom 'plat (eg. euclin.std.Math) en nom interne pour la JVM (eg. euclin/std/Math)
 */
fun String.toInternalName(): String {
    return replace(".", "/")
}