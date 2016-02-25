   import java.util.Scanner;
	
   public class LoopBasics
   {
   	   
      public static void main(String[] args)    
      {
         int count = 0;
      
      	//  increment operator...
         count++;
         System.out.println(count);
         
			int k = 0;
         
      	// The standard 'for' loop...          
         for (k = 0; k < 5; k = k + 1)
         {
            System.out.print(k);
         }
      
         System.out.println(k);
      
         System.out.println();
         // System.out.println(k);
         
      	// Standard while loop with sentry variable...
         int index = 1;
         while ( index > 0 )
         {
            // index--;
            System.out.print(index-- + " ");
         }  
            
         System.out.println();
      	
      	// 'do-while' loop...
      	// Notice how the 'index--' statement is handled...
         index = 1;
         while (index > 0)
         {
            System.out.print( --index + " ");
				
         }
      	
         System.out.println();
      	
      	
            
            //  ===========================================
            //  This routine is a "nested" for loop...
         System.out.println();	
         for (int i = 0; i < 5; i += 1)
         {
            for (k = 0; k < 5; k++)
            {
               System.out.print(k);
            }
            System.out.print("\n");
         }   
      	
      	
            // ============================================		
            // This is another example of a nested for loop...
         for (int i = 0; i < 5; i++)
         {
            for (int j = 0; j <= i; j++)
            {
               System.out.print("*");
            }
            System.out.println();
         }
         
         //  'Do-While' Loop...
         //    Sentry variable:
         Scanner kb = new Scanner(System.in);
         char c = ' ';
         while (c != 'q')
         {
            System.out.println("Select 'q' to Quit");
            c = kb.next().charAt(0);
            
         
         }
         
         
         
         
            // 
            // ============================================
            //  This routine loads an array using a for loop...
         
         int[] myAra = {41, 42, 43, 44};
         
         int[] numbers = new int[10];
         int loadValue = 2;
         for (int i = 0; i < numbers.length; i++)
         {
            numbers[i] = loadValue;
            loadValue = loadValue * 2;
         }																																																												
         
         System.out.println(numbers[1]);
         
            // ============================================
            //  This routine displays the contents of the array...
         for (int i = 0; i < numbers.length; i++)
         {
            System.out.print("\t " + numbers[i]);
         }
            
            // ============================================
            //  This routine also displays the contents of the array...
            //    ...note the alternate form of 'for' loop!
         for (int value : numbers)
         {
            System.out.print(value);
         }
            
            
         System.out.println();
            
         String myString = "Now is the time for all good " + 
                  				"persons to come to the aid of their party.";
         for (int i = myString.length() - 1; i >= 0; i--)
         {
            System.out.print(myString.charAt(i));
         }
            
         System.out.println();
      		
         for (int i = myString.length() - 1; i >= 0; i--)
         {
            System.out.print(myString.charAt(i));		
         }
      
      }
   }