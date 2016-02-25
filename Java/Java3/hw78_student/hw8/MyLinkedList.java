

/**
 * Created by moth on 12/3/15.
 */
public class MyLinkedList {
    private class Node{

        private WordItem word;
        private Node next;

        private Node(WordItem word){
            this.word = word;
        }

        private Node(WordItem word, Node next){
            this(word);
            this.next = next;
        }

    }
    private Node head;
    private int size;

    public MyLinkedList(){
        head = null;
        size = 0;
    }

    public void add(WordItem word){
        Node newNode = new Node(word);
        if (isEmpty()){
            head = newNode;
        }else{
            Node prev = head;
            if (head.word.getCount() <= newNode.word.getCount()){
                newNode.next = head;
                head = newNode;
                size++;
                return;
            }
            for (Node curr = head; curr != null; curr = curr.next){
                if (curr.word.getCount() <= newNode.word.getCount()){
                    if (curr.word.getWord().equals(newNode.word.getWord()))
                        return;
                    prev.next = newNode;
                    newNode.next = curr;
                    size++;
                    return;
                }
                    prev = curr;
            }
            prev.next = newNode;
        }
        size++;

    }

    public MyLinkedList take(int n){
        MyLinkedList list = new MyLinkedList();
        if (n > size)
            n = size;
        Node curr = head;
        for (int i = 0; i < n; i++){
            list.add(curr.word);
            curr = curr.next;
        }
        return list;
    }
    public String[] toArray(){
        String[] strings = new String[size];
        Node curr = head;
        for (int i = 0; i < size; i++){
            strings[i] = curr.word.getWord();
            curr = curr.next;
        }
        return strings;
    }
    @Override
    public String toString(){
        String string = "";
        if (isEmpty()){
            return string;
        }
        string += head.word.getWord();
        for (Node curr = head.next; curr != null; curr = curr.next){
            string += ", " + curr.word.getWord();
        }
        return string;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
