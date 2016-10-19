package datastructures.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class ArrayExamples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		
		int[] array = {6, 1, 3, 2, 10, 14, 50};
		ArrayExamples.isValuesSumEqualToIndicesSum(array);
		
		int[] nums = {2, 3, 1, 4, 3, 2};
		ArrayExamples.productOfWholeArray(nums);

	}
	
	private static boolean isValuesSumEqualToIndicesSum(int[] array)
	{
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<array.length; i++)
		{
			int diff = array[i] - i;
			
			if(map.containsKey(diff))
			{
				int existingIndex = map.get(diff);
				System.out.println("Sum of values: " + array[existingIndex] + " & " + array[i] + " is equal to sum of indices: " + existingIndex + " & " + i);
				return true;
			}
			else
			{
				map.put(-diff, i);
			}
		}
		 
		return false;
	}
	
	
	private static void productOfWholeArray(int[] nums) {
	    int totalProduct = 1;
	    
	    for (int i : nums) 
		totalProduct *= i;
	    
	    int[] productExcluding = new int[nums.length];
	    for (int i = 0; i < nums.length; i++) {
		productExcluding[i] = totalProduct / nums[i];
	    }
	    
	    System.out.println(Arrays.toString(productExcluding));
	}

}
