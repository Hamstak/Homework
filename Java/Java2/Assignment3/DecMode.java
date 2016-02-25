public class DecMode extends Mode{
   public DecMode(String calculatorState){
      super(calculatorState, "Decimal");
   }
   public LongInteger setNumber(String userInput) throws NumberMismatchException{
      userInput = LongInteger.normalize(userInput);
      String negator = userInput.charAt(0) == '-' ? "-" : "";
      if (userInput.charAt(0) == '-')
         userInput = userInput.substring(1,userInput.length());
      userInput = userInput.toLowerCase();
      if(!userInput.matches("[0-9]+")|| userInput.length() > 19)
         throw new NumberMismatchException("Invalid Decimal numerical entry");
      return new DecimalInteger(negator + userInput);
   }
   public LongInteger setNumber(LongInteger number){
      return new DecimalInteger(number.value());
   }
}