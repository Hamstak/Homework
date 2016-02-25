public abstract class Monster extends DungeonCharacter{
   private double chanceHeal;
   private int minHeal;
   private int maxHeal;
   private String victory;
   private String defeat;
   public String defeat(){ return defeat; }
   
   protected String skill;
   public String victory(){ return victory; }
   
   public Monster(String name, double chanceHeal,int minHeal,int maxHeal,int maxHp, int speed ,double hit, int damageMin, int damageMax, String victory, String defeat, String skill){
      super(maxHp, speed, damageMin, damageMax, hit,"");
      this.chanceHeal = chanceHeal;
      this.minHeal = minHeal;
      this.maxHeal = maxHeal;
      this.victory = victory;
      this.defeat = defeat;
      this.skill = skill;
      setName(name);
   }
   public void attack(Hero other){
      if (Math.random() > hit()){
         doAction(other,"miss the %s", other.name());
         return;
      }
      String message = "";
      if (Math.random() < chanceHeal){
         int amount = (int)(Math.random() * (maxHeal - minHeal)) + minHeal;
         amount = Math.min(amount+hp(),maxHp()) - hp();
         doAction(other,"heal %d health", amount);
         modifyHp(amount);      
      }
      if (Math.random() > other.block()){
         other.blockNotify();
         return;
      }
      int amount = (int)(Math.random() * (damageMax - damageMin)) + damageMin;
      doAction(other,"attack %s for %d damage", other.name(), amount);
      other.modifyHp(-amount);
   }
   public abstract void specialAttack(DungeonCharacter other);
}