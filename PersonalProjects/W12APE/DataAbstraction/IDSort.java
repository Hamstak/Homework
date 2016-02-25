import java.util.*;
public class IDSort implements Comparator{
   public int compare(Object studentOne, Object studentTwo){
      return studentOne.compareTo(studentTwo);
   }
}