package ca.ece.ubc.cpen221.mp5;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.ToDoubleBiFunction;

import org.json.simple.JSONObject;

public class YelpDB implements MP5Db<Object> {

	private Map<String, Restaurant> restaurants;
	private Map<String, Review> reviews;
	private Map<String, User> users;
	private static final double WEIGHT = 2.0;
	
	public YelpDB(String restaurantFilename, String reviewFilename, String userFilename) {

	}

	@Override
	public Set getMatches(String queryString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String kMeansClusters_json(int k) {

		List<Set<Restaurant>> clusterList = findClusters(k);
		String jsonFormat = convertListToJsonFormat(clusterList);
		return jsonFormat;
		
	}
	
	private String convertListToJsonFormat(List<Set<Restaurant>> clusterList) {
		String jsonFormat = "";
		int clusterNum = 0;
		
		for (Set<Restaurant> cluster: clusterList) {
			for (Restaurant r: cluster) {
				JSONObject obj = new JSONObject();
				obj.put("x", r.getLatitude());
				obj.put("y", r.getLongitude());
				obj.put("name", r.getName());
				obj.put("cluster", clusterNum);
				obj.put("weight",WEIGHT);
				jsonFormat += obj.toJSONString();
			}
		}
		return jsonFormat;
	}
	private List<Set<Restaurant>> findClusters(int k){
		Map<Point, Set<Restaurant>> clusterMap = new HashMap<Point, Set<Restaurant>>();
		for (int i = 0; i < k; i++) 
			clusterMap.put(generateRandomPointInRange(), new HashSet<Restaurant>());
		Map<Point,Point> updatedCentroids;
		do {
			findClosestRestaurants(clusterMap);
			updatedCentroids = findNewCentroids(clusterMap);
		} while (newCentroidsFoundOrNot(updatedCentroids)); 
		
		List<Set<Restaurant>> clusterList = new ArrayList<Set<Restaurant>>();
		
		for (Point p: clusterMap.keySet()) {
			clusterList.add(clusterMap.get(p));
		}
		return clusterList;
	}

	private boolean newCentroidsFoundOrNot(Map<Point,Point> newCentroids) {
		for (Point oldCentroid: newCentroids.keySet()) {
			if (!oldCentroid.aboutEqual(newCentroids.get(oldCentroid)) )
				return true;
		}
		return false;
	}
	
	private Map<Point,Point> findNewCentroids(Map<Point, Set<Restaurant>> clusterMap){
		Map<Point,Point> newCentroids = new HashMap<Point,Point>();
		
		for (Point centroidLoc: clusterMap.keySet()) {
			Iterator<Restaurant> itr = clusterMap.get(centroidLoc).iterator();
			int size = clusterMap.get(centroidLoc).size();
			double averageLat = 0;
			double averageLong = 0;
			while (itr.hasNext()) {
				Restaurant r = itr.next();
				averageLat += r.getLatitude();
				averageLong += r.getLongitude();
			}
			averageLat = averageLat/size;
			averageLong = averageLong/size;
			newCentroids.put(centroidLoc, new Point(averageLat,averageLong));
		}
		return newCentroids;
		
	}
	private void findClosestRestaurants(Map<Point, Set<Restaurant>> clusterMap) {
		for (String business_id: restaurants.keySet()) {
			Restaurant r = restaurants.get(business_id);
			Point restaurantLoc = new Point(r.getLatitude(),r.getLongitude());
			double minDist = Double.MAX_VALUE;
			Point closestCentroid = null;
			for (Point p: clusterMap.keySet()) {
				if (restaurantLoc.distanceTo(p)<minDist) {
					closestCentroid = p;
					minDist = restaurantLoc.distanceTo(p);
				}
			}
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
		return null;
	}

}
