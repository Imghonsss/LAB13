import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//This code made by Muhammad Imran B032120025

public class WordCountApplicationServer {
	
public static void main(String[] args) throws IOException {
		
		// Launch the server frame
		WordCountFrameServer serverFrame = new WordCountFrameServer();
		serverFrame.setVisible(true);
		
		// 1. Binding to a port number, 1234 that enables for connection
		int portNo = 1234;
		
		ServerSocket serverSocket = new ServerSocket(portNo);
		
		WordCountGenerator wordGenerator = new WordCountGenerator();
		
		// Counter to keep track the number of requested connection
		int totalRequest = 0;
		
		// 2. Listen continuously for request of connection
		// Server needs to be alive forever in unterminated while loop
		while (true) {
			
			// Message to indicate server is alive
			serverFrame.updateServerStatus(false);
			
			// 3. Accept client request for connection
			Socket clientSocket = serverSocket.accept();
			
			// 4. Process request
			// Generate word count for a text
			int output = wordGenerator.getWordCount();
			
			// 5. Respond to the client
			// code: clientSocket.getOutputStream()
			
			// Create stream to write data on the network
			DataOutputStream outputStream = 
					new DataOutputStream(clientSocket.getOutputStream());
			
			// Send word count back to the client
			outputStream.writeBytes(String.valueOf(output));
			
			// Close the socket
			clientSocket.close();
		
			// Update the request status
			serverFrame.updateRequestStatus(
					"Data sent to the client: " + output);
			serverFrame.updateRequestStatus("Accepted connection to from the "
					+ "client. Total request = " + ++totalRequest );
			
		}
		
		

	}
}
