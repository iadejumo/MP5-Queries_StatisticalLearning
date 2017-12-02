package ca.ece.ubc.cpen221.mp5;

import java.util.Collections;
import java.util.List;

import org.json.simple.JSONObject;

public class Restaurant {

	/*
	 * Abstraction Function: all fields of this restaurant, which represent a
	 * restaurant's characteristics
	 * 
	 * Rep. Invariants: no fields are null 1<=stars<=5 1<=price<=4 photo_url and url
	 * are URLs that link to websites for the restaurant longitude and latitude are
	 * within UCB's range review_count>=0 neighborhoods, state, city, full_address,
	 * schools match restaurant's real location type.equals("restaurant")
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

	/**
	 * Creates a Restaurant object
	 * 
	 * @param restaurant
	 *            JSONObject with fields:
	 * 
	 *            open -> boolean
	 * 
	 *            url -> String
	 * 
	 *            longitude -> double
	 * 
	 *            neighborhoods -> List<String>
	 * 
	 *            business_id -> String
	 * 
	 *            name -> String
	 * 
	 *            categories -> List<String>
	 * 
	 *            state -> String
	 * 
	 *            type -> String
	 * 
	 *            stars -> double
	 * 
	 *            city -> String
	 * 
	 *            full_address -> String
	 * 
	 *            review_count -> long
	 * 
	 *            photo_url -> String schools -> List<String>
	 * 
	 *            latitude -> double
	 * 
	 *            price -> long
	 */
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
	}

	/**
	 * checks if the Restaurant is open
	 * 
	 * @return boolean - returns true if the Restaurant is open, else false
	 */
	public boolean getOpen() {
		return open;
	}

	/**
	 * gets the URL of the Restaurant website
	 * 
	 * @return String - URL of the Restaurant website
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * gets the Restaurant's longitude
	 * 
	 * @return double - returns the Restaurant's longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * returns the neighborhoods of the Restaurant
	 * 
	 * @return List<String> - returns List<String> with each string being a
	 *         neighborhood of the Restaurant
	 */
	public List<String> getNeighborhoods() {
		return Collections.unmodifiableList(neighborhoods);
	}

	/**
	 * returns the Restaurant's business_id
	 * 
	 * @return String - the Restaurant's business_id
	 */
	public String getBusiness_id() {
		return business_id;
	}

	/**
	 * returns the Restaurant's name
	 * 
	 * @return String - returns the Restaurant name
	 */
	public String getName() {
		return name;
	}

	/**
	 * returns the Restaurant's categories
	 * 
	 * @return List<String> - returns List<String> with each String being a category
	 *         of the Restaurant
	 */
	public List<String> getCategories() {
		return Collections.unmodifiableList(categories);
	}

	/**
	 * returns the State that the Restaurant is in
	 * 
	 * @return String - returns the State that the Restaurant is in
	 */
	public String getState() {
		return state;
	}

	/**
	 * returns the Restaurant Type
	 * 
	 * @return String - the Restaurant's type
	 */
	public String getType() {
		return type;
	}

	/**
	 * returns the average number of stars in the rating of the Restaurant
	 * 
	 * @return double - average number of stars in the rating of the Restaurant
	 */
	public double getStars() {
		return stars;
	}

	/**
	 * returns the city that the Restaurant is in
	 * 
	 * @return the city that the Restaurant is in
	 */
	public String getCity() {
		return city;
	}

	/**
	 * returns the full address of the Restaurant
	 * 
	 * @return String - the full address of the Restaurant
	 */
	public String getFull_address() {
		return full_address;
	}

	/**
	 * returns number of reviews that the Restaurant has
	 * 
	 * @return long - the number of reviews that the Restaurant has
	 */
	public long getReview_count() {
		return review_count;
	}

	/**
	 * returns the URL of the website with the Restaurant photo
	 * 
	 * @return String - the URL of the website with the Restaurant photo
	 */
	public String getPhoto_url() {
		return photo_url;
	}

	/**
	 * gets the schools near the Restaurant
	 * 
	 * @return List<String> - returns List<String> with each String being a school
	 *         near the Restaurant
	 */
	public List<String> getSchools() {
		return Collections.unmodifiableList(schools);
	}

	/**
	 * returns latitude of the Restaurant
	 * 
	 * @return double - returns the latitude of the Restaurant
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * returns price rating of the Restaurant
	 * 
	 * @return long - returns the price rating of the Restaurant
	 */
	public long getPrice() {
		return price;
	}

}
