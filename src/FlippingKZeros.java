/**
 * 
 * Given an array of 0s and 1s, and k, Find the longest continuous streak of 1s after flipping k 0s to 1s. 
 * 
 * E.x array is {1,1,0,0,1,1,1,0,1,1} 
 * k = 1 (which means we can flip ‘k’ one 0 to 1) 
 * 
 * Answer: 6 (if we flip 0 at index 7, we get the longest continuous streak of 1s having length 6)
 *
 */

/**
 * @author Dhaval
 *
 */
public class FlippingKZeros {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		int[] arrays = {1,1,1,0,1,1,1,0,1,1};
		int[] arrays = {1,1,1,1,0,0,1,1,1,1};
		

		int longestLen = longestContinuousStreaks(arrays, 1);
		System.out.println("Longest continuouse streak length is " + longestLen);
	}
	
	
	public static int longestContinuousStreaks(int[] items, int k) {
		int maxLength = Integer.MIN_VALUE;
		int runningLength = 0;
		int start = 0;
		int tempK = k;
		
		
		for (int i = 0; i < items.length; i++) {
			System.out.println(i);
			if (items[i] == 1) {
				runningLength++;
			}
			else  if (tempK > 0 && tempK < k) {
				tempK--;
				runningLength++;
			} 
			else if (tempK == k && k > 0) {
				tempK--;
				runningLength++;
				start = i;
			}
			else if(tempK == 0) {
				tempK = k;
				maxLength = Math.max (maxLength, runningLength);
				runningLength = 0;
				int temp = i;
				i = start;
				start = temp;
			}
		}
		
		return Math.max(maxLength, runningLength);
	}

}
