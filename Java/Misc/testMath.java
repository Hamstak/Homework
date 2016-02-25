import java.util.*;
import java.lang.Math;

public class testMath {
	
	public static void main (String args[]) {
		int myint = 0;
		int[] myara = new int[3];
		Scanner kb = new Scanner(System.in);
		myint = kb.nextInt();
		kb.nextLine();
		checkEvensOddsZeros(myint);
	}
	public static boolean isEven (int checkInt){
		if (checkInt == 0){
			return false;
		}
		if (checkInt % 2 == 0){
			return true;
		}else{
			return false;
		}
	}
	public static boolean isZero (int checkInt){
		if (checkInt == 0){
			return true;
		}else{
			return false;
		}
	}
	/* Sieve is a form of The Sieve of Eratosthenes
	 * This sieve is constructed by giving an upper bound (upperBound) 
	 * From the proof of the sieve, the square root of the upper bound is the upper limit of all primes that eliminate
	 * composites from the list of numbers (upperBoundsqrt)
	 * all composites are eliminated by the form of f(x)= n^(2+x) while f(x) is less than the upper bound and n is a prime
	 * less than the square root of the upper bound.
	 * the method then prints all numbers that are not composites (primes).
	 */
	public static void primeSieve(int upperBound){
		boolean isComposite[] = new boolean[upperBound +1];
		isComposite = createCompositeList(upperBound, isComposite);
		for (int i = 2; i <= upperBound; i++){
			if (!isComposite[i]){
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
	public static boolean[] createCompositeList (int upperBound, boolean[] isComposite){
		int upperBoundsqrt = (int)(Math.pow(upperBound, .5));
		for (int i = 2; i <= upperBoundsqrt; i++){
			if (!isComposite[i]){
				for (int j = i * i; j<= upperBound; j += i){
					isComposite[j] = true;
				}
			}
		}
		return isComposite;
	}
	public static void addDigits(int num){
		int temp1 = 0;
		int temp2 = num;
		while (num != 0){
			temp1 += num % 10;
			num /= 10;
		}System.out.printf("The sum of the digits in %d is %d\n", temp2, temp1);
	}
	public static void checkEvensOddsZeros (int checkInt){
		int[] checkAra = new int[3]; //0 is evens 1 is odds 2 is zeroes 
		while (checkInt !=0){
			if (isZero(checkInt % 10)){
				checkAra[2]++;
			}else if (isEven(checkInt %10)){
				checkAra[0]++;
			}else{
				checkAra[1]++;
			}
			checkInt /= 10;
		}System.out.printf("Your results are:\nOdd - %d\nEven - %d\nZero(s) - %d\n", checkAra[1], checkAra[0], checkAra[2]);
	}
	public static void printEvensOddsZeros(int[] ara){
		System.out.printf("Your results are:\nOdd - %d\nEven - %d\nZero(s) - %d\n", ara[1], ara[0], ara[2]);
	}
}

