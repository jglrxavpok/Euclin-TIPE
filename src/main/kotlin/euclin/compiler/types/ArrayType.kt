package euclin.compiler.types

import org.jglr.inference.types.TypeDefinition

class ArrayType(val elementType: TypeDefinition): TypeDefinition() {

    override fun toString(): String {
        return "[$elementType]"
    }

    override fun equals(other: Any?): Boolean {
        if(super.equals(other))
            return true
        if(other is ArrayType) {
            return elementType == other.elementType
        }
        return false
    }

    override fun compare(other: TypeDefinition, firstCall: Boolean): Int {
        if(other == this)
            return 0
        if(other is ArrayType) {
            return elementType.compareTo(other.elementType)
        }
        else if(firstCall)
            return -other.compare(this, firstCall = false)
        else
            throw IllegalArgumentException("Cannot compare $this and $other")
    }

    override fun hashCode(): Int {
        return 13 * elementType.hashCode()
    }
}