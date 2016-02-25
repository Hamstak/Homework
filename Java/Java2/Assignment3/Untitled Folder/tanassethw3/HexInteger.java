public class HexInteger extends LongInteger {
   public HexInteger(String number){
      super(convertToNum(number,16));
   }
   public HexInteger(long number){
      super(number);
   }
   @Override
   public String toString(){
      return convertToString(16) + " (Hexidecimal)";
   }
   @Override
   public String toStringSimple(){
      return convertToString(16);
   }
}