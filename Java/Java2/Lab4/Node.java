public class Node{
   
   private Object item;
   public Object item(){ return item; }
   public void setItem(Object item) { this.item = item; }
   
   private Node next;
   public Node next(){return next; }
   public void setNext(Node next){ this.next = next; }
   
   public Node(Object item){
      this.item = item;
      this.next = null;
   }
   
   public Node(Object item, Node next){
      this.item = item;
      this.next = next;
   }
   
   
}