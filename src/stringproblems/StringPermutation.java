package stringproblems;

import java.util.*;

public class StringPermutation {

	// print N! permutation of the characters of the string s
	public static void recursivePermutation(String s) {	
		List<String> list = new LinkedList<>();
		recursivePermutation("", s, list);
		System.out.println(Arrays.deepToString(list.toArray()));
	}

	private static void recursivePermutation(String prefix, String s, List<String>list) {
		int N = s.length();
		
		if (N == 0) 
		    list.add(prefix);
		else {
			for (int i = 0; i < N; i++) {
				recursivePermutation(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1), list);
			}
		}
	}

	// print N! permutation of the characters of the string s (in order)
	public static void sortedPermutation(String s) {	
		TreeSet<String> ts = new TreeSet<>();
		sortedPermutation("", s, ts);
		System.out.println(Arrays.deepToString(ts.toArray()));
	}
		
	private static void sortedPermutation(String prefix, String s, TreeSet<String> ts) {
		int N = s.length();
		
		if (N == 0) 
			ts.add(prefix);
		else {
			for (int i = 0; i < N; i++) {
				if (prefix.length() > 0)
					ts.add(prefix);
				sortedPermutation(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1), ts);
			}
		}
	}
	
	public static void nonOverlappingPairs(String s) {
	    List<String> list = new ArrayList<>();
	    patternPermutation("", s, list);
	}
	
	private static void patternPermutation(String prefix, String s, List<String> list) {
	    StringBuilder strBuilder = new StringBuilder();
	    strBuilder.append("(");
	    strBuilder.append(s);
	    strBuilder.append(")");
	    
	    for (int i = 0; i < s.length(); i++) {
		String newPrefix = prefix + s.charAt(i);
		String newString = strBuilder.append("(" + newPrefix + ")").toString();
		list.add(newString);
		patternPermutation(newPrefix, s.substring(i), list);
	    }
	}
	
	// print N! permutation of the elements of array a (not in order)
	public static void permutation(String s) {
	    List<String> list = new LinkedList<>();
	    permutation(s.toCharArray(), s.length(), list);
	    System.out.println(Arrays.deepToString(list.toArray()));
	}

	private static void permutation(char[] a, int n, List<String>list) {
		if (n == 1) {
			list.add(String.valueOf(a));
			return;
		}
		for (int i = 0; i < n; i++) {
			// System.out.println("Before swap one:" + String.valueOf(a));
			swap(a, i, n - 1);
			// System.out.println("After swap one:" + String.valueOf(a));
			permutation(a, n - 1, list);
			// System.out.println("After perm2:" + String.valueOf(a));
			swap(a, i, n - 1);
			// System.out.println("After swap two:" + String.valueOf(a));
		}
	}

	// swap the characters at indices i and j
	private static void swap(char[] a, int i, int j) {
		if (i == j)
			return;

		char c;
		c = a[i];
		a[i] = a[j];
		a[j] = c;
	}

	public static void upperLowerCasePermutation(String word) {
		for (String variant : getAllCases(word)) {
			System.out.println(variant);
		}
	}

	public static String[] getAllCases(String word) {
		int len = word.length();
		int combinations = (int) Math.pow(2, len);
		String[] variants = new String[combinations];

		for (int i = 0; i < combinations; i++) {
			variants[i] = getCase(i, word.toCharArray(), len);
		}

		return variants;
	}

	public static String getCase(int n, char[] letters, int len) {
		char[] modified = new char[len];
		for (int i = 0; i < len; i++) {
			int bitmask = (int) Math.pow(2, i);

			if ((bitmask & n) == bitmask)
				modified[i] = Character.toUpperCase(letters[i]);
			else
				modified[i] = Character.toLowerCase(letters[i]);
		}

		return new String(modified);
	}

	public static void main(String[] args) {
		String alphabet = "abc";
		
		System.out.println("Permutations of input string: ");
		recursivePermutation(alphabet);
		System.out.println();
		
		System.out.println("Sorted Permutations of input string: ");
		sortedPermutation(alphabet);
		System.out.println();
		
		System.out.println("Permutations of input string using swap method: ");
		permutation(alphabet);
		System.out.println();
		upperLowerCasePermutation("word");
	}

}
