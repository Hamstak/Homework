public class StringCleaning {
   public static void main(String[] args){
      System.out.print(stringClean("aabccc"));
   }
   private static String stringClean(String toBeCleaned){
      if (toBeCleaned.length() <= 1)
         return toBeCleaned;
      if (toBeCleaned.charAt(0) == toBeCleaned.charAt(1))
         return stringClean(toBeCleaned.substring(1));
      return toBeCleaned.charAt(0) + stringClean(toBeCleaned.substring(1));
   }
}