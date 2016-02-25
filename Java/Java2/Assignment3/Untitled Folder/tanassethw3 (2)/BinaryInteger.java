import java.util.*;

public class BinaryInteger extends LongInteger{
   public BinaryInteger(String number){
      super(convertToNum(number,2));
   }
   public BinaryInteger(long number){
      super(number);
   }
   @Override
   public String toString(){
      return convertToString(2) + " (Binary)";
   }
   @Override
   public String toStringSimple(){
      return convertToString(2);
   }
}