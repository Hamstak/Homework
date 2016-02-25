public class LinkedListA extends LinkedList
{
   	public void addLast(Comparable data){
         Node nn = new Node(data); 
         if (size == 0){
            head = nn;
         }else{
            Node curr = head;
            while(curr.next != null){
               curr = curr.next;
            }
            curr.next = nn;
         }
         size++;
      }
}// end class
