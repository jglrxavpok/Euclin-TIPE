package euclin.std.functions

import euclin.std.points.RealPoint
import euclin.std.points.IntPoint
import euclin.std.UnitObject

interface FuncF2S {
    @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
    fun invoke(input: Float): Short
}