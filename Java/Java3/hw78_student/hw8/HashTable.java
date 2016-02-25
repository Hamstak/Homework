import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by moth on 12/4/15.
 */
public class HashTable {
    private class HashtableNode {
        private String key;
        private MyLinkedList data;

        public HashtableNode() {
            this.key = null;
            this.data = new MyLinkedList();
        }

        public HashtableNode(String inKey, WordItem inData) {
            this.key = inKey;
            this.data.add(inData);
        }

        /* Equality can be based on key alone because there can't be
         * 2 nodes with the same key in the table */
        public boolean equals(Object obj) {
            if (obj instanceof HashtableNode) {
                HashtableNode node = (HashtableNode)obj;
                return this.key.equals(node.key);
            }
            else {
                return false;
            }
        }

        public String toString() {
            return "Key: ["+this.key+"] Value: ["+this.data+"]";
        }
    }
        //
        //
        private final int tableSize = 26000*7;
        private int numElements;
        private HashMap<String, MyLinkedList>[] table;

        //constructor
        @SuppressWarnings("unchecked")
        public HashTable(int realSize) {

            this.table = new HashMap[realSize];
            this.numElements = 0;
        }
        @SuppressWarnings("unchecked")
        public HashTable() {
            this.table = new HashMap[this.tableSize];
            this.numElements = 0;
        }

        public MyLinkedList get(String string){
            int pos = this.hash(string);
            return this.table[pos].get(string);
        }

        private int hash(String key) {

		/* Start with a base, just so that it's not 0 for empty strings */
            int result = 42; //start at hard coded base

            String inputString = key.toString().toLowerCase();
            //System.out.println("hash string is:" + inputString + "\n");

            char [] characters = inputString.toCharArray();
            for (int i = 0; i < characters.length; i++) {
                char currentChar = characters[i];

                if (currentChar == 'a' || currentChar == 'b' || currentChar == 'c' ||
                        currentChar == 'd' || currentChar == 'e' || currentChar == 'f') {
                    result += Integer.parseInt(""+currentChar, 16);
                }

                int j = (int)currentChar;
                //System.out.println("j = " + j );
                result += j;
            }

            return (result % this.tableSize);
        }

        public void add(String key, WordItem data) {
            if (data == null || key == null) {
                System.err.println("ERROR: Either the key or the data are null");
                return;
            }

            // If trying to add duplicate keys, that means
            // we like to update the value associated with that existing key.
            // We then first delete the existing mapping, then insert a new record that key.

            //if (this.contains(key)) {
            //    remove(key);
            //}
            for (int i = 1; i <= key.length(); i++){
                int pos = this.hash(key.substring(0,i));
                if (this.table[pos] == null){
                    this.table[pos] = new HashMap<>();
                }
                if (this.table[pos].get(key.substring(0,i)) == null){
                    this.table[pos].put(key.substring(0,i), new MyLinkedList());
                }
                this.table[pos].get(key.substring(0,i)).add(data);
                this.numElements++;
            }
        }

        /*//public void add(Object [] keys, Object [] inputData) {
        //    for (int i = 0; i < inputData.length; i++) {
        //        this.add(keys[i], inputData[i]);
        //    }
        //}

        //return type is different from the standard Map interface.
        //public void
        //   for (int i = 1; i <= key.length(); i++){
        //        int pos = this.hash(key.substring(0,i));
        //        if (this.table[pos] == null){
                    this.table[pos] = new remove(Object key) {
            int hashVal = this.hash(key);

            if (this.table[hashVal] != null) {
                HashtableNode node = new HashtableNode();
                node.key = key; //in order to use the equals() method in HashtableNode

                if (((LinkedList<HashtableNode>)this.table[hashVal]).indexOf(node) > -1) {
                    ((LinkedList<HashtableNode>)this.table[hashVal]).remove(node);
                    if( ((LinkedList<HashtableNode>)this.table[hashVal]).size() == 0 )
                        this.table[hashVal] = null;

                    this.numElements--;
                }
            }
        }*/

        //public void remove(Object [] keys) {
        //    for (int i = 0; i < keys.length; i++) {
        //        this.remove(keys[i]);
        //    }
        //}

        public String toString() {
            String buffer = "";

            buffer += "{\n";
            for (int i = 0; i < this.table.length; i++) {
                if (this.table[i] != null) {
                    buffer  = buffer +  "\t" + this.table[i] + "\n" ;
                }
            }
            buffer += "}";
            return buffer;
        }

        public int getNumElements() {
            return this.numElements;
        }

        /*public boolean contains(Object key) {
            boolean result = false;
            int hash = this.hash(key);

            if (this.table[hash] != null) {
                HashtableNode node = new HashtableNode();
                node.key = key;
                if (((LinkedList<HashtableNode>)this.table[hash]).indexOf(node) > -1) {
                    result = true;
                }
            }
            return result;
        }*/

        public HashTable insertFromFile(String fileName) {
            try {
                Scanner fin = new Scanner(new File(fileName));
                while(fin.hasNext()) {
                    String[] strings = fin.nextLine().split(",");
                    this.add(strings[0], new WordItem(strings[0], Integer.parseInt(strings[1])));
                }
            }catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
            return this;
        }

        public static void main(String argv[]){
            long time = System.currentTimeMillis();
            HashTable myhash = (new HashTable()).insertFromFile("dictionary.txt");
            System.out.println(System.currentTimeMillis() - time);

            //test of strings
		/*
		System.out.println("Inital hash table is: \n" + myhash);
		myhash.add("smith", 30);
		myhash.add("john", 10);
		System.out.println("After two adds, hashtalbe is: \n" + myhash);
		myhash.add("green", 10);
		myhash.add("green", 60); //this will be added successfully, updating existing record.
		System.out.println("After four adds, hashtalbe is: \n" + myhash);

		myhash.remove("green");
		System.out.println("After remove green, hashtalbe is: \n" + myhash);
		*/

        }

}
