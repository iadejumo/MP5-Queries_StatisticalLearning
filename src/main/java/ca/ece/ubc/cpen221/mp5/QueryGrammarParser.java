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
		public List<TerminalNode> WS() { return getTokens(QueryGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(QueryGrammarParser.WS, i);
		}
		public List<TerminalNode> OR() { return getTokens(QueryGrammarParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(QueryGrammarParser.OR, i);
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
			setState(25);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(24);
				match(WS);
				}
				break;
			}
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR || _la==WS) {
				{
				{
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WS) {
					{
					setState(27);
					match(WS);
					}
				}

				setState(30);
				match(OR);
				setState(31);
				andExpr();
				}
				}
				setState(36);
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
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(37);
				match(WS);
				}
			}

			setState(40);
			atom();
			setState(42);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(41);
				match(WS);
				}
				break;
			}
			setState(54);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(45);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==WS) {
						{
						setState(44);
						match(WS);
						}
					}

					setState(47);
					match(AND);
					setState(49);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==WS) {
						{
						setState(48);
						match(WS);
						}
					}

					setState(51);
					atom();
					}
					} 
				}
				setState(56);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				in();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				category();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(59);
				rating();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 4);
				{
				setState(60);
				price();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 5);
				{
				setState(61);
				name();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 6);
				{
				{
				setState(62);
				match(LPAREN);
				setState(63);
				orExpr();
				setState(64);
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
			setState(68);
			match(T__0);
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(69);
				match(WS);
				}
			}

			setState(72);
			match(LPAREN);
			setState(73);
			string();
			setState(74);
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
			setState(76);
			match(T__1);
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(77);
				match(WS);
				}
			}

			setState(80);
			match(LPAREN);
			setState(81);
			string();
			setState(82);
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
			setState(84);
			match(T__2);
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(85);
				match(WS);
				}
			}

			setState(88);
			match(LPAREN);
			setState(89);
			string();
			setState(90);
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
			setState(92);
			match(T__3);
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(93);
				match(WS);
				}
			}

			setState(96);
			match(INEQ);
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
			setState(102);
			match(T__4);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(103);
				match(WS);
				}
			}

			setState(106);
			match(INEQ);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(107);
				match(WS);
				}
			}

			setState(110);
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
		public List<TerminalNode> SYMBOLS() { return getTokens(QueryGrammarParser.SYMBOLS); }
		public TerminalNode SYMBOLS(int i) {
			return getToken(QueryGrammarParser.SYMBOLS, i);
		}
		public List<TerminalNode> WS() { return getTokens(QueryGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(QueryGrammarParser.WS, i);
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
			setState(119); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(113);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==WS) {
						{
						setState(112);
						match(WS);
						}
					}

					setState(115);
					match(WORD);
					setState(117);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						setState(116);
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
				setState(121); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SYMBOLS || _la==WS) {
				{
				{
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WS) {
					{
					setState(123);
					match(WS);
					}
				}

				setState(126);
				match(SYMBOLS);
				setState(128);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(127);
					match(WS);
					}
					break;
				}
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WORD) {
					{
					{
					setState(130);
					match(WORD);
					}
					}
					setState(135);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(137);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(136);
					match(WS);
					}
					break;
				}
				setState(142);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(139);
						match(SYMBOLS);
						}
						} 
					}
					setState(144);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				}
				setState(146);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(145);
					match(WS);
					}
					break;
				}
				}
				}
				setState(152);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25\u009c\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\3\2\3\2\3\3\3\3\5\3\34\n\3\3\3\5\3\37\n\3\3\3\3\3\7\3#\n\3\f"+
		"\3\16\3&\13\3\3\4\5\4)\n\4\3\4\3\4\5\4-\n\4\3\4\5\4\60\n\4\3\4\3\4\5\4"+
		"\64\n\4\3\4\7\4\67\n\4\f\4\16\4:\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\5\5E\n\5\3\6\3\6\5\6I\n\6\3\6\3\6\3\6\3\6\3\7\3\7\5\7Q\n\7\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\5\bY\n\b\3\b\3\b\3\b\3\b\3\t\3\t\5\ta\n\t\3\t\3\t\5"+
		"\te\n\t\3\t\3\t\3\n\3\n\5\nk\n\n\3\n\3\n\5\no\n\n\3\n\3\n\3\13\5\13t\n"+
		"\13\3\13\3\13\5\13x\n\13\6\13z\n\13\r\13\16\13{\3\13\5\13\177\n\13\3\13"+
		"\3\13\5\13\u0083\n\13\3\13\7\13\u0086\n\13\f\13\16\13\u0089\13\13\3\13"+
		"\5\13\u008c\n\13\3\13\7\13\u008f\n\13\f\13\16\13\u0092\13\13\3\13\5\13"+
		"\u0095\n\13\7\13\u0097\n\13\f\13\16\13\u009a\13\13\3\13\2\2\f\2\4\6\b"+
		"\n\f\16\20\22\24\2\2\2\u00af\2\26\3\2\2\2\4\31\3\2\2\2\6(\3\2\2\2\bD\3"+
		"\2\2\2\nF\3\2\2\2\fN\3\2\2\2\16V\3\2\2\2\20^\3\2\2\2\22h\3\2\2\2\24y\3"+
		"\2\2\2\26\27\5\4\3\2\27\30\7\2\2\3\30\3\3\2\2\2\31\33\5\6\4\2\32\34\7"+
		"\25\2\2\33\32\3\2\2\2\33\34\3\2\2\2\34$\3\2\2\2\35\37\7\25\2\2\36\35\3"+
		"\2\2\2\36\37\3\2\2\2\37 \3\2\2\2 !\7\b\2\2!#\5\6\4\2\"\36\3\2\2\2#&\3"+
		"\2\2\2$\"\3\2\2\2$%\3\2\2\2%\5\3\2\2\2&$\3\2\2\2\')\7\25\2\2(\'\3\2\2"+
		"\2()\3\2\2\2)*\3\2\2\2*,\5\b\5\2+-\7\25\2\2,+\3\2\2\2,-\3\2\2\2-8\3\2"+
		"\2\2.\60\7\25\2\2/.\3\2\2\2/\60\3\2\2\2\60\61\3\2\2\2\61\63\7\t\2\2\62"+
		"\64\7\25\2\2\63\62\3\2\2\2\63\64\3\2\2\2\64\65\3\2\2\2\65\67\5\b\5\2\66"+
		"/\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29\7\3\2\2\2:8\3\2\2\2;E\5\n"+
		"\6\2<E\5\f\7\2=E\5\20\t\2>E\5\22\n\2?E\5\16\b\2@A\7\21\2\2AB\5\4\3\2B"+
		"C\7\22\2\2CE\3\2\2\2D;\3\2\2\2D<\3\2\2\2D=\3\2\2\2D>\3\2\2\2D?\3\2\2\2"+
		"D@\3\2\2\2E\t\3\2\2\2FH\7\3\2\2GI\7\25\2\2HG\3\2\2\2HI\3\2\2\2IJ\3\2\2"+
		"\2JK\7\21\2\2KL\5\24\13\2LM\7\22\2\2M\13\3\2\2\2NP\7\4\2\2OQ\7\25\2\2"+
		"PO\3\2\2\2PQ\3\2\2\2QR\3\2\2\2RS\7\21\2\2ST\5\24\13\2TU\7\22\2\2U\r\3"+
		"\2\2\2VX\7\5\2\2WY\7\25\2\2XW\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z[\7\21\2\2["+
		"\\\5\24\13\2\\]\7\22\2\2]\17\3\2\2\2^`\7\6\2\2_a\7\25\2\2`_\3\2\2\2`a"+
		"\3\2\2\2ab\3\2\2\2bd\7\n\2\2ce\7\25\2\2dc\3\2\2\2de\3\2\2\2ef\3\2\2\2"+
		"fg\7\20\2\2g\21\3\2\2\2hj\7\7\2\2ik\7\25\2\2ji\3\2\2\2jk\3\2\2\2kl\3\2"+
		"\2\2ln\7\n\2\2mo\7\25\2\2nm\3\2\2\2no\3\2\2\2op\3\2\2\2pq\7\20\2\2q\23"+
		"\3\2\2\2rt\7\25\2\2sr\3\2\2\2st\3\2\2\2tu\3\2\2\2uw\7\23\2\2vx\7\25\2"+
		"\2wv\3\2\2\2wx\3\2\2\2xz\3\2\2\2ys\3\2\2\2z{\3\2\2\2{y\3\2\2\2{|\3\2\2"+
		"\2|\u0098\3\2\2\2}\177\7\25\2\2~}\3\2\2\2~\177\3\2\2\2\177\u0080\3\2\2"+
		"\2\u0080\u0082\7\24\2\2\u0081\u0083\7\25\2\2\u0082\u0081\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0087\3\2\2\2\u0084\u0086\7\23\2\2\u0085\u0084\3"+
		"\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008c\7\25\2\2\u008b\u008a\3"+
		"\2\2\2\u008b\u008c\3\2\2\2\u008c\u0090\3\2\2\2\u008d\u008f\7\24\2\2\u008e"+
		"\u008d\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2"+
		"\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0095\7\25\2\2\u0094"+
		"\u0093\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\3\2\2\2\u0096~\3\2\2\2"+
		"\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\25"+
		"\3\2\2\2\u009a\u0098\3\2\2\2\34\33\36$(,/\638DHPX`djnsw{~\u0082\u0087"+
		"\u008b\u0090\u0094\u0098";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}