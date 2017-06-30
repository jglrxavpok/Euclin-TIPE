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
		T__0=1, Return=2, TransformBlockStart=3, FunctionDefStart=4, Var=5, True=6, 
		False=7, Pure=8, Impure=9, Memoized=10, Else=11, If=12, While=13, StructStart=14, 
		New=15, Import=16, ImportMethod=17, LambdaVariable=18, LeftBracket=19, 
		RightBracket=20, LeftCurlyBracket=21, RightCurlyBracket=22, LeftSquareBracket=23, 
		RightSquareBracket=24, Comma=25, Period=26, Colon=27, SemiColon=28, Equals=29, 
		LightArrow=30, Bang=31, Less=32, LessEqual=33, Greater=34, GreaterEqual=35, 
		Star=36, Identifier=37, Integer=38, FloatNumber=39, MultOperator=40, DivOperator=41, 
		AddOperator=42, SubOperator=43, StringConstant=44, LineComment=45, MultilineComment=46, 
		Whitespace=47;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "Return", "TransformBlockStart", "FunctionDefStart", "Var", "True", 
		"False", "Pure", "Impure", "Memoized", "Else", "If", "While", "StructStart", 
		"New", "Import", "ImportMethod", "LambdaVariable", "LeftBracket", "RightBracket", 
		"LeftCurlyBracket", "RightCurlyBracket", "LeftSquareBracket", "RightSquareBracket", 
		"Comma", "Period", "Colon", "SemiColon", "Equals", "LightArrow", "Bang", 
		"Less", "LessEqual", "Greater", "GreaterEqual", "Star", "Identifier", 
		"Integer", "FloatNumber", "MultOperator", "DivOperator", "AddOperator", 
		"SubOperator", "StringConstant", "IdentifierStart", "IdentifierPart", 
		"Digits", "Digit", "BinaryOperatorSuffix", "LineComment", "MultilineComment", 
		"Whitespace"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'as'", "'return'", "'transform'", "'func'", "'var'", "'true'", 
		"'false'", "'pure'", "'impure'", "'memoized'", "'else'", "'if'", "'while'", 
		"'struct'", "'new'", "'import'", "'import method'", "'_'", "'('", "')'", 
		"'{'", "'}'", "'['", "']'", "','", "'.'", "':'", "';'", "'='", "'->'", 
		"'!'", "'<'", "'<='", "'>'", "'>='", "'@'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "Return", "TransformBlockStart", "FunctionDefStart", "Var", 
		"True", "False", "Pure", "Impure", "Memoized", "Else", "If", "While", 
		"StructStart", "New", "Import", "ImportMethod", "LambdaVariable", "LeftBracket", 
		"RightBracket", "LeftCurlyBracket", "RightCurlyBracket", "LeftSquareBracket", 
		"RightSquareBracket", "Comma", "Period", "Colon", "SemiColon", "Equals", 
		"LightArrow", "Bang", "Less", "LessEqual", "Greater", "GreaterEqual", 
		"Star", "Identifier", "Integer", "FloatNumber", "MultOperator", "DivOperator", 
		"AddOperator", "SubOperator", "StringConstant", "LineComment", "MultilineComment", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\61\u0157\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3"+
		"\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3"+
		" \3 \3!\3!\3\"\3\"\3\"\3#\3#\3$\3$\3$\3%\3%\3&\3&\7&\u0102\n&\f&\16&\u0105"+
		"\13&\3\'\3\'\3(\3(\3(\5(\u010c\n(\3(\3(\3(\5(\u0111\n(\3)\3)\3)\3*\3*"+
		"\3*\3+\3+\3+\3,\3,\3,\3-\3-\7-\u0121\n-\f-\16-\u0124\13-\3-\3-\3.\5.\u0129"+
		"\n.\3/\5/\u012c\n/\3\60\6\60\u012f\n\60\r\60\16\60\u0130\3\61\3\61\3\62"+
		"\5\62\u0136\n\62\3\63\3\63\3\63\3\63\7\63\u013c\n\63\f\63\16\63\u013f"+
		"\13\63\3\63\3\63\3\64\3\64\3\64\3\64\7\64\u0147\n\64\f\64\16\64\u014a"+
		"\13\64\3\64\3\64\3\64\3\64\3\64\3\65\6\65\u0152\n\65\r\65\16\65\u0153"+
		"\3\65\3\65\3\u0148\2\66\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[\2]\2_\2a\2c\2"+
		"e/g\60i\61\3\2\b\3\2$$\4\2C\\c|\5\2\62;C\\c|\3\2\62;\4\2\f\f\17\17\5\2"+
		"\13\f\17\17\"\"\2\u015a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2e\3\2\2\2\2g\3"+
		"\2\2\2\2i\3\2\2\2\3k\3\2\2\2\5n\3\2\2\2\7u\3\2\2\2\t\177\3\2\2\2\13\u0084"+
		"\3\2\2\2\r\u0088\3\2\2\2\17\u008d\3\2\2\2\21\u0093\3\2\2\2\23\u0098\3"+
		"\2\2\2\25\u009f\3\2\2\2\27\u00a8\3\2\2\2\31\u00ad\3\2\2\2\33\u00b0\3\2"+
		"\2\2\35\u00b6\3\2\2\2\37\u00bd\3\2\2\2!\u00c1\3\2\2\2#\u00c8\3\2\2\2%"+
		"\u00d6\3\2\2\2\'\u00d8\3\2\2\2)\u00da\3\2\2\2+\u00dc\3\2\2\2-\u00de\3"+
		"\2\2\2/\u00e0\3\2\2\2\61\u00e2\3\2\2\2\63\u00e4\3\2\2\2\65\u00e6\3\2\2"+
		"\2\67\u00e8\3\2\2\29\u00ea\3\2\2\2;\u00ec\3\2\2\2=\u00ee\3\2\2\2?\u00f1"+
		"\3\2\2\2A\u00f3\3\2\2\2C\u00f5\3\2\2\2E\u00f8\3\2\2\2G\u00fa\3\2\2\2I"+
		"\u00fd\3\2\2\2K\u00ff\3\2\2\2M\u0106\3\2\2\2O\u0110\3\2\2\2Q\u0112\3\2"+
		"\2\2S\u0115\3\2\2\2U\u0118\3\2\2\2W\u011b\3\2\2\2Y\u011e\3\2\2\2[\u0128"+
		"\3\2\2\2]\u012b\3\2\2\2_\u012e\3\2\2\2a\u0132\3\2\2\2c\u0135\3\2\2\2e"+
		"\u0137\3\2\2\2g\u0142\3\2\2\2i\u0151\3\2\2\2kl\7c\2\2lm\7u\2\2m\4\3\2"+
		"\2\2no\7t\2\2op\7g\2\2pq\7v\2\2qr\7w\2\2rs\7t\2\2st\7p\2\2t\6\3\2\2\2"+
		"uv\7v\2\2vw\7t\2\2wx\7c\2\2xy\7p\2\2yz\7u\2\2z{\7h\2\2{|\7q\2\2|}\7t\2"+
		"\2}~\7o\2\2~\b\3\2\2\2\177\u0080\7h\2\2\u0080\u0081\7w\2\2\u0081\u0082"+
		"\7p\2\2\u0082\u0083\7e\2\2\u0083\n\3\2\2\2\u0084\u0085\7x\2\2\u0085\u0086"+
		"\7c\2\2\u0086\u0087\7t\2\2\u0087\f\3\2\2\2\u0088\u0089\7v\2\2\u0089\u008a"+
		"\7t\2\2\u008a\u008b\7w\2\2\u008b\u008c\7g\2\2\u008c\16\3\2\2\2\u008d\u008e"+
		"\7h\2\2\u008e\u008f\7c\2\2\u008f\u0090\7n\2\2\u0090\u0091\7u\2\2\u0091"+
		"\u0092\7g\2\2\u0092\20\3\2\2\2\u0093\u0094\7r\2\2\u0094\u0095\7w\2\2\u0095"+
		"\u0096\7t\2\2\u0096\u0097\7g\2\2\u0097\22\3\2\2\2\u0098\u0099\7k\2\2\u0099"+
		"\u009a\7o\2\2\u009a\u009b\7r\2\2\u009b\u009c\7w\2\2\u009c\u009d\7t\2\2"+
		"\u009d\u009e\7g\2\2\u009e\24\3\2\2\2\u009f\u00a0\7o\2\2\u00a0\u00a1\7"+
		"g\2\2\u00a1\u00a2\7o\2\2\u00a2\u00a3\7q\2\2\u00a3\u00a4\7k\2\2\u00a4\u00a5"+
		"\7|\2\2\u00a5\u00a6\7g\2\2\u00a6\u00a7\7f\2\2\u00a7\26\3\2\2\2\u00a8\u00a9"+
		"\7g\2\2\u00a9\u00aa\7n\2\2\u00aa\u00ab\7u\2\2\u00ab\u00ac\7g\2\2\u00ac"+
		"\30\3\2\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af\7h\2\2\u00af\32\3\2\2\2\u00b0"+
		"\u00b1\7y\2\2\u00b1\u00b2\7j\2\2\u00b2\u00b3\7k\2\2\u00b3\u00b4\7n\2\2"+
		"\u00b4\u00b5\7g\2\2\u00b5\34\3\2\2\2\u00b6\u00b7\7u\2\2\u00b7\u00b8\7"+
		"v\2\2\u00b8\u00b9\7t\2\2\u00b9\u00ba\7w\2\2\u00ba\u00bb\7e\2\2\u00bb\u00bc"+
		"\7v\2\2\u00bc\36\3\2\2\2\u00bd\u00be\7p\2\2\u00be\u00bf\7g\2\2\u00bf\u00c0"+
		"\7y\2\2\u00c0 \3\2\2\2\u00c1\u00c2\7k\2\2\u00c2\u00c3\7o\2\2\u00c3\u00c4"+
		"\7r\2\2\u00c4\u00c5\7q\2\2\u00c5\u00c6\7t\2\2\u00c6\u00c7\7v\2\2\u00c7"+
		"\"\3\2\2\2\u00c8\u00c9\7k\2\2\u00c9\u00ca\7o\2\2\u00ca\u00cb\7r\2\2\u00cb"+
		"\u00cc\7q\2\2\u00cc\u00cd\7t\2\2\u00cd\u00ce\7v\2\2\u00ce\u00cf\7\"\2"+
		"\2\u00cf\u00d0\7o\2\2\u00d0\u00d1\7g\2\2\u00d1\u00d2\7v\2\2\u00d2\u00d3"+
		"\7j\2\2\u00d3\u00d4\7q\2\2\u00d4\u00d5\7f\2\2\u00d5$\3\2\2\2\u00d6\u00d7"+
		"\7a\2\2\u00d7&\3\2\2\2\u00d8\u00d9\7*\2\2\u00d9(\3\2\2\2\u00da\u00db\7"+
		"+\2\2\u00db*\3\2\2\2\u00dc\u00dd\7}\2\2\u00dd,\3\2\2\2\u00de\u00df\7\177"+
		"\2\2\u00df.\3\2\2\2\u00e0\u00e1\7]\2\2\u00e1\60\3\2\2\2\u00e2\u00e3\7"+
		"_\2\2\u00e3\62\3\2\2\2\u00e4\u00e5\7.\2\2\u00e5\64\3\2\2\2\u00e6\u00e7"+
		"\7\60\2\2\u00e7\66\3\2\2\2\u00e8\u00e9\7<\2\2\u00e98\3\2\2\2\u00ea\u00eb"+
		"\7=\2\2\u00eb:\3\2\2\2\u00ec\u00ed\7?\2\2\u00ed<\3\2\2\2\u00ee\u00ef\7"+
		"/\2\2\u00ef\u00f0\7@\2\2\u00f0>\3\2\2\2\u00f1\u00f2\7#\2\2\u00f2@\3\2"+
		"\2\2\u00f3\u00f4\7>\2\2\u00f4B\3\2\2\2\u00f5\u00f6\7>\2\2\u00f6\u00f7"+
		"\7?\2\2\u00f7D\3\2\2\2\u00f8\u00f9\7@\2\2\u00f9F\3\2\2\2\u00fa\u00fb\7"+
		"@\2\2\u00fb\u00fc\7?\2\2\u00fcH\3\2\2\2\u00fd\u00fe\7B\2\2\u00feJ\3\2"+
		"\2\2\u00ff\u0103\5[.\2\u0100\u0102\5]/\2\u0101\u0100\3\2\2\2\u0102\u0105"+
		"\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104L\3\2\2\2\u0105"+
		"\u0103\3\2\2\2\u0106\u0107\5_\60\2\u0107N\3\2\2\2\u0108\u0109\5_\60\2"+
		"\u0109\u010b\5\65\33\2\u010a\u010c\5_\60\2\u010b\u010a\3\2\2\2\u010b\u010c"+
		"\3\2\2\2\u010c\u0111\3\2\2\2\u010d\u010e\5\65\33\2\u010e\u010f\5_\60\2"+
		"\u010f\u0111\3\2\2\2\u0110\u0108\3\2\2\2\u0110\u010d\3\2\2\2\u0111P\3"+
		"\2\2\2\u0112\u0113\7,\2\2\u0113\u0114\5c\62\2\u0114R\3\2\2\2\u0115\u0116"+
		"\7\61\2\2\u0116\u0117\5c\62\2\u0117T\3\2\2\2\u0118\u0119\7-\2\2\u0119"+
		"\u011a\5c\62\2\u011aV\3\2\2\2\u011b\u011c\7/\2\2\u011c\u011d\5c\62\2\u011d"+
		"X\3\2\2\2\u011e\u0122\7$\2\2\u011f\u0121\n\2\2\2\u0120\u011f\3\2\2\2\u0121"+
		"\u0124\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0125\3\2"+
		"\2\2\u0124\u0122\3\2\2\2\u0125\u0126\7$\2\2\u0126Z\3\2\2\2\u0127\u0129"+
		"\t\3\2\2\u0128\u0127\3\2\2\2\u0129\\\3\2\2\2\u012a\u012c\t\4\2\2\u012b"+
		"\u012a\3\2\2\2\u012c^\3\2\2\2\u012d\u012f\5a\61\2\u012e\u012d\3\2\2\2"+
		"\u012f\u0130\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131`\3"+
		"\2\2\2\u0132\u0133\t\5\2\2\u0133b\3\2\2\2\u0134\u0136\7\60\2\2\u0135\u0134"+
		"\3\2\2\2\u0135\u0136\3\2\2\2\u0136d\3\2\2\2\u0137\u0138\7\61\2\2\u0138"+
		"\u0139\7\61\2\2\u0139\u013d\3\2\2\2\u013a\u013c\n\6\2\2\u013b\u013a\3"+
		"\2\2\2\u013c\u013f\3\2\2\2\u013d\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e"+
		"\u0140\3\2\2\2\u013f\u013d\3\2\2\2\u0140\u0141\b\63\2\2\u0141f\3\2\2\2"+
		"\u0142\u0143\7\61\2\2\u0143\u0144\7,\2\2\u0144\u0148\3\2\2\2\u0145\u0147"+
		"\13\2\2\2\u0146\u0145\3\2\2\2\u0147\u014a\3\2\2\2\u0148\u0149\3\2\2\2"+
		"\u0148\u0146\3\2\2\2\u0149\u014b\3\2\2\2\u014a\u0148\3\2\2\2\u014b\u014c"+
		"\7,\2\2\u014c\u014d\7\61\2\2\u014d\u014e\3\2\2\2\u014e\u014f\b\64\2\2"+
		"\u014fh\3\2\2\2\u0150\u0152\t\7\2\2\u0151\u0150\3\2\2\2\u0152\u0153\3"+
		"\2\2\2\u0153\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0155\3\2\2\2\u0155"+
		"\u0156\b\65\2\2\u0156j\3\2\2\2\16\2\u0103\u010b\u0110\u0122\u0128\u012b"+
		"\u0130\u0135\u013d\u0148\u0153\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}