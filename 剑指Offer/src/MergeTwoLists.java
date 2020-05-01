//合并两个有序链表。
public class MergeTwoLists {
    private static void printListNode(ListNode n1){
        ListNode cur=n1;
        while (cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /*
        //非递归
        if(l1==null&&l2==null)
            return null;
        else if(l1==null)
            return l2;
        else if(l2==null)
            return l1;

        ListNode cur1=l1;
        ListNode cur2=l2;
        ListNode nHead=null;
        ListNode nLast=null;

        while (cur1!=null&&cur2!=null){
            if(cur1.val<=cur2.val){
                if(nHead==null) {
                    nHead = cur1;
                }else {
                //尾插
                    nLast.next=cur1;
                }
                nLast=cur1;
                cur1=cur1.next;
            }else{
                if(nHead==null) {
                    nHead=cur2;
                }
                else {
                    nLast.next=cur2;
                }
                nLast=cur2;
                cur2=cur2.next;
            }
        }

        if(cur1==null)
            nLast.next=cur2;
        else if(cur2==null)
            nLast.next=cur1;

        return nHead;
        */

        //递归
        if(l1==null&&l2==null)
            return null;
        else if(l1==null)
            return l2;
        else if(l2==null)
            return l1;

        ListNode nHead=null;

        if(l1.val<=l2.val){
            nHead=l1;
            nHead.next=mergeTwoLists(l1.next,l2);
        }else{
            nHead=l2;
            nHead.next=mergeTwoLists(l1,l2.next);
        }
        return nHead;
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(4);

        ListNode n4=new ListNode(1);
        ListNode n5=new ListNode(3);
        ListNode n6=new ListNode(4);

        n1.next=n2;
        n2.next=n3;
        n3.next=null;
        n4.next=n5;
        n5.next=n6;
        n6.next=null;

        printListNode(mergeTwoLists(n1,n4));
    }
}
