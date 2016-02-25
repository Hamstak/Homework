public class Multiplier implements Functor{
   LongInteger number;
   
   public Multiplier(LongInteger number){
      this.number = number;
   }
   
   public LongInteger function(LongInteger other){
      number.multiply(other);
      return number;
   }
}