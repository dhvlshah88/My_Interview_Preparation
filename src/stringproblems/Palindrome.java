package stringproblems;

public class Palindrome {
	
	private String word = null;
	
	public void setString(String word){
		this.word = word;
	}
	
	public String getString(){
		return this.word;
	}
	
	public boolean isPalindrome(String word){
		
		boolean isStringPalindrome = false;
		String tempString;
		//StringBuilder secondHalf = null;
		
		if(word.isEmpty() || word.contains(".*\\d.*")){
			return isStringPalindrome;
		}
		
		tempString = word.toLowerCase();
		int strLen = tempString.length();
		
		int mid = (strLen - 1) >> 1;
		
		if(strLen%2 == 0)
			isStringPalindrome = expandThruCenter(tempString, mid, mid+1);
		else
			isStringPalindrome = expandThruCenter(tempString, mid, mid);
		
		//isStringPalindrome = true;
		return isStringPalindrome;
	}
	
	public boolean expandThruCenter(String str, int ctr1, int ctr2)
	{
		int l = ctr1, r = ctr2;
		int count = 0;
		int len = str.length();
		
		while(l>=0 && r<len && str.substring(l, l).equals(str.substring(r, r)))
		{
			--l;
			++r;
			++count;
		}
		
		return count == ctr1+1;
	}
	
	public String longestPalindromeSubstring(String s) {
		
		if (s.isEmpty() || s.length() == 1) {
			return s;
		}
	 
		String longest = s.substring(0, 1);
		
		for (int i = 0; i < s.length(); i++) {
		
			// get longest palindrome with center of i
			String tmp = helper(s, i, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
	 
			// get longest palindrome with center of i, i+1
			tmp = helper(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
	 
		return longest;
	}
	 
	// Given a center, either one letter or two letter,  find longest palindrome
	public String helper(String s, int begin, int end) {
		while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
	}
	
}
