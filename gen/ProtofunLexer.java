// Generated from /home/net/repos/protofunmvn/src/main/antlr4/ProtofunLexer.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ProtofunLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, PRINT=2, L_PAREN=3, REAL_LITERAL=4, INTEGER_LITERAL=5, R_PAREN=6, 
		ACCUMULATION_OP=7, MULOP=8, ASSIGNMENT_OP=9, VAR=10, ALGORITHM=11, TYPE=12, 
		IDENTIFIER=13, CLOSE_CURLY_BRACE=14, OPEN_CURLY_BRACE=15, BLOCK_COMMENT=16, 
		COMMENT=17, COLON=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS", "PRINT", "L_PAREN", "REAL_LITERAL", "INTEGER_LITERAL", "R_PAREN", 
			"ACCUMULATION_OP", "MULOP", "ASSIGNMENT_OP", "VAR", "ALGORITHM", "TYPE", 
			"IDENTIFIER", "CLOSE_CURLY_BRACE", "OPEN_CURLY_BRACE", "BLOCK_COMMENT", 
			"COMMENT", "COLON"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'print'", "'('", null, null, "')'", null, null, "':='", 
			"'var '", "'algorithm'", null, null, "'}'", "'{'", null, null, "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "PRINT", "L_PAREN", "REAL_LITERAL", "INTEGER_LITERAL", "R_PAREN", 
			"ACCUMULATION_OP", "MULOP", "ASSIGNMENT_OP", "VAR", "ALGORITHM", "TYPE", 
			"IDENTIFIER", "CLOSE_CURLY_BRACE", "OPEN_CURLY_BRACE", "BLOCK_COMMENT", 
			"COMMENT", "COLON"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public ProtofunLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ProtofunLexer.g4"; }

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
		"\u0004\u0000\u0012\u0094\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0001\u0000\u0004\u0000\'\b\u0000\u000b\u0000\f\u0000(\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0003\u00036\b\u0003\u0001"+
		"\u0003\u0004\u00039\b\u0003\u000b\u0003\f\u0003:\u0001\u0003\u0001\u0003"+
		"\u0004\u0003?\b\u0003\u000b\u0003\f\u0003@\u0001\u0004\u0003\u0004D\b"+
		"\u0004\u0001\u0004\u0004\u0004G\b\u0004\u000b\u0004\f\u0004H\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000bk\b\u000b\u0001\f\u0001\f\u0005\fo\b\f\n\f\f\f"+
		"r\t\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0005\u000f|\b\u000f\n\u000f\f\u000f\u007f\t"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u008a\b\u0010\n"+
		"\u0010\f\u0010\u008d\t\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0002}\u008b\u0000\u0012\u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010"+
		"!\u0011#\u0012\u0001\u0000\u0007\u0003\u0000\t\n\r\r  \u0001\u000009\u0002"+
		"\u0000++--\u0003\u0000%%**//\u0002\u0000AZaz\u0005\u0000--09AZ__az\u0001"+
		"\u0000\n\n\u009d\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001"+
		"\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001"+
		"\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000"+
		"\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000"+
		"\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000"+
		"\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000"+
		"\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000"+
		"\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000"+
		"\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0001"+
		"&\u0001\u0000\u0000\u0000\u0003,\u0001\u0000\u0000\u0000\u00052\u0001"+
		"\u0000\u0000\u0000\u00075\u0001\u0000\u0000\u0000\tC\u0001\u0000\u0000"+
		"\u0000\u000bJ\u0001\u0000\u0000\u0000\rL\u0001\u0000\u0000\u0000\u000f"+
		"N\u0001\u0000\u0000\u0000\u0011P\u0001\u0000\u0000\u0000\u0013S\u0001"+
		"\u0000\u0000\u0000\u0015X\u0001\u0000\u0000\u0000\u0017j\u0001\u0000\u0000"+
		"\u0000\u0019l\u0001\u0000\u0000\u0000\u001bs\u0001\u0000\u0000\u0000\u001d"+
		"u\u0001\u0000\u0000\u0000\u001fw\u0001\u0000\u0000\u0000!\u0085\u0001"+
		"\u0000\u0000\u0000#\u0092\u0001\u0000\u0000\u0000%\'\u0007\u0000\u0000"+
		"\u0000&%\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000(&\u0001\u0000"+
		"\u0000\u0000()\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*+\u0006"+
		"\u0000\u0000\u0000+\u0002\u0001\u0000\u0000\u0000,-\u0005p\u0000\u0000"+
		"-.\u0005r\u0000\u0000./\u0005i\u0000\u0000/0\u0005n\u0000\u000001\u0005"+
		"t\u0000\u00001\u0004\u0001\u0000\u0000\u000023\u0005(\u0000\u00003\u0006"+
		"\u0001\u0000\u0000\u000046\u0005-\u0000\u000054\u0001\u0000\u0000\u0000"+
		"56\u0001\u0000\u0000\u000068\u0001\u0000\u0000\u000079\u0007\u0001\u0000"+
		"\u000087\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:8\u0001\u0000"+
		"\u0000\u0000:;\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<>\u0005"+
		".\u0000\u0000=?\u0007\u0001\u0000\u0000>=\u0001\u0000\u0000\u0000?@\u0001"+
		"\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000"+
		"A\b\u0001\u0000\u0000\u0000BD\u0005-\u0000\u0000CB\u0001\u0000\u0000\u0000"+
		"CD\u0001\u0000\u0000\u0000DF\u0001\u0000\u0000\u0000EG\u0007\u0001\u0000"+
		"\u0000FE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HF\u0001\u0000"+
		"\u0000\u0000HI\u0001\u0000\u0000\u0000I\n\u0001\u0000\u0000\u0000JK\u0005"+
		")\u0000\u0000K\f\u0001\u0000\u0000\u0000LM\u0007\u0002\u0000\u0000M\u000e"+
		"\u0001\u0000\u0000\u0000NO\u0007\u0003\u0000\u0000O\u0010\u0001\u0000"+
		"\u0000\u0000PQ\u0005:\u0000\u0000QR\u0005=\u0000\u0000R\u0012\u0001\u0000"+
		"\u0000\u0000ST\u0005v\u0000\u0000TU\u0005a\u0000\u0000UV\u0005r\u0000"+
		"\u0000VW\u0005 \u0000\u0000W\u0014\u0001\u0000\u0000\u0000XY\u0005a\u0000"+
		"\u0000YZ\u0005l\u0000\u0000Z[\u0005g\u0000\u0000[\\\u0005o\u0000\u0000"+
		"\\]\u0005r\u0000\u0000]^\u0005i\u0000\u0000^_\u0005t\u0000\u0000_`\u0005"+
		"h\u0000\u0000`a\u0005m\u0000\u0000a\u0016\u0001\u0000\u0000\u0000bc\u0005"+
		"I\u0000\u0000cd\u0005n\u0000\u0000dk\u0005t\u0000\u0000ef\u0005F\u0000"+
		"\u0000fg\u0005l\u0000\u0000gh\u0005o\u0000\u0000hi\u0005a\u0000\u0000"+
		"ik\u0005t\u0000\u0000jb\u0001\u0000\u0000\u0000je\u0001\u0000\u0000\u0000"+
		"k\u0018\u0001\u0000\u0000\u0000lp\u0007\u0004\u0000\u0000mo\u0007\u0005"+
		"\u0000\u0000nm\u0001\u0000\u0000\u0000or\u0001\u0000\u0000\u0000pn\u0001"+
		"\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000q\u001a\u0001\u0000\u0000"+
		"\u0000rp\u0001\u0000\u0000\u0000st\u0005}\u0000\u0000t\u001c\u0001\u0000"+
		"\u0000\u0000uv\u0005{\u0000\u0000v\u001e\u0001\u0000\u0000\u0000wx\u0005"+
		"/\u0000\u0000xy\u0005*\u0000\u0000y}\u0001\u0000\u0000\u0000z|\t\u0000"+
		"\u0000\u0000{z\u0001\u0000\u0000\u0000|\u007f\u0001\u0000\u0000\u0000"+
		"}~\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000~\u0080\u0001\u0000"+
		"\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u0080\u0081\u0005*\u0000\u0000"+
		"\u0081\u0082\u0005/\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083"+
		"\u0084\u0006\u000f\u0000\u0000\u0084 \u0001\u0000\u0000\u0000\u0085\u0086"+
		"\u0005/\u0000\u0000\u0086\u0087\u0005/\u0000\u0000\u0087\u008b\u0001\u0000"+
		"\u0000\u0000\u0088\u008a\t\u0000\u0000\u0000\u0089\u0088\u0001\u0000\u0000"+
		"\u0000\u008a\u008d\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000"+
		"\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008c\u008e\u0001\u0000\u0000"+
		"\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008e\u008f\u0007\u0006\u0000"+
		"\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0091\u0006\u0010\u0000"+
		"\u0000\u0091\"\u0001\u0000\u0000\u0000\u0092\u0093\u0005:\u0000\u0000"+
		"\u0093$\u0001\u0000\u0000\u0000\u000b\u0000(5:@CHjp}\u008b\u0001\u0006"+
		"\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}