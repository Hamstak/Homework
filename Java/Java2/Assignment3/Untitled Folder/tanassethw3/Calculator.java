public class Calculator {
   private LongInteger number1;
   private LongInteger number2;
   private Mode mode;
   private Functor functor;
   private String displayFunctor;
   private String display;
   public Calculator(){
      this.mode = new DecMode("new");
      this.functor = null;
   }
   public void run(){
      String userInput = "";
      do{
         displayOutput();
         userInput = UserUtil.getUserString();
         if(checkOption(userInput)){
            mode = mode.changeMode(userInput);
         }else if(checkFunctor(userInput)){
            functorRun(userInput);
         }else{
            NumberCrunch(userInput);
         }
         if(userInput.equals(""))
              userInput += "1";
      }while(!(userInput.charAt(0) == 'q' || userInput.charAt(0) == 'Q'));
   }
   private boolean checkOption(String userInput){
      if (userInput.equals(""))
         return false;
      if(userInput.equalsIgnoreCase("dcm"))
         return true;

      userInput = userInput.substring(0,1);
      return userInput.matches("^[HhOoBb]*");
   }
   private boolean checkFunctor(String userInput){
      if(userInput.equals(""))
         return false;
      return userInput.matches("^[+*/=-]*");
   }
   public void functorRun(String userInput){
      if(mode.calculatorState().equals("num2") && number2 != null){
         //if(functor.functionCheck())
            number1 = mode.setNumber(functor.function(number2));
         //else
         //throw new NumberMismatchException("numerical result is too large!");
         if (userInput.charAt(0) == '='){
            mode.setCalculatorState("num1");
            return;
         }
      }
      if (number1 != null){
         switch(userInput.charAt(0)){
            case '+': functor = new Adder(number1);
            break;
            case '-': functor = new Subtractor(number1);
            break;
            case '*': functor = new Multiplier(number1);
            break;
            case '/': functor = new Divider(number1);
            break;
         }
      }
      displayFunctor = "" + userInput.charAt(0);
      mode.setCalculatorState("functor");
   }
   public void NumberCrunch(String userInput){
      if(userInput.equals(""))
         return;
      try{
         if(mode.calculatorState().equals("num1") || mode.calculatorState().equals("new")){
             number1 = mode.setNumber(userInput);
             mode.setCalculatorState("num1");
         }else{
             number2 = mode.setNumber(userInput);
             mode.setCalculatorState("num2");
         }
      }catch(NumberMismatchException e){
         System.out.println(e.getMessage() + "\n");
      }
   }
   public void displayOutput(){
      if (mode.calculatorState().equals("num2"))
         display = number1.toString() + " "  + displayFunctor + " " + number2.toString();
      else if (mode.calculatorState().equals("functor"))
         display = number1.toString()+ " " + displayFunctor;
      else if (mode.calculatorState().equals("num1"))
         display = number1.toString();
      else
         display = "";
         
      System.out.print(mode.numberMode() + " mode\n\n" + display + "\n\n" + String.format("%-25s  +\n%-25s  -\n%-25s  *\n%-25s  /\n%-25s  =\n","BIN-Binary","OCT-Octal","HEX-Hexidecimal","DCM-Decimal","Q-Quit") + "Option or value -> ");
   }
}
