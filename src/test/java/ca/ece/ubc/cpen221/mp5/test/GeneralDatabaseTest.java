package ca.ece.ubc.cpen221.mp5.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import ca.ece.ubc.cpen221.mp5.Restaurant;
import ca.ece.ubc.cpen221.mp5.Review;
import ca.ece.ubc.cpen221.mp5.User;
import ca.ece.ubc.cpen221.mp5.YelpDB;

public class GeneralDatabaseTest {

	String userFile = "data/users.json";
	String restaurantFile = "data/restaurants.json";
	String reviewFile = "data/reviews.json";

	@Test
	public void test1() throws ParseException, IOException {
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		Map<String, Restaurant> restaurants = yelpDB.getRestaurants();

		Restaurant r = restaurants.get("gclB3ED6uk6viWlolSb_uA");
		assertTrue(r.getCity().equals("Berkeley"));
		assertTrue(r.getBusiness_id().equals("gclB3ED6uk6viWlolSb_uA"));
		assertTrue(r.getFull_address().length() == (48));
		assertTrue(Math.abs(37.867417 - r.getLatitude()) < 0.1);
		assertTrue(Math.abs(-122.260408 - r.getLongitude()) < 0.1);
		assertTrue(r.getName().equals("Cafe 3"));
		assertTrue(r.getOpen() == true);
		assertTrue(r.getPhoto_url().equals("http://s3-media1.ak.yelpcdn.com/bphoto/AaHq1UzXiT6zDBUYrJ2NKA/ms.jpg"));
		assertTrue(r.getPrice() == 1);
		assertTrue(r.getReview_count() == 9);
		assertTrue(Math.abs(r.getStars() - 2) < 0.1);
		assertTrue(r.getState().equals("CA"));
		assertTrue(r.getType().equals("business"));
		assertTrue(r.getCategories().size() == 2);
		assertTrue(r.getSchools().size() == 1);
		assertTrue(r.getNeighborhoods().size() == 2);
		assertTrue(r.getUrl().length() == 39);
	}

	@Test
	public void test2() throws ParseException, IOException {
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		Map<String, Review> reviews = yelpDB.getReviews();
		Review r = null;
		for (String s : reviews.keySet()) {
			r = reviews.get(s);
			break;
		}

		assertTrue(r.getBusiness_id().equals("1CBs84C-a-cuA3vncXVSAw"));
		assertTrue(r.getDate().equals("2009-02-24"));
		assertTrue(r.getReview_id().equals("bWgTFMpd-uZ9z-4pp3mjxw"));
		assertTrue(r.getStars() == 3);
		assertTrue(r.getText().length() == 575);
		assertTrue(r.getType().equals("review"));
		assertTrue(r.getUser_id().equals("m7iiJlloCRfWaCPwQwTmpg"));
		assertTrue(r.getVotes().size() == 3);

	}

	@Test
	public void test3() throws ParseException, IOException {
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		Map<String, User> users = yelpDB.getUsers();
		User r = null;

		for (String s : users.keySet()) {
			r = users.get(s);
			break;
		}

		assertTrue(r.getName().equals("Karen D."));
		assertTrue(r.getReview_count() == 14);
		assertTrue(r.getType().equals("user"));
		assertTrue(r.getUrl().equals("http://www.yelp.com/user_details?userid=VfqkoiMTtw3_BVk9wAB_YA"));
		assertTrue(r.getUser_id().equals("VfqkoiMTtw3_BVk9wAB_YA"));
		assertTrue(r.getAverage_stars() < 4.5);
		assertTrue(r.getVotes().size() == 3);
	}

	@Test
	public void test4() throws ParseException, IOException {
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		Map<String, User> usersInitial = yelpDB.getUsers();
		User newUser = null;
		String userName = "Sathish G.";

		boolean found1 = false;

		for (String s : usersInitial.keySet()) {
			if (usersInitial.get(s).getName().equals(userName)) {
				found1 = true;
			}
		}

		assertFalse(found1);

		//yelpDB.addUser(userName);

		Map<String, User> usersAfter = yelpDB.getUsers();
		boolean found2 = false;

		for (User u : usersAfter.values()) {
			if (u.getName().equals(userName)) {
				found2 = true;
				newUser = u;
			}
		}

		assertTrue(found2);
	}

	@Test
	public void test5() throws ParseException, IOException {
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);

		Restaurant res1 = yelpDB.getRestaurants().get("QQIjsdcokFermi2ugoD6ow");
		Restaurant res2 = yelpDB.getRestaurants().get("plRUSuB_uY_dEgcMqeZMYA");
		Restaurant res3 = res1;

		Review rev1 = yelpDB.getReviews().get("9-OuiSVIYEgiDLpDIYlkjw");
		Review rev2 = yelpDB.getReviews().get("9rST92s00AoVF2rws1haYg");
		Review rev3 = rev1;

		User user1 = yelpDB.getUsers().get("cywLfetwd4k7gSu5ewNuhw");
		User user2 = yelpDB.getUsers().get("dLob_b2vhg4_V95-VMVdLw");
		User user3 = user1;

		assertFalse(res1.equals(res2));
		assertTrue(res1.hashCode() != res2.hashCode());
		assertTrue(res1.equals(res3));
		assertTrue(res1.hashCode() == res3.hashCode());

