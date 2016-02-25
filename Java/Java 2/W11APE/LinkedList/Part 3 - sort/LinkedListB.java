public class LinkedListB extends LinkedListA
{
   public void sort(){
      //Some basic edge case testing
      if(size <= 1)
         return;
         
      //Setting up to sort,
      //but also filling a Comparable array with the data from the list,
      //because sorting an actual linkedList is a lot slower   
      Comparable switcher;
      Comparable[] temp = new Comparable[size];
      Node curr = head;
      for(int i = 0; i < size; i++){
         temp[i] = curr.data;
         curr = curr.next;
      }
      
      //Simple selection sort
      int indexSmallest;
      for (int posFill = 0; posFill < temp.length - 1; posFill++){
         indexSmallest = posFill;
         for (int current = posFill; current < temp.length; current++){
            if (temp[current].compareTo(temp[indexSmallest]) < 0)
               indexSmallest = current;
         }
         switcher = temp[posFill];
         temp[posFill] = temp[indexSmallest];
         temp[indexSmallest] = switcher;
      }
      
      //Rebuilding the list
      head = new Node(temp[0]);
      curr = head;
      for (int i = 1; i < temp.length; i++){
         curr.next = new Node(temp[i]);
         curr = curr.next;
      }
   }
}// end class