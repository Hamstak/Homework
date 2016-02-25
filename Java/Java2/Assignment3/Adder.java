public class Adder implements Functor{
   LongInteger number;
   
   public Adder(LongInteger number){
      this.number = number;
   }
   
   public LongInteger function(LongInteger other){
      number.add(other);
      return number;
   }
   
   //public boolean functionCheck(LongInteger other){
   //   Adder temp = new Adder(number);
   //   if(temp)
   //}
}