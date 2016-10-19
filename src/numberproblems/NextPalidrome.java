package numberproblems;

public class NextPalidrome {


	public static void main(String[] args)
	{
		System.out.println(nextPalindrome(129921));
	}


	public static int nextPalindrome(int num)
	{
		return nextPalindrome(num, true);
	}

	private static int nextPalindrome(int num, boolean firstTime)
	{

		String numString=""+num;
		
		int leftEndIndex=-1;
		int rightStartIndex=-1;
		
		boolean isOdd= (numString.length()%2==1);
		if(isOdd)
		{
			leftEndIndex = numString.length()/2;
			rightStartIndex = leftEndIndex + 1;
		}
		else
		{
			leftEndIndex=rightStartIndex=numString.length()/2;

		}
		
		String leftHalf = numString.substring(0,leftEndIndex);
		System.out.println("Left half :" + leftHalf);
		String rightHalf = numString.substring(rightStartIndex);
		System.out.println("Right half :" + rightHalf);
		
		String leftReversed = new StringBuffer(leftHalf).reverse().toString();
		System.out.println("Reverse Left half :" + leftReversed);
		
		String palindrome=null;
		
		if(Integer.parseInt(leftReversed)>Integer.parseInt(rightHalf) || !firstTime)
		{
			if(isOdd)
				palindrome = leftHalf + numString.charAt(leftEndIndex) + leftReversed;
			else
				palindrome=leftHalf+leftReversed;
			return Integer.parseInt(palindrome);
		}
		else
		{
			if(isOdd)
			{
				String leftAndMiddle=leftHalf + numString.charAt(leftEndIndex);
				int incrementedLeft=Integer.parseInt(leftAndMiddle)+1;
				return nextPalindrome(Integer.parseInt(incrementedLeft+rightHalf), false);
			}
			else
			{
				int incrementedLeft=Integer.parseInt(leftHalf)+1;
				return nextPalindrome(Integer.parseInt(incrementedLeft+rightHalf), false);
			}
		}

	}

}
