public class Gremlin extends Monster{
   public Gremlin(){
      super("Gizmo, the Gremlin", 0.4, 20, 40, 70, 5, 0.8, 15, 30, "There will be no end to the gremlin menace!", "You've defeated the gremlin menace!", "Life Leech");
   }
   public void specialAttack(DungeonCharacter other){
      int amount = (int)(Math.random() * 10) + 30;
      amount = Math.min((amount + hp()),maxHp()) - hp();
      doAction(other,"attack %s for %d damage", other.name(),amount);
      other.modifyHp(-amount);
      doAction(other,"heal for %d health using %s", amount, skill);
      modifyHp(amount);
   }
}