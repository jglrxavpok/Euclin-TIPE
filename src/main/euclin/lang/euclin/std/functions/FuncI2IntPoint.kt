package euclin.std.functions

import euclin.std.RealPoint
import euclin.std.IntPoint
import euclin.std.UnitObject

interface FuncI2IntPoint {
    fun invoke(input: Int): IntPoint
}