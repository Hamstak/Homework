   import java.util.*;

   public class RentalRate
   {
      private static final boolean DEBUG = true;
      
      private static final String BEST_RATE = "Best rate - $40.00 per day or $200.00 per week.";
      private static final String RISK_RATE_1= "Risk rate 1-$50.00 per day or $255.00 per week.";
      private static final String RISK_RATE_2= "Risk rate 2-$57.00 per day or $285.00 per week.";
      private static final String RISK_RATE_3= "Risk rate 3-$%4.2f per day or $%5.2f per week.";
   
      public static void main(String[] args)
      {    
         int curMonth = 0;
         int curDay = 0;
         int curYear = 0;
         int birthMonth = 0;
         int birthDay = 0;
         int birthYear = 0;
         String gender = "";
         int age = 0;
         String rateResult = "";         
         
         // Testing mode...   
         if (DEBUG == true)
        {
            // Establish a 'current' date for testing...
            curMonth = 2;
            curDay = 1;
            curYear = 2013;
            
            System.out.println("First test case: Renter is not old enough to rent...");
            birthMonth = 2;
            birthDay = 2;
            birthYear = 1988;
            gender = "m";
            age = calcAge(curMonth, curDay, curYear, birthMonth, birthDay, birthYear);
            rateResult = calcRateClass(age, gender);
            displayResults(gender, age, rateResult);
            
            System.out.println("\nSecond test case: Renter is barely old enough (57/285)...");
            birthMonth = 2;
            birthDay = 1;
            birthYear = 1988;
            gender = "m";
            age = calcAge(curMonth, curDay, curYear, birthMonth, birthDay, birthYear);
            rateResult = calcRateClass(age, gender);
            displayResults(gender, age, rateResult);
            
            System.out.println("\nThird test case: Renter is 35 and male (40/200)...");
            birthMonth = 1;
            birthDay = 1;
            birthYear = 1978;
            gender = "m";
            age = calcAge(curMonth, curDay, curYear, birthMonth, birthDay, birthYear);
            rateResult = calcRateClass(age, gender);
            displayResults(gender, age, rateResult);
        
            System.out.println("\nFourth test case: Renter is 35 and female (40/200)...");
            birthMonth = 1;
            birthDay = 1;
            birthYear = 1978;
            gender = "f";
            age = calcAge(curMonth, curDay, curYear, birthMonth, birthDay, birthYear);
            rateResult = calcRateClass(age, gender);
            displayResults(gender, age, rateResult);
            
            System.out.println("\nFifth test case: Renter is 30 and male (57/285)...");
            birthMonth = 1;
            birthDay = 1;
            birthYear = 1983;
            gender = "m";
            age = calcAge(curMonth, curDay, curYear, birthMonth, birthDay, birthYear);
            rateResult = calcRateClass(age, gender);
            displayResults(gender, age, rateResult);
            
            System.out.println("\nSixth test case: Renter is 30 and female (40/200)...");
            birthMonth = 1;
            birthDay = 1;
            birthYear = 1983;
            gender = "f";
            age = calcAge(curMonth, curDay, curYear, birthMonth, birthDay, birthYear);
            rateResult = calcRateClass(age, gender);
            displayResults(gender, age, rateResult);
         
            System.out.println("\nSeventh test case: Renter is 76 and male (62/255)...");
            birthMonth = 1;
            birthDay = 1;
            birthYear = 1937;
            gender = "m";
            age = calcAge(curMonth, curDay, curYear, birthMonth, birthDay, birthYear);
            rateResult = calcRateClass(age, gender);
            displayResults(gender, age, rateResult);        
         
            System.out.println("\nEighth test case: Renter is 76 and female (68/270)...");
            birthMonth = 1;
            birthDay = 1;
            birthYear = 1937;
            gender = "f";
            age = calcAge(curMonth, curDay, curYear, birthMonth, birthDay, birthYear);
            rateResult = calcRateClass(age, gender);
            displayResults(gender, age, rateResult);         
         }
         else
         {
            Scanner kb = new Scanner(System.in);
            System.out.println("Welcome to the car renter's rate finder.");
         
         // If you're not attempting the EC, get today's date from the user...
         //    Your code goes here...
         
         // If you are attempting the EC, use the Calendar class to get today's date...
         //    Your code goes here...
         
         // Get the gender...
         //    Your code goes here...
         
         // Get the date of birth...
         //    Your code goes here...
         
         // Get age...
            age = calcAge(curMonth, curDay, curYear, birthMonth, birthDay, birthYear);
            
         // Get the rental rate...
            rateResult = calcRateClass(age, gender);
            
         // Display the results...
            displayResults(gender, age, rateResult);
         }
      }
	  public static int calcAge(int bm, int bd, int by, int cd, int cm,int cy){
		int age=0;
		age=cy-by;
		if(bm>cm){
			age--;
		}
		else if ((bm == cm) && (bd > cd)){
			age--;
		}
		return age;
	}
	public static String calcRateClass(int age, String gender){
		String rateResult = "";
		if(gender == "m"){
			if((age >= 33) && (age <= 65)){
				rateResult = BEST_RATE;
			}
			else if((age >= 25) && (age <= 32)){
				rateResult = RISK_RATE_2;
			}
			else if(age <= 66){
				rateResult = RISK_RATE_3;
			}
		}
		else if(gender == "f"){
			if(age <4){
				rateResult = BEST_RATE;
			}
		}
		return rateResult;
	}
	public static void displayResults(String gender, int age, String rateResult){
	System.out.println("This isn't complete");	
	}
}
   
