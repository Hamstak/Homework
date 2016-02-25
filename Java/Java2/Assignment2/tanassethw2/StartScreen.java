import java.util.*;

public class StartScreen implements Screen {
   public StartScreen(){
      display();
      respondToUserInput();
   }
   public void display(){
      System.out.print("#-----------------------#\n|  Heroes\t        |\n|        and\t        |\n|\t  Monsters!     |\n#-----------------------#");
      
   }
   public Screen respondToUserInput(){
      Scanner kb = new Scanner(System.in);
      String name = kb.nextLine();
      
      return new ClassScreen();
   }
   
   public void repaint(){
      System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n");
   }
   
}