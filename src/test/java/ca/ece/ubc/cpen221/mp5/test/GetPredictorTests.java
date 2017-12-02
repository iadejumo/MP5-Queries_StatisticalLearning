package ca.ece.ubc.cpen221.mp5.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.function.ToDoubleBiFunction;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import ca.ece.ubc.cpen221.mp5.MP5Db;
import ca.ece.ubc.cpen221.mp5.Restaurant;
import ca.ece.ubc.cpen221.mp5.YelpDB;

public class GetPredictorTests {
	
	@Test
	public void test0() throws ParseException, IOException {
		String userFile = "data\\users.json";
		String restaurantFile = "data\\restaurants.json";
		String reviewFile = "data\\reviews.json";
				
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
	}

	@Test
	public void test1() throws ParseException, IOException {
		String userFile = "data\\users.json";
		String restaurantFile = "data\\restaurants.json";
		String reviewFile = "data\\reviews.json";
				
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		
		String userID = "fL8ujZ89qTyhbjr1Qz5aSg";
		String restaurantID = "P2XKcDLVHUuOdGNBQtMFRQ";
		
		ToDoubleBiFunction<MP5Db<Restaurant>, String> predictor = yelpDB.getPredictorFunction(userID);
		double predicted_3 = predictor.applyAsDouble(yelpDB, restaurantID);
		
		String restaurantID2 = "6QZR4ToHKlse0yhqpU5ijg";
		double predicted_4 = predictor.applyAsDouble(yelpDB, restaurantID2);
		
		double expected_3 = 1.0;
		double expected_4 = 1;
		
		System.out.println("Price " + yelpDB.getRestaurants().get(restaurantID).getPrice());
		System.out.println(predicted_3);
		
		System.out.println("Price " + yelpDB.getRestaurants().get(restaurantID2).getPrice());
		System.out.println(predicted_4);

		assertTrue(Math.abs(expected_3 - predicted_3) < 0.001);
		assertTrue(Math.abs(expected_4 - predicted_4) < 0.001);
	}
	
	@Test
	public void test2() throws ParseException, IOException {
		String userFile = "data\\users.json";
		String restaurantFile = "data\\restaurants.json";
		String reviewFile = "data\\reviews.json";
				
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		
		String userID = "Rto4xWr5gXA2IbrfyAn-Xg";
		String restaurantID = "o0KC5k-7fXH8LHf75Icfuw";
		
		ToDoubleBiFunction<MP5Db<Restaurant>, String> predictor = yelpDB.getPredictorFunction(userID);
		double predicted = predictor.applyAsDouble(yelpDB, restaurantID);
		double expected = 2.718;
		
		System.out.println("Price " + yelpDB.getRestaurants().get(restaurantID).getPrice());
		System.out.println(predicted);

		assertTrue(Math.abs(expected - predicted) < 0.001);
	}
	
	@Test
	public void test3() throws ParseException, IOException {
		String userFile = "data\\users.json";
		String restaurantFile = "data\\restaurants.json";
		String reviewFile = "data\\reviews.json";
				
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		
		String userID = "FjNgN6Dk9fh4NatwthoFgA";
		String restaurantID = "6QZR4ToHKlse0yhqpU5ijg";
		
		ToDoubleBiFunction<MP5Db<Restaurant>, String> predictor = yelpDB.getPredictorFunction(userID);
		double predicted = predictor.applyAsDouble(yelpDB, restaurantID);
		double expected = 5.0;
		
		System.out.println("Price " + yelpDB.getRestaurants().get(restaurantID).getPrice());
		System.out.println(predicted);

		assertTrue(Math.abs(expected - predicted) < 0.001);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test6() throws ParseException, IOException {
		String userFile = "data\\users.json";
		String restaurantFile = "data\\restaurants.json";
		String reviewFile = "data\\reviews.json";
				
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		
		String userID = "a_-YKfqF2gCghzblWciBcA";
		String restaurantID = "P2XKcDLVHUuOdGNBQtMFRQ";
		
		ToDoubleBiFunction<MP5Db<Restaurant>, String> predictor = yelpDB.getPredictorFunction(userID);

	}

}
