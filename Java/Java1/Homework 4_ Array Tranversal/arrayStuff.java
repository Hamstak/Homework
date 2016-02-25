/*
 * 
 */
import java.util.*;

public class ArrayTransversal {
	
	public static void main (String args[]) {
		int option = 0;
		Scanner kb = new Scanner(System.in);
		option = displayMenu(kb);
		switch (option){
			case 1: break;
			case 2: break;
			case 3: break;
			case 4: break;
			case 5: break;
			case 6: System.exit(0);
		}while (true);
	}
	public static int displayMenu(Scanner kb){
		int option = 0;
		while (option != 1 && option != 2 && option != 3 && option != 4 && option != 5 && option != 6){
			System.out.println("Please select from the following menu choices.\n\n\t\t1. Add a number to the array\n\t\t2. Display the mean\n\t\t3. Display the median\n\t\t4. Print the array to the screen\n\t\t5.Print the array in reverse order\n\t\t6. Quit");
			System.out.print("Choice --> ");
			option = getInt(kb);
			System.out.println();
			if (!(option == 1 || option == 2 || option == 3 || option == 4 || option == 5)){
				System.out.println("Invalid choice!");
			}
		}return option;
	}
	public static int getInt(Scanner kb){
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
	public static boolean isEven(int num){
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
	public static boolean isZero(int num){
		if (num == 0){
			return true;
		}else{
			return false;
		}
	}
}

