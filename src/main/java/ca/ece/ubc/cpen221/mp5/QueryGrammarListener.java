// Generated from QueryGrammar.g4 by ANTLR 4.7

package ca.ece.ubc.cpen221.mp5;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QueryGrammarParser}.
 */
public interface QueryGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QueryGrammarParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(QueryGrammarParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QueryGrammarParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(QueryGrammarParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link QueryGrammarParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(QueryGrammarParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link QueryGrammarParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(QueryGrammarParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link QueryGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(QueryGrammarParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link QueryGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(QueryGrammarParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link QueryGrammarParser#in}.
	 * @param ctx the parse tree
	 */
	void enterIn(QueryGrammarParser.InContext ctx);
	/**
	 * Exit a parse tree produced by {@link QueryGrammarParser#in}.
	 * @param ctx the parse tree
	 */
	void exitIn(QueryGrammarParser.InContext ctx);
	/**
	 * Enter a parse tree produced by {@link QueryGrammarParser#category}.
	 * @param ctx the parse tree
	 */
	void enterCategory(QueryGrammarParser.CategoryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QueryGrammarParser#category}.
	 * @param ctx the parse tree
	 */
	void exitCategory(QueryGrammarParser.CategoryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QueryGrammarParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(QueryGrammarParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QueryGrammarParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(QueryGrammarParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QueryGrammarParser#rating}.
	 * @param ctx the parse tree
	 */
	void enterRating(QueryGrammarParser.RatingContext ctx);
	/**
	 * Exit a parse tree produced by {@link QueryGrammarParser#rating}.
	 * @param ctx the parse tree
	 */
	void exitRating(QueryGrammarParser.RatingContext ctx);
	/**
	 * Enter a parse tree produced by {@link QueryGrammarParser#price}.
	 * @param ctx the parse tree
	 */
	void enterPrice(QueryGrammarParser.PriceContext ctx);
	/**
	 * Exit a parse tree produced by {@link QueryGrammarParser#price}.
	 * @param ctx the parse tree
	 */
	void exitPrice(QueryGrammarParser.PriceContext ctx);
	/**
	 * Enter a parse tree produced by {@link QueryGrammarParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(QueryGrammarParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link QueryGrammarParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(QueryGrammarParser.StringContext ctx);
}