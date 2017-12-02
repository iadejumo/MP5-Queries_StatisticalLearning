package ca.ece.ubc.cpen221.mp5.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.ece.ubc.cpen221.mp5.Point;
import ca.ece.ubc.cpen221.mp5.YelpDB;

public class KMeansClusterTest {

	
	@Test
	public void test1() {
		String userFile = "data\\users.json";
		String restaurantFile = "data\\restaurants.json";
		String reviewFile = "data\\reviews.json";

		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);

		String s = yelpDB.kMeansClusters_json(5);
		System.out.println(s);

		int count1 = 0;
		for (int k = 0; k < s.length() - 10; k++) {
			if (s.substring(k, k + 10).equals("cluster\":0"))
				count1++;
		}
		System.out.println(count1);

		int count2 = 0;
		for (int k = 0; k < s.length() - 10; k++) {
			if (s.substring(k, k + 10).equals("cluster\":1"))
				count2++;
		}
		System.out.println(count2);

		int count3 = 0;
		for (int k = 0; k < s.length() - 10; k++) {
			if (s.substring(k, k + 10).equals("cluster\":2"))
				count3++;
		}
		System.out.println(count3);

		int count4 = 0;
		for (int k = 0; k < s.length() - 10; k++) {
			if (s.substring(k, k + 10).equals("cluster\":3"))
				count4++;
		}
		System.out.println(count4);

		int count5 = 0;
		for (int k = 0; k < s.length() - 10; k++) {
			if (s.substring(k, k + 10).equals("cluster\":4"))
				count5++;
		}

		System.out.println(count5);

		assertTrue(count1 + count2 + count3 + count4 + count5 == 135);
	}

	@Test
	public void test2() {
		String userFile = "data\\users.json";
		String restaurantFile = "data\\restaurants.json";
		String reviewFile = "data\\reviews.json";

		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);

		System.out.println("Done");

		String s = yelpDB.kMeansClusters_json(1);
		System.out.println(s);

		int count1 = 0;
		for (int k = 0; k < s.length() - 10; k++) {
			if (s.substring(k, k + 10).equals("cluster\":0"))
				count1++;
		}
		System.out.println(count1);

		int count2 = 0;
		for (int k = 0; k < s.length() - 10; k++) {
			if (s.substring(k, k + 10).equals("cluster\":1"))
				count2++;
		}
		System.out.println(count2);

		int count3 = 0;
		for (int k = 0; k < s.length() - 10; k++) {
			if (s.substring(k, k + 10).equals("cluster\":2"))
				count3++;
		}
		System.out.println(count3);

		int count4 = 0;
		for (int k = 0; k < s.length() - 10; k++) {
			if (s.substring(k, k + 10).equals("cluster\":3"))
				count4++;
		}
		System.out.println(count4);

		int count5 = 0;
		for (int k = 0; k < s.length() - 10; k++) {
			if (s.substring(k, k + 10).equals("cluster\":4"))
				count5++;
		}

		System.out.println(count5);

		assertTrue(count1 + count2 + count3 + count4 + count5 == 135);
	}

	@Test
	public void test3() {
		String userFile = "data\\users.json";
		String restaurantFile = "data\\restaurants.json";
		String reviewFile = "data\\reviews.json";

		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);

		System.out.println("Done");

		String s = yelpDB.kMeansClusters_json(11);
		System.out.println(s);

		int count0 = 0;
		for (int k = 0; k < s.length() - 10; k++) {
			if (s.substring(k, k + 10).equals("cluster\":0"))
				count0++;
		}

		int count1 = 0;
		for (int k = 0; k < s.length() - 11; k++) {
			if (s.substring(k, k + 11).equals("cluster\":1,"))
				count1++;
		}

		int count2 = 0;
		for (int k = 0; k < s.length() - 10; k++) {
			if (s.substring(k, k + 10).equals("cluster\":2"))
				count2++;
		}

		int count3 = 0;
		for (int k = 0; k < s.length() - 10; k++) {
			if (s.substring(k, k + 10).equals("cluster\":3"))
				count3++;
		}

		int count4 = 0;
		for (int k = 0; k < s.length() - 10; k++) {
			if (s.substring(k, k + 10).equals("cluster\":4"))
				count4++;
		}

		int count5 = 0;
		for (int k = 0; k < s.length() - 10; k++) {
			if (s.substring(k, k + 10).equals("cluster\":5"))
				count5++;
		}

		int count6 = 0;
		for (int k = 0; k < s.length() - 10; k++) {
			if (s.substring(k, k + 10).equals("cluster\":6"))
				count6++;
		}

		int count7 = 0;
		for (int k = 0; k < s.length() - 10; k++) {
			if (s.substring(k, k + 10).equals("cluster\":7"))
				count7++;
		}

		int count8 = 0;
		for (int k = 0; k < s.length() - 10; k++) {
			if (s.substring(k, k + 10).equals("cluster\":8"))
				count8++;
		}

		int count9 = 0;
		for (int k = 0; k < s.length() - 10; k++) {
			if (s.substring(k, k + 10).equals("cluster\":9"))
				count9++;
		}

		int count10 = 0;
		for (int k = 0; k < s.length() - 11; k++) {
			if (s.substring(k, k + 11).equals("cluster\":10"))
				count10++;
		}

		int count11 = 0;
		for (int k = 0; k < s.length() - 11; k++) {
			if (s.substring(k, k + 11).equals("cluster\":11"))
				count11++;
		}

		assertTrue(count0 + count1 + count2 + count3 + count4 + count5 + count6 + count7 + count8 + count9 + count10
				+ count11 == 135);
	}

	@Test
	public void test4() {
		Point p = new Point(10, -20);
		assertTrue(p.toString().equals("10.0 -20.0"));
	}
	
	
	@Test 
	public void test5() {
		String userFile = "data\\users.json";
		String restaurantFile = "data\\restaurants.json";
		String reviewFile = "data\\reviews.json";

		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		System.out.println("Done");

		String s = yelpDB.kMeansClusters_json(60);
		System.out.println(s);
		
	}
	
	
}
