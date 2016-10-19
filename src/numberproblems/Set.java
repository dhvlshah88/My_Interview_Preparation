package numberproblems;

public class Set {

	public static void powerSet(int[] set)
	{
		int len = set.length;
		int psLen = 1 << len;
		int bitValue, arrIndex;

		for(int i=1; i<psLen; i++)
		{
			bitValue = i;
			arrIndex = 0;

			while(bitValue > 0)
			{
				if((bitValue & 1) == 1) 
					System.out.print(set[arrIndex] + " ");

				arrIndex++;
				bitValue >>= 1;
			}

			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[] set = {1,2,3};
		powerSet(set);
	}
}
