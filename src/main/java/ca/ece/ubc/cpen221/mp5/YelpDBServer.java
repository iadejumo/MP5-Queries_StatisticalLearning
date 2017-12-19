package ca.ece.ubc.cpen221.mp5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.json.JsonObject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class YelpDBServer {

	// Abstraction Function: yelpDB + serverSocket + port number
	// Rep invariant: serverSocket != null

	// Thread safety argument:
	// YELPDB_PORT is static final and primitive type, so its reference and value
	// are fully immutable
	// TODO serverSocket
	// socket objects
	// readers and writers in handle()
	// data in handle
	// filenames are private and final and String, so its reference and object
	// values are fully immutable
	// commands is only ever read from NEVER WRITTEN TO after constructor and is immutable
	private final YelpDB yelpDB;
	
	private ServerSocket serverSocket;
	public static final int YELPDB_PORT = 4949;

	private final String userFile = "data/users.json";
	private final String restaurantFile = "data/restaurants.json";
	private final String reviewFile = "data/reviews.json";
	
	private final List<String> commands; //maybe should be static?

	private static final int GETRESTAURANT = 0;
	private static final int ADDUSER = 1;
	private static final int ADDRESTAURANT = 2;
	private static final int ADDREVIEW = 3;
	/**
	 * Make a YelpDBServer that listens for connections on port.
	 * 
	 * @param port
	 *            port number, requires 0 <= port <= 65535
	 * @throws IOException
	 *             if YelpDB data files are not in the proper location
	 * @throws ParseException
	 *             if YelpDB data files are not valid
	 */
	public YelpDBServer(int port) throws ParseException, IOException {
		yelpDB = new YelpDB(restaurantFile, reviewFile, userFile);
		serverSocket = new ServerSocket(port);
		commands = setupCommands();
	}
	
	private List<String> setupCommands(){
		List<String> commands = new ArrayList<String>();
		commands.add("GETRESTAURANT");
		commands.add("ADDUSER");
		commands.add("ADDRESTAURANT");
		commands.add("ADDREVIEW");
		return Collections.unmodifiableList(commands);
	}

	/**
	 * Run the server, listening for connections and handling them.
	 * 
	 * @throws IOException
	 *             if the main server socket is broken
	 */
	public void serve() throws IOException {
		while (true) {
			//block until a client conects
			final Socket socket = serverSocket.accept();
			//create a new thread to handle that client
			Thread handler = new Thread(new Runnable() {
				public void run() {
					try {
						try {
							handle(socket);
						} finally {
							socket.close();
						}
					} catch (IOException ioe) {
						// this exception wouldn't terminate serve()
						// since we're now on a different thread but 
						// we still need to handle it
						ioe.printStackTrace();
					}
				}
			});
			// start the thread
			handler.start();
		}
	}
	
	/**
	 * Handle one client connection. Returns when client disconnects.
	 * 
	 * @param socket
	 *            socket where client is connected
	 * @throws IOException
	 *             if connection encounters an error
	 */
	private void handle(Socket socket) throws IOException {
		System.err.println("New client connected!");
		
		// get the socket's input stream, and wrap converters around it 
		// that convert it from a byte stream to a character stream,
		// and then buffer it so that we can read it line by line
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		// similarly, wrap character=>bytestream converter around the socket output stream
		// and wrap a PrintWRiter around that so 
		// that we have more convenient ways to write Java primitive
		// types to it
		PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
		
		try {
			//each request is a single line containing a command keyword and its parameters
			for (String line = in.readLine(); line != null; line = in.readLine()) {
				System.err.println("request: " + line);
				try {
				
					// get answer and send back to client
					String reply = prepareReply(line);
					System.err.println("reply: " + reply);
					out.println(reply);
				} /*catch (NoRestaurantException e) {
					// complain about the error in format of request
					System.err.println("reply: ERR: NO_RESTAURANT_WITH_GIVEN_ID");
					out.println("ERR: NO_RESTAURANT_WITH_GIVEN_ID\n");	
				} */
				catch (Exception e) {
					// complain about error in format of request
					System.err.println("reply: err");
					out.println("err\n");	
				} 
				// important! our PrintWriter is auto-flushing, but if not
				// out.flush();
			}
		} finally {
			out.close();
			in.close();
		}
	}
	
	private String prepareReply(String inputLine) {
		
		if (inputLine.equals("GETRESTAURANT")) {
			return getRestaurant(inputLine).toString();
		}
		
		if (inputLine.equals("ADDUSER")) {
			
		}
		if (inputLine.equals("ADDRESTAURANT")) {
	
		}
		if (inputLine.equals("ADDREVIEW")) {
	
		}
		return null;
		
		
	}
	
	private synchronized Restaurant getRestaurant(String businessId) {
		Map<String, Restaurant> allRestaurants = yelpDB.getRestaurants();
		return allRestaurants.get(businessId);
	}
	
	private synchronized void addReview(Review review) {
		
	}
	
	private synchronized void addRestaurant(Restaurant restaurant) {
		
	}
	
	private synchronized void addUser(String userName) {
		yelpDB.addUser(userName);
	}
	
	private String convertToJsonFormat(Restaurant r) {

		JSONObject obj = new JSONObject();
		obj.put("x", r.getLatitude());
		obj.put("y", r.getLongitude());
		obj.put("name", r.getName());
	
		return obj.toJSONString();
	}
	/**
	 * Start a YelpDBServer running on the default port.
	 */
	public static void main(String[] args) {
		try {
			YelpDBServer server = new YelpDBServer(YELPDB_PORT);
			server.serve();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
}
