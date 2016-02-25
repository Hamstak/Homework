/*Tim tanasse
  CSCD 300
  October 13th 2015
  EC attempted: Both
 */

import java.io.IOException;


public class Tester {

	public static void main(String[] args) throws IOException {

		String fileName1="files/testfile1";
		String fileName2="files/testfile2";
		WordProcessor wp = new WordProcessor();

		MyLinkedList allWords = wp.extractAll(fileName1);
		wp.writeToFile(allWords, "outSort1");
		allWords.sortListOcc(); //sort the list according to word occurrence, you have to implement it.
		wp.writeToFile(allWords,"outSort2");
		
		//System.out.println(allWords);
		
	}

}
