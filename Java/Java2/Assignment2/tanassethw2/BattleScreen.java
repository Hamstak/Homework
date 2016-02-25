import java.util.*;
public class BattleScreen implements Screen{
   private Hero actor;
   private Monster nemesis;
   
   public BattleScreen(Hero actor, Monster nemesis){
      this.actor = actor;
      this.nemesis = nemesis;
      repaint();
      display();
      respondToUserInput();
   }
   public void display(){
      if (actor.hp() <= 0){
         defeat();
      }
      if (nemesis.hp() <= 0){
         victory();
      }
      if (actor.turns() > 0){
         Scanner kb = new Scanner(System.in);
         String display = blockBuilder();
         System.out.print(display);
         System.out.print("Enter your choice -> ");
      }else{
         attacking();
      }
   }
   public Screen attacking(){
      if (Math.random() < .3){
         nemesis.specialAttack(actor);
      }else{
         nemesis.attack(actor);
      }
      actor.setTurns(nemesis);
      return new BattleScreen(actor,nemesis);
   }
   public Screen respondToUserInput(){
      Scanner kb = new Scanner(System.in);
      String choice = kb.nextLine();
      choice = choice.toLowerCase();
         switch(choice){
            case "hadoken":
            case "crushing blow":
            case "surprise attack":
            case "heal": actor.specialAttack(nemesis);
            actor.subTurn();
            break;
            case "quit": System.exit(0);
            break;
            case "attack": actor.attack(nemesis);
            actor.subTurn();
            break;
            default: return instruction(); 
         }
      return new BattleScreen(actor, nemesis);
   }
   private String blockBuilder(){
       String messages ="";
       if (actor.messages() != null){
         for(String s: actor.messages()){
            messages = messages + s + "\n";
         }
         actor.removeMessages();
       }
       String nameSpace =String.format("| -=%-20s hp: %3d=-  -=%-20s hp: %3d=- |", actor.name(), actor.hp(), nemesis.name(), nemesis.hp()); 
       String temp =nameSpace +"\n| make a choice:\t\t\t\t\t\t     |\n" + String.format("| 1. Attack\t\t\t\t\t\t\t     |\n| 2. %-15s\t\t\t\t\t\t     |", actor.skill());
       String line = lineBuilder(nameSpace.length());
       temp = messages + line + "\n" + temp + "\n" + line + "\n";
       return temp;
   }
   private String lineBuilder(int length){
      String enter ="-=Choose and Press Enter=-";
      String line = "#";
      for (int x = 0; x < 2; x++){
         for(int i = 0; i < (length - enter.length())/2 -1; i++){
         line = line + "-";
         }
         if (x == 0){
            line = line + enter;
         }
      }
      line = line + "#";
      return line;

   }
   public void repaint(){
      System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
   }
   public Screen instruction(){
      Scanner kb = new Scanner(System.in);
      System.out.println("=-Input either the name of the special attack, 'attack', or quit=- \n                -=Press enter to continue=-");
      kb.nextLine();
      return new BattleScreen(actor, nemesis);
   }
   public void victory(){
      Screen victory = new VictoryScreen(actor, nemesis);
   }
   public void defeat(){
      Screen defeat = new DefeatScreen(actor, nemesis);
   }
}