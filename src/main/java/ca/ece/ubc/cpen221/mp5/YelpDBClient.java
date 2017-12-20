package ca.ece.ubc.cpen221.mp5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;


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

	            client.sendRequest("GETRESTAURANT gclB3ED6uk6viWlolSb_uA");
	            System.out.println("Asked1: GETRESTAURANT gclB3ED6uk6viWlolSb_uA");
	            TimeUnit.SECONDS.sleep(1);
	            
	            
	            
	            System.out.println("Answer1: "+client.getReply());
	            
	            client.sendRequest("GETRESTAURANT 1CBs84C-a-cuA3vncXVSAw");
	            System.out.println("Asked2: GETRESTAURANT 1CBs84C-a-cuA3vncXVSAw");
	            TimeUnit.SECONDS.sleep(1);
	            
	            System.out.println("Answer2: "+client.getReply());
	  
	            client.close();
	        } catch (IOException ioe) {
	            ioe.printStackTrace();
	        }
	    }
}
