package stringproblems;

public class FindMin {
	
	public static void returnArr(int[] arr, int n, int k, int a, int b, int c, int r){
	
		arr[0] = a;
		
		for(int i=1; i<n; i++){
			arr[i] = (b * arr[i-1] + c) % r;
			System.out.println(arr[i]);
		}
		
		//return arr;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 46;
		int[] m = new int[n];
		
		FindMin.returnArr(m, n, 18, 7, 11, 9, 46);
		
		
	}

}
