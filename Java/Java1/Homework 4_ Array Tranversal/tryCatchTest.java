/*
 * 
 * 
 */
import java.util.*;

public class tryCatchTest {
	
	public static void main (String args[]) {
		int myNum = 0;
		Scanner kb = new Scanner(System.in);
		while (myNum == 0){
			try{
			myNum = kb.nextInt();
		}
		catch (Exception e){
			System.out.println("Input an integer!");
			kb.nextLine();
			myNum = 0;
		}
		}
		System.out.println(myNum);
	}
}

