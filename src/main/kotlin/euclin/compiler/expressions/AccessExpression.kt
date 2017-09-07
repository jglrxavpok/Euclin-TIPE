package euclin.compiler.expressions

import org.jglr.inference.expressions.Expression

class AccessExpression(val parent: Expression, val name: String): Expression() {
    override val stringRepresentation: String
        get() = "${parent.stringRepresentation}.$name"
}