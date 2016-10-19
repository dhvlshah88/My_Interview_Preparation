package numberproblems;

public class MathFunc {

	public static double power(double base, int exponent)
	{	
		//Base case for power = 0, return 1.
		if(exponent == 0)
			return 1;

		//Base case for power = 1, return base.
		if(exponent == 1)
			return base;

		double temp = power(base, exponent/2);

		if(exponent % 2 == 0)
			return temp * temp;

		if(exponent > 0)
			return base * temp * temp;
		else
			return (temp * temp) / base;
	}

	public static long fibonacciNumber(int position)
	{
		if (position < 2)
			return position;
		long ans = 0;
		long n1 = 0;
		long n2 = 1;
		//System.out.print("Series: " + n1);
		for(position--; position > 0; position--)
		{
			ans = n1 + n2;
			n1 = n2;
			n2 = ans;
			//System.out.print(" " + ans);
		}
		return ans;
	}
	
	public static int fibonacciNumberRecursively(int position)
	{
		return fibo(position); 
	}
	
	private static int fibo(int position)
	{
		return (position < 2)? position : fibo(position-1) + fibo(position-2);
	}

	public static void main(String[] args)
	{
		System.out.println(MathFunc.power(2, 3));
		System.out.println(fibonacciNumber(4));
		System.out.println(fibonacciNumberRecursively(4));
	}

}
