/* Tim Tanasse
 * Assignment 3: Integer Fun
 * Completed EC: Do all three
 * Jan 27 2015
 */

import java.util.*;
import java.lang.Math;

public class intFun {
	
	public static void main (String args[]) {
		int workingInt = 0;
		int choice = 0;
		Scanner kb = new Scanner(System.in);
		System.out.println("Welcome to Integer Fun!");
		workingInt = getPositiveInt(kb);
		choice = displayMenu(kb);
		while (choice != 5) {
			switch (choice) {
				case 1: workingInt = getPositiveInt(kb);
				System.out.println(workingInt);
				break;
				case 2: checkEvensOddsZeroes(workingInt);
				break;
				case 3: primeSieve(workingInt);
				break;
				case 4: addDigits(workingInt);
				break;
			}
			choice = displayMenu(kb);
		}
	}
	//gets a positive int from the user
	public static int getPositiveInt(Scanner kb){
		int temp = 0;
		while (temp <= 0){
			System.out.print("Please enter a positive integer --> ");
			temp = getInt(kb);
			System.out.println("\n");
			if (temp <= 0){
				System.out.println("This integer is not positive!");
			}
		}return temp;
	}
	//displays a menu
	public static int displayMenu(Scanner kb){
		int option = 0;
		while (option != 1 && option != 2 && option != 3 && option != 4 && option != 5){
			System.out.println("Please select from the following menu choices.\n\n\t\t1. Enter new number\n\t\t2. Print the number of even, odd, and zero digits in the integer\n\t\t3. Print the prime numbers between 2 and the integer\n\t\t4. Print the sum of the digits of the integer\n\t\t5. Quit the program\n");
			System.out.print("Choice --> ");
			option = getInt(kb);
			System.out.println();
			if (!(option == 1 || option == 2 || option == 3 || option == 4 || option == 5)){
				System.out.println("Invalid choice!");
			}
		}return option;
	}
	//gets an int
	private static int getInt(Scanner kb){
			int temp = kb.nextInt();
			kb.nextLine();
			return temp;
	}
	//checks if int is even
	private static boolean isEven (int checkInt){
		if (checkInt % 2 == 0){
			return true;
		}else{
			return false;
		}
	}
	//checks if int is zero
	private static boolean isZero (int checkInt){
		if (checkInt == 0){
			return true;
		}else{
			return false;
		}
	}
	//Given an int, displays the number of odd even and zero valued digits
	public static void checkEvensOddsZeroes (int checkInt){
		int[] checkAra = new int[3]; //0 is evens 1 is odds 2 is zeroes 
		while (checkInt !=0){
			if (isZero(checkInt%10)){
				checkAra[2]++;
			}else if (isEven(checkInt%10)){
				checkAra[0]++;
			}else{
				checkAra[1]++;
			}
			checkInt /= 10;
		}System.out.printf("Your results are:\nOdd - %d\nEven - %d\nZero(s) - %d\n\n", checkAra[1], checkAra[0], checkAra[2]);
	}
	/* Sieve is a form of The Sieve of Eratosthenes
	 * This sieve is constructed by giving an upper bound (upperBound) 
	 * From the proof of the sieve, the square root of the upper bound is the upper limit of all primes that eliminate
	 * composites from the list of numbers (upperBoundsqrt)
	 * all composites are eliminated by the form of f(x)= n^2+nx while f(x) is less than the upper bound and n is a prime
	 * less than the square root of the upper bound.
	 * the method then prints all numbers that are not composites (primes).
	 * additionally, when removing composites we starts at n^2 (where n is prime) since all of the previous multiplies of n
	 * are covered by previous primes
	 * the in method comments are a way to check if all primes are output by displaying the number of primes output.
	 */
	public static void primeSieve(int upperBound){
		//int check = 0;
		boolean isComposite[] = new boolean[upperBound +1];
		isComposite = createCompositeList(upperBound, isComposite);
		for (int i = 2; i <= upperBound; i++){
			if (!isComposite[i]){
				System.out.print(i + " ");
				//check++;
			}
		}
		//System.out.print(check);
		System.out.println("\n");
	}
	//part of primeSieve, although this is the actual sieve
	private static boolean[] createCompositeList (int upperBound, boolean[] isComposite){
		int upperBoundsqrt = (int)(Math.sqrt(upperBound));
		for (int i = 2; i <= upperBoundsqrt; i++){
			if (!isComposite[i]){
				for (int j = i * i; j<= upperBound; j += i){
					isComposite[j] = true;
				}
			}
		}
		return isComposite;
	}
	//Displays the sum of the digits in the given int
	public static void addDigits(int num){
		int temp1 = 0;
		int temp2 = num;
		while (num != 0){
			temp1 += num % 10;
			num /= 10;
		}System.out.printf("The sum of the digits in %d is %d\n\n", temp2, temp1);
	}
}

