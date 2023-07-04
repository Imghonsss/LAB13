import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//This code made by Muhammad Imran B032120025

public class TextTranslator {
	public void createData()
	{
			// Declaration of target storage
			String MalayStorage = "Malay.txt";
			String ArabicStorage = "Arabic.txt";
			String KoreanStorage = "Korean.txt";
			
			// Declaration of stream objects to write data to  the target storage
			FileOutputStream fileOutputStreamBm; 
			FileOutputStream fileOutputStreamArb; 
			FileOutputStream fileOutputStreamKrn; 
			
			DataOutputStream dataOutputStreamBm; 
			DataOutputStream dataOutputStreamArb; 
			DataOutputStream dataOutputStreamKrn; 
			
			try
			{
				// write in Malay
				// create stream to write Malay translated text to the Malay text storage
				fileOutputStreamBm = new FileOutputStream(MalayStorage);
				dataOutputStreamBm = new DataOutputStream(fileOutputStreamBm);
				
				// write the data
				dataOutputStreamBm.writeUTF("Selamat pagi");
				dataOutputStreamBm.writeUTF("Selamat malam");
				dataOutputStreamBm.writeUTF("Apa khabar ?");
				dataOutputStreamBm.writeUTF("Terima kasih");
				dataOutputStreamBm.writeUTF("Selamat tinggal");
				dataOutputStreamBm.writeUTF("Ada apa");
				
				// clear the stream
				dataOutputStreamBm.flush();
				
				// write in Arabic
				// create stream to write Arabic translated text to the Arabic text storage
				fileOutputStreamArb = new FileOutputStream(ArabicStorage);
				dataOutputStreamArb = new DataOutputStream(fileOutputStreamArb);
				
				// write the data
				dataOutputStreamArb.writeUTF("صباح الخير");
				dataOutputStreamArb.writeUTF("طاب مساؤك");
				dataOutputStreamArb.writeUTF("كيف حالك؟");
				dataOutputStreamArb.writeUTF("شكرا لك");
				dataOutputStreamArb.writeUTF("مع السلامة");
				dataOutputStreamArb.writeUTF("ما أخبارك؟");
				
				// clear the stream
				dataOutputStreamArb.flush();
				
				// write in Korean
				// create stream to write Korean translated text to the Korean text storage
				fileOutputStreamKrn = new FileOutputStream(KoreanStorage);
				dataOutputStreamKrn = new DataOutputStream(fileOutputStreamKrn);
				
				// write the data
				dataOutputStreamKrn.writeUTF("좋은 아침");
				dataOutputStreamKrn.writeUTF("안녕히 주무세요");
				dataOutputStreamKrn.writeUTF("어떻게 지내세요 ?");
				dataOutputStreamKrn.writeUTF("감사합니다");
				dataOutputStreamKrn.writeUTF("안녕");
				dataOutputStreamKrn.writeUTF("뭐야 ?");
				
				// clear the stream
				dataOutputStreamKrn.flush();
							
				// Close all streams
				fileOutputStreamBm.close(); 
				fileOutputStreamArb.close(); 
				fileOutputStreamKrn.close(); 
				
				dataOutputStreamBm.close(); 
				dataOutputStreamArb.close(); 
				dataOutputStreamKrn.close(); 
				
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
			}
	}
	

