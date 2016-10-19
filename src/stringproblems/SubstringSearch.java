package stringproblems;

import java.util.HashMap;

public class SubstringSearch {

    private int[] preProcessPattern(char[] pattern) {

	int[] temp = new int[pattern.length];
	int index = 0;

	for (int i = 1; i < pattern.length;) {
	    if (pattern[i] == pattern[index]) {
		temp[i] = ++index;
		i++;
	    } else {
		if (index != 0) {
		    index = temp[index - 1];
		} else {
		    temp[i] = 0;
		    i++;
		}
	    }
	}

	return temp;
    }

    public boolean KMP(String text, String pattern) {

	int[] temp = preProcessPattern(pattern.toCharArray());
	int i = 0;
	int j = 0;

	while (i < text.length() && j < pattern.length()) {
	    if (text.charAt(i) == pattern.charAt(j)) {
		i++;
		j++;
	    } else {
		if (j != 0) {
		    j = temp[j - 1];
		} else {
		    i++;
		}
	    }

	    if (j == pattern.length()) {
		return true;
	    }
	}

	return false;
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
	return lengthOfLongestSubstringKDistinct(s, 2);
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
	if (s.length() < 1 || k == 0)
	    return 0;

	// This approach tracks total number of occurence of at most two distint
	// characters.

	//	int max = 0;
	//	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	//	int start = 0;
	//
	//	for (int i = 0; i < s.length(); i++) {
	//	    char c = s.charAt(i);
	//	    map.put(c, map.getOrDefault(c, 0) + 1);
	//
	//	    while (map.size() > 2) {
	//		char leftChar = s.charAt(start);
	//		int count = map.get(leftChar);
	//
	//		if (count > 1) {
	//		    map.put(leftChar, count-1);
	//		}
	//
	//		if (count == 0) {
	//		    map.remove(leftChar);
	//		}
	//
	//		start++;
	//	    }
	//
	//	    max = Math.max(max, i - start + 1);
	//	}
	//
	//	return max;

	int lo = 0, hi = 0, maxLen = 0;
	int leftMostIndex;
	HashMap<Character, Integer> indexMap = new HashMap<>();

	while (hi < s.length()) {
	    if (indexMap.size() <= k) {
		char c = s.charAt(hi);
		indexMap.put(c, hi);
		hi++;
	    }

	    if (indexMap.size() > k) {
		leftMostIndex = s.length();
		for (int index : indexMap.values()) {
		    leftMostIndex = Math.min(leftMostIndex, index);
		}
		char leftChar = s.charAt(leftMostIndex);
		indexMap.remove(leftChar);
		lo = leftMostIndex + 1;
	    }

	    maxLen = Math.max(maxLen, hi - lo);
	}

	return maxLen;
    }

    public static void main(String[] args) {
	String str = "abcxabcdabcdabcyabcdabcy";
	String subString = "abcdabcy";
	SubstringSearch ss = new SubstringSearch();
	boolean result = ss.KMP(str, subString);
	System.out.println(result);

	System.out.println(ss.lengthOfLongestSubstringTwoDistinct("abcbbbbcccbdddadacb"));

	System.out.println(ss.lengthOfLongestSubstringKDistinct("abcbbbbcccabdddadacb", 3));

    }

}
