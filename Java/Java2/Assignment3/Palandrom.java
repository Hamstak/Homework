public class Palandrom {
   public static void main(String[] args){
      System.out.print(isPalandrom(""));
   }
   private static boolean isPalandrom(String word){
      if (word.length() <= 1)
         return true;
      if (word.charAt(0) == word.charAt(word.length() - 1))
         return isPalandrom(word.substring(1,word.length() - 1));
      return false;
   }
}