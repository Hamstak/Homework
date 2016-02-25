public class Recursion3nPlus1{
   public static void main(String[] args){
      rec3nPlus1(22);
   }
   private static void rec3nPlus1(int number){
      System.out.print(number + " ");
      if (number == 1)
         return;
      rec3nPlus1(number % 2 == 0 ? number/2 : (number * 3) + 1);
   }
}