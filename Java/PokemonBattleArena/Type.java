public enum Type{
   NORMAL (0),
   FIGHTING(1),
   FLYING (2),
   POISON (3),
   GROUND (4),
   ROCK (5),
   BUG (6),
   GHOST (7),
   STEEL (8),
   FIRE (9),
   WATER (10),
   GRASS (11),
   ELECTRIC (12),
   PSYCHIC (13),
   ICE (14),
   DRAGON (15),
   DARK (16);
   
   private int index;
   public int index(){return index;}
   
   Type(int index){
      this.index = index;
   }
   public static Type type(String type){
      switch(type){
         case "NORMAL": return NORMAL;
         case "FLYING": return FLYING;
         case "FIGHTING": return FIGHTING;
         case "POISON": return POISON;
         case "GROUND": return GROUND;
         case "ROCK": return ROCK;
         case "BUG": return BUG;
         case "STEEL": return STEEL;
         case "GHOST": return GHOST;
         case "FIRE": return FIRE;
         case "WATER": return WATER;
         case "GRASS": return GRASS;
         case "ELETRIC": return ELECTRIC;
         case "PSYCHIC": return PSYCHIC;
         case "ICE": return ICE;
         case "DRAGON": return DRAGON;
         case "DARK": return DARK;
      }
      return null;
   }
}