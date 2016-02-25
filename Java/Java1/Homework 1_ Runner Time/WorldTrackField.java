import java.util.Scanner; // Scanner Package
public class WorldTrackField
{
	public static double inversion(double num)
	{
		double result;
		result = 100/num;
		return result;
	}
	public static double toFeet(double num)
	{
		double result;
		result = num*3.28084;
		return result;
	}
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in); // create scanner object
		double raceTimeinMeters; // Various important non-easily computed variables
		double meterspSecond;
		double feetpSecond;
		double kilopSecond;
		double milespHour;
		double kilopHour;
		double mileTime;
		double kiloTime;
		double minTime;
		double secondRemander;
		
		System.out.println("Enter in the 100 meter race time:");
		raceTimeinMeters = input.nextDouble(); //receive input and make calculations
		meterspSecond = 100/(raceTimeinMeters);
		feetpSecond = meterspSecond * 3.28084;
		kilopSecond = meterspSecond / 1000.0;
		milespHour = (feetpSecond / 5280.0) * 60 * 60;
		kilopHour = kilopSecond * 60 * 60;
		mileTime =  1.0/milespHour;
		kiloTime = 1.0/(kilopSecond * 60 * 60);
		minTime = (int)(mileTime * 3600)/60;
		secondRemander = (mileTime * 3600) - (minTime * 60);
		
		System.out.println("The person was travelling at a rate of:" + "\n" +
		meterspSecond + " Meters per second"+"\n"+
		feetpSecond + " Feet per second"+"\n" +
		kilopHour + " Kilometers per hour" + "\n" +
		milespHour+ " Miles per hour"); //Display output
		System.out.println("It would take the person " + minTime + " minutes and " + secondRemander + " seconds for the person to run one mile.");
	}
}
		
		
		
