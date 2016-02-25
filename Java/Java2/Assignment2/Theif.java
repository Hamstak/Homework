public class Theif extends Hero{
   public Theif(){
      super(75,6,20,40,.8,.4,"Surprise Attack");
   }
   public void specialAttack(DungeonCharacter other){
      if (Math.random() > .2){
         doAction(other, "miss the %s with Surprise Attack", other.name());
         return;
      }
      doAction(other, "attack the %s using %s", other.name(), skill());
      addTurn();
      attack(other);
   }
}