public class ReferenceBasedList implements ListInterface{
   private Node head;
   private int size;
   
   public ReferenceBasedList(){
      this.head = null;
      this.size = 0;
   }
   public ReferenceBasedList(Node head){
      this.head = head;
      this.size = 1;
   }
   @Override
   public boolean isEmpty(){
      return (size == 0);
   }
   @Override
   public int getSize(){
      return size;
   }
   @Override
   public void addNode(Object item){
      Node temp = new Node(item);
      size++;
      if(isEmpty()){
         this.head = temp;
         return;
      }
      while(curr.next() != null)
         curr = curr.next();
      curr.setNext(temp);
   }
   @Override
   public void addNode(Object item, int index){
      Node temp = new Node(item);
      size++;
      if (index == 0){
         temp.setNext(head);
         this.head = temp;
         return;
      }
      Node curr = find(index - 1);
      temp.setNext(curr.next());
      curr.setNext(temp);
   }
   @Override
   public void removeNode(int index){
      size --;
      if (index == 0){
         this.head = head.next();
         return;
      }
      Node prev = find(index - 1);
      Node curr = prev.next();
      prev.setNext(curr.next);
   }
   @Override
   public void removeAll(){
      this.head = null;
      size = 0;
   }
   private Node find(int index){
      Node curr = head;
      for (int i = 0; i < index; i++){
         curr = curr.next();
      }
      return curr;
   }
}