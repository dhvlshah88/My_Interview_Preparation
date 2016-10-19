package stringproblems;

public class ReverseString {

	public static void main(String[] args) {
		System.out.println(recurreverseSentence("This is test string"));
		System.out.println(recurreverse("11001101"));
	}
	
	public static String recurreverse(String string) {
		if (string == null || string.isEmpty())
			return "";
		
		int last_index = string.length() - 1;
		if (last_index == 0)
			return string;
		
		return string.substring(last_index) + recurreverse(string.substring(0, last_index));
	}

	public static String reverseUsingStringBuilder(String sentence) {
		return new StringBuilder(sentence).reverse().toString();
	}
	
	public static String reverseSentence(String sentence) {
		if(sentence == null)
			return null;
		
		String[] arrayOfWords = sentence.split(" ");
		StringBuilder revSentence = new StringBuilder();
		for(int i = arrayOfWords.length - 1; i>=0; i--) {
			revSentence.append(arrayOfWords[i]);

			if(i!= 0)
				revSentence.append(" ");
		}

		return revSentence.toString();
	}
	
	public static String recurreverseSentence(String sentence) {
		   int k = sentence.indexOf(" ");
		   return k == -1 ? sentence : recurreverseSentence(sentence.substring(k + 1)) + " " + sentence.substring(0, k);
	}
	
}
