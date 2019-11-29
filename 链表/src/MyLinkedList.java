public class MyLinkedList {
    private DoublyNode head=null;
    private DoublyNode last=null;
    private int size=0;

    //头插 空间复杂度O(1)
    public  void pushFront(int val){
        DoublyNode node=new DoublyNode(val);
        node.next=head;
        if(head!=null){
            head.prev=node;
        }
        head=node;
        if(head.next==null){
            last=head;
        }
        size++;
    }
    //头删 空间复杂度0(1)
    public void popFront(){
        if (size == 0) {
            throw new RuntimeException("空的");
        }
        head=head.next;
        if(head!=null){
            head.prev=null;
        }else{
            last=null;
        }
        size--;
    }

    //尾插 空间复杂度为O(1)
    public void pushBack(int val){
        DoublyNode node=new DoublyNode(val);
        if(last!=null) {
            last.next = node;
            node.prev=last;
        }else{
            head=last=node;
        }
        size++;
    }

    //尾删 空间复杂度为O(1)
    public void popBack(){
            if (size == 0) {
                throw new RuntimeException("空的");
            }
        if(last.prev!=null) {
            last.prev.next =null ;
            last=last.prev;
        }else{
                head=last=null;
        }
        size--;
    }
    @Override
    public String toString() {
        String s = "";
        for (DoublyNode cur =head; cur != null; cur = cur.next) {
            s += String.format("%d --> ", cur.val);
        }
        s += "null";

        return s;
    }
}
