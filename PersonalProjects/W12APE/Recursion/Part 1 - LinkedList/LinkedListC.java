public class LinkedListC extends LinkedList
{
   // If the list is empty, print the message "The list is empty"
	// Check the indexes to ensure
	// -fromIndex is not less than 0
	// -toIndex is not greater than size
	// -fromIndex is less than toIndex
	// throw an IndexOutOfBoundsException if one of the indexes are incorrect
	// otherwise print the nodes fromIndex to toIndex in reverse order
  	public void subListReverse(int fromIndex, int toIndex)
	{
      if(size == 0){
       System.out.print("the list is empty");
      }else if(fromIndex < 0 || toIndex > size || fromIndex > toIndex){
         throw new IndexOutOfBoundsException("Index out of bounds");
      }else{
         System.out.print(subListReverseHelper(fromIndex, toIndex, head.next, 0));
      }
      
	}// end subListReverse
	private String subListReverseHelper(int fromIndex, int toIndex, Node curr, int index){
      if (index >= toIndex && curr == null){
         return "";
      }else if (index <= toIndex && index >= fromIndex){
         return subListReverseHelper(fromIndex, toIndex, curr.next, index + 1) + curr.data.toString() + "\n"; 
      }else{
         return subListReverseHelper(fromIndex, toIndex, curr.next, index + 1);
      }
   }  	
}// end class
