/* Tim Tanasse
 * Assignment 5: Linked List
 * EC attempted
 * May 28th 2015
*/
public class LinkedListTester{
   public static final String[] OPTIONS = {" Create new list", " Sort the list", " Print the list", " Print the list in reverse", " Generate a sublist with even data", " Print every nth node", " Delete by content", " Delete the list"," Quit"};
   public static void main(String[] args){
      LinkedList list = new LinkedList();
      int option = UserUtil.dynamicMenu(OPTIONS);
      System.out.print("Enter your choice -> ");
      while(option < OPTIONS.length){
         switch(option){
            case 1: initializeList(list);
            break;
            case 2: sortList(list);
            break;
            case 3: System.out.println(list.toString());
            break;
            case 4: System.out.println(list.revToString());
            break;
            case 5: System.out.println(generateEvenSublist(list).toString());
            break;
            case 6: printNth(list);
            break;
            case 7:removeByContent(list);
            break;
            case 8:list.removeAll();
            System.out.println("The list has been cleared!");
         }
         option = UserUtil.dynamicMenu(OPTIONS);
      }
   }
   
   public static void initializeList(LinkedList list){
      if(!list.isEmpty())
         list.removeAll();
      System.out.print("Enter the amount of nodes you want -> ");
      int size = UserUtil.getUserPositiveInt();
      for(int i = 0; i < size; i++){
         list.insert(new Integer((int)(Math.random() * 100)));
      }
      System.out.println("The list is initialized and sorted!");
   }
   
   public static void sortList(LinkedList list){
      if(list.isEmpty())
         System.out.println("The list is empty!");
      else
         System.out.println("The list is already sorted!");
   }
   
   public static LinkedList generateEvenSublist(LinkedList list){
      LinkedList temp = list.modSublist(2);
      return temp;
   } 
   
   public static void printNth(LinkedList list){
      System.out.print("Enter n, where ever nth node is printed -> ");
      int n = UserUtil.getUserPositiveInt();
      System.out.println(list.toStringN(n));
   }  
   public static void removeByContent(LinkedList list){
      System.out.print("Enter the integer you want to remove by -> ");
      Integer data = new Integer(UserUtil.getUserInt());
      System.out.println(list.remove(data) + " Objects removed from the list.");
   }
}