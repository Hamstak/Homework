import java.util.*;

public class CalendarTest {
	public static void main(String[] args){
		Calendar today = Calendar.getInstance();
		
		System.out.println(today.toString());
		int dayMonth = today.get(Calendar.YEAR) + 1 ;
		System.out.println(today.get(Calendar.MONTH));	
		System.out.println(dayMonth);
		
	}
	public static int calcAge(int bm, int bd, int by, int cd, int cm,int cy){
		int age=0;
		age=cy-by;
		if(bm>cm){
			age--;
		}
		else if((bm == cm) && (bd > cd)){
			age--;
		}
		return age;
	}
	public static String calcRateClass(int age, String gender){
		int[] maleAge = {25, 32, 65};
		int[] femaleAge = {25, 39, 62};
		int[] valueChoice = new int[3];
		String rateChoice = "";
		String riskRate = "";
		if (gender.equals("m")){
			rateChoice = RISK_RATE_2;
			valueChoice = maleAge;
		}else{
			rateChoice = RISK_RATE_1;
			valueChoice = femaleAge;
		}
		if (age > valueChoice[3]){
			riskRate = RISK_RATE_3;
		} else if (age > valueChoice[2]){
			riskRate = BEST_RATE;
		} else if (age < valueChoice[1]){
			riskRate = rateChoice;
		}
		return riskRate;
	}
}
