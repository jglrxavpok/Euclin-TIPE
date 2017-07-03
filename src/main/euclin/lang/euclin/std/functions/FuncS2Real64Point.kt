package euclin.std.functions

import euclin.std.points.Real64Point
import euclin.std.points.Int64Point
import euclin.std.points.Real32Point
import euclin.std.points.Int32Point
import euclin.std.UnitObject

interface FuncS2Real64Point {
    @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
    fun invoke(input: Short): Real64Point
}