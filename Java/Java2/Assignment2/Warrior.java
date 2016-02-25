/*
 *
 */
 
 public class Warrior extends Hero{
   private String skillName;
   public Warrior(){
      super(125, 4, 35, 60, .8, .2, "Crushing Blow");
   }
   public void specialAttack(DungeonCharacter other){
      if (Math.random() < .4){
         doAction(other, "miss the %s", other.name());
         return;
      }
      int amount = (int)(Math.random() * 100) + 75;
      doAction(other, "attack the %s using %s for %d damage", other.name(), skill(), amount);
      other.modifyHp(-amount);
   }
 }