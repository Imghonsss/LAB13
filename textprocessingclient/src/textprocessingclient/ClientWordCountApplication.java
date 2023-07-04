package textprocessingclient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//This code made by Muhammad Imran B032120025
public class ClientWordCountApplication {
	public static void main(String[] args) 
			throws UnknownHostException, IOException {
		
		ClientWordCountFrame clientWordFrame = new ClientWordCountFrame();
		clientWordFrame.setVisible(true);
		
		Socket socket = new Socket(InetAddress.getLocalHost(), 1234);

		clientWordFrame.updateConnectionStatus(socket.isConnected());
		
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		
		
		String wordCountNumber = bufferedReader.readLine();
		
		clientWordFrame.updateServerWordCount(wordCountNumber);
		
		bufferedReader.close();
		socket.close();

	}
}
