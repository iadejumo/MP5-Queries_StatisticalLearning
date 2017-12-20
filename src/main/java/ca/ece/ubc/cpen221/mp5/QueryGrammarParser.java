// Generated from QueryGrammar.g4 by ANTLR 4.7

package ca.ece.ubc.cpen221.mp5;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QueryGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, OR=6, AND=7, INEQ=8, GT=9, GTE=10, 
		LT=11, LTE=12, EQ=13, NUM=14, LPAREN=15, RPAREN=16, WORD=17, SYMBOLS=18, 
		WS=19;
	public static final int
		RULE_root = 0, RULE_orExpr = 1, RULE_andExpr = 2, RULE_atom = 3, RULE_in = 4, 
		RULE_category = 5, RULE_name = 6, RULE_rating = 7, RULE_price = 8, RULE_string = 9;
	public static final String[] ruleNames = {
		"root", "orExpr", "andExpr", "atom", "in", "category", "name", "rating", 
		"price", "string"
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

	@Override
	public String getGrammarFileName() { return "QueryGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	  @Override
	  public void reportError(RecognitionException e) {
	    throw new RuntimeException("I quit!\n" + e.getMessage()); 
	  }

	public QueryGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RootContext extends ParserRuleContext {
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public TerminalNode EOF() { return getToken(QueryGrammarParser.EOF, 0); }
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QueryGrammarListener ) ((QueryGrammarListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QueryGrammarListener ) ((QueryGrammarListener)listener).exitRoot(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			orExpr();
			setState(21);
			match(EOF);
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

	public static class OrExprContext extends ParserRuleContext {
		public List<AndExprContext> andExpr() {
			return getRuleContexts(AndExprContext.class);
		}
		public AndExprContext andExpr(int i) {
			return getRuleContext(AndExprContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(QueryGrammarParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(QueryGrammarParser.OR, i);
		}
		public List<TerminalNode> WS() { return getTokens(QueryGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(QueryGrammarParser.WS, i);
		}
		public OrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QueryGrammarListener ) ((QueryGrammarListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QueryGrammarListener ) ((QueryGrammarListener)listener).exitOrExpr(this);
		}
	}

	public final OrExprContext orExpr() throws RecognitionException {
		OrExprContext _localctx = new OrExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_orExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			andExpr();
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR || _la==WS) {
				{
				{
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WS) {
					{
					setState(24);
					match(WS);
					}
				}

				setState(27);
				match(OR);
				setState(28);
				andExpr();
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

	public static class AndExprContext extends ParserRuleContext {
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public List<TerminalNode> WS() { return getTokens(QueryGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(QueryGrammarParser.WS, i);
		}
		public List<TerminalNode> AND() { return getTokens(QueryGrammarParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(QueryGrammarParser.AND, i);
		}
		public AndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QueryGrammarListener ) ((QueryGrammarListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QueryGrammarListener ) ((QueryGrammarListener)listener).exitAndExpr(this);
		}
	}

	public final AndExprContext andExpr() throws RecognitionException {
		AndExprContext _localctx = new AndExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_andExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(34);
				match(WS);
				}
			}

			setState(37);
			atom();
			setState(48);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(39);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==WS) {
						{
						setState(38);
						match(WS);
						}
					}

					setState(41);
					match(AND);
					setState(43);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==WS) {
						{
						setState(42);
						match(WS);
						}
					}

					setState(45);
					atom();
					}
					} 
				}
				setState(50);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class AtomContext extends ParserRuleContext {
		public InContext in() {
			return getRuleContext(InContext.class,0);
		}
		public CategoryContext category() {
			return getRuleContext(CategoryContext.class,0);
		}
		public RatingContext rating() {
			return getRuleContext(RatingContext.class,0);
		}
		public PriceContext price() {
			return getRuleContext(PriceContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(QueryGrammarParser.LPAREN, 0); }
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(QueryGrammarParser.RPAREN, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QueryGrammarListener ) ((QueryGrammarListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QueryGrammarListener ) ((QueryGrammarListener)listener).exitAtom(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_atom);
		try {
			setState(60);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				in();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				category();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(53);
				rating();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 4);
				{
				setState(54);
				price();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 5);
				{
				setState(55);
				name();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 6);
				{
				{
				setState(56);
				match(LPAREN);
				setState(57);
				orExpr();
				setState(58);
				match(RPAREN);
				}
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

	public static class InContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(QueryGrammarParser.LPAREN, 0); }
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(QueryGrammarParser.RPAREN, 0); }
		public TerminalNode WS() { return getToken(QueryGrammarParser.WS, 0); }
		public InContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_in; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QueryGrammarListener ) ((QueryGrammarListener)listener).enterIn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QueryGrammarListener ) ((QueryGrammarListener)listener).exitIn(this);
		}
	}

	public final InContext in() throws RecognitionException {
		InContext _localctx = new InContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_in);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(T__0);
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(63);
				match(WS);
				}
			}

			setState(66);
			match(LPAREN);
			setState(67);
			string();
			setState(68);
			match(RPAREN);
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

	public static class CategoryContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(QueryGrammarParser.LPAREN, 0); }
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(QueryGrammarParser.RPAREN, 0); }
		public TerminalNode WS() { return getToken(QueryGrammarParser.WS, 0); }
		public CategoryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_category; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QueryGrammarListener ) ((QueryGrammarListener)listener).enterCategory(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QueryGrammarListener ) ((QueryGrammarListener)listener).exitCategory(this);
		}
	}

	public final CategoryContext category() throws RecognitionException {
		CategoryContext _localctx = new CategoryContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_category);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(T__1);
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(71);
				match(WS);
				}
			}

			setState(74);
			match(LPAREN);
			setState(75);
			string();
			setState(76);
			match(RPAREN);
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

	public static class NameContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(QueryGrammarParser.LPAREN, 0); }
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(QueryGrammarParser.RPAREN, 0); }
		public TerminalNode WS() { return getToken(QueryGrammarParser.WS, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QueryGrammarListener ) ((QueryGrammarListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QueryGrammarListener ) ((QueryGrammarListener)listener).exitName(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(T__2);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(79);
				match(WS);
				}
			}

			setState(82);
			match(LPAREN);
			setState(83);
			string();
			setState(84);
			match(RPAREN);
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

	public static class RatingContext extends ParserRuleContext {
		public TerminalNode INEQ() { return getToken(QueryGrammarParser.INEQ, 0); }
		public TerminalNode NUM() { return getToken(QueryGrammarParser.NUM, 0); }
		public List<TerminalNode> WS() { return getTokens(QueryGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(QueryGrammarParser.WS, i);
		}
		public RatingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rating; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QueryGrammarListener ) ((QueryGrammarListener)listener).enterRating(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QueryGrammarListener ) ((QueryGrammarListener)listener).exitRating(this);
		}
	}

	public final RatingContext rating() throws RecognitionException {
		RatingContext _localctx = new RatingContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_rating);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(T__3);
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(87);
				match(WS);
				}
			}

			setState(90);
			match(INEQ);
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(91);
				match(WS);
				}
			}

			setState(94);
			match(NUM);
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

	public static class PriceContext extends ParserRuleContext {
		public TerminalNode INEQ() { return getToken(QueryGrammarParser.INEQ, 0); }
		public TerminalNode NUM() { return getToken(QueryGrammarParser.NUM, 0); }
		public List<TerminalNode> WS() { return getTokens(QueryGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(QueryGrammarParser.WS, i);
		}
		public PriceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_price; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QueryGrammarListener ) ((QueryGrammarListener)listener).enterPrice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QueryGrammarListener ) ((QueryGrammarListener)listener).exitPrice(this);
		}
	}

	public final PriceContext price() throws RecognitionException {
		PriceContext _localctx = new PriceContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_price);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__4);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(97);
				match(WS);
				}
			}

			setState(100);
			match(INEQ);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(101);
				match(WS);
				}
			}

			setState(104);
			match(NUM);
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

	public static class StringContext extends ParserRuleContext {
		public List<TerminalNode> WORD() { return getTokens(QueryGrammarParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(QueryGrammarParser.WORD, i);
		}
		public List<StringContext> string() {
			return getRuleContexts(StringContext.class);
		}
		public StringContext string(int i) {
			return getRuleContext(StringContext.class,i);
		}
		public List<TerminalNode> WS() { return getTokens(QueryGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(QueryGrammarParser.WS, i);
		}
		public List<TerminalNode> SYMBOLS() { return getTokens(QueryGrammarParser.SYMBOLS); }
		public TerminalNode SYMBOLS(int i) {
			return getToken(QueryGrammarParser.SYMBOLS, i);
		}
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QueryGrammarListener ) ((QueryGrammarListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QueryGrammarListener ) ((QueryGrammarListener)listener).exitString(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_string);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(113); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(107);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==WS) {
						{
						setState(106);
						match(WS);
						}
					}

					setState(109);
					match(WORD);
					setState(111);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						setState(110);
						match(WS);
						}
						break;
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(115); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(129);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(118);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						setState(117);
						match(WS);
						}
						break;
					}
					setState(121);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SYMBOLS) {
						{
						setState(120);
						match(SYMBOLS);
						}
					}

					setState(124);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						setState(123);
						match(WS);
						}
						break;
					}
					setState(126);
					string();
					}
					} 
				}
				setState(131);
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
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25\u0087\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\3\2\3\2\3\3\3\3\5\3\34\n\3\3\3\3\3\7\3 \n\3\f\3\16\3#\13\3\3"+
		"\4\5\4&\n\4\3\4\3\4\5\4*\n\4\3\4\3\4\5\4.\n\4\3\4\7\4\61\n\4\f\4\16\4"+
		"\64\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5?\n\5\3\6\3\6\5\6C\n\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\5\7K\n\7\3\7\3\7\3\7\3\7\3\b\3\b\5\bS\n\b\3\b"+
		"\3\b\3\b\3\b\3\t\3\t\5\t[\n\t\3\t\3\t\5\t_\n\t\3\t\3\t\3\n\3\n\5\ne\n"+
		"\n\3\n\3\n\5\ni\n\n\3\n\3\n\3\13\5\13n\n\13\3\13\3\13\5\13r\n\13\6\13"+
		"t\n\13\r\13\16\13u\3\13\5\13y\n\13\3\13\5\13|\n\13\3\13\5\13\177\n\13"+
		"\3\13\7\13\u0082\n\13\f\13\16\13\u0085\13\13\3\13\2\2\f\2\4\6\b\n\f\16"+
		"\20\22\24\2\2\2\u0095\2\26\3\2\2\2\4\31\3\2\2\2\6%\3\2\2\2\b>\3\2\2\2"+
		"\n@\3\2\2\2\fH\3\2\2\2\16P\3\2\2\2\20X\3\2\2\2\22b\3\2\2\2\24s\3\2\2\2"+
		"\26\27\5\4\3\2\27\30\7\2\2\3\30\3\3\2\2\2\31!\5\6\4\2\32\34\7\25\2\2\33"+
		"\32\3\2\2\2\33\34\3\2\2\2\34\35\3\2\2\2\35\36\7\b\2\2\36 \5\6\4\2\37\33"+
		"\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"\5\3\2\2\2#!\3\2\2\2$&\7\25"+
		"\2\2%$\3\2\2\2%&\3\2\2\2&\'\3\2\2\2\'\62\5\b\5\2(*\7\25\2\2)(\3\2\2\2"+
		")*\3\2\2\2*+\3\2\2\2+-\7\t\2\2,.\7\25\2\2-,\3\2\2\2-.\3\2\2\2./\3\2\2"+
		"\2/\61\5\b\5\2\60)\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63"+
		"\7\3\2\2\2\64\62\3\2\2\2\65?\5\n\6\2\66?\5\f\7\2\67?\5\20\t\28?\5\22\n"+
		"\29?\5\16\b\2:;\7\21\2\2;<\5\4\3\2<=\7\22\2\2=?\3\2\2\2>\65\3\2\2\2>\66"+
		"\3\2\2\2>\67\3\2\2\2>8\3\2\2\2>9\3\2\2\2>:\3\2\2\2?\t\3\2\2\2@B\7\3\2"+
		"\2AC\7\25\2\2BA\3\2\2\2BC\3\2\2\2CD\3\2\2\2DE\7\21\2\2EF\5\24\13\2FG\7"+
		"\22\2\2G\13\3\2\2\2HJ\7\4\2\2IK\7\25\2\2JI\3\2\2\2JK\3\2\2\2KL\3\2\2\2"+
		"LM\7\21\2\2MN\5\24\13\2NO\7\22\2\2O\r\3\2\2\2PR\7\5\2\2QS\7\25\2\2RQ\3"+
		"\2\2\2RS\3\2\2\2ST\3\2\2\2TU\7\21\2\2UV\5\24\13\2VW\7\22\2\2W\17\3\2\2"+
		"\2XZ\7\6\2\2Y[\7\25\2\2ZY\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\^\7\n\2\2]_\7"+
		"\25\2\2^]\3\2\2\2^_\3\2\2\2_`\3\2\2\2`a\7\20\2\2a\21\3\2\2\2bd\7\7\2\2"+
		"ce\7\25\2\2dc\3\2\2\2de\3\2\2\2ef\3\2\2\2fh\7\n\2\2gi\7\25\2\2hg\3\2\2"+
		"\2hi\3\2\2\2ij\3\2\2\2jk\7\20\2\2k\23\3\2\2\2ln\7\25\2\2ml\3\2\2\2mn\3"+
		"\2\2\2no\3\2\2\2oq\7\23\2\2pr\7\25\2\2qp\3\2\2\2qr\3\2\2\2rt\3\2\2\2s"+
		"m\3\2\2\2tu\3\2\2\2us\3\2\2\2uv\3\2\2\2v\u0083\3\2\2\2wy\7\25\2\2xw\3"+
		"\2\2\2xy\3\2\2\2y{\3\2\2\2z|\7\24\2\2{z\3\2\2\2{|\3\2\2\2|~\3\2\2\2}\177"+
		"\7\25\2\2~}\3\2\2\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080\u0082\5\24\13"+
		"\2\u0081x\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084"+
		"\3\2\2\2\u0084\25\3\2\2\2\u0085\u0083\3\2\2\2\27\33!%)-\62>BJRZ^dhmqu"+
		"x{~\u0083";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}