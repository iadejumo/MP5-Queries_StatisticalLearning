package ca.ece.ubc.cpen221.mp5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;


public class YelpDBClient {

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	public YelpDBClient(String hostname,int port) throws IOException, IOException {
		socket = new Socket(hostname,port);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
	}
	
	public void sendRequest(String s) {
		out.println(s + "\n");
		out.flush();
	}
	
	public String getReply() throws IOException {
		String reply = in.readLine();
		if (reply == null)
			throw new IOException("connection ended");
		
		try {
			return reply;
			
		} catch (Exception e) {
			throw new IOException("misformatted reply");
		}
	}
	
	public void close() throws IOException {
        in.close();
        out.close();
        socket.close();
    }
	
	 public static void main(String[] args) throws InterruptedException {
	        try {
	            YelpDBClient client = new YelpDBClient("localhost", YelpDBServer.YELPDB_PORT);
	          
	            /*client.sendRequest("");
	            System.out.println("Asked-1: ");
	            TimeUnit.SECONDS.sleep(1);
          
	            System.out.println("Answer1: "+client.getReply());
	            TimeUnit.SECONDS.sleep(1);
	            
	            client.sendRequest("");
	            System.out.println("Asked0: ");
	            TimeUnit.SECONDS.sleep(1);
          
	            System.out.println("Answer0: "+client.getReply());
	            TimeUnit.SECONDS.sleep(1);
	            */
	            int timeDelay = 1;
	            client.sendRequest("GETRESTAURANT gclB3ED6uk6viWlolSb_uA");
	            System.out.println("Asked1: GETRESTAURANT gclB3ED6uk6viWlolSb_uA");
	            TimeUnit.SECONDS.sleep(timeDelay);
          
	            System.out.println("Answer1: "+client.getReply());
	            TimeUnit.SECONDS.sleep(timeDelay);
	            
	            client.sendRequest("ADDUSER {\"name\": \"Sathish G.\"}");
	            System.out.println("Asked2: ADDUSER {\"name\": \"Sathish G.\"}");
	            TimeUnit.SECONDS.sleep(timeDelay);
	            
	            System.out.println("Answer2: "+client.getReply());
	            TimeUnit.SECONDS.sleep(timeDelay);
	            
	            client.sendRequest("ADDUSER {\"name\": \"Tyler L.\"}");
	            System.out.println("Asked3: ADDUSER {\"name\": \"Tyler L.\"}");
	            TimeUnit.SECONDS.sleep(timeDelay);
	            
	            System.out.println("Answer3: "+client.getReply());
	            TimeUnit.SECONDS.sleep(timeDelay);
	            
	            client.sendRequest("ADDUSER {\"name\": Tyler L.\"}");
	            System.out.println("Asked4: ADDUSER {\"name\": Tyler L.\"}, should be error");
	            TimeUnit.SECONDS.sleep(timeDelay);
	            
	            System.out.println("Answer4: "+client.getReply());
	  
	            client.sendRequest("ADDREVIEW {\"name\": \"Tyler L.\"}");
	            System.out.println("Asked5: ADDREVIEW {\"name\": Tyler L.\"}, should be error");
	            TimeUnit.SECONDS.sleep(timeDelay*2);
	            
	            System.out.println("Answer5: "+client.getReply());
	            TimeUnit.SECONDS.sleep(timeDelay);
	            
	            /////////////////
	            client.sendRequest("ADDUSER {\"name\": \"Tyler L.\", \"url\": \"http\"}");
	            System.out.println("Asked6: ADDUSER {\"name\": \"Tyler L.\"}, \"url\": \"http\", should not be error");
	            TimeUnit.SECONDS.sleep(timeDelay);
	            
	            System.out.println("Answer6: "+client.getReply());
	            /////////////////
	            client.sendRequest("ADDUSER {\"url\": \"http\"}");
	            System.out.println("Asked7: ADDUSER {\"url\": \"http\"}, should be error");
	            TimeUnit.SECONDS.sleep(timeDelay);

	            System.out.println("Answer7: "+client.getReply());
	            
	            JSONObject jObjRestaurant = new JSONObject();
	            jObjRestaurant.put("open",true);
	            jObjRestaurant.put("longitude",10.0);
	            List<String> n = new ArrayList<String>();
	            n.add("UBC");
	            jObjRestaurant.put("neighborhoods",n);
	            jObjRestaurant.put("name","King Mahal");
	            List<String> c = new ArrayList<String>();
	            c.add("Italian");
	            jObjRestaurant.put("categories",c);
	            jObjRestaurant.put("state","BC");
	            jObjRestaurant.put("city","Burnaby");
	            jObjRestaurant.put("full_address","2525 West Mall");
	            jObjRestaurant.put("schools",n);
	            jObjRestaurant.put("latitude", 12.0);
	            jObjRestaurant.put("price",2.0);
	            
	            JSONObject jObjReview1 = new JSONObject();
	            jObjReview1.put("business_id","134jkdlf");
	            Map<String,Integer> v = new HashMap<String,Integer>();
	            v.put("funny", 1);
	            jObjReview1.put("votes",v);
	            jObjReview1.put("text","GREAT FOOD");
	            jObjReview1.put("stars",2.0);
	            jObjReview1.put("user_id","20");
	            jObjReview1.put("date","Today");
	            
	            JSONObject jObjReview2 = new JSONObject();
	            jObjReview2.put("business_id","gclB3ED6uk6viWlolSb_uA");
	            jObjReview2.put("votes",v);
	            jObjReview2.put("text","GREAT FOOD");
	            jObjReview2.put("stars",2.0);
	            jObjReview2.put("user_id","_NH7Cpq3qZkByP5xR4gXog");
	            jObjReview2.put("date","Today");
	            
	            client.sendRequest("ADDREVIEW "+ jObjReview1.toString());
	            System.out.println("Asked8: ADDREVIEW" + jObjReview1.toString() + ", should be error, bad ids");
	            TimeUnit.SECONDS.sleep(timeDelay);
	            
	            System.out.println("Answer8: "+client.getReply());
	            
	            client.sendRequest("ADDREVIEW "+ jObjReview2.toString());
	            System.out.println("Asked9: ADDREVIEW" + jObjReview2.toString() + ", should be no error");
	            TimeUnit.SECONDS.sleep(timeDelay);
	            System.out.println("Answer9: "+client.getReply());

	            client.sendRequest("ADDRESTAURANT "+ jObjRestaurant.toString());
	            System.out.println("Asked10: ADDRESTAURANT" + jObjRestaurant.toString() + ", should be no error");
	            TimeUnit.SECONDS.sleep(timeDelay);
	            System.out.println("Answer10: "+client.getReply());
	            System.out.println("Answer11: "+client.getReply());
	            System.out.println("Answer12: "+client.getReply());
	            System.out.println("Answer13: "+client.getReply());
	            System.out.println("Answer14: "+client.getReply());
	            System.out.println("Answer15: "+client.getReply());
	            
	            TimeUnit.SECONDS.sleep(timeDelay*10);
	            client.close();
	        } catch (IOException ioe) {
	            ioe.printStackTrace();
	        }
	    }
}
