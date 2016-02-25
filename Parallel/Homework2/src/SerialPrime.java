
public class SerialPrime {
	
	public SerialPrime() {
		super();
	}
	
	//checks whether an int n is prime or not.
	public static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		else if (n <= 3)
			return true;
		else if (n%2 == 0 || n%3==0)
			return false;
		int i = 5;
		while(i*i <= n){
			if (n%i == 0 || n%(i+2) == 0)
				return false;
			i += 6;
		}
		return true;
	}
	
	public static int numSerailPrimes(int low, int high) {
		int numPrime = 0;
		//long start = System.currentTimeMillis();
		for( int i = low; i <= high; i ++ ) {
			if (isPrime(i)) { numPrime ++; }
		}
		//long stop = System.currentTimeMillis();
		//System.out.println("Number of primes found is: " + numPrime);
		return numPrime;
	}

}
