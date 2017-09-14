package euclin.compiler

import euclin.compiler.types.toASM
import org.objectweb.asm.ClassWriter

class EuclinClassWriter: ClassWriter(ClassWriter.COMPUTE_FRAMES) {

    lateinit var context: Context

    override fun getCommonSuperClass(type1: String, type2: String): String {
        val typeA = context.getTypeOrCreate(type1)
        val typeB = context.getTypeOrCreate(type2)
        val result = context.translator.inferer.unify(typeA, typeB) // permet d'utiliser des types définis
        return result.toASM().internalName
    }

}