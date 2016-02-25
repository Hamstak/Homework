/* Tim Tanasse
 * User input utility
 * 
 */
import java.util.Scanner;
public class UserUtil{
	
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
	  public static int DynamicMenu(String[] options){
		int choice = 0;
		while ( choice <= 0 || choice > options.length){
			for (int i = 0; i < options.length; i++){
				System.out.println("\t\t"+ (i+1) + options[i]);
			}
			choice = getUserInt();
			if ( choice <= 0 || choice > options.length){
				System.out.println("Invalid choice");
			}
		}
		return choice;
	}
   public static String getUserString(){
      Scanner kb = new Scanner(System.in);
      String temp;
      while(true){
         try{
            temp = kb.nextLine();
            System.out.println();
            break;
         }catch(Exception e){
            System.out.println("Please enter a valid string!");
            System.out.print("Enter a string -> ");
            temp = null;
            kb.nextLine();
         }
      }
      return temp;
   }
}

