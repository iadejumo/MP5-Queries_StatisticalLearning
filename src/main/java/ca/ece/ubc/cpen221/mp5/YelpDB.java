package ca.ece.ubc.cpen221.mp5;

import java.io.File;
import java.util.Set;
import java.util.function.ToDoubleBiFunction;


public class YelpDB implements MP5Db<Object> {

	private File restaurants;
	private File reviews;
	private File users;
	
	public YelpDB(String restaurantFilename,String reviewFilename, String userFilename) {
		
	}
	@Override
	public Set getMatches(String queryString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String kMeansClusters_json(int k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ToDoubleBiFunction getPredictorFunction(String user) {
		// TODO Auto-generated method stub
		return null;
	}

}
