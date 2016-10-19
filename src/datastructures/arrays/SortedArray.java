package datastructures.arrays;

import java.util.Arrays;

public class SortedArray {

	public static void main(String[] args) {
		int[] a = { 2, 5, 17, 20, 25 };
		int[] b = { 4, 9, 15, 19 };

		int[] output = mergeSortedArrays(a,b);

		System.out.println(Arrays.toString(output));
		
		System.out.println("Median is " + median(output));
		
		 int ar1[] = {1, 12, 15, 26, 38};
		 int ar2[] = {2, 13, 17, 30, 45};
		 int median = median(ar1, ar2);   
	
		 System.out.println(median);
	}


	public static int[] mergeSortedArrays(int[] a, int[] b){

		int len1 = a.length;
		int len2 = b.length;
		int aIndex = 0;
		int bIndex = 0;
		int cIndex = 0;

		int[] c = new int[len1+len2];

		while(aIndex < len1 && bIndex < len2){

			if(a[aIndex] <= b[bIndex]){
				c[cIndex] = a[aIndex];
				++aIndex;
			} else {
				c[cIndex] = b[bIndex];
				++bIndex;
			}

			cIndex++;
		}

		//If first array is traversed while merging, then add remaining elements of second array in merged array.
		if(aIndex == len1) {
			for(int i = bIndex; i < len2; i++) {
				c[cIndex] = b[i];
				cIndex++;
			}
		} else {
			//vice versa as above.
			for(int j = aIndex; j < len1;  j++) {
				c[cIndex] = a[j];
				cIndex++;
			}
		}

		return c;
	}
	
	
	/**
	 * This method uses merged sorted array as input to find median.
	 * Runtime complexity is O(length of merged array).
	 * 
	 * @param mergedArray
	 * @return median element of merged sorted array
	 */
	public static int median(int[] mergedArray) {
		int len = mergedArray.length;
		if (len == 0) 
			return -1;
		
		int median = (int) Math.floor((len - 1)/2);
		return mergedArray[median];
	}
	
	public static int median(int[] a, int[] b) {
		int aLen = a.length;
		int bLen = b.length;
		int median;
		
		if (aLen == 0 && bLen == 0) {
			throw new IllegalArgumentException("Both the arrays are empty.");
		}

		if (aLen == 0) {
			median = (int)Math.floor((bLen - 1)/2);
			return b[median];
		}

		if (bLen == 0) {
			median = (int)Math.floor((aLen)/2);
			return a[median];
		}
		
		if (aLen == bLen) {
			throw new IllegalArgumentException("Both arrays should be of same length");
		}
		
		 // If all elements of array 1 are smaller then
		 // median is average of last element of a[] and
		 // first element of b[]
		if (a[aLen-1] < b[0]) {
			return (a[aLen-1] + b[0])/2;
		}

		 // If all elements of array 2 are smaller then
		 // median is average of last element of b[] and
		 // first element of a[]
		if (b[bLen-1] < a[0]) {
			return (b[bLen-1] + a[0])/2;
		}
		 
		return median(a, b, 0, aLen-1, aLen); 
	}
	
	private static int median(int[] a, int[] b, int lowIndex, int upperIndex, int len) {
		
		if ( lowIndex > upperIndex ) {
			return median (b, a, 0, len-1, len);
		}
		
		int mid = (lowIndex + upperIndex) / 2;
		int j = len - mid - 1; /* Index for b[] */
		
		if (a[mid] > b[j] && (j == len - 1 || a[mid] <= b[j+1])) {
			 /* ar1[i] is decided as median 2, now select the median 1
	           (element just before ar1[i] in merged array) to get the
	           average of both*/
	        if (mid == 0 || b[j] > a[mid-1])
	            return (a[mid] + b[j])/2;
	        else
	            return (a[mid] + b[mid-1])/2;
		} 
		/*Search left half of a[] */
		else if (a[mid] > b[j] && j != len - 1 && a[mid] >= b[j+1]) {
			return median(a, b, lowIndex, mid -1, len);
		} else {
			return median(a, b, mid+1, upperIndex, len);
		}
	}
	
	 /**
     * Gets the median of a single sorted array.
     *
     * @param array The sorted array to get the median of.
     * @param start The start of the array to use.
     * @param end The end of the array to use.
     * @return The median of the array.
     */
    public  static double medianOfArray(int[] array, int start, int end) {
        if (start == end) {
            return array[start];
        }
        int mid = (start + end) / 2;
        
        // If array[start..end].length is even
        if ((end - start) % 2 == 1) {
            return (array[mid] + array[mid + 1]) / 2d;
        }
        return array[mid];
    }
	
}
