// Generated from F:/Programming/Kotlin/Languages/Euclin-TIPE/src/main/kotlin/antlr/euclin\Euclin.g4 by ANTLR 4.7
package org.jglrxavpok.euclin.grammar;
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
		Pure=7, Impure=8, Memoized=9, LambdaVariable=10, LeftBracket=11, RightBracket=12, 
		LeftCurlyBracket=13, RightCurlyBracket=14, LeftSquareBracket=15, RightSquareBracket=16, 
		Comma=17, Period=18, Colon=19, SemiColon=20, Equals=21, Identifier=22, 
		Integer=23, FloatNumber=24, MultOperator=25, DivOperator=26, AddOperator=27, 
		SubOperator=28, LineComment=29, Whitespace=30;
	public static final int
		RULE_codeBlock = 0, RULE_functionCodeBlock = 1, RULE_functionInstructions = 2, 
		RULE_instructions = 3, RULE_type = 4, RULE_parameter = 5, RULE_functionDeclaration = 6, 
		RULE_modifiers = 7, RULE_functionCall = 8, RULE_variableDeclaration = 9, 
		RULE_variableAssign = 10, RULE_memberAssign = 11, RULE_transformBlock = 12, 
		RULE_expression = 13, RULE_couple = 14;
	public static final String[] ruleNames = {
		"codeBlock", "functionCodeBlock", "functionInstructions", "instructions", 
		"type", "parameter", "functionDeclaration", "modifiers", "functionCall", 
		"variableDeclaration", "variableAssign", "memberAssign", "transformBlock", 
		"expression", "couple"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'return'", "'transform'", "'func'", "'var'", "'true'", "'false'", 
		"'pure'", "'impure'", "'memoized'", "'_'", "'('", "')'", "'{'", "'}'", 
		"'['", "']'", "','", "'.'", "':'", "';'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Return", "TransformBlockStart", "FunctionDefStart", "Var", "True", 
		"False", "Pure", "Impure", "Memoized", "LambdaVariable", "LeftBracket", 
		"RightBracket", "LeftCurlyBracket", "RightCurlyBracket", "LeftSquareBracket", 
		"RightSquareBracket", "Comma", "Period", "Colon", "SemiColon", "Equals", 
		"Identifier", "Integer", "FloatNumber", "MultOperator", "DivOperator", 
		"AddOperator", "SubOperator", "LineComment", "Whitespace"
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
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TransformBlockStart) | (1L << FunctionDefStart) | (1L << Var) | (1L << True) | (1L << False) | (1L << Pure) | (1L << Impure) | (1L << Memoized) | (1L << LambdaVariable) | (1L << LeftBracket) | (1L << LeftSquareBracket) | (1L << Identifier) | (1L << Integer) | (1L << FloatNumber))) != 0)) {
				{
				{
				setState(30);
				instructions();
				}
				}
				setState(35);
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
			setState(37); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(36);
				functionInstructions();
				}
				}
				setState(39); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Return) | (1L << TransformBlockStart) | (1L << FunctionDefStart) | (1L << Var) | (1L << True) | (1L << False) | (1L << Pure) | (1L << Impure) | (1L << Memoized) | (1L << LambdaVariable) | (1L << LeftBracket) | (1L << LeftSquareBracket) | (1L << Identifier) | (1L << Integer) | (1L << FloatNumber))) != 0) );
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
			setState(44);
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
			case LambdaVariable:
			case LeftBracket:
			case LeftSquareBracket:
			case Identifier:
			case Integer:
			case FloatNumber:
				_localctx = new InstructionFuncInstructionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				instructions();
				}
				break;
			case Return:
				_localctx = new ReturnFuncInstructionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				match(Return);
				setState(43);
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
	public static class CallInstructionContext extends InstructionsContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public CallInstructionContext(InstructionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterCallInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitCallInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitCallInstruction(this);
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
		try {
			setState(52);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new CallInstructionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				functionCall();
				}
				break;
			case 2:
				_localctx = new DeclareVarInstructionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				variableDeclaration();
				}
				break;
			case 3:
				_localctx = new AssignVarInstructionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				variableAssign();
				}
				break;
			case 4:
				_localctx = new AssignMemberInstructionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(49);
				memberAssign();
				}
				break;
			case 5:
				_localctx = new TransformBlockInstructionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(50);
				transformBlock();
				}
				break;
			case 6:
				_localctx = new DeclareFuncInstructionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(51);
				functionDeclaration();
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(EuclinParser.Identifier, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EuclinListener ) ((EuclinListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EuclinVisitor ) return ((EuclinVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
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
		enterRule(_localctx, 10, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(Identifier);
			setState(57);
			match(Colon);
			setState(58);
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
		enterRule(_localctx, 12, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Pure) | (1L << Impure) | (1L << Memoized))) != 0)) {
				{
				{
				setState(60);
				modifiers();
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66);
			match(FunctionDefStart);
			setState(67);
			match(Identifier);
			setState(68);
			match(LeftBracket);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(69);
				parameter();
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(70);
					match(Comma);
					setState(71);
					parameter();
					}
					}
					setState(76);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(79);
			match(RightBracket);
			setState(80);
			match(Colon);
			setState(81);
			type();
			setState(82);
			match(LeftCurlyBracket);
			setState(83);
			functionCodeBlock();
			setState(84);
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
		enterRule(_localctx, 14, RULE_modifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
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
		enterRule(_localctx, 16, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(Identifier);
			setState(89);
			match(LeftBracket);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << True) | (1L << False) | (1L << LambdaVariable) | (1L << LeftBracket) | (1L << LeftSquareBracket) | (1L << Identifier) | (1L << Integer) | (1L << FloatNumber))) != 0)) {
				{
				setState(90);
				expression(0);
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(91);
					match(Comma);
					setState(92);
					expression(0);
					}
					}
					setState(97);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(100);
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
		enterRule(_localctx, 18, RULE_variableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(Var);
			setState(103);
			match(Identifier);
			setState(104);
			match(Equals);
			setState(105);
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
		enterRule(_localctx, 20, RULE_variableAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(Identifier);
			setState(108);
			match(Equals);
			setState(109);
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
		public TerminalNode Period() { return getToken(EuclinParser.Period, 0); }
		public TerminalNode Identifier() { return getToken(EuclinParser.Identifier, 0); }
		public TerminalNode Equals() { return getToken(EuclinParser.Equals, 0); }
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
		enterRule(_localctx, 22, RULE_memberAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			expression(0);
			setState(112);
			match(Period);
			setState(113);
			match(Identifier);
			setState(114);
			match(Equals);
			setState(115);
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
		enterRule(_localctx, 24, RULE_transformBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(TransformBlockStart);
			setState(118);
			match(LeftCurlyBracket);
			setState(119);
			codeBlock();
			setState(120);
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
		public TerminalNode Period() { return getToken(EuclinParser.Period, 0); }
		public TerminalNode Identifier() { return getToken(EuclinParser.Identifier, 0); }
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

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				_localctx = new LambdaVarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(123);
				match(LambdaVariable);
				}
				break;
			case 2:
				{
				_localctx = new LambdaFunctionExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(124);
				match(LeftSquareBracket);
				setState(125);
				expression(0);
				setState(126);
				match(RightSquareBracket);
				}
				break;
			case 3:
				{
				_localctx = new CallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(128);
				functionCall();
				}
				break;
			case 4:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(129);
				match(Identifier);
				}
				break;
			case 5:
				{
				_localctx = new CoupleExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(130);
				couple();
				}
				break;
			case 6:
				{
				_localctx = new IntExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(131);
				match(Integer);
				}
				break;
			case 7:
				{
				_localctx = new FloatExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(132);
				match(FloatNumber);
				}
				break;
			case 8:
				{
				_localctx = new WrappedExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(133);
				match(LeftBracket);
				setState(134);
				expression(0);
				setState(135);
				match(RightBracket);
				}
				break;
			case 9:
				{
				_localctx = new BoolTrueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(137);
				match(True);
				}
				break;
			case 10:
				{
				_localctx = new BoolFalseExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(138);
				match(False);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(158);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(156);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new DivExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(141);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(142);
						match(DivOperator);
						setState(143);
						expression(7);
						}
						break;
					case 2:
						{
						_localctx = new MultExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(144);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(145);
						match(MultOperator);
						setState(146);
						expression(6);
						}
						break;
					case 3:
						{
						_localctx = new SubExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(147);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(148);
						match(SubOperator);
						setState(149);
						expression(5);
						}
						break;
					case 4:
						{
						_localctx = new AddExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(150);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(151);
						match(AddOperator);
						setState(152);
						expression(4);
						}
						break;
					case 5:
						{
						_localctx = new AccessExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(153);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(154);
						match(Period);
						setState(155);
						match(Identifier);
						}
						break;
					}
					} 
				}
				setState(160);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
		enterRule(_localctx, 28, RULE_couple);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(LeftBracket);
			setState(162);
			expression(0);
			setState(163);
			match(Comma);
			setState(164);
			expression(0);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 13:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 13);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3 \u00aa\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\7\2\"\n\2\f\2\16"+
		"\2%\13\2\3\3\6\3(\n\3\r\3\16\3)\3\4\3\4\3\4\5\4/\n\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\5\5\67\n\5\3\6\3\6\3\7\3\7\3\7\3\7\3\b\7\b@\n\b\f\b\16\bC\13\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\7\bK\n\b\f\b\16\bN\13\b\5\bP\n\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\7\n`\n\n\f\n\16\nc\13\n\5"+
		"\ne\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u008e\n\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\7\17\u009f\n\17\f\17\16\17\u00a2\13\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\2\3\34\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\3\3\2\t\13\2"+
		"\u00b5\2#\3\2\2\2\4\'\3\2\2\2\6.\3\2\2\2\b\66\3\2\2\2\n8\3\2\2\2\f:\3"+
		"\2\2\2\16A\3\2\2\2\20X\3\2\2\2\22Z\3\2\2\2\24h\3\2\2\2\26m\3\2\2\2\30"+
		"q\3\2\2\2\32w\3\2\2\2\34\u008d\3\2\2\2\36\u00a3\3\2\2\2 \"\5\b\5\2! \3"+
		"\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\3\3\2\2\2%#\3\2\2\2&(\5\6\4\2\'"+
		"&\3\2\2\2()\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\5\3\2\2\2+/\5\b\5\2,-\7\3\2"+
		"\2-/\5\34\17\2.+\3\2\2\2.,\3\2\2\2/\7\3\2\2\2\60\67\5\22\n\2\61\67\5\24"+
		"\13\2\62\67\5\26\f\2\63\67\5\30\r\2\64\67\5\32\16\2\65\67\5\16\b\2\66"+
		"\60\3\2\2\2\66\61\3\2\2\2\66\62\3\2\2\2\66\63\3\2\2\2\66\64\3\2\2\2\66"+
		"\65\3\2\2\2\67\t\3\2\2\289\7\30\2\29\13\3\2\2\2:;\7\30\2\2;<\7\25\2\2"+
		"<=\5\n\6\2=\r\3\2\2\2>@\5\20\t\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2"+
		"\2BD\3\2\2\2CA\3\2\2\2DE\7\5\2\2EF\7\30\2\2FO\7\r\2\2GL\5\f\7\2HI\7\23"+
		"\2\2IK\5\f\7\2JH\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MP\3\2\2\2NL\3\2"+
		"\2\2OG\3\2\2\2OP\3\2\2\2PQ\3\2\2\2QR\7\16\2\2RS\7\25\2\2ST\5\n\6\2TU\7"+
		"\17\2\2UV\5\4\3\2VW\7\20\2\2W\17\3\2\2\2XY\t\2\2\2Y\21\3\2\2\2Z[\7\30"+
		"\2\2[d\7\r\2\2\\a\5\34\17\2]^\7\23\2\2^`\5\34\17\2_]\3\2\2\2`c\3\2\2\2"+
		"a_\3\2\2\2ab\3\2\2\2be\3\2\2\2ca\3\2\2\2d\\\3\2\2\2de\3\2\2\2ef\3\2\2"+
		"\2fg\7\16\2\2g\23\3\2\2\2hi\7\6\2\2ij\7\30\2\2jk\7\27\2\2kl\5\34\17\2"+
		"l\25\3\2\2\2mn\7\30\2\2no\7\27\2\2op\5\34\17\2p\27\3\2\2\2qr\5\34\17\2"+
		"rs\7\24\2\2st\7\30\2\2tu\7\27\2\2uv\5\34\17\2v\31\3\2\2\2wx\7\4\2\2xy"+
		"\7\17\2\2yz\5\2\2\2z{\7\20\2\2{\33\3\2\2\2|}\b\17\1\2}\u008e\7\f\2\2~"+
		"\177\7\21\2\2\177\u0080\5\34\17\2\u0080\u0081\7\22\2\2\u0081\u008e\3\2"+
		"\2\2\u0082\u008e\5\22\n\2\u0083\u008e\7\30\2\2\u0084\u008e\5\36\20\2\u0085"+
		"\u008e\7\31\2\2\u0086\u008e\7\32\2\2\u0087\u0088\7\r\2\2\u0088\u0089\5"+
		"\34\17\2\u0089\u008a\7\16\2\2\u008a\u008e\3\2\2\2\u008b\u008e\7\7\2\2"+
		"\u008c\u008e\7\b\2\2\u008d|\3\2\2\2\u008d~\3\2\2\2\u008d\u0082\3\2\2\2"+
		"\u008d\u0083\3\2\2\2\u008d\u0084\3\2\2\2\u008d\u0085\3\2\2\2\u008d\u0086"+
		"\3\2\2\2\u008d\u0087\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008c\3\2\2\2\u008e"+
		"\u00a0\3\2\2\2\u008f\u0090\f\b\2\2\u0090\u0091\7\34\2\2\u0091\u009f\5"+
		"\34\17\t\u0092\u0093\f\7\2\2\u0093\u0094\7\33\2\2\u0094\u009f\5\34\17"+
		"\b\u0095\u0096\f\6\2\2\u0096\u0097\7\36\2\2\u0097\u009f\5\34\17\7\u0098"+
		"\u0099\f\5\2\2\u0099\u009a\7\35\2\2\u009a\u009f\5\34\17\6\u009b\u009c"+
		"\f\17\2\2\u009c\u009d\7\24\2\2\u009d\u009f\7\30\2\2\u009e\u008f\3\2\2"+
		"\2\u009e\u0092\3\2\2\2\u009e\u0095\3\2\2\2\u009e\u0098\3\2\2\2\u009e\u009b"+
		"\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1"+
		"\35\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a4\7\r\2\2\u00a4\u00a5\5\34\17"+
		"\2\u00a5\u00a6\7\23\2\2\u00a6\u00a7\5\34\17\2\u00a7\u00a8\7\16\2\2\u00a8"+
		"\37\3\2\2\2\16#).\66ALOad\u008d\u009e\u00a0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}