public class PrinterBackwarders{
   public static void main(String[] args){
      System.out.println(pbw("hello"));
   }
   private static String pbw(String s){
      if (s.length() == 1)
         return s;
      return s.substring(s.length() - 1, s.length()) + pbw(s.substring(0,s.length() - 1));
   }
}