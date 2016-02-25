public abstract class Mode{
   private String calculatorState;
   public String calculatorState(){ return calculatorState; }
   public void setCalculatorState(String calculatorState){ this.calculatorState = calculatorState; }
   
   private String numberMode;
   public String numberMode(){ return numberMode; }
   
   public Mode(String calculatorState,String numberMode){
      this.calculatorState = calculatorState;
      this.numberMode = numberMode;   
   }
   public abstract LongInteger setNumber(String number) throws NumberMismatchException;
   public abstract LongInteger setNumber(LongInteger number);
   public Mode changeMode(String userInput){
      userInput = userInput.toLowerCase();
      switch(userInput.charAt(0)){
         case 'h': return new HexMode(calculatorState);
         case 'o': return new OctMode(calculatorState);
         case 'd': return new DecMode(calculatorState);
         case 'b': return new BinMode(calculatorState);
      }
      return null;
   }
}