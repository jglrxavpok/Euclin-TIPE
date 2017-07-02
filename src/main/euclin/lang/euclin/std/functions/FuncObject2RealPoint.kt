package euclin.std.functions

import euclin.std.RealPoint
import euclin.std.IntPoint
import euclin.std.UnitObject

interface FuncObject2RealPoint {
    fun invoke(input: Object): RealPoint
}