package datastructures.arrays;

import java.util.HashSet;

public class SumUpToForUnsortedArray {
	
	public static void main(String[] args) {
		int[] arrNumber = {6,7,8,9,1,16,2,3,14,13,4,5,12,32,44};	
		printNumberThatSumToK(arrNumber, 14);
	}
	
	private static void printNumberThatSumToK(int[] arrNumber, int k){
		HashSet<Integer> hs = new HashSet<Integer>();
		
		for(int num : arrNumber){
			if(hs.contains(k-num))
				System.out.println(num + " + " + (k - num) + " = " + k);
	
			hs.add(num);
		}
	}

}
