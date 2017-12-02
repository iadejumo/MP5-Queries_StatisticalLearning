package ca.ece.ubc.cpen221.mp5;

import java.util.Collections;
import java.util.List;

import org.json.simple.JSONObject;

public class Restaurant {

	/*
	 * Abstraction Function: all fields of this restaurant, which represent a
	 * restaurant's characteristics
	 * 
	 * Rep. Invariants: no fields are null
	 * 1<=stars<=5 
	 * 1<=price<=4 
	 * photo_url and url are URLs that link to websites for the restaurant 
	 * longitude and latitude are within UCB's range 
	 * review_count>=0 
	 * neighborhoods, state, city, full_address, schools match restaurant's real location 
	 * type.equals("restaurant")
	 */

	private boolean open;
	private String url;
	private double longitude;
	private List<String> neighborhoods;
	private String business_id;
	private String name;
	private List<String> categories;
	private String state;
	private String type;
	private double stars;
	private String city;
	private String full_address;
	private long review_count;
	private String photo_url;
	private List<String> schools;
	private double latitude;
	private long price;
	private String jsonString;

	public Restaurant(JSONObject restaurant) {
		this.open = (Boolean) restaurant.get("open");
		this.url = (String) restaurant.get("url");
		this.longitude = (Double) restaurant.get("longitude");
		this.neighborhoods = (List<String>) restaurant.get("neighborhoods");
		this.business_id = (String) restaurant.get("business_id");
		this.name = (String) restaurant.get("name");
		this.categories = (List<String>) restaurant.get("categories");
		this.state = (String) restaurant.get("state");
		this.type = (String) restaurant.get("type");
		this.stars = (Double) restaurant.get("stars");
		this.city = (String) restaurant.get("city");
		this.full_address = (String) restaurant.get("full_address");
		this.review_count = (long) restaurant.get("review_count");
		this.photo_url = (String) restaurant.get("photo_url");
		this.schools = (List<String>) restaurant.get("schools");
		this.latitude = (Double) restaurant.get("latitude");
		this.price = (long) restaurant.get("price");
		this.jsonString = restaurant.toString();
	}

	public boolean getOpen() {
		return open;
	}

	public String getUrl() {
		return url;
	}

	public double getLongitude() {
		return longitude;
	}

	public List<String> getNeighborhoods() {
		return Collections.unmodifiableList(neighborhoods);
	}

	public String getBusiness_id() {
		return business_id;
	}

	public String getName() {
		return name;
	}

	public List<String> getCategories() {
		return Collections.unmodifiableList(categories);
	}

	public String getState() {
		return state;
	}

	public String getType() {
		return type;
	}

	public double getStars() {
		return stars;
	}

	public String getCity() {
		return city;
	}

	public String getFull_address() {
		return full_address;
	}

	public long getReview_count() {
		return review_count;
	}

	public String getPhoto_url() {
		return photo_url;
	}

	public List<String> getSchools() {
		return Collections.unmodifiableList(schools);
	}

	public double getLatitude() {
		return latitude;
	}

	public long getPrice() {
		return price;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Restaurant) {
			Restaurant otherRes = (Restaurant) other;
			return (this.business_id.equals(otherRes.business_id));
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return business_id.hashCode();
	}
	
	@Override
	public String toString() {
		return jsonString;
	}

}
