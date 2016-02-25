/* Tim Tanasse
 * Assignment: Composition and File Handling
 * March 12th, 2015
 * Extra Credit Attempted: Weekday Month Day Year, day DayOfYear of the year display
 */
import java.util.Scanner;
import java.io.*;
public class DateTester {
	
	public static void main (String args[]){
		
      System.out.print("Enter the file name -> ");
      String fileName = UserUtil.getUserString();
      System.out.println();
      
      Scanner fin = FileUtil.openInputFile(fileName);
		int[][] ara = translateFile(fin, fileName);
		fin.close();
		Date[] fileDates = buildDateArray(ara);
		SortSearchUtil.quickSort(fileDates, 0 , fileDates.length - 1);
      String[] options = {"Print the array of dates.","Search for a date.","Add a date to the array.","Delete a date from the array", "Quit"};
		int option = UserUtil.dynamicMenu(options);
		while(true){
			switch(option){
				case 1: String[] printOptions = {"Print to screen.", "Print to file."};
						int printOption = UserUtil.dynamicMenu(printOptions);
						switch(printOption){
							case 1: printDateArray(fileDates);
							break;
							case 2: FileUtil.printToFile(fileDates);
						}
				break;
				case 2: printSearchedDate(searchDates(fileDates));
				break;
				case 3: fileDates = addDate(fileDates);
                    SortSearchUtil.quickSort(fileDates,0,fileDates.length - 1);
				break;
				case 4: fileDates = deleteDate(fileDates);
				break;
				case 5: System.exit(0);
			}
         option = UserUtil.dynamicMenu(options);
		}
	}
	public static int[][] translateFile (Scanner fin, String fileName){ //takes a file, and the location/name of the file and returns a int array of dates
		int count = FileUtil.countFile(FileUtil.openInputFile(fileName));
		int countTemp = 0;
		int[][] temp = new int[count][3];
		while (fin.hasNextLine()){
			String tempString = fin.nextLine();
			String[] tempSplit = tempString.split("/");
			for (int i = 0; i < 3; i++){
				temp[countTemp][i] = Integer.parseInt(tempSplit[i]);	//array goes {month,day,year}
			}
			countTemp++;
		}
		return temp;
	}
	public static Date[] buildDateArray (int[][] input){//builds the Date[] object from the ints previously translated.
		int badDates = 0;
      for (int i = 0; i < input.length; i++){
         if (Date.valiDate(input[i][0],input[i][1],input[i][2]) != 1){
         badDates++;
         }
      }
		Date[] temp = new Date[input.length - badDates];
		int counter = 0;
      int placement = 0;
      while(counter < input.length){
         if (Date.valiDate(input[counter][0],input[counter][1],input[counter][2]) == 1){
            temp[placement] = new Date(input[counter][0],input[counter][1],input[counter][2]);
            placement++;
         }
         counter++;
      }
		System.out.println("There were " + badDates + " bad date lines in the file.\n");
		return temp;
	}
	public static void printDateArray (Date[] array){
		System.out.println("The dates in the array are: ");
		for (int i = 0; i < array.length; i++){
			System.out.println(array[i].toStringLongForm());
		}
		System.out.println();
	}
	public static int searchDates(Date[] input){
		int dayVal, monthVal, yearVal;
		Date temp;
		while(true){
			System.out.print("Enter the day -> ");
			dayVal = UserUtil.getUserInt();
			System.out.print("Enter the month -> ");
			monthVal = UserUtil.getUserInt();
			System.out.print("Enter the year -> ");
			yearVal = UserUtil.getUserInt();
			if (Date.valiDate(monthVal, dayVal, yearVal) == 1){
				temp = new Date(monthVal, dayVal, yearVal);
				break;
			}else{
				System.out.println("Enter a valid date!");
			}
		}
		return SortSearchUtil.binarySearch(input, temp, 0, input.length);
	}
	public static void printSearchedDate(int searchedDate){
		if (searchedDate < 0){
			System.out.println("Date not found!");
		}else{
			System.out.println("Date is at index: " + searchedDate);
		}
	}
	public static Date[] addDate(Date[] input){
		Date[] tempAra = new Date[input.length + 1];
		int dayVal, monthVal, yearVal;
		Date temp;
		while(true){
			System.out.print("Enter the day -> ");
			dayVal = UserUtil.getUserInt();
			System.out.print("Enter the month -> ");
			monthVal = UserUtil.getUserInt();
			System.out.print("Enter the year -> ");
			yearVal = UserUtil.getUserInt();
			if (Date.valiDate(monthVal, dayVal, yearVal) == 1){
				temp = new Date(monthVal, dayVal, yearVal);
				break;
			}else{
				System.out.println("Enter a valid date!");
			}
		}
		for (int i = 0; i < input.length; i ++){
			tempAra[i] = input[i];
		}
		tempAra[input.length] = temp;
		return tempAra;
	}
	public static Date[] deleteDate(Date[] input){
		int temp = searchDates(input);
		Date[] tempAra = new Date[input.length - 1];
		int count = 0;
		int adder = 0;
		while (count < (input.length - 1)){
			if (( count + adder )!= temp){
				tempAra[count]= input[count + adder];
            count++;
			}else{
				adder++;
			}
		}
		return tempAra;
	}
}

