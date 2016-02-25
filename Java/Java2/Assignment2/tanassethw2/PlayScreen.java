import java.util.*;

public class PlayScreen implements Screen {
   private Hero actor;
   private Monster nemesis;
   
   public PlayScreen(Hero actor, Monster nemesis){
      this.actor = actor;
      this.nemesis = nemesis;
      actor.setTurns(nemesis);
      display();
      respondToUserInput();
      repaint();
   }
   public void display(){
      System.out.print(blockBuilder());
   }
   public Screen respondToUserInput(){   
      Scanner kb = new Scanner(System.in);
      kb.nextLine();
      return new BattleScreen(actor,nemesis);
   }
   
   private String blockBuilder(){
      String temp = "|  " + actor.name() + " and " + nemesis.name() + " take to the battlefield! |";
      String line = lineBuilder(temp.length());
      temp = line + "\n" + temp + "\n" + line + "\n";
      return temp;
   }
   private String lineBuilder(int length){
      String enter ="-=Press Enter=-";
      String line = "#";
      int adjust = (length%2 == 0 ? 1 : 1);
      for (int x = 0; x < 2; x++){
         for(int i = 0; i < (length - adjust - enter.length())/2; i++){
            line = line + "-";
         }
         if (x==0){
            line = line + enter;
         }

      }
      line = line + "#";
      return line;
   }
   public void repaint(){
      System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
   }
}