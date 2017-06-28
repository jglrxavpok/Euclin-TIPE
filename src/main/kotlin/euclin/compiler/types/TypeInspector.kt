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
        target.declaredFields.filter { Modifier.isPublic(it.modifiers) /* Le champ doit être publique */ }.forEach {
            val name = it.name
            val type = it.type

            destination.listFields() += TypedMember(name, convert(type))
        }

        target.declaredMethods.filter { Modifier.isPublic(it.modifiers) /* La fonction doit être publique */ }.forEach {
            val name = it.name
            val args = it.parameters.map { TypedMember(it.name, convert(it.type)) }
            val returnType = it.returnType

            if(Modifier.isStatic(it.modifiers)) { // si c'est une fonction statique
                destination.listStaticMethods() += FunctionSignature(name, args, convert(returnType), target.canonicalName, static = true)
            } else {
                destination.listMethods() += FunctionSignature(name, args, convert(returnType), target.canonicalName, static = false)
            }
        }
    }

    private fun convert(clazz: Class<*>): TypeDefinition {
        // les '.java' sont importants, le test d'égalité échoue sinon
        return when(clazz) {
            Integer.TYPE -> IntType
            java.lang.Float.TYPE -> RealType
            IntPoint::class.java -> IntPointType
            RealPoint::class.java -> RealPointType
            UnitObject::class.java -> UnitType
            Void.TYPE -> JVMVoid
            Unit::class.java -> JVMVoid
            else -> BasicType(clazz.canonicalName)
        }
    }
}