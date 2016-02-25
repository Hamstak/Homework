/*

	Write the sort method for the sort class.
	It takes an array of Comparable and sorts it.
	Be sure and handle edge cases as pointed out by
	the Tester.
	No API calls to sort are allowed.
	
	10 points
*/

public class Sort
{
	public static void sort(Comparable[] input){
      if(input.length <= 1)
         return;
      int indexSmallest;
      Comparable temp;
      for(int posFill = 0; posFill < input.length - 1; posFill++){
         indexSmallest = posFill;
         for(int current = posFill; current < input.length; current++){
            if (input[indexSmallest].compareTo(input[current]) > 0)
               indexSmallest = current;
         }
         temp = input[indexSmallest];
         input[indexSmallest] = input[posFill];
         input[posFill] = temp;
      }
   }
}//end class Sort