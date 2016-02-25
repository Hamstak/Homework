import java.util.Comparator;

/**
 * Created by tim on 10/13/15.
 */
public class OccuranceComparator implements Comparator {
    @Override
    public int compare(Object o, Object t1) {
        WordItem first = (WordItem) o;
        WordItem second = (WordItem) t1;

        int OccuranceChange;
        if ((OccuranceChange = Integer.compare(first.getCount(), second.getCount())) == 0){
            return first.getWord().compareToIgnoreCase(second.getWord());
        }
        return -1 * OccuranceChange;
    }
}
