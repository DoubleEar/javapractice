public class UseList {
    public static MyList selectYiFang(){
        return new MyLinkedList();
    }

    public static void main(String[] args) {
        MyList list=new MyLinkedList();
        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(3);
        list.popFront();
        System.out.println(list);
    }
}
