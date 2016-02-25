/*
 *
 */
 
 public class Sorcerer extends Hero{
   public Sorcerer(){
      super(75, 6, 25, 45, .7, .3, "Heal");
   }
   public void specialAttack(DungeonCharacter other){
      int amount = (int)(Math.random() * 50) + 40;
      amount = Math.min(amount + hp(), maxHp()) - hp();
      doAction(other, "heal for %d using %s", amount, skill());
      modifyHp(amount);
   }
 }