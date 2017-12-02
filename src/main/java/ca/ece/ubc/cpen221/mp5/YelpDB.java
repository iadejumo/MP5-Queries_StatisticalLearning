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

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class YelpDB implements MP5Db<Object> {

	private Map<String, Restaurant> restaurants;
	private Map<String, Review> reviews;
	private Map<String, User> users;

	private static final double WEIGHT = 2.0;

	public YelpDB(String restaurantFilename, String reviewFilename, String userFilename) {
		restaurants = new HashMap<String, Restaurant>();
		reviews = new HashMap<String, Review>();
		users = new HashMap<String, User>();

		createRestaurantDB(restaurantFilename);
		createReviewDB(reviewFilename);
		createUserDB(userFilename);
	}

	private void createRestaurantDB(String restaurantFilename) {
		BufferedReader restaurantBR = null;
		JSONParser parser = new JSONParser();

		try {
			String sCurrentLine;

			restaurantBR = new BufferedReader(new FileReader(restaurantFilename));

			while ((sCurrentLine = restaurantBR.readLine()) != null) {

				Object obj;
				try {
					obj = parser.parse(sCurrentLine);
					JSONObject jsonObject = (JSONObject) obj;

					Restaurant r = new Restaurant(jsonObject);
					restaurants.put(r.getBusiness_id(), r);

				} catch (ParseException e) {
					e.printStackTrace();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (restaurantBR != null)
					restaurantBR.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	private void createReviewDB(String reviewFilename) {
		BufferedReader reviewBR = null;
		JSONParser parser = new JSONParser();

		try {
			String sCurrentLine;

			reviewBR = new BufferedReader(new FileReader(reviewFilename));

			while ((sCurrentLine = reviewBR.readLine()) != null) {

				Object obj;
				try {
					obj = parser.parse(sCurrentLine);
					JSONObject jsonObject = (JSONObject) obj;

					Review r = new Review(jsonObject);
					reviews.put(r.getReview_id(), r);

				} catch (ParseException e) {
					e.printStackTrace();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reviewBR != null)
					reviewBR.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	private void createUserDB(String userFilename) {
		BufferedReader userBR = null;
		JSONParser parser = new JSONParser();

		try {
			String sCurrentLine;

			userBR = new BufferedReader(new FileReader(userFilename));

			while ((sCurrentLine = userBR.readLine()) != null) {

				Object obj;
				try {
					obj = parser.parse(sCurrentLine);
					JSONObject jsonObject = (JSONObject) obj;

					User u = new User(jsonObject);
					users.put(u.getUser_id(), u);

				} catch (ParseException e) {
					e.printStackTrace();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (userBR != null)
					userBR.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

	@Override
	public Set getMatches(String queryString) {
		// TODO Auto-generated method stub
		return null;
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
		String jsonFormat = "";

		// for each Restaurant in each cluster, create a JSONObject with the necessary
		// fields, then convert the JSONObject to String format, then add it to String
		for (int clusterNum = 0; clusterNum < clusterList.size(); clusterNum++) {
			for (Restaurant r : clusterList.get(clusterNum)) {
				JSONObject obj = new JSONObject();
				obj.put("x", r.getLatitude());
				obj.put("y", r.getLongitude());
				obj.put("name", r.getName());
				obj.put("cluster", clusterNum);
				obj.put("weight", WEIGHT);
				jsonFormat += obj.toJSONString();
			}
		}
		return jsonFormat;
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

		KMeansVisualizer vis = new KMeansVisualizer();
		vis.setDelay(1000);

		do {
			clusterMap = updateClusterMap(updatedCentroids);
			findClosestRestaurants(clusterMap);

			for (Point centroid : clusterMap.keySet()) {
				vis.beginCluster(centroid.latitude, centroid.longitude);
				for (Restaurant r : clusterMap.get(centroid))
					vis.addPoint(r.getLatitude(), r.getLongitude());
			}

			vis.show();
			updatedCentroids = findNewCentroids(clusterMap);
			// } while (newCentroidsFound(updatedCentroids) );
		} while (newCentroidsFound(updatedCentroids) || emptyClusterIn(clusterMap));
		vis.close();

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
		//only needed for very rare case
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
	public ToDoubleBiFunction getPredictorFunction(String user) {
		// TODO Auto-generated method stub
		List<Long> prices = new ArrayList<Long>();
		List<Long> ratings = new ArrayList<Long>();
		List<Double> avgList = getUserRatingAndPrice(user, prices, ratings);

		double avgPrice = avgList.get(0);
		double avgRating = avgList.get(1);

		ToDoubleBiFunction<YelpDB, String> predictor = generatePredictor(prices, ratings, avgPrice, avgRating);

		return predictor;
	}

	private List<Double> getUserRatingAndPrice(String user, List<Long> prices, List<Long> ratings) {

		long sumPrice = 0;
		long sumRating = 0;
		double avgPrice;
		double avgRating;

		for (String review_id : reviews.keySet()) {
			Review review = reviews.get(review_id);
			if (review.getUser_id().equals(user)) {
				Long rating = review.getStars();
				String restaurant = review.getBusiness_id();
				Long price = restaurants.get(restaurant).getPrice();

				sumPrice += price;
				sumRating += rating;

				prices.add(price);
				ratings.add(rating);
			}
		}

		int num = prices.size();
		avgPrice = sumPrice / num;
		avgRating = sumRating / num;

		List<Double> avgList = new ArrayList<Double>();
		avgList.add(avgPrice);
		avgList.add(avgRating);

		return avgList;
	}

	private ToDoubleBiFunction<YelpDB, String> generatePredictor(List<Long> prices, List<Long> ratings, double meanX,
			double meanY) {
		int size = prices.size();
		double sxx = 0;
		double syy = 0;
		double sxy = 0;
		double x;
		double y;

		for (int i = 0; i < size; i++) {
			x = prices.get(i);
			y = ratings.get(i);
			sxx += Math.pow((x - meanX), 2);
			syy += Math.pow((y - meanY), 2);
			sxy += x * y;
		}

		double b = sxy / sxx;
		double a = meanY - b * meanX;
		double r_squared = Math.pow(sxy, 2) / (sxx * syy);

		ToDoubleBiFunction<YelpDB, String> predictor = (yelpDB,
				restaurant) -> (restaurants.get(restaurant).getPrice()) * b + a;

		return predictor;
	}

}
