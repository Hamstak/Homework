/* Time Tanasse
 * 
 * 
 */
import java.util.Scanner;
import java.io.*;

public class FileUtil {
	public static Scanner openInputFile (String fileName){
		Scanner fileScanner = null;
		File fileHandle;
		try{
			fileHandle = new File(fileName);
			fileScanner = new Scanner(fileHandle);
		}catch (FileNotFoundException e){
			System.out.print("file "+fileName+" was not found!");
		}
		return fileScanner;
	}
	public static Scanner openInputFile() throws IOException{
		Scanner kb = new Scanner(System.in);
		String fileName;
		System.out.print("Enter file name -> ");
		fileName = kb.nextLine();
		System.out.println();
		return openInputFile(fileName);
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
	public static PrintWriter openOutputFile(String fileName){
		File temp;
		PrintWriter fout;
		temp = new File(fileName);
		while (true){
			try{
				fout = new PrintWriter(temp);
				break;
			}catch(Exception e){
				System.out.println("File Not Found");
				System.exit(1);
			}
		}
		return fout;
	}
}

