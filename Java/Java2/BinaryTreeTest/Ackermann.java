public class Ackermann{
   public static void main(String[] args){
      System.out.print(ackermann(3,4));
   }
   private static long ackermann(long m, long n){
      if (m == 0)
         return n + 1;
      if (n == 0)
         return ackermann(m - 1, 1);
      return ackermann(m - 1, ackermann(m,n-1));
   }
}