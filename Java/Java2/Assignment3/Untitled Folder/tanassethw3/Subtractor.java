public class Subtractor implements Functor{
   LongInteger number;
   
   public Subtractor(LongInteger number){
      this.number = number;
   }
   public LongInteger function(LongInteger other){
      number.subtract(other);
      return number;
   }
}