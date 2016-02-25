public class LinkedListD extends LinkedListC
{
   // If the list is empty, print the message "The list is empty."
   // Otherwise list all the data fields, one to a line --- IN REVERSE.
   public void listReverse(){
      if (size == 0){
         System.out.print("The list is empty.");
         return;
      }
      System.out.print(listReverseHelper(head));  
   }
   public String listReverseHelper(Node curr){
      if (curr.next == null)
         return curr.data.toString();
      return listReverseHelper(curr.next) + "\n" + curr.data.toString();
   }
}// end class
