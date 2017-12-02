package ca.ece.ubc.cpen221.mp5;

import java.util.Collections;
import java.util.Map;

import org.json.simple.JSONObject;

public class User {

	/*
	 * Abstraction Function: all fields of this user, which represent a user's
	 * characteristics
	 * 
	 * Rep. Invariants:
	 * 
	 * no fields are null
	 * 
	 * 1<=average_stars<=5
	 * 
	 * url is a URL that links to a website for the user
	 * 
	 * review_count>=0
	 *
	 * type.equals("user")
	 */
	private String url;
	private Map<String, Integer> votes;
	private long review_count;
	private String type;
	private String user_id;
	private String name;
	private Double average_stars;
	private String jsonString;

	/**
	 * Creates a User object
	 * 
	 * @param user
	 *            JSONObject with fields:
	 * 
	 *            url -> String
	 * 
	 *            votes -> Map<String,Integer>
	 * 
	 *            user_id -> String
	 * 
	 *            name -> String
	 * 
	 *            type -> String
	 * 
	 *            average_stars -> double
	 * 
	 *            review_count -> long
	 * 
	 *            jsonString -> String
	 */
	public User(JSONObject user) {
		this.url = (String) user.get("url");
		this.votes = (Map<String, Integer>) user.get("votes");
		this.review_count = (long) user.get("review_count");
		this.type = (String) user.get("type");
		this.user_id = (String) user.get("user_id");
		this.name = (String) user.get("name");
		this.average_stars = (Double) user.get("average_stars");
		this.jsonString = user.toString();
	}

	/**
	 * gets the URL of the website associated with the user
	 * 
	 * @return String - gets the URL of the website associated with the user
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * gets the user's past votes
	 * 
	 * @return Map<String,Integer> - such that each String is a reaction and its
	 *         Integer value is the number of times it has been used
	 */
	public Map<String, Integer> getVotes() {
		return Collections.unmodifiableMap(votes);
	}

	/**
	 * gets number of reviews written by the User
	 * 
	 * @return long - number of reviews written by the User
	 */
	public long getReview_count() {
		return review_count;
	}

	/**
	 * returns the type of User
	 * 
	 * @return String - the type of User
	 */
	public String getType() {
		return type;
	}

	/**
	 * gets the User's special ID number
	 * 
	 * @return String - the User's unique ID number
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * gets the User's name
	 * 
	 * @return String - name of the User
	 */
	public String getName() {
		return name;
	}

	/**
	 * gets the average star rating given out by the User
	 * 
	 * @return Double - the average star rating given out by the User
	 */
	public Double getAverage_stars() {
		return average_stars;
	}

	/**
	 * checks the equality of this User to other
	 * 
	 * @param other - Object to be compared to this in terms of equality
	 * @return boolean - true if other and this are equal 
	 */
	@Override
	public boolean equals(Object other) {
		if (other instanceof User) {
			User otherRes = (User) other;
			return (this.user_id.equals(otherRes.user_id));
		} else {
			return false;
		}
	}

	/**
	 * returns the Hashcode of the User
	 * 
	 * @return int - the hashcode of the User
	 */
	@Override
	public int hashCode() {
		return user_id.hashCode();
	}

	/**
	 * returns the String representation of the User
	 * 
	 * @return String - the String representation of the User
	 */
	@Override
	public String toString() {
		return jsonString;
	}
}
