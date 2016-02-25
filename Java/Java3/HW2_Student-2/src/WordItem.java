import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.BufferedWriter;
import java.util.*;
import java.util.ArrayList;

/*
 * Each WordItem object represents a word extracted from the text file.
 * It has three fields. String word stores the literal English word.
 * int count records the number of occurrence for that word in text file.
 * ArrayList atLines records a list of line numbers at which the word appears in
 * the original text file. 
 * NOTE: line number in this Arraylist 'atLines' should be unique, no duplicates.
 * 
 * 
 *  
 */

public class WordItem implements Comparable {

    public static void main(String[] args){
        System.out.println("Begin unit tests for WordItem.java!");
        System.out.println("Testing compareTo()");
        System.out.println((new WordItem("String", 1, 1)).compareTo(new WordItem("String", 1, 10)) + " Output should have been 0");
        System.out.println((new WordItem("Strings", 1, 1)).compareTo(new WordItem("String", 1, 10)) + " Output should have been ");
        System.out.println((new WordItem("aaaaaa", 1, 1)).compareTo(new WordItem("AAAAAA", 1, 1)) + " Outputshould have been 0");
        System.out.println("Testing Complete!\nTesting equals()");
        System.out.println((new WordItem("String", 1, 10)).equals(new WordItem("String", 1, 1)) + " Output should be false");
        System.out.println((new WordItem("test", 1, 1)).equals(new WordItem("Test", 2, 1)) + " Output should be false");
        System.out.println((new WordItem("test", 1, 1)).equals(new WordItem("string", 1, 1)) + " Output should be false");
        System.out.println("Testing Complete!\nTesting addAtLines()");
        WordItem test = new WordItem("test", 1, 1);
        System.out.println(test);
        System.out.println(test.addAtLines(10) + " Should be true");
        System.out.println(test);
        System.out.println(test.addAtLines(10) + " Should be false");
	System.out.println(test);
        System.out.println(test.addAtLines(12) + " Should be true");
	System.out.println(test);
        System.out.println("Testing Complete!\n Testing increaseCount()");
        System.out.println(test);
        test.increaseCount();
        System.out.println(test);
        System.out.println("Testing Complete!");
    }

    private String word;
	private int count;
	private ArrayList<Integer> atLines;
	
	public WordItem(String word, int c, int atLine) {
		this.word = word;
		this.count = c;
		this.atLines = new ArrayList<Integer>();
		atLines.add(atLine);
	}
	
		
	@Override
	//implement this method
	public int compareTo(Object other) {
        return word.compareToIgnoreCase(((WordItem)other).word);
	}
	
	//
	public String getWord() {
		return this.word;
	}
	

	//
	public int getCount() {
		return this.count;
	}
	
	//
	@Override
	public boolean equals(Object obj) {
		if (obj == null){
			return false;
		}
		if (this.getClass().getSimpleName().equals(obj.getClass().getSimpleName())){
			WordItem that = (WordItem) obj;
			if (this.word.equalsIgnoreCase(that.word) && this.count == that.count && this.atLines.equals(that.atLines) ){
				return true;
			}
		}
        return false;
    }
	
	public boolean addAtLines(int atLines){
		if (this.atLines.contains(new Integer(atLines))){
			return false;
		}
		this.atLines.add(new Integer(atLines));
		return true;
	}

	public void increaseCount(){
		count++;
	}

	@Override
	public String toString() {
		String ret = "";
		ret += word + ":" + this.count + "->" +
				this.atLines.toString();
		return ret;
	}
	
}//end of class
