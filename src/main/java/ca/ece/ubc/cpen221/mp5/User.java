package ca.ece.ubc.cpen221.mp5;

import java.util.Collections;
import java.util.Map;

import org.json.simple.JSONObject;

public class User {

	private String url;
	private Map<String,Integer> votes;
	private long review_count;
	private String type;
	private String user_id;
	private String name;
	private Double average_stars;
	
	public User(JSONObject user) {
		this.url = (String) user.get("url");
		this.votes = (Map<String,Integer>) user.get("votes");
		this.review_count = (long) user.get("review_count");
		this.type = (String) user.get("type");
		this.user_id = (String) user.get("user_id");
		this.name = (String) user.get("name");
		this.average_stars = (Double) user.get("average_stars");
	}
	
	public String getUrl() {
		return url;
	}
	public Map<String,Integer> getVotes() {
		return Collections.unmodifiableMap(votes);
	}
	public long getReview_count() {
		return review_count;
	}
	public String getType() {
		return type;
	}
	public String getUser_id() {
		return user_id;
	}
	public String getName() {
		return name;
	}
	public Double getAverage_stars() {
		return average_stars;
	}
}
