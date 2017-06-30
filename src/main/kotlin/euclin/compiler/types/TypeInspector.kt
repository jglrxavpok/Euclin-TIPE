package euclin.compiler.types

import euclin.compiler.Context
import euclin.compiler.TypedMember
import euclin.compiler.functions.FunctionSignature
import euclin.std.IntPoint
import euclin.std.RealPoint
import euclin.std.UnitObject
import org.jglr.inference.types.TypeDefinition
import org.objectweb.asm.ClassReader
import java.lang.reflect.Modifier

object TypeInspector {

    fun inspect(target: Class<*>, destination: TypeDefinition, context: Context): Unit {
        target.declaredFields.filter { Modifier.isPublic(it.modifiers) /* Le champ doit être publique */ }.forEach {
            val name = it.name
            val type = it.type

            destination.listFields() += TypedMember(name, convert(type, context))
        }

        target.declaredMethods.filter { Modifier.isPublic(it.modifiers) /* La fonction doit être publique */ }.forEach {
            val name = it.name
            val args = it.parameters.map { TypedMember(it.name, convert(it.type, context)) }
            val returnType = it.returnType

            if(Modifier.isStatic(it.modifiers)) { // si c'est une fonction statique
                destination.listStaticMethods() += FunctionSignature(name, args, convert(returnType, context), target.canonicalName, static = true)
            } else {
                destination.listMethods() += FunctionSignature(name, args, convert(returnType, context), target.canonicalName, static = false)
            }
        }

        target.declaredConstructors.filter { Modifier.isPublic(it.modifiers) /* La fonction doit être publique */ }.forEach {
            val name = it.name
            val args = it.parameters.map { TypedMember(it.name, convert(it.type, context)) }

            destination.listConstructors() += FunctionSignature(name, args, convert(Void.TYPE, context), target.canonicalName, static = false)
        }
    }

    fun inspect(bytecode: ByteArray, destination: TypeDefinition, context: Context) {
        val reader = ClassReader(bytecode)
        reader.accept(TypeInspectorVisitor(destination, context), 0)
    }

    private fun convert(clazz: Class<*>, context: Context): TypeDefinition {
        // les '.java' sont importants, le test d'égalité échoue sinon
        return when(clazz) {
            Integer.TYPE -> IntType
            java.lang.Boolean.TYPE -> BooleanType
            java.lang.Float.TYPE -> RealType
            IntPoint::class.java -> IntPointType
            RealPoint::class.java -> RealPointType
            UnitObject::class.java -> UnitType
            Void.TYPE -> JVMVoid
            Unit::class.java -> JVMVoid
            Object::class.java -> WildcardType
            String::class.java -> StringType
            else -> {
                val known = context.knowsType(clazz.canonicalName)
                val basic = context.typeConverter.convertBasic(clazz.canonicalName)
                if( ! known) {
                    inspect(clazz, basic, context)
                }
                basic
            }
        }
    }
}