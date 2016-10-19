package datastructures.arrays;

/*
 * Problem : Given a sorted integer array and an integer k, find two numbers which sum upto k.
 */

public class SumUpToKForSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arrNumber = {1,2,3,4,6,7,9,10,11,12,14,16,18,20};	
		printNumberThatSumToK(arrNumber, 16);
	}
	
	private static void printNumberThatSumToK(int[] arrNumber, int k){
		int startIndex = 0;
		int endIndex = arrNumber.length - 1;
		
		while(startIndex<endIndex){
			int sum = arrNumber[startIndex] + arrNumber[endIndex];
			
			if(sum == k){
				System.out.println(arrNumber[startIndex] + " + " + arrNumber[endIndex] + " = " + k);
				startIndex++;
				endIndex--;
			}
			
			if(sum<k){
				startIndex++;
			}
			
			if(sum>k){
				endIndex--;
			}
		}
		
	}

}
