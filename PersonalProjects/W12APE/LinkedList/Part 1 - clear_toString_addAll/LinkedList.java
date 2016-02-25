public class LinkedList
{
   protected static class Node
   {
      protected Comparable data;
      protected Node next;
		
		protected Node ( Comparable data )
      {
         this.data = data;
         this.next = null;
      }// end constructor


    	protected Node ( Comparable data, Node next )
      {
         this.data = data;
         this.next = next;
      }// end constructor
     		
   }// end Node class

   
   protected Node head;
   protected int  size;
	
	// NOTE:  DUMMY header node.
	public LinkedList()
	{
		this.head = new Node(null);//set up DUMMY
		this.size = 0;
	
	}//end constructor

   // Return the present size of the linked list
   public int size()
   {  
		return size;
	}// end size
	
	/*********************************************************/
	/******** Your Code Goes Below Here **********************/
	/*********************************************************/

   // Empty out the linked list
	
   public void clear(){
      head = new Node(null);
      size = 0;
   }
   
	// Appends the specified elements to the end of this list.
	// Returns true if this collection changed as a result of the call.
	
   public boolean addAll(Integer[] array){
      Node temp = head;
      int tempSize = size;
      
      while(temp.next != null){
         temp = temp.next;
      }
      
      for (int i = 0; i < array.length; i++){
         temp.next = new Node(array[i]);
         temp = temp.next;
         size++;
      }
      
      if(size != tempSize)
         return true;
      return false;
   }
	// Write the toString method.
	// This method returns a string formatted
	// as follows: [first value, second value, ..., last value ]
	// Note that the last value does not have a comma after it.
	// Note also that there is a space after each comma.
	// The method should return 'List is Empty'
	// if the list is empty	
	public String toString(){
      if (size == 0)
         return "List is Empty";
      String result = "(";
      Node curr;
      for(curr = head; curr.next != null; curr = curr.next){
         if (curr.data == null)
            continue;
         result += curr.data.toString() +", ";
      }
      result += curr.data.toString() + ")";
      return result;
   }
	
 }// end LinkedList class