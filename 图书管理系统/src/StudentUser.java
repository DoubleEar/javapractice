import java.util.Scanner;

public class StudentUser extends User {
    @Override
    public void menu() {
        System.out.println("1.借书");
        System.out.println("2.还书");
        System.out.println("3.现有书展示");
    }

    @Override
    public void operation(int select) {
        switch(select){
            case 1:
                borrowBook();
                break;
            case 2:
                returnBook();
                break;
            case 3:
                listBook();
                break;
            default:
                System.out.println("输入有误");
        }

    }

    private void returnBook() {
        System.out.println("请输入书名");
        Scanner scanner=new Scanner(System.in);
        String title=scanner.nextLine();
        BookShelf bookShelf=BookShelf.getBookShelf();
        Book[] books=bookShelf.getBooks();
        for(Book book:books){
            if(book.title.equals(title)){
                book.currentCount++;
            }
        }
        System.out.println("你所还的书不存在");
    }

    private void borrowBook() {
        System.out.println("请输入书名");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        BookShelf bookShelf = BookShelf.getBookShelf();
        Book[] books = bookShelf.getBooks();
        for (Book book : books) {
            if (book.currentCount > 0) {
                book.currentCount--;
                System.out.println("借书成功");
                return;
            } else {
                System.out.println("你所借的书已经没有了");
                return;
            }
        }
    }
    private void listBook() {
            BookShelf bookShelf = BookShelf.getBookShelf();
            Book[] books = bookShelf.getBooks();
            System.out.println("书名，当前数量，总数 ");
            for (Book book : books) {
                System.out.println(book.title + " , " + book.currentCount + " , " + book.totalCount);
            }
        }
    }

