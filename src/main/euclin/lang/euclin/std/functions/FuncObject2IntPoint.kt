package euclin.std.functions

import euclin.std.RealPoint
import euclin.std.IntPoint
import euclin.std.UnitObject

interface FuncObject2IntPoint {
    fun invoke(input: Object): IntPoint
}