		assertFalse(rev1.equals(rev2));
		assertTrue(rev1.hashCode() != rev2.hashCode());
		assertTrue(rev1.equals(rev3));
		assertTrue(rev1.hashCode() == rev3.hashCode());

		assertFalse(user1.equals(user2));
		assertTrue(user1.hashCode() != user2.hashCode());
		assertTrue(user1.equals(user3));
		assertTrue(user1.hashCode() == user3.hashCode());

		assertFalse(res1.equals(rev1));
		assertFalse(rev1.equals(user1));
		assertFalse(user1.equals(res1));
	}

	@Test
	public void test6() throws ParseException, IOException {
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		String jsonUserString = "{\"url\": \"http://www.yelp.com/user_details?userid=_NH7Cpq3qZkByP5xR4gXog\", \"votes\": {\"funny\": 35, \"useful\": 21, \"cool\": 14}, \"review_count\": 29, \"type\": \"user\", \"user_id\": \"_NH7Cpq3qZkByP5xR4gXog\", \"name\": \"Chris M.\", \"average_stars\": 3.89655172413793}";
		String jsonReviewString = "{\"type\": \"review\", \"business_id\": \"1CBs84C-a-cuA3vncXVSAw\", \"votes\": {\"cool\": 0, \"useful\": 0, \"funny\": 0}, \"review_id\": \"0a-pCW4guXIlWNpVeBHChg\", \"text\": \"The pizza is terrible, but if you need a place to watch a game or just down some pitchers, this place works.\n\nOh, and the pasta is even worse than the pizza.\", \"stars\": 2, \"user_id\": \"90wm_01FAIqhcgV_mPON9Q\", \"date\": \"2006-07-26\"}";
		String jsonRestaurantString = "{\"open\": true, \"url\": \"http://www.yelp.com/biz/cafe-3-berkeley\", \"longitude\": -122.260408, \"neighborhoods\": [\"Telegraph Ave\", \"UC Campus Area\"], \"business_id\": \"gclB3ED6uk6viWlolSb_uA\", \"name\": \"Cafe 3\", \"categories\": [\"Cafes\", \"Restaurants\"], \"state\": \"CA\", \"type\": \"business\", \"stars\": 2.0, \"city\": \"Berkeley\", \"full_address\": \"2400 Durant Ave\nTelegraph Ave\nBerkeley, CA 94701\", \"review_count\": 9, \"photo_url\": \"http://s3-media1.ak.yelpcdn.com/bphoto/AaHq1UzXiT6zDBUYrJ2NKA/ms.jpg\", \"schools\": [\"University of California at Berkeley\"], \"latitude\": 37.867417, \"price\": 1}";
		
		Map<String, User> users = yelpDB.getUsers();
		Map<String, Review> reviews = yelpDB.getReviews();
		Map<String, Restaurant> restaurants = yelpDB.getRestaurants();
		
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(users.get("_NH7Cpq3qZkByP5xR4gXog").toString());
		User u = new User(json);
		assertTrue(users.get("_NH7Cpq3qZkByP5xR4gXog").equals(u));
		
		json = (JSONObject) parser.parse(reviews.get("0a-pCW4guXIlWNpVeBHChg").toString());
		Review r = new Review (json);
		assertTrue(reviews.get("0a-pCW4guXIlWNpVeBHChg").equals(r));
		
		
		json = (JSONObject) parser.parse(restaurants.get("gclB3ED6uk6viWlolSb_uA").toString());
		Restaurant res = new Restaurant (json);
		assertTrue(restaurants.get("gclB3ED6uk6viWlolSb_uA").equals(res));

	}
	
	@Test
	public void test7() throws ParseException, IOException {
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		// We are yet to add a addReview method, so this is just to test that the update
		// review method (and sub methods) are functioning as expected
	
		Map<String, User> users = yelpDB.getUsers();
		Map<String, Restaurant> restaurants = yelpDB.getRestaurants();
		
		String business_id = "gclB3ED6uk6viWlolSb_uA";
		String user_id = "_NH7Cpq3qZkByP5xR4gXog";
		
		double businessInitialAverageRating = restaurants.get(business_id).getStars();
		long businessInitialRatingCount = restaurants.get(business_id).getReview_count();
		
		double userInitialAverageRating = users.get(user_id).getAverage_stars();
		long userInitialRatingCount = users.get(user_id).getReview_count();
		
		System.out.println(restaurants.get(business_id).toString());
		//yelpDB.updateRatingsAndRatingsCount(business_id,user_id , 5);
		
		Map<String, User> usersAfter = yelpDB.getUsers();
		Map<String, Restaurant> restaurantsAfter = yelpDB.getRestaurants();
		
		double businessAfterAverageRating = restaurantsAfter.get(business_id).getStars();
		long businessAfterRatingCount = restaurantsAfter.get(business_id).getReview_count();
		
		double userAfterAverageRating = usersAfter.get(user_id).getAverage_stars();
		long userAfterRatingCount = usersAfter.get(user_id).getReview_count();
		
		assertEquals(businessInitialRatingCount + 1, businessAfterRatingCount);
		assertEquals(userInitialRatingCount + 1, userAfterRatingCount);
		
		assertTrue( businessInitialAverageRating < businessAfterAverageRating);
		assertTrue(userInitialAverageRating < userAfterAverageRating);
		
	}
	
	

}
