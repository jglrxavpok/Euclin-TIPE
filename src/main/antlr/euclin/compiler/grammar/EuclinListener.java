// Generated from D:/Code/Kotlin/Languages/Euclin/src/main/kotlin/antlr/euclin\Euclin.g4 by ANTLR 4.7
package euclin.compiler.grammar;
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
	 * Enter a parse tree produced by the {@code ImportInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 */
	void enterImportInstruction(EuclinParser.ImportInstructionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImportInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 */
	void exitImportInstruction(EuclinParser.ImportInstructionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ImportMethodInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 */
	void enterImportMethodInstruction(EuclinParser.ImportMethodInstructionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImportMethodInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 */
	void exitImportMethodInstruction(EuclinParser.ImportMethodInstructionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 */
	void enterExpressionInstruction(EuclinParser.ExpressionInstructionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 */
	void exitExpressionInstruction(EuclinParser.ExpressionInstructionContext ctx);
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
	 * Enter a parse tree produced by the {@code DeclareStructInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 */
	void enterDeclareStructInstruction(EuclinParser.DeclareStructInstructionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclareStructInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 */
	void exitDeclareStructInstruction(EuclinParser.DeclareStructInstructionContext ctx);
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
	 * Enter a parse tree produced by the {@code ArrayStoreInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 */
	void enterArrayStoreInstruction(EuclinParser.ArrayStoreInstructionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayStoreInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 */
	void exitArrayStoreInstruction(EuclinParser.ArrayStoreInstructionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfBranchingInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 */
	void enterIfBranchingInstruction(EuclinParser.IfBranchingInstructionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfBranchingInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 */
	void exitIfBranchingInstruction(EuclinParser.IfBranchingInstructionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileLoopInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoopInstruction(EuclinParser.WhileLoopInstructionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileLoopInstruction}
	 * labeled alternative in {@link EuclinParser#instructions}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoopInstruction(EuclinParser.WhileLoopInstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link EuclinParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclaration(EuclinParser.ImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EuclinParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclaration(EuclinParser.ImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BasicMethodImport}
	 * labeled alternative in {@link EuclinParser#methodImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterBasicMethodImport(EuclinParser.BasicMethodImportContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BasicMethodImport}
	 * labeled alternative in {@link EuclinParser#methodImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitBasicMethodImport(EuclinParser.BasicMethodImportContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ImportAllMethods}
	 * labeled alternative in {@link EuclinParser#methodImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportAllMethods(EuclinParser.ImportAllMethodsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImportAllMethods}
	 * labeled alternative in {@link EuclinParser#methodImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportAllMethods(EuclinParser.ImportAllMethodsContext ctx);
	/**
	 * Enter a parse tree produced by {@link EuclinParser#renamming}.
	 * @param ctx the parse tree
	 */
	void enterRenamming(EuclinParser.RenammingContext ctx);
	/**
	 * Exit a parse tree produced by {@link EuclinParser#renamming}.
	 * @param ctx the parse tree
	 */
	void exitRenamming(EuclinParser.RenammingContext ctx);
	/**
	 * Enter a parse tree produced by {@link EuclinParser#structureDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStructureDeclaration(EuclinParser.StructureDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EuclinParser#structureDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStructureDeclaration(EuclinParser.StructureDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EuclinParser#linkage}.
	 * @param ctx the parse tree
	 */
	void enterLinkage(EuclinParser.LinkageContext ctx);
	/**
	 * Exit a parse tree produced by {@link EuclinParser#linkage}.
	 * @param ctx the parse tree
	 */
	void exitLinkage(EuclinParser.LinkageContext ctx);
	/**
	 * Enter a parse tree produced by {@link EuclinParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void enterElseBlock(EuclinParser.ElseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link EuclinParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void exitElseBlock(EuclinParser.ElseBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionType}
	 * labeled alternative in {@link EuclinParser#type}.
	 * @param ctx the parse tree
	 */
	void enterFunctionType(EuclinParser.FunctionTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionType}
	 * labeled alternative in {@link EuclinParser#type}.
	 * @param ctx the parse tree
	 */
	void exitFunctionType(EuclinParser.FunctionTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CoupleType}
	 * labeled alternative in {@link EuclinParser#type}.
	 * @param ctx the parse tree
	 */
	void enterCoupleType(EuclinParser.CoupleTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CoupleType}
	 * labeled alternative in {@link EuclinParser#type}.
	 * @param ctx the parse tree
	 */
	void exitCoupleType(EuclinParser.CoupleTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WrappedType}
	 * labeled alternative in {@link EuclinParser#type}.
	 * @param ctx the parse tree
	 */
	void enterWrappedType(EuclinParser.WrappedTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WrappedType}
	 * labeled alternative in {@link EuclinParser#type}.
	 * @param ctx the parse tree
	 */
	void exitWrappedType(EuclinParser.WrappedTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BasicType}
	 * labeled alternative in {@link EuclinParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBasicType(EuclinParser.BasicTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BasicType}
	 * labeled alternative in {@link EuclinParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBasicType(EuclinParser.BasicTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WildcardType}
	 * labeled alternative in {@link EuclinParser#type}.
	 * @param ctx the parse tree
	 */
	void enterWildcardType(EuclinParser.WildcardTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WildcardType}
	 * labeled alternative in {@link EuclinParser#type}.
	 * @param ctx the parse tree
	 */
	void exitWildcardType(EuclinParser.WildcardTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link EuclinParser#type}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(EuclinParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link EuclinParser#type}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(EuclinParser.ArrayTypeContext ctx);
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
	 * Enter a parse tree produced by the {@code StringExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpr(EuclinParser.StringExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpr(EuclinParser.StringExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LoadAndRetypeExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLoadAndRetypeExpr(EuclinParser.LoadAndRetypeExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LoadAndRetypeExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLoadAndRetypeExpr(EuclinParser.LoadAndRetypeExprContext ctx);
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
	 * Enter a parse tree produced by the {@code NewObjectExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewObjectExpr(EuclinParser.NewObjectExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NewObjectExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewObjectExpr(EuclinParser.NewObjectExprContext ctx);
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
	 * Enter a parse tree produced by the {@code LessEqualExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLessEqualExpr(EuclinParser.LessEqualExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LessEqualExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLessEqualExpr(EuclinParser.LessEqualExprContext ctx);
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
	 * Enter a parse tree produced by the {@code CastExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCastExpr(EuclinParser.CastExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CastExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCastExpr(EuclinParser.CastExprContext ctx);
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
	 * Enter a parse tree produced by the {@code UnitExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnitExpr(EuclinParser.UnitExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnitExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnitExpr(EuclinParser.UnitExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Equality}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEquality(EuclinParser.EqualityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Equality}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEquality(EuclinParser.EqualityContext ctx);
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
	 * Enter a parse tree produced by the {@code GreaterExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGreaterExpr(EuclinParser.GreaterExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GreaterExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGreaterExpr(EuclinParser.GreaterExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GreaterEqualExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGreaterEqualExpr(EuclinParser.GreaterEqualExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GreaterEqualExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGreaterEqualExpr(EuclinParser.GreaterEqualExprContext ctx);
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
	 * Enter a parse tree produced by the {@code CharExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCharExpr(EuclinParser.CharExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CharExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCharExpr(EuclinParser.CharExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LessExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLessExpr(EuclinParser.LessExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LessExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLessExpr(EuclinParser.LessExprContext ctx);
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
	 * Enter a parse tree produced by the {@code ArrayExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpr(EuclinParser.ArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpr(EuclinParser.ArrayExprContext ctx);
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
	 * Enter a parse tree produced by the {@code NewArrayExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewArrayExpr(EuclinParser.NewArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NewArrayExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewArrayExpr(EuclinParser.NewArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AccessArrayExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAccessArrayExpr(EuclinParser.AccessArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AccessArrayExpr}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAccessArrayExpr(EuclinParser.AccessArrayExprContext ctx);
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
	 * Enter a parse tree produced by the {@code Inequality}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInequality(EuclinParser.InequalityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Inequality}
	 * labeled alternative in {@link EuclinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInequality(EuclinParser.InequalityContext ctx);
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
	/**
	 * Enter a parse tree produced by the {@code DirectFunctionIdentifier}
	 * labeled alternative in {@link EuclinParser#functionIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterDirectFunctionIdentifier(EuclinParser.DirectFunctionIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DirectFunctionIdentifier}
	 * labeled alternative in {@link EuclinParser#functionIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitDirectFunctionIdentifier(EuclinParser.DirectFunctionIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberFunctionIdentifier}
	 * labeled alternative in {@link EuclinParser#functionIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterMemberFunctionIdentifier(EuclinParser.MemberFunctionIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberFunctionIdentifier}
	 * labeled alternative in {@link EuclinParser#functionIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitMemberFunctionIdentifier(EuclinParser.MemberFunctionIdentifierContext ctx);
}