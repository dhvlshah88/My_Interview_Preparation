package datastructures.arrays;

public class SubarrayProblem {
    
    /*
     	Given an array of integers find the length of the longest subarray of consecutive numbers.
  	With "consecutive" meaning that they are sorted and difference with the next integer, if exists, is exactly 1.

  	Examples:
  	{1, 5, 4, 5, 6} -> 3
         	   ^  ^  ^
 
  	{8, 9, 0, -1, 0, 1, 2, -7} -> 4
     			^   ^   ^   ^	
     */
    
    public static int longestSubarrayOfConsecutiveArray(int[] nums) {
	if (nums == null || nums.length == 0)
	    return 0;
	
	int currentLen = 0;
	int longestLen = 0;
	
	for (int i  = 0; i < nums.length -1; i++) {
	    if (nums[i] < nums[i+1] && nums[i+1] - nums[i] == 1) {
		currentLen++;
		longestLen = Math.max(currentLen, longestLen);
	    } else {
		currentLen = 0;
	    }
	}
	
	return ++longestLen;
    }

    public static void main(String[] args) {
	int[] nums = {8, 9, 0, -1, 0, 1, 2, -7};
	
	int result = SubarrayProblem.longestSubarrayOfConsecutiveArray(nums);
	System.out.println("Length of longest subarray: " + result);
    }

}
