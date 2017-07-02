package euclin.std.functions

import euclin.std.RealPoint
import euclin.std.IntPoint
import euclin.std.UnitObject

interface Func_FF_2B {
    @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
    fun invoke(input: RealPoint): Byte
}