	public String translateToBM(String text)
	{
		
		String translated = "";
		
		String path = "Malay.txt";
		
		String morning, night, howareyou, thank, bye, whatup = "";
		
		try
		{
			// create stream to read data from source file
			FileInputStream file = new FileInputStream(path);
			DataInputStream read = new DataInputStream(file);
			
			// read data
			morning = read.readUTF();
			night = read.readUTF();
			howareyou = read.readUTF();
			thank = read.readUTF();
			bye = read.readUTF();
			whatup = read.readUTF();
			
			// Conditions to parse the correspond text to the respective variable
			// based on English text input
			if(text.toUpperCase().equals("GOOD MORNING"))
			{
				translated = morning;
			}
			else if(text.toUpperCase().equals("GOOD NIGHT"))
			{
				translated = night;
			}
			else if(text.toUpperCase().equals("HOW ARE YOU") || text.toUpperCase().equals("HOW ARE YOU ?")
				|| text.toUpperCase().equals("HOW ARE YOU?"))
			{
				translated = howareyou;
			}
			else if(text.toUpperCase().equals("THANK YOU"))
			{
				translated = thank;
			}
			else if(text.toUpperCase().equals("GOODBYE"))
			{
				translated = bye;
			}
			else if(text.toUpperCase().equals("WHAT'S UP ?") || text.toUpperCase().equals("WHAT'S UP")
					|| text.toUpperCase().equals("WHAT'S UP?"))
			{
				translated = whatup;
			}
			else
			{
				translated = "Error No Related Word In Database";
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
		return translated;
	}
	

	public String translateToArb(String text)
	{
		String translated = "";
		
		// declare target storage to be read 
		String path = "Arabic.txt";
		
		// variable for storing text input of translation
		String morning, night, howareyou, thank, bye, whatup = "";
		
		try
		{
			// create stream to read data from source file
			FileInputStream file = new FileInputStream(path);
			DataInputStream read = new DataInputStream(file);
			
			// read data
			morning = read.readUTF();
			night = read.readUTF();
			howareyou = read.readUTF();
			thank = read.readUTF();
			bye = read.readUTF();
			whatup = read.readUTF();
			
			// Conditions to parse the correspond text to the respective variable
			// based on English text input
			if(text.toUpperCase().equals("GOOD MORNING"))
			{
				translated = morning;
			}
			else if(text.toUpperCase().equals("GOOD NIGHT"))
			{
				translated = night;
			}
			else if(text.toUpperCase().equals("HOW ARE YOU") || text.toUpperCase().equals("HOW ARE YOU ?")
					|| text.toUpperCase().equals("HOW ARE YOU?"))
			{
				translated = howareyou;
			}
			else if(text.toUpperCase().equals("THANK YOU"))
			{
				translated = thank;
			}
			else if(text.toUpperCase().equals("GOODBYE"))
			{
				translated = bye;
			}
			else if(text.toUpperCase().equals("WHAT'S UP ?") || text.toUpperCase().equals("WHAT'S UP"))
			{
				translated = whatup;
			}
			else
			{
				translated = "Error No Related Word In Database";
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
		return translated;
	}
	

	public String translateToKrn(String text)
	{
		String translated = "";
		
		// declare target storage to be read 
		String path = "Korean.txt";
		
		// variable for storing text input of translation
		String morning, night, howareyou, thank, bye, whatup = "";
		
		try
		{
			// create stream to read data from source file
			FileInputStream file = new FileInputStream(path);
			DataInputStream read = new DataInputStream(file);
			
			// read data
			morning = read.readUTF();
			night = read.readUTF();
			howareyou = read.readUTF();
			thank = read.readUTF();
			bye = read.readUTF();
			whatup = read.readUTF();
			
			// Conditions to parse the correspond text to the respective variable
			// based on English text input
			if(text.toUpperCase().equals("GOOD MORNING"))
			{
				translated = morning;
			}
			else if(text.toUpperCase().equals("GOOD NIGHT"))
			{
				translated = night;
			}
			else if(text.toUpperCase().equals("HOW ARE YOU") || text.toUpperCase().equals("HOW ARE YOU ?")
					|| text.toUpperCase().equals("HOW ARE YOU?"))
			{
				translated = howareyou;
			}
			else if(text.toUpperCase().equals("THANK YOU"))
			{
				translated = thank;
			}
			else if(text.toUpperCase().equals("GOODBYE"))
			{
				translated = bye;
			}
			else if(text.toUpperCase().equals("WHAT'S UP ?") || text.toUpperCase().equals("WHAT'S UP"))
			{
				translated = whatup;
			}
			else
			{
				translated = "Error No Related Word In Database";
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
		return translated;
	}
}
