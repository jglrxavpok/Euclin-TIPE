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
		New=15, Import=16, ImportMethod=17, LinkStart=18, LambdaVariable=19, LeftBracket=20, 
		RightBracket=21, LeftCurlyBracket=22, RightCurlyBracket=23, LeftSquareBracket=24, 
		RightSquareBracket=25, Comma=26, Period=27, Colon=28, SemiColon=29, Equals=30, 
		LightArrow=31, RightLightArrow=32, Bang=33, Less=34, LessEqual=35, Greater=36, 
		GreaterEqual=37, Star=38, Identifier=39, Integer=40, FloatNumber=41, MultOperator=42, 
		DivOperator=43, AddOperator=44, SubOperator=45, StringConstant=46, LineComment=47, 
		MultilineComment=48, Whitespace=49;
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
		"DivOperator", "AddOperator", "SubOperator", "StringConstant", "IdentifierStart", 
		"IdentifierPart", "Digits", "Digit", "BinaryOperatorSuffix", "LineComment", 
		"MultilineComment", "Whitespace"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\63\u0163\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3"+
		"\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3"+
		"\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3#\3#\3$\3$\3$"+
		"\3%\3%\3&\3&\3&\3\'\3\'\3(\3(\7(\u010e\n(\f(\16(\u0111\13(\3)\3)\3*\3"+
		"*\3*\5*\u0118\n*\3*\3*\3*\5*\u011d\n*\3+\3+\3+\3,\3,\3,\3-\3-\3-\3.\3"+
		".\3.\3/\3/\7/\u012d\n/\f/\16/\u0130\13/\3/\3/\3\60\5\60\u0135\n\60\3\61"+
		"\5\61\u0138\n\61\3\62\6\62\u013b\n\62\r\62\16\62\u013c\3\63\3\63\3\64"+
		"\5\64\u0142\n\64\3\65\3\65\3\65\3\65\7\65\u0148\n\65\f\65\16\65\u014b"+
		"\13\65\3\65\3\65\3\66\3\66\3\66\3\66\7\66\u0153\n\66\f\66\16\66\u0156"+
		"\13\66\3\66\3\66\3\66\3\66\3\66\3\67\6\67\u015e\n\67\r\67\16\67\u015f"+
		"\3\67\3\67\3\u0154\28\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\2a\2c\2e\2"+
		"g\2i\61k\62m\63\3\2\b\3\2$$\4\2C\\c|\5\2\62;C\\c|\3\2\62;\4\2\f\f\17\17"+
		"\5\2\13\f\17\17\"\"\2\u0166\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C"+
		"\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2"+
		"\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2"+
		"\2]\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\3o\3\2\2\2\5r\3\2\2\2\7y"+
		"\3\2\2\2\t\u0083\3\2\2\2\13\u0088\3\2\2\2\r\u008c\3\2\2\2\17\u0091\3\2"+
		"\2\2\21\u0097\3\2\2\2\23\u009c\3\2\2\2\25\u00a3\3\2\2\2\27\u00ac\3\2\2"+
		"\2\31\u00b1\3\2\2\2\33\u00b4\3\2\2\2\35\u00ba\3\2\2\2\37\u00c1\3\2\2\2"+
		"!\u00c5\3\2\2\2#\u00cc\3\2\2\2%\u00da\3\2\2\2\'\u00df\3\2\2\2)\u00e1\3"+
		"\2\2\2+\u00e3\3\2\2\2-\u00e5\3\2\2\2/\u00e7\3\2\2\2\61\u00e9\3\2\2\2\63"+
		"\u00eb\3\2\2\2\65\u00ed\3\2\2\2\67\u00ef\3\2\2\29\u00f1\3\2\2\2;\u00f3"+
		"\3\2\2\2=\u00f5\3\2\2\2?\u00f7\3\2\2\2A\u00fa\3\2\2\2C\u00fd\3\2\2\2E"+
		"\u00ff\3\2\2\2G\u0101\3\2\2\2I\u0104\3\2\2\2K\u0106\3\2\2\2M\u0109\3\2"+
		"\2\2O\u010b\3\2\2\2Q\u0112\3\2\2\2S\u011c\3\2\2\2U\u011e\3\2\2\2W\u0121"+
		"\3\2\2\2Y\u0124\3\2\2\2[\u0127\3\2\2\2]\u012a\3\2\2\2_\u0134\3\2\2\2a"+
		"\u0137\3\2\2\2c\u013a\3\2\2\2e\u013e\3\2\2\2g\u0141\3\2\2\2i\u0143\3\2"+
		"\2\2k\u014e\3\2\2\2m\u015d\3\2\2\2op\7c\2\2pq\7u\2\2q\4\3\2\2\2rs\7t\2"+
		"\2st\7g\2\2tu\7v\2\2uv\7w\2\2vw\7t\2\2wx\7p\2\2x\6\3\2\2\2yz\7v\2\2z{"+
		"\7t\2\2{|\7c\2\2|}\7p\2\2}~\7u\2\2~\177\7h\2\2\177\u0080\7q\2\2\u0080"+
		"\u0081\7t\2\2\u0081\u0082\7o\2\2\u0082\b\3\2\2\2\u0083\u0084\7h\2\2\u0084"+
		"\u0085\7w\2\2\u0085\u0086\7p\2\2\u0086\u0087\7e\2\2\u0087\n\3\2\2\2\u0088"+
		"\u0089\7x\2\2\u0089\u008a\7c\2\2\u008a\u008b\7t\2\2\u008b\f\3\2\2\2\u008c"+
		"\u008d\7v\2\2\u008d\u008e\7t\2\2\u008e\u008f\7w\2\2\u008f\u0090\7g\2\2"+
		"\u0090\16\3\2\2\2\u0091\u0092\7h\2\2\u0092\u0093\7c\2\2\u0093\u0094\7"+
		"n\2\2\u0094\u0095\7u\2\2\u0095\u0096\7g\2\2\u0096\20\3\2\2\2\u0097\u0098"+
		"\7r\2\2\u0098\u0099\7w\2\2\u0099\u009a\7t\2\2\u009a\u009b\7g\2\2\u009b"+
		"\22\3\2\2\2\u009c\u009d\7k\2\2\u009d\u009e\7o\2\2\u009e\u009f\7r\2\2\u009f"+
		"\u00a0\7w\2\2\u00a0\u00a1\7t\2\2\u00a1\u00a2\7g\2\2\u00a2\24\3\2\2\2\u00a3"+
		"\u00a4\7o\2\2\u00a4\u00a5\7g\2\2\u00a5\u00a6\7o\2\2\u00a6\u00a7\7q\2\2"+
		"\u00a7\u00a8\7k\2\2\u00a8\u00a9\7|\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab"+
		"\7f\2\2\u00ab\26\3\2\2\2\u00ac\u00ad\7g\2\2\u00ad\u00ae\7n\2\2\u00ae\u00af"+
		"\7u\2\2\u00af\u00b0\7g\2\2\u00b0\30\3\2\2\2\u00b1\u00b2\7k\2\2\u00b2\u00b3"+
		"\7h\2\2\u00b3\32\3\2\2\2\u00b4\u00b5\7y\2\2\u00b5\u00b6\7j\2\2\u00b6\u00b7"+
		"\7k\2\2\u00b7\u00b8\7n\2\2\u00b8\u00b9\7g\2\2\u00b9\34\3\2\2\2\u00ba\u00bb"+
		"\7u\2\2\u00bb\u00bc\7v\2\2\u00bc\u00bd\7t\2\2\u00bd\u00be\7w\2\2\u00be"+
		"\u00bf\7e\2\2\u00bf\u00c0\7v\2\2\u00c0\36\3\2\2\2\u00c1\u00c2\7p\2\2\u00c2"+
		"\u00c3\7g\2\2\u00c3\u00c4\7y\2\2\u00c4 \3\2\2\2\u00c5\u00c6\7k\2\2\u00c6"+
		"\u00c7\7o\2\2\u00c7\u00c8\7r\2\2\u00c8\u00c9\7q\2\2\u00c9\u00ca\7t\2\2"+
		"\u00ca\u00cb\7v\2\2\u00cb\"\3\2\2\2\u00cc\u00cd\7k\2\2\u00cd\u00ce\7o"+
		"\2\2\u00ce\u00cf\7r\2\2\u00cf\u00d0\7q\2\2\u00d0\u00d1\7t\2\2\u00d1\u00d2"+
		"\7v\2\2\u00d2\u00d3\7\"\2\2\u00d3\u00d4\7o\2\2\u00d4\u00d5\7g\2\2\u00d5"+
		"\u00d6\7v\2\2\u00d6\u00d7\7j\2\2\u00d7\u00d8\7q\2\2\u00d8\u00d9\7f\2\2"+
		"\u00d9$\3\2\2\2\u00da\u00db\7n\2\2\u00db\u00dc\7k\2\2\u00dc\u00dd\7p\2"+
		"\2\u00dd\u00de\7m\2\2\u00de&\3\2\2\2\u00df\u00e0\7a\2\2\u00e0(\3\2\2\2"+
		"\u00e1\u00e2\7*\2\2\u00e2*\3\2\2\2\u00e3\u00e4\7+\2\2\u00e4,\3\2\2\2\u00e5"+
		"\u00e6\7}\2\2\u00e6.\3\2\2\2\u00e7\u00e8\7\177\2\2\u00e8\60\3\2\2\2\u00e9"+
		"\u00ea\7]\2\2\u00ea\62\3\2\2\2\u00eb\u00ec\7_\2\2\u00ec\64\3\2\2\2\u00ed"+
		"\u00ee\7.\2\2\u00ee\66\3\2\2\2\u00ef\u00f0\7\60\2\2\u00f08\3\2\2\2\u00f1"+
		"\u00f2\7<\2\2\u00f2:\3\2\2\2\u00f3\u00f4\7=\2\2\u00f4<\3\2\2\2\u00f5\u00f6"+
		"\7?\2\2\u00f6>\3\2\2\2\u00f7\u00f8\7/\2\2\u00f8\u00f9\7@\2\2\u00f9@\3"+
		"\2\2\2\u00fa\u00fb\7>\2\2\u00fb\u00fc\7/\2\2\u00fcB\3\2\2\2\u00fd\u00fe"+
		"\7#\2\2\u00feD\3\2\2\2\u00ff\u0100\7>\2\2\u0100F\3\2\2\2\u0101\u0102\7"+
		">\2\2\u0102\u0103\7?\2\2\u0103H\3\2\2\2\u0104\u0105\7@\2\2\u0105J\3\2"+
		"\2\2\u0106\u0107\7@\2\2\u0107\u0108\7?\2\2\u0108L\3\2\2\2\u0109\u010a"+
		"\7B\2\2\u010aN\3\2\2\2\u010b\u010f\5_\60\2\u010c\u010e\5a\61\2\u010d\u010c"+
		"\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110"+
		"P\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u0113\5c\62\2\u0113R\3\2\2\2\u0114"+
		"\u0115\5c\62\2\u0115\u0117\5\67\34\2\u0116\u0118\5c\62\2\u0117\u0116\3"+
		"\2\2\2\u0117\u0118\3\2\2\2\u0118\u011d\3\2\2\2\u0119\u011a\5\67\34\2\u011a"+
		"\u011b\5c\62\2\u011b\u011d\3\2\2\2\u011c\u0114\3\2\2\2\u011c\u0119\3\2"+
		"\2\2\u011dT\3\2\2\2\u011e\u011f\7,\2\2\u011f\u0120\5g\64\2\u0120V\3\2"+
		"\2\2\u0121\u0122\7\61\2\2\u0122\u0123\5g\64\2\u0123X\3\2\2\2\u0124\u0125"+
		"\7-\2\2\u0125\u0126\5g\64\2\u0126Z\3\2\2\2\u0127\u0128\7/\2\2\u0128\u0129"+
		"\5g\64\2\u0129\\\3\2\2\2\u012a\u012e\7$\2\2\u012b\u012d\n\2\2\2\u012c"+
		"\u012b\3\2\2\2\u012d\u0130\3\2\2\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2"+
		"\2\2\u012f\u0131\3\2\2\2\u0130\u012e\3\2\2\2\u0131\u0132\7$\2\2\u0132"+
		"^\3\2\2\2\u0133\u0135\t\3\2\2\u0134\u0133\3\2\2\2\u0135`\3\2\2\2\u0136"+
		"\u0138\t\4\2\2\u0137\u0136\3\2\2\2\u0138b\3\2\2\2\u0139\u013b\5e\63\2"+
		"\u013a\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d"+
		"\3\2\2\2\u013dd\3\2\2\2\u013e\u013f\t\5\2\2\u013ff\3\2\2\2\u0140\u0142"+
		"\7\60\2\2\u0141\u0140\3\2\2\2\u0141\u0142\3\2\2\2\u0142h\3\2\2\2\u0143"+
		"\u0144\7\61\2\2\u0144\u0145\7\61\2\2\u0145\u0149\3\2\2\2\u0146\u0148\n"+
		"\6\2\2\u0147\u0146\3\2\2\2\u0148\u014b\3\2\2\2\u0149\u0147\3\2\2\2\u0149"+
		"\u014a\3\2\2\2\u014a\u014c\3\2\2\2\u014b\u0149\3\2\2\2\u014c\u014d\b\65"+
		"\2\2\u014dj\3\2\2\2\u014e\u014f\7\61\2\2\u014f\u0150\7,\2\2\u0150\u0154"+
		"\3\2\2\2\u0151\u0153\13\2\2\2\u0152\u0151\3\2\2\2\u0153\u0156\3\2\2\2"+
		"\u0154\u0155\3\2\2\2\u0154\u0152\3\2\2\2\u0155\u0157\3\2\2\2\u0156\u0154"+
		"\3\2\2\2\u0157\u0158\7,\2\2\u0158\u0159\7\61\2\2\u0159\u015a\3\2\2\2\u015a"+
		"\u015b\b\66\2\2\u015bl\3\2\2\2\u015c\u015e\t\7\2\2\u015d\u015c\3\2\2\2"+
		"\u015e\u015f\3\2\2\2\u015f\u015d\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0161"+
		"\3\2\2\2\u0161\u0162\b\67\2\2\u0162n\3\2\2\2\16\2\u010f\u0117\u011c\u012e"+
		"\u0134\u0137\u013c\u0141\u0149\u0154\u015f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}