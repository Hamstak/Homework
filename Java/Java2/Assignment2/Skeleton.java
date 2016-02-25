public class Skeleton extends Monster{
   public Skeleton(){
      super("Mr.Skeleton", 0.3, 30, 50, 100, 3, 0.8, 30, 50, "\" You want to leave Mr.Skeletons Wild Ride.\"", "Mr.Skeletons Wild Ride is over!", "Reckless Assault");
   }
   public void specialAttack(DungeonCharacter other){
      if (Math.random() < .5){
         doAction(other, "miss the %s attack",skill);
         return;
      }
      int amount = (int)(Math.random() * 70)+30;
      amount = (amount - other.hp()) > 0 ? amount : (other.hp() - 1);
      doAction(other, "attack %s with %s for %d damage", other.name(), skill,amount);
      doAction(other, "attack themself for 30 damage");
      modifyHp(-30);
      other.modifyHp(-amount);
   }
}