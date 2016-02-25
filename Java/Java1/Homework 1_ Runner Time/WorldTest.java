// Tim Tanasse
// Assignment 1 - Track Times

import java.util.*;
public class WorldTest
{
	
	public static void main(String[] args)
	{
		double time = 0.0;
		//Get time from user
		time = getTime();
		//Print the data from the methods
		System.out.printf("%10.2f Meters per second \n", timeToMPS(time));
		System.out.printf("%10.2f Feet per second \n", timeToFPS(time));
		System.out.printf("%10.2f Kilometers per hour \n", timeToKPH(time));
		System.out.printf("%10.2f Miles per hour \n", timeToMPH(time) );
		System.out.printf("This person can run a mile in %d minutes and %3.2f seconds. \n", timeForMileMinutes(time), timeForMileRemander(time) );
		System.out.printf("This person can run 100 yards in %3.2f seconds.", hundredYardConversion(time));
	}
	private static double getTime()
	{
		//Get the time from the user
		double theTime = 0.0;
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Input winning time: ");
		theTime = kb.nextDouble();
		kb.nextLine();
		return theTime;
	}
	private static double timeToMPS(double seconds)
	{
		//Convert time per 100 meters to meters per second
		double metersPS = 0.0;
		metersPS = 100 / seconds;
		return metersPS;
	}
	private static double timeToFPS(double seconds)
	{
		//convert time in seconds to feet per second through previous method
		double feetPS = 0.0;
		feetPS = timeToMPS(seconds) * 3.24084;
		return feetPS;
	}
	private static double timeToMPH(double seconds)
	{
		//Convert time in seconds to miles per hour using previous feet per second method
		double milesPH = 0.0;
		milesPH = ( timeToFPS(seconds) / 5280 ) * ( 60 * 60 );
		return milesPH;
	}
	private static double timeToKPH(double seconds)
	{
		//Convert time in seconds to kilometers per hour using the meters per second method
		double kiloPH = 0.0;
		kiloPH = ( timeToMPS(seconds) / 1000 ) * ( 60 * 60 );
		return kiloPH;
	}
	private static int timeForMileMinutes(double seconds)
	{
		//Do some conviluted mathematics to turn miles per hour into minutes per mile.
		int mileTime = 0;
		mileTime = (int)( ( 1  / timeToMPH(seconds) ) * 60 );
		return mileTime; 
	}
	private static double timeForMileRemander (double seconds)
	{
		//remander for the two part function because conviluted math
		double remander;
		remander =( ( 1 / timeToMPH(seconds) ) % 60 );
		return remander;
	}
	private static double hundredYardConversion(double seconds)
	{
		//Method for 100 yard conversion
		double yardTime = 0.0;
		yardTime = 300 / timeToFPS(seconds);
		return yardTime;
	}
}
