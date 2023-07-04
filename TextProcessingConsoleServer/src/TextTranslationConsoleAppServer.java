import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//This code made by Muhammad Imran B032120025

public class TextTranslationConsoleAppServer {
	public static void main (String [] args) throws IOException
	{
		ServerSocket serverSocket = null;
		TextTranslator translate = new TextTranslator();
		
		// create data from TextTranslator.java using stream
		translate.createData();

				try
				{
					int totalRequest = 0;
					int portNo = 6789;
					serverSocket = new ServerSocket(portNo);

					while (true) {

						Socket clientSocket = serverSocket.accept();

						DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());

						String text = inputStream.readUTF();
						int languageChoice = inputStream.readInt();
						String language = "";
						String translated = "";
						
						// if client input target language is Malay
						if(languageChoice == 1)
						{
							// parse the text for Malay translation 
							language = "Malay";
							translated = translate.translateToBM(text);
						}
						// else if client input target language is Arabic
						else if(languageChoice == 2)
						{
							// parse the text for Arabic translation 
							language = "Arabic";
							translated = translate.translateToArb(text);
						}
						// else if client input target language is Korean
						else if(languageChoice == 3)
						{
							// parse the text for Korean translation 
							language = "Korean";
							translated = translate.translateToKrn(text);
						}
						
						//Create stream to write data on the network
						DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
						
						//send current text back to the client
						outputStream.writeUTF(translated);
						
						// update and display the request status
						System.out.println("Data sent to the client: " + text + " is translated to " + language);
						System.out.println("Accepted connection to from the " + "client. Total request = " + ++totalRequest);
						
						text = "";
						language = "";
						
						
						clientSocket.close();
						
					}
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
	}
		
}
