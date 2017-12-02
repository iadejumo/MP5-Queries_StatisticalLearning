package ca.ece.ubc.cpen221.mp5.test;

import java.io.IOException;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import ca.ece.ubc.cpen221.mp5.Restaurant;
import ca.ece.ubc.cpen221.mp5.Review;
import ca.ece.ubc.cpen221.mp5.User;
import ca.ece.ubc.cpen221.mp5.YelpDB;

public class GeneralDatabaseTest {

	String userFile = "data\\users.json";
	String restaurantFile = "data\\restaurants.json";
	String reviewFile = "data\\reviews.json";

	@Test
	public void test1() throws ParseException, IOException {
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		Map<String,Restaurant> restaurants = yelpDB.getRestaurants();
		
		Restaurant r = restaurants.get("gclB3ED6uk6viWlolSb_uA");
		
		System.out.println(r.getCity());
		System.out.println(r.getBusiness_id());
		System.out.println(r.getFull_address());
		System.out.println(r.getLatitude());
		System.out.println(r.getLongitude());
		System.out.println(r.getName());
		System.out.println(r.getOpen());
		System.out.println(r.getPhoto_url());
		System.out.println(r.getPrice());
		System.out.println(r.getReview_count());
		System.out.println(r.getStars());
		System.out.println(r.getState());
		System.out.println(r.getType());
		System.out.println(r.getUrl());
		System.out.println(r.getCategories());
		System.out.println(r.getSchools());
		System.out.println(r.getNeighborhoods());
	}
	
	@Test
	public void test2() throws ParseException, IOException {
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		Map<String,Review> reviews = yelpDB.getReviews();
		Review r = null;
		for (String s: reviews.keySet()) {
			r = reviews.get(s);
			break;
		}
		
		System.out.println(r.getBusiness_id());
		System.out.println(r.getDate());
		System.out.println(r.getReview_id());
		System.out.println(r.getStars());
		System.out.println(r.getText());
		System.out.println(r.getType());
		System.out.println(r.getUser_id());
		System.out.println(r.getVotes());
	}
	
	@Test
	public void test3() throws ParseException, IOException {
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		Map<String, User> users = yelpDB.getUsers();
		User r = null;
		
		for (String s: users.keySet()) {
			r = users.get(s);
			break;
		}
		
		System.out.println(r.getName());
		System.out.println(r.getReview_count());
		System.out.println(r.getType());
		System.out.println(r.getUrl());
		System.out.println(r.getUser_id());
		System.out.println(r.getAverage_stars());
		System.out.println(r.getVotes());
	}
	
	
}
