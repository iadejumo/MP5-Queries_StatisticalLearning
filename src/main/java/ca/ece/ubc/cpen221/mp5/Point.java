package ca.ece.ubc.cpen221.mp5;

public class Point {

	// Rep Invariant: latitude and longitude are not NaN
	// Abstraction Function: latitude x longitude

	public final double latitude;
	public final double longitude;
	private static final double TOLERANCE = 0.000001;

	/**
	 * Create an Immutable Point object
	 * 
	 * @param latitude
	 *            - latitude position of the Point, can't be NaN
	 * @param longitude
	 *            - longitude position of the Point, can't be NaN
	 */
	public Point(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * Find the distance of this Point to another Point
	 * 
	 * @param other
	 *            - Point to be compared to to find the distance from this to other
	 *            other != null
	 * @return double - distance between this and other
	 */
	public double distanceTo(Point other) {
		double diffLat = this.latitude - other.latitude;
		double diffLong = this.longitude - other.longitude;
		return Math.sqrt(Math.pow(diffLat, 2.0) + Math.pow(diffLong, 2.0));
	}

	/**
	 * Checks if the Points are very close
	 * 
	 * @param other
	 *            - Point to be compared to. Checks if the Points are very close
	 *            other != null
	 * @return boolean - true if this and other are very close, else returns false
	 */
	public boolean aboutEqual(Point other) {
		if (Math.abs(this.latitude - other.latitude) < TOLERANCE
				&& Math.abs(this.longitude - other.longitude) < TOLERANCE)
			return true;
		return false;
	}

	/**
	 * returns String representation of the Point
	 * 
	 * @return String - String representation of the point
	 */
	@Override
	public String toString() {
		return "(" + latitude + " " + longitude + ")";
	}
}
