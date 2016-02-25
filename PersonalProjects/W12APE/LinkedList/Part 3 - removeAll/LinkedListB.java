public class LinkedListB extends LinkedList
{
 	public boolean removeAll(Integer [] array)
	{	
      if (array == null)
         throw new IllegalArgumentException();
      int tempSize = size;
      for (Node curr = head; curr.next != null; curr = curr.next){
         boolean changed = true;
         while (changed == true){
            changed = false;
            if (curr.next == null)
               break;
            for (int i = 0; i < array.length; i++){
               if (curr.next.data.compareTo(array[i]) == 0){
                  curr.next = curr.next.next;
                  size--;
                  changed = true;
                  break;
               }
            }
         }
         if (curr.next == null){
            break;
         }
      }
      if(size != tempSize)
         return true;
      return false;
	}// end removeAll
	
	   	
}// end class