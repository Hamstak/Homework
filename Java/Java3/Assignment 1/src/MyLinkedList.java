import com.sun.corba.se.impl.presentation.rmi.IDLTypeException;

import java.io.Serializable;
import java.util.*;

/**
 * Created by tim on 10/5/15.
 */
public class MyLinkedList<T> implements Cloneable, List<T>, Serializable
{
    private class Node<E>{
        E data;
        Node<E> next;

        private Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }

        private Node(E data){
            this(data, null);
        }
    }

    //vairables of our linked list
    int size;
    Node<T> head;

    public MyLinkedList(){
        size = 0;
        head = new Node<T>(null);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (isEmpty())
            return false;
        Node curr = head.next;
        while(curr != null){
            if (curr.data.equals(o))
                return true;
            curr = curr.next;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator(){
        return new MyLinkedListIterator<>(this);
    }

    //class attached to the iterator
    public class MyLinkedListIterator<T> implements Iterator<T>{

        MyLinkedList<T> list;
        Node<T> curr;

        public MyLinkedListIterator(MyLinkedList list){
            this.list = list;
            curr = list.head;
        }

        @Override
        public boolean hasNext() {
            return curr.next != null;
        }

        @Override
        public T next() {
            curr = curr.next;
            return curr.data;
        }

        @Override
        public void remove() {
                list.remove(curr.data);
        }
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[this.size];
        Node curr = head.next;
        for (int i = 0; i < array.length; i++) {
            array[i] = curr.data;
            curr = curr.next;
        }
        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        return (T1[])toArray();
    }

    @Override
    public boolean add(T t) {
        this.head.next = new Node<T>(t, head.next);
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null)
            return false;
        if (isEmpty())
            return false;
        if (!o.getClass().getSimpleName().equals(head.next.data.getClass().getSimpleName()))
            return false;
        T t = (T)o;
        Node<T> curr = head.next;
        Node<T> prev = curr;
        while(curr.next != null) {
            if (t.equals(curr.data)) {
                curr.data = curr.next.data;
                curr.next = curr.next.next;
                size--;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        if (curr.data.equals(t)) {
            prev.next = null;
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection){
        Object[] testarray = collection.toArray();
        if( head.next != null || head.next.data.getClass().getSimpleName().equals(testarray[0].getClass().getSimpleName())){
            T[] array = (T[])testarray;
            for (int i = 0; i < array.length; i ++) {
                if(!contains(array[i])) {
                    return false;
                }
            }
        }else{
            return false;
        }
        return true;
    }

    @Override

    public boolean addAll(Collection<? extends T> collection) {
        Object[] testarray = collection.toArray();
        //System.out.println(head.data.getClass().getSimpleName());
        //System.out.println(testarray[0].getClass().getSimpleName());
        if(head.next != null) {
            if (head.next.data.getClass().getSimpleName().equals(testarray[0].getClass().getSimpleName())) {
                T[] array = (T[]) testarray;
                for (int i = 0; i < array.length; i++) {
                    addLast(array[i]);
                }
                return true;
            }
        }else{
            T[] array = (T[]) testarray;
            for (int i = 0; i < array.length; i++) {
                addLast(array[i]);
            }
            return true;
        }
        return false;
    }

    public void addLast(T t) {
        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = new Node(t);
        size++;
    }

    @Override
    public boolean addAll(int i, Collection<? extends T> collection) {
        Object[] testarray = collection.toArray();
        if (head.next != null) {
            if (head.next.data.getClass().getSimpleName().equals(testarray[0].getClass().getSimpleName())) {
                T[] array = (T[]) testarray;
                for (int n = 0; n < array.length; n++) {
                    add(i + n, array[n]);
                }
                return true;
            }
        }else{
            addAll(collection);
            return true;
        }
        return false;
    }

    public void addFirst(T t){
        head.next = new Node<T>(t, head.next);
        size++;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        if (collection == null || collection.size() == 0)
                return false;
        if (isEmpty())
            return false;
        Object[] testarray = collection.toArray();
        if (head.next.data.getClass().getSimpleName().equals(testarray[0].getClass().getSimpleName())){
            T[] array = (T[])testarray;
            int testSize = this.size;
            for (int i = 0; i < array.length; i++){
                remove(array[i]);
            }
            if (testSize == this.size)
                return false;
            return true;
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        if (isEmpty() || collection == null || collection.size() == 0)
            return false;
        Object[] testarray = collection.toArray();
        if (head.next.data.getClass().getSimpleName().equals(testarray[0].getClass().getSimpleName())){
            T[] array = (T[])testarray;
            List<T> toRemove = new ArrayList<>();
            int testSize = this.size;
            Node<T> curr = head.next;
            while(curr != null){
                boolean in = false;
                for (int i = 0; i < 10; i++){
                    if (curr.data.equals(testarray[i]) && !in){
                        in = true;
                    }
                }
                if (!in){
                    toRemove.add(curr.data);
                }
                curr = curr.next;
            }
            removeAll(toRemove);
            if (testSize != size)
                return true;
            return false;
        }
        return false;
    }

    @Override
    public void clear() {
        head = new Node<T>(null);
        size = 0;
    }

    @Override
    public T get(int i) throws IndexOutOfBoundsException{
        if (i < 0 || i >= size)
            throw new IndexOutOfBoundsException();
        Node<T> curr = head.next;
        for (i = i; i != 0; i--) {
            curr = curr.next;
        }
        return curr.data;

    }

    @Override
    public T set(int i, T t) {
        if (i < 0 || i >= size){
            throw new IndexOutOfBoundsException();
        }
        Node<T> curr = head.next;
        for (int n = i; n != 0; n--){
            curr = curr.next;
        }
        T temp = curr.data;
        curr.data = t;
        return temp;
    }

    @Override
    public void add(int i, T t) {
        if (i < 0 || i > size){
            throw new IndexOutOfBoundsException();
        }
        Node<T> curr = head.next;
        Node<T> prev = head;
        if (i == size){
            while(curr != null){
                prev = curr;
                curr = curr.next;
            }
        }else {
            for (int n = i; n != 0; n--) {
                prev = curr;
                curr = curr.next;

            }
        }
        Node<T> newNode = new Node<T>(t, curr);
        prev.next = newNode;
        size++;
    }

    @Override
    public T remove(int i) {
        if (i < 0 || i >= size){
            throw new IndexOutOfBoundsException();
        }
        Node<T> curr = head.next;
        Node<T> prev = head;
        for (int n = i; n != 0; n--) {
            curr = curr.next;
            prev = prev.next;
        }
        T temp = curr.data;
        prev.next = curr.next;
        size--;
        return temp;

    }

    @Override
    public int indexOf(Object o) {
        int i = -1;
        Node<T> curr = head.next;
        if (curr.data.getClass().getSimpleName().equals(o.getClass().getSimpleName())){
            T t = (T)o;
            for(int n = 0; curr != null; n++) {
                if (curr.data.equals(t)){
                    i = n;
                    break;
                }
                curr = curr.next;
            }
        }
        return i;
    }

    @Override
    public int lastIndexOf(Object o) {
        int i = -1;
        Node<T> curr = head.next;
        if (curr.data.getClass().getSimpleName().equals(o.getClass().getSimpleName())){
            T t = (T)o;
            for(int n = 0; curr != null; n++) {
                if (curr.data == t){
                    i = n;
                }
                curr = curr.next;
            }
        }
        return i;
    }

    public class MyLinkedListListIterator<T> implements ListIterator<T>{

        ArrayList<T> arrayList;
        T toRemove;
        int index;

        public MyLinkedListListIterator(MyLinkedList<T> list){
            arrayList = new ArrayList<T>();
            Node<T> curr = (Node<T>) list.head.next;
            while(curr != null) {
                arrayList.add(curr.data);
                curr = curr.next;
            }
            toRemove = null;
            index = 0;
        }

        @Override
        public boolean hasNext() {
            try{
                arrayList.get(index);
                return true;
            }catch (IndexOutOfBoundsException e) {
                return false;
            }
        }

        @Override
        public T next() {
            T temp = null;
            try{
                temp = arrayList.get(index);
                toRemove = temp;
                index++;

            }catch(IndexOutOfBoundsException e){
                return null;
            }
            return temp;
        }

        @Override
        public boolean hasPrevious() {
            try{
                arrayList.get(index - 1);
                return true;
            }catch(IndexOutOfBoundsException e){
                return false;
            }
        }

        @Override
        public T previous() {
            T temp = null;
            try{
                temp = arrayList.get(index - 1);
                toRemove = temp;
                index--;
            }catch(IndexOutOfBoundsException e){
                return null;
            }
            return temp;
        }

        @Override
        public int nextIndex() {
            return index + 1;
        }

        @Override
        public int previousIndex() {
            return index - 1;
        }

        @Override
        public void remove() {
            arrayList.remove(toRemove);
        }

        @Override
        public void set(T t) {
            arrayList.set(index , t);
        }

        @Override
        public void add(T t) {
            arrayList.add(t);
        }
    }

    @Override
    public ListIterator<T> listIterator() {
        return new MyLinkedListListIterator<T>(this);
    }

    @Override
    public ListIterator<T> listIterator(int i) {
        ListIterator<T> temp = new MyLinkedListListIterator<T>(this);
        if (!(i >= 0 && i < size)){
            return null;
        }
        for (int n = i; n > 0; n--){
            if(temp.hasNext()){
                temp.next();
            }
        }
        return temp;
    }

    @Override
    public List<T> subList(int i, int i1) {
        List<T> temp = new ArrayList<T>();
        Node<T> curr = head.next;
        if (i < 0 || i >= size || i > i1 || i1 < 0 || i1 >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int n = i; n != 0; n--){
            curr = curr.next;
        }
        for (int n = i; n < i1; n++){
            temp.add(curr.data);
            curr = curr.next;
        }
        return temp;
    }

    @Override
    public String toString(){
        String temp = "";
        Node<T> curr = head.next;
        temp = "[";
        while(curr != null){
            //System.out.println(curr.data.getClass().getSimpleName());
            if (curr.data.getClass().getSimpleName().equals("String")){
                String temp1 = "\"" + curr.data + "\"";
                temp += temp1;
                if (curr.next != null){
                    temp += ",";
                }
            }else{
                String temp1 = "\"" + curr.data.toString() + "\"";
                temp += temp1;
                if (curr.next != null){
                    temp += ",";
                }
            }
            curr = curr.next;
        }
        temp += "]";
        return temp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyLinkedList<?> that = (MyLinkedList<?>) o;
        if (size != that.size){
            return false;
        }
        if (size ==0) return true;

        Node<?> curr = head.next;
        Node<?> thatcurr = (Node<?>) that.head.next;
        while(curr != null){
            if (!curr.data.equals(thatcurr.data)){
                return false;
            }
            curr = curr.next;
            thatcurr = thatcurr.next;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.toArray());
    }

}
