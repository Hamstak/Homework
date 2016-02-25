/* Tim Tanasse
 * Assigment 6: Rationals
 * Mar 2nd, 2015
 */

import java.util.*;
public class RationalDriver{
	
	public static void main (String args[]) {
		Scanner kb = new Scanner(System.in);
		int option = displayMenu(kb);
		int[][] init ={{2,3},{2,18},{3,12},{9,3},{2,5},{22,7}};
		Rational[] array = Rational.initializeRationalArray(init);
		while (option != 7){
			switch(option){
				case 1: System.out.println(array[getUserIndex(array.length)].toString()+"\n");
				break;
				case 2: array[getUserIndex(array.length)] = createRational();
				break;
				case 3: displayAddition(array);
				break;
				case 4: displaySubtraction(array);
				break;
				case 5: SortSearchUtil.quickSort(array, 0, array.length - 1);
				System.out.println("Sorted!\n");
				break;
				case 6:printObjectArray(array);
				break;
			}
			option = displayMenu(kb);
		}
	}
	private static int displayMenu(Scanner kb){
         int myOption = 0;
         while (myOption != 1 && myOption != 2 && myOption != 3 && myOption != 4 && myOption != 5 && myOption != 6 && myOption != 7){
            System.out.println("\t\t1. Display a stored rational\n\t\t2. Change the value of a stored rational\n\t\t3. Add two rationals\n\t\t4. Subtract two rationals\n\t\t5. Sort the array\n\t\t6. Print the array\n\t\t7. Quit the program");
            System.out.print("Choice -> ");
            myOption = getUserInt();
            if ((myOption == 1 || myOption == 2 || myOption == 3 || myOption == 4 || myOption == 5 || myOption == 6 || myOption == 7))
               return myOption;
            System.out.println("Invalid choice");
         }
         return myOption;
      }
      public static int getUserIndex(int size){
		  System.out.print("Please enter the index of the rational you want to use -> ");
		  int temp = -1;
		  while (temp < 0 || temp > size - 1){
			temp = getUserInt();
			if (temp >= 0 && temp < size){
				return temp;
			}
			System.out.print("Array index out of bounds! Pick a smaller index -> ");
		  }
		  return temp;
	  }
	  public static int getUserPositiveInt(){	//psuedo try catch for getting a positive integer from the user
		int temp = 0;
		while (temp <= 0){
			temp = getUserInt();
			if (temp > 0){
				return temp;
			}
			System.out.println("This integer is not positive!");
		}
		return temp;
	}
      public static int getUserInt(){	//try catch for getting an integer from the user
		Scanner kb = new Scanner(System.in);
		int temp = 0;
		boolean exception = true;
		while (exception){
			try{
				temp = kb.nextInt();
				exception = false;
				System.out.println();
			}
			catch (Exception e){
				System.out.println("Input an integer!");
				kb.nextLine();
				temp = 0;
				exception = true;
			}
		}
		kb.nextLine();
		return temp;
	}
	public static Rational createRational(){
		int num1, num2=0;
		Rational temp = new Rational();
		System.out.println("Please enter the numerator ->");
		num1 = getUserInt();
		System.out.println("Please enter the denominator ->");
		while (num2 == 0){
			num2 = getUserInt();
			if (num2 != 0){
				temp = new Rational(num1,num2);
				return temp;
			}
			System.out.println("Please enter a non-zero integer");
		}
		return temp;
	}
	public static void printObjectArray (Object[] array){
		System.out.println("The objects in the array are: ");
		for (int i = 0; i < array.length; i++){
			System.out.println(array[i].toString());
		}
		System.out.println();
	}
	public static void displayAddition (Rational[] input){
		int num1 = getUserIndex(input.length);
		int num2 = getUserIndex(input.length);
		System.out.printf("The addition of Rational at index %d and %d results in " + (Rational.add(input[num1],input[num2]).toString())+ "\n\n", num1, num2);
	}
    public static void displaySubtraction (Rational[] input){
		int num1 = getUserIndex(input.length);
		int num2 = getUserIndex(input.length);
		System.out.printf("The subtraction of Rational at index %d and %d results in " + (Rational.sub(input[num1],input[num2]).toString())+ "\n\n", num1, num2);

	}
}

