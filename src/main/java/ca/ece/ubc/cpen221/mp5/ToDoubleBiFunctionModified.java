package ca.ece.ubc.cpen221.mp5;

import java.util.function.ToDoubleBiFunction;

public class ToDoubleBiFunctionModified implements ToDoubleBiFunction<MP5Db<Restaurant>, String>{
	private double a;
	private double b;
	
	public ToDoubleBiFunctionModified(double a, double b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public double applyAsDouble(MP5Db<Restaurant> t, String u) {
		// TODO Auto-generated method stub
		double prediction = ((((YelpDB)t).getRestaurants().get(u).getPrice()) * b + a);
		
		if (prediction < 1) {
			return (double)1;
		}
		else if (prediction <= 5) {
			return prediction;
		}
		else {
			return 5;
		}
	}

}
