public class OctMode extends Mode{
   public OctMode(String calculatorState){
      super(calculatorState, "Octal");
   }
   public LongInteger setNumber(String userInput) throws NumberMismatchException{
      userInput = LongInteger.normalize(userInput);
      String negator = (userInput.charAt(0) == '-') ? "-" : "";
      if(userInput.charAt(0) == '-')
         userInput = userInput.substring(1,userInput.length());
      if((!userInput.matches("[0-7]+")) || userInput.length() > 21)
         throw new NumberMismatchException("Invalid octal numerical");
      return new OctalInteger(negator + userInput);
   }
   public LongInteger setNumber(LongInteger number){
      return new OctalInteger(number.value());
   }
}