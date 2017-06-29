package euclin.std.functions

import euclin.std.RealPoint
import euclin.std.IntPoint
import euclin.std.UnitObject

interface Func_FF_2RealPoint {
    fun invoke(input: RealPoint): RealPoint
}