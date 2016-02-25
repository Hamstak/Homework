public class BinaryTester{
   public static void main(String[] args){
      LongInteger test = new HexInteger("");
      LongInteger test2 = new HexInteger("abc");
      test.add(new HexInteger("ade"));
      System.out.println(test.toString() + ", " + test.value());
      System.out.println(test2.toString()+ ", " + test2.value());
      test2.multiply(new HexInteger("ee"));
      test.subtract(test2);
      System.out.println(test.toString() + ", " + test.value());
      System.out.println(test2.toString()+ ", " + test2.value());
   }
}