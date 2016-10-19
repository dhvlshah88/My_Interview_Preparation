package numberproblems;

import java.util.*;

public class PrimeNumber {

	// will contain true or false values for the first 10,000 integers
	private boolean[] primes=new boolean[100000]; 

	//checks whether an int is prime or not.
	@SuppressWarnings("unused")
	private static boolean isPrime1(int n) {
		for(int i=2;2*i<n;i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}

	@SuppressWarnings("unused")
	private static boolean isPrime2(int n) {
		//check if n is a multiple of 2
		if (n%2==0) return false;
		//if not, then just check the odds
		for(int i=3;i*i<=n;i+=2) {
			if(n%i==0)
				return false;
		}
		return true;
	}


	//set up the prime sieve
	public void fillSieve() {
		Arrays.fill(primes, true);        // assume all integers are prime.
		primes[0]=primes[1]=false;       // we know 0 and 1 are not prime.

		for (int i=2; i<primes.length; i++) {
			//if the number is prime, then go through all its multiples and make their values false.
			if(primes[i]) {
				for (int j=2; i*j<primes.length; j++) {
					primes[i*j]=false;
				}
			}
		}
	}

	public boolean isPrime(int n) {
		fillSieve();
		/*int counter = 0;
		for(int i = 2; i<=n; i++){
			if(Arrays.asList(primes[i]).contains(true)){
				counter++;
			}
		}
		return counter; */
		return primes[n];
	}

	public static void main(String[] args) {

		//System.out.println("Is Prime: " + isPrime1(2147483647));

		System.out.println("Is Prime: " + new PrimeNumber().isPrime(1));

	}
}
