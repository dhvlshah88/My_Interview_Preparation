package stringproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class Solution {
	String str1, str2;
	
	public String longestCommonPrefix(String[] strs) 
	{
		int noOfStrings = strs.length;
		if(noOfStrings == 0) 
			return "";

		int i = 0;

		for(i=0; i<strs[0].length(); i++) {
			char c = strs[0].charAt(i);

			for(int j=1; j<strs.length; j++) {
				if(i >= strs[j].length() || strs[j].charAt(i) != c) 
					return strs[0].substring(0,i);
			}
		}
		return strs[0].substring(0,i);
	}

	public static String sortChars(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}   

	public static ArrayList<String> groupListOfAnagrams(String[] strs) {

		ArrayList<String> res = new ArrayList<String>();
		Hashtable<String, ArrayList<String>> hash = new Hashtable<String, ArrayList<String>>();

		/* Group words by anagram */
		for (String s : strs) {
			String key = sortChars(s); 
			if (!hash.containsKey(key)) {
				hash.put(key, new ArrayList<String>());
			}   
			ArrayList<String> anagrams = hash.get(key);
			anagrams.add(s);
		} 

		for (String key : hash.keySet()) {
			ArrayList<String> list = hash.get(key);
			if (list.size() > 1) 
				res.addAll(list);   
		}

		return res;
	}

	public boolean isWildcardMatch(String str1, String str2 ) {
		this.str1 = str1;
		this.str2 =str2;
		
		return isMatchRecursive(0, 0);
	}
	
	public boolean isMatchRecursive(int i, int j) {
		System.out.println("i: " + i + " j: " + j);
		while (i == this.str1.length() && (secondStrCharAt(j) == '*'  || secondStrCharAt(j+1) == '*')) 
			j++;
		
		//Return true if both strings are of same length and strings has been traverses entirely.  
		if (i == this.str1.length() && j == this.str2.length()) 
			return true;
		
		// Return false when both strings are of different length.
		if (i == this.str1.length() || j == this.str2.length())
			return false;
		
		if (secondStrCharAt(j+1) == '*' && (secondStrCharAt(j) == '.' || this.str1.charAt(i) == this.str2.charAt(j))) {
			System.out.println("i: " + i + " j: " + (j+2) + "      " + "i: " + (i+1) + " j: " + j);
			return isMatchRecursive(i, j+2) || isMatchRecursive(i+1, j);
		}
		
		if (secondStrCharAt(j+1) == '*') 
			return isMatchRecursive(i, j+2);
				
		if (this.secondStrCharAt(j) == '.'  || this.str1.charAt(i) == this.str2.charAt(j)) 
			return isMatchRecursive(i+1, j+1);
		
		return false;
	}
	
	public char secondStrCharAt(int k) {
		if (k < 0 || k >= str2.length()) 
			return '\0';
		return this.str2.charAt(k);
	}
	
	public void decode(String prefix, String code, Set<String> set) {
		if (code.isEmpty() || code.charAt(0) == '0') {
			set.add(prefix);
			return;
		}
			
		decode(prefix + (char) (code.charAt(0) - '1' + 'a'), code.substring(1), set);
		
		if (code.length() >= 2 && code.charAt(0) == '1') {
			decode(prefix + (char) (10 + code.charAt(1) - '1' + 'a'), code.substring(2), set);
		}
		
		if (code.length() >= 2 && code.charAt(0) == '2' && code.charAt(1) <= '6') {
			decode(prefix + (char) (20 + code.charAt(1) - '1' + 'a'), code.substring(2), set);
		}
}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		String[] arrOfStr = {"cat", "star", "act", "god", "arts", "rats", "dog"};
//		
//		for(String str : groupListOfAnagrams(arrOfStr))
//			System.out.println(str + ", ");
		
		Solution s  = new Solution();
//		boolean ans = s.isWildcardMatch("aabbefcd", "aabb.*cd");
//		if (ans)
//			System.out.println("TRUE");

		Set<String> outputList = new HashSet<>();
		s.decode("", "1120", outputList);
		for (String str : outputList) 
			System.out.println(str);
	}

}
