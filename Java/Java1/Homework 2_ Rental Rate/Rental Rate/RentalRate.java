/* Tim Tanasse
 * Assignment 2: Rental Rate
 * Completed Calendar EC
 * Jan 18 2015
*/   
   import java.util.*;

   public class RentalRate
   {
      private static final boolean DEBUG = false;
      
      private static final String BEST_RATE = "Best rate - $40.00 per day or $200.00 per week.";
      private static final String RISK_RATE_1= "Risk rate 1 - $50.00 per day or $255.00 per week.";
      private static final String RISK_RATE_2= "Risk rate 2 - $57.00 per day or $285.00 per week.";
      private static final String RISK_RATE_3= "Risk rate 3 - $%4.2f per day or $%5.2f per week. ";
   
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
			Calendar today = Calendar.getInstance();
			curMonth = today.get(Calendar.MONTH);
			curDay = today.get(Calendar.DAY_OF_MONTH);
			curYear = today.get(Calendar.YEAR);
         
         // Get the gender...
			gender = getGender(kb);
         
         // Get the date of birth...
			int[] birthDate = new int[3];
			birthDate = getBirthDate(kb);
			birthMonth = birthDate[0];
			birthDay = birthDate[1];
			birthYear = birthDate[2];
         
         // Get age...
            age = calcAge(curMonth, curDay, curYear, birthMonth, birthDay, birthYear);
            
         // Get the rental rate...
            rateResult = calcRateClass(age, gender);
            
         // Display the results...
            displayResults(gender, age, rateResult);
         }
      }
	  public static int calcAge(int cm, int cd, int cy, int bm, int bd,int by){
		int age=0; //This method supplied by Chris Peters.
		age=cy-by;
		if(bm>cm){
			age--;
		}else if ((bm == cm) && (bd > cd)){
			age--;
		}return age;
	}
	public static String calcRateClass(int age, String gender){
		String rateResult = "";
		if(gender.equals("m")){
			if ((age >= 33) && (age <= 65)){
				rateResult = BEST_RATE;
			}else if ((age >= 25) && (age <= 32)){
				rateResult = RISK_RATE_2;
			}else if (age >= 66){
				rateResult = RISK_RATE_3;
			}
		}else if (gender.equals("f")){
			if ((age >= 30) && (age <= 62)){
				rateResult = BEST_RATE;
			}else if ((age >= 25) && (age <= 29)){
				rateResult = RISK_RATE_1;
			}else if ((age >= 63)){
				rateResult = RISK_RATE_3;
			}
		}return rateResult;
	}
	public static String getGender(Scanner kb){
		String gender = "";
		while ((!gender.equals("m")) && (!gender.equals("f"))){
			System.out.print("Please enter the renters gender (m/f): ");
			gender = kb.next();
			kb.nextLine();
			System.out.println();
		}
		return gender;
	}
	public static int[] getBirthDate(Scanner kb){
		int[] birthDate = new int[3];
		while (!checkBirthDate(birthDate)){
			System.out.print("Please enter the renters birth date (mm dd yyyy): ");
			birthDate[0] = kb.nextInt();
			birthDate[1] = kb.nextInt();
			birthDate[2] = kb.nextInt();
			kb.nextLine();
			System.out.println();
		}return birthDate;
	}
	public static boolean checkBirthDate(int[] birthDate){
		Calendar temp = Calendar.getInstance();
		if ((birthDate[0] > 12) || (birthDate[0] == 0)){
				return false;
		} else if (birthDate[1] > 31){
			return false;
		}else if ((birthDate[2] >=(temp.get(Calendar.YEAR))) && (birthDate[2] < (temp.get(Calendar.YEAR)-120))){
			return false;
		}else{
			return true;
		}
	}
	public static double getDayRate(int age, String gender){
		double dayRate = 0;
		int setAge = 0;
		if (gender.equals("m")){
			setAge = 65;
		}else if (gender.equals("f")){
			setAge = 62;
		}
		dayRate = (double)(((age - setAge) * 2) + 40);
		return dayRate;
	}
	public static double getWeekRate(int age, String gender){
		double weekRate = 0;
		int setAge = 0;
		if (gender.equals("m")){
			setAge = 65;
		} else if (gender.equals("f")){
			setAge = 62;
		}
		weekRate = (double)(((age-setAge)*5) + 200);
		return weekRate;
	}
	public static void displayResults(String gender, int age, String rateResult){
		System.out.println("Thank you!");
		if (gender.equals("m")){
			System.out.printf("The male renter is %d years old. \n", age);
		}else if (gender.equals ("f")){
			System.out.printf("The female renter is %d years old.\n", age);
		} 
		if (age < 25){
			System.out.printf("Sorry, but the renter is not old enough to rent! \n");
		}else if ((age > 65) && (gender.equals("m"))){
			System.out.printf(rateResult + "\n", getDayRate(age, gender), getWeekRate(age, gender));
		}else if ((age > 62) && (gender.equals("f"))){
			System.out.printf(rateResult + "\n", getDayRate(age, gender), getWeekRate(age, gender));
		}else{
			System.out.printf(rateResult + "\n");
		}
	}
}
   
