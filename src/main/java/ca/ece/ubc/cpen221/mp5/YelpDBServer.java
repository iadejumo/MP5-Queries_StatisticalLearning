package ca.ece.ubc.cpen221.mp5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.json.simple.parser.ParseException;

import fibonacci.FibonacciServerMulti;

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
	private final YelpDB yelpDB;
	private ServerSocket serverSocket;
	public static final int YELPDB_PORT = 4949;

	private final String userFile = "data/users.json";
	private final String restaurantFile = "data/restaurants.json";
	private final String reviewFile = "data/reviews.json";

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
			//each request is a single line containing a number
			for (String line = in.readLine(); line != null; line = in.readLine()) {
				System.err.println("request: " + line);
				try {
					// TODO make this handle actually do YelpDB work
					int x = Integer.valueOf(line);
					// compute ansewr and send back to client
					int y = x;
					System.err.println("reply: " + y);
					out.println(y);
				} catch (Exception e) {
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
