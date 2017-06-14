// Generated from F:/Programming/Kotlin/Languages/Euclin-TIPE/src/main/kotlin/antlr/euclin\Euclin.g4 by ANTLR 4.7
package org.jglrxavpok.euclin.grammar;
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
	 * Visit a parse tree produced by the {@code CallInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallInstruction(EuclinParser.CallInstructionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclareVarInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareVarInstruction(EuclinParser.DeclareVarInstructionContext ctx);
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
	 * Visit a parse tree produced by the {@code LambdaFunctionExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaFunctionExpr(EuclinParser.LambdaFunctionExprContext ctx);
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
	 * Visit a parse tree produced by the {@code LambdaVarExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaVarExpr(EuclinParser.LambdaVarExprContext ctx);
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
	 * Visit a parse tree produced by the {@code IntExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExpr(EuclinParser.IntExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link EuclinParser#couple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCouple(EuclinParser.CoupleContext ctx);
}