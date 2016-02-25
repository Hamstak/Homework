import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


/*
 *The WordProcessor class would extract words from the raw text file(a.k.a tokenization).
 *After extracted one word, it either creates a new WordItem object and insert
 *the object into LinkedLis at a proper location, or it calls a method in MyLinkedList to increment 
 *the word occurrence and to update line-number list if a word has already been existing.
 *
 *The class also provides File I/O methods. Write the resultant string or list back to a file.
 *
 */

public class WordProcessor {
    public static void main(String[] args) throws IOException {
        System.out.println("Begin unit test for WordProcessor.java!");
        System.out.println("Testing ExtractLine()");
        System.out.println("This should be easy:\n" + (new WordProcessor().extractLine("This should be easy")).toString());
        System.out.println("This is a bit more difficult, should it still work?:\n" +
                (new WordProcessor().extractLine("This is a bit more difficult, should it still work?").toString()));
        System.out.println(",...,2341235!@!#%!@#%!@#%Test!@$%@#^@#$>,.,14513461                :\n" +
                (new WordProcessor().extractLine(",...,2341235!@!#%!@#%!@#%Test!@$%@#^@#$>,.,14513461                ").toString()));
        System.out.println("All other functions are helper functions for extractLines() and were tested in the process of testing extractLines()");
    }
	private final String fileName="files/testfile1";
    private final String alpha ="QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
	
	//give you a taste about how to do fileIO
	public ArrayList<String> fileRead(String name) throws IOException {
		ArrayList<String> lines = new ArrayList<String>();
		
		FileReader fileReader = new FileReader(name);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String aline = null;
        //read in the rest of rows
        //readLine() returns striped string, that discards any line-termination chars
        while ((aline = bufferedReader.readLine()) != null) {
        	aline = aline.trim();
        	if(aline.length() > 0)
        		lines.add(aline); //skip empty lines
        }
        fileReader.close();
		return lines;
	}
	
	public MyLinkedList extractLine(String aline) throws IOException {
        MyLinkedList list = new MyLinkedList();

        while(aline.length() > 0){
            int end = endGetter(aline, list);
            try{
                aline = aline.substring(end + 1);
            }catch(Exception e){
                return list;
            }
        }
        return list;
	}//end of extract

    private void checkAndAddWord(String word, MyLinkedList list){
        if (word.length() > 1 || word.equalsIgnoreCase("i") || word.equalsIgnoreCase("a")){
            list.add(word);
        }
    }

	private int endGetter(String aline, MyLinkedList list){
        int end;
        for (int i = 0; i < aline.length(); i++){
            if (!alpha.contains("" + aline.charAt(i))) {
                end = i;
                checkAndAddWord(aline.substring(0,end), list);
                return end;
            }
        }
        checkAndAddWord(aline.substring(0, aline.length()), list);
        return aline.length();
    }

	public MyLinkedList extractAll(String fileName) throws IOException {
		MyLinkedList list = new MyLinkedList();
        Iterator<String> aline = fileRead(fileName).iterator();
        int atLine = 0;
        String word = null;
        while((aline.hasNext())) {
            MyLinkedList extractedWords = extractLine(aline.next());
            Iterator iterator = extractedWords.iterator();
            while (iterator.hasNext() && (word = (String)iterator.next()) != null){
                if (!list.containWord(word, atLine)) {
                    list.addOrdered(new WordItem(word, 1, atLine));
                }
            }
            atLine++;
        }
        return list;
	}
	
	public void writeToFile(MyLinkedList alist, String fileName) {
		FileWriter fileWriter = null;
        try {
            String content = alist.toString();
            File newTextFile = new File(fileName);
            fileWriter = new FileWriter(newTextFile);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
	}//
	
}//end of class
	

