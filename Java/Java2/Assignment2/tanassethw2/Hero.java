/*
 *
 */
 
 import java.util.*;
 
 public abstract class Hero extends DungeonCharacter{
   private double block;
   public double block(){ return block; }
   private int turns;
   public int turns() { return turns; }
   
   private List<String> messages;
   public List<String> messages() { return messages; }
   
   public Hero(int maxHp, int speed, int damageMin, int damageMax, double hit, double block, String skill){
      super(maxHp, speed, damageMin, damageMax, hit, skill);
      this.block = block;
      System.out.print("Enter you name -> ");
      setName(UserUtil.getUserString());
      System.out.println();
      messages = new ArrayList<String>();
   }
   public void setTurns(DungeonCharacter other){
      turns = speed()/other.speed();
      turns = Math.max(turns,1);
   }
   public void addTurn(){
      this.turns++;
   }
   public void subTurn(){
      this.turns--;
   }
   public void notify(String message, Object ... params){
      messages.add(String.format(message,params));
   }
   public void removeMessages(){
      if(messages.size() == 0)
         return;
      while(messages.size() != 0){
         messages.remove(0);
      }
   }
   public void blockNotify(){
      notify("You block the attack.");
   }
   
   public abstract void specialAttack(DungeonCharacter other);
 }