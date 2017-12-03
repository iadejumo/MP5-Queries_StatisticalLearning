package ca.ece.ubc.cpen221.mp5;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

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
	 * keys in votes are "useful","cool",or "funny"
	 * 
	 * all Integers in votes >= 0
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
	 *            JSONObject with fields: (none null or NaN)
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
	 * Creates a User object with the given name, and initiates empty fields
	 * 
	 * @param name
	 *            - String name of the user, can't be null
	 */
	public User(String name) {
		this.name = name;
		this.user_id = generateUser_id();
		this.url = generateDummyURL(user_id);
		this.votes = generateNewVotesMap();
		this.review_count = 0;
		this.type = "user";
		this.average_stars = 0.0;
		this.jsonString = generateJsonString();
	}

	// creates random user_id for new user
	private String generateUser_id() {
		String uniqueID = UUID.randomUUID().toString();
		uniqueID += name.hashCode();

		return uniqueID;
	}

	// creates the url for new user
	private String generateDummyURL(String user_id) {
		String defaultURL = "http://www.yelp.com/user_details?userid=";
		return defaultURL + user_id;
	}

	// creates an empty votes map
	private Map<String, Integer> generateNewVotesMap() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("funny", 0);
		map.put("useful", 0);
		map.put("cool", 0);

		return map;
	}

	// create JsonString of user
	private String generateJsonString() {
		JSONObject JsonObj = new JSONObject();
		JsonObj.put("url", this.url);
		JsonObj.put("votes", this.votes);
		JsonObj.put("review_count", this.review_count);
		JsonObj.put("type", this.type);
		JsonObj.put("user_id", this.user_id);
		JsonObj.put("name", this.name);
		JsonObj.put("average_stars", this.average_stars);

		return JsonObj.toString();
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

	public void updateRating(long newReview) {
		average_stars = (average_stars * review_count + newReview) / (review_count + 1);
		review_count++;
	}

	/**
	 * checks the equality of this User to other
	 * 
	 * @param other
	 *            - Object to be compared to this in terms of equality
	 * @return boolean - true if other and this are equal (have the same user_id),
	 *         else false
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
