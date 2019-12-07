import java.util.Comparator;

public class BookComparator implements Comparator<BookCompare> {
    @Override
    public int compare(BookCompare o1, BookCompare o2) {
        return o1.title.compareTo(o2.title);
    }
}
