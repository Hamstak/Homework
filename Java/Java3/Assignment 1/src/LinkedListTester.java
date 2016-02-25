/*Tim Tanasse
 * Wednesday October 7th, 2015
 * Generic EC attempted.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTester {

    public static void main(String[] args) {
        MyLinkedList<String> tester = new MyLinkedList<>();
        String[] options = {"boolean add","add at index",
            "add collection", "add collection at index", "addFirst",
            "addLast", "clear","contains","containsAll", "equals", "get",
            "hashCode", "IndexOf", "isEmpty", "iterator","lastIndexOf",
            "listIterator", "listIterator at index","remove and get what was removed", "boolean remove", "boolean removeAll", "retainAll",
            "set","size", "subList", "toString", "exit"};
        System.out.println("Linked List Implementations Menu:");
        int option = UserUtil.DynamicMenu(options);
        while(option != options.length){
            switch (option){
                case 1: booleanAddTester();
                    break;
                case 2: addAtIndexTester();
                    break;
                case 3: addCollectionTester();
                    break;
                case 4: addCollectionAtIndexTester();
                    break;
                case 5: addFirstTester();
                    break;
                case 6: addLastTester();
                    break;
                case 7: clearTester();
                    break;
                case 8: containsTester();
                    break;
                case 9: containsAllTester();
                    break;
                case 10: equalsTester();
                    break;
                case 11: getTester();
                    break;
                case 12: hashCodeTester();
                    break;
                case 13: indexOfTester();
                    break;
                case 14: isEmptyTester();
                    break;
                case 15: iteratorTester();
                    break;
                case 16: lastIndexOfTester();
                    break;
                case 17: listIteratorTester();
                    break;
                case 18: listIteratorAtIndexTester();
                    break;
                case 19: removeAndGetTester();
                    break;
                case 20: booleanRemoveTester();
                    break;
                case 21: booleanRemoveAllTester();
                    break;
                case 22: retainAllTester();
                    break;
                case 23: setTester();
                    break;
                case 24: sizeTester();
                    break;
                case 25: subListTester();
                    break;
                case 26: toStringTester();
                    break;

            }
            option = UserUtil.DynamicMenu(options);
        }
        System.exit(0);
    }
    private static void booleanAddTester(){
        System.out.println("Begin booleanAddTester!");
        MyLinkedList<String> temp = new MyLinkedList<>();
        System.out.println(temp.toString());
        System.out.println(temp.add("test"));
        System.out.println(temp.toString());
        System.out.println("booleanAddTester complete!\n");

    }
    private static void addAtIndexTester(){
        System.out.println("Begin addAtIndexTester!");
        MyLinkedList<String> temp = new MyLinkedList<>();
        for (int i = 0; i < 10; i++){
            temp.addLast("" + i);
        }
        System.out.println(temp.toString());
        temp.add(3, "test3");
        temp.add(0, "test");
        temp.add(temp.size() - 1, "testlength");
        System.out.println(temp.toString());
        System.out.println("Completed addAtIndexTester!\n");
    }
    private static void addCollectionTester(){
        System.out.println("Begin addCollectionTester!");
        MyLinkedList<String> tempLL = new MyLinkedList<>();
        List<String> tempAL = new ArrayList<String>();
        for (int i = 0; i < 10; i++){
            tempAL.add("" + i);
        }
        System.out.println(tempLL.toString());
        tempLL.add("test");
        tempLL.addAll(tempAL);
        System.out.println(tempLL.toString());
        System.out.println("Completed addCollectionTester!\n");
    }
    private static void addCollectionAtIndexTester(){
        System.out.println("Begin addCollectionAtIndexTester!");
        MyLinkedList<String> tempLL = new MyLinkedList<>();
        List<String> tempAL = new ArrayList<String>();
        for (int i = 0; i < 10; i++){
            tempAL.add("" + i);
        }
        System.out.println(tempLL.toString());
        tempLL.add("test");
        tempLL.addAll(tempAL);
        System.out.println(tempLL.toString());
        tempLL.addAll(3, tempAL);
        System.out.println(tempLL.toString());
        tempLL.addAll(0, tempAL);
        System.out.println(tempLL.toString());
        tempLL.addAll(tempLL.size() - 1, tempAL);
        System.out.println(tempLL.toString());
        System.out.println("Compeleted addCollectionAtIndexTester!\n");
    }
    private static void addFirstTester(){
        System.out.println("Begin addFirstTester!");
        MyLinkedList<String> temp = new MyLinkedList<>();
        temp.add("test");
        System.out.println(temp.toString());
        temp.addFirst("first");
        System.out.println(temp.toString());
        System.out.println("Completed addFirstTester!\n");
    }
    private static void addLastTester(){
        System.out.println("Begin addLastTester!");
        MyLinkedList<String> temp = new MyLinkedList<>();
        temp.add("test");
        System.out.println(temp.toString());
        temp.addLast("last");
        System.out.println(temp.toString());
        System.out.println("Completed addLastTester!\n");
    }
    private static void clearTester(){
        System.out.println("Begin clearTester!");
        MyLinkedList<String> temp = new MyLinkedList<>();
        for (int i = 0; i < 10; i++){
            temp.add("" + i);
        }
        System.out.println(temp.toString());
        temp.clear();
        System.out.println(temp.toString());
        System.out.println("Completed clearTester!\n");
    }
    private static void containsTester() {
        System.out.println("Begin containsTester!");
        MyLinkedList<String> temp = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            temp.add("" + i);
        }
        System.out.println(temp.toString());
        double random = Math.random();
        if (temp.contains("" + 1)) {
            System.out.println("The list " + temp.toString() + " contained the number " + 1);
        }
        if (!temp.contains("" + random)) {
            System.out.println("The list " + temp.toString() + " did not contain the number " + random);
        }
        System.out.println("Completed containsTester!\n");
    }
    private static void containsAllTester(){
        System.out.println("Begin containsAllTester!");
        MyLinkedList<String> temp = new MyLinkedList<>();
        for (int i = 0; i < 10; i++){
            temp.add("" + i);
        }
        System.out.println(temp.toString());
        List<String> tempList1 = new ArrayList<>();
        List<String> tempList2 = new ArrayList<>();
        for (int i = 0; i < 2; i++){
            tempList1.add("" + Math.random());
        }
        for (int i = 0; i < 2; i++){
            tempList2.add("" + i);
        }
        if (!temp.containsAll(tempList1)){
            System.out.println("The list " + temp.toString() + " did not contain the numbers " + tempList1.toString());
        }
        if (temp.containsAll(tempList2)){
            System.out.println("The list " + temp.toString() + " does contain the numbers " + tempList2.toString());
        }
        System.out.println("Completed containsAllTester!\n");
    }
    private static void equalsTester(){
        System.out.println("Begin equalsTester!");
        MyLinkedList<String> temp = new MyLinkedList<>();
        MyLinkedList<String> temp1 = new MyLinkedList<>();
        MyLinkedList<String> temp2 = new MyLinkedList<>();
        MyLinkedList<String> temp3 = new MyLinkedList<>();
        String testerString = "This should fail";
        for (int i = 0; i < 10; i++){
            temp.add("" + i);
            temp1.add("" + i);
            temp2.add("" + Math.random());
        }
        System.out.println(temp.toString() + "=" + temp1.toString() + "? " + temp.equals(temp1));
        System.out.println(temp.toString() + "=" + temp2.toString() + "? " + temp.equals(temp2));
        System.out.println(temp.toString() + "=" + temp3.toString() + "? " + temp.equals(temp3));
        System.out.println(temp.toString() + "=" + testerString + "? " + temp.equals(testerString));
        System.out.println("Completed equalsTester!\n");
    }
    private static void getTester(){
        System.out.println("Begin getTester!");
        MyLinkedList<String> temp = new MyLinkedList<>();
        for (int i = 0; i < 10; i++){
            temp.add("" + i);
        }
        System.out.println("Check if index 2 is the string \"7\"? " + temp.get(2).equals("7") );
        System.out.println("Completed getTester!\n");
    }
    private static void hashCodeTester(){
        System.out.println("Begin hasCodeTester!");
        MyLinkedList<String> temp = new MyLinkedList<>();
        MyLinkedList<String> temp1 = new MyLinkedList<>();
        for (int i = 0; i < 10; i++){
            temp.add("" + i);
            temp1.add("" + Math.random());
        }
        System.out.println(temp.hashCode());
        System.out.println(temp1.hashCode());
        System.out.println("Completed hashCodeTester!\n");
    }
    private static void indexOfTester(){
        System.out.println("Begin indexOfTester!");
        MyLinkedList<String> temp = new MyLinkedList<>();
        for (int i = 0; i < 10; i++){
            temp.add("" + i);
        }
        System.out.println(temp.toString() + " the index of \"2\" is " + temp.indexOf("2"));
        System.out.println("Completed indexOfTester!\n");
    }
    private static void isEmptyTester(){
        System.out.println("Begin isEmptyTester!");
        MyLinkedList<String> temp = new MyLinkedList<>();
        MyLinkedList<String> temp1 = new MyLinkedList<>();
        temp.add("testing");
        System.out.println("Non-empty list is empty? " + temp.isEmpty());
        System.out.println("Empty list is empty? " + temp1.isEmpty());
        System.out.println("Completed isEmptyTester!\n");
    }
    private static void iteratorTester(){
        System.out.println("Begin iteratorTester!");
        MyLinkedList<String> temp = new MyLinkedList<>();
        for (int i = 0; i < 10; i++){
            temp.add("" + i);
        }
        Iterator<String> tempIterator = temp.iterator();
        System.out.println("Does " + temp.toString() + " iterator have next? " + tempIterator.hasNext());
        System.out.println("Does " + temp.toString() + " iterator have \"9\" as next? " + tempIterator.next());
        System.out.println("Can " + temp.toString() + " have \"9\" removed?");
        tempIterator.remove();
        System.out.println("Yes? " + temp.toString());
        System.out.println("Completed iteratorTester!\n");
    }
    private static void lastIndexOfTester(){
        System.out.println("Begin lastIndexOfTester!");
        MyLinkedList<String> temp = new MyLinkedList<>();
        for (int x = 0; x < 2; x++){
            for (int y = 0; y < 10; y++){
                temp.add("" + y);
            }
        }
        System.out.println("Does the last \"2\" have an index of 12?" + temp.lastIndexOf("2"));
        System.out.println("Completed lastIndexOfTester!\n");
    }
    private static void listIteratorTester(){
        System.out.println("Begin listIteratorTester!");
        MyLinkedList<String> temp = new MyLinkedList<>();
        for (int i = 0; i < 10; i++){
            temp.add("" + i);
        }
        ListIterator<String> tempListIterator = temp.listIterator();
        System.out.println("Does the list iterator both have a next and give \"9\" as next? " + tempListIterator.next());
        System.out.println("Does the list iterator do that again for \"8\"? " + tempListIterator.next());
        System.out.println("Completed listIteratorTester!\n");

    }
    private static void listIteratorAtIndexTester(){
        System.out.println("Begin listIteratorAtIndexTester!");
        MyLinkedList<String> temp = new MyLinkedList<>();
        for (int i = 0; i < 10; i++){
            temp.add("" + i);
        }
        ListIterator<String> tempListIterator = temp.listIterator(3);
        if (tempListIterator.hasNext()){
            System.out.print(tempListIterator.next());
        }
        while(tempListIterator.hasNext()){
            System.out.print(", " + tempListIterator.next());
        }
        System.out.println("\n This should be equivalent to [3, 4, 5, 6, 7, 8, 9]");
        System.out.println("Completed listIteratorAtIndexTester!\n");
    }
    private static void removeAndGetTester(){
        System.out.println("Begin removeAndGetTester!");
        MyLinkedList<String> temp = new MyLinkedList<>();
        for (int i = 0; i < 10; i++){
            temp.add("" + i);
        }
        System.out.println(temp.toString());
        System.out.println("Does remove get rid of \"2\" at index 2 and return \"7\"? " + temp.remove(2));
        System.out.println(temp.toString());
        System.out.println("Completed removeAndGetTester!\n");
    }
    private static void booleanRemoveTester(){
        System.out.println("Begin booleanRemoveTester!");
        MyLinkedList<String> temp = new MyLinkedList<>();
        for (int i = 0; i < 10; i++){
            temp.add("" + i);
        }
        System.out.println(temp.toString());
        System.out.println("Does remove get rid of the first instance of \"2\" and return true? " + temp.remove("2"));
        System.out.println(temp.toString());
        System.out.println("Does remove not get rid of \"10\" and return false? " + temp.remove("10"));
        System.out.println(temp.toString());
        System.out.println("Completed booleanRemoveTester!\n");
    }
    private static void booleanRemoveAllTester(){
        System.out.println("Begin booleanRemoveAllTester!");
        MyLinkedList<String> temp = new MyLinkedList<>();
        List<String> tempList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            temp.add("" +  i);
            tempList.add("" + (2*i));
        }
        System.out.println(temp.toString());
        System.out.println("Does removeAll get rid of all even numbers in the list? " + temp.removeAll(tempList));
        System.out.println(temp.toString());
        System.out.println("Completed booleanRemoveAllTester!\n");
    }
    private static void retainAllTester(){
        System.out.println("Begin retainAllTester!");
        MyLinkedList<String> temp = new MyLinkedList<>();
        List<String> tempList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            temp.add("" +  i);
            tempList.add("" + (2*i));
        }
        System.out.println(temp.toString());
        System.out.println("Does retainAll retain all even numbers in the list? " + temp.retainAll(tempList));
        System.out.println(temp.toString());
        System.out.println("Completed retainAllTester!\n");
    }
    private static void setTester(){
        System.out.println("Begin setTester!");
        MyLinkedList<String> temp = new MyLinkedList<>();
        for (int i = 0; i < 10; i++){
            temp.add("" + i);
        }
        System.out.println(temp.toString());
        System.out.println("Does set get \"7\" and set \"7\" to be \"test\"? " + temp.set(2, "test"));
        System.out.println(temp.toString());
        System.out.println("Completed setTester!\n");
    }
    private static void subListTester(){
        System.out.println("Begin subListTester!");
        MyLinkedList<String> temp = new MyLinkedList<>();
        for (int i = 0; i < 10; i++){
            temp.add("" + i);
        }
        System.out.println(temp.toString());
        System.out.println("Print a sublist starting at index 2 and ending at 6:" + temp.subList(2,6));
        System.out.println("Completed subListTester!\n");
    }
    private static void toStringTester() {
        System.out.println("Begin toStringTester!");
        MyLinkedList<String> temp = new MyLinkedList<>();
        for (int i = 0; i < 10; i++){
            temp.add("" + i);
        }
        System.out.println(temp.toString());
        System.out.println("Completed toStringTester!\n");
    }
    private static void sizeTester(){
        System.out.println("Begin sizeTester!");
        MyLinkedList<String> temp = new MyLinkedList<>();
        for (int i = 0; i < 10; i++){
            System.out.print( temp.size() + " ");
            temp.add("" + i);
        }
        System.out.println();
        System.out.println("Completed sizeTester!\n");
    }
}
