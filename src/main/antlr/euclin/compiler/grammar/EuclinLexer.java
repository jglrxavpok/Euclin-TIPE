// Generated from D:/Code/Kotlin/Languages/Euclin/src/main/kotlin/antlr/euclin\Euclin.g4 by ANTLR 4.7
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
		New=15, Import=16, ImportMethod=17, LinkStart=18, LambdaVariable=19, LeftBracket=20, 
		RightBracket=21, LeftCurlyBracket=22, RightCurlyBracket=23, LeftSquareBracket=24, 
		RightSquareBracket=25, Comma=26, Period=27, Colon=28, SemiColon=29, Equals=30, 
		LightArrow=31, RightLightArrow=32, Bang=33, Less=34, LessEqual=35, Greater=36, 
		GreaterEqual=37, Star=38, Identifier=39, Integer=40, FloatNumber=41, MultOperator=42, 
		DivOperator=43, AddOperator=44, SubOperator=45, StringConstant=46, CharConstant=47, 
		LineComment=48, MultilineComment=49, Whitespace=50;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "Return", "TransformBlockStart", "FunctionDefStart", "Var", "True", 
		"False", "Pure", "Impure", "Memoized", "Else", "If", "While", "StructStart", 
		"New", "Import", "ImportMethod", "LinkStart", "LambdaVariable", "LeftBracket", 
		"RightBracket", "LeftCurlyBracket", "RightCurlyBracket", "LeftSquareBracket", 
		"RightSquareBracket", "Comma", "Period", "Colon", "SemiColon", "Equals", 
		"LightArrow", "RightLightArrow", "Bang", "Less", "LessEqual", "Greater", 
		"GreaterEqual", "Star", "Identifier", "Integer", "FloatNumber", "MultOperator", 
		"DivOperator", "AddOperator", "SubOperator", "StringConstant", "CharConstant", 
		"IdentifierStart", "IdentifierPart", "Digits", "Digit", "BinaryOperatorSuffix", 
		"LineComment", "MultilineComment", "Whitespace"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'as'", "'return'", "'transform'", "'func'", "'var'", "'true'", 
		"'false'", "'pure'", "'impure'", "'memoized'", "'else'", "'if'", "'while'", 
		"'struct'", "'new'", "'import'", "'import method'", "'link'", "'_'", "'('", 
		"')'", "'{'", "'}'", "'['", "']'", "','", "'.'", "':'", "';'", "'='", 
		"'->'", "'<-'", "'!'", "'<'", "'<='", "'>'", "'>='", "'@'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "Return", "TransformBlockStart", "FunctionDefStart", "Var", 
		"True", "False", "Pure", "Impure", "Memoized", "Else", "If", "While", 
		"StructStart", "New", "Import", "ImportMethod", "LinkStart", "LambdaVariable", 
		"LeftBracket", "RightBracket", "LeftCurlyBracket", "RightCurlyBracket", 
		"LeftSquareBracket", "RightSquareBracket", "Comma", "Period", "Colon", 
		"SemiColon", "Equals", "LightArrow", "RightLightArrow", "Bang", "Less", 
		"LessEqual", "Greater", "GreaterEqual", "Star", "Identifier", "Integer", 
		"FloatNumber", "MultOperator", "DivOperator", "AddOperator", "SubOperator", 
		"StringConstant", "CharConstant", "LineComment", "MultilineComment", "Whitespace"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\64\u0169\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\3\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3"+
		"\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3"+
		"\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3#\3#\3$\3"+
		"$\3$\3%\3%\3&\3&\3&\3\'\3\'\3(\3(\7(\u0110\n(\f(\16(\u0113\13(\3)\3)\3"+
		"*\3*\3*\5*\u011a\n*\3*\3*\3*\5*\u011f\n*\3+\3+\3+\3,\3,\3,\3-\3-\3-\3"+
		".\3.\3.\3/\3/\7/\u012f\n/\f/\16/\u0132\13/\3/\3/\3\60\3\60\3\60\3\60\3"+
		"\61\5\61\u013b\n\61\3\62\5\62\u013e\n\62\3\63\6\63\u0141\n\63\r\63\16"+
		"\63\u0142\3\64\3\64\3\65\5\65\u0148\n\65\3\66\3\66\3\66\3\66\7\66\u014e"+
		"\n\66\f\66\16\66\u0151\13\66\3\66\3\66\3\67\3\67\3\67\3\67\7\67\u0159"+
		"\n\67\f\67\16\67\u015c\13\67\3\67\3\67\3\67\3\67\3\67\38\68\u0164\n8\r"+
		"8\168\u0165\38\38\3\u015a\29\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61"+
		"a\2c\2e\2g\2i\2k\62m\63o\64\3\2\t\3\2$$\3\2))\4\2C\\c|\5\2\62;C\\c|\3"+
		"\2\62;\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u016c\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3"+
		"\2\2\2\3q\3\2\2\2\5t\3\2\2\2\7{\3\2\2\2\t\u0085\3\2\2\2\13\u008a\3\2\2"+
		"\2\r\u008e\3\2\2\2\17\u0093\3\2\2\2\21\u0099\3\2\2\2\23\u009e\3\2\2\2"+
		"\25\u00a5\3\2\2\2\27\u00ae\3\2\2\2\31\u00b3\3\2\2\2\33\u00b6\3\2\2\2\35"+
		"\u00bc\3\2\2\2\37\u00c3\3\2\2\2!\u00c7\3\2\2\2#\u00ce\3\2\2\2%\u00dc\3"+
		"\2\2\2\'\u00e1\3\2\2\2)\u00e3\3\2\2\2+\u00e5\3\2\2\2-\u00e7\3\2\2\2/\u00e9"+
		"\3\2\2\2\61\u00eb\3\2\2\2\63\u00ed\3\2\2\2\65\u00ef\3\2\2\2\67\u00f1\3"+
		"\2\2\29\u00f3\3\2\2\2;\u00f5\3\2\2\2=\u00f7\3\2\2\2?\u00f9\3\2\2\2A\u00fc"+
		"\3\2\2\2C\u00ff\3\2\2\2E\u0101\3\2\2\2G\u0103\3\2\2\2I\u0106\3\2\2\2K"+
		"\u0108\3\2\2\2M\u010b\3\2\2\2O\u010d\3\2\2\2Q\u0114\3\2\2\2S\u011e\3\2"+
		"\2\2U\u0120\3\2\2\2W\u0123\3\2\2\2Y\u0126\3\2\2\2[\u0129\3\2\2\2]\u012c"+
		"\3\2\2\2_\u0135\3\2\2\2a\u013a\3\2\2\2c\u013d\3\2\2\2e\u0140\3\2\2\2g"+
		"\u0144\3\2\2\2i\u0147\3\2\2\2k\u0149\3\2\2\2m\u0154\3\2\2\2o\u0163\3\2"+
		"\2\2qr\7c\2\2rs\7u\2\2s\4\3\2\2\2tu\7t\2\2uv\7g\2\2vw\7v\2\2wx\7w\2\2"+
		"xy\7t\2\2yz\7p\2\2z\6\3\2\2\2{|\7v\2\2|}\7t\2\2}~\7c\2\2~\177\7p\2\2\177"+
		"\u0080\7u\2\2\u0080\u0081\7h\2\2\u0081\u0082\7q\2\2\u0082\u0083\7t\2\2"+
		"\u0083\u0084\7o\2\2\u0084\b\3\2\2\2\u0085\u0086\7h\2\2\u0086\u0087\7w"+
		"\2\2\u0087\u0088\7p\2\2\u0088\u0089\7e\2\2\u0089\n\3\2\2\2\u008a\u008b"+
		"\7x\2\2\u008b\u008c\7c\2\2\u008c\u008d\7t\2\2\u008d\f\3\2\2\2\u008e\u008f"+
		"\7v\2\2\u008f\u0090\7t\2\2\u0090\u0091\7w\2\2\u0091\u0092\7g\2\2\u0092"+
		"\16\3\2\2\2\u0093\u0094\7h\2\2\u0094\u0095\7c\2\2\u0095\u0096\7n\2\2\u0096"+
		"\u0097\7u\2\2\u0097\u0098\7g\2\2\u0098\20\3\2\2\2\u0099\u009a\7r\2\2\u009a"+
		"\u009b\7w\2\2\u009b\u009c\7t\2\2\u009c\u009d\7g\2\2\u009d\22\3\2\2\2\u009e"+
		"\u009f\7k\2\2\u009f\u00a0\7o\2\2\u00a0\u00a1\7r\2\2\u00a1\u00a2\7w\2\2"+
		"\u00a2\u00a3\7t\2\2\u00a3\u00a4\7g\2\2\u00a4\24\3\2\2\2\u00a5\u00a6\7"+
		"o\2\2\u00a6\u00a7\7g\2\2\u00a7\u00a8\7o\2\2\u00a8\u00a9\7q\2\2\u00a9\u00aa"+
		"\7k\2\2\u00aa\u00ab\7|\2\2\u00ab\u00ac\7g\2\2\u00ac\u00ad\7f\2\2\u00ad"+
		"\26\3\2\2\2\u00ae\u00af\7g\2\2\u00af\u00b0\7n\2\2\u00b0\u00b1\7u\2\2\u00b1"+
		"\u00b2\7g\2\2\u00b2\30\3\2\2\2\u00b3\u00b4\7k\2\2\u00b4\u00b5\7h\2\2\u00b5"+
		"\32\3\2\2\2\u00b6\u00b7\7y\2\2\u00b7\u00b8\7j\2\2\u00b8\u00b9\7k\2\2\u00b9"+
		"\u00ba\7n\2\2\u00ba\u00bb\7g\2\2\u00bb\34\3\2\2\2\u00bc\u00bd\7u\2\2\u00bd"+
		"\u00be\7v\2\2\u00be\u00bf\7t\2\2\u00bf\u00c0\7w\2\2\u00c0\u00c1\7e\2\2"+
		"\u00c1\u00c2\7v\2\2\u00c2\36\3\2\2\2\u00c3\u00c4\7p\2\2\u00c4\u00c5\7"+
		"g\2\2\u00c5\u00c6\7y\2\2\u00c6 \3\2\2\2\u00c7\u00c8\7k\2\2\u00c8\u00c9"+
		"\7o\2\2\u00c9\u00ca\7r\2\2\u00ca\u00cb\7q\2\2\u00cb\u00cc\7t\2\2\u00cc"+
		"\u00cd\7v\2\2\u00cd\"\3\2\2\2\u00ce\u00cf\7k\2\2\u00cf\u00d0\7o\2\2\u00d0"+
		"\u00d1\7r\2\2\u00d1\u00d2\7q\2\2\u00d2\u00d3\7t\2\2\u00d3\u00d4\7v\2\2"+
		"\u00d4\u00d5\7\"\2\2\u00d5\u00d6\7o\2\2\u00d6\u00d7\7g\2\2\u00d7\u00d8"+
		"\7v\2\2\u00d8\u00d9\7j\2\2\u00d9\u00da\7q\2\2\u00da\u00db\7f\2\2\u00db"+
		"$\3\2\2\2\u00dc\u00dd\7n\2\2\u00dd\u00de\7k\2\2\u00de\u00df\7p\2\2\u00df"+
		"\u00e0\7m\2\2\u00e0&\3\2\2\2\u00e1\u00e2\7a\2\2\u00e2(\3\2\2\2\u00e3\u00e4"+
		"\7*\2\2\u00e4*\3\2\2\2\u00e5\u00e6\7+\2\2\u00e6,\3\2\2\2\u00e7\u00e8\7"+
		"}\2\2\u00e8.\3\2\2\2\u00e9\u00ea\7\177\2\2\u00ea\60\3\2\2\2\u00eb\u00ec"+
		"\7]\2\2\u00ec\62\3\2\2\2\u00ed\u00ee\7_\2\2\u00ee\64\3\2\2\2\u00ef\u00f0"+
		"\7.\2\2\u00f0\66\3\2\2\2\u00f1\u00f2\7\60\2\2\u00f28\3\2\2\2\u00f3\u00f4"+
		"\7<\2\2\u00f4:\3\2\2\2\u00f5\u00f6\7=\2\2\u00f6<\3\2\2\2\u00f7\u00f8\7"+
		"?\2\2\u00f8>\3\2\2\2\u00f9\u00fa\7/\2\2\u00fa\u00fb\7@\2\2\u00fb@\3\2"+
		"\2\2\u00fc\u00fd\7>\2\2\u00fd\u00fe\7/\2\2\u00feB\3\2\2\2\u00ff\u0100"+
		"\7#\2\2\u0100D\3\2\2\2\u0101\u0102\7>\2\2\u0102F\3\2\2\2\u0103\u0104\7"+
		">\2\2\u0104\u0105\7?\2\2\u0105H\3\2\2\2\u0106\u0107\7@\2\2\u0107J\3\2"+
		"\2\2\u0108\u0109\7@\2\2\u0109\u010a\7?\2\2\u010aL\3\2\2\2\u010b\u010c"+
		"\7B\2\2\u010cN\3\2\2\2\u010d\u0111\5a\61\2\u010e\u0110\5c\62\2\u010f\u010e"+
		"\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112"+
		"P\3\2\2\2\u0113\u0111\3\2\2\2\u0114\u0115\5e\63\2\u0115R\3\2\2\2\u0116"+
		"\u0117\5e\63\2\u0117\u0119\5\67\34\2\u0118\u011a\5e\63\2\u0119\u0118\3"+
		"\2\2\2\u0119\u011a\3\2\2\2\u011a\u011f\3\2\2\2\u011b\u011c\5\67\34\2\u011c"+
		"\u011d\5e\63\2\u011d\u011f\3\2\2\2\u011e\u0116\3\2\2\2\u011e\u011b\3\2"+
		"\2\2\u011fT\3\2\2\2\u0120\u0121\7,\2\2\u0121\u0122\5i\65\2\u0122V\3\2"+
		"\2\2\u0123\u0124\7\61\2\2\u0124\u0125\5i\65\2\u0125X\3\2\2\2\u0126\u0127"+
		"\7-\2\2\u0127\u0128\5i\65\2\u0128Z\3\2\2\2\u0129\u012a\7/\2\2\u012a\u012b"+
		"\5i\65\2\u012b\\\3\2\2\2\u012c\u0130\7$\2\2\u012d\u012f\n\2\2\2\u012e"+
		"\u012d\3\2\2\2\u012f\u0132\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2"+
		"\2\2\u0131\u0133\3\2\2\2\u0132\u0130\3\2\2\2\u0133\u0134\7$\2\2\u0134"+
		"^\3\2\2\2\u0135\u0136\7)\2\2\u0136\u0137\n\3\2\2\u0137\u0138\7)\2\2\u0138"+
		"`\3\2\2\2\u0139\u013b\t\4\2\2\u013a\u0139\3\2\2\2\u013bb\3\2\2\2\u013c"+
		"\u013e\t\5\2\2\u013d\u013c\3\2\2\2\u013ed\3\2\2\2\u013f\u0141\5g\64\2"+
		"\u0140\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143"+
		"\3\2\2\2\u0143f\3\2\2\2\u0144\u0145\t\6\2\2\u0145h\3\2\2\2\u0146\u0148"+
		"\7\60\2\2\u0147\u0146\3\2\2\2\u0147\u0148\3\2\2\2\u0148j\3\2\2\2\u0149"+
		"\u014a\7\61\2\2\u014a\u014b\7\61\2\2\u014b\u014f\3\2\2\2\u014c\u014e\n"+
		"\7\2\2\u014d\u014c\3\2\2\2\u014e\u0151\3\2\2\2\u014f\u014d\3\2\2\2\u014f"+
		"\u0150\3\2\2\2\u0150\u0152\3\2\2\2\u0151\u014f\3\2\2\2\u0152\u0153\b\66"+
		"\2\2\u0153l\3\2\2\2\u0154\u0155\7\61\2\2\u0155\u0156\7,\2\2\u0156\u015a"+
		"\3\2\2\2\u0157\u0159\13\2\2\2\u0158\u0157\3\2\2\2\u0159\u015c\3\2\2\2"+
		"\u015a\u015b\3\2\2\2\u015a\u0158\3\2\2\2\u015b\u015d\3\2\2\2\u015c\u015a"+
		"\3\2\2\2\u015d\u015e\7,\2\2\u015e\u015f\7\61\2\2\u015f\u0160\3\2\2\2\u0160"+
		"\u0161\b\67\2\2\u0161n\3\2\2\2\u0162\u0164\t\b\2\2\u0163\u0162\3\2\2\2"+
		"\u0164\u0165\3\2\2\2\u0165\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0167"+
		"\3\2\2\2\u0167\u0168\b8\2\2\u0168p\3\2\2\2\16\2\u0111\u0119\u011e\u0130"+
		"\u013a\u013d\u0142\u0147\u014f\u015a\u0165\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}