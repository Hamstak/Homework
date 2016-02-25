public class BinMode extends Mode{
   public BinMode(String calculatorState){
      super(calculatorState,"Binary");
   }
   public LongInteger setNumber(String userInput) throws NumberMismatchException{
      userInput = LongInteger.normalize(userInput);
      String negator = (userInput.charAt(0) == '-') ? "-" : "";
      if (userInput.charAt(0) == '-')
         userInput = userInput.substring(1,userInput.length());
      if (!userInput.matches("[01]+"))
         throw new NumberMismatchException("Invalid binary numerical entry");
      return new BinaryInteger(negator + userInput);
   }
   public LongInteger setNumber(LongInteger number){
      return new BinaryInteger(number.value());
   }
}