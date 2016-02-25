  import java.util.Scanner;  
	 
	 public class StringFun
   {
   
       public static void main(String[] args)
      {

      
         String t1 = "abc";
         String t2 = new String("abc");
			
      	
      	//  Might work, but only if the compiler is really smart...
         if (t1 == t2)
         {
            System.out.println("maybe");
         }
  
         t1 = "m";
         if (t1 == "m")
         {
            System.out.println("t1 '==' \"m\"");
         }
  
         t1 = "abc";
  
      	//  Always works:
         if (t2.equals(t1))
         {
            System.out.println("for sure");
         }
      	
			int val = t2.compareTo(t1);
			
			String s = "Now is the time...";
			
			//  More string fun - helpful methods in the String class...
         System.out.println(s.toUpperCase());
         System.out.println(s);
         s = s.toUpperCase();
         System.out.println(s);
         s = s.toLowerCase();
			System.out.println(s);
			
			//  Grab a single character at a designated position...
         System.out.println(s.charAt(1));
         
         // You can't do this...
         // s.charAt(0) = 'a';
			
			//  How long is my string..?      			
         System.out.println(s.length());
			
			//  Sometimes it's helpful to get a substring of a string...
			String sub = s.substring(0, 2);
			System.out.println(sub);
			
			sub = s.substring(1, 2);
			System.out.println(sub);

			
      	//  Where is 'b' in my String..?		
         System.out.println(s.indexOf("b"));
			
			
			// ==================================================================

         
         
			//  Here, an array of Strings is being instantiated:
			String[] myStrings = new String[5];
			
			//  Now, load him up using the standard array-traversal 'for' loop...
			for (int i = 0; i < myStrings.length; i++)
			{
				myStrings[i] = new String("This is string number " + i);
			}
			
			System.out.println();
			
			//  Show that the String array is really a reference variable:
			System.out.println(myStrings);
			
			System.out.println();
			
			//  To see the content of the array elements, you have to traverse it...
			for (int i = 0; i < myStrings.length; i++)
			{
				System.out.println(myStrings[i]);
			}
			
			Scanner kb = new Scanner(System.in);
			System.out.println("Please enter a date: ");
			
			
			String rawDate = kb.nextLine();
			
			//  Try to split by spaces...
			String[] arrayDate = rawDate.split(" ");
			if (arrayDate.length < 3)
			{
				//  Try to split by "/"...
				arrayDate = rawDate.split("/");
			}
			if (arrayDate.length < 3)
			{
				//  Try to split by "-"...
				arrayDate = rawDate.split("-");
			}
			
			System.out.println(arrayDate[0]);
			System.out.println(arrayDate[1]);
			System.out.println(arrayDate[2] + "\n");
			
         System.out.println(arrayDate[0] + "." + arrayDate[1] + "." + arrayDate[2]);
      	
      
      }
   
   
   }