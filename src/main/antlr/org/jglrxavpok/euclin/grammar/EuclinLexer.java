// Generated from F:/Programming/Kotlin/Languages/Euclin-TIPE/src/main/kotlin/antlr/euclin\Euclin.g4 by ANTLR 4.7
package org.jglrxavpok.euclin.grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EuclinLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"Return", "TransformBlockStart", "FunctionDefStart", "Var", "True", "False", 
		"LambdaVariable", "LeftBracket", "RightBracket", "LeftCurlyBracket", "RightCurlyBracket", 
		"LeftSquareBracket", "RightSquareBracket", "Comma", "Period", "Colon", 
		"SemiColon", "Equals", "Identifier", "Integer", "FloatNumber", "MultOperator", 
		"DivOperator", "AddOperator", "SubOperator", "IdentifierStart", "IdentifierPart", 
		"Digits", "Digit", "BinaryOperatorSuffix", "LineComment", "Whitespace"
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


	public EuclinLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Euclin.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u00c0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\7\24"+
		"\u0083\n\24\f\24\16\24\u0086\13\24\3\25\3\25\3\26\3\26\3\26\5\26\u008d"+
		"\n\26\3\26\3\26\3\26\5\26\u0092\n\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\34\5\34\u00a3\n\34\3\35\6\35\u00a6"+
		"\n\35\r\35\16\35\u00a7\3\36\3\36\3\37\5\37\u00ad\n\37\3 \3 \3 \3 \7 \u00b3"+
		"\n \f \16 \u00b6\13 \3 \3 \3!\6!\u00bb\n!\r!\16!\u00bc\3!\3!\2\2\"\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\2\67\29\2;\2=\2?\34A"+
		"\35\3\2\7\4\2C\\c|\5\2\62;C\\c|\3\2\62;\4\2\f\f\17\17\5\2\13\f\17\17\""+
		"\"\2\u00c1\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\3C\3\2\2\2"+
		"\5J\3\2\2\2\7T\3\2\2\2\tY\3\2\2\2\13]\3\2\2\2\rb\3\2\2\2\17h\3\2\2\2\21"+
		"j\3\2\2\2\23l\3\2\2\2\25n\3\2\2\2\27p\3\2\2\2\31r\3\2\2\2\33t\3\2\2\2"+
		"\35v\3\2\2\2\37x\3\2\2\2!z\3\2\2\2#|\3\2\2\2%~\3\2\2\2\'\u0080\3\2\2\2"+
		")\u0087\3\2\2\2+\u0091\3\2\2\2-\u0093\3\2\2\2/\u0096\3\2\2\2\61\u0099"+
		"\3\2\2\2\63\u009c\3\2\2\2\65\u009f\3\2\2\2\67\u00a2\3\2\2\29\u00a5\3\2"+
		"\2\2;\u00a9\3\2\2\2=\u00ac\3\2\2\2?\u00ae\3\2\2\2A\u00ba\3\2\2\2CD\7t"+
		"\2\2DE\7g\2\2EF\7v\2\2FG\7w\2\2GH\7t\2\2HI\7p\2\2I\4\3\2\2\2JK\7v\2\2"+
		"KL\7t\2\2LM\7c\2\2MN\7p\2\2NO\7u\2\2OP\7h\2\2PQ\7q\2\2QR\7t\2\2RS\7o\2"+
		"\2S\6\3\2\2\2TU\7h\2\2UV\7w\2\2VW\7p\2\2WX\7e\2\2X\b\3\2\2\2YZ\7x\2\2"+
		"Z[\7c\2\2[\\\7t\2\2\\\n\3\2\2\2]^\7v\2\2^_\7t\2\2_`\7w\2\2`a\7g\2\2a\f"+
		"\3\2\2\2bc\7h\2\2cd\7c\2\2de\7n\2\2ef\7u\2\2fg\7g\2\2g\16\3\2\2\2hi\7"+
		"a\2\2i\20\3\2\2\2jk\7*\2\2k\22\3\2\2\2lm\7+\2\2m\24\3\2\2\2no\7}\2\2o"+
		"\26\3\2\2\2pq\7\177\2\2q\30\3\2\2\2rs\7]\2\2s\32\3\2\2\2tu\7_\2\2u\34"+
		"\3\2\2\2vw\7.\2\2w\36\3\2\2\2xy\7\60\2\2y \3\2\2\2z{\7<\2\2{\"\3\2\2\2"+
		"|}\7=\2\2}$\3\2\2\2~\177\7?\2\2\177&\3\2\2\2\u0080\u0084\5\65\33\2\u0081"+
		"\u0083\5\67\34\2\u0082\u0081\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3"+
		"\2\2\2\u0084\u0085\3\2\2\2\u0085(\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0088"+
		"\59\35\2\u0088*\3\2\2\2\u0089\u008a\59\35\2\u008a\u008c\5\37\20\2\u008b"+
		"\u008d\59\35\2\u008c\u008b\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u0092\3\2"+
		"\2\2\u008e\u008f\5\37\20\2\u008f\u0090\59\35\2\u0090\u0092\3\2\2\2\u0091"+
		"\u0089\3\2\2\2\u0091\u008e\3\2\2\2\u0092,\3\2\2\2\u0093\u0094\7,\2\2\u0094"+
		"\u0095\5=\37\2\u0095.\3\2\2\2\u0096\u0097\7\61\2\2\u0097\u0098\5=\37\2"+
		"\u0098\60\3\2\2\2\u0099\u009a\7-\2\2\u009a\u009b\5=\37\2\u009b\62\3\2"+
		"\2\2\u009c\u009d\7/\2\2\u009d\u009e\5=\37\2\u009e\64\3\2\2\2\u009f\u00a0"+
		"\t\2\2\2\u00a0\66\3\2\2\2\u00a1\u00a3\t\3\2\2\u00a2\u00a1\3\2\2\2\u00a3"+
		"8\3\2\2\2\u00a4\u00a6\5;\36\2\u00a5\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2"+
		"\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8:\3\2\2\2\u00a9\u00aa\t"+
		"\4\2\2\u00aa<\3\2\2\2\u00ab\u00ad\7\60\2\2\u00ac\u00ab\3\2\2\2\u00ac\u00ad"+
		"\3\2\2\2\u00ad>\3\2\2\2\u00ae\u00af\7\61\2\2\u00af\u00b0\7\61\2\2\u00b0"+
		"\u00b4\3\2\2\2\u00b1\u00b3\n\5\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b6\3\2"+
		"\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b7\3\2\2\2\u00b6"+
		"\u00b4\3\2\2\2\u00b7\u00b8\b \2\2\u00b8@\3\2\2\2\u00b9\u00bb\t\6\2\2\u00ba"+
		"\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2"+
		"\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\b!\2\2\u00bfB\3\2\2\2\13\2\u0084"+
		"\u008c\u0091\u00a2\u00a7\u00ac\u00b4\u00bc\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}