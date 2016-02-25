/*
	Implement the Comparator interface.  The type on which your Comparator
	will operate is Fish.  It will compare for order based on Fish weight.
	
	See the Java API on Comparator for where comparator lives in the API,
	what method it contains, and what the method must do.
	
	You do not need to provide any other functionality in this class
	other than implementing the Comparator interface

*/
import java.util.*;
public class FishWeightComparator implements Comparator<Fish>
{
   public int compare(Fish a, Fish b){
      return a.getOunceWeight() - b.getOunceWeight();
   }
}//end class FishWeightComparator