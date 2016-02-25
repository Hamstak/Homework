public class LinkedList{
   private class Node{
      public Integer data;
      public Node next;
      
      public Node(Integer data){
         this.data = data;
         this.next = null;
      }
      
      public Node(Integer data, Node next){
         this.data = data;
         this.next = next;
      }
   }
   private int size;
   public int size() { return size; }
   
   private Node head;
   private Node tail;
   
   public Integer tailData() { return tail.data; }
   
   public LinkedList(){
      this.head = null;
      this.size = 0;
   }
   public LinkedList(Integer data){
      this.head = new Node(data);
      this.size = 1;
   }
   public boolean isEmpty(){
      return size == 0;
   }
   public void addFirst(Integer data){
      Node newNode = new Node(data);
      if (isEmpty()){
         head = newNode;
         tail = newNode;
      }
      else{
         newNode.next = head;
         head = newNode;
      }
      size++;
   }
   
   public void insert(Integer data){
      Node newNode = new Node(data);
      if (isEmpty()){
         head = newNode;
         tail = newNode;
         size++;
         return;
      }else if (size == 1){
         if (head.data.compareTo(data) > 0)
            addLast(data);
         else
            addFirst(data);
         return;
      }else if (head.data.compareTo(data) < 0){
         newNode.next = head;
         head = newNode;
      }else{
         Node curr = head;
         size++;
         while (curr.next != null){
            if (curr.next.data.compareTo(data) <= 0){
               newNode.next = curr.next;
               curr.next = newNode;
               return;
            }
            curr = curr.next;
         }
         curr.next = newNode;
         tail = newNode;
         return;
      }
      size++;
   }
   public void addLast(Integer data){
      Node newNode = new Node(data);
      if (isEmpty()){
         head = newNode;
         tail = newNode;
         return;
      }else{
         Node curr = head;
         while (curr.next != null){
             curr = curr.next;
         }
         curr.next = newNode;
         tail = newNode;
      }
      size++;
   }
   public int remove(Integer data){
      int amount = 0;
      if (isEmpty()){
         return 0;
      }
      if (size == 1){
         if (head.data.compareTo(data) == 0){
            size--;
            amount++;
            head = null;
            tail = null;
         }
      }else{
         Node prev = head;   
         Node curr = head.next;
         while(curr.next != null){
            if (prev.data.compareTo(data) == 0){
               size--;
               amount++;
               head = prev.next;
               prev = head;
               curr = head.next;
            }else if (curr.data.compareTo(data) == 0){
               size --;
               amount++;
               if (curr.next.next == null){
                  prev.next = curr.next;
                  tail = prev;
               }else{
                  prev.next = curr.next;
                  curr = curr.next;
               }
            }else{
               prev = curr;
               curr = curr.next;
            }
         }
         if (prev.next.data.compareTo(data) == 0){
            size--;
            amount++;
            prev.next = null;
            tail = prev;
         }
      }
      return amount;
   }
   public void removeAll(){
      head = null;
      size = 0;
   }
   public String toString(){
      if (isEmpty())
         return "The list is empty!";
      String result = "";
      Node curr;
      for (curr = head; curr.next != null; curr = curr.next){
         result = result + curr.data.toString() + ", ";
         
      }
      result = result + curr.data.toString();
      return result;
   }
   public String revToString(){
      if (isEmpty())
         return "The list is empty!";
      return revToString(head);
   }
   private String revToString(Node curr){
      if (curr.next == null)
         return curr.data.toString();
      else
         return revToString(curr.next) + ", " + curr.data.toString();
   }
   public String toStringN(int skip){
      if (skip > size)
         return "The amount skipped is larger than the size of the list!";
      Node curr = head;
      String result = "";
      if (isEmpty())
         return "The list is empty!";
      while(curr != null){
         for (int i = 0; i < skip; i++){
            if (curr == head)
               i++;
            if (curr == null)
               return result;
            curr = curr.next;
         }
         if (curr == null)
            return result;
         result = result + curr.data.toString() + ", ";
      }
      return result;
   }
   public LinkedList modSublist(int mod){
      LinkedList temp = new LinkedList();
      for (Node curr = this.head; curr != null; curr = curr.next){
         if (curr.data.intValue() % mod == 0)
            temp.insert(curr.data);
      }
      return temp; 
   }
}