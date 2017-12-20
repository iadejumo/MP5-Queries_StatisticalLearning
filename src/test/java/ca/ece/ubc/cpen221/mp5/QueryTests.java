package ca.ece.ubc.cpen221.mp5;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Test;

public class QueryTests {
	String userFile = "data/users.json";
	String restaurantFile = "data/restaurants.json";
	String reviewFile = "data/reviews.json";

	@Test
	public void test1() throws ParseException, IOException {
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		
		String s = "in(Telegraph Ave)";
		
		
	}

}
