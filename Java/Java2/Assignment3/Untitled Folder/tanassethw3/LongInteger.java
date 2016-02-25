import java.util.*;

public abstract class LongInteger{
   public static final String[] NUMBERS = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
   private long value;
   public long value() { return value; }
   public void setValue(long value) { this.value = value; }
   
   private boolean negative;
   public boolean negative(){ return negative; }

   
   public LongInteger(long value){
      this.value = value;
      checkNegative();
   }
   
   public LongInteger(){
      this.value = 0;
      this.negative = false;
   }
   public LongInteger(long value, boolean negative){
      this.value = value;
      this.negative = negative;
   }
   
   public void add(LongInteger other){
      this.value = this.value() + other.value();
      checkNegative();
   }
   
   public void subtract(LongInteger other){
      this.value = this.value() - other.value();
      checkNegative();
   }
   
   public void multiply(LongInteger other){
      this.value = this.value() * other.value();
      checkNegative();
   }
   
   public void divide(LongInteger other){
      this.value = this.value() / other.value();
      checkNegative();
   }
   
   protected void checkNegative(){
      if (value < 0){
         negative = true;   
         return;
      }
      negative = false;
   }
   
   public static long convertToNum(String number, int base){
      boolean negative = false;
      if (number.charAt(0) == '-'){
         negative = true;
         number = number.substring(1,number.length());
      }
      switch(base){
         case 2: return negative ? -binDec(number) : binDec(number);
         case 8: return negative ? -octalDec(number) : octalDec(number);
         case 10: return negative ? -decNum(number) : decNum(number);
         case 16: return negative ? -hexDec(number) : hexDec(number);
      }
      return 0;
   }
   private static long binDec(String number){
      long temp = 0;
      for (int i = number.length() - 1; i >= 0; i--){
         if (number.charAt(i) == '1'){
            temp += Math.pow(2,number.length() - 1 - i);
         }
      }
      return temp;
   }
   private static long octalDec(String number){
      long temp = 0;
      for (int i = number.length() - 1; i >= 0; i--){
         temp += (Integer.parseInt(number.substring(i,i + 1)) * Math.pow(8,number.length() - 1 - i));
      }
      return temp;
   }
   private static long decNum(String number){
      long temp = 0;
      for (int i = number.length() - 1; i >= 0; i--){
            temp += (Integer.parseInt(number.substring(i,i+1)) * Math.pow(10,number.length() - 1 - i));
      }
      return temp;
   }
   private static long hexDec(String number){
      long temp = 0;
      for (int i = number.length() - 1; i >= 0; i--){
         if (number.substring(i,i+1).matches("[0-9]")){
            temp += (Integer.parseInt(number.substring(i,i+1)) * Math.pow(16,number.length() - 1 - i));
         }else{
            int m = number.length() - 1 - i;
            switch(number.charAt(i)){
               case 'a':
               case 'A': temp += 10 * Math.pow(16,m);
               break;
               case 'b':
               case 'B': temp += 11 * Math.pow(16,m);
               break;
               case 'c':
               case 'C': temp += 12 * Math.pow(16,m);
               break;
               case 'd':
               case 'D': temp += 13 * Math.pow(16,m);
               break;
               case 'e':
               case 'E': temp += 14 * Math.pow(16,m);
               break;
               case 'f':
               case 'F': temp += 15 * Math.pow(16,m);
            }
         }
      }
      return temp;
   }
   private String convertString(){
      return "" + value;
   }
   public static String normalize(String number){
      String negator = (number.charAt(0) == '-') ? "-" : "";
      int d = (number.charAt(0) == '-' ? 1 : 0);
      if (number.charAt(0 + d) == '0' && number.length() > 1){
         if (number.charAt(1 + d) == 'x'){
            return negator + number.substring(2 + d,number.length());
         }
         return negator + number.substring(1 + d,number.length());
      }
      return negator + number.substring(0 + d,number.length());
   }
   protected String convertToString(int base){
      List<String> number = new ArrayList<String>();
      String negator = "";
      long temp = value();
      if (temp == 0)
         return "0";
      if (temp < 0){
         negator = "-";
         temp = Math.abs(temp);
      }
      while (temp > 0){
         number.add(NUMBERS[(int)(temp % base)]);
         temp /= base;
      }
      Collections.reverse(number);
      String tempString = "";
      for (String s : number){
         tempString += s;
      }
      return negator + tempString;
   }
   public abstract String toStringSimple();
}