package stringproblems;

import java.util.StringTokenizer;

public class StringTokenizerExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String line = "do not understand you";
		System.out.println(StringTokenizerExample.capitalizeEveryWord(line));
	}
	
	public static String capitalizeEveryWord(String sentence)
	{
		if (sentence == null || sentence.length() == 0)
			throw new IllegalArgumentException();
		
		String token = "";
		StringTokenizer st = new StringTokenizer(sentence);
		StringBuilder sb = new StringBuilder();
		
		while(st.hasMoreElements()){
			token = st.nextToken();
			//System.out.println(token);

			token = Character.toUpperCase(token.charAt(0)) + token.substring(1);
			//System.out.println(token);
			
			sb.append(token);
			sb.append(" ");
		}
		
		return sb.toString();
	}
	
}
