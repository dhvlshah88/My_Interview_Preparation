package stringproblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Words {

	public static void main(String[] args)
	{
		try
		{
			readFile(args[0]);			
		}
		catch(IOException ex)
		{
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	public static void readFile(String filePath) throws IOException
	{
	
		String currentLine = "";
		try(BufferedReader reader = new BufferedReader(new FileReader(filePath)))
		{
			System.out.println("Iterative Approach");
			
			while((currentLine = reader.readLine()) != null)
			{
				System.out.println(reverseSentence(currentLine));
			}
		
		}
		
		
		currentLine = "";
		try(BufferedReader reader = new BufferedReader(new FileReader(filePath)))
		{
			System.out.println("Recursive Approach");
		
			while((currentLine = reader.readLine()) != null)
			{
				System.out.println(recurreverseSentence(currentLine));
			}
		
		}
	
	}

	//Iterative solution to reverse words.
	public static String reverseSentence(String sentence)
	{
		if(sentence == null)
			return null;
		
		String[] arrayOfWords = sentence.split(" ");
		StringBuilder revSentence = new StringBuilder();
		for(int i = arrayOfWords.length - 1; i>=0; i--)
		{
			revSentence.append(arrayOfWords[i]);

			if(i!= 0)
				revSentence.append(" ");
		}
		
		
		/*for(String word : sentence.split("\\s"))
		{
			revSentence = word + " " + revSentence;
		}*/
			
		return revSentence.toString();
	}
	
	//Recursive solution to reverse words
	public static String recurreverseSentence(String sentence) 
	{
		if(sentence == null)
			return null;
	
	
		int k = sentence.indexOf(" ");
		return k == -1 ? sentence : recurreverseSentence(sentence.substring(k + 1)) + " " + sentence.substring(0, k);
		
	}

}
