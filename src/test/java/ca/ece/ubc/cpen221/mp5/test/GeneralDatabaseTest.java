package ca.ece.ubc.cpen221.mp5.test;

import static org.junit.Assert.*;

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
		
		assertTrue(r.getCity().equals("Berkeley"));
		assertTrue(r.getBusiness_id().equals("gclB3ED6uk6viWlolSb_uA"));
		assertTrue(r.getFull_address().length()==(48));
		assertTrue(Math.abs(37.867417-r.getLatitude())<0.1);
		assertTrue(Math.abs(-122.260408-r.getLongitude())<0.1);
		assertTrue(r.getName().equals("Cafe 3"));
		assertTrue(r.getOpen()==true);
		assertTrue(r.getPhoto_url().equals("http://s3-media1.ak.yelpcdn.com/bphoto/AaHq1UzXiT6zDBUYrJ2NKA/ms.jpg"));
		assertTrue(r.getPrice()==1);
		assertTrue(r.getReview_count()==9);
		assertTrue(Math.abs(r.getStars()-2)<0.1);
		assertTrue(r.getState().equals("CA"));
		assertTrue(r.getType().equals("business"));
		assertTrue(r.getCategories().size()==2);
		assertTrue(r.getSchools().size() == 1);
		assertTrue(r.getNeighborhoods().size()==2);
		assertTrue(r.getUrl().length()==39);
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
		
		assertTrue(r.getBusiness_id().equals("1CBs84C-a-cuA3vncXVSAw"));
		assertTrue(r.getDate().equals("2009-02-24"));
		assertTrue(r.getReview_id().equals("bWgTFMpd-uZ9z-4pp3mjxw"));
		assertTrue(r.getStars()==3);
		assertTrue(r.getText().length()==575);
		assertTrue(r.getType().equals("review"));
		assertTrue(r.getUser_id().equals("m7iiJlloCRfWaCPwQwTmpg"));
		assertTrue(r.getVotes().size()==3);
		
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
		
		assertTrue(r.getName().equals("Karen D."));
		assertTrue(r.getReview_count()==14);
		assertTrue(r.getType().equals("user"));
		assertTrue(r.getUrl().equals("http://www.yelp.com/user_details?userid=VfqkoiMTtw3_BVk9wAB_YA"));
		assertTrue(r.getUser_id().equals("VfqkoiMTtw3_BVk9wAB_YA"));
		assertTrue(r.getAverage_stars()<4.5);
		assertTrue(r.getVotes().size()==3);
	}
	
	
}
