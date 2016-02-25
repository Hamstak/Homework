/* Tim Tanasse
 * Assignment Inheritence 1; Heroes and Monsters
 * April 8th, 2015
 */
 
 import java.util.*;
 
 public abstract class DungeonCharacter{
   private String name;
   public String name(){ return name; }
   public void setName(String name) { this.name = name; }
   
   private int maxHp;
   public int maxHp() { return maxHp; }
   
   private int hp;
   public int hp(){ return hp; }
  
   private int speed;
   public int speed(){ return speed; }
  
   protected int damageMin;
   protected int damageMax;
   
   private double hit;
   public double hit() { return hit; }
   
   private String skill;
   public String skill(){ return skill; }
      
   public DungeonCharacter(int maxHp, int speed, int damageMin, int damageMax, double hit, String skill){
      this.maxHp = maxHp;
      this.hp = maxHp;
      this.speed = speed;
      this.damageMin = damageMin;
      this.damageMax = damageMax;
      this.hit = hit;
      this.skill = skill;
   }
   public void attack(DungeonCharacter other){
      if (Math.random() > hit){
         doAction(other,"miss the %s", other.name);
         return;
      }
      int amount = (int)(Math.random() * (damageMax - damageMin)) + damageMin;
      doAction(other,"attack %s for %d damage", other.name, amount);
      other.modifyHp(-amount);
   }
   public double chanceToBlock() { return 0.0; };
   public void modifyHp(int amount){
      hp += amount;
   }
   public void doAction(DungeonCharacter other, String message, Object ... params){				
				if (other == null)
					return;
			   notify("You " + message + ".",params);
			   other.notify(String.format("The '%s' %s.",name,makeSecondPerson(message)),params);
	}
   private String makeSecondPerson(String message){
      String[] words = message.split(" ");
      if (words[0].equals("miss"))
         words[0] = words[0] + "es";
      else
         words[0] = words[0] + "s";
      
      StringBuilder builder = new StringBuilder();
      for (String word: words){
         builder.append(" ");
         builder.append(word);
      } 
      return builder.toString().trim();
   }
   public void notify(String message, Object ... params){}
   
   public abstract void specialAttack(DungeonCharacter other);
 }