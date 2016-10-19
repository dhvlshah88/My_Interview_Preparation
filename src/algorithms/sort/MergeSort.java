package algorithms.sort;

public class MergeSort {

	private int[] unSArr;
	private int[] sArr;
	
	public void sort(int unSArr[]){
		
		this.unSArr = unSArr;
		int arrayLen = unSArr.length;
		sArr = new int[arrayLen];
		
		mergeSort(0, arrayLen - 1);
		
		System.arraycopy(unSArr, 0, sArr, 0, arrayLen);
		
		System.out.println();
		System.out.println("After Sorting:");
		for(int j = 0; j < arrayLen; j++){
			System.out.print(sArr[j]);
			System.out.print(" ");
		}
	}

	private void mergeSort(int low, int high){

		// If there are more than one element
		if(low < high){

			// Divide P into subproblems.
			// Find where to split the set.
			int mid = (low + high)/2;

			//Solve the left side of the array.
			mergeSort(low, mid);
			
			//Solve the right side of the array.
			mergeSort(mid + 1, high);

			//Merge the solutions.
			merge(low, mid, high);

		}

	}

	private void merge(int low, int mid, int high){
		
		int l = low, k = low, m1 = mid + 1;
		
		// Copy both parts into the helper array
		for (int i = low; i <= high; i++) {
			sArr[i] = unSArr[i];
		}

		
		// Copy the smallest values from either the left or the right side
		// to the new array
		while((l <= mid) && (m1 <= high)){

			if(sArr[l] <= sArr[m1]){
				unSArr[k] = sArr[l]; 
				l++;
			}
			else{
				unSArr[k] = sArr[m1];
				m1++;
			}
			k++;
		}

		while(l <= mid){
			unSArr[k] = sArr[l];
			k++;
			l++;
		}
	}


	public static void main(String[] args) {
		
		MergeSort ms = new MergeSort();
		int[] unSortedArray = {6, 5, 3, 1, 8, 7, 2, 4, 9, 7};
		
		System.out.println("Before Sorting:");
		for(int j = 0; j < unSortedArray.length; j++){
			System.out.print(unSortedArray[j]);
			System.out.print(" ");
		}
		
		ms.sort(unSortedArray);
		

	}

}