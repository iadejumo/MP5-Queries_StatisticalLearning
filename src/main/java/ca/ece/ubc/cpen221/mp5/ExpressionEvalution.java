package ca.ece.ubc.cpen221.mp5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ExpressionEvalution extends QueryGrammarBaseListener {
	private Map<String, Restaurant> restaurants;

	private Stack<List<String>> matches = new Stack<List<String>>();
	private List<String> finalMatches = new ArrayList<String>();

	private static final double PRECISION = 0.0001;

	public ExpressionEvalution(YelpDB yelpDB) {
		restaurants = yelpDB.getRestaurants();
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterRoot(QueryGrammarParser.RootContext ctx) {
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void exitRoot(QueryGrammarParser.RootContext ctx) {
		finalMatches.addAll(matches.pop());
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterOrExpr(QueryGrammarParser.OrExprContext ctx) {
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void exitOrExpr(QueryGrammarParser.OrExprContext ctx) {
		List<String> otherList = new ArrayList<String>();
		List<String> orCombination = new ArrayList<String>();

		orCombination = matches.pop();
		int numChildren = ctx.getChildCount();

		if (ctx.OR().toString().contains("||")) {
			System.out.println("Inside");
			otherList = matches.pop();

			for (String item : otherList) {
				if (!orCombination.contains(item)) {
					orCombination.add(item);
				}
			}
		}

		matches.push(orCombination);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterAndExpr(QueryGrammarParser.AndExprContext ctx) {
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void exitAndExpr(QueryGrammarParser.AndExprContext ctx) {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		List<String> andCombination = new ArrayList<String>();

		list1 = matches.pop();

		if (ctx.AND().toString().contains("&&")) {
			list2 = matches.pop();
			for (String item : list1) {
				if (list2.contains(item)) {
					andCombination.add(item);
				}
			}
		} else {

			andCombination.addAll(list1);
		}
		matches.push(andCombination);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterAtom(QueryGrammarParser.AtomContext ctx) {
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void exitAtom(QueryGrammarParser.AtomContext ctx) {
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterIn(QueryGrammarParser.InContext ctx) {
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void exitIn(QueryGrammarParser.InContext ctx) {
		String neighborhood = ctx.string().getText();

		List<String> matchNeighborhood = restaurants.keySet().stream()
				.filter(x -> restaurants.get(x).getNeighborhoods().contains(neighborhood)).collect(Collectors.toList());
		// System.out.println(matchNeighborhood);
		matches.push(matchNeighborhood);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterCategory(QueryGrammarParser.CategoryContext ctx) {
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void exitCategory(QueryGrammarParser.CategoryContext ctx) {
		String category = ctx.string().getText();

		List<String> matchCategory = restaurants.keySet().stream()
				.filter(x -> restaurants.get(x).getCategories().contains(category)).collect(Collectors.toList());
		// System.out.println(matchCategory);
		matches.push(matchCategory);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterName(QueryGrammarParser.NameContext ctx) {
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void exitName(QueryGrammarParser.NameContext ctx) {
		String businessName = ctx.string().getText();

		List<String> matchName = restaurants.keySet().stream()
				.filter(x -> restaurants.get(x).getName().equals(businessName)).collect(Collectors.toList());
		// System.out.println(matchName);
		matches.push(matchName);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public void enterRating(QueryGrammarParser.RatingContext ctx) {
	}

	private static boolean checkClose(double arg1, double arg2) {
		if (Math.abs(arg1 - arg2) < PRECISION)
			return true;
		return false;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void exitRating(QueryGrammarParser.RatingContext ctx) {
		double rating = Double.parseDouble(ctx.NUM().getText());
		String inequality = ctx.INEQ().getText();
		List<String> matchRatingAndInequality = new ArrayList<String>();

		if (inequality.equals(">")) {
			matchRatingAndInequality = restaurants.keySet().stream().filter(x -> restaurants.get(x).getStars() > rating)
					.collect(Collectors.toList());
		} else if (inequality.equals(">=")) {
			matchRatingAndInequality = restaurants.keySet().stream()
					.filter(x -> restaurants.get(x).getStars() >= rating).collect(Collectors.toList());
		} else if (inequality.equals("<")) {
			matchRatingAndInequality = restaurants.keySet().stream().filter(x -> restaurants.get(x).getStars() < rating)
					.collect(Collectors.toList());
		} else if (inequality.equals("<=")) {
			matchRatingAndInequality = restaurants.keySet().stream()
					.filter(x -> restaurants.get(x).getStars() <= rating).collect(Collectors.toList());
		} else if (inequality.equals("=")) {
			matchRatingAndInequality = restaurants.keySet().stream()
					.filter(x -> checkClose(restaurants.get(x).getStars(), rating)).collect(Collectors.toList());
		}

		// System.out.println(matchRatingAndInequality);
		matches.push(matchRatingAndInequality);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterPrice(QueryGrammarParser.PriceContext ctx) {
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void exitPrice(QueryGrammarParser.PriceContext ctx) {
		long price = Long.parseLong(ctx.NUM().getText());
		String inequality = ctx.INEQ().getText();
		List<String> matchPriceAndInequality = new ArrayList<String>();

		if (inequality.equals(">")) {
			matchPriceAndInequality = restaurants.keySet().stream().filter(x -> restaurants.get(x).getPrice() > price)
					.collect(Collectors.toList());
		} else if (inequality.equals(">=")) {
			matchPriceAndInequality = restaurants.keySet().stream().filter(x -> restaurants.get(x).getPrice() >= price)
					.collect(Collectors.toList());
		} else if (inequality.equals("<")) {
			matchPriceAndInequality = restaurants.keySet().stream().filter(x -> restaurants.get(x).getPrice() < price)
					.collect(Collectors.toList());
		} else if (inequality.equals("<=")) {
			matchPriceAndInequality = restaurants.keySet().stream().filter(x -> restaurants.get(x).getPrice() <= price)
					.collect(Collectors.toList());
		} else if (inequality.equals("=")) {
			matchPriceAndInequality = restaurants.keySet().stream().filter(x -> restaurants.get(x).getPrice() == price)
					.collect(Collectors.toList());
		}

		// System.out.println(matchPriceAndInequality);
		matches.push(matchPriceAndInequality);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterString(QueryGrammarParser.StringContext ctx) {
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void exitString(QueryGrammarParser.StringContext ctx) {
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void visitTerminal(TerminalNode node) {
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void visitErrorNode(ErrorNode node) {
	}

	public List<String> returnResults() {

		return Collections.unmodifiableList(finalMatches);
	}
}
