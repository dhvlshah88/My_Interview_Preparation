package stringproblems;

import java.util.*;

public class WordBreak {

	private static HashSet<String> validStrings = new HashSet<>();
	private static List<String> validSubstringList = new ArrayList<>(Arrays.asList("leanplum", "leanplums", "start", "tart", "party", "part"));

	public static void main(String[] args) {
		String jumbledString = "leanplumstartparty";
		
		getValidWords(jumbledString, jumbledString.length(), "");
		
		System.out.println(Arrays.deepToString(validStrings.toArray()));
	}

	public static void getValidWords(String sentence, int len, String result) {
		if (sentence == null || sentence.isEmpty())
			return;

		for (int i = 0; i <= len; i++) {
			String subStr = sentence.substring(0, i);

			if (validSubstringList.contains(subStr)) {
				if (i == len) {
					result +=subStr;
					System.out.println(result);
					validStrings.add(result);
				}

				getValidWords(sentence.substring(i, len), len - i, result+subStr+" ");
			}   
		}
	}

}