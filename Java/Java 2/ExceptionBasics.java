import java.util.Scanner;
import java.io.*;

//  Basic exception handling mechanisms...

public class ExceptionBasics 
{
	@SuppressWarnings({ "unused" })
	public static void main(String args[]) throws MyException
	{
		
		int x = 2;
		int y = 0;
		int z;
		
		// z = 9 / 0;
		
		int[] ints = new int[1];
		
		try
		{
			//ints[1] = 42;
			z = x / y;
			System.out.println("I'm in the try block...");
		}
		catch (ArithmeticException e)
		{
			System.out.println("An error occurred.");
			System.out.println(e.getMessage());
			System.out.println(e);
			e.printStackTrace();
			System.out.println("After stack trace...");
			return;
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Array index catch...");
		}
		catch (Exception e)
		{
			System.out.println("General catch...");
		}
		finally
		{
			System.out.println("And finally...");
		}
		
		//  =========================================
		
		Scanner myFile = null;
	
		try
		{
			myFile = new Scanner(new File("myFile.tx"));
			
			ints[1] = 42;
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e);
		}  
		catch (RuntimeException e)
		{
			System.out.println("File may not be available.");
			// myFile = new Scanner(new File("myFile.txt"));
		}
		catch (Exception e)
		{
			System.out.println("Unspecified error (I don't know what happened.)");
		}
		finally
		{
			if (myFile != null)
			{
				myFile.close();
			}
			System.out.println("In finally...");
		}
	}
}
