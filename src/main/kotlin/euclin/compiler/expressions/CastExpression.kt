package euclin.compiler.expressions

import org.jglr.inference.expressions.Expression
import org.jglr.inference.types.TypeDefinition

/**
 * Représente un cast d'une expression
 */
class CastExpression(val expression: Expression, val castedTo: TypeDefinition): Expression() {
    override val stringRepresentation: String
        get() = "$expression <- $castedTo"

    override var type: TypeDefinition
        get() = castedTo
        set(value) {}
}