public class MyLinkedList  implements MyList{
    private Node head;
    @Override
    public void pushFront(int element) {
        Node node=new Node();
        node.val=element;
        node.next=head;
        head=node;
    }

    @Override
    public void popFront() {
        head=head.next;
    }
    @Override
    public String toString() {
        String s = "";
        for (Node cur =head; cur != null; cur = cur.next) {
            s += String.format("%d --> ", cur.val);
        }
        s += "null";
        return s;
    }
}




