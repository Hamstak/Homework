/* Tim Tanasse
 * File Utilities
 * 
 */
import java.util.Scanner;
import java.io.*;

public class FileUtil {
	public static Scanner openInputFile (String file){
		String fileName = file;
		Scanner fileScanner = null;
		File fileHandle;
		boolean failure = false;
		while(true){
			try{
				if (failure == true){
					Scanner kb = new Scanner(System.in);
					fileName = kb.nextLine();
					System.out.println();
					failure = false;
				}
				fileHandle = new File(fileName);
				fileScanner = new Scanner(fileHandle);
				break;
			}catch (FileNotFoundException e){
				System.out.print("file "+fileName+" was not found!\nEnter a good file name-> ");
				failure = true;
			}
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
		fin.close();
		return count;
	}
	public static void printToFile(Object[] input){
		PrintWriter fout = openOutputFile();
		for (int i = 0; i < input.length; i++){
         fout.println(input[i].toString());
		}
        fout.close();
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
	public static PrintWriter openOutputFile(){
		Scanner kb = new Scanner(System.in);
		String fileName;
		System.out.print("Enter file -> ");
		while (true){
			try{
				fileName = kb.nextLine();
            System.out.println();
				break;
			}catch(Exception e){
				System.out.println("\nInput Error.");
			}
		}
		return openOutputFile(fileName);
	}
}

