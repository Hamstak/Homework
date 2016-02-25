import java.util.*;

public class OctalInteger extends LongInteger {
   public OctalInteger(String number){
      super(convertToNum(number,8));
   }
   public OctalInteger(long number){
      super(number);
   }
   @Override
   public String toString(){
      return convertToString(8) + " (Octal)";
   }
   @Override
   public String toStringSimple(){
      return convertToString(8);
   }
}