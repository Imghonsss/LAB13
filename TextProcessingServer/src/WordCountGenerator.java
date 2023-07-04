import java.util.Date;

//This code made by Muhammad Imran B032120025

public class WordCountGenerator {
	public WordCountGenerator()
	{
		
	}

	public int getWordCount() {
		
		String input = "Hello I am Muhammad Imran from BITS S2G1."; // The Input Words   
		
		 if (input == null || input.isEmpty()) {
		      return 0;
		    }

		 String[] words = input.split("\\s+");
		 return words.length;
		
	}
}
