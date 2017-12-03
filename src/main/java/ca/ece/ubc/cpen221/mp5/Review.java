package ca.ece.ubc.cpen221.mp5;

import java.util.Collections;
import java.util.Map;

import org.json.simple.JSONObject;

public class Review {

	/*
	 * Abstraction Function: all fields of this Review, which represent a review's
	 * characteristics
	 * 
	 * Rep. Invariants:
	 * 
	 * no fields are null
	 * 
	 * 1<=stars<=5
	 * 
	 * keys in votes are "useful","cool",or "funny"
	 * 
	 * all Integers in votes >= 0
	 * 
	 * date in format YYYY-MM-DD
	 * 
	 * type.equals("review")
	 */

	private String type;
	private String business_id;
	private Map<String, Integer> votes;
	private String review_id;
	private String text;
	private long stars;
	private String user_id;
	private String date;
	private String jsonString;

	/**
	 * Creates a Review object
	 * 
	 * @param review
	 *            JSONObject with fields:
	 * 
	 *            type -> String
	 * 
	 *            business_id -> String
	 * 
	 *            votes -> Map<String,Integer>
	 * 
	 *            review_id -> String
	 * 
	 *            text -> String
	 * 
	 *            stars -> long
	 * 
	 *            user_id -> String
	 * 
	 *            date -> String
	 * 
	 *            jsonString -> String
	 */
	public Review(JSONObject review) {
		this.type = (String) review.get("type");
		this.business_id = (String) review.get("business_id");
		this.votes = (Map<String, Integer>) review.get("votes");
		this.review_id = (String) review.get("review_id");
		this.text = (String) review.get("text");
		this.stars = (long) review.get("stars");
		this.user_id = (String) review.get("user_id");
		this.date = (String) review.get("date");
		this.jsonString = review.toString();
	}

	/**
	 * returns the type
	 * 
	 * @return String - the type: review
	 */
	public String getType() {
		return type;
	}

	/**
	 * returns the business_id of the reviewed restaurant
	 * 
	 * @return String - returns the business_id of the reviewed restaurant
	 */
	public String getBusiness_id() {
		return business_id;
	}

	/**
	 * returns types and number of votes received on this review
	 * 
	 * @return Map<String,Integer> - Strings as keys (type of vote) mapped to an
	 *         Integer representing the number of this type of vote
	 */
	public Map<String, Integer> getVotes() {
		return Collections.unmodifiableMap(votes);
	}

	/**
	 * returns the review_id of this specific review
	 * 
	 * @return String - returns the review_id of this specific review
	 */
	public String getReview_id() {
		return review_id;
	}

	/**
	 * returns the review's text content 
	 * 
	 * @return String - returns review's text content
	 */
	public String getText() {
		return text;
	}

	/**
	 * returns the rating (in # of stars) of this review
	 * 
	 * @return String - returns the rating (in # of stars) of this review
	 */
	public long getStars() {
		return stars;
	}

	/**
	 * returns the user_id of the user who wrote the review
	 * 
	 * @return String - returns the user_id of the user who wrote the review
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * returns the date that this review was written
	 * 
	 * @return String - returns the date that this review was written
	 */
	public String getDate() {
		return date;
	}

	/**
	 * checks the equality of this Review to other
	 * 
	 * @param other - Object to be compared to this in terms of equality
	 * @return boolean - true if other and this are equal (have the same review_id), else false 
	 */
	@Override
	public boolean equals(Object other) {
		if (other instanceof Review) {
			Review otherRes = (Review) other;
			return (this.review_id.equals(otherRes.review_id));
		} else {
			return false;
		}
	}

	/**
	 * returns the Hashcode of the Review
	 * 
	 * @return int - the hashcode of the Review
	 */
	@Override
	public int hashCode() {
		return review_id.hashCode();
	}

	/**
	 * returns the String representation of the Review
	 * 
	 * @return String - the String representation of the Review
	 */
	@Override
	public String toString() {
		return jsonString;
	}
}
