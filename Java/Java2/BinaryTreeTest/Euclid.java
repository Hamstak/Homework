public class Euclid{
   public static void main(String[] args){
      System.out.print(gcd(40,12));
   }
   private static int gcd(int num1, int num2){
      if (num2 == 0)
         return num1;
      return gcd(num2,num1 % num2);
   }
}