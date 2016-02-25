public class DecimalInteger extends LongInteger{
   public DecimalInteger(String number){
      super(convertToNum(number,10));
   }
   public DecimalInteger(long number){
      super(number);
   }
   @Override
   public String toString(){
      return convertToString(10) + " (Decimal)";
   }
   @Override
   public String toStringSimple(){
      return convertToString(10);
   }
}