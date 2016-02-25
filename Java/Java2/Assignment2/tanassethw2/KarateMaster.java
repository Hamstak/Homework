public class KarateMaster extends Hero{
   public KarateMaster(){
      super(120,5,30,70,.8,.3,"Hadoken");
   }
   public void specialAttack(DungeonCharacter other){
      if (Math.random() < .2){
         doAction(other, "miss the %s attack", skill());
         return;
      }
      doAction(other,"attack %s with %s for %d damage", other.name(),skill(),45);
      other.modifyHp(-45);
   }
}