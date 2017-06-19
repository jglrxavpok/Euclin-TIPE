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
		Return=1, TransformBlockStart=2, FunctionDefStart=3, Var=4, True=5, False=6, 
		Pure=7, Impure=8, Memoized=9, Else=10, If=11, While=12, LambdaVariable=13, 
		LeftBracket=14, RightBracket=15, LeftCurlyBracket=16, RightCurlyBracket=17, 
		LeftSquareBracket=18, RightSquareBracket=19, Comma=20, Period=21, Colon=22, 
		SemiColon=23, Equals=24, LightArrow=25, Bang=26, Less=27, LessEqual=28, 
		Greater=29, GreaterEqual=30, Identifier=31, Integer=32, FloatNumber=33, 
		MultOperator=34, DivOperator=35, AddOperator=36, SubOperator=37, StringConstant=38, 
		LineComment=39, MultilineComment=40, Whitespace=41;
	public static final int
		RULE_codeBlock = 0, RULE_functionCodeBlock = 1, RULE_functionInstructions = 2, 
		RULE_instructions = 3, RULE_elseBlock = 4, RULE_type = 5, RULE_parameter = 6, 
		RULE_functionDeclaration = 7, RULE_modifiers = 8, RULE_functionCall = 9, 
		RULE_variableDeclaration = 10, RULE_variableAssign = 11, RULE_memberAssign = 12, 
		RULE_transformBlock = 13, RULE_expression = 14, RULE_couple = 15;
	public static final String[] ruleNames = {
		"codeBlock", "functionCodeBlock", "functionInstructions", "instructions", 
		"elseBlock", "type", "parameter", "functionDeclaration", "modifiers", 
		"functionCall", "variableDeclaration", "variableAssign", "memberAssign", 
		"transformBlock", "expression", "couple"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'return'", "'transform'", "'func'", "'var'", "'true'", "'false'", 
		"'pure'", "'impure'", "'memoized'", "'else'", "'if'", "'while'", "'_'", 
		"'('", "')'", "'{'", "'}'", "'['", "']'", "','", "'.'", "':'", "';'", 
		"'='", "'->'", "'!'", "'<'", "'<='", "'>'", "'>='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Return", "TransformBlockStart", "FunctionDefStart", "Var", "True", 
		"False", "Pure", "Impure", "Memoized", "Else", "If", "While", "LambdaVariable", 
		"LeftBracket", "RightBracket", "LeftCurlyBracket", "RightCurlyBracket", 
		"LeftSquareBracket", "RightSquareBracket", "Comma", "Period", "Colon", 
		"SemiColon", "Equals", "LightArrow", "Bang", "Less", "LessEqual", "Greater", 
		"GreaterEqual", "Identifier", "Integer", "FloatNumber", "MultOperator", 
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
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TransformBlockStart) | (1L << FunctionDefStart) | (1L << Var) | (1L << True) | (1L << False) | (1L << Pure) | (1L << Impure) | (1L << Memoized) | (1L << If) | (1L << While) | (1L << LambdaVariable) | (1L << LeftBracket) | (1L << LeftSquareBracket) | (1L << Identifier) | (1L << Integer) | (1L << FloatNumber) | (1L << StringConstant))) != 0)) {
				{
				{
				setState(32);
				instructions();
				}
				}
				setState(37);
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
			setState(39); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(38);
				functionInstructions();
				}
				}
				setState(41); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Return) | (1L << TransformBlockStart) | (1L << FunctionDefStart) | (1L << Var) | (1L << True) | (1L << False) | (1L << Pure) | (1L << Impure) | (1L << Memoized) | (1L << If) | (1L << While) | (1L << LambdaVariable) | (1L << LeftBracket) | (1L << LeftSquareBracket) | (1L << Identifier) | (1L << Integer) | (1L << FloatNumber) | (1L << StringConstant))) != 0) );
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
			setState(46);
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
			case LambdaVariable:
			case LeftBracket:
			case LeftSquareBracket:
			case Identifier:
			case Integer:
			case FloatNumber:
			case StringConstant:
				_localctx = new InstructionFuncInstructionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				instructions();
				}
				break;
			case Return:
				_localctx = new ReturnFuncInstructionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				match(Return);
				setState(45);
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
		public List<InstructionsContext> instructions() {
			return getRuleContexts(InstructionsContext.class);
		}
		public InstructionsContext instructions(int i) {
			return getRuleContext(InstructionsContext.class,i);
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
	public static class IfBranchingInstructionContext extends InstructionsContext {
		public TerminalNode If() { return getToken(EuclinParser.If, 0); }
		public TerminalNode LeftBracket() { return getToken(EuclinParser.LeftBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightBracket() { return getToken(EuclinParser.RightBracket, 0); }
		public TerminalNode LeftCurlyBracket() { return getToken(EuclinParser.LeftCurlyBracket, 0); }
		public TerminalNode RightCurlyBracket() { return getToken(EuclinParser.RightCurlyBracket, 0); }
		public List<InstructionsContext> instructions() {
			return getRuleContexts(InstructionsContext.class);
		}
		public InstructionsContext instructions(int i) {
			return getRuleContext(InstructionsContext.class,i);
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

	public final InstructionsContext instructions() throws RecognitionException {
		InstructionsContext _localctx = new InstructionsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instructions);
		int _la;
		try {
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new ExpressionInstructionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				expression(0);
				}
				break;
			case 2:
				_localctx = new DeclareVarInstructionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				variableDeclaration();
				}
				break;
			case 3:
				_localctx = new AssignVarInstructionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				variableAssign();
				}
				break;
			case 4:
				_localctx = new AssignMemberInstructionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(51);
				memberAssign();
				}
				break;
			case 5:
				_localctx = new TransformBlockInstructionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(52);
				transformBlock();
				}
				break;
			case 6:
				_localctx = new DeclareFuncInstructionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(53);
				functionDeclaration();
				}
				break;
			case 7:
				_localctx = new IfBranchingInstructionContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(54);
				match(If);
				setState(55);
				match(LeftBracket);
				setState(56);
				expression(0);
				setState(57);
				match(RightBracket);
				setState(58);
				match(LeftCurlyBracket);
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TransformBlockStart) | (1L << FunctionDefStart) | (1L << Var) | (1L << True) | (1L << False) | (1L << Pure) | (1L << Impure) | (1L << Memoized) | (1L << If) | (1L << While) | (1L << LambdaVariable) | (1L << LeftBracket) | (1L << LeftSquareBracket) | (1L << Identifier) | (1L << Integer) | (1L << FloatNumber) | (1L << StringConstant))) != 0)) {
					{
					{
					setState(59);
					instructions();
					}
					}
					setState(64);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(65);
				match(RightCurlyBracket);
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Else) {
					{
					setState(66);
					elseBlock();
					}
				}

				}
				break;
			case 8:
				_localctx = new WhileLoopInstructionContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(69);
				match(While);
				setState(70);
				match(LeftBracket);
				setState(71);
				expression(0);
				setState(72);
				match(RightBracket);
				setState(73);
				match(LeftCurlyBracket);
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TransformBlockStart) | (1L << FunctionDefStart) | (1L << Var) | (1L << True) | (1L << False) | (1L << Pure) | (1L << Impure) | (1L << Memoized) | (1L << If) | (1L << While) | (1L << LambdaVariable) | (1L << LeftBracket) | (1L << LeftSquareBracket) | (1L << Identifier) | (1L << Integer) | (1L << FloatNumber) | (1L << StringConstant))) != 0)) {
					{
					{
					setState(74);
					instructions();
					}
					}
					setState(79);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(80);
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

	public static class ElseBlockContext extends ParserRuleContext {
		public TerminalNode Else() { return getToken(EuclinParser.Else, 0); }
		public TerminalNode LeftCurlyBracket() { return getToken(EuclinParser.LeftCurlyBracket, 0); }
		public TerminalNode RightCurlyBracket() { return getToken(EuclinParser.RightCurlyBracket, 0); }
		public List<InstructionsContext> instructions() {
			return getRuleContexts(InstructionsContext.class);
		}
		public InstructionsContext instructions(int i) {
			return getRuleContext(InstructionsContext.class,i);
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
		enterRule(_localctx, 8, RULE_elseBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(Else);
			setState(85);
			match(LeftCurlyBracket);
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TransformBlockStart) | (1L << FunctionDefStart) | (1L << Var) | (1L << True) | (1L << False) | (1L << Pure) | (1L << Impure) | (1L << Memoized) | (1L << If) | (1L << While) | (1L << LambdaVariable) | (1L << LeftBracket) | (1L << LeftSquareBracket) | (1L << Identifier) | (1L << Integer) | (1L << FloatNumber) | (1L << StringConstant))) != 0)) {
				{
				{
				setState(86);
				instructions();
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(92);
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
		enterRule(_localctx, 10, RULE_type);
		int _la;
		try {
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new FunctionTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				match(LeftBracket);
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftBracket || _la==Identifier) {
					{
					setState(95);
					type();
					setState(100);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(96);
						match(Comma);
						setState(97);
						type();
						}
						}
						setState(102);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(105);
				match(RightBracket);
				setState(106);
				match(LightArrow);
				setState(107);
				type();
				}
				break;
			case 2:
				_localctx = new CoupleTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				match(LeftBracket);
				setState(109);
				type();
				setState(110);
				match(Comma);
				setState(111);
				type();
				setState(112);
				match(RightBracket);
				}
				break;
			case 3:
				_localctx = new WrappedTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(114);
				match(LeftBracket);
				setState(115);
				type();
				setState(116);
				match(RightBracket);
				}
				break;
			case 4:
				_localctx = new BasicTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(118);
				match(Identifier);
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
		enterRule(_localctx, 12, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(Identifier);
			setState(122);
			match(Colon);
			setState(123);
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
		enterRule(_localctx, 14, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Pure) | (1L << Impure) | (1L << Memoized))) != 0)) {
				{
				{
				setState(125);
				modifiers();
				}
				}
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(131);
			match(FunctionDefStart);
			setState(132);
			match(Identifier);
			setState(133);
			match(LeftBracket);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(134);
				parameter();
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(135);
					match(Comma);
					setState(136);
					parameter();
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(144);
			match(RightBracket);
			setState(145);
			match(Colon);
			setState(146);
			type();
			setState(147);
			match(LeftCurlyBracket);
			setState(148);
			functionCodeBlock();
			setState(149);
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
		enterRule(_localctx, 16, RULE_modifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
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
		enterRule(_localctx, 18, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(Identifier);
			setState(154);
			match(LeftBracket);
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << True) | (1L << False) | (1L << LambdaVariable) | (1L << LeftBracket) | (1L << LeftSquareBracket) | (1L << Identifier) | (1L << Integer) | (1L << FloatNumber) | (1L << StringConstant))) != 0)) {
				{
				setState(155);
				expression(0);
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(156);
					match(Comma);
					setState(157);
					expression(0);
					}
					}
					setState(162);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(165);
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
		enterRule(_localctx, 20, RULE_variableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(Var);
			setState(168);
			match(Identifier);
			setState(169);
			match(Equals);
			setState(170);
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
		enterRule(_localctx, 22, RULE_variableAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(Identifier);
			setState(173);
			match(Equals);
			setState(174);
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
		enterRule(_localctx, 24, RULE_memberAssign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			expression(0);
			setState(179); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(177);
				match(Period);
				setState(178);
				match(Identifier);
				}
				}
				setState(181); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Period );
			setState(183);
			match(Equals);
			setState(184);
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
		enterRule(_localctx, 26, RULE_transformBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(TransformBlockStart);
			setState(187);
			match(LeftCurlyBracket);
			setState(188);
			codeBlock();
			setState(189);
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
	public static class LambdaFunctionExprContext extends ExpressionContext {
		public TerminalNode LeftSquareBracket() { return getToken(EuclinParser.LeftSquareBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightSquareBracket() { return getToken(EuclinParser.RightSquareBracket, 0); }
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				_localctx = new LambdaVarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(192);
				match(LambdaVariable);
				}
				break;
			case 2:
				{
				_localctx = new LambdaFunctionExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(193);
				match(LeftSquareBracket);
				setState(194);
				expression(0);
				setState(195);
				match(RightSquareBracket);
				}
				break;
			case 3:
				{
				_localctx = new CallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(197);
				functionCall();
				}
				break;
			case 4:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(198);
				match(Identifier);
				}
				break;
			case 5:
				{
				_localctx = new CoupleExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(199);
				couple();
				}
				break;
			case 6:
				{
				_localctx = new IntExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(200);
				match(Integer);
				}
				break;
			case 7:
				{
				_localctx = new FloatExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(201);
				match(FloatNumber);
				}
				break;
			case 8:
				{
				_localctx = new WrappedExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(202);
				match(LeftBracket);
				setState(203);
				expression(0);
				setState(204);
				match(RightBracket);
				}
				break;
			case 9:
				{
				_localctx = new BoolTrueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(206);
				match(True);
				}
				break;
			case 10:
				{
				_localctx = new BoolFalseExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(207);
				match(False);
				}
				break;
			case 11:
				{
				_localctx = new StringExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(208);
				match(StringConstant);
				}
				break;
			case 12:
				{
				_localctx = new UnitExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(209);
				match(LeftBracket);
				setState(210);
				match(RightBracket);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(254);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(252);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new DivExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(213);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(214);
						match(DivOperator);
						setState(215);
						expression(15);
						}
						break;
					case 2:
						{
						_localctx = new MultExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(216);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(217);
						match(MultOperator);
						setState(218);
						expression(14);
						}
						break;
					case 3:
						{
						_localctx = new SubExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(219);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(220);
						match(SubOperator);
						setState(221);
						expression(13);
						}
						break;
					case 4:
						{
						_localctx = new AddExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(222);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(223);
						match(AddOperator);
						setState(224);
						expression(12);
						}
						break;
					case 5:
						{
						_localctx = new LessExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(225);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(226);
						match(Less);
						setState(227);
						expression(11);
						}
						break;
					case 6:
						{
						_localctx = new LessEqualExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(228);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(229);
						match(LessEqual);
						setState(230);
						expression(10);
						}
						break;
					case 7:
						{
						_localctx = new GreaterExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(231);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(232);
						match(Greater);
						setState(233);
						expression(9);
						}
						break;
					case 8:
						{
						_localctx = new GreaterEqualExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(234);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(235);
						match(GreaterEqual);
						setState(236);
						expression(8);
						}
						break;
					case 9:
						{
						_localctx = new EqualityContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(237);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(238);
						match(Equals);
						setState(239);
						match(Equals);
						setState(240);
						expression(7);
						}
						break;
					case 10:
						{
						_localctx = new InequalityContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(241);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(242);
						match(Bang);
						setState(243);
						match(Equals);
						setState(244);
						expression(6);
						}
						break;
					case 11:
						{
						_localctx = new AccessExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(245);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(248); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(246);
								match(Period);
								setState(247);
								match(Identifier);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(250); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					}
					} 
				}
				setState(256);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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
		enterRule(_localctx, 30, RULE_couple);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(LeftBracket);
			setState(258);
			expression(0);
			setState(259);
			match(Comma);
			setState(260);
			expression(0);
			setState(261);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 14);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 7);
		case 8:
			return precpred(_ctx, 6);
		case 9:
			return precpred(_ctx, 5);
		case 10:
			return precpred(_ctx, 21);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u010a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\7\2$\n"+
		"\2\f\2\16\2\'\13\2\3\3\6\3*\n\3\r\3\16\3+\3\4\3\4\3\4\5\4\61\n\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5?\n\5\f\5\16\5B\13\5\3\5"+
		"\3\5\5\5F\n\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5N\n\5\f\5\16\5Q\13\5\3\5\3\5"+
		"\5\5U\n\5\3\6\3\6\3\6\7\6Z\n\6\f\6\16\6]\13\6\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\7\7e\n\7\f\7\16\7h\13\7\5\7j\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\5\7z\n\7\3\b\3\b\3\b\3\b\3\t\7\t\u0081\n\t\f\t\16"+
		"\t\u0084\13\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u008c\n\t\f\t\16\t\u008f\13"+
		"\t\5\t\u0091\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\7\13\u00a1\n\13\f\13\16\13\u00a4\13\13\5\13\u00a6\n\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\6\16\u00b6\n\16"+
		"\r\16\16\16\u00b7\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\5\20\u00d6\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\6\20\u00fb\n\20\r\20\16\20\u00fc\7\20\u00ff\n\20\f\20\16\20\u0102\13"+
		"\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\2\3\36\22\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \2\3\3\2\t\13\2\u0129\2%\3\2\2\2\4)\3\2\2\2\6\60\3"+
		"\2\2\2\bT\3\2\2\2\nV\3\2\2\2\fy\3\2\2\2\16{\3\2\2\2\20\u0082\3\2\2\2\22"+
		"\u0099\3\2\2\2\24\u009b\3\2\2\2\26\u00a9\3\2\2\2\30\u00ae\3\2\2\2\32\u00b2"+
		"\3\2\2\2\34\u00bc\3\2\2\2\36\u00d5\3\2\2\2 \u0103\3\2\2\2\"$\5\b\5\2#"+
		"\"\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\3\3\2\2\2\'%\3\2\2\2(*\5\6"+
		"\4\2)(\3\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\5\3\2\2\2-\61\5\b\5\2./"+
		"\7\3\2\2/\61\5\36\20\2\60-\3\2\2\2\60.\3\2\2\2\61\7\3\2\2\2\62U\5\36\20"+
		"\2\63U\5\26\f\2\64U\5\30\r\2\65U\5\32\16\2\66U\5\34\17\2\67U\5\20\t\2"+
		"89\7\r\2\29:\7\20\2\2:;\5\36\20\2;<\7\21\2\2<@\7\22\2\2=?\5\b\5\2>=\3"+
		"\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2AC\3\2\2\2B@\3\2\2\2CE\7\23\2\2DF"+
		"\5\n\6\2ED\3\2\2\2EF\3\2\2\2FU\3\2\2\2GH\7\16\2\2HI\7\20\2\2IJ\5\36\20"+
		"\2JK\7\21\2\2KO\7\22\2\2LN\5\b\5\2ML\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2"+
		"\2\2PR\3\2\2\2QO\3\2\2\2RS\7\23\2\2SU\3\2\2\2T\62\3\2\2\2T\63\3\2\2\2"+
		"T\64\3\2\2\2T\65\3\2\2\2T\66\3\2\2\2T\67\3\2\2\2T8\3\2\2\2TG\3\2\2\2U"+
		"\t\3\2\2\2VW\7\f\2\2W[\7\22\2\2XZ\5\b\5\2YX\3\2\2\2Z]\3\2\2\2[Y\3\2\2"+
		"\2[\\\3\2\2\2\\^\3\2\2\2][\3\2\2\2^_\7\23\2\2_\13\3\2\2\2`i\7\20\2\2a"+
		"f\5\f\7\2bc\7\26\2\2ce\5\f\7\2db\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2"+
		"gj\3\2\2\2hf\3\2\2\2ia\3\2\2\2ij\3\2\2\2jk\3\2\2\2kl\7\21\2\2lm\7\33\2"+
		"\2mz\5\f\7\2no\7\20\2\2op\5\f\7\2pq\7\26\2\2qr\5\f\7\2rs\7\21\2\2sz\3"+
		"\2\2\2tu\7\20\2\2uv\5\f\7\2vw\7\21\2\2wz\3\2\2\2xz\7!\2\2y`\3\2\2\2yn"+
		"\3\2\2\2yt\3\2\2\2yx\3\2\2\2z\r\3\2\2\2{|\7!\2\2|}\7\30\2\2}~\5\f\7\2"+
		"~\17\3\2\2\2\177\u0081\5\22\n\2\u0080\177\3\2\2\2\u0081\u0084\3\2\2\2"+
		"\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0082"+
		"\3\2\2\2\u0085\u0086\7\5\2\2\u0086\u0087\7!\2\2\u0087\u0090\7\20\2\2\u0088"+
		"\u008d\5\16\b\2\u0089\u008a\7\26\2\2\u008a\u008c\5\16\b\2\u008b\u0089"+
		"\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e"+
		"\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0088\3\2\2\2\u0090\u0091\3\2"+
		"\2\2\u0091\u0092\3\2\2\2\u0092\u0093\7\21\2\2\u0093\u0094\7\30\2\2\u0094"+
		"\u0095\5\f\7\2\u0095\u0096\7\22\2\2\u0096\u0097\5\4\3\2\u0097\u0098\7"+
		"\23\2\2\u0098\21\3\2\2\2\u0099\u009a\t\2\2\2\u009a\23\3\2\2\2\u009b\u009c"+
		"\7!\2\2\u009c\u00a5\7\20\2\2\u009d\u00a2\5\36\20\2\u009e\u009f\7\26\2"+
		"\2\u009f\u00a1\5\36\20\2\u00a0\u009e\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2"+
		"\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2"+
		"\2\2\u00a5\u009d\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7"+
		"\u00a8\7\21\2\2\u00a8\25\3\2\2\2\u00a9\u00aa\7\6\2\2\u00aa\u00ab\7!\2"+
		"\2\u00ab\u00ac\7\32\2\2\u00ac\u00ad\5\36\20\2\u00ad\27\3\2\2\2\u00ae\u00af"+
		"\7!\2\2\u00af\u00b0\7\32\2\2\u00b0\u00b1\5\36\20\2\u00b1\31\3\2\2\2\u00b2"+
		"\u00b5\5\36\20\2\u00b3\u00b4\7\27\2\2\u00b4\u00b6\7!\2\2\u00b5\u00b3\3"+
		"\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8"+
		"\u00b9\3\2\2\2\u00b9\u00ba\7\32\2\2\u00ba\u00bb\5\36\20\2\u00bb\33\3\2"+
		"\2\2\u00bc\u00bd\7\4\2\2\u00bd\u00be\7\22\2\2\u00be\u00bf\5\2\2\2\u00bf"+
		"\u00c0\7\23\2\2\u00c0\35\3\2\2\2\u00c1\u00c2\b\20\1\2\u00c2\u00d6\7\17"+
		"\2\2\u00c3\u00c4\7\24\2\2\u00c4\u00c5\5\36\20\2\u00c5\u00c6\7\25\2\2\u00c6"+
		"\u00d6\3\2\2\2\u00c7\u00d6\5\24\13\2\u00c8\u00d6\7!\2\2\u00c9\u00d6\5"+
		" \21\2\u00ca\u00d6\7\"\2\2\u00cb\u00d6\7#\2\2\u00cc\u00cd\7\20\2\2\u00cd"+
		"\u00ce\5\36\20\2\u00ce\u00cf\7\21\2\2\u00cf\u00d6\3\2\2\2\u00d0\u00d6"+
		"\7\7\2\2\u00d1\u00d6\7\b\2\2\u00d2\u00d6\7(\2\2\u00d3\u00d4\7\20\2\2\u00d4"+
		"\u00d6\7\21\2\2\u00d5\u00c1\3\2\2\2\u00d5\u00c3\3\2\2\2\u00d5\u00c7\3"+
		"\2\2\2\u00d5\u00c8\3\2\2\2\u00d5\u00c9\3\2\2\2\u00d5\u00ca\3\2\2\2\u00d5"+
		"\u00cb\3\2\2\2\u00d5\u00cc\3\2\2\2\u00d5\u00d0\3\2\2\2\u00d5\u00d1\3\2"+
		"\2\2\u00d5\u00d2\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u0100\3\2\2\2\u00d7"+
		"\u00d8\f\20\2\2\u00d8\u00d9\7%\2\2\u00d9\u00ff\5\36\20\21\u00da\u00db"+
		"\f\17\2\2\u00db\u00dc\7$\2\2\u00dc\u00ff\5\36\20\20\u00dd\u00de\f\16\2"+
		"\2\u00de\u00df\7\'\2\2\u00df\u00ff\5\36\20\17\u00e0\u00e1\f\r\2\2\u00e1"+
		"\u00e2\7&\2\2\u00e2\u00ff\5\36\20\16\u00e3\u00e4\f\f\2\2\u00e4\u00e5\7"+
		"\35\2\2\u00e5\u00ff\5\36\20\r\u00e6\u00e7\f\13\2\2\u00e7\u00e8\7\36\2"+
		"\2\u00e8\u00ff\5\36\20\f\u00e9\u00ea\f\n\2\2\u00ea\u00eb\7\37\2\2\u00eb"+
		"\u00ff\5\36\20\13\u00ec\u00ed\f\t\2\2\u00ed\u00ee\7 \2\2\u00ee\u00ff\5"+
		"\36\20\n\u00ef\u00f0\f\b\2\2\u00f0\u00f1\7\32\2\2\u00f1\u00f2\7\32\2\2"+
		"\u00f2\u00ff\5\36\20\t\u00f3\u00f4\f\7\2\2\u00f4\u00f5\7\34\2\2\u00f5"+
		"\u00f6\7\32\2\2\u00f6\u00ff\5\36\20\b\u00f7\u00fa\f\27\2\2\u00f8\u00f9"+
		"\7\27\2\2\u00f9\u00fb\7!\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc"+
		"\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00ff\3\2\2\2\u00fe\u00d7\3\2"+
		"\2\2\u00fe\u00da\3\2\2\2\u00fe\u00dd\3\2\2\2\u00fe\u00e0\3\2\2\2\u00fe"+
		"\u00e3\3\2\2\2\u00fe\u00e6\3\2\2\2\u00fe\u00e9\3\2\2\2\u00fe\u00ec\3\2"+
		"\2\2\u00fe\u00ef\3\2\2\2\u00fe\u00f3\3\2\2\2\u00fe\u00f7\3\2\2\2\u00ff"+
		"\u0102\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101\37\3\2\2"+
		"\2\u0102\u0100\3\2\2\2\u0103\u0104\7\20\2\2\u0104\u0105\5\36\20\2\u0105"+
		"\u0106\7\26\2\2\u0106\u0107\5\36\20\2\u0107\u0108\7\21\2\2\u0108!\3\2"+
		"\2\2\27%+\60@EOT[fiy\u0082\u008d\u0090\u00a2\u00a5\u00b7\u00d5\u00fc\u00fe"+
		"\u0100";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}