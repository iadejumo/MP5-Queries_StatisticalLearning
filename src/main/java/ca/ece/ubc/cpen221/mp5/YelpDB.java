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
		restaurants = new HashMap<String, Restaurant> ();
		reviews = new HashMap<String, Review> ();
		users = new HashMap<String, User> ();
		
		createRestaurantDB(restaurantFilename);
		createReviewDB(reviewFilename);
		createUserDB(userFilename);
		

	}
	
	private void createRestaurantDB (String restaurantFilename) {
		BufferedReader restaurantBR =null;
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
                    restaurants.put(r.getBusiness_id(),r);

                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (restaurantBR != null)restaurantBR.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
	}
	
	private void createReviewDB (String reviewFilename) {
		BufferedReader reviewBR =null;
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
                    reviews.put(r.getReview_id(),r);

                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reviewBR != null)reviewBR.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
	}
	
	private void createUserDB (String userFilename) {
		BufferedReader userBR =null;
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
                    users.put(u.getUser_id(),u);

                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (userBR != null)userBR.close();
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
		// fields, then convert the JSONObject to String format
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
		// create map connecting a random centroid point -> a set of restaurants nearest
		// to it
		Map<Point, Set<Restaurant>> clusterMap = new HashMap<Point, Set<Restaurant>>();
		for (int i = 0; i < k; i++)
			clusterMap.put(generateRandomPointInRange(), new HashSet<Restaurant>());

		// continuously find closest restaurants to the centroid points, then update the
		// Centroids to the average of the cluster
		// stop when the update to the new average does not change any of the centroid
		// points
		Map<Point, Point> updatedCentroids;
		do {
			findClosestRestaurants(clusterMap);
			updatedCentroids = findNewCentroids(clusterMap);
		} while (newCentroidsFoundOrNot(updatedCentroids));

		// convert the clusterMap to a clusterList
		List<Set<Restaurant>> clusterList = new ArrayList<Set<Restaurant>>();
		for (Point p : clusterMap.keySet())
			clusterList.add(clusterMap.get(p));
		return clusterList;
	}

	// returns true if at least one centroid point has changed
	// returns false if no centroid points are changed
	private boolean newCentroidsFoundOrNot(Map<Point, Point> newCentroids) {
		for (Point oldCentroid : newCentroids.keySet()) {
			if (!oldCentroid.aboutEqual(newCentroids.get(oldCentroid)))
				return true;
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
			Iterator<Restaurant> itr = clusterMap.get(centroidLoc).iterator();
			int size = clusterMap.get(centroidLoc).size();
			double averageLat = 0;
			double averageLong = 0;

			// calculate the averageLatitude and averageLongitude and then set newCentroid
			// Point to that location
			while (itr.hasNext()) {
				Restaurant r = itr.next();
				averageLat += r.getLatitude();
				averageLong += r.getLongitude();
			}
			averageLat = averageLat / size;
			averageLong = averageLong / size;
			newCentroids.put(centroidLoc, new Point(averageLat, averageLong));
		}
		return newCentroids;
	}

	private void findClosestRestaurants(Map<Point, Set<Restaurant>> clusterMap) {

		// for each restaurant, find the closest centroid Point to it
		// and then add this restaurant to the centroid Point's corresponding
		// Set<Restaurant>
		for (String business_id : restaurants.keySet()) {
			Restaurant r = restaurants.get(business_id);
			Point restaurantLoc = new Point(r.getLatitude(), r.getLongitude());
			double minDist = Double.MAX_VALUE;
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

	private Point generateRandomPointInRange() {
		double maxLongitude = maxLongitude();
		double minLongitude = minLongitude();
		double maxLatitude = maxLatitude();
		double minLatitude = minLatitude();

		double diffLong = maxLongitude - minLongitude;
		double diffLat = maxLatitude - minLatitude;
		double randLongitude = Math.random() * diffLong + minLongitude;
		double randLatitude = Math.random() * diffLat + minLatitude;
		return new Point(randLatitude, randLongitude);
	}

	private double maxLongitude() {
		double maxLongitude = Double.MIN_VALUE;
		double longitude;
		for (String restName : restaurants.keySet()) {
			longitude = restaurants.get(restName).getLongitude();
			if (maxLongitude < longitude)
				maxLongitude = longitude;
		}
		return maxLongitude;
	}

	private double minLongitude() {
		double minLongitude = Double.MAX_VALUE;
		double longitude;
		for (String restName : restaurants.keySet()) {
			longitude = restaurants.get(restName).getLongitude();
			if (minLongitude > longitude)
				minLongitude = longitude;
		}
		return minLongitude;
	}

	private double maxLatitude() {
		double maxLatitude = Double.MIN_VALUE;
		double latitude;
		for (String restName : restaurants.keySet()) {
			latitude = restaurants.get(restName).getLatitude();
			if (maxLatitude < latitude)
				maxLatitude = latitude;
		}
		return maxLatitude;
	}

	private double minLatitude() {
		double minLatitude = Double.MAX_VALUE;
		double latitude;
		for (String restName : restaurants.keySet()) {
			latitude = restaurants.get(restName).getLatitude();
			if (minLatitude > latitude)
				minLatitude = latitude;
		}
		return minLatitude;
	}

	@Override
	public ToDoubleBiFunction getPredictorFunction(String user) {
		// TODO Auto-generated method stub
		List<Long> prices = new ArrayList<Long>();
		List<Long> ratings = new ArrayList<Long>();
		List<Double> avgList = getUserRatingAndPrice (user, prices, ratings);
		
		
		double avgPrice = avgList.get(0);
		double avgRating = avgList.get(1);
		
		ToDoubleBiFunction<YelpDB, String> predictor = generatePredictor(prices, ratings, avgPrice, avgRating);
		
		return predictor;
	}
	
	private List<Double> getUserRatingAndPrice (String user, List<Long> prices, List<Long> ratings) {
		
		long sumPrice = 0;
		long sumRating = 0;
		double avgPrice = 0;
		double avgRating = 0;
		
		
		for (String review_id: reviews.keySet()) {
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
			avgPrice = (double)sumPrice/num;
			avgRating = (double)sumRating/num;
		}
	
		List<Double> avgList = new ArrayList<Double>();
		
		avgList.add(avgPrice);
		avgList.add(avgRating);
		
		return avgList;
	}
	
	private ToDoubleBiFunction<YelpDB, String> generatePredictor(List<Long> prices, List<Long> ratings, double meanX, double meanY) {
		int size = prices.size();
		
		if(size <= 1) {
			throw new IllegalArgumentException("The user has too few reviews to use to predict");
		}
		
		double sxx = 0.0;
		double syy = 0.0;
		double sxy = 0.0;
		double x;
		double y;
		
		for(int i = 0; i < size; i++) {
			x = prices.get(i);
			y = ratings.get(i);
			sxx += Math.pow((x - meanX), 2);
			syy += Math.pow((y - meanY), 2);
			sxy += (x - meanX)*(y - meanY);
		}
		
		double b = sxy/sxx;
		double a = meanY - b*meanX;
		double r_squared = Math.pow(sxy, 2)/(sxx * syy);
		
		System.out.println(prices + "\n" + ratings);
		ToDoubleBiFunction<YelpDB, String> predictor = (yelpDB, restaurant) -> ((yelpDB.restaurants.get(restaurant).getPrice())*b + a);
		
		return predictor;
	}

}
