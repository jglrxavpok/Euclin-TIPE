package euclin.compiler.functions

import euclin.compiler.TypedMember
import euclin.compiler.toInternalName
import euclin.compiler.types.methodType
import org.jglr.inference.types.FunctionType
import org.jglr.inference.types.TupleType
import org.jglr.inference.types.TypeDefinition
import org.objectweb.asm.Handle
import org.objectweb.asm.Opcodes

// Définit la signature d'une fonction (nom, arguments, type de retour, la classe dans laquelle elle est et sa pureté)
class FunctionSignature(val name: String, val arguments: List<TypedMember>, val returnType: TypeDefinition, val ownerClass: String, val static: Boolean) {

    fun toType(): TypeDefinition {
        if(arguments.size == 1)
            return FunctionType(arguments[0].type, returnType)
        return FunctionType(TupleType(arguments.map { it.type }.toTypedArray()), returnType)
    }

    fun toHandle(): Handle {
        return Handle(if(static) Opcodes.H_INVOKESTATIC else Opcodes.H_INVOKEVIRTUAL, ownerClass.toInternalName(), name, methodType(arguments, returnType).descriptor)
    }

    override fun equals(other: Any?): Boolean {
        if(other is FunctionSignature)
            return name == other.name && areListEqual(arguments, other.arguments) && returnType == other.returnType && ownerClass == other.ownerClass && static == other.static && pure == other.pure
        return super.equals(other)
    }

    private fun <T> areListEqual(listA: List<T>, listB: List<T>): Boolean {
        if(listA.size != listB.size)
            return false
        listA.forEachIndexed { index, elem -> if(elem != listB[index]) return false }
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        for(elem in arguments)
            result = 31 * result + elem.hashCode()
        result = 31 * result + returnType.hashCode()
        result = 31 * result + ownerClass.hashCode()
        result = 31 * result + static.hashCode()
        result = 31 * result + pure.hashCode()
        return result
    }

    var pure: Boolean = false
}