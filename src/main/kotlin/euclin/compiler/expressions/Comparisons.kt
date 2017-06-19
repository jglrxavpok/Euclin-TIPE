package euclin.compiler.expressions

import euclin.compiler.types.BooleanType
import org.jglr.inference.expressions.Expression
import org.jglr.inference.types.TypeDefinition

open class ComparisonExpression(val left: Expression, val right: Expression, val operator: String): Expression() {
    override val stringRepresentation: String
        get() = "$left $operator $right"

    // Toujours un booléen!
    override var type: TypeDefinition
        get() = BooleanType
        set(value) {}
}

class LessThan(left: Expression, right: Expression): ComparisonExpression(left, right, "<")
class LessEqualThan(left: Expression, right: Expression): ComparisonExpression(left, right, "<=")
class GreaterThan(left: Expression, right: Expression): ComparisonExpression(left, right, ">")
class GreaterEqualThan(left: Expression, right: Expression): ComparisonExpression(left, right, ">=")
class EqualTo(left: Expression, right: Expression): ComparisonExpression(left, right, "==")
class DifferentFrom(left: Expression, right: Expression): ComparisonExpression(left, right, "!=")