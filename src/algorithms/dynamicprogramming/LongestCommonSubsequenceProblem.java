package algorithms.dynamicprogramming;

public class LongestCommonSubsequenceProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {	    
	    LongestCommonSubsequenceProblem lcs = new LongestCommonSubsequenceProblem();
	    String str1 = "ABCDGHLQR";
	    String str2 = "AEDPHR";
	    
	    String lcsStr = lcs.longestCommonSubsequence(str1, str2);
	    System.out.println("Subsequence is " + lcsStr);
	    
	    int lcsLen = lcs.lengthOfLongestCommonSubsequence(str1, str2);
	    System.out.println("Length of LCS is " + lcsLen);	    
	}
	
	public String longestCommonSubsequence(String a, String b) {
	    int[][] lengths = new int[a.length()+1][b.length()+1];
	 
	    // row 0 and column 0 are initialized to 0 already
	    for (int i = 0; i < a.length(); i++)
	        for (int j = 0; j < b.length(); j++)
	            if (a.charAt(i) == b.charAt(j))
	                lengths[i+1][j+1] = lengths[i][j] + 1;
	            else
	                lengths[i+1][j+1] =
	                    Math.max(lengths[i+1][j], lengths[i][j+1]);
	 
	    System.out.println("Length of LCS is " + lengths[a.length()][b.length()]);
	    
	    // read the substring out from the matrix
	    StringBuffer sb = new StringBuffer();
	    for (int x = a.length(), y = b.length();
	         x != 0 && y != 0; ) {
	        if (lengths[x][y] == lengths[x-1][y])
	            x--;
	        else if (lengths[x][y] == lengths[x][y-1])
	            y--;
	        else {
//	            assert a.charAt(x-1) == b.charAt(y-1);
	            sb.append(a.charAt(x-1));
	            x--;
	            y--;
	        }
	    }
	 
	    return sb.reverse().toString();
	}
	
	public  int lengthOfLongestCommonSubsequence(String a, String b) {
	    int m = a.length();
	    int n = b.length();
	
	    int lengths[][] = new int[m+1][n+1];
	    for (int i = 1; i <= m; i++) {
		for (int j = 1; j<= n; j++) {
		    if (a.charAt(i-1) == b.charAt(j-1)) {
			lengths[i][j] = lengths[i-1][j-1] +1;
		    } else {
			lengths[i][j] = Math.max(lengths[i-1][j], lengths[i][j-1]);
		    }
		}
	    }

	    return lengths[m][n];
	}
}
