package euclin.std.functions

import euclin.std.RealPoint
import euclin.std.IntPoint
import euclin.std.UnitObject

interface FuncS2J {
    @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
    fun invoke(input: Short): Long
}