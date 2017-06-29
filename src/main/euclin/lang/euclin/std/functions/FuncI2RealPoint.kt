package euclin.std.functions

import euclin.std.RealPoint
import euclin.std.IntPoint
import euclin.std.UnitObject

interface FuncI2RealPoint {
    fun invoke(input: Int): RealPoint
}