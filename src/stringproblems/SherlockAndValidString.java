package stringproblems;

import java.util.*;


public class SherlockAndValidString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	       
//	       char[] temp  = "jtqgugmcsxvdwidtcyqpogkdifapuloqykjfxruvfrshcehekoiwbpbrprahwvhliglyxynjotbaswnnnmxbkmcftvsdqajemeul".toCharArray();
//	       Arrays.sort(temp);
//	       System.out.println(temp);
//	       
	       String ans = SherlockAndValidString.isValid("aabbcd");
	        System.out.println(ans);
	}

	public static String isValid(String s) {
		if (s.isEmpty())
				throw new IllegalArgumentException("s is empty!");
		
		if (s.length() == 1)
			return "YES";
		
		char[] temp = s.toCharArray();
		Arrays.sort(temp);
		String sortedString = new String(temp);
		
		Queue<String> q = new LinkedList<String>();
		q.add(sortedString);
		
		char alreadyOccuredChar = 0;
		for (int i =0 ; i < sortedString.length(); i++) {
			if (alreadyOccuredChar != sortedString.charAt(i)) {				
				alreadyOccuredChar = sortedString.charAt(i);
				q.add(sortedString.substring(0, i) + sortedString.substring(i+1, sortedString.length()));
			}
		}
		
		while (!q.isEmpty()) {
			if (isNewStringValid(q.poll())) {
				return "YES";
			}
		}
		
		return "NO";
	}
	
	public static boolean isNewStringValid(String modifiedStr) {
		int[] alpha = new int[26];
		for (int i =0; i < 26; i++){
			alpha[i] = 0;
		}
		
		int max = Integer.MIN_VALUE;
		for (char singleChar : modifiedStr.toCharArray()) {
			int index = singleChar - 'a'; 
			alpha[index]++;
			max = Math.max(alpha[index], max);
		}
		
		for (int i = 0; i < 26; i++) {
			if (alpha[i] == 0) 
				continue;
		}
		
		return (modifiedStr.length()  % max) == 0;
	}
}
