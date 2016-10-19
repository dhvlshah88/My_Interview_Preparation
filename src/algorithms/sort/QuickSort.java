package algorithms.sort;

import java.util.Arrays;

public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] unsortedArray = {6, 5, 3, 1, 8, 7, 2, 4, 9, 7};
		QuickSort.sort(unsortedArray);
		
		for(int i : unsortedArray)
			System.out.println(i);
		
	}
	
	public static void sort(int[] data)
	{
	  sort(data, 0, data.length - 1);
	}

	private static void sort(int[] data, int left, int right)
	{
		int pivotValue = data[(left + right)/2];
		int startIndex = left;
		int endIndex = right;
		
		while(startIndex <= endIndex)
		{
			// Find leftmost value greater than or equal to the pivot.
			while(data[startIndex] < pivotValue)
				startIndex++;
			
			// Find rightmost value less than or equal to the pivot.
			while(data[endIndex] > pivotValue)
				endIndex--;
			
			// If the values are in the wrong order, swap them.
			if(startIndex <= endIndex)
			{
				swap(data, startIndex, endIndex);
				startIndex++;
				endIndex--;
			}		
		}
		
		System.out.print(Arrays.toString(data));
		
		// Apply the algorithm to the partitions we made, if any.
		// This index position are on either sides of pivot index.
		if( left < endIndex )
			sort( data, left, endIndex);
		
		if( startIndex < right )
			sort( data, startIndex, right );
	}
	
	public static void swap(int[] data, int i, int j)
	{
		if(i == j)
			return;
		
		data[i] = data[j] - data[i];
		data[j] -= data[i];
		data[i] += data[j];
	}
}
