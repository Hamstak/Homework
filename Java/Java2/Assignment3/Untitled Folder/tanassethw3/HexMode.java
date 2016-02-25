public class HexMode extends Mode{
   public HexMode(String calculatorState){
      super(calculatorState, "Hexidecimal");
   }
   public LongInteger setNumber(String userInput) throws NumberMismatchException{
      userInput = LongInteger.normalize(userInput);
      String negator = userInput.charAt(0) == '-' ? "-" : "";
      if (userInput.charAt(0) == '-')
         userInput = userInput.substring(1,userInput.length());
      userInput = userInput.toLowerCase();
      if(!userInput.matches("[0-9,a-f]+") || userInput.length() > 16)
         throw new NumberMismatchException("Invalid hexidecimal numerical entry");
      return new HexInteger(negator + userInput);
   }
   public LongInteger setNumber(LongInteger number){
      return new HexInteger(number.value());
   }
}