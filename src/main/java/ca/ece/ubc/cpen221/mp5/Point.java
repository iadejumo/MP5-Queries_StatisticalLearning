package ca.ece.ubc.cpen221.mp5;

public class Point {

	public final double latitude;
	public final double longitude;
	private static final double TOLERANCE = 0.0001;

	public Point(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double distanceTo(Point other) {
		double diffLat = this.latitude - other.latitude;
		double diffLong = this.longitude - other.longitude;
		return Math.sqrt(Math.pow(diffLat, 2.0) + Math.pow(diffLong, 2.0));
	}

	public boolean aboutEqual(Point other) {
		if (Math.abs(this.latitude - other.latitude) < TOLERANCE
				&& Math.abs(this.longitude - other.longitude) < TOLERANCE) 
			return true;

		return false;
	}
}