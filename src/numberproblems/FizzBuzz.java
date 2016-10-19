package numberproblems;

public class FizzBuzz {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public static String checkFizzBuzz(int number)
	{
		//for ()
		if(number % 15 == 0)
			return "FizzBuzz";
		else if(number % 3 == 0)
			return "Fizz";
		else if(number % 5 == 0)
			return "Buzz";
		
		
		return String.valueOf(number);
	}

}
