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

      public void setData ( Comparable data )
      {  
			this.data = data;
		}// end setData

      public void setNext ( Node next )
      { 
			this.next = next;
		}// end setNext

      public Comparable getData ()
      {
			return this.data;
		}// end getData

      public Node getNext ()
      {
			return this.next;
		}// end getNext
		
   }// end Node class

   // NOTE:  NO header node.
   protected Node head = null;
   protected int  size = 0;

   // Return the present size of the linked list
   public int size()
   {  
		return size;
		
	}// end size
	
	/*********************************************************/
	/*********** Your Code Goes Below ************************/
	/*********************************************************/
   public void addFirst(Comparable data){
      if(size == 0){
         head = new Node(data);
      }
      else{
         Node nn = new Node(data);
         nn.next = head;
         head = nn;
      }
      size++;
   }
   
   public void clear(){
      head = null;
      size = 0;
   }
   
   public String toString(){
      String result = "";
      int i = 0;
      for(Node curr = head; curr != null; curr = curr.next){
         result = result + i + ". " + curr.data.toString() + "\n";
         i++;
      }
      return result;
   }
 }// end LinkedList class