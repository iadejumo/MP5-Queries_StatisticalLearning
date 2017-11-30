package ca.ece.ubc.cpen221.mp5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.ToDoubleBiFunction;
import java.util.stream.Stream;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class YelpDB implements MP5Db<Object> {

	private Map<String, Restaurant> restaurants;
	private Map<String, Review> reviews;
	private Map<String, User> users;

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

	@Override
	public String kMeansClusters_json(int k) {

		for (int i = 0;i<k;i++) {
			
		}
		
		
		return null;
	}
	
	private double generateRandomLongitudeInRange() {
		double maxLongitude = maxLongitude();
		double minLongitude = minLongitude();
		double diff = maxLongitude - minLongitude;
		double randLongitude = Math.random()*diff + minLongitude;
		return randLongitude;
	}
	
	private double generateRandomLatitudeInRange() {
		
		double maxLatitude = maxLatitude();
		double minLatitude = minLatitude();
		double diff = maxLatitude - minLatitude;
		double randLatitude = Math.random()*diff + minLatitude;
		return randLatitude;
	}
	
	

	private double maxLongitude() {
		double maxLongitude = Double.MIN_VALUE;
		for (String restName : restaurants.keySet()) {
			longitude = restaurants.get(restName).getLongitude();
			if (maxLongitude < longitude)
				maxLongitude = longitude;
		}
		return maxLongitude;
	}

	private int minLongitude() {
		double minLongitude = Double.MAX_VALUE;
		for (String restName : restaurants.keySet()) {
			longitude = restaurants.get(restName).getLongitude();
			if (minLongitude > longitude)
				minLongitude = longitude;
		}
		return minLongitude;
	}

	private int maxLatitude() {
		double maxLatitude = Double.MIN_VALUE;
		for (String restName : restaurants.keySet()) {
			latitude = restaurants.get(restName).getLatitude();
			if (maxLatitude < latitude)
				maxLatitude = latitude;
		}
		return maxLatitude;
	}

	private int minLatitude() {
		double minLatitude = Double.MAX_VALUE;
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
		double avgPrice;
		double avgRating;
		
		
		for (String review_id: reviews.keySet()) {
			Review review = reviews.get(review_id);
			if (review.getUser_id().equals(user)) {
				Long rating = review.getStars();
				String restaurant = review.getBusiness_id();
				Long price = restaurants.get(restaurant).getPrice();
				
				sumPrice += price;
				sumRating +=rating;
				
				prices.add(price);
				ratings.add(rating);	
			}
		}
		
		int num = prices.size();
		avgPrice = sumPrice/num;
		avgRating = sumRating/num;
		
		List<Double> avgList = new ArrayList<Double>();
		avgList.add(avgPrice);
		avgList.add(avgRating);
		
		return avgList;
	}
	
	private ToDoubleBiFunction<YelpDB, String> generatePredictor(List<Long> prices, List<Long> ratings, double meanX, double meanY) {
		int size = prices.size();
		double sxx = 0;
		double syy = 0;
		double sxy = 0;
		double x;
		double y;
		
		for(int i = 0; i < size; i++) {
			x = prices.get(i);
			y = ratings.get(i);
			sxx += Math.pow((x - meanX), 2);
			syy += Math.pow((y - meanY), 2);
			sxy += x*y;
		}
		
		double b = sxy/sxx;
		double a = meanY - b*meanX;
		double r_squared = Math.pow(sxy, 2)/(sxx * syy);
		
		ToDoubleBiFunction<YelpDB, String> predictor = (yelpDB, restaurant) -> (restaurants.get(restaurant).getPrice())*b + a;
		
		return predictor;
	}

}
