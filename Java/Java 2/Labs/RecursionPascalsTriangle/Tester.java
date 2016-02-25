public class Tester
{
   public static void main ( String[] args )
   {
		int r;
		long theResult;
		
		for(r = 0 ; r < 24; r+=2)
		{
		
			theResult = Recursion.pascal(r, r/2);
			
			System.out.println("The middle number of Pascal's Triangle for row: " + r 
			  + " is " + theResult + "\r\n");
			  
		}// end for		
      		
   }// end main
		
}// end class
