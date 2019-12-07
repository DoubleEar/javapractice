import java.awt.print.Book;
import java.util.Comparator;
import java.util.Scanner;

public class BookCompare implements Comparable<BookCompare> {
    public String ISBN;
    public String title;
    public String author;
    int price;

    @Override
    public int compareTo(BookCompare o) {

        return this.price - o.price;
    }

    @Override
    public boolean equals(Object obj) {
        //1.obj==null;不相等
        if (obj == null)
            return false;
        //2.obj不是Book不相等
        if (!(obj instanceof BookCompare))
            return false;
        //3.向下转型
        BookCompare book = (BookCompare) obj;
        //4.比较需要的内容
        return this.ISBN.equals(book.ISBN);

    }

    public static void main(String[] args) {
        BookCompare book1 = new BookCompare();
        book1.ISBN = "123";
        book1.author = "女朋友";
        book1.title = "好人";
        book1.price = 100;
        BookCompare book2 = new BookCompare();
        book2.ISBN = "123";
        book2.author = "男朋友";
        book2.title = "好人";
        book2.price = 100;
        //System.out.println(book1.equals(book2));
        //System.out.println(book1.compareTo(book2));
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            int r = 5;
            if (line.equalsIgnoreCase("价格")) {
                // 按价格比较
                r = book1.compareTo(book2);
            } else if (line.equalsIgnoreCase("书名")) {
                // 按书名比较
                Comparator<BookCompare> c = new BookComparator();
                r = c.compare(book1, book2);
            } else if (line.equalsIgnoreCase("作者")) {
                Comparator<BookCompare> c = new AuthorComparator();
                r = c.compare(book1, book2);
            }
            System.out.println(r);
        }
    }
}
