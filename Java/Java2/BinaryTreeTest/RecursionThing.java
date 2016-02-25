public class RecursionThing{
   public static void main(String[] args){
      System.out.print(pow(2,6) + "\n");
      System.out.print(1/pow(2,6));
   }
   private static double pow(int base, int expon){
      if (expon < 0)
         return 1 / pow(base, -expon);
      if (expon == 0)
         return 1;
      return base * pow(base,expon - 1);
   }
}