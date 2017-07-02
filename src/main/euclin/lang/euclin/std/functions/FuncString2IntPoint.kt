package euclin.std.functions

import euclin.std.RealPoint
import euclin.std.IntPoint
import euclin.std.UnitObject

interface FuncString2IntPoint {
    fun invoke(input: String): IntPoint
}