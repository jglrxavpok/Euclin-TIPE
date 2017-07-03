import euclin.compiler.types.*
import org.jglr.inference.types.FunctionType
import org.jglr.inference.types.TypeDefinition
import euclin.compiler.types.basicType
import java.io.File
import java.io.FileWriter

object StdFunctionGenerator {

    @JvmStatic fun main(args: Array<String>) {
        val types = mutableListOf(Real32Type, Real32PointType, Real64Type, Real64PointType, Int32Type, Int32PointType, Int64PointType, UnitType, StringType, BooleanType, WildcardType, Real64Type, Int16Type, CharType, Int8Type, Int64Type)

        val rootFolder = File("./src/main/euclin/lang/euclin/std/functions")
        rootFolder.mkdirs()
        for(argument in types) {
            for(returnType in types) {
                val funcType = FunctionType(argument, returnType)
                val correspondingType = basicType(funcType).internalName
                val name = correspondingType.substringAfterLast("/")
                val output = File(rootFolder, name+".kt")
                println("> ${output.path}")
                output.createNewFile()

                val argumentType = funcType.argumentType
                val returnTypeStr = funcType.returnType
                writeContents(output, name, argumentType, returnTypeStr)
            }
        }
    }

    private fun writeContents(output: File, name: String, argument: TypeDefinition, returnType: TypeDefinition) {
        val rawData = String(javaClass.getResourceAsStream("/generation/FunctionTemplate.txt").readBytes())
        FileWriter(output).use {
            val argumentStr = typeToKotlinType(argument)
            val returnTypeStr = typeToKotlinType(returnType)
            val content = rawData.replace("<Args>", argumentStr).replace("<Return>", returnTypeStr).replace("<Name>", name)
            it.write(content)
            it.flush()
        }
    }

    private fun typeToKotlinType(type: TypeDefinition): String {
        return when(type) {
            Real32Type -> "Float"
            Int32Type -> "Int"
            Real32PointType -> "Real32Point"
            Int32PointType -> "Int32Point"
            Real64PointType -> "Real64Point"
            Int64PointType -> "Int64Point"
            UnitType -> "UnitObject"
            BooleanType -> "Boolean"
            WildcardType -> "Object"
            Int64Type -> "Long"
            CharType -> "Char"
            Int8Type -> "Byte"
            Int16Type -> "Short"
            Real64Type -> "Double"
            else -> type.toString().substringAfterLast(".")
        }
    }
}