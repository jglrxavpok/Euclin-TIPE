package euclin.std.functions

import euclin.std.RealPoint
import euclin.std.IntPoint
import euclin.std.UnitObject

interface FuncString2RealPoint {
    fun invoke(input: String): RealPoint
}