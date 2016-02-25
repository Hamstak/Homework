public class LinkedListA extends LinkedList
{
     // NOTE:  this is NOT one of the methods in the Java API LinkedList
      // Precondition:  The list on entry is properly sorted.
		// Postcondition: List has new data and is in ascending order
      public void addOrdered(Comparable dataToAdd)
		{
			Node nn = new Node(dataToAdd);
         if (size == 0){
            head.next = nn;
         }else if (size == 1){
            if (head.next.data.compareTo(nn.data) < 0){
               head.next.next = nn;
            }else{
               nn.next = head.next;
               head.next = nn;
            }
         }else{
            Node prev = head;
            Node curr = head.next;
            while (curr != null){
               if (curr.data.compareTo(nn.data) >= 0){
                  nn.next = curr;
                  prev.next = nn;
                  break;
               }
               curr = curr.next;
               prev = prev.next;
            }
            if (curr == null)
               prev.next = nn;
         }
         size++;
		}// end addOrdered		
			
}// end class
