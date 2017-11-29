package ca.ece.ubc.cpen221.mp5;

import java.io.File;
<<<<<<< HEAD
=======
import java.util.HashMap;
>>>>>>> 8904b02370c5e6ac445bce51a0eaaffd83cc0d55
import java.util.Map;
import java.util.Set;
import java.util.function.ToDoubleBiFunction;

public class YelpDB implements MP5Db<Object> {

	private Map<String, Restaurant> restaurants;
	private Map<String, Review> reviews;
	private Map<String, User> users;

	public YelpDB(String restaurantFilename, String reviewFilename, String userFilename) {


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
		return null;
	}

}
