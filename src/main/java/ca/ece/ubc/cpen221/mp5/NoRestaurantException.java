package ca.ece.ubc.cpen221.mp5;

public class NoRestaurantException extends Exception {

	// RI = None
	// AF = None, no fields

	public NoRestaurantException() {
		System.err.println("ERR: NO_RESTAURANT_WITH_GIVEN_ID");
	}

}
