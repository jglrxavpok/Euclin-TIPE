import euclin.compiler.types.*
import org.jglr.inference.types.FunctionType
import org.jglr.inference.types.TypeDefinition
import euclin.compiler.types.basicType
import java.io.File
import java.io.FileWriter

object StdFunctionGenerator {

    @JvmStatic fun main(args: Array<String>) {
        val types = mutableListOf(RealType, RealPointType, IntType, IntPointType, UnitType, StringType, BooleanType, WildcardType, DoubleType, ShortType, CharType, ByteType, LongType)

        val rootFolder = File("./src/main/euclin/lang/euclin/std/functions")
        rootFolder.mkdirs()
        for(argument in types) {
            for(returnType in types) {
                val funcType = FunctionType(argument, returnType)
                val correspondingType = basicType(FunctionType(argument, returnType)).internalName
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
            RealType -> "Float"
            IntType -> "Int"
            RealPointType -> "RealPoint"
            IntPointType -> "IntPoint"
            UnitType -> "UnitObject"
            BooleanType -> "Boolean"
            WildcardType -> "Object"
            LongType -> "Long"
            CharType -> "Char"
            ByteType -> "Byte"
            ShortType -> "Short"
            DoubleType -> "Double"
            else -> type.toString().substringAfterLast(".")
        }
    }
}