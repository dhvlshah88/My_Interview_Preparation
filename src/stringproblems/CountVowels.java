package stringproblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CountVowels {

	private static int count(String inputStr){
		if(inputStr == null)
			return 0;
		
		int count = 0;
		for(char c : inputStr.toCharArray()){
			if("aeiou".indexOf(c)>=0){
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		try{
			String str=null;
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter a string: ");
			str = reader.readLine();
			System.out.println("Count: " + count(str.toLowerCase()));
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
