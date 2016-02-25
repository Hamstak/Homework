import java.util.*;
import java.io.*;
public class KeyboardException 
{
	//  This example shows how to catch a keyboard error...

	public static void main(String[] args) 
	{
		int myInt = 0;
		Scanner kb = new Scanner(System.in);

		while(true)
		{
			try
			{
				System.out.print("Enter a positive integer: ");
				myInt = kb.nextInt();
				
				if (myInt <= 0)
				{
					Exception e = new InputMismatchException("Hello World");
					throw e;
				}
				break;
			}
			catch (FileNotFoundException e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
				System.out.println("Invalid input.  Please re-enter.");
				kb.nextLine();
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
				System.out.println("I SAID A POSITIVE INTEGER!!!!.  Please re-enter.");
				kb.nextLine();
			}
		}
		kb.nextLine();
		System.out.println(myInt);
		
		//  Using a try-block to validate...
		
		String input = "10";
		long value = 0;
		try
		{
			value = Long.parseLong(input, 11);
		}
		catch (NumberFormatException e)
		{
			System.out.print("Enter a valid number... ");
		}
	}
}
