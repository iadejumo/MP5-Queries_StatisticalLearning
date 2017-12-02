package ca.ece.ubc.cpen221.mp5;

import java.util.List;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ExpressionEvalution extends QueryGrammarBaseListener {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterOrExpr(QueryGrammarParser.OrExprContext ctx) { 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitOrExpr(QueryGrammarParser.OrExprContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAndExpr(QueryGrammarParser.AndExprContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAndExpr(QueryGrammarParser.AndExprContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAtom(QueryGrammarParser.AtomContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAtom(QueryGrammarParser.AtomContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIn(QueryGrammarParser.InContext ctx) {
		/*List<TerminalNode> l = ctx.string().WORD();
		String initS = "";
		String ws = " ";
		for (TerminalNode n: l) {
			initS += n + ws;
		}
		initS = initS.substring(0,initS.length()-1);
		
		final String finalS = new String(initS);
		*/
		
		String finalS = ctx.string().getText();
		System.out.println(finalS);
		
		List <String> list = YelpDB.restaurants.keySet().stream().filter(x -> YelpDB.restaurants.get(x).getNeighborhoods().contains(finalS)).collect(Collectors.toList());
		//System.out.println(ctx.string().WORD());
		System.out.println(list);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitIn(QueryGrammarParser.InContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCategory(QueryGrammarParser.CategoryContext ctx) {
	/*	List<TerminalNode> l = ctx.string().WORD();
		String initS = "";
		String ws = " ";
		for (TerminalNode n: l) {
			initS += n + ws;
		}
		initS = initS.substring(0,initS.length()-1);
		
		final String finalS = new String(initS);
		
		System.out.println(finalS);
		
		List <String> list = YelpDB.restaurants.keySet().stream().filter(x -> YelpDB.restaurants.get(x).getCategories().contains(finalS)).collect(Collectors.toList());
		System.out.println(ctx.string().WORD());
		System.out.println(list);*/
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCategory(QueryGrammarParser.CategoryContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterName(QueryGrammarParser.NameContext ctx) {
		List<TerminalNode> l = ctx.string().WORD();
		String initS = "";
		String ws = " ";
		for (TerminalNode n: l) {
			initS += n + ws;
		}
		initS = initS.substring(0,initS.length()-1);
		
		final String finalS = new String(initS);
		
		System.out.println(finalS);
		
		List <String> list = YelpDB.getRestaurants().keySet().stream().filter(x -> YelpDB.restaurants.get(x).getCategories().contains(finalS)).collect(Collectors.toList());
		System.out.println(ctx.string().WORD());
		System.out.println(list);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitName(QueryGrammarParser.NameContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterRating(QueryGrammarParser.RatingContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitRating(QueryGrammarParser.RatingContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterPrice(QueryGrammarParser.PriceContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPrice(QueryGrammarParser.PriceContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterString(QueryGrammarParser.StringContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitString(QueryGrammarParser.StringContext ctx) { }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitTerminal(TerminalNode node) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitErrorNode(ErrorNode node) { }
}
