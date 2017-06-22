package euclin.compiler.functions

import euclin.compiler.compileError
import euclin.compiler.expressions.ExpressionTranslator
import euclin.compiler.grammar.EuclinBaseVisitor
import euclin.compiler.grammar.EuclinParser

class FunctionMatcher(val availableFunctions: Map<String, FunctionSignature>, val translator: ExpressionTranslator): EuclinBaseVisitor<FunctionSignature>() {

    override fun visitDirectFunctionIdentifier(ctx: EuclinParser.DirectFunctionIdentifierContext): FunctionSignature {
        val name = ctx.Identifier().text
        val signature = availableFunctions[name] ?: compileError("Pas de fonction trouvée avec le nom $name", "?", ctx)
        return signature
    }

    override fun visitMemberFunctionIdentifier(ctx: EuclinParser.MemberFunctionIdentifierContext): FunctionSignature {
        // TODO
        return super.visitMemberFunctionIdentifier(ctx)
    }
}