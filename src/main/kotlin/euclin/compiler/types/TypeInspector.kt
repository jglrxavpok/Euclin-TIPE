package euclin.compiler.types

import euclin.compiler.Context
import euclin.compiler.TypedMember
import euclin.compiler.functions.FunctionSignature
import euclin.std.UnitObject
import euclin.std.points.Int32Point
import euclin.std.points.Int64Point
import euclin.std.points.Real32Point
import euclin.std.points.Real64Point
import org.jglr.inference.types.TypeDefinition
import org.objectweb.asm.ClassReader
import java.lang.reflect.Modifier

object TypeInspector {

    fun inspect(target: Class<*>, destination: TypeDefinition, context: Context): Unit {
        target.declaredFields.filter { Modifier.isPublic(it.modifiers) /* Le champ doit être publique */ }.forEach {
            val name = it.name
            val type = it.type

            val field = TypedMember(name, convert(type, context))
            val destinationList = if(Modifier.isStatic(it.modifiers)) destination.listStaticFields() else destination.listFields()
            if(field !in destinationList)
                destinationList += field
        }

        target.declaredMethods.filter { Modifier.isPublic(it.modifiers) /* La fonction doit être publique */ }.forEach {
            val name = it.name
            val args = it.parameters.map { TypedMember(it.name, convert(it.type, context)) }
            val returnType = it.returnType

            if(Modifier.isStatic(it.modifiers)) { // si c'est une fonction statique
                val function = FunctionSignature(name, args, convert(returnType, context), target.canonicalName, static = true)
                if(function !in destination.listStaticMethods())
                    destination.listStaticMethods() += function
            } else {
                val function = FunctionSignature(name, args, convert(returnType, context), target.canonicalName, static = false)
                if(function !in destination.listMethods()) {
                    destination.listMethods() += function
                }
            }
        }

        target.declaredConstructors.filter { Modifier.isPublic(it.modifiers) /* La fonction doit être publique */ }.forEach {
            val name = it.name
            val args = it.parameters.map { TypedMember(it.name, convert(it.type, context)) }

            val constructor = FunctionSignature(name, args, convert(Void.TYPE, context), target.canonicalName, static = false)
            if(constructor !in destination.listConstructors())
                destination.listConstructors() += constructor
        }
    }

    fun inspect(bytecode: ByteArray, destination: TypeDefinition, context: Context) {
        val reader = ClassReader(bytecode)
        reader.accept(TypeInspectorVisitor(destination, context), 0)
    }

    private fun convert(clazz: Class<*>, context: Context): TypeDefinition {
        // les '.java' sont importants, le test d'égalité échoue sinon
        return when(clazz) {
            Integer.TYPE -> Int32Type
            java.lang.Long.TYPE -> Int64Type
            java.lang.Boolean.TYPE -> BooleanType
            java.lang.Character.TYPE -> CharType
            java.lang.Float.TYPE -> Real32Type
            java.lang.Double.TYPE -> Real64Type
            java.lang.Short.TYPE -> Int16Type
            java.lang.Byte.TYPE -> Int8Type
            Int32Point::class.java -> Int32PointType
            Real32Point::class.java -> Real32PointType
            Int64Point::class.java -> Int64PointType
            Real64Point::class.java -> Real64PointType
            UnitObject::class.java -> UnitType
            Void.TYPE -> JVMVoid
            Unit::class.java -> JVMVoid
            Object::class.java -> WildcardType
            String::class.java -> StringType
            else -> {
                val known = context.knowsType(clazz.canonicalName)
                if(known)
                    return context.getTypeOrCreate(clazz.canonicalName)
                if(clazz.isArray) {
                    val elementType = convert(clazz.componentType, context)
                    val arrayType = ArrayType(elementType)
                    context.registerType(clazz.canonicalName, arrayType)
                    arrayType
                } else {
                    val basic = context.typeConverter.convertBasic(clazz.canonicalName)
                    inspect(clazz, basic, context)
                    basic
                }
            }
        }
    }
}