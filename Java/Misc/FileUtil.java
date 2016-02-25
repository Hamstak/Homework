/* Time Tanasse
 * 
 * 
 */
import java.util.Scanner;
import java.io.*;

public class FileUtil {
	public static Scanner openInputFile (String fileName) throws IOException{
		Scanner fileScanner = null;
		File fileHandle;
		while(true){
         try{
			   fileHandle = new File(fileName);
			   fileScanner = new Scanner(fileHandle);
            break;
		   }catch (FileNotFoundException e){
			   System.out.println("file "+fileName+" was not found!");
		   }
         return openInputFile();
      }
		return fileScanner;
	}
	public static Scanner openInputFile() throws IOException{
		
		return openInputFile(getUserFileName());
	}
   private static String getUserFileName(){
      Scanner kb = new Scanner(System.in);
		String fileName;
		System.out.print("Enter file name -> ");
		fileName = kb.nextLine();
		System.out.println();
      return fileName;
   }
	public static int countFile(Scanner fin){
		int count = 0;
		while (fin.hasNextLine()){
			count++;
			fin.nextLine();
		}
		//reset file pointer, or handle outside.
		return count;
	}
}

