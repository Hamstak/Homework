import java.util.*;

public class ClassScreen implements Screen{
   public ClassScreen(){
      repaint();
      display();
      respondToUserInput();
   }
   public void display(){
      System.out.print("#-------------------------------------------------#\n|                  Choose a class:                |\n|  Warrior    Sorceress    Theif    Karate Master |\n#-------------------------------------------------#\n Choose a class -> ");
   }
   
   public Screen respondToUserInput(){
      Scanner kb = new Scanner(System.in);
      String temp = kb.nextLine();
      temp = temp.toLowerCase();
      Hero actor;
      
      switch(temp){
         case "warrior" : actor = new Warrior();
         break;
         case "sorceress": actor = new Sorcerer();
         break;
         case "theif": actor = new Theif();
         break;
         case "karate master": actor = new KarateMaster();
         break;
         default: return new ClassScreen();
      }
      return new PlayScreen(actor, generateMonster());
   }
   
   public void repaint(){
      System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n");
   }
   
   private Monster generateMonster(){
      int temp = (int)(Math.random() * 3) + 1;
      switch(temp){
         case 1: return new Ogre();
         case 2: return new Skeleton();
         case 3: return new Gremlin();
      }
      return null;
   }
}