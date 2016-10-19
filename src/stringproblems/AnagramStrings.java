package stringproblems;

import java.util.Arrays;

public class AnagramStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		AnagramStrings strings = new AnagramStrings();
		if(strings.checkBySorting("12s3", "321s"))
			System.out.println("True");
		else
			System.out.println("False");
		
		if(strings.checkByUniqueChar("12s3", "321s"))
			System.out.println("True");
		else
			System.out.println("False");
		
	}

	
	public boolean checkBySorting(String firstStr, String secondStr)
	{
		if (firstStr == null || secondStr == null)
			return false;
			
		if (firstStr.length() != secondStr.length())
			return false;
		
		return sort(firstStr).equals(sort(secondStr));
	}
	
	
	public String sort(String unsortedStr)
	{
		char[] charArray = unsortedStr.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}
	
	protected boolean checkByUniqueChar(String firstStr, String secondStr)
	{
		if (firstStr == null || secondStr == null)
			return false;
		
		if (firstStr.length() != secondStr.length())
			return false;
		
		int uniqueCharCount = 0, uniqueCharParsed = 0;
		int[] characters = new int[256];
		
		for(char character : firstStr.toCharArray())
		{
			if(characters[character] == 0)
				++uniqueCharCount;
			
			characters[character]++;
		}
		
		for(int i = 0; i < secondStr.length(); i++)
		{
			int index = (int)secondStr.charAt(i);
		
			if(characters[index] == 0)
				return false;
			
			characters[index]--;
			if(characters[index] == 0)
			{
				uniqueCharParsed++;
				
				if(uniqueCharCount == uniqueCharParsed)
					return i == firstStr.length() - 1;
			}
			
		}
		
		return false;
	}
	
	
	
	
}
