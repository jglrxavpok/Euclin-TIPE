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
		LambdaVariable=7, LeftBracket=8, RightBracket=9, LeftCurlyBracket=10, 
		RightCurlyBracket=11, LeftSquareBracket=12, RightSquareBracket=13, Comma=14, 
		Period=15, Colon=16, SemiColon=17, Equals=18, Identifier=19, Integer=20, 
		FloatNumber=21, MultOperator=22, DivOperator=23, AddOperator=24, SubOperator=25, 
		LineComment=26, Whitespace=27;
	public static final int
		RULE_codeBlock = 0, RULE_functionCodeBlock = 1, RULE_functionInstructions = 2, 
		RULE_instructions = 3, RULE_type = 4, RULE_parameter = 5, RULE_functionDeclaration = 6, 
		RULE_functionCall = 7, RULE_variableDeclaration = 8, RULE_variableAssign = 9, 
		RULE_memberAssign = 10, RULE_transformBlock = 11, RULE_expression = 12, 
		RULE_couple = 13;
	public static final String[] ruleNames = {
		"codeBlock", "functionCodeBlock", "functionInstructions", "instructions", 
		"type", "parameter", "functionDeclaration", "functionCall", "variableDeclaration", 
		"variableAssign", "memberAssign", "transformBlock", "expression", "couple"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'return'", "'transform'", "'func'", "'var'", "'true'", "'false'", 
		"'_'", "'('", "')'", "'{'", "'}'", "'['", "']'", "','", "'.'", "':'", 
		"';'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Return", "TransformBlockStart", "FunctionDefStart", "Var", "True", 
		"False", "LambdaVariable", "LeftBracket", "RightBracket", "LeftCurlyBracket", 
		"RightCurlyBracket", "LeftSquareBracket", "RightSquareBracket", "Comma", 
		"Period", "Colon", "SemiColon", "Equals", "Identifier", "Integer", "FloatNumber", 
		"MultOperator", "DivOperator", "AddOperator", "SubOperator", "LineComment", 
		"Whitespace"
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
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TransformBlockStart) | (1L << FunctionDefStart) | (1L << Var) | (1L << True) | (1L << False) | (1L << LambdaVariable) | (1L << LeftBracket) | (1L << LeftSquareBracket) | (1L << Identifier) | (1L << Integer) | (1L << FloatNumber))) != 0)) {
				{
				{
				setState(28);
				instructions();
				}
				}
				setState(33);
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
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34);
				functionInstructions();
				}
				}
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Return) | (1L << TransformBlockStart) | (1L << FunctionDefStart) | (1L << Var) | (1L << True) | (1L << False) | (1L << LambdaVariable) | (1L << LeftBracket) | (1L << LeftSquareBracket) | (1L << Identifier) | (1L << Integer) | (1L << FloatNumber))) != 0) );
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
			setState(42);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TransformBlockStart:
			case FunctionDefStart:
			case Var:
			case True:
			case False:
			case LambdaVariable:
			case LeftBracket:
			case LeftSquareBracket:
			case Identifier:
			case Integer:
			case FloatNumber:
				_localctx = new InstructionFuncInstructionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				instructions();
				}
				break;
			case Return:
				_localctx = new ReturnFuncInstructionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				match(Return);
				setState(41);
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
			setState(50);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new CallInstructionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				functionCall();
				}
				break;
			case 2:
				_localctx = new DeclareVarInstructionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				variableDeclaration();
				}
				break;
			case 3:
				_localctx = new AssignVarInstructionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(46);
				variableAssign();
				}
				break;
			case 4:
				_localctx = new AssignMemberInstructionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(47);
				memberAssign();
				}
				break;
			case 5:
				_localctx = new TransformBlockInstructionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(48);
				transformBlock();
				}
				break;
			case 6:
				_localctx = new DeclareFuncInstructionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(49);
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
			setState(52);
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
			setState(54);
			match(Identifier);
			setState(55);
			match(Colon);
			setState(56);
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
			setState(58);
			match(FunctionDefStart);
			setState(59);
			match(Identifier);
			setState(60);
			match(LeftBracket);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(61);
				parameter();
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(62);
					match(Comma);
					setState(63);
					parameter();
					}
					}
					setState(68);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(71);
			match(RightBracket);
			setState(72);
			match(Colon);
			setState(73);
			type();
			setState(74);
			match(LeftCurlyBracket);
			setState(75);
			functionCodeBlock();
			setState(76);
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
		enterRule(_localctx, 14, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(Identifier);
			setState(79);
			match(LeftBracket);
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << True) | (1L << False) | (1L << LambdaVariable) | (1L << LeftBracket) | (1L << LeftSquareBracket) | (1L << Identifier) | (1L << Integer) | (1L << FloatNumber))) != 0)) {
				{
				setState(80);
				expression(0);
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(81);
					match(Comma);
					setState(82);
					expression(0);
					}
					}
					setState(87);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(90);
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
		enterRule(_localctx, 16, RULE_variableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(Var);
			setState(93);
			match(Identifier);
			setState(94);
			match(Equals);
			setState(95);
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
		enterRule(_localctx, 18, RULE_variableAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(Identifier);
			setState(98);
			match(Equals);
			setState(99);
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
		enterRule(_localctx, 20, RULE_memberAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			expression(0);
			setState(102);
			match(Period);
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
		enterRule(_localctx, 22, RULE_transformBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(TransformBlockStart);
			setState(108);
			match(LeftCurlyBracket);
			setState(109);
			codeBlock();
			setState(110);
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new LambdaVarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(113);
				match(LambdaVariable);
				}
				break;
			case 2:
				{
				_localctx = new LambdaFunctionExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(114);
				match(LeftSquareBracket);
				setState(115);
				expression(0);
				setState(116);
				match(RightSquareBracket);
				}
				break;
			case 3:
				{
				_localctx = new CallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(118);
				functionCall();
				}
				break;
			case 4:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(119);
				match(Identifier);
				}
				break;
			case 5:
				{
				_localctx = new CoupleExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(120);
				couple();
				}
				break;
			case 6:
				{
				_localctx = new IntExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(121);
				match(Integer);
				}
				break;
			case 7:
				{
				_localctx = new FloatExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(122);
				match(FloatNumber);
				}
				break;
			case 8:
				{
				_localctx = new WrappedExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(123);
				match(LeftBracket);
				setState(124);
				expression(0);
				setState(125);
				match(RightBracket);
				}
				break;
			case 9:
				{
				_localctx = new BoolTrueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(127);
				match(True);
				}
				break;
			case 10:
				{
				_localctx = new BoolFalseExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(128);
				match(False);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(148);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(146);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new DivExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(131);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(132);
						match(DivOperator);
						setState(133);
						expression(7);
						}
						break;
					case 2:
						{
						_localctx = new MultExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(134);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(135);
						match(MultOperator);
						setState(136);
						expression(6);
						}
						break;
					case 3:
						{
						_localctx = new SubExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(137);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(138);
						match(SubOperator);
						setState(139);
						expression(5);
						}
						break;
					case 4:
						{
						_localctx = new AddExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(140);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(141);
						match(AddOperator);
						setState(142);
						expression(4);
						}
						break;
					case 5:
						{
						_localctx = new AccessExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(143);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(144);
						match(Period);
						setState(145);
						match(Identifier);
						}
						break;
					}
					} 
				}
				setState(150);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
		enterRule(_localctx, 26, RULE_couple);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(LeftBracket);
			setState(152);
			expression(0);
			setState(153);
			match(Comma);
			setState(154);
			expression(0);
			setState(155);
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
		case 12:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35\u00a0\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\7\2 \n\2\f\2\16\2#\13\2"+
		"\3\3\6\3&\n\3\r\3\16\3\'\3\4\3\4\3\4\5\4-\n\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\5\5\65\n\5\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7\bC\n\b\f"+
		"\b\16\bF\13\b\5\bH\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t"+
		"\7\tV\n\t\f\t\16\tY\13\t\5\t[\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\5\16\u0084\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\7\16\u0095\n\16\f\16\16\16\u0098\13\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\2\3\32\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\2\2\2\u00ab\2!\3\2\2\2\4%\3\2\2\2\6,\3\2\2\2\b\64\3\2\2\2\n\66\3\2\2"+
		"\2\f8\3\2\2\2\16<\3\2\2\2\20P\3\2\2\2\22^\3\2\2\2\24c\3\2\2\2\26g\3\2"+
		"\2\2\30m\3\2\2\2\32\u0083\3\2\2\2\34\u0099\3\2\2\2\36 \5\b\5\2\37\36\3"+
		"\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"\3\3\2\2\2#!\3\2\2\2$&\5\6\4"+
		"\2%$\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\5\3\2\2\2)-\5\b\5\2*+\7"+
		"\3\2\2+-\5\32\16\2,)\3\2\2\2,*\3\2\2\2-\7\3\2\2\2.\65\5\20\t\2/\65\5\22"+
		"\n\2\60\65\5\24\13\2\61\65\5\26\f\2\62\65\5\30\r\2\63\65\5\16\b\2\64."+
		"\3\2\2\2\64/\3\2\2\2\64\60\3\2\2\2\64\61\3\2\2\2\64\62\3\2\2\2\64\63\3"+
		"\2\2\2\65\t\3\2\2\2\66\67\7\25\2\2\67\13\3\2\2\289\7\25\2\29:\7\22\2\2"+
		":;\5\n\6\2;\r\3\2\2\2<=\7\5\2\2=>\7\25\2\2>G\7\n\2\2?D\5\f\7\2@A\7\20"+
		"\2\2AC\5\f\7\2B@\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2EH\3\2\2\2FD\3\2"+
		"\2\2G?\3\2\2\2GH\3\2\2\2HI\3\2\2\2IJ\7\13\2\2JK\7\22\2\2KL\5\n\6\2LM\7"+
		"\f\2\2MN\5\4\3\2NO\7\r\2\2O\17\3\2\2\2PQ\7\25\2\2QZ\7\n\2\2RW\5\32\16"+
		"\2ST\7\20\2\2TV\5\32\16\2US\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2X[\3"+
		"\2\2\2YW\3\2\2\2ZR\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\]\7\13\2\2]\21\3\2\2"+
		"\2^_\7\6\2\2_`\7\25\2\2`a\7\24\2\2ab\5\32\16\2b\23\3\2\2\2cd\7\25\2\2"+
		"de\7\24\2\2ef\5\32\16\2f\25\3\2\2\2gh\5\32\16\2hi\7\21\2\2ij\7\25\2\2"+
		"jk\7\24\2\2kl\5\32\16\2l\27\3\2\2\2mn\7\4\2\2no\7\f\2\2op\5\2\2\2pq\7"+
		"\r\2\2q\31\3\2\2\2rs\b\16\1\2s\u0084\7\t\2\2tu\7\16\2\2uv\5\32\16\2vw"+
		"\7\17\2\2w\u0084\3\2\2\2x\u0084\5\20\t\2y\u0084\7\25\2\2z\u0084\5\34\17"+
		"\2{\u0084\7\26\2\2|\u0084\7\27\2\2}~\7\n\2\2~\177\5\32\16\2\177\u0080"+
		"\7\13\2\2\u0080\u0084\3\2\2\2\u0081\u0084\7\7\2\2\u0082\u0084\7\b\2\2"+
		"\u0083r\3\2\2\2\u0083t\3\2\2\2\u0083x\3\2\2\2\u0083y\3\2\2\2\u0083z\3"+
		"\2\2\2\u0083{\3\2\2\2\u0083|\3\2\2\2\u0083}\3\2\2\2\u0083\u0081\3\2\2"+
		"\2\u0083\u0082\3\2\2\2\u0084\u0096\3\2\2\2\u0085\u0086\f\b\2\2\u0086\u0087"+
		"\7\31\2\2\u0087\u0095\5\32\16\t\u0088\u0089\f\7\2\2\u0089\u008a\7\30\2"+
		"\2\u008a\u0095\5\32\16\b\u008b\u008c\f\6\2\2\u008c\u008d\7\33\2\2\u008d"+
		"\u0095\5\32\16\7\u008e\u008f\f\5\2\2\u008f\u0090\7\32\2\2\u0090\u0095"+
		"\5\32\16\6\u0091\u0092\f\17\2\2\u0092\u0093\7\21\2\2\u0093\u0095\7\25"+
		"\2\2\u0094\u0085\3\2\2\2\u0094\u0088\3\2\2\2\u0094\u008b\3\2\2\2\u0094"+
		"\u008e\3\2\2\2\u0094\u0091\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2"+
		"\2\2\u0096\u0097\3\2\2\2\u0097\33\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009a"+
		"\7\n\2\2\u009a\u009b\5\32\16\2\u009b\u009c\7\20\2\2\u009c\u009d\5\32\16"+
		"\2\u009d\u009e\7\13\2\2\u009e\35\3\2\2\2\r!\',\64DGWZ\u0083\u0094\u0096";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}