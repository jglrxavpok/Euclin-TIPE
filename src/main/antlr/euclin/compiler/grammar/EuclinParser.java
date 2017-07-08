// Generated from F:/Programming/Kotlin/Languages/Euclin-TIPE/src/main/kotlin/antlr/euclin\Euclin.g4 by ANTLR 4.7
package euclin.compiler.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EuclinParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, Return=2, TransformBlockStart=3, FunctionDefStart=4, Var=5, True=6, 
		False=7, Pure=8, Impure=9, Memoized=10, Else=11, If=12, While=13, StructStart=14, 
		New=15, Import=16, ImportMethod=17, LambdaVariable=18, LeftBracket=19, 
		RightBracket=20, LeftCurlyBracket=21, RightCurlyBracket=22, LeftSquareBracket=23, 
		RightSquareBracket=24, Comma=25, Period=26, Colon=27, SemiColon=28, Equals=29, 
		LightArrow=30, RightLightArrow=31, Bang=32, Less=33, LessEqual=34, Greater=35, 
		GreaterEqual=36, Star=37, Identifier=38, Integer=39, FloatNumber=40, MultOperator=41, 
		DivOperator=42, AddOperator=43, SubOperator=44, StringConstant=45, LineComment=46, 
		MultilineComment=47, Whitespace=48;
	public static final int
		RULE_codeBlock = 0, RULE_functionCodeBlock = 1, RULE_functionInstructions = 2, 
		RULE_instructions = 3, RULE_importDeclaration = 4, RULE_methodImportDeclaration = 5, 
		RULE_renamming = 6, RULE_structureDeclaration = 7, RULE_elseBlock = 8, 
		RULE_type = 9, RULE_parameter = 10, RULE_functionDeclaration = 11, RULE_modifiers = 12, 
		RULE_functionCall = 13, RULE_variableDeclaration = 14, RULE_variableAssign = 15, 
		RULE_memberAssign = 16, RULE_transformBlock = 17, RULE_expression = 18, 
		RULE_couple = 19, RULE_functionIdentifier = 20;
	public static final String[] ruleNames = {
		"codeBlock", "functionCodeBlock", "functionInstructions", "instructions", 
		"importDeclaration", "methodImportDeclaration", "renamming", "structureDeclaration", 
		"elseBlock", "type", "parameter", "functionDeclaration", "modifiers", 
		"functionCall", "variableDeclaration", "variableAssign", "memberAssign", 
		"transformBlock", "expression", "couple", "functionIdentifier"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'as'", "'return'", "'transform'", "'func'", "'var'", "'true'", 
		"'false'", "'pure'", "'impure'", "'memoized'", "'else'", "'if'", "'while'", 
		"'struct'", "'new'", "'import'", "'import method'", "'_'", "'('", "')'", 
		"'{'", "'}'", "'['", "']'", "','", "'.'", "':'", "';'", "'='", "'->'", 
		"'<-'", "'!'", "'<'", "'<='", "'>'", "'>='", "'@'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "Return", "TransformBlockStart", "FunctionDefStart", "Var", 
		"True", "False", "Pure", "Impure", "Memoized", "Else", "If", "While", 
		"StructStart", "New", "Import", "ImportMethod", "LambdaVariable", "LeftBracket", 
		"RightBracket", "LeftCurlyBracket", "RightCurlyBracket", "LeftSquareBracket", 
		"RightSquareBracket", "Comma", "Period", "Colon", "SemiColon", "Equals", 
		"LightArrow", "RightLightArrow", "Bang", "Less", "LessEqual", "Greater", 
		"GreaterEqual", "Star", "Identifier", "Integer", "FloatNumber", "MultOperator", 
		"DivOperator", "AddOperator", "SubOperator", "StringConstant", "LineComment", 
		"MultilineComment", "Whitespace"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Euclin.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EuclinParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CodeBlockContext extends ParserRuleContext {
		public List<InstructionsContext> instructions() {
			return getRuleContexts(InstructionsContext.class);
		}
		public InstructionsContext instructions(int i) {
			return getRuleContext(InstructionsContext.class,i);
		}
		public CodeBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codeBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterCodeBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitCodeBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitCodeBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeBlockContext codeBlock() throws RecognitionException {
		CodeBlockContext _localctx = new CodeBlockContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_codeBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TransformBlockStart) | (1L << FunctionDefStart) | (1L << Var) | (1L << True) | (1L << False) | (1L << Pure) | (1L << Impure) | (1L << Memoized) | (1L << If) | (1L << While) | (1L << StructStart) | (1L << New) | (1L << Import) | (1L << ImportMethod) | (1L << LambdaVariable) | (1L << LeftBracket) | (1L << LeftCurlyBracket) | (1L << LeftSquareBracket) | (1L << Identifier) | (1L << Integer) | (1L << FloatNumber) | (1L << StringConstant))) != 0)) {
				{
				{
				setState(42);
				instructions();
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCodeBlockContext extends ParserRuleContext {
		public List<FunctionInstructionsContext> functionInstructions() {
			return getRuleContexts(FunctionInstructionsContext.class);
		}
		public FunctionInstructionsContext functionInstructions(int i) {
			return getRuleContext(FunctionInstructionsContext.class,i);
		}
		public FunctionCodeBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCodeBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterFunctionCodeBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitFunctionCodeBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitFunctionCodeBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCodeBlockContext functionCodeBlock() throws RecognitionException {
		FunctionCodeBlockContext _localctx = new FunctionCodeBlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_functionCodeBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(48);
				functionInstructions();
				}
				}
				setState(51); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Return) | (1L << TransformBlockStart) | (1L << FunctionDefStart) | (1L << Var) | (1L << True) | (1L << False) | (1L << Pure) | (1L << Impure) | (1L << Memoized) | (1L << If) | (1L << While) | (1L << StructStart) | (1L << New) | (1L << Import) | (1L << ImportMethod) | (1L << LambdaVariable) | (1L << LeftBracket) | (1L << LeftCurlyBracket) | (1L << LeftSquareBracket) | (1L << Identifier) | (1L << Integer) | (1L << FloatNumber) | (1L << StringConstant))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionInstructionsContext extends ParserRuleContext {
		public FunctionInstructionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionInstructions; }
	 
		public FunctionInstructionsContext() { }
		public void copyFrom(FunctionInstructionsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InstructionFuncInstructionContext extends FunctionInstructionsContext {
		public InstructionsContext instructions() {
			return getRuleContext(InstructionsContext.class,0);
		}
		public InstructionFuncInstructionContext(FunctionInstructionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterInstructionFuncInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitInstructionFuncInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitInstructionFuncInstruction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnFuncInstructionContext extends FunctionInstructionsContext {
		public TerminalNode Return() { return getToken(EuclinParser.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnFuncInstructionContext(FunctionInstructionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterReturnFuncInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitReturnFuncInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitReturnFuncInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionInstructionsContext functionInstructions() throws RecognitionException {
		FunctionInstructionsContext _localctx = new FunctionInstructionsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functionInstructions);
		try {
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TransformBlockStart:
			case FunctionDefStart:
			case Var:
			case True:
			case False:
			case Pure:
			case Impure:
			case Memoized:
			case If:
			case While:
			case StructStart:
			case New:
			case Import:
			case ImportMethod:
			case LambdaVariable:
			case LeftBracket:
			case LeftCurlyBracket:
			case LeftSquareBracket:
			case Identifier:
			case Integer:
			case FloatNumber:
			case StringConstant:
				_localctx = new InstructionFuncInstructionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				instructions();
				}
				break;
			case Return:
				_localctx = new ReturnFuncInstructionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				match(Return);
				setState(55);
				expression(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstructionsContext extends ParserRuleContext {
		public InstructionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructions; }
	 
		public InstructionsContext() { }
		public void copyFrom(InstructionsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssignMemberInstructionContext extends InstructionsContext {
		public MemberAssignContext memberAssign() {
			return getRuleContext(MemberAssignContext.class,0);
		}
		public AssignMemberInstructionContext(InstructionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterAssignMemberInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitAssignMemberInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitAssignMemberInstruction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TransformBlockInstructionContext extends InstructionsContext {
		public TransformBlockContext transformBlock() {
			return getRuleContext(TransformBlockContext.class,0);
		}
		public TransformBlockInstructionContext(InstructionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterTransformBlockInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitTransformBlockInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitTransformBlockInstruction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclareVarInstructionContext extends InstructionsContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public DeclareVarInstructionContext(InstructionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterDeclareVarInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitDeclareVarInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitDeclareVarInstruction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionInstructionContext extends InstructionsContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionInstructionContext(InstructionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterExpressionInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitExpressionInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitExpressionInstruction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignVarInstructionContext extends InstructionsContext {
		public VariableAssignContext variableAssign() {
			return getRuleContext(VariableAssignContext.class,0);
		}
		public AssignVarInstructionContext(InstructionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterAssignVarInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitAssignVarInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitAssignVarInstruction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileLoopInstructionContext extends InstructionsContext {
		public TerminalNode While() { return getToken(EuclinParser.While, 0); }
		public TerminalNode LeftBracket() { return getToken(EuclinParser.LeftBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightBracket() { return getToken(EuclinParser.RightBracket, 0); }
		public TerminalNode LeftCurlyBracket() { return getToken(EuclinParser.LeftCurlyBracket, 0); }
		public TerminalNode RightCurlyBracket() { return getToken(EuclinParser.RightCurlyBracket, 0); }
		public List<FunctionInstructionsContext> functionInstructions() {
			return getRuleContexts(FunctionInstructionsContext.class);
		}
		public FunctionInstructionsContext functionInstructions(int i) {
			return getRuleContext(FunctionInstructionsContext.class,i);
		}
		public WhileLoopInstructionContext(InstructionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterWhileLoopInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitWhileLoopInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitWhileLoopInstruction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ImportInstructionContext extends InstructionsContext {
		public ImportDeclarationContext importDeclaration() {
			return getRuleContext(ImportDeclarationContext.class,0);
		}
		public ImportInstructionContext(InstructionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterImportInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitImportInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitImportInstruction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfBranchingInstructionContext extends InstructionsContext {
		public TerminalNode If() { return getToken(EuclinParser.If, 0); }
		public TerminalNode LeftBracket() { return getToken(EuclinParser.LeftBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightBracket() { return getToken(EuclinParser.RightBracket, 0); }
		public TerminalNode LeftCurlyBracket() { return getToken(EuclinParser.LeftCurlyBracket, 0); }
		public TerminalNode RightCurlyBracket() { return getToken(EuclinParser.RightCurlyBracket, 0); }
		public List<FunctionInstructionsContext> functionInstructions() {
			return getRuleContexts(FunctionInstructionsContext.class);
		}
		public FunctionInstructionsContext functionInstructions(int i) {
			return getRuleContext(FunctionInstructionsContext.class,i);
		}
		public ElseBlockContext elseBlock() {
			return getRuleContext(ElseBlockContext.class,0);
		}
		public IfBranchingInstructionContext(InstructionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterIfBranchingInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitIfBranchingInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitIfBranchingInstruction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclareStructInstructionContext extends InstructionsContext {
		public StructureDeclarationContext structureDeclaration() {
			return getRuleContext(StructureDeclarationContext.class,0);
		}
		public DeclareStructInstructionContext(InstructionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterDeclareStructInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitDeclareStructInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitDeclareStructInstruction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclareFuncInstructionContext extends InstructionsContext {
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public DeclareFuncInstructionContext(InstructionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterDeclareFuncInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitDeclareFuncInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitDeclareFuncInstruction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ImportMethodInstructionContext extends InstructionsContext {
		public MethodImportDeclarationContext methodImportDeclaration() {
			return getRuleContext(MethodImportDeclarationContext.class,0);
		}
		public ImportMethodInstructionContext(InstructionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterImportMethodInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitImportMethodInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitImportMethodInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionsContext instructions() throws RecognitionException {
		InstructionsContext _localctx = new InstructionsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instructions);
		int _la;
		try {
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new ImportInstructionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				importDeclaration();
				}
				break;
			case 2:
				_localctx = new ImportMethodInstructionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				methodImportDeclaration();
				}
				break;
			case 3:
				_localctx = new ExpressionInstructionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(60);
				expression(0);
				}
				break;
			case 4:
				_localctx = new DeclareVarInstructionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(61);
				variableDeclaration();
				}
				break;
			case 5:
				_localctx = new DeclareStructInstructionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(62);
				structureDeclaration();
				}
				break;
			case 6:
				_localctx = new AssignVarInstructionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(63);
				variableAssign();
				}
				break;
			case 7:
				_localctx = new AssignMemberInstructionContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(64);
				memberAssign();
				}
				break;
			case 8:
				_localctx = new TransformBlockInstructionContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(65);
				transformBlock();
				}
				break;
			case 9:
				_localctx = new DeclareFuncInstructionContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(66);
				functionDeclaration();
				}
				break;
			case 10:
				_localctx = new IfBranchingInstructionContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(67);
				match(If);
				setState(68);
				match(LeftBracket);
				setState(69);
				expression(0);
				setState(70);
				match(RightBracket);
				setState(71);
				match(LeftCurlyBracket);
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Return) | (1L << TransformBlockStart) | (1L << FunctionDefStart) | (1L << Var) | (1L << True) | (1L << False) | (1L << Pure) | (1L << Impure) | (1L << Memoized) | (1L << If) | (1L << While) | (1L << StructStart) | (1L << New) | (1L << Import) | (1L << ImportMethod) | (1L << LambdaVariable) | (1L << LeftBracket) | (1L << LeftCurlyBracket) | (1L << LeftSquareBracket) | (1L << Identifier) | (1L << Integer) | (1L << FloatNumber) | (1L << StringConstant))) != 0)) {
					{
					{
					setState(72);
					functionInstructions();
					}
					}
					setState(77);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(78);
				match(RightCurlyBracket);
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Else) {
					{
					setState(79);
					elseBlock();
					}
				}

				}
				break;
			case 11:
				_localctx = new WhileLoopInstructionContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(82);
				match(While);
				setState(83);
				match(LeftBracket);
				setState(84);
				expression(0);
				setState(85);
				match(RightBracket);
				setState(86);
				match(LeftCurlyBracket);
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Return) | (1L << TransformBlockStart) | (1L << FunctionDefStart) | (1L << Var) | (1L << True) | (1L << False) | (1L << Pure) | (1L << Impure) | (1L << Memoized) | (1L << If) | (1L << While) | (1L << StructStart) | (1L << New) | (1L << Import) | (1L << ImportMethod) | (1L << LambdaVariable) | (1L << LeftBracket) | (1L << LeftCurlyBracket) | (1L << LeftSquareBracket) | (1L << Identifier) | (1L << Integer) | (1L << FloatNumber) | (1L << StringConstant))) != 0)) {
					{
					{
					setState(87);
					functionInstructions();
					}
					}
					setState(92);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(93);
				match(RightCurlyBracket);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportDeclarationContext extends ParserRuleContext {
		public TerminalNode Import() { return getToken(EuclinParser.Import, 0); }
		public List<TerminalNode> Identifier() { return getTokens(EuclinParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(EuclinParser.Identifier, i);
		}
		public List<TerminalNode> Period() { return getTokens(EuclinParser.Period); }
		public TerminalNode Period(int i) {
			return getToken(EuclinParser.Period, i);
		}
		public RenammingContext renamming() {
			return getRuleContext(RenammingContext.class,0);
		}
		public ImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterImportDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitImportDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitImportDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportDeclarationContext importDeclaration() throws RecognitionException {
		ImportDeclarationContext _localctx = new ImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_importDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(Import);
			setState(98);
			match(Identifier);
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Period) {
				{
				{
				setState(99);
				match(Period);
				setState(100);
				match(Identifier);
				}
				}
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(106);
				renamming();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodImportDeclarationContext extends ParserRuleContext {
		public MethodImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodImportDeclaration; }
	 
		public MethodImportDeclarationContext() { }
		public void copyFrom(MethodImportDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BasicMethodImportContext extends MethodImportDeclarationContext {
		public TerminalNode ImportMethod() { return getToken(EuclinParser.ImportMethod, 0); }
		public List<TerminalNode> Identifier() { return getTokens(EuclinParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(EuclinParser.Identifier, i);
		}
		public List<TerminalNode> Period() { return getTokens(EuclinParser.Period); }
		public TerminalNode Period(int i) {
			return getToken(EuclinParser.Period, i);
		}
		public RenammingContext renamming() {
			return getRuleContext(RenammingContext.class,0);
		}
		public BasicMethodImportContext(MethodImportDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterBasicMethodImport(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitBasicMethodImport(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitBasicMethodImport(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ImportAllMethodsContext extends MethodImportDeclarationContext {
		public TerminalNode ImportMethod() { return getToken(EuclinParser.ImportMethod, 0); }
		public List<TerminalNode> Identifier() { return getTokens(EuclinParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(EuclinParser.Identifier, i);
		}
		public List<TerminalNode> Period() { return getTokens(EuclinParser.Period); }
		public TerminalNode Period(int i) {
			return getToken(EuclinParser.Period, i);
		}
		public TerminalNode Star() { return getToken(EuclinParser.Star, 0); }
		public ImportAllMethodsContext(MethodImportDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterImportAllMethods(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitImportAllMethods(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitImportAllMethods(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodImportDeclarationContext methodImportDeclaration() throws RecognitionException {
		MethodImportDeclarationContext _localctx = new MethodImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_methodImportDeclaration);
		int _la;
		try {
			int _alt;
			setState(132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new BasicMethodImportContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				match(ImportMethod);
				setState(110);
				match(Identifier);
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Period) {
					{
					{
					setState(111);
					match(Period);
					setState(112);
					match(Identifier);
					}
					}
					setState(117);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(118);
					renamming();
					}
				}

				}
				break;
			case 2:
				_localctx = new ImportAllMethodsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				match(ImportMethod);
				setState(122);
				match(Identifier);
				setState(127);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(123);
						match(Period);
						setState(124);
						match(Identifier);
						}
						} 
					}
					setState(129);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				}
				setState(130);
				match(Period);
				setState(131);
				match(Star);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RenammingContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(EuclinParser.Identifier, 0); }
		public RenammingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_renamming; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterRenamming(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitRenamming(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitRenamming(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RenammingContext renamming() throws RecognitionException {
		RenammingContext _localctx = new RenammingContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_renamming);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(T__0);
			setState(135);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructureDeclarationContext extends ParserRuleContext {
		public TerminalNode StructStart() { return getToken(EuclinParser.StructStart, 0); }
		public TerminalNode Identifier() { return getToken(EuclinParser.Identifier, 0); }
		public TerminalNode LeftCurlyBracket() { return getToken(EuclinParser.LeftCurlyBracket, 0); }
		public TerminalNode RightCurlyBracket() { return getToken(EuclinParser.RightCurlyBracket, 0); }
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public StructureDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structureDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterStructureDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitStructureDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitStructureDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructureDeclarationContext structureDeclaration() throws RecognitionException {
		StructureDeclarationContext _localctx = new StructureDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_structureDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(StructStart);
			setState(138);
			match(Identifier);
			setState(139);
			match(LeftCurlyBracket);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(140);
				parameter();
				}
				}
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(146);
			match(RightCurlyBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseBlockContext extends ParserRuleContext {
		public TerminalNode Else() { return getToken(EuclinParser.Else, 0); }
		public TerminalNode LeftCurlyBracket() { return getToken(EuclinParser.LeftCurlyBracket, 0); }
		public TerminalNode RightCurlyBracket() { return getToken(EuclinParser.RightCurlyBracket, 0); }
		public List<FunctionInstructionsContext> functionInstructions() {
			return getRuleContexts(FunctionInstructionsContext.class);
		}
		public FunctionInstructionsContext functionInstructions(int i) {
			return getRuleContext(FunctionInstructionsContext.class,i);
		}
		public ElseBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterElseBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitElseBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitElseBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseBlockContext elseBlock() throws RecognitionException {
		ElseBlockContext _localctx = new ElseBlockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_elseBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(Else);
			setState(149);
			match(LeftCurlyBracket);
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Return) | (1L << TransformBlockStart) | (1L << FunctionDefStart) | (1L << Var) | (1L << True) | (1L << False) | (1L << Pure) | (1L << Impure) | (1L << Memoized) | (1L << If) | (1L << While) | (1L << StructStart) | (1L << New) | (1L << Import) | (1L << ImportMethod) | (1L << LambdaVariable) | (1L << LeftBracket) | (1L << LeftCurlyBracket) | (1L << LeftSquareBracket) | (1L << Identifier) | (1L << Integer) | (1L << FloatNumber) | (1L << StringConstant))) != 0)) {
				{
				{
				setState(150);
				functionInstructions();
				}
				}
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(156);
			match(RightCurlyBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CoupleTypeContext extends TypeContext {
		public TerminalNode LeftBracket() { return getToken(EuclinParser.LeftBracket, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode Comma() { return getToken(EuclinParser.Comma, 0); }
		public TerminalNode RightBracket() { return getToken(EuclinParser.RightBracket, 0); }
		public CoupleTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterCoupleType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitCoupleType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitCoupleType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayTypeContext extends TypeContext {
		public TerminalNode LeftSquareBracket() { return getToken(EuclinParser.LeftSquareBracket, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RightSquareBracket() { return getToken(EuclinParser.RightSquareBracket, 0); }
		public ArrayTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WildcardTypeContext extends TypeContext {
		public TerminalNode Star() { return getToken(EuclinParser.Star, 0); }
		public WildcardTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterWildcardType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitWildcardType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitWildcardType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BasicTypeContext extends TypeContext {
		public TerminalNode Identifier() { return getToken(EuclinParser.Identifier, 0); }
		public BasicTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterBasicType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitBasicType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitBasicType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WrappedTypeContext extends TypeContext {
		public TerminalNode LeftBracket() { return getToken(EuclinParser.LeftBracket, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RightBracket() { return getToken(EuclinParser.RightBracket, 0); }
		public WrappedTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterWrappedType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitWrappedType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitWrappedType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionTypeContext extends TypeContext {
		public TerminalNode LeftBracket() { return getToken(EuclinParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(EuclinParser.RightBracket, 0); }
		public TerminalNode LightArrow() { return getToken(EuclinParser.LightArrow, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(EuclinParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(EuclinParser.Comma, i);
		}
		public FunctionTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterFunctionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitFunctionType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitFunctionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		int _la;
		try {
			setState(188);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new FunctionTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				match(LeftBracket);
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LeftBracket) | (1L << LeftSquareBracket) | (1L << Star) | (1L << Identifier))) != 0)) {
					{
					setState(159);
					type();
					setState(164);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(160);
						match(Comma);
						setState(161);
						type();
						}
						}
						setState(166);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(169);
				match(RightBracket);
				setState(170);
				match(LightArrow);
				setState(171);
				type();
				}
				break;
			case 2:
				_localctx = new CoupleTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				match(LeftBracket);
				setState(173);
				type();
				setState(174);
				match(Comma);
				setState(175);
				type();
				setState(176);
				match(RightBracket);
				}
				break;
			case 3:
				_localctx = new WrappedTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(178);
				match(LeftBracket);
				setState(179);
				type();
				setState(180);
				match(RightBracket);
				}
				break;
			case 4:
				_localctx = new BasicTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(182);
				match(Identifier);
				}
				break;
			case 5:
				_localctx = new WildcardTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(183);
				match(Star);
				}
				break;
			case 6:
				_localctx = new ArrayTypeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(184);
				match(LeftSquareBracket);
				setState(185);
				type();
				setState(186);
				match(RightSquareBracket);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(EuclinParser.Identifier, 0); }
		public TerminalNode Colon() { return getToken(EuclinParser.Colon, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(Identifier);
			setState(191);
			match(Colon);
			setState(192);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public TerminalNode FunctionDefStart() { return getToken(EuclinParser.FunctionDefStart, 0); }
		public TerminalNode Identifier() { return getToken(EuclinParser.Identifier, 0); }
		public TerminalNode LeftBracket() { return getToken(EuclinParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(EuclinParser.RightBracket, 0); }
		public TerminalNode Colon() { return getToken(EuclinParser.Colon, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LeftCurlyBracket() { return getToken(EuclinParser.LeftCurlyBracket, 0); }
		public FunctionCodeBlockContext functionCodeBlock() {
			return getRuleContext(FunctionCodeBlockContext.class,0);
		}
		public TerminalNode RightCurlyBracket() { return getToken(EuclinParser.RightCurlyBracket, 0); }
		public List<ModifiersContext> modifiers() {
			return getRuleContexts(ModifiersContext.class);
		}
		public ModifiersContext modifiers(int i) {
			return getRuleContext(ModifiersContext.class,i);
		}
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(EuclinParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(EuclinParser.Comma, i);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Pure) | (1L << Impure) | (1L << Memoized))) != 0)) {
				{
				{
				setState(194);
				modifiers();
				}
				}
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(200);
			match(FunctionDefStart);
			setState(201);
			match(Identifier);
			setState(202);
			match(LeftBracket);
			setState(211);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(203);
				parameter();
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(204);
					match(Comma);
					setState(205);
					parameter();
					}
					}
					setState(210);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(213);
			match(RightBracket);
			setState(214);
			match(Colon);
			setState(215);
			type();
			setState(216);
			match(LeftCurlyBracket);
			setState(217);
			functionCodeBlock();
			setState(218);
			match(RightCurlyBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModifiersContext extends ParserRuleContext {
		public TerminalNode Pure() { return getToken(EuclinParser.Pure, 0); }
		public TerminalNode Impure() { return getToken(EuclinParser.Impure, 0); }
		public TerminalNode Memoized() { return getToken(EuclinParser.Memoized, 0); }
		public ModifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterModifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitModifiers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitModifiers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifiersContext modifiers() throws RecognitionException {
		ModifiersContext _localctx = new ModifiersContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_modifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Pure) | (1L << Impure) | (1L << Memoized))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public FunctionIdentifierContext functionIdentifier() {
			return getRuleContext(FunctionIdentifierContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(EuclinParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(EuclinParser.RightBracket, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(EuclinParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(EuclinParser.Comma, i);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			functionIdentifier();
			setState(223);
			match(LeftBracket);
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << True) | (1L << False) | (1L << New) | (1L << LambdaVariable) | (1L << LeftBracket) | (1L << LeftCurlyBracket) | (1L << LeftSquareBracket) | (1L << Identifier) | (1L << Integer) | (1L << FloatNumber) | (1L << StringConstant))) != 0)) {
				{
				setState(224);
				expression(0);
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(225);
					match(Comma);
					setState(226);
					expression(0);
					}
					}
					setState(231);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(234);
			match(RightBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclarationContext extends ParserRuleContext {
		public TerminalNode Var() { return getToken(EuclinParser.Var, 0); }
		public TerminalNode Identifier() { return getToken(EuclinParser.Identifier, 0); }
		public TerminalNode Equals() { return getToken(EuclinParser.Equals, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_variableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(Var);
			setState(237);
			match(Identifier);
			setState(238);
			match(Equals);
			setState(239);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableAssignContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(EuclinParser.Identifier, 0); }
		public TerminalNode Equals() { return getToken(EuclinParser.Equals, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableAssign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterVariableAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitVariableAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitVariableAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableAssignContext variableAssign() throws RecognitionException {
		VariableAssignContext _localctx = new VariableAssignContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_variableAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(Identifier);
			setState(242);
			match(Equals);
			setState(243);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemberAssignContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Equals() { return getToken(EuclinParser.Equals, 0); }
		public List<TerminalNode> Period() { return getTokens(EuclinParser.Period); }
		public TerminalNode Period(int i) {
			return getToken(EuclinParser.Period, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(EuclinParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(EuclinParser.Identifier, i);
		}
		public MemberAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberAssign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterMemberAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitMemberAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitMemberAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberAssignContext memberAssign() throws RecognitionException {
		MemberAssignContext _localctx = new MemberAssignContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_memberAssign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			expression(0);
			setState(248); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(246);
				match(Period);
				setState(247);
				match(Identifier);
				}
				}
				setState(250); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Period );
			setState(252);
			match(Equals);
			setState(253);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TransformBlockContext extends ParserRuleContext {
		public TerminalNode TransformBlockStart() { return getToken(EuclinParser.TransformBlockStart, 0); }
		public TerminalNode LeftCurlyBracket() { return getToken(EuclinParser.LeftCurlyBracket, 0); }
		public CodeBlockContext codeBlock() {
			return getRuleContext(CodeBlockContext.class,0);
		}
		public TerminalNode RightCurlyBracket() { return getToken(EuclinParser.RightCurlyBracket, 0); }
		public TransformBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transformBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterTransformBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitTransformBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitTransformBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TransformBlockContext transformBlock() throws RecognitionException {
		TransformBlockContext _localctx = new TransformBlockContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_transformBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(TransformBlockStart);
			setState(256);
			match(LeftCurlyBracket);
			setState(257);
			codeBlock();
			setState(258);
			match(RightCurlyBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringExprContext extends ExpressionContext {
		public TerminalNode StringConstant() { return getToken(EuclinParser.StringConstant, 0); }
		public StringExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterStringExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitStringExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitStringExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LoadAndRetypeExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Colon() { return getToken(EuclinParser.Colon, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public LoadAndRetypeExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterLoadAndRetypeExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitLoadAndRetypeExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitLoadAndRetypeExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatExprContext extends ExpressionContext {
		public TerminalNode FloatNumber() { return getToken(EuclinParser.FloatNumber, 0); }
		public FloatExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterFloatExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitFloatExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitFloatExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolFalseExprContext extends ExpressionContext {
		public TerminalNode False() { return getToken(EuclinParser.False, 0); }
		public BoolFalseExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterBoolFalseExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitBoolFalseExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitBoolFalseExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewObjectExprContext extends ExpressionContext {
		public TerminalNode New() { return getToken(EuclinParser.New, 0); }
		public TerminalNode Identifier() { return getToken(EuclinParser.Identifier, 0); }
		public TerminalNode LeftBracket() { return getToken(EuclinParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(EuclinParser.RightBracket, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(EuclinParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(EuclinParser.Comma, i);
		}
		public NewObjectExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterNewObjectExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitNewObjectExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitNewObjectExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LambdaFunctionExprContext extends ExpressionContext {
		public TerminalNode LeftCurlyBracket() { return getToken(EuclinParser.LeftCurlyBracket, 0); }
		public TerminalNode RightCurlyBracket() { return getToken(EuclinParser.RightCurlyBracket, 0); }
		public List<FunctionInstructionsContext> functionInstructions() {
			return getRuleContexts(FunctionInstructionsContext.class);
		}
		public FunctionInstructionsContext functionInstructions(int i) {
			return getRuleContext(FunctionInstructionsContext.class,i);
		}
		public LambdaFunctionExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterLambdaFunctionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitLambdaFunctionExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitLambdaFunctionExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessEqualExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LessEqual() { return getToken(EuclinParser.LessEqual, 0); }
		public LessEqualExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterLessEqualExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitLessEqualExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitLessEqualExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LambdaVarExprContext extends ExpressionContext {
		public TerminalNode LambdaVariable() { return getToken(EuclinParser.LambdaVariable, 0); }
		public LambdaVarExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterLambdaVarExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitLambdaVarExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitLambdaVarExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CastExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightLightArrow() { return getToken(EuclinParser.RightLightArrow, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public CastExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterCastExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitCastExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitCastExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarExprContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(EuclinParser.Identifier, 0); }
		public VarExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterVarExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitVarExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitVarExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CallExprContext extends ExpressionContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public CallExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitCallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnitExprContext extends ExpressionContext {
		public TerminalNode LeftBracket() { return getToken(EuclinParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(EuclinParser.RightBracket, 0); }
		public UnitExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterUnitExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitUnitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitUnitExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualityContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Equals() { return getTokens(EuclinParser.Equals); }
		public TerminalNode Equals(int i) {
			return getToken(EuclinParser.Equals, i);
		}
		public EqualityContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitEquality(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitEquality(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolTrueExprContext extends ExpressionContext {
		public TerminalNode True() { return getToken(EuclinParser.True, 0); }
		public BoolTrueExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterBoolTrueExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitBoolTrueExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitBoolTrueExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AccessExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> Period() { return getTokens(EuclinParser.Period); }
		public TerminalNode Period(int i) {
			return getToken(EuclinParser.Period, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(EuclinParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(EuclinParser.Identifier, i);
		}
		public AccessExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterAccessExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitAccessExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitAccessExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MultOperator() { return getToken(EuclinParser.MultOperator, 0); }
		public MultExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterMultExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitMultExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitMultExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode SubOperator() { return getToken(EuclinParser.SubOperator, 0); }
		public SubExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterSubExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitSubExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitSubExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Greater() { return getToken(EuclinParser.Greater, 0); }
		public GreaterExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterGreaterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitGreaterExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitGreaterExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterEqualExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode GreaterEqual() { return getToken(EuclinParser.GreaterEqual, 0); }
		public GreaterEqualExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterGreaterEqualExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitGreaterEqualExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitGreaterEqualExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AddOperator() { return getToken(EuclinParser.AddOperator, 0); }
		public AddExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitAddExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitAddExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WrappedExprContext extends ExpressionContext {
		public TerminalNode LeftBracket() { return getToken(EuclinParser.LeftBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightBracket() { return getToken(EuclinParser.RightBracket, 0); }
		public WrappedExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterWrappedExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitWrappedExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitWrappedExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Less() { return getToken(EuclinParser.Less, 0); }
		public LessExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterLessExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitLessExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitLessExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CoupleExprContext extends ExpressionContext {
		public CoupleContext couple() {
			return getRuleContext(CoupleContext.class,0);
		}
		public CoupleExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterCoupleExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitCoupleExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitCoupleExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayExprContext extends ExpressionContext {
		public TerminalNode LeftSquareBracket() { return getToken(EuclinParser.LeftSquareBracket, 0); }
		public TerminalNode RightSquareBracket() { return getToken(EuclinParser.RightSquareBracket, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(EuclinParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(EuclinParser.Comma, i);
		}
		public ArrayExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterArrayExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitArrayExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitArrayExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DivOperator() { return getToken(EuclinParser.DivOperator, 0); }
		public DivExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterDivExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitDivExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitDivExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AccessArrayExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LeftSquareBracket() { return getToken(EuclinParser.LeftSquareBracket, 0); }
		public TerminalNode RightSquareBracket() { return getToken(EuclinParser.RightSquareBracket, 0); }
		public AccessArrayExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterAccessArrayExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitAccessArrayExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitAccessArrayExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntExprContext extends ExpressionContext {
		public TerminalNode Integer() { return getToken(EuclinParser.Integer, 0); }
		public IntExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterIntExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitIntExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitIntExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InequalityContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Bang() { return getToken(EuclinParser.Bang, 0); }
		public TerminalNode Equals() { return getToken(EuclinParser.Equals, 0); }
		public InequalityContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterInequality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitInequality(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitInequality(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				_localctx = new LambdaVarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(261);
				match(LambdaVariable);
				}
				break;
			case 2:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(262);
				match(LeftSquareBracket);
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << True) | (1L << False) | (1L << New) | (1L << LambdaVariable) | (1L << LeftBracket) | (1L << LeftCurlyBracket) | (1L << LeftSquareBracket) | (1L << Identifier) | (1L << Integer) | (1L << FloatNumber) | (1L << StringConstant))) != 0)) {
					{
					setState(263);
					expression(0);
					setState(268);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(264);
						match(Comma);
						setState(265);
						expression(0);
						}
						}
						setState(270);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(273);
				match(RightSquareBracket);
				}
				break;
			case 3:
				{
				_localctx = new NewObjectExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(274);
				match(New);
				setState(275);
				match(Identifier);
				setState(288);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(276);
					match(LeftBracket);
					setState(285);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << True) | (1L << False) | (1L << New) | (1L << LambdaVariable) | (1L << LeftBracket) | (1L << LeftCurlyBracket) | (1L << LeftSquareBracket) | (1L << Identifier) | (1L << Integer) | (1L << FloatNumber) | (1L << StringConstant))) != 0)) {
						{
						setState(277);
						expression(0);
						setState(282);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==Comma) {
							{
							{
							setState(278);
							match(Comma);
							setState(279);
							expression(0);
							}
							}
							setState(284);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(287);
					match(RightBracket);
					}
					break;
				}
				}
				break;
			case 4:
				{
				_localctx = new LambdaFunctionExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(290);
				match(LeftCurlyBracket);
				setState(292); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(291);
					functionInstructions();
					}
					}
					setState(294); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Return) | (1L << TransformBlockStart) | (1L << FunctionDefStart) | (1L << Var) | (1L << True) | (1L << False) | (1L << Pure) | (1L << Impure) | (1L << Memoized) | (1L << If) | (1L << While) | (1L << StructStart) | (1L << New) | (1L << Import) | (1L << ImportMethod) | (1L << LambdaVariable) | (1L << LeftBracket) | (1L << LeftCurlyBracket) | (1L << LeftSquareBracket) | (1L << Identifier) | (1L << Integer) | (1L << FloatNumber) | (1L << StringConstant))) != 0) );
				setState(296);
				match(RightCurlyBracket);
				}
				break;
			case 5:
				{
				_localctx = new CallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(298);
				functionCall();
				}
				break;
			case 6:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(299);
				match(Identifier);
				}
				break;
			case 7:
				{
				_localctx = new CoupleExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(300);
				couple();
				}
				break;
			case 8:
				{
				_localctx = new IntExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(301);
				match(Integer);
				}
				break;
			case 9:
				{
				_localctx = new FloatExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(302);
				match(FloatNumber);
				}
				break;
			case 10:
				{
				_localctx = new WrappedExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(303);
				match(LeftBracket);
				setState(304);
				expression(0);
				setState(305);
				match(RightBracket);
				}
				break;
			case 11:
				{
				_localctx = new BoolTrueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(307);
				match(True);
				}
				break;
			case 12:
				{
				_localctx = new BoolFalseExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(308);
				match(False);
				}
				break;
			case 13:
				{
				_localctx = new StringExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(309);
				match(StringConstant);
				}
				break;
			case 14:
				{
				_localctx = new UnitExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(310);
				match(LeftBracket);
				setState(311);
				match(RightBracket);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(366);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(364);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
					case 1:
						{
						_localctx = new DivExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(314);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(315);
						match(DivOperator);
						setState(316);
						expression(16);
						}
						break;
					case 2:
						{
						_localctx = new MultExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(317);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(318);
						match(MultOperator);
						setState(319);
						expression(15);
						}
						break;
					case 3:
						{
						_localctx = new SubExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(320);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(321);
						match(SubOperator);
						setState(322);
						expression(14);
						}
						break;
					case 4:
						{
						_localctx = new AddExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(323);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(324);
						match(AddOperator);
						setState(325);
						expression(13);
						}
						break;
					case 5:
						{
						_localctx = new LessExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(326);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(327);
						match(Less);
						setState(328);
						expression(12);
						}
						break;
					case 6:
						{
						_localctx = new LessEqualExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(329);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(330);
						match(LessEqual);
						setState(331);
						expression(11);
						}
						break;
					case 7:
						{
						_localctx = new GreaterExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(332);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(333);
						match(Greater);
						setState(334);
						expression(10);
						}
						break;
					case 8:
						{
						_localctx = new GreaterEqualExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(335);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(336);
						match(GreaterEqual);
						setState(337);
						expression(9);
						}
						break;
					case 9:
						{
						_localctx = new EqualityContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(338);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(339);
						match(Equals);
						setState(340);
						match(Equals);
						setState(341);
						expression(8);
						}
						break;
					case 10:
						{
						_localctx = new InequalityContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(342);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(343);
						match(Bang);
						setState(344);
						match(Equals);
						setState(345);
						expression(7);
						}
						break;
					case 11:
						{
						_localctx = new AccessArrayExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(346);
						if (!(precpred(_ctx, 27))) throw new FailedPredicateException(this, "precpred(_ctx, 27)");
						setState(347);
						match(LeftSquareBracket);
						setState(348);
						expression(0);
						setState(349);
						match(RightSquareBracket);
						}
						break;
					case 12:
						{
						_localctx = new LoadAndRetypeExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(351);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(352);
						match(Colon);
						setState(353);
						type();
						}
						break;
					case 13:
						{
						_localctx = new AccessExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(354);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(357); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(355);
								match(Period);
								setState(356);
								match(Identifier);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(359); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					case 14:
						{
						_localctx = new CastExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(361);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(362);
						match(RightLightArrow);
						setState(363);
						type();
						}
						break;
					}
					} 
				}
				setState(368);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CoupleContext extends ParserRuleContext {
		public TerminalNode LeftBracket() { return getToken(EuclinParser.LeftBracket, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Comma() { return getToken(EuclinParser.Comma, 0); }
		public TerminalNode RightBracket() { return getToken(EuclinParser.RightBracket, 0); }
		public CoupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_couple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterCouple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitCouple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitCouple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CoupleContext couple() throws RecognitionException {
		CoupleContext _localctx = new CoupleContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_couple);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			match(LeftBracket);
			setState(370);
			expression(0);
			setState(371);
			match(Comma);
			setState(372);
			expression(0);
			setState(373);
			match(RightBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionIdentifierContext extends ParserRuleContext {
		public FunctionIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionIdentifier; }
	 
		public FunctionIdentifierContext() { }
		public void copyFrom(FunctionIdentifierContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DirectFunctionIdentifierContext extends FunctionIdentifierContext {
		public TerminalNode Identifier() { return getToken(EuclinParser.Identifier, 0); }
		public DirectFunctionIdentifierContext(FunctionIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterDirectFunctionIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitDirectFunctionIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitDirectFunctionIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MemberFunctionIdentifierContext extends FunctionIdentifierContext {
		public List<TerminalNode> Identifier() { return getTokens(EuclinParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(EuclinParser.Identifier, i);
		}
		public List<TerminalNode> Period() { return getTokens(EuclinParser.Period); }
		public TerminalNode Period(int i) {
			return getToken(EuclinParser.Period, i);
		}
		public MemberFunctionIdentifierContext(FunctionIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterMemberFunctionIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitMemberFunctionIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitMemberFunctionIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionIdentifierContext functionIdentifier() throws RecognitionException {
		FunctionIdentifierContext _localctx = new FunctionIdentifierContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_functionIdentifier);
		int _la;
		try {
			setState(383);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				_localctx = new DirectFunctionIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(375);
				match(Identifier);
				}
				break;
			case 2:
				_localctx = new MemberFunctionIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(376);
				match(Identifier);
				setState(379); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(377);
					match(Period);
					setState(378);
					match(Identifier);
					}
					}
					setState(381); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==Period );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 18:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 15);
		case 1:
			return precpred(_ctx, 14);
		case 2:
			return precpred(_ctx, 13);
		case 3:
			return precpred(_ctx, 12);
		case 4:
			return precpred(_ctx, 11);
		case 5:
			return precpred(_ctx, 10);
		case 6:
			return precpred(_ctx, 9);
		case 7:
			return precpred(_ctx, 8);
		case 8:
			return precpred(_ctx, 7);
		case 9:
			return precpred(_ctx, 6);
		case 10:
			return precpred(_ctx, 27);
		case 11:
			return precpred(_ctx, 25);
		case 12:
			return precpred(_ctx, 22);
		case 13:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\62\u0184\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\7\2.\n\2\f\2\16\2\61\13\2"+
		"\3\3\6\3\64\n\3\r\3\16\3\65\3\4\3\4\3\4\5\4;\n\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5L\n\5\f\5\16\5O\13\5\3\5\3\5"+
		"\5\5S\n\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5[\n\5\f\5\16\5^\13\5\3\5\3\5\5\5"+
		"b\n\5\3\6\3\6\3\6\3\6\7\6h\n\6\f\6\16\6k\13\6\3\6\5\6n\n\6\3\7\3\7\3\7"+
		"\3\7\7\7t\n\7\f\7\16\7w\13\7\3\7\5\7z\n\7\3\7\3\7\3\7\3\7\7\7\u0080\n"+
		"\7\f\7\16\7\u0083\13\7\3\7\3\7\5\7\u0087\n\7\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\7\t\u0090\n\t\f\t\16\t\u0093\13\t\3\t\3\t\3\n\3\n\3\n\7\n\u009a\n\n"+
		"\f\n\16\n\u009d\13\n\3\n\3\n\3\13\3\13\3\13\3\13\7\13\u00a5\n\13\f\13"+
		"\16\13\u00a8\13\13\5\13\u00aa\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00bf"+
		"\n\13\3\f\3\f\3\f\3\f\3\r\7\r\u00c6\n\r\f\r\16\r\u00c9\13\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\7\r\u00d1\n\r\f\r\16\r\u00d4\13\r\5\r\u00d6\n\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\7\17\u00e6\n\17"+
		"\f\17\16\17\u00e9\13\17\5\17\u00eb\n\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\6\22\u00fb\n\22\r\22\16\22\u00fc"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\7\24\u010d\n\24\f\24\16\24\u0110\13\24\5\24\u0112\n\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\7\24\u011b\n\24\f\24\16\24\u011e\13\24\5\24\u0120"+
		"\n\24\3\24\5\24\u0123\n\24\3\24\3\24\6\24\u0127\n\24\r\24\16\24\u0128"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\5\24\u013b\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\6\24\u0168\n\24\r\24\16\24\u0169\3\24\3"+
		"\24\3\24\7\24\u016f\n\24\f\24\16\24\u0172\13\24\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\26\3\26\3\26\3\26\6\26\u017e\n\26\r\26\16\26\u017f\5\26\u0182"+
		"\n\26\3\26\2\3&\27\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*\2\3\3"+
		"\2\n\f\2\u01b7\2/\3\2\2\2\4\63\3\2\2\2\6:\3\2\2\2\ba\3\2\2\2\nc\3\2\2"+
		"\2\f\u0086\3\2\2\2\16\u0088\3\2\2\2\20\u008b\3\2\2\2\22\u0096\3\2\2\2"+
		"\24\u00be\3\2\2\2\26\u00c0\3\2\2\2\30\u00c7\3\2\2\2\32\u00de\3\2\2\2\34"+
		"\u00e0\3\2\2\2\36\u00ee\3\2\2\2 \u00f3\3\2\2\2\"\u00f7\3\2\2\2$\u0101"+
		"\3\2\2\2&\u013a\3\2\2\2(\u0173\3\2\2\2*\u0181\3\2\2\2,.\5\b\5\2-,\3\2"+
		"\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\3\3\2\2\2\61/\3\2\2\2\62\64"+
		"\5\6\4\2\63\62\3\2\2\2\64\65\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\5"+
		"\3\2\2\2\67;\5\b\5\289\7\4\2\29;\5&\24\2:\67\3\2\2\2:8\3\2\2\2;\7\3\2"+
		"\2\2<b\5\n\6\2=b\5\f\7\2>b\5&\24\2?b\5\36\20\2@b\5\20\t\2Ab\5 \21\2Bb"+
		"\5\"\22\2Cb\5$\23\2Db\5\30\r\2EF\7\16\2\2FG\7\25\2\2GH\5&\24\2HI\7\26"+
		"\2\2IM\7\27\2\2JL\5\6\4\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NP\3"+
		"\2\2\2OM\3\2\2\2PR\7\30\2\2QS\5\22\n\2RQ\3\2\2\2RS\3\2\2\2Sb\3\2\2\2T"+
		"U\7\17\2\2UV\7\25\2\2VW\5&\24\2WX\7\26\2\2X\\\7\27\2\2Y[\5\6\4\2ZY\3\2"+
		"\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]_\3\2\2\2^\\\3\2\2\2_`\7\30\2\2`"+
		"b\3\2\2\2a<\3\2\2\2a=\3\2\2\2a>\3\2\2\2a?\3\2\2\2a@\3\2\2\2aA\3\2\2\2"+
		"aB\3\2\2\2aC\3\2\2\2aD\3\2\2\2aE\3\2\2\2aT\3\2\2\2b\t\3\2\2\2cd\7\22\2"+
		"\2di\7(\2\2ef\7\34\2\2fh\7(\2\2ge\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2"+
		"\2jm\3\2\2\2ki\3\2\2\2ln\5\16\b\2ml\3\2\2\2mn\3\2\2\2n\13\3\2\2\2op\7"+
		"\23\2\2pu\7(\2\2qr\7\34\2\2rt\7(\2\2sq\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3"+
		"\2\2\2vy\3\2\2\2wu\3\2\2\2xz\5\16\b\2yx\3\2\2\2yz\3\2\2\2z\u0087\3\2\2"+
		"\2{|\7\23\2\2|\u0081\7(\2\2}~\7\34\2\2~\u0080\7(\2\2\177}\3\2\2\2\u0080"+
		"\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0084\3\2\2"+
		"\2\u0083\u0081\3\2\2\2\u0084\u0085\7\34\2\2\u0085\u0087\7\'\2\2\u0086"+
		"o\3\2\2\2\u0086{\3\2\2\2\u0087\r\3\2\2\2\u0088\u0089\7\3\2\2\u0089\u008a"+
		"\7(\2\2\u008a\17\3\2\2\2\u008b\u008c\7\20\2\2\u008c\u008d\7(\2\2\u008d"+
		"\u0091\7\27\2\2\u008e\u0090\5\26\f\2\u008f\u008e\3\2\2\2\u0090\u0093\3"+
		"\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094\3\2\2\2\u0093"+
		"\u0091\3\2\2\2\u0094\u0095\7\30\2\2\u0095\21\3\2\2\2\u0096\u0097\7\r\2"+
		"\2\u0097\u009b\7\27\2\2\u0098\u009a\5\6\4\2\u0099\u0098\3\2\2\2\u009a"+
		"\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009e\3\2"+
		"\2\2\u009d\u009b\3\2\2\2\u009e\u009f\7\30\2\2\u009f\23\3\2\2\2\u00a0\u00a9"+
		"\7\25\2\2\u00a1\u00a6\5\24\13\2\u00a2\u00a3\7\33\2\2\u00a3\u00a5\5\24"+
		"\13\2\u00a4\u00a2\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6"+
		"\u00a7\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00a1\3\2"+
		"\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\7\26\2\2\u00ac"+
		"\u00ad\7 \2\2\u00ad\u00bf\5\24\13\2\u00ae\u00af\7\25\2\2\u00af\u00b0\5"+
		"\24\13\2\u00b0\u00b1\7\33\2\2\u00b1\u00b2\5\24\13\2\u00b2\u00b3\7\26\2"+
		"\2\u00b3\u00bf\3\2\2\2\u00b4\u00b5\7\25\2\2\u00b5\u00b6\5\24\13\2\u00b6"+
		"\u00b7\7\26\2\2\u00b7\u00bf\3\2\2\2\u00b8\u00bf\7(\2\2\u00b9\u00bf\7\'"+
		"\2\2\u00ba\u00bb\7\31\2\2\u00bb\u00bc\5\24\13\2\u00bc\u00bd\7\32\2\2\u00bd"+
		"\u00bf\3\2\2\2\u00be\u00a0\3\2\2\2\u00be\u00ae\3\2\2\2\u00be\u00b4\3\2"+
		"\2\2\u00be\u00b8\3\2\2\2\u00be\u00b9\3\2\2\2\u00be\u00ba\3\2\2\2\u00bf"+
		"\25\3\2\2\2\u00c0\u00c1\7(\2\2\u00c1\u00c2\7\35\2\2\u00c2\u00c3\5\24\13"+
		"\2\u00c3\27\3\2\2\2\u00c4\u00c6\5\32\16\2\u00c5\u00c4\3\2\2\2\u00c6\u00c9"+
		"\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9"+
		"\u00c7\3\2\2\2\u00ca\u00cb\7\6\2\2\u00cb\u00cc\7(\2\2\u00cc\u00d5\7\25"+
		"\2\2\u00cd\u00d2\5\26\f\2\u00ce\u00cf\7\33\2\2\u00cf\u00d1\5\26\f\2\u00d0"+
		"\u00ce\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2"+
		"\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00cd\3\2\2\2\u00d5"+
		"\u00d6\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\7\26\2\2\u00d8\u00d9\7"+
		"\35\2\2\u00d9\u00da\5\24\13\2\u00da\u00db\7\27\2\2\u00db\u00dc\5\4\3\2"+
		"\u00dc\u00dd\7\30\2\2\u00dd\31\3\2\2\2\u00de\u00df\t\2\2\2\u00df\33\3"+
		"\2\2\2\u00e0\u00e1\5*\26\2\u00e1\u00ea\7\25\2\2\u00e2\u00e7\5&\24\2\u00e3"+
		"\u00e4\7\33\2\2\u00e4\u00e6\5&\24\2\u00e5\u00e3\3\2\2\2\u00e6\u00e9\3"+
		"\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9"+
		"\u00e7\3\2\2\2\u00ea\u00e2\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ec\3\2"+
		"\2\2\u00ec\u00ed\7\26\2\2\u00ed\35\3\2\2\2\u00ee\u00ef\7\7\2\2\u00ef\u00f0"+
		"\7(\2\2\u00f0\u00f1\7\37\2\2\u00f1\u00f2\5&\24\2\u00f2\37\3\2\2\2\u00f3"+
		"\u00f4\7(\2\2\u00f4\u00f5\7\37\2\2\u00f5\u00f6\5&\24\2\u00f6!\3\2\2\2"+
		"\u00f7\u00fa\5&\24\2\u00f8\u00f9\7\34\2\2\u00f9\u00fb\7(\2\2\u00fa\u00f8"+
		"\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"\u00fe\3\2\2\2\u00fe\u00ff\7\37\2\2\u00ff\u0100\5&\24\2\u0100#\3\2\2\2"+
		"\u0101\u0102\7\5\2\2\u0102\u0103\7\27\2\2\u0103\u0104\5\2\2\2\u0104\u0105"+
		"\7\30\2\2\u0105%\3\2\2\2\u0106\u0107\b\24\1\2\u0107\u013b\7\24\2\2\u0108"+
		"\u0111\7\31\2\2\u0109\u010e\5&\24\2\u010a\u010b\7\33\2\2\u010b\u010d\5"+
		"&\24\2\u010c\u010a\3\2\2\2\u010d\u0110\3\2\2\2\u010e\u010c\3\2\2\2\u010e"+
		"\u010f\3\2\2\2\u010f\u0112\3\2\2\2\u0110\u010e\3\2\2\2\u0111\u0109\3\2"+
		"\2\2\u0111\u0112\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u013b\7\32\2\2\u0114"+
		"\u0115\7\21\2\2\u0115\u0122\7(\2\2\u0116\u011f\7\25\2\2\u0117\u011c\5"+
		"&\24\2\u0118\u0119\7\33\2\2\u0119\u011b\5&\24\2\u011a\u0118\3\2\2\2\u011b"+
		"\u011e\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u0120\3\2"+
		"\2\2\u011e\u011c\3\2\2\2\u011f\u0117\3\2\2\2\u011f\u0120\3\2\2\2\u0120"+
		"\u0121\3\2\2\2\u0121\u0123\7\26\2\2\u0122\u0116\3\2\2\2\u0122\u0123\3"+
		"\2\2\2\u0123\u013b\3\2\2\2\u0124\u0126\7\27\2\2\u0125\u0127\5\6\4\2\u0126"+
		"\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2"+
		"\2\2\u0129\u012a\3\2\2\2\u012a\u012b\7\30\2\2\u012b\u013b\3\2\2\2\u012c"+
		"\u013b\5\34\17\2\u012d\u013b\7(\2\2\u012e\u013b\5(\25\2\u012f\u013b\7"+
		")\2\2\u0130\u013b\7*\2\2\u0131\u0132\7\25\2\2\u0132\u0133\5&\24\2\u0133"+
		"\u0134\7\26\2\2\u0134\u013b\3\2\2\2\u0135\u013b\7\b\2\2\u0136\u013b\7"+
		"\t\2\2\u0137\u013b\7/\2\2\u0138\u0139\7\25\2\2\u0139\u013b\7\26\2\2\u013a"+
		"\u0106\3\2\2\2\u013a\u0108\3\2\2\2\u013a\u0114\3\2\2\2\u013a\u0124\3\2"+
		"\2\2\u013a\u012c\3\2\2\2\u013a\u012d\3\2\2\2\u013a\u012e\3\2\2\2\u013a"+
		"\u012f\3\2\2\2\u013a\u0130\3\2\2\2\u013a\u0131\3\2\2\2\u013a\u0135\3\2"+
		"\2\2\u013a\u0136\3\2\2\2\u013a\u0137\3\2\2\2\u013a\u0138\3\2\2\2\u013b"+
		"\u0170\3\2\2\2\u013c\u013d\f\21\2\2\u013d\u013e\7,\2\2\u013e\u016f\5&"+
		"\24\22\u013f\u0140\f\20\2\2\u0140\u0141\7+\2\2\u0141\u016f\5&\24\21\u0142"+
		"\u0143\f\17\2\2\u0143\u0144\7.\2\2\u0144\u016f\5&\24\20\u0145\u0146\f"+
		"\16\2\2\u0146\u0147\7-\2\2\u0147\u016f\5&\24\17\u0148\u0149\f\r\2\2\u0149"+
		"\u014a\7#\2\2\u014a\u016f\5&\24\16\u014b\u014c\f\f\2\2\u014c\u014d\7$"+
		"\2\2\u014d\u016f\5&\24\r\u014e\u014f\f\13\2\2\u014f\u0150\7%\2\2\u0150"+
		"\u016f\5&\24\f\u0151\u0152\f\n\2\2\u0152\u0153\7&\2\2\u0153\u016f\5&\24"+
		"\13\u0154\u0155\f\t\2\2\u0155\u0156\7\37\2\2\u0156\u0157\7\37\2\2\u0157"+
		"\u016f\5&\24\n\u0158\u0159\f\b\2\2\u0159\u015a\7\"\2\2\u015a\u015b\7\37"+
		"\2\2\u015b\u016f\5&\24\t\u015c\u015d\f\35\2\2\u015d\u015e\7\31\2\2\u015e"+
		"\u015f\5&\24\2\u015f\u0160\7\32\2\2\u0160\u016f\3\2\2\2\u0161\u0162\f"+
		"\33\2\2\u0162\u0163\7\35\2\2\u0163\u016f\5\24\13\2\u0164\u0167\f\30\2"+
		"\2\u0165\u0166\7\34\2\2\u0166\u0168\7(\2\2\u0167\u0165\3\2\2\2\u0168\u0169"+
		"\3\2\2\2\u0169\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u016f\3\2\2\2\u016b"+
		"\u016c\f\3\2\2\u016c\u016d\7!\2\2\u016d\u016f\5\24\13\2\u016e\u013c\3"+
		"\2\2\2\u016e\u013f\3\2\2\2\u016e\u0142\3\2\2\2\u016e\u0145\3\2\2\2\u016e"+
		"\u0148\3\2\2\2\u016e\u014b\3\2\2\2\u016e\u014e\3\2\2\2\u016e\u0151\3\2"+
		"\2\2\u016e\u0154\3\2\2\2\u016e\u0158\3\2\2\2\u016e\u015c\3\2\2\2\u016e"+
		"\u0161\3\2\2\2\u016e\u0164\3\2\2\2\u016e\u016b\3\2\2\2\u016f\u0172\3\2"+
		"\2\2\u0170\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171\'\3\2\2\2\u0172\u0170"+
		"\3\2\2\2\u0173\u0174\7\25\2\2\u0174\u0175\5&\24\2\u0175\u0176\7\33\2\2"+
		"\u0176\u0177\5&\24\2\u0177\u0178\7\26\2\2\u0178)\3\2\2\2\u0179\u0182\7"+
		"(\2\2\u017a\u017d\7(\2\2\u017b\u017c\7\34\2\2\u017c\u017e\7(\2\2\u017d"+
		"\u017b\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u017d\3\2\2\2\u017f\u0180\3\2"+
		"\2\2\u0180\u0182\3\2\2\2\u0181\u0179\3\2\2\2\u0181\u017a\3\2\2\2\u0182"+
		"+\3\2\2\2&/\65:MR\\aimuy\u0081\u0086\u0091\u009b\u00a6\u00a9\u00be\u00c7"+
		"\u00d2\u00d5\u00e7\u00ea\u00fc\u010e\u0111\u011c\u011f\u0122\u0128\u013a"+
		"\u0169\u016e\u0170\u017f\u0181";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}