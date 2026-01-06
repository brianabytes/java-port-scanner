import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

/**
 * A single threaded TCP port scanner that attempts to connect to a range of ports
 * on a target host in order to determine which ports are open.
 *
 * This implementation uses a TCP connect scan and is intended for
 * educational purposes only.
 */
public class PortScanner {	
public static void main(String[] args){
	 // Target host (localhost for safe testing)
	String host = "127.0.0.1";
	//Range of ports to scan
	int startingPort = 1;
	int endPort = 65535;
	System.out.print("Beginning scan.............\n");
	for(int port = startingPort; port <= endPort; port++)
	{
		try(Socket s = new Socket())
		{
			try {
				//try to establish a connection with a timeout
				s.connect(new InetSocketAddress(host, port));
				
				System.out.println("Port " + port + " is OPEN");
				
			  } catch (SocketTimeoutException e) {
	                // FILTERED
	            } catch (java.net.ConnectException e) {
	                // CLOSED
	            } catch (SocketException e) {
	                // PERMISSION DENIED / RESET
	            } catch (IOException e) {
	                // I/O ERRORS
	            }
	        } catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
	        }
	    }
	System.out.println("Scan is complete.");
	} 
	

}
