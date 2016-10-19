package numberproblems;

public class MultiplyWithoutOperator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(MultiplyWithoutOperator.multiply(5, -5));
		System.out.println(MultiplyWithoutOperator.multiply(0, -13));
	}

	public static int multiply(int firstOperand, int secondOperand)
	{
		if(firstOperand == 0 || secondOperand == 0)
			return 0;
		
		int counter = 0;
		if(firstOperand < 0)
		{
			firstOperand =	Math.abs(firstOperand);	
			++counter;
		}
		
		if(secondOperand < 0)
		{
			secondOperand = Math.abs(secondOperand);
			++counter;
		}
		
		int multiple = firstOperand;
		int value = secondOperand;
		if (firstOperand > secondOperand)
		{
			multiple = secondOperand;
			value = firstOperand;
		}
		
		int total = 0;
		while(multiple-- != 0)
		{
			total += value;
		}
		
		return (counter == 1? -total : total);
	}
}
