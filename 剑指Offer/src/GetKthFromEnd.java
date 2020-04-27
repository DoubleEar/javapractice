//链表中倒数第k个节点
public class GetKthFromEnd {
    public static void printListNode(ListNode head){
        ListNode cur=head;
        while (cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
    }

    /**
     * 双指针法，让两个指针之间保持k-1个位置。7
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null||k<=0){
            return null;
        }
        ListNode cur=head;
        ListNode res=null;
        for(int i=0;i<k-1;i++){
            if(cur!=null) {
                cur = cur.next;
            }
        }

        res=head;
        //当快指针指向链表中最后一个节点时，res为倒数第k个节点。
        while (cur.next!=null){
            cur=cur.next;
            res=res.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        ListNode n6=new ListNode(6);
        ListNode n7=new ListNode(7);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;
        n7.next=null;

        printListNode(getKthFromEnd(n1,4));
    }
}
