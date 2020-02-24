//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
public class RemoveNthFromEnd {
    public static void printLinkedList(ListNode head){
        ListNode cur=head;

        while(cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }
    public static int getLength(ListNode head){
        if(head==null){
            return 0;
        }
        ListNode cur=head;
        int length=0;
        while(cur!=null){
            length++;
            cur=cur.next;
        }
        return length;
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int size=getLength(head);
        //哑结点用来简化某些极端情况，例如列表中只含有一个结点，或需要删除列表的头部。
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode cur=dummy;
        ListNode next=cur.next;
        if(n<=0||n>size||head==null){
            return null;
        }
        for(int i=0;i<size;i++){
            if(next!=null) {
                //当它到达第(L−n)个结点
                if (i == size - n) {
                    next = next.next;
                    cur.next = next;
                    break;
                }
            }
            cur = next;
            if(next!=null) {
                next = next.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        //ListNode n5 = new ListNode(6,null);
        //ListNode n4 = new ListNode(5, n5);
        //ListNode n3 = new ListNode(5, n4);
        ListNode n2 = new ListNode(3,null);
        ListNode n1 = new ListNode(1, n2);
        ListNode result=removeNthFromEnd(n1,2);
        printLinkedList(result);
    }
}
