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

import fibonacci.FibonacciClient;
import fibonacci.FibonacciServer;

public class YelpDBClient {

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	public YelpDBClient(String hostname,int port) throws IOException, IOException {
		socket = new Socket(hostname,port);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
	}
	
	public void sendRequest(int x) {
		out.println(x + "\n");
		out.flush();
	}
	
	public BigInteger getReply() throws IOException {
		String reply = in.readLine();
		if (reply == null)
			throw new IOException("connection ended");
		
		try {
			return new BigInteger(reply);
			
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

	            // send the requests to find the first N Fibonacci numbers
	            int p = -2;
	            client.sendRequest(p);
	            System.out.println(client.getReply());
	            
	            for (int x = 1; x <= N; ++x) {
	                client.sendRequest(x);
	                System.out.println("fibonacci("+x+") = ?");
	                TimeUnit.SECONDS.sleep(1);
	            }
	            
	            
	            // collect the replies
	            for (int x = 1; x <= N; ++x) {
	                BigInteger y = client.getReply();
	                System.out.println("fibonacci("+x+") = "+y);
	            }
	            
	            client.close();
	        } catch (IOException ioe) {
	            ioe.printStackTrace();
	        }
	    }
}
