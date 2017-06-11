// Generated from F:/Programming/Kotlin/Languages/Euclin-TIPE/src/main/kotlin/antlr/euclin\Euclin.g4 by ANTLR 4.7
package org.jglrxavpok.euclin.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EuclinParser}.
 */
public interface EuclinListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EuclinParser#codeBlock}.
	 * @param ctx the parse tree
	 */
	void enterCodeBlock(EuclinParser.CodeBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link EuclinParser#codeBlock}.
	 * @param ctx the parse tree
	 */
	void exitCodeBlock(EuclinParser.CodeBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link EuclinParser#functionCodeBlock}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCodeBlock(EuclinParser.FunctionCodeBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link EuclinParser#functionCodeBlock}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCodeBlock(EuclinParser.FunctionCodeBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstructionFuncInstruction}
	 * labeled alternative in {@link EuclinParser#functionInstructions}.
	 * @param ctx the parse tree
	 */
	void enterInstructionFuncInstruction(EuclinParser.InstructionFuncInstructionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstructionFuncInstruction}
	 * labeled alternative in {@link EuclinParser#functionInstructions}.
	 * @param ctx the parse tree
	 */
	void exitInstructionFuncInstruction(EuclinParser.InstructionFuncInstructionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnFuncInstruction}
	 * labeled alternative in {@link EuclinParser#functionInstructions}.
	 * @param ctx the parse tree
	 */
	void enterReturnFuncInstruction(EuclinParser.ReturnFuncInstructionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnFuncInstruction}
	 * labeled alternative in {@link EuclinParser#functionInstructions}.
	 * @param ctx the parse tree
	 */
	void exitReturnFuncInstruction(EuclinParser.ReturnFuncInstructionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CallInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 */
	void enterCallInstruction(EuclinParser.CallInstructionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CallInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 */
	void exitCallInstruction(EuclinParser.CallInstructionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclareVarInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 */
	void enterDeclareVarInstruction(EuclinParser.DeclareVarInstructionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclareVarInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 */
	void exitDeclareVarInstruction(EuclinParser.DeclareVarInstructionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignVarInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 */
	void enterAssignVarInstruction(EuclinParser.AssignVarInstructionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignVarInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 */
	void exitAssignVarInstruction(EuclinParser.AssignVarInstructionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignMemberInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 */
	void enterAssignMemberInstruction(EuclinParser.AssignMemberInstructionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignMemberInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 */
	void exitAssignMemberInstruction(EuclinParser.AssignMemberInstructionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TransformBlockInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 */
	void enterTransformBlockInstruction(EuclinParser.TransformBlockInstructionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TransformBlockInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 */
	void exitTransformBlockInstruction(EuclinParser.TransformBlockInstructionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclareFuncInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 */
	void enterDeclareFuncInstruction(EuclinParser.DeclareFuncInstructionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclareFuncInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 */
	void exitDeclareFuncInstruction(EuclinParser.DeclareFuncInstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EuclinParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(EuclinParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EuclinParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(EuclinParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EuclinParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(EuclinParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link EuclinParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(EuclinParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link EuclinParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(EuclinParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EuclinParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(EuclinParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EuclinParser#modifiers}.
	 * @param ctx the parse tree
	 */
	void enterModifiers(EuclinParser.ModifiersContext ctx);
	/**
	 * Exit a parse tree produced by {@link EuclinParser#modifiers}.
	 * @param ctx the parse tree
	 */
	void exitModifiers(EuclinParser.ModifiersContext ctx);
	/**
	 * Enter a parse tree produced by {@link EuclinParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(EuclinParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link EuclinParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(EuclinParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link EuclinParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(EuclinParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EuclinParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(EuclinParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EuclinParser#variableAssign}.
	 * @param ctx the parse tree
	 */
	void enterVariableAssign(EuclinParser.VariableAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link EuclinParser#variableAssign}.
	 * @param ctx the parse tree
	 */
	void exitVariableAssign(EuclinParser.VariableAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link EuclinParser#memberAssign}.
	 * @param ctx the parse tree
	 */
	void enterMemberAssign(EuclinParser.MemberAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link EuclinParser#memberAssign}.
	 * @param ctx the parse tree
	 */
	void exitMemberAssign(EuclinParser.MemberAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link EuclinParser#transformBlock}.
	 * @param ctx the parse tree
	 */
	void enterTransformBlock(EuclinParser.TransformBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link EuclinParser#transformBlock}.
	 * @param ctx the parse tree
	 */
	void exitTransformBlock(EuclinParser.TransformBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolTrueExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolTrueExpr(EuclinParser.BoolTrueExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolTrueExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolTrueExpr(EuclinParser.BoolTrueExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AccessExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAccessExpr(EuclinParser.AccessExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AccessExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAccessExpr(EuclinParser.AccessExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FloatExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFloatExpr(EuclinParser.FloatExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FloatExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFloatExpr(EuclinParser.FloatExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolFalseExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolFalseExpr(EuclinParser.BoolFalseExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolFalseExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolFalseExpr(EuclinParser.BoolFalseExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr(EuclinParser.MultExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr(EuclinParser.MultExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SubExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubExpr(EuclinParser.SubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SubExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubExpr(EuclinParser.SubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LambdaFunctionExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLambdaFunctionExpr(EuclinParser.LambdaFunctionExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LambdaFunctionExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLambdaFunctionExpr(EuclinParser.LambdaFunctionExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(EuclinParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(EuclinParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WrappedExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterWrappedExpr(EuclinParser.WrappedExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WrappedExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitWrappedExpr(EuclinParser.WrappedExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LambdaVarExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLambdaVarExpr(EuclinParser.LambdaVarExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LambdaVarExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLambdaVarExpr(EuclinParser.LambdaVarExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CoupleExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCoupleExpr(EuclinParser.CoupleExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CoupleExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCoupleExpr(EuclinParser.CoupleExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DivExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDivExpr(EuclinParser.DivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DivExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDivExpr(EuclinParser.DivExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVarExpr(EuclinParser.VarExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVarExpr(EuclinParser.VarExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CallExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCallExpr(EuclinParser.CallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CallExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCallExpr(EuclinParser.CallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIntExpr(EuclinParser.IntExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIntExpr(EuclinParser.IntExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link EuclinParser#couple}.
	 * @param ctx the parse tree
	 */
	void enterCouple(EuclinParser.CoupleContext ctx);
	/**
	 * Exit a parse tree produced by {@link EuclinParser#couple}.
	 * @param ctx the parse tree
	 */
	void exitCouple(EuclinParser.CoupleContext ctx);
}