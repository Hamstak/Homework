public class Ogre extends Monster{
   public Ogre(){
      super("Shrek, the Ogre", 0.1, 30, 60, 200, 2, 0.6, 30, 60, "Get out of my swamp!", "Shrek\n...\nis\n...\nlove.","Crushing Blow");
      
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