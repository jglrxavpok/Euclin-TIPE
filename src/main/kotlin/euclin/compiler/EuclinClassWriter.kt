package euclin.compiler

import euclin.compiler.types.basicType
import org.objectweb.asm.ClassWriter
import java.lang.reflect.Field

class EuclinClassWriter(): ClassWriter(ClassWriter.COMPUTE_FRAMES) {

    lateinit var context: Context

    override fun getCommonSuperClass(type1: String, type2: String): String {
        val typeA = context.type(type1)
        val typeB = context.type(type2)
        val result = context.translator.inferer.unify(typeA, typeB)
        return basicType(result).internalName
    }



}