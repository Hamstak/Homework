/* Tim Tanasse
 * Assignment 4: Array Handling
 * feb 6 2015
 */
import java.util.*;

public class ArrayTransversal {
	
	public static void main (String args[]) {
		int option = 0;
		int[] ara = new int[0];
		Scanner kb = new Scanner(System.in);
		option = displayMenu(kb);
		while(true){
			switch (option){
				case 1: ara = addIntToArray(ara, kb); 
				SortSearchUtil.quickSort(ara, 0, ara.length-1);
				break;
				case 2: displayMean(ara); 
				break;
				case 3: displayMedian(ara);
				break;
				case 4: printAra(ara);
				break;
				case 5: printAraReverse(ara);
				break;
				case 6: System.exit(0);
			}
		option = displayMenu(kb);
		}
	}
	public static void printAra(int[] input){	//displays the elements of an array
		for (int i = 0; i < input.length; i++){
			System.out.print(input[i] + " ");
		}
		System.out.println("\n");
	}
	public static void printAraReverse(int[] input){// displays the elements of an array in reverse order
		for(int i = input.length - 1; i >= 0; i--){
			System.out.print(input[i] + " ");
		}
		System.out.println("\n");
	}
	public static void displayMedian(int[] input){	// gets the middle element or averages the middle elements and displays it
		double temp = 0;
		if (input.length == 0){
			System.out.println("There are no integers in the array!\n");
		}else{
			if(isEven(input.length)){
				temp = ( ( input[ ( input.length / 2 ) ] + input[ ( ( input.length / 2 ) - 1 ) ] ) / 2.0 );
			}else{
				temp = (double)(input[ ( input.length / 2 ) ]);
			}
			System.out.printf("The median of the array is %.2f\n\n",temp);
		}
	}
	public static int[] addIntToArray(int[] input, Scanner kb){ //copies previous array to new larger array and sets the last
		int temp = 0;											// index to be the new value
		int index = 0;
		int[] tempAra = new int[input.length+1];
		temp = getPositiveInt(kb);
		for (index = 0; index < input.length; index++){
			tempAra[index] = input[index];
		}
		tempAra[index] = temp;
		return tempAra;
	}
	public static void displayMean(int[] input){ //averages an array and displays the means
		double temp = 0;
		if (input.length == 0){
			System.out.println("There are no integers in the array!\n");
		}else{
			for (int i = 0; i < input.length; i++){
				temp += input[i];
			}
			temp /= input.length;
			System.out.printf("The mean of the array is %.2f.\n\n",temp);
		}
		
	}
	public static int displayMenu(Scanner kb){	//displays menu options, gets a valid menu choice and returns that choice
		int option = 0;
		while (option != 1 && option != 2 && option != 3 && option != 4 && option != 5 && option != 6){
			System.out.println("Please select from the following menu choices.\n\n\t\t1. Add a number to the array\n\t\t2. Display the mean\n\t\t3. Display the median\n\t\t4. Print the array to the screen\n\t\t5. Print the array in reverse order\n\t\t6. Quit");
			System.out.print("Choice --> ");
			option = getInt(kb);
			System.out.println();
			if (!(option == 1 || option == 2 || option == 3 || option == 4 || option == 5 || option == 6)){
				System.out.println("Invalid choice!");
			}
		}return option;
	}
	public static int getPositiveInt(Scanner kb){	//psuedo try catch for getting a positive integer from the user
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
	public static int getInt(Scanner kb){	//try catch for getting an integer from the user
		int temp = 0;
		boolean exception = true;
		while (exception){
			try{
				temp = kb.nextInt();
				exception = false;
			}
			catch (Exception e){
				System.out.println("Input an integer!");
				kb.nextLine();
				temp = 0;
				exception = true;
			}
		}return temp;
	}
	public static boolean isEven(int num){ // simple check for even integers
		if (num != 0){
		if (num % 2 == 0){
			 return true;
		} else{
			 return false;
		 }
		}else{
			return false;
		}
	}
}

