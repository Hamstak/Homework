import java.util.Comparator;

/**
 * Created by tim on 10/13/15.
 */
public class WordComparator implements Comparator {
    @Override
    public int compare(Object o, Object t1) {
        WordItem first = (WordItem) o;
        WordItem second = (WordItem) t1;

        return first.getWord().compareToIgnoreCase(second.getWord());
    }
}
