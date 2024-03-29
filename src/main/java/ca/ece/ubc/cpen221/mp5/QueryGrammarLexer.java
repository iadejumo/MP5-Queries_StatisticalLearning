// Generated from QueryGrammar.g4 by ANTLR 4.7

package ca.ece.ubc.cpen221.mp5;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QueryGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, OR=6, AND=7, INEQ=8, GT=9, GTE=10, 
		LT=11, LTE=12, EQ=13, NUM=14, LPAREN=15, RPAREN=16, WORD=17, SYMBOLS=18, 
		WS=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "OR", "AND", "INEQ", "GT", "GTE", 
		"LT", "LTE", "EQ", "NUM", "LPAREN", "RPAREN", "WORD", "SYMBOLS", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'in'", "'category'", "'name'", "'rating'", "'price'", "'||'", "'&&'", 
		null, "'>'", "'>='", "'<'", "'<='", "'='", null, "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "OR", "AND", "INEQ", "GT", "GTE", 
		"LT", "LTE", "EQ", "NUM", "LPAREN", "RPAREN", "WORD", "SYMBOLS", "WS"
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


	public QueryGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "QueryGrammar.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25u\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\5\tS\n\t\3\n\3\n\3\13\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\6\17b\n\17\r\17\16\17c\3\20\3"+
		"\20\3\21\3\21\3\22\6\22k\n\22\r\22\16\22l\3\23\3\23\3\24\6\24r\n\24\r"+
		"\24\16\24s\2\2\25\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25\3\2\6\3\2\63\67\5\2\62;C\\c|\4"+
		"\2(+/\61\5\2\13\f\17\17\"\"\2{\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3)\3\2\2\2\5"+
		",\3\2\2\2\7\65\3\2\2\2\t:\3\2\2\2\13A\3\2\2\2\rG\3\2\2\2\17J\3\2\2\2\21"+
		"R\3\2\2\2\23T\3\2\2\2\25V\3\2\2\2\27Y\3\2\2\2\31[\3\2\2\2\33^\3\2\2\2"+
		"\35a\3\2\2\2\37e\3\2\2\2!g\3\2\2\2#j\3\2\2\2%n\3\2\2\2\'q\3\2\2\2)*\7"+
		"k\2\2*+\7p\2\2+\4\3\2\2\2,-\7e\2\2-.\7c\2\2./\7v\2\2/\60\7g\2\2\60\61"+
		"\7i\2\2\61\62\7q\2\2\62\63\7t\2\2\63\64\7{\2\2\64\6\3\2\2\2\65\66\7p\2"+
		"\2\66\67\7c\2\2\678\7o\2\289\7g\2\29\b\3\2\2\2:;\7t\2\2;<\7c\2\2<=\7v"+
		"\2\2=>\7k\2\2>?\7p\2\2?@\7i\2\2@\n\3\2\2\2AB\7r\2\2BC\7t\2\2CD\7k\2\2"+
		"DE\7e\2\2EF\7g\2\2F\f\3\2\2\2GH\7~\2\2HI\7~\2\2I\16\3\2\2\2JK\7(\2\2K"+
		"L\7(\2\2L\20\3\2\2\2MS\5\23\n\2NS\5\25\13\2OS\5\27\f\2PS\5\31\r\2QS\5"+
		"\33\16\2RM\3\2\2\2RN\3\2\2\2RO\3\2\2\2RP\3\2\2\2RQ\3\2\2\2S\22\3\2\2\2"+
		"TU\7@\2\2U\24\3\2\2\2VW\7@\2\2WX\7?\2\2X\26\3\2\2\2YZ\7>\2\2Z\30\3\2\2"+
		"\2[\\\7>\2\2\\]\7?\2\2]\32\3\2\2\2^_\7?\2\2_\34\3\2\2\2`b\t\2\2\2a`\3"+
		"\2\2\2bc\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\36\3\2\2\2ef\7*\2\2f \3\2\2\2gh"+
		"\7+\2\2h\"\3\2\2\2ik\t\3\2\2ji\3\2\2\2kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2m"+
		"$\3\2\2\2no\t\4\2\2o&\3\2\2\2pr\t\5\2\2qp\3\2\2\2rs\3\2\2\2sq\3\2\2\2"+
		"st\3\2\2\2t(\3\2\2\2\7\2Rcls\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}