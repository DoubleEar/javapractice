import java.util.Comparator;

public class AuthorComparator implements Comparator<BookCompare> {
    @Override
    public int compare(BookCompare o1, BookCompare o2) {
        return o1.author.compareTo(o2.author);
    }
}
