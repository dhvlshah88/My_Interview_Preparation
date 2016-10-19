package stringproblems;

public class StringInterleavingPermutation {
    
    public void interleaving(String str1, int len1, String str2,  int len2, char result[], int resultLen) {
	if (resultLen == result.length) {
	    for (char c : result) 
		System.out.print(c);
	   
	    System.out.println();
	    return;
	}
	
	if (len1 < str1.length()) {
	    result[resultLen] = str1.charAt(len1);
	    interleaving(str1, len1+1, str2, len2, result, resultLen+1);
	}
	
	if (len2 < str2.length()) {
	    result[resultLen] = str2.charAt(len2);
	    interleaving(str1, len1, str2, len2+1, result, resultLen+1);
	}
    }

    public static void main(String[] args) {
	StringInterleavingPermutation interleavingPerm = new StringInterleavingPermutation();
	String str1 ="ABC";
        String str2 = "DE";
        char[] result = new char[str1.length() + str2.length()];
        interleavingPerm.interleaving(str1, 0, str2, 0, result, 0);
    }

}
