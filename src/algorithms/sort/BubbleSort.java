package algorithms.sort;

public class BubbleSort {
	public static int[] sort(int unsortedArray[], int arrayLength){
		int temp = 0;
		boolean swapped = false;
		for(int i = 0; i < arrayLength - 1; i++){
			if(unsortedArray[i]>unsortedArray[i+1]){
				temp = unsortedArray[i];
				unsortedArray[i] = unsortedArray[i+1];
				unsortedArray[i+1] = temp;
				swapped = true;
			}
		}
		
		if(swapped){
			sort(unsortedArray, arrayLength);
		}
	
	return unsortedArray;
	}
}
