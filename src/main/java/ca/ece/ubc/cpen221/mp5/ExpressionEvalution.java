package ca.ece.ubc.cpen221.mp5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ExpressionEvalution extends QueryGrammarBaseListener {
	private Map<String, Restaurant> restaurants;
	private Map<String, Review> reviews;
	private Map<String, User> users;
	
	private static final double PRECISION = 0.0001;
	
	public ExpressionEvalution(YelpDB yelpDB) {
		restaurants = yelpDB.getRestaurants();
		reviews = yelpDB.getReviews();
		users = yelpDB.getUsers();
	}
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
		String neighborhood = ctx.string().getText();
		
		List <String> matchNeighborhood = restaurants.keySet().stream().filter(x -> restaurants.get(x).getNeighborhoods().contains(neighborhood)).collect(Collectors.toList());
		//System.out.println(ctx.string().WORD());
		System.out.println(matchNeighborhood);
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
		String category = ctx.string().getText();
		String parent = ctx.getParent().getText();
		
		List <String> matchCategory = restaurants.keySet().stream().filter(x -> restaurants.get(x).getCategories().contains(category)).collect(Collectors.toList());
		System.out.println(matchCategory);
	}
	
	public List<String> andExpression(ParserRuleContext ctx) {
		int number = ctx.getChildCount();
		
		List <String> matchCategory = restaurants.keySet().stream().filter(x -> restaurants.get(x).getCategories().contains(category)).collect(Collectors.toList());
		System.out.println(matchCategory);
		return matchCategory;
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
		String businessName = ctx.string().getText();
		
		List <String> matchName = restaurants.keySet().stream().filter(x -> restaurants.get(x).getName().equals(businessName)).collect(Collectors.toList());
		System.out.println(matchName);
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
	 * @return 
	 */
	@Override public void enterRating(QueryGrammarParser.RatingContext ctx) {
		double rating = Double.parseDouble(ctx.NUM().getText());
		String inequality = ctx.INEQ().getText();
		List <String> matchRatingAndInequality = new ArrayList<String>();
		
		if (inequality.equals(">")) {
			matchRatingAndInequality = restaurants.keySet().stream().filter(x -> restaurants.get(x).getStars() > rating).collect(Collectors.toList());
		}
		else if (inequality.equals(">=")) {
			matchRatingAndInequality = restaurants.keySet().stream().filter(x -> restaurants.get(x).getStars() >= rating).collect(Collectors.toList());
		} 
		else if (inequality.equals("<")) {
			matchRatingAndInequality = restaurants.keySet().stream().filter(x -> restaurants.get(x).getStars() < rating).collect(Collectors.toList());
		}
		else if (inequality.equals("<=")) {
			matchRatingAndInequality = restaurants.keySet().stream().filter(x -> restaurants.get(x).getStars() <= rating).collect(Collectors.toList());
		}
		else if (inequality.equals("=")) {
			matchRatingAndInequality = restaurants.keySet().stream().filter(x -> checkClose(restaurants.get(x).getStars(), rating)).collect(Collectors.toList());
		}
			
		System.out.println(matchRatingAndInequality);
	}
	
	private static boolean checkClose(double arg1, double arg2) {
		if (Math.abs(arg1 - arg2) < PRECISION)
			return true;
		return false;
	}
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
	@Override public void enterPrice(QueryGrammarParser.PriceContext ctx) {
		long price = Long.parseLong(ctx.NUM().getText());
		String inequality = ctx.INEQ().getText();
		List <String> matchPriceAndInequality = new ArrayList<String>();
		
		if (inequality.equals(">")) {
			matchPriceAndInequality = restaurants.keySet().stream().filter(x -> restaurants.get(x).getPrice() > price).collect(Collectors.toList());
		}
		else if (inequality.equals(">=")) {
			matchPriceAndInequality = restaurants.keySet().stream().filter(x -> restaurants.get(x).getPrice() >= price).collect(Collectors.toList());
		} 
		else if (inequality.equals("<")) {
			matchPriceAndInequality = restaurants.keySet().stream().filter(x -> restaurants.get(x).getPrice() < price).collect(Collectors.toList());
		}
		else if (inequality.equals("<=")) {
			matchPriceAndInequality = restaurants.keySet().stream().filter(x -> restaurants.get(x).getPrice() <= price).collect(Collectors.toList());
		}
		else if (inequality.equals("=")) {
			matchPriceAndInequality = restaurants.keySet().stream().filter(x -> restaurants.get(x).getPrice() == price).collect(Collectors.toList());
		}
		
		System.out.println(matchPriceAndInequality);
	}
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
