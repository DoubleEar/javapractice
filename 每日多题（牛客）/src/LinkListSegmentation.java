//链表的分割
//以给定值x为基准将链表分割成两部分
// 所有小于x的结点排在大于或等于x的结点之前
public class LinkListSegmentation {
    public static void printLinkedList(ListNode head) {
        ListNode cur = head;

        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
    }
    public static ListNode partition(ListNode pHead, int x) {
        if(pHead==null)
            return null;
        ListNode sList=new ListNode(-1);//追加小于x的节点
        ListNode bList=new ListNode(-1);//追加大于等于x的节点

        ListNode cur=pHead;//遍历原链表
        ListNode sl=sList;
        ListNode bl=bList;
        while (cur!=null){
            if(cur.val<x){
                    sl.next = cur;
                    sl=cur;
            }else{
                    bl.next = cur;
                    bl=cur;
            }
            cur=cur.next;
        }
        bl.next=null;
        sl.next=bList.next;//小数链表的尾链接大树链表的头
        return sList.next;
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(8);
        ListNode n2=new ListNode(9);
        ListNode n3=new ListNode(1);
        ListNode n4=new ListNode(3);
        ListNode n5=new ListNode(6);
        ListNode n6=new ListNode(7);
        ListNode n7=new ListNode(0);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;
        n7.next=null;

        printLinkedList(partition(n1,6));
    }
}
