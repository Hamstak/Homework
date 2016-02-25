import java.util.Scanner;
/**
 *Does the stuff for the recursive assignment.
 *@author Tim Tanasse
 */
public class SubstringTester{
   public static void main(String[] args){
      System.out.print("\nEnter a string -> ");
      Scanner kb = new Scanner(System.in);
      String word = kb.nextLine();
      System.out.println();
      ascend(word);
      System.out.print("Would you like to do this again? (y/n): ");
      if (kb.nextLine().equals("y"))
         main(new String[0]);
      else
         System.exit(0);
   }
   /**
    *Prints the word and ascends as a substring through the word. Feeds to descend() before processing.
    *Recursively ascends the string word as a substring cutting off the first element.
    *@param word Any string
    *@exception none
    */
   public static void ascend(String word){
      if (word.length() == 0){
         System.out.println("\"\"");
         return;
      }
      descend(word);
      ascend(word.substring(1));
   }
   /**
    *Prints the word and descends as a substring through the word.
    *Recursively descends through a string as a substring removing the last element.
    *@param word Any string
    *@exception none
    */
   public static void descend(String word){
      if (word.length() == 0)
         return;
      System.out.println(word);
      descend(word.substring(0, word.length() - 1));
   }
}