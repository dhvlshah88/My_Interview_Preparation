package algorithms.dynamicprogramming;

public class KnapsackProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		int[] wt = {10,20,30};
		int[] val = {60,100,120};
		int capacity = 50;
		
		System.out.println("Max value is " + maxValue(capacity, val, wt, val.length));
	}

	public static int maxValue(int capacity, int[] val, int[] wt, int size)
	{
		int[][] K = new int[size+1][capacity+1];
		
		for(int i = 1; i <= size; i++)
		{
			for(int j = 1; j <= capacity; j++)
			{
				if(wt[i-1] > j)
					K[i][j] = K[i-1][j];
				else
					K[i][j] = Math.max((val[i-1] + K[i-1][j - wt[i-1]]), K[i-1][j]);
			}	
		}
		
		int j = capacity;
		for(int i = size; i > 0; i--)
		{
			if(K[i][j] != K[i-1][j])
			{
				System.out.println("Weight is " + wt[i-1] + " and profit is " + val[i-1]);
				j -= wt[i-1];
			}
			
			if(j < 0) break;
		}
		
		
		return K[size][capacity];	
	}
}
