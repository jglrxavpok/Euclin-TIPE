package euclin.std.functions

import euclin.std.RealPoint
import euclin.std.IntPoint
import euclin.std.UnitObject

interface FuncUnitObject2IntPoint {
    fun invoke(input: UnitObject): IntPoint
}