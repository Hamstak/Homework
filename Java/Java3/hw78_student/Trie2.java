import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Trie2 {
	
	private class TrieNode {
		Map<Character, TrieNode> children = new TreeMap<>();//TreeMap is java build-in structure, 
		int weight;						//Basically it acts like a Hashtable or Hashmap, establishing a mapping between Key and Value
        MyLinkedList list = new MyLinkedList();              //Unlike hash table, keys in TreeMap are sorted!

        public boolean isWord(){
            return weight != 0;
        }
	}
	
	private TrieNode root;

	public Trie2() {
		this.root = new TrieNode();
	}
/*
	public void insertString(String s) {
		insertString(root, s);
	}
	
	private void insertString(TrieNode root, String s) {
		TrieNode cur = root;
		for (char ch : s.toCharArray()) {
			TrieNode next = cur.children.get(ch);
			if (next == null)
				cur.children.put(ch, next = new TrieNode());
			cur = next;
		}
		cur.aword = true;
	}
*/

	public void insertWord(WordItem word) {insertWord(root, word);}

	private void insertWord(TrieNode root, WordItem word){
		TrieNode curr = root;
        //String prefix = "";
		for (char ch: word.getWord().toCharArray()){
			TrieNode next = curr.children.get(ch);
            //prefix += ch;
			if (next == null)
				curr.children.put(ch, next = new TrieNode());
            next.list.add(word);
            //System.out.println("Current prefix: " + prefix);
			curr = next;
		}
		curr.weight = word.getCount();
	}

	public void printSorted() {
		ArrayList<WordItem> list = printSorted(root, "", new ArrayList<WordItem>());
        Collections.sort(list, new WordItem.WordComparator(true));
        for (WordItem word :list) {
            System.out.println(word.getWord());
        }
    }

	private ArrayList<WordItem> printSorted(TrieNode node, String s, ArrayList<WordItem> list) {
		if (node.isWord())
			list.add(new WordItem(s, node.weight));
        for (Character ch : node.children.keySet()) {
            printSorted(node.children.get(ch), s + ch, list);
        }
        return list;
	}

	public MyLinkedList getLeaves(String prefix){
        return moveTo(prefix).list;
    }


    private TrieNode moveTo(String prefix){
        TrieNode node = root;
        for (char ch: prefix.toCharArray()){
            if (node == null)
                return null;
            node = node.children.get(ch);
        }
        return node;
    }

	public boolean findWord(String s) {
		return findWord(root, s);
	}
	
	private boolean findWord(TrieNode node, String s) {
		if(s != null) {
			String rest = s.substring(1); //rest is a substring of s, by excluding the first character in s
			char ch = s.charAt(0);        //ch is the first letter of s
			TrieNode child = node.children.get(ch);	//return the child that ch associated with. 
			if(s.length() == 1 && child != null) //if s contains only one letter, and current node has a child associated with that letter, we find the prefix in Trie!
				return true;	                 //base case
			if(child == null)
				return false;
			else
				return findWord(child, rest);    //recursive, In this way, we follow the path of the trie from root down towards leaf
		}
		return false;
	}

    public Trie2 insertFromFile(String filename){
        try {
            Scanner fin = new Scanner(new File(filename));
            while(fin.hasNext()){
                String[] wordWeight = fin.nextLine().split(",");
                insertWord(new WordItem(wordWeight[0], Integer.parseInt(wordWeight[1])));
            }
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            return this;
        }

        return this;
    }

	// Usage example
	public static void main(String[] args) {
		
		Trie2 tr = new Trie2();
		
		tr.insertWord(new WordItem("hello", 4));
		tr.insertWord(new WordItem("world", 6));
		tr.insertWord(new WordItem("hi", 11));
		tr.insertWord(new WordItem("ant", 13));
		tr.insertWord(new WordItem("an", 24));
		
		System.out.println(tr.findWord("ant"));
		System.out.println(tr.findWord("an"));
		System.out.println(tr.findWord("hello"));
		System.out.println(tr.findWord("cant"));
		System.out.println(tr.findWord("hig"));
		System.out.println(tr.findWord("he"));
		
		tr.printSorted();
        System.out.println(tr.getLeaves("").toString());
        long time = System.currentTimeMillis();
        Trie2 dictionary = (new Trie2()).insertFromFile("files/dictionary.txt");
        System.out.println(System.currentTimeMillis() - time);
	}
}
