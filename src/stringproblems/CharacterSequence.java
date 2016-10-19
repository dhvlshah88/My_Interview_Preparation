package stringproblems;

public class CharacterSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// System.out.println(CharacterSequence.encode("aabbccaaddd"));

		matchWithWildCard("g*ks", "geeks"); // Yes
		matchWithWildCard("ge?ks*", "geeksforgeeks"); // Yes
		matchWithWildCard("g*k", "gee"); // No because 'k' is not in second
		matchWithWildCard("*pqrs", "pqrst"); // No because 't' is not in first
		matchWithWildCard("abc*bcd", "abcdhghgbcd"); // Yes
		matchWithWildCard("abc*c?d", "abcd"); // No because second must have 2
												// instances of 'c'
		matchWithWildCard("*b*d", "abcd"); // Yes
		matchWithWildCard("*?c*d", "abccd"); // Yes
		matchWithWildCard("*", ""); // No

		System.out.println(CharacterSequence.isMatch("*", "hello.txt"));
		System.out.println(CharacterSequence.isMatch("he*", "hello.txt"));
		System.out.println(CharacterSequence.isMatch("*txt", "hello.txt"));
		System.out.println(CharacterSequence.isMatch("he*xt", "hello.txt"));
		System.out.println(CharacterSequence.isMatch("xx*", "hello.txt"));

		System.out.println(lcs("thisisatest", "testing123testing"));
	}

	public static String lcs(String a, String b) {
		int aLen = a.length();
		int bLen = b.length();

		if (aLen == 0 || bLen == 0) {
			return "";
		} else if (a.charAt(aLen - 1) == b.charAt(bLen - 1)) {
			return lcs(a.substring(0, aLen - 1), b.substring(0, bLen - 1)) + a.charAt(aLen - 1);
		} else {
			String x = lcs(a, b.substring(0, bLen - 1));
			String y = lcs(a.substring(0, aLen - 1), b);
			return (x.length() > y.length()) ? x : y;
		}
	}

	public static String encode(String normalString) {
		char letter = normalString.charAt(0);
		int letterCount = 1;
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < normalString.length(); i++) {
			if (letter == normalString.charAt(i)) {
				++letterCount;
			} else {
				sb.append(letter + "" + letterCount);
				letter = normalString.charAt(i);
				letterCount = 1;
			}
		}
		sb.append(letter + "" + letterCount);

		return sb.toString();
	}

	public static void matchWithWildCard(String str1, String str2) {
		System.out.println("Ans: " + matchWithWildCard(str1, str2, 0, 0));
	}

	public static boolean matchWithWildCard(String str1, String str2, int index1, int index2) {
		int len1 = str1.length();
		int len2 = str2.length();

		if (len1 == index1 && len2 == index2 && (str1.indexOf('?') != -1 || str1.indexOf('*') != -1))
			return true;

		if (index1 >= len1 || index2 >= len2)
			return false;

		if (str1.charAt(index1) == '*' && len1 == (index1 + 1) && len2 == index2)
			return false;

		if (str1.charAt(index1) == '?' || str1.charAt(index1) == str2.charAt(index2))
			return matchWithWildCard(str1, str2, ++index1, ++index2);

		if (str1.charAt(index1) == '*')
			return (matchWithWildCard(str1, str2, index1, ++index2) || matchWithWildCard(str1, str2, ++index1, index2));

		return false;
	}

	private static boolean isMatch(String patternStr, String inputStr) {
		int starIndex = patternStr.indexOf("*");
		if (starIndex < 0)
			throw new IllegalArgumentException("Please check the arguments!");

		else if (patternStr.length() == 1)
			return true;

		String prefix = patternStr.substring(0, starIndex);
		String suffix = patternStr.substring(starIndex + 1);

		boolean prefixCorrect = false, suffixCorrect = false;

		if (prefix == "" || inputStr.startsWith(prefix))
			prefixCorrect = true;

		if (suffix == "" || inputStr.endsWith(suffix))
			suffixCorrect = true;

		return prefixCorrect && suffixCorrect;
	}

}
