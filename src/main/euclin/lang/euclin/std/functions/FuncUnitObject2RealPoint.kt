package euclin.std.functions

import euclin.std.points.RealPoint
import euclin.std.points.IntPoint
import euclin.std.UnitObject

interface FuncUnitObject2RealPoint {
    @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
    fun invoke(input: UnitObject): RealPoint
}