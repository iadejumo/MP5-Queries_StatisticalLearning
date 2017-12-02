package ca.ece.ubc.cpen221.mp5;

import java.util.Collections;
import java.util.Map;

import org.json.simple.JSONObject;

public class Review {
	private String type;
	private String business_id;
	private Map<String,Integer> votes;
	private String review_id;
	private String text;
	private long stars;
	private String user_id;
	private String date;
	private String jsonString;
	
	public Review(JSONObject review) {
		this.type = (String) review.get("type");
		this.business_id = (String) review.get("business_id");
		this.votes = (Map<String,Integer>) review.get("votes");
		this.review_id = (String) review.get("review_id");
		this.text = (String) review.get("text");
		this.stars = (long) review.get("stars");
		this.user_id = (String) review.get("user_id");
		this.date = (String) review.get("date");
		this.jsonString = review.toString();
	}
	
	public String getType() {
		return type;
	}
	public String getBusiness_id() {
		return business_id;
	}
	public Map<String,Integer> getVotes() {
		return Collections.unmodifiableMap(votes);
	}
	public String getReview_id() {
		return review_id;
	}
	public String getText() {
		return text;
	}
	public long getStars() {
		return stars;
	}
	public String getUser_id() {
		return user_id;
	}
	public String getDate() {
		return date;
	}
	@Override
	public boolean equals(Object other) {
		if (other instanceof Review) {
			Review otherRes = (Review) other;
			return (this.review_id.equals(otherRes.review_id));
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return review_id.hashCode();
	}
	
	@Override
	public String toString() {
		return jsonString;
	}
}
