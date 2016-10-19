public class Index {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = {-7, 1, 5, 2, -4, 3, 0};
		isEquilibrium(arr, arr.length);
		isEquilibriumEff(arr, arr.length);
		
		
		String str = "Dhaval";
		int l = 0, r =1;
		System.out.println(str.substring(l+1, r-l-1));
	}
	
	
	public static void isEquilibrium(int[] arr, int len)
	{
		int leftsum = 0;
		
		for(int i=0; i<len; i++)
		{
			int rightsum = 0;
			for(int j = i+1; j<len; j++)
			{
				rightsum += arr[j];
			}
	
			if(leftsum == rightsum)
				System.out.println("E. Index is :" + i);
			
			leftsum += arr[i];
		}
	}
	
	public static void isEquilibriumEff(int[] arr, int len)
	{
		int sum = 0, leftsum = 0;
		int i;
		
		for(i=0; i<len; i++)
			sum += arr[i];
		
		for(i=0; i<len; i++)
		{
			sum -= arr[i];
			
			if(sum == leftsum)
				System.out.println("E. Index is :" + i);
			
			leftsum += arr[i]; 
			
		}
	}

}
