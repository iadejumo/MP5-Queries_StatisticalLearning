package ca.ece.ubc.cpen221.mp5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class TestJSON {

	
	public static void main(String[] args) throws org.json.simple.parser.ParseException, FileNotFoundException, IOException {
		/* JSONParser parser = new JSONParser();

        try {     
            Object obj = parser.parse(new FileReader("data/reviews.json"));

            JSONObject jsonObject =  (JSONObject) obj;

            String name = (String) jsonObject.get("name");
            System.out.println(name);

            String city = (String) jsonObject.get("city");
            System.out.println(city);

            String job = (String) jsonObject.get("job");
            System.out.println(job);

            // loop array
            JSONArray cars = (JSONArray) jsonObject.get("cars");
            Iterator<String> iterator = cars.iterator();
            while (iterator.hasNext()) {
             System.out.println(iterator.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
		*/
		JSONParser parser = new JSONParser();
		JSONArray a = (JSONArray) parser.parse(new FileReader("data/restaurants.json"));

		  for (Object o : a)
		  {
		    JSONObject person = (JSONObject) o;

		    String name = (String) person.get("name");
		    System.out.println(name);

		    String city = (String) person.get("city");
		    System.out.println(city);

		    String job = (String) person.get("job");
		    System.out.println(job);

		    JSONArray cars = (JSONArray) person.get("cars");

		    for (Object c : cars)
		    {
		      System.out.println(c+"");
		    }
		  }
		/*
		List<Object> list = new ArrayList<Object>();
		list.add("YO");
		list.add(10);
		list.add(new ArrayList<String>());
		System.out.println(list);
		list.add(1, 11);
		System.out.println(list);
		List<String> l = (List)(list.get(3));
		l.add("e");
		System.out.println(list);
		*/
		
    }
	
	public static void readJsonFile() {

        BufferedReader br =null;
        JSONParser parser = new JSONParser();

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader("C:/Users/tlum1/f17-mp5-tylerlum_iadejumo/data/restants.json"));

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
