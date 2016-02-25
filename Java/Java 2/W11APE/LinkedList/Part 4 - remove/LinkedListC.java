public class LinkedListC extends LinkedListB
{
   public Comparable remove(int index)throws IndexOutOfBoundsException{
      if (index > size - 1 || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", " + "Size: " + size);
      Node temp;
      if (index == 0){
         temp = head;
         head = head.next;
      }else{
         Node curr = head;
         for (int i = 0; i < index - 1; i++){
            curr=curr.next;
         }
         temp = curr.next;
         curr.next = curr.next.next;
      }
      size--;
      return temp.data;
   }
	
	
	
		
}// end class