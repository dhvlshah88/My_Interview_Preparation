package algorithms.dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	  public static int[] getLIS(int[] nums) {
		 
	    int len = nums.length;    

	    int[] lenOfIS = new int[len];
	    Arrays.fill(lenOfIS, 1);
	 
	    int[] pred = new int[len];
	    Arrays.fill(pred, -1);
	    
	    // O(n^2) complexity
	    for (int i = 1; i < len; i++) {
	      for (int j = 0; j < i; j++) {
	        if (nums[j] < nums[i] && lenOfIS[i] < lenOfIS[j] + 1) {
	          lenOfIS[i] = lenOfIS[j] + 1;
	          pred[i] = j;
	        }
	      }
	    }
	    
	    // find a value with max length of increasing subsequence.
	    int maxLen = 0;
	    for (int i = 0; i < len; i++) {
	      maxLen = Math.max(lenOfIS[i], maxLen);
	    }
	    System.out.println("Lenght of Longest Increasing Subsequence: " + maxLen);
	    
	    int maxLenIndex = 0;
	    for (int i = 0; i < len; i++) {
	      if (lenOfIS[maxLenIndex] < lenOfIS[i]) {
		  maxLenIndex = i;
	      }
	    }
	    
	    int[] res = new int[maxLen];
	    for (int i = maxLenIndex; i != -1; i = pred[i]) {
	      res[--maxLen] = nums[i];
	    }
	    
	    return res;
	  }

	  public static void main(String[] args) {
	    int[] a = { 10, 9, 2, 5, 3, 7, 101, 18};
	    int[] lis = getLIS(a);
	    
	    System.out.println(Arrays.toString(lis));
	  }
}
