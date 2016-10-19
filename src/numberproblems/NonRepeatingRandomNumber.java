package numberproblems;

import java.util.HashSet;
import java.util.Random;

public class NonRepeatingRandomNumber {
	
	private static final int randomRange = 1000;
	private static final Random randomNumberGenerator = new Random();
	private static HashSet<Integer> testList = new HashSet<>();
	
	private static void printNonRepeatingRandomNumber() {
		
		int [] numberArray =  new int[randomRange];
		
		for (int i = 0; i < randomRange; i++) 
			numberArray[i] = i;
		
		int randomIndex = 0 ;
		int randomValue = 0;
		int upperBound = randomRange;
		boolean didRepeat = false;
		
		for (int i = randomRange; i > 0; i--) {			
			randomIndex = randomNumberGenerator.nextInt(upperBound);
			
			//get random value in 
			randomValue = numberArray[randomIndex];
			int lastValue = numberArray[upperBound-1];
			numberArray[upperBound-1] = randomValue;
			numberArray[randomIndex] = lastValue;
			
			System.out.println(randomValue);

			if (!testList.add(randomValue))
				didRepeat = true;
		
			--upperBound;
			if (upperBound == 0) {
				upperBound = randomRange;
			}
		}	
		
		System.out.println(didRepeat ? "Test failed: Repeating" : "Test Passed: All random");
	}

	
	public static void main (String args[]) {
		NonRepeatingRandomNumber.printNonRepeatingRandomNumber();
	}
}
