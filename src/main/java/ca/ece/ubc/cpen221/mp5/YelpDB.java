package ca.ece.ubc.cpen221.mp5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.HashSet;
import java.util.Iterator;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.ToDoubleBiFunction;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonBuilderFactory;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class YelpDB implements MP5Db<Restaurant> {

	/*
	 * Abstraction function: restaurants x reviews x users
	 * 
	 * Representation Invariants: all Restaurants in restaurants have different
	 * business_id's
	 * 
	 * all Users in users have different user_id's
	 * 
	 * all Reviews in reviews have different review_id's
	 * 
	 * all keys in userToReview are user_id's that map to a list of all review_id's
	 * that have the same user_id
	 * 
	 * all keys in userToRestaurant are user_id's that map to a list of all
	 * business_id's of restaurants that these users have reviewed
	 * 
	 * all keys in restaurantToReview are business_id's that map to a list of all
	 * review_id's that have the business_id's
	 * 
	 * all of the Strings in userToReview/restaurantToReview/userToRestaurant are
	 * business_ids/review_ids/user_ids which leads to
	 * 
	 * restaurantToReview.size() == restaurants.size()
	 * 
	 * userToReview.size() == users.size() == userToRestaurant.size()
	 * 
	 * Note: review.size()/review_count/votes/average_stars/stars do not have to sum
	 * up in any way, as reviews and votes could be done to non-restaurant
	 * reviewable objects
	 * 
	 * 
	 */
	private Map<String, Restaurant> restaurants;
	private Map<String, Review> reviews;
	private Map<String, User> users;

	private static final double WEIGHT = 2.0;

	private Map<String, List<String>> userToReview;
	private Map<String, List<String>> restaurantToReview;
	private Map<String, List<String>> userToRestaurant;

	/**
	 * Initializes and constructs the database. And establishes the relationships
	 * between entries in the database
	 * 
	 * @param restaurantFilename
	 *            the location and filename of the restaurant file in json format
	 * @param reviewFilename
	 *            the location and filename of the review file in json format
	 * @param userFilename
	 *            the location and filename of the user file in json format
	 * @throws ParseException
	 *             if an error has been reached unexpectedly while parsing.
	 * @throws IOException
	 *             if the file could not be found or opened
	 */
	public YelpDB(String restaurantFilename, String reviewFilename, String userFilename)
			throws ParseException, IOException {
		restaurants = new HashMap<String, Restaurant>();
		reviews = new HashMap<String, Review>();
		users = new HashMap<String, User>();

		createRestaurantDB(restaurantFilename);
		createReviewDB(reviewFilename);
		createUserDB(userFilename);

		establishRelationships();
	}

	/**
	 * Creates and initializes the restaurant database, and entries.
	 * 
	 * @param restaurantFilename
	 *            the location and filename of the restaurant file in json format
	 * @throws ParseException
	 *             if an error has been reached unexpectedly while parsing.
	 * @throws IOException
	 *             if the file could not be found or opened
	 */
	private void createRestaurantDB(String restaurantFilename) throws ParseException, IOException {
		BufferedReader restaurantBR = null;
		JSONParser parser = new JSONParser();

		String sCurrentLine;

		restaurantBR = new BufferedReader(new FileReader(restaurantFilename));

		while ((sCurrentLine = restaurantBR.readLine()) != null) {

			Object obj;
			obj = parser.parse(sCurrentLine);
			JSONObject jsonObject = (JSONObject) obj;

			Restaurant r = new Restaurant(jsonObject);
			restaurants.put(r.getBusiness_id(), r);
		}

		restaurantBR.close();

	}

	/**
	 * Creates and initializes the review database, and entries.
	 * 
	 * @param reviewFilename
	 *            the location and filename of the review file in json format
	 * @throws IOException
	 *             if an error has been reached unexpectedly while parsing.
	 * @throws ParseException
	 *             if the file could not be found or opened
	 */
	private void createReviewDB(String reviewFilename) throws IOException, ParseException {
		BufferedReader reviewBR = null;
		JSONParser parser = new JSONParser();

		String sCurrentLine;

		reviewBR = new BufferedReader(new FileReader(reviewFilename));

		while ((sCurrentLine = reviewBR.readLine()) != null) {

			Object obj;

			obj = parser.parse(sCurrentLine);
			JSONObject jsonObject = (JSONObject) obj;

			Review r = new Review(jsonObject);
			reviews.put(r.getReview_id(), r);

		}

		reviewBR.close();

	}

	/**
	 * Creates and initializes the user database, and entries.
	 * 
	 * @param userFilename
	 *            the location and filename of the user file in json format
	 * @throws IOException
	 *             if an error has been reached unexpectedly while parsing.
	 * @throws ParseException
	 *             if the file could not be found or opened
	 */
	private void createUserDB(String userFilename) throws IOException, ParseException {
		BufferedReader userBR = null;
		JSONParser parser = new JSONParser();

		String sCurrentLine;

		userBR = new BufferedReader(new FileReader(userFilename));

		while ((sCurrentLine = userBR.readLine()) != null) {

			Object obj;
			obj = parser.parse(sCurrentLine);
			JSONObject jsonObject = (JSONObject) obj;

			User u = new User(jsonObject);
			users.put(u.getUser_id(), u);

		}

		userBR.close();
	}

	/**
	 * Establishes relationships between the different entries in the database by
	 * initializing and storing a map that links the different key field(unique) in
	 * the different databases. i.e; user_id -> review_id, business_id -> review_id,
	 * user_id -> business_id
	 * 
	 */
	private void establishRelationships() {
		userToReview = new HashMap<String, List<String>>();
		restaurantToReview = new HashMap<String, List<String>>();
		userToRestaurant = new HashMap<String, List<String>>();

		// Establishes user to review relationship
		for (String user : users.keySet()) {
			userToReview.put(user, new ArrayList<String>());
		}

		for (Review review : reviews.values()) {
			userToReview.get(review.getUser_id()).add(review.getReview_id());
		}

		// Establish restaurants to review relationship
		for (String restaurant : restaurants.keySet()) {
			restaurantToReview.put(restaurant, new ArrayList<String>());
		}

		for (Review review : reviews.values()) {
			restaurantToReview.get(review.getBusiness_id()).add(review.getReview_id());
		}

		// Establish user to restaurant relationship
		for (String user : users.keySet()) {
			userToRestaurant.put(user, new ArrayList<String>());
		}

		for (Review review : reviews.values()) {
			userToRestaurant.get(review.getUser_id()).add(review.getBusiness_id());
		}

	}

	/**
	 * Returns the map containing an unmodifiable map and business_ids mapped to
	 * Restaurant objects
	 * 
	 * @return the map containing an unmodifiable map and business_ids mapped to
	 *         Restaurant objects
	 */
	public Map<String, Restaurant> getRestaurants() {
		return new HashMap<String, Restaurant>(restaurants);
	}

	/**
	 * Returns the map containing an unmodifiable map and review_ids mapped to
	 * Review objects
	 * 
	 * @return the map containing an unmodifiable map and review_ids mapped to
	 *         Review objects
	 */
	public Map<String, Review> getReviews() {
		return new HashMap<String, Review>(reviews);
	}

	/**
	 * Returns the map containing an unmodifiable map and user_ids mapped to User
	 * objects
	 * 
	 * @return the map containing an unmodifiable map and user_ids mapped to User
	 *         objects
	 */
	public Map<String, User> getUsers() {
		return new HashMap<String, User>(users);
	}

	// Uncompleted (Part 5)
	@Override
	public Set getMatches(String queryString) {
		// TODO Auto-generated method stub
		return null;
	}

	// Uncompleted (Part 5)
	private void parseInput(String input) {
		CharStream stream = new ANTLRInputStream(input);

		QueryGrammarLexer lexer = new QueryGrammarLexer(stream);
		TokenStream tokens = new CommonTokenStream(lexer);

		QueryGrammarParser parser = new QueryGrammarParser(tokens);

		ParseTree tree = parser.orExpr();

		System.err.println(tree.toStringTree(parser));
		// ((RuleContext) tree).inspect((Parser)parser);
		ParseTreeWalker walker = new ParseTreeWalker();
		QueryGrammarListener listener = new ExpressionEvalution();
		walker.walk(listener, tree);
	}

	/**
	 * Groups the restaurants into k clusters, such that no point is closer to the
	 * centroid of its assigned cluster than any other cluster. This finds k
	 * centroids in the restaurant dataset. It then returns a String in JsonFormat
	 * showing the cluster location of each restaurant
	 *
	 * @param k
	 *            the number of clusters to be for kMeansCluster k>0 and
	 *            k<restaurants.size()
	 * @return String in JsonFormat that shows restaurant data and which cluster it
	 *         is in
	 */
	@Override
	public String kMeansClusters_json(int k) {
		List<Set<Restaurant>> clusterList = findClusters(k);
		String jsonFormat = convertListToJsonFormat(clusterList);
		return jsonFormat;
	}

	// converts List<Set<Restaurant>> to a String in Json Format
	private String convertListToJsonFormat(List<Set<Restaurant>> clusterList) {

		JSONArray jArray = new JSONArray();
		// for each Restaurant in each cluster, create a JSONObject with the necessary
		// fields, then add it to jArray
		for (int clusterNum = 0; clusterNum < clusterList.size(); clusterNum++) {
			for (Restaurant r : clusterList.get(clusterNum)) {
				JSONObject obj = new JSONObject();
				obj.put("x", r.getLatitude());
				obj.put("y", r.getLongitude());
				obj.put("name", r.getName());
				obj.put("cluster", clusterNum);
				obj.put("weight", WEIGHT);
				jArray.add(obj);
			}
		}
		return jArray.toJSONString();
	}

	// finds k clusters of restaurants
	private List<Set<Restaurant>> findClusters(int k) {

		// map connecting a centroid point -> a set of restaurants nearest to it
		Map<Point, Set<Restaurant>> clusterMap;

		// contains the first set of random Centroid points
		Map<Point, Point> updatedCentroids = firstCentroids(k);

		// continuously find closest restaurants to the centroids, then update the
		// Centroids to the average of the cluster
		// stop when the update to the new centroids doesn't change any of the centroids

		do {
			clusterMap = updateClusterMap(updatedCentroids);
			findClosestRestaurants(clusterMap);
			updatedCentroids = findNewCentroids(clusterMap);
			// } while (newCentroidsFound(updatedCentroids) );
		} while (newCentroidsFound(updatedCentroids) || emptyClusterIn(clusterMap));

		// convert the clusterMap to a clusterList
		List<Set<Restaurant>> clusterList = new ArrayList<Set<Restaurant>>();
		for (Point p : clusterMap.keySet())
			clusterList.add(clusterMap.get(p));
		return clusterList;
	}

	// generates first Centroid points from k restaurants
	private Map<Point, Point> firstCentroids(int k) {
		Map<Point, Point> updatedCentroids = new HashMap<Point, Point>();

		// create k Points at restaurants
		for (int i = 0; i < k; i++)
			updatedCentroids.put(new Point(i, i), getRestaurantLoc());

		return updatedCentroids;
	}

	// returns a new Map<Point,Set<Restaurant>> that has the Point keys as the
	// updatedCentroid points -> new HashSet<Restaurant>
	private Map<Point, Set<Restaurant>> updateClusterMap(Map<Point, Point> updatedCentroids) {
		Map<Point, Set<Restaurant>> newClusterMap = new HashMap<Point, Set<Restaurant>>();

		for (Point oldCentroid : updatedCentroids.keySet())
			newClusterMap.put(updatedCentroids.get(oldCentroid), new HashSet<Restaurant>());

		return newClusterMap;
	}

	private boolean emptyClusterIn(Map<Point, Set<Restaurant>> clusterMap) {
		// only needed for very rare case
		for (Point centroid : clusterMap.keySet()) {
			if (clusterMap.get(centroid).isEmpty()) {
				return true;
			}
		}
		return false;
	}

	// returns true if at least one centroid point has changed
	// returns false if no centroid points are changed
	private boolean newCentroidsFound(Map<Point, Point> newCentroids) {
		for (Point oldCentroid : newCentroids.keySet()) {
			if (!oldCentroid.aboutEqual(newCentroids.get(oldCentroid))) {
				return true;
			}
		}
		return false;
	}

	// updates centroid point locations to their new average locations
	private Map<Point, Point> findNewCentroids(Map<Point, Set<Restaurant>> clusterMap) {
		// maps the old centroid point -> the new centroid point
		Map<Point, Point> newCentroids = new HashMap<Point, Point>();

		// for each oldCentroid Point, find the average latitude and average longitude
		// of its nearest restaurants
		// use this to find a newCentroid Point
		for (Point centroidLoc : clusterMap.keySet()) {
			int size = clusterMap.get(centroidLoc).size();
			if (size != 0) {
				double averageLat = 0;
				double averageLong = 0;

				// calculate the averageLatitude and averageLongitude and then set newCentroid
				// Point to that location
				for (Restaurant r : clusterMap.get(centroidLoc)) {
					averageLat += r.getLatitude();
					averageLong += r.getLongitude();
				}

				averageLat = averageLat / size;
				averageLong = averageLong / size;
				newCentroids.put(centroidLoc, new Point(averageLat, averageLong));
			}

			// else put centroid at another restaurant location
			else
				newCentroids.put(centroidLoc, getRestaurantLoc());
		}
		return newCentroids;
	}

	/*
	 * private Point getRestaurantLoc() { Restaurant r; Point p = null; int count =
	 * 0; int aim = (int) (Math.random() * restaurants.size());
	 * 
	 * for (String s : restaurants.keySet()) { if (count == aim) { r =
	 * restaurants.get(s); p = new Point(r.getLatitude(), r.getLongitude()); break;
	 * } count++; } return p; }
	 */

	private Point getRestaurantLoc() {
		Restaurant r;
		Point p = null;
		int count = 0;
		int aim = (int) (Math.random() * restaurants.size());

		for (String s : restaurants.keySet()) {
			if (count == aim) {
				r = restaurants.get(s);
				p = new Point(r.getLatitude(), r.getLongitude());
				break;
			}
			count++;
		}
		return p;
	}

	// modifies clusterMap's Set<Restaurant>
	private void findClosestRestaurants(Map<Point, Set<Restaurant>> clusterMap) {

		// for each restaurant, find the closest centroid Point to it
		// and then add this restaurant to the centroid Point's corresponding
		// Set<Restaurant>
		for (String business_id : restaurants.keySet()) {
			Restaurant r = restaurants.get(business_id);
			Point restaurantLoc = new Point(r.getLatitude(), r.getLongitude());
			double minDist = Double.POSITIVE_INFINITY;
			Point closestCentroid = null;

			// find the centroid Point that restaurant is closest to
			for (Point centroid : clusterMap.keySet()) {
				if (restaurantLoc.distanceTo(centroid) < minDist) {
					closestCentroid = centroid;
					minDist = restaurantLoc.distanceTo(centroid);
				}
			}

			// add this restaurant to the Set<Restaurant> of the corresponding centroid
			clusterMap.get(closestCentroid).add(restaurants.get(business_id));
		}
	}

	@Override
	public ToDoubleBiFunction<MP5Db<Restaurant>, String> getPredictorFunction(String user) {
		// TODO Auto-generated method stub
		List<Long> prices = new ArrayList<Long>();
		List<Long> ratings = new ArrayList<Long>();
		List<Double> avgList = getUserRatingAndPrice(user, prices, ratings);

		double avgPrice = avgList.get(0);
		double avgRating = avgList.get(1);

		ToDoubleBiFunction<MP5Db<Restaurant>, String> predictor = generatePredictor(prices, ratings, avgPrice,
				avgRating);

		return predictor;
	}

	/**
	 * Finds the different reviews that the user has created, and finds the ratings
	 * the user gave to each restaurant and the corresponding prices of the
	 * restaurant. Modifies the two lists that are passed in as parameters and
	 * stores the prices of the restaurants and the corresponding rating given to
	 * the restaurants (such that order of restaurants in prices is the same as
	 * order of ratings).
	 * 
	 * Returns the average price of the restaurants that the user has reviewed and
	 * the average rating given to the restaurants.
	 * 
	 * @param user
	 *            represents a user_id in the database
	 * @param prices
	 *            empty list to store prices of restaurants
	 * @param ratings
	 *            empty list to store ratings of restaurants
	 * @return list of doubles containing the average price of restaurants reviewed
	 *         by the user (at index = 0) and average rating given by the user (at
	 *         index = 1)
	 * 
	 *         If the number of restaurants reviewed by the user is 0 then the
	 *         method returns average price = 0 and average rating = 0
	 */
	private List<Double> getUserRatingAndPrice(String user, List<Long> prices, List<Long> ratings) {

		long sumPrice = 0;
		long sumRating = 0;
		double avgPrice = 0;
		double avgRating = 0;

		for (String review_id : reviews.keySet()) {
			Review review = reviews.get(review_id);
			if (review.getUser_id().equals(user)) {
				long rating = review.getStars();
				String restaurant = review.getBusiness_id();
				long price = restaurants.get(restaurant).getPrice();

				sumPrice += price;
				sumRating += rating;

				prices.add(price);
				ratings.add(rating);
			}
		}

		int num = prices.size();

		if (num > 0) {
			avgPrice = (double) sumPrice / num;
			avgRating = (double) sumRating / num;
		}

		List<Double> avgList = new ArrayList<Double>();

		avgList.add(avgPrice);
		avgList.add(avgRating);

		return avgList;
	}

	/**
	 * Generates a function that predicts the user's ratings for Restaurants in the
	 * database of type MP5Db<Restaurants>. The function that is returned takes two
	 * arguments: one is the database and other other is a String that represents
	 * the id of an object of the Restaurant.
	 * 
	 * @param xList
	 *            list containing the prices of the restaurants
	 * @param yList
	 *            list containing the ratings of the restaurants (order of
	 *            restaurants in prices should match the order of ratings).
	 * @param meanX
	 *            the average value of the prices in xList
	 * @param meanY
	 *            the average value of the ratings in yList
	 * @return a function that predicts the user's ratings for Restaurants in the
	 *         database of type MP5Db<Restaurants>. The function that is returned
	 *         takes two arguments: one is the database and other other is a String
	 *         that represents the id of an object of the Restaurant.
	 * 
	 *         If price.size() < 2 then it throw an IllegalArgumentException because
	 *         the data points are too few.
	 */
	private ToDoubleBiFunction<MP5Db<Restaurant>, String> generatePredictor(List<Long> xList, List<Long> yList,
			double meanX, double meanY) {
		int numReviews = xList.size();

		if (numReviews <= 1) {
			throw new IllegalArgumentException("Not enough data to make prediction");
		}

		double sxx = 0.0;
		double syy = 0.0;
		double sxy = 0.0;
		double x;
		double y;

		for (int i = 0; i < numReviews; i++) {
			x = xList.get(i);
			y = yList.get(i);
			sxx += Math.pow((x - meanX), 2);
			syy += Math.pow((y - meanY), 2);
			sxy += (x - meanX) * (y - meanY);
		}

		double b = sxy / sxx;
		double a = meanY - b * meanX;
		double r_squared = Math.pow(sxy, 2) / (sxx * syy);

		ToDoubleBiFunction<MP5Db<Restaurant>, String> predictor = new ToDoubleBiFunctionModified(a, b);

		return predictor;
	}

	/**
	 * Updates the rating count and average rating for both the restaurant being
	 * reviewed and the user making the review
	 * 
	 * @param business_id
	 *            represents a business_id(restaurant_id) in the database
	 * @param user_id
	 *            represents a user_id in the database
	 * @param newRating
	 *            the new rating being submitted 1 <= newRating <= 5
	 */
	// This is supposed to be a private method that would be called by the addReview
	// method, however, because for testing purposes, and since addReviews would not
	// be completed in time for the first deadline it was changed to public.
	public void updateRatingsAndRatingsCount(String business_id, String user_id, long newRating) {
		restaurants.get(business_id).updateRating(newRating);
		users.get(user_id).updateRating(newRating);
	}

	public String addUser(String name) {
		User u = new User(name);
		users.put(u.getUser_id(), u);

		return u.toString();
	}
}
