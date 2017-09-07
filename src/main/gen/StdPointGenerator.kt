import euclin.compiler.types.*
import org.jglr.inference.types.TypeDefinition
import java.io.File
import java.io.FileWriter

object StdPointGenerator {

    // FIXME Pas encore au point

    @JvmStatic fun main(args: Array<String>) {
        val types = mutableListOf(Real32Type, Real32PointType, Int32Type, Int32PointType, UnitType, StringType, BooleanType, WildcardType, Real64Type, Int16Type, CharType, Int8Type, Int64Type)

        val rootFolder = File("./src/main/euclin/lang/euclin/std/points/")
        rootFolder.mkdirs()
        for(argument in types) {
            for(returnType in types) {
                val name = argument.generateShortName() +"Point"
                val output = File(rootFolder, name+".kt")
                println("> ${output.path}")
                output.createNewFile()

                val argumentType = argument
                writeContents(output, name, argumentType)
            }
        }
    }

    private fun writeContents(output: File, name: String, argument: TypeDefinition) {
        val rawData = String(javaClass.getResourceAsStream("/generation/PointTemplate.txt").readBytes())
        FileWriter(output).use {
            val argumentStr = typeToKotlinType(argument)
            val content = rawData.replace("<Type>", argumentStr).replace("<Name>", name)
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