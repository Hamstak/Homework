public class RecursionTester{
   public static void main(String[] args){
      System.out.println(factorial(10));
   }
   private static long factorial(int i){
      if (i > 0)
         return i * factorial(i - 1);
      return 1;
   }
}