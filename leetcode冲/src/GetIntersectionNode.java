//求两个相交链表的结点。
//两个链表走过相同的长度，如果他们相交，他们总会相遇。
class ListNode {
    int val;
    ListNode next;

    ListNode(int x,ListNode next) {
        this.val = x;
        this.next = next;
     }
}
public class GetIntersectionNode {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)
            return null;
        ListNode pA=headA;//链表A的头结点
        ListNode pB=headB;//链表B的头结点
        while(pA!=pB){
            //pA是否走到最后，如果走到最后，就从B的头继续走
            pA=pA==null?headB:pA.next;
            //pB是否走到最后，如果走到最后，就从A的头继续走
            pB=pB==null?headA:pB.next;
        }
        return pA;
    }
    public static void main(String[] args) {
        ListNode l4=new ListNode(4,null);
        ListNode l3=new ListNode(3,l4);
        ListNode l2=new ListNode(2,l3);
        ListNode l1=new ListNode(1,l2);

        ListNode n2=new ListNode(6,l3);
        ListNode n1=new ListNode(5,n2);

        System.out.println(getIntersectionNode(l1,n1));

    }
}
