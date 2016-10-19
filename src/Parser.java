public class Parser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long i = stringToLong("123");
		System.out.println("Output is " + i);
		if (i == 123)
		{
			System.out.println("SUCCESS");
		}
		else
		{
			System.out.println("FAILURE");
		}
	}

	/**
	 * One of the limitation my code has is I am converting the string value to its equivalent decimal number. This code cannot convert word 
	 * or string of letters to equivalent long value. My code uses radix base 10 to convert the string to long value. 
	 *
	 */
	public static long stringToLong(String s)
	{
		//Condition checks whether the parameter string is null or empty, if any throws an exception.
		if(s == null || s.isEmpty())
			throw new NumberFormatException("String is either null or empty");

		int len = s.length();
		//This determines whether the string has +ve/-ve value.
		boolean signed = s.charAt(0) == '-';
		int index = signed ? 1 : 0;
		long output = 0;

		//Throws an exception if the string has minus sign only. 
		if(len == 1 && signed)
			throw new NumberFormatException(s);
		
		//This determines the a bound of long data type based on the sign.  
		long bound = !signed ? Long.MIN_VALUE : -Long.MAX_VALUE;
		//This value is used to determine whether the string value doesn't exceed the bound of long data type.
		long threshold = bound/10;
		
		while(len > index)
		{
			output *= 10;
			int val = s.charAt(index) - 48;

			//Throws a exception if value is not between 0 and 9. 
			if(val < 0 || val > 9)
				throw new NumberFormatException(val + "");

			//If the output is less than the threshold, throw a number format exception.
			if(output < threshold)
				throw new NumberFormatException("The long value is out of range");

			output += val;
			index++;
		}

		return signed ? -output : output;
	}
}
