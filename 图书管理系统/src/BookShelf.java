import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookShelf {
    private static final BookShelf instance=new BookShelf();
    private BookShelf(){}


    public static BookShelf getBookShelf() {
        return instance;
    }

    //Book[] array=new Book[100];
    //int size;

    List<Book> list=new ArrayList<>();
    public void add(Book book){
        list.add(book);
        //array[size++]=book;
    }

    public Book[] getBooks() {
        Book[] array=new Book[list.size()];
        list.toArray(array);
        return array;
        //return Arrays.copyOf(array,size);
    }

    public void remove(String title){
        //1.找下标
        /*int removeIndex=-1;
        for(int i=0;i<list.size();i++){
            Book book=list.get(i);
            if(book.title.equals(title)){
                removeIndex=i;
                break;
            }
        }
        if(removeIndex!=-1){
            list.remove(removeIndex);
        }
        */
        //2.利用迭代器删除
        Iterator<Book> it =list.iterator();
        while (it.hasNext()){
            Book book=it.next();
            if(book.title.equals(title)){
                it.remove();//删除的就是刚才拿到的数据
            }
        }
    }
}
