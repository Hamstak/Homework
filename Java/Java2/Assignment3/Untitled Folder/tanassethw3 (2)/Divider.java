public class Divider implements Functor{
   LongInteger number;
   
   public Divider(LongInteger number){
      this.number = number;
   }
   
   public LongInteger function(LongInteger other){
      number.divide(other);
      return number;
   }
}