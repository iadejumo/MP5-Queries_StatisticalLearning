package ca.ece.ubc.cpen221.mp5.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import ca.ece.ubc.cpen221.mp5.Restaurant;
import ca.ece.ubc.cpen221.mp5.YelpDB;

public class QueryTests {
	String userFile = "data/users.json";
	String restaurantFile = "data/restaurants.json";
	String reviewFile = "data/reviews.json";

	@Test
	public void test1() throws ParseException, IOException {
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		
		String query = "in(Telegraph Ave)";
		
		Set<String> matches = yelpDB.getMatches(query);
		
		assertEquals(76, matches.size());
		
	}
	
	@Test
	public void test2() throws ParseException, IOException {
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		
		String query = "in(UC Campus Area)";
		
		Set<String> matches = yelpDB.getMatches(query);
		
		assertEquals(135, matches.size());	
	}
	
	@Test (expected = Exception.class)
	public void test3() throws ParseException, IOException {
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		
		String query = "in(Telegraph Ave) && in(Downtown Berkeley)";
		
		Set<String> matches = yelpDB.getMatches(query);
		
	}
	/*
	@Test
	public void test4() throws ParseException, IOException {
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		
		String query = "category(American (Traditional))";
		
		Set<String> matches = yelpDB.getMatches(query);
		
		assertEquals(8, matches.size());
		
	}
	*/
	@Test
	public void test5() throws ParseException, IOException {
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		
		String query = "category(Persian/Iranian)";
		
		Set<String> matches = yelpDB.getMatches(query);
		
		assertEquals(2, matches.size());	
	}
	
	@Test
	public void test6() throws ParseException, IOException {
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		
		String query = "category(Coffee & Tea)";
		
		Set<String> matches = yelpDB.getMatches(query);
		
		assertEquals(15, matches.size());
		
	}
	
	
	@Test (expected = Exception.class)
	public void test7() throws ParseException, IOException {
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		
		String query = "category()";
		
		Set<String> matches = yelpDB.getMatches(query);
		
		assertEquals(1, matches.size());
		
	}
		
	@Test
	public void test8() throws ParseException, IOException {
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		String restuarant1 = yelpDB.getRestaurants().get("TUIDRJ_rUkdmYPSRAAEsPg").getName();
		System.out.println(restuarant1.equals("I.B.'s Hoagies"));
		
		String query = "name(I.B.'s Hoagies) || name(Steve's Bar-B-Que) || name(Pho K & K)";
		
		Set<String> matches = yelpDB.getMatches(query);
		

		System.out.println(matches);
		assertEquals(3, matches.size());	
	}
	
	/*
	@Test 
	public void test9() throws ParseException, IOException {
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		Restaurant restuarant1 = yelpDB.getRestaurants().get("LMkjYjW17gyckgGVxEmVNw");
		Restaurant restuarant2 = yelpDB.getRestaurants().get("G3d-xJF_Rt-P_za2eZ1q-Q");
		Restaurant restuarant3 = yelpDB.getRestaurants().get("8PE1KtG_ZMxcgqCseHhmLA");
		
		List<Restaurant> matchesExpected = new ArrayList<Restaurant>();
		matchesExpected.add(restuarant1);
		matchesExpected.add(restuarant2);
		matchesExpected.add(restuarant3);
		
		String query = "name(Bongo Burger)";
		
		List<Restaurant> matchesGenerated = new ArrayList<Restaurant>();
		Set<String> matches = yelpDB.getMatches(query);
		
		for (String restaurant: matches) {
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(restaurant);
			matchesGenerated.add(new Restaurant(json));
		}
		
		assertEquals(3, matches.size());
		
		int check = 0;
		for (Restaurant rE: matchesExpected) {
			for (Restaurant rG: matchesGenerated) {
				if( rE.equals(rG)) {
					check++;
				}
			}
		}
		
		assertEquals(3, check);
	}
	*/
	
	@Test (expected = Exception.class)
	public void test11() throws ParseException, IOException {
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		
		String query = "price > 0";
		
		Set<String> matches = yelpDB.getMatches(query);		
	}
	
	@Test
	public void test12() throws ParseException, IOException {
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		
		String query = "price <= 1";
		
		Set<String> matches = yelpDB.getMatches(query);
		
		assertEquals(54, matches.size());	
	}
	
	@Test 
	public void test13() throws ParseException, IOException {
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		
		String query = "price = 3";
		
		Set<String> matches = yelpDB.getMatches(query);
		
		assertEquals(11, matches.size());
		
	}
	
	@Test
	public void test14() throws ParseException, IOException {
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		
		String query = "price >= 3";
		
		Set<String> matches = yelpDB.getMatches(query);
		
		assertEquals(20, matches.size());
		
	}
	
	@Test
	public void test15() throws ParseException, IOException {
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		
		String query = "price > 3";
		
		Set<String> matches = yelpDB.getMatches(query);
		
		assertEquals(9, matches.size());	
	}
	
	@Test (expected = Exception.class)
	public void test16() throws ParseException, IOException {
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		
		String query = "rating < 6";
		
		Set<String> matches = yelpDB.getMatches(query);		
	}
	
	@Test
	public void test17() throws ParseException, IOException {
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		
		String query = "rating <= 5";
		
		Set<String> matches = yelpDB.getMatches(query);
		
		assertEquals(135, matches.size());	
	}
	
	@Test 
	public void test18() throws ParseException, IOException {
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		
		String query = "rating = 3";
		
		Set<String> matches = yelpDB.getMatches(query);
		
		assertEquals(30, matches.size());
		
	}
	
	@Test
	public void test19() throws ParseException, IOException {
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		
		String query = "rating >= 4";
		
		Set<String> matches = yelpDB.getMatches(query);
		
		assertEquals(39, matches.size());
		
	}
	
	@Test
	public void test20() throws ParseException, IOException {
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		
		String query = "rating > 4";
		
		Set<String> matches = yelpDB.getMatches(query);
		
		assertEquals(7, matches.size());	
	}

	
	
	

}
