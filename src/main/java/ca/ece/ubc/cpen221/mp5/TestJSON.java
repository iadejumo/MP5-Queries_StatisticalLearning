package ca.ece.ubc.cpen221.mp5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.function.ToDoubleBiFunction;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class TestJSON {

	
	public static void main(String[] args) throws org.json.simple.parser.ParseException, FileNotFoundException, IOException {

		String userFile = "data\\users.json";
		String restaurantFile = "data\\restaurants.json";
		String reviewFile = "data\\reviews.json";
				
		YelpDB yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		
		ToDoubleBiFunction<MP5Db<Restaurant>, String> predictor = yelpDB.getPredictorFunction("FjNgN6Dk9fh4NatwthoFgA");
		double predicted = predictor.applyAsDouble(yelpDB, "P2XKcDLVHUuOdGNBQtMFRQ");
		
		String s1 = "in(Telegraph Ave) && (category(Chinese) || category(Italian)) && price <= 2";
		String s = "category(i)";
		String s2 = "time";
		
		yelpDB.parseInput(s1);
		//System.out.println(predicted);
		
		
    }
	
	public static void readJsonFile() {

        BufferedReader br = null;
        JSONParser parser = new JSONParser();

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader("C:/Users/tlum1/f17-mp5-tylerlum_iadejumo/data/restaurants.json"));

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println("Record:\t" + sCurrentLine);

                Object obj;
                try {
                    obj = parser.parse(sCurrentLine);
                    JSONObject jsonObject = (JSONObject) obj;

                    String rel = (String) jsonObject.get("rel");
                    System.out.println(rel);

                    String start = (String) jsonObject.get("start");
                    System.out.println(start);

                    String end = (String) jsonObject.get("end");
                    System.out.println(end);

                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
