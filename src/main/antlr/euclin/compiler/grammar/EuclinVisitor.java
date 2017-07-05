// Generated from F:/Programming/Kotlin/Languages/Euclin-TIPE/src/main/kotlin/antlr/euclin\Euclin.g4 by ANTLR 4.7
package euclin.compiler.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EuclinParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EuclinVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EuclinParser#codeBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeBlock(EuclinParser.CodeBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link EuclinParser#functionCodeBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCodeBlock(EuclinParser.FunctionCodeBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstructionFuncInstruction}
	 * labeled alternative in {@link EuclinParser#functionInstructions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstructionFuncInstruction(EuclinParser.InstructionFuncInstructionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnFuncInstruction}
	 * labeled alternative in {@link EuclinParser#functionInstructions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnFuncInstruction(EuclinParser.ReturnFuncInstructionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImportInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportInstruction(EuclinParser.ImportInstructionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImportMethodInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportMethodInstruction(EuclinParser.ImportMethodInstructionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionInstruction(EuclinParser.ExpressionInstructionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclareVarInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareVarInstruction(EuclinParser.DeclareVarInstructionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclareStructInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareStructInstruction(EuclinParser.DeclareStructInstructionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignVarInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignVarInstruction(EuclinParser.AssignVarInstructionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignMemberInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignMemberInstruction(EuclinParser.AssignMemberInstructionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TransformBlockInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransformBlockInstruction(EuclinParser.TransformBlockInstructionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclareFuncInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareFuncInstruction(EuclinParser.DeclareFuncInstructionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfBranchingInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfBranchingInstruction(EuclinParser.IfBranchingInstructionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileLoopInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoopInstruction(EuclinParser.WhileLoopInstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EuclinParser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDeclaration(EuclinParser.ImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BasicMethodImport}
	 * labeled alternative in {@link EuclinParser#methodImportDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicMethodImport(EuclinParser.BasicMethodImportContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImportAllMethods}
	 * labeled alternative in {@link EuclinParser#methodImportDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportAllMethods(EuclinParser.ImportAllMethodsContext ctx);
	/**
	 * Visit a parse tree produced by {@link EuclinParser#renamming}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenamming(EuclinParser.RenammingContext ctx);
	/**
	 * Visit a parse tree produced by {@link EuclinParser#structureDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructureDeclaration(EuclinParser.StructureDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EuclinParser#elseBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseBlock(EuclinParser.ElseBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionType}
	 * labeled alternative in {@link EuclinParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionType(EuclinParser.FunctionTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CoupleType}
	 * labeled alternative in {@link EuclinParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoupleType(EuclinParser.CoupleTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WrappedType}
	 * labeled alternative in {@link EuclinParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWrappedType(EuclinParser.WrappedTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BasicType}
	 * labeled alternative in {@link EuclinParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicType(EuclinParser.BasicTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WildcardType}
	 * labeled alternative in {@link EuclinParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildcardType(EuclinParser.WildcardTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EuclinParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(EuclinParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link EuclinParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(EuclinParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EuclinParser#modifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifiers(EuclinParser.ModifiersContext ctx);
	/**
	 * Visit a parse tree produced by {@link EuclinParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(EuclinParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link EuclinParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(EuclinParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EuclinParser#variableAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableAssign(EuclinParser.VariableAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link EuclinParser#memberAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberAssign(EuclinParser.MemberAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link EuclinParser#transformBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransformBlock(EuclinParser.TransformBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpr(EuclinParser.StringExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LoadAndRetypeExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoadAndRetypeExpr(EuclinParser.LoadAndRetypeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FloatExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatExpr(EuclinParser.FloatExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolFalseExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolFalseExpr(EuclinParser.BoolFalseExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NewObjectExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewObjectExpr(EuclinParser.NewObjectExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LambdaFunctionExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaFunctionExpr(EuclinParser.LambdaFunctionExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessEqualExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessEqualExpr(EuclinParser.LessEqualExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LambdaVarExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaVarExpr(EuclinParser.LambdaVarExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CastExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpr(EuclinParser.CastExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarExpr(EuclinParser.VarExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CallExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpr(EuclinParser.CallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnitExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnitExpr(EuclinParser.UnitExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Equality}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality(EuclinParser.EqualityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolTrueExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolTrueExpr(EuclinParser.BoolTrueExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AccessExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessExpr(EuclinParser.AccessExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpr(EuclinParser.MultExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SubExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubExpr(EuclinParser.SubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GreaterExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterExpr(EuclinParser.GreaterExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GreaterEqualExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterEqualExpr(EuclinParser.GreaterEqualExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(EuclinParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WrappedExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWrappedExpr(EuclinParser.WrappedExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessExpr(EuclinParser.LessExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CoupleExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoupleExpr(EuclinParser.CoupleExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DivExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivExpr(EuclinParser.DivExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExpr(EuclinParser.IntExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Inequality}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInequality(EuclinParser.InequalityContext ctx);
	/**
	 * Visit a parse tree produced by {@link EuclinParser#couple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCouple(EuclinParser.CoupleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DirectFunctionIdentifier}
	 * labeled alternative in {@link EuclinParser#functionIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirectFunctionIdentifier(EuclinParser.DirectFunctionIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MemberFunctionIdentifier}
	 * labeled alternative in {@link EuclinParser#functionIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberFunctionIdentifier(EuclinParser.MemberFunctionIdentifierContext ctx);
}