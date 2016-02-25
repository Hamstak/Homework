import java.util.*;

public class DefeatScreen implements Screen{
   private Hero actor;
   private Monster nemesis;
   public DefeatScreen(Hero actor, Monster nemesis){
      this.actor = actor;
      this.nemesis = nemesis;
      display();
      respondToUserInput();
      System.exit(0);
   }
   public void display(){
      for(String s: actor.messages()){
         System.out.println(s);
      }
      System.out.println(nemesis.victory());
      System.out.print("You Lose!");
   }
   public Screen respondToUserInput(){
      Scanner kb = new Scanner(System.in);
      kb.nextLine();
      return null;
   }
   public void repaint(){
      System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
   }
}