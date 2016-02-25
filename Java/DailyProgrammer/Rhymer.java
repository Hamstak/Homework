public class Rhymer {
   public static void main(String[] args){
      rhyme("Arnold");
      rhyme("Billy");
      rhyme("Tim");
   }
   private static void rhyme(String name){
      String[] specialLetters = {"B","F","M"};
      String[] shortNames = shorten(0,name, specialLetters, new String[3]);
      System.out.println(name + " " + name + " bo" + shortNames[0]);
      System.out.println("Bonana fanna fo" + shortNames[1]);
      System.out.println("Fee fy mo" + shortNames[2] + "\n" + name + "!\n");
   }
   private static String[] shorten(int index,String name,String[] specialLetters,String[] shortNames){
      if (index == 3)
         return shortNames;
      if (name.substring(0,1).equalsIgnoreCase(specialLetters[index])){
         shortNames[index] = adder("-",name.toLowerCase());
         return shorten((index + 1),name,specialLetters,shortNames);
      }
      shortNames[index] = adder(" " + specialLetters[index],name.toLowerCase());
      return shorten((index + 1),name,specialLetters,shortNames);
   }
   private static String adder(String addition, String name){
      if ("qwrtypsdfghjklzxcvbnm".contains(name.substring(0,1)))
         return adder(addition, name.substring(1,name.length()));
      return addition + name;
   }
}