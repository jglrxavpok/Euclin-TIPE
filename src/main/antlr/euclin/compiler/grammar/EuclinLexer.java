// Generated from F:/Programming/Kotlin/Languages/Euclin-TIPE/src/main/kotlin/antlr/euclin\Euclin.g4 by ANTLR 4.7
package euclin.compiler.grammar;
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
		Pure=7, Impure=8, Memoized=9, Else=10, If=11, While=12, StructStart=13, 
		New=14, LambdaVariable=15, LeftBracket=16, RightBracket=17, LeftCurlyBracket=18, 
		RightCurlyBracket=19, LeftSquareBracket=20, RightSquareBracket=21, Comma=22, 
		Period=23, Colon=24, SemiColon=25, Equals=26, LightArrow=27, Bang=28, 
		Less=29, LessEqual=30, Greater=31, GreaterEqual=32, Star=33, Identifier=34, 
		Integer=35, FloatNumber=36, MultOperator=37, DivOperator=38, AddOperator=39, 
		SubOperator=40, StringConstant=41, LineComment=42, MultilineComment=43, 
		Whitespace=44;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"Return", "TransformBlockStart", "FunctionDefStart", "Var", "True", "False", 
		"Pure", "Impure", "Memoized", "Else", "If", "While", "StructStart", "New", 
		"LambdaVariable", "LeftBracket", "RightBracket", "LeftCurlyBracket", "RightCurlyBracket", 
		"LeftSquareBracket", "RightSquareBracket", "Comma", "Period", "Colon", 
		"SemiColon", "Equals", "LightArrow", "Bang", "Less", "LessEqual", "Greater", 
		"GreaterEqual", "Star", "Identifier", "Integer", "FloatNumber", "MultOperator", 
		"DivOperator", "AddOperator", "SubOperator", "StringConstant", "IdentifierStart", 
		"IdentifierPart", "Digits", "Digit", "BinaryOperatorSuffix", "LineComment", 
		"MultilineComment", "Whitespace"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'return'", "'transform'", "'func'", "'var'", "'true'", "'false'", 
		"'pure'", "'impure'", "'memoized'", "'else'", "'if'", "'while'", "'struct'", 
		"'new'", "'_'", "'('", "')'", "'{'", "'}'", "'['", "']'", "','", "'.'", 
		"':'", "';'", "'='", "'->'", "'!'", "'<'", "'<='", "'>'", "'>='", "'@'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Return", "TransformBlockStart", "FunctionDefStart", "Var", "True", 
		"False", "Pure", "Impure", "Memoized", "Else", "If", "While", "StructStart", 
		"New", "LambdaVariable", "LeftBracket", "RightBracket", "LeftCurlyBracket", 
		"RightCurlyBracket", "LeftSquareBracket", "RightSquareBracket", "Comma", 
		"Period", "Colon", "SemiColon", "Equals", "LightArrow", "Bang", "Less", 
		"LessEqual", "Greater", "GreaterEqual", "Star", "Identifier", "Integer", 
		"FloatNumber", "MultOperator", "DivOperator", "AddOperator", "SubOperator", 
		"StringConstant", "LineComment", "MultilineComment", "Whitespace"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2.\u0139\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30"+
		"\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\37"+
		"\3\37\3\37\3 \3 \3!\3!\3!\3\"\3\"\3#\3#\7#\u00e4\n#\f#\16#\u00e7\13#\3"+
		"$\3$\3%\3%\3%\5%\u00ee\n%\3%\3%\3%\5%\u00f3\n%\3&\3&\3&\3\'\3\'\3\'\3"+
		"(\3(\3(\3)\3)\3)\3*\3*\7*\u0103\n*\f*\16*\u0106\13*\3*\3*\3+\5+\u010b"+
		"\n+\3,\5,\u010e\n,\3-\6-\u0111\n-\r-\16-\u0112\3.\3.\3/\5/\u0118\n/\3"+
		"\60\3\60\3\60\3\60\7\60\u011e\n\60\f\60\16\60\u0121\13\60\3\60\3\60\3"+
		"\61\3\61\3\61\3\61\7\61\u0129\n\61\f\61\16\61\u012c\13\61\3\61\3\61\3"+
		"\61\3\61\3\61\3\62\6\62\u0134\n\62\r\62\16\62\u0135\3\62\3\62\3\u012a"+
		"\2\63\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U\2W\2Y\2[\2]\2_,a-c.\3\2\b\3\2$$\4\2C\\"+
		"c|\5\2\62;C\\c|\3\2\62;\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u013c\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2"+
		"\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I"+
		"\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2_\3\2"+
		"\2\2\2a\3\2\2\2\2c\3\2\2\2\3e\3\2\2\2\5l\3\2\2\2\7v\3\2\2\2\t{\3\2\2\2"+
		"\13\177\3\2\2\2\r\u0084\3\2\2\2\17\u008a\3\2\2\2\21\u008f\3\2\2\2\23\u0096"+
		"\3\2\2\2\25\u009f\3\2\2\2\27\u00a4\3\2\2\2\31\u00a7\3\2\2\2\33\u00ad\3"+
		"\2\2\2\35\u00b4\3\2\2\2\37\u00b8\3\2\2\2!\u00ba\3\2\2\2#\u00bc\3\2\2\2"+
		"%\u00be\3\2\2\2\'\u00c0\3\2\2\2)\u00c2\3\2\2\2+\u00c4\3\2\2\2-\u00c6\3"+
		"\2\2\2/\u00c8\3\2\2\2\61\u00ca\3\2\2\2\63\u00cc\3\2\2\2\65\u00ce\3\2\2"+
		"\2\67\u00d0\3\2\2\29\u00d3\3\2\2\2;\u00d5\3\2\2\2=\u00d7\3\2\2\2?\u00da"+
		"\3\2\2\2A\u00dc\3\2\2\2C\u00df\3\2\2\2E\u00e1\3\2\2\2G\u00e8\3\2\2\2I"+
		"\u00f2\3\2\2\2K\u00f4\3\2\2\2M\u00f7\3\2\2\2O\u00fa\3\2\2\2Q\u00fd\3\2"+
		"\2\2S\u0100\3\2\2\2U\u010a\3\2\2\2W\u010d\3\2\2\2Y\u0110\3\2\2\2[\u0114"+
		"\3\2\2\2]\u0117\3\2\2\2_\u0119\3\2\2\2a\u0124\3\2\2\2c\u0133\3\2\2\2e"+
		"f\7t\2\2fg\7g\2\2gh\7v\2\2hi\7w\2\2ij\7t\2\2jk\7p\2\2k\4\3\2\2\2lm\7v"+
		"\2\2mn\7t\2\2no\7c\2\2op\7p\2\2pq\7u\2\2qr\7h\2\2rs\7q\2\2st\7t\2\2tu"+
		"\7o\2\2u\6\3\2\2\2vw\7h\2\2wx\7w\2\2xy\7p\2\2yz\7e\2\2z\b\3\2\2\2{|\7"+
		"x\2\2|}\7c\2\2}~\7t\2\2~\n\3\2\2\2\177\u0080\7v\2\2\u0080\u0081\7t\2\2"+
		"\u0081\u0082\7w\2\2\u0082\u0083\7g\2\2\u0083\f\3\2\2\2\u0084\u0085\7h"+
		"\2\2\u0085\u0086\7c\2\2\u0086\u0087\7n\2\2\u0087\u0088\7u\2\2\u0088\u0089"+
		"\7g\2\2\u0089\16\3\2\2\2\u008a\u008b\7r\2\2\u008b\u008c\7w\2\2\u008c\u008d"+
		"\7t\2\2\u008d\u008e\7g\2\2\u008e\20\3\2\2\2\u008f\u0090\7k\2\2\u0090\u0091"+
		"\7o\2\2\u0091\u0092\7r\2\2\u0092\u0093\7w\2\2\u0093\u0094\7t\2\2\u0094"+
		"\u0095\7g\2\2\u0095\22\3\2\2\2\u0096\u0097\7o\2\2\u0097\u0098\7g\2\2\u0098"+
		"\u0099\7o\2\2\u0099\u009a\7q\2\2\u009a\u009b\7k\2\2\u009b\u009c\7|\2\2"+
		"\u009c\u009d\7g\2\2\u009d\u009e\7f\2\2\u009e\24\3\2\2\2\u009f\u00a0\7"+
		"g\2\2\u00a0\u00a1\7n\2\2\u00a1\u00a2\7u\2\2\u00a2\u00a3\7g\2\2\u00a3\26"+
		"\3\2\2\2\u00a4\u00a5\7k\2\2\u00a5\u00a6\7h\2\2\u00a6\30\3\2\2\2\u00a7"+
		"\u00a8\7y\2\2\u00a8\u00a9\7j\2\2\u00a9\u00aa\7k\2\2\u00aa\u00ab\7n\2\2"+
		"\u00ab\u00ac\7g\2\2\u00ac\32\3\2\2\2\u00ad\u00ae\7u\2\2\u00ae\u00af\7"+
		"v\2\2\u00af\u00b0\7t\2\2\u00b0\u00b1\7w\2\2\u00b1\u00b2\7e\2\2\u00b2\u00b3"+
		"\7v\2\2\u00b3\34\3\2\2\2\u00b4\u00b5\7p\2\2\u00b5\u00b6\7g\2\2\u00b6\u00b7"+
		"\7y\2\2\u00b7\36\3\2\2\2\u00b8\u00b9\7a\2\2\u00b9 \3\2\2\2\u00ba\u00bb"+
		"\7*\2\2\u00bb\"\3\2\2\2\u00bc\u00bd\7+\2\2\u00bd$\3\2\2\2\u00be\u00bf"+
		"\7}\2\2\u00bf&\3\2\2\2\u00c0\u00c1\7\177\2\2\u00c1(\3\2\2\2\u00c2\u00c3"+
		"\7]\2\2\u00c3*\3\2\2\2\u00c4\u00c5\7_\2\2\u00c5,\3\2\2\2\u00c6\u00c7\7"+
		".\2\2\u00c7.\3\2\2\2\u00c8\u00c9\7\60\2\2\u00c9\60\3\2\2\2\u00ca\u00cb"+
		"\7<\2\2\u00cb\62\3\2\2\2\u00cc\u00cd\7=\2\2\u00cd\64\3\2\2\2\u00ce\u00cf"+
		"\7?\2\2\u00cf\66\3\2\2\2\u00d0\u00d1\7/\2\2\u00d1\u00d2\7@\2\2\u00d28"+
		"\3\2\2\2\u00d3\u00d4\7#\2\2\u00d4:\3\2\2\2\u00d5\u00d6\7>\2\2\u00d6<\3"+
		"\2\2\2\u00d7\u00d8\7>\2\2\u00d8\u00d9\7?\2\2\u00d9>\3\2\2\2\u00da\u00db"+
		"\7@\2\2\u00db@\3\2\2\2\u00dc\u00dd\7@\2\2\u00dd\u00de\7?\2\2\u00deB\3"+
		"\2\2\2\u00df\u00e0\7B\2\2\u00e0D\3\2\2\2\u00e1\u00e5\5U+\2\u00e2\u00e4"+
		"\5W,\2\u00e3\u00e2\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5"+
		"\u00e6\3\2\2\2\u00e6F\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00e9\5Y-\2\u00e9"+
		"H\3\2\2\2\u00ea\u00eb\5Y-\2\u00eb\u00ed\5/\30\2\u00ec\u00ee\5Y-\2\u00ed"+
		"\u00ec\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f3\3\2\2\2\u00ef\u00f0\5/"+
		"\30\2\u00f0\u00f1\5Y-\2\u00f1\u00f3\3\2\2\2\u00f2\u00ea\3\2\2\2\u00f2"+
		"\u00ef\3\2\2\2\u00f3J\3\2\2\2\u00f4\u00f5\7,\2\2\u00f5\u00f6\5]/\2\u00f6"+
		"L\3\2\2\2\u00f7\u00f8\7\61\2\2\u00f8\u00f9\5]/\2\u00f9N\3\2\2\2\u00fa"+
		"\u00fb\7-\2\2\u00fb\u00fc\5]/\2\u00fcP\3\2\2\2\u00fd\u00fe\7/\2\2\u00fe"+
		"\u00ff\5]/\2\u00ffR\3\2\2\2\u0100\u0104\7$\2\2\u0101\u0103\n\2\2\2\u0102"+
		"\u0101\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2"+
		"\2\2\u0105\u0107\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u0108\7$\2\2\u0108"+
		"T\3\2\2\2\u0109\u010b\t\3\2\2\u010a\u0109\3\2\2\2\u010bV\3\2\2\2\u010c"+
		"\u010e\t\4\2\2\u010d\u010c\3\2\2\2\u010eX\3\2\2\2\u010f\u0111\5[.\2\u0110"+
		"\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2"+
		"\2\2\u0113Z\3\2\2\2\u0114\u0115\t\5\2\2\u0115\\\3\2\2\2\u0116\u0118\7"+
		"\60\2\2\u0117\u0116\3\2\2\2\u0117\u0118\3\2\2\2\u0118^\3\2\2\2\u0119\u011a"+
		"\7\61\2\2\u011a\u011b\7\61\2\2\u011b\u011f\3\2\2\2\u011c\u011e\n\6\2\2"+
		"\u011d\u011c\3\2\2\2\u011e\u0121\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u0120"+
		"\3\2\2\2\u0120\u0122\3\2\2\2\u0121\u011f\3\2\2\2\u0122\u0123\b\60\2\2"+
		"\u0123`\3\2\2\2\u0124\u0125\7\61\2\2\u0125\u0126\7,\2\2\u0126\u012a\3"+
		"\2\2\2\u0127\u0129\13\2\2\2\u0128\u0127\3\2\2\2\u0129\u012c\3\2\2\2\u012a"+
		"\u012b\3\2\2\2\u012a\u0128\3\2\2\2\u012b\u012d\3\2\2\2\u012c\u012a\3\2"+
		"\2\2\u012d\u012e\7,\2\2\u012e\u012f\7\61\2\2\u012f\u0130\3\2\2\2\u0130"+
		"\u0131\b\61\2\2\u0131b\3\2\2\2\u0132\u0134\t\7\2\2\u0133\u0132\3\2\2\2"+
		"\u0134\u0135\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0137"+
		"\3\2\2\2\u0137\u0138\b\62\2\2\u0138d\3\2\2\2\16\2\u00e5\u00ed\u00f2\u0104"+
		"\u010a\u010d\u0112\u0117\u011f\u012a\u0135\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}