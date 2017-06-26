package euclin.compiler.types

import euclin.compiler.TypedMember
import euclin.compiler.functions.FunctionSignature
import euclin.std.IntPoint
import euclin.std.RealPoint
import euclin.std.UnitObject
import org.jglr.inference.types.TypeDefinition
import java.lang.reflect.Modifier

object TypeInspector {

    fun inspect(target: Class<*>, destination: TypeDefinition): Unit {
        target.declaredFields.filter { it.modifiers and Modifier.PUBLIC == 1 /* Le champ doit être publique */ }.forEach {
            val name = it.name
            val type = it.type

            destination.listFields() += TypedMember(name, convert(type))
        }

        target.declaredMethods.filter { it.modifiers and Modifier.PUBLIC == 1 /* La fonction doit être publique */ }.forEach {
            val name = it.name
            val args = it.parameterTypes.map { TypedMember(it.name, convert(it)) }
            val returnType = it.returnType

            if(it.modifiers and Modifier.STATIC == 1) { // si c'est pas une fonction statique
                destination.listMethods() += FunctionSignature(name, args, convert(returnType), target.canonicalName)
            } else {
                destination.listStaticMethods() += FunctionSignature(name, args, convert(returnType), target.canonicalName)
            }
        }
    }

    private fun convert(clazz: Class<*>): TypeDefinition {
        return when(clazz) {
            Integer.TYPE -> IntType
            java.lang.Float.TYPE -> RealType
            IntPoint::class -> IntPointType
            RealPoint::class -> RealPointType
            UnitObject::class -> UnitType
            Void.TYPE -> JVMVoid
            Unit::class -> JVMVoid
            else -> BasicType(clazz.canonicalName)
        }
    }
}