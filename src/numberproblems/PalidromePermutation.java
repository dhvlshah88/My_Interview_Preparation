package numberproblems;

public class PalidromePermutation {
    
    /*
     * Write an efficient function that checks whether any permutation of an input string is a palindrome.
     */
    public static  boolean canPermutePalidrome (String s) {
	if (s == null || s.isEmpty())
	    	return false;
	
	int[] charOccurence = new int[128];
	for (char c : s.toLowerCase().toCharArray()) {
	    charOccurence[(int)c]++;
	}
	
	int count = 0;
	for (int i : charOccurence) {
	    if (i %2 == 1) {
		count++;
	    }
	}
	
	if (count > 1)
	    return false;
	
	return true;
    }
    
    public static void main(String[] args) {
	boolean ans = PalidromePermutation.canPermutePalidrome("A ruban abura");
	System.out.println(ans ? "True" : "False");
    }

}
