//给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
//如果有两个中间结点，则返回第二个中间结点。
public class MiddleNode {
    public static ListNode middleNode(ListNode head) {
        /*
        //数组
        ListNode[] node=new ListNode[100];
        int n=0;
        while (head!=null){
            node[n++]=head;
            head=head.next;
        }
        return node[n/2];
        */

        /*
        //单指针法
        ListNode cur=head;
        int size=0;
        while (cur!=null){
            size++;
            cur=cur.next;
        }
        int k=0;
        cur=head;
        while (k<size/2){
            k++;
            cur=cur.next;
        }
        return cur;
        */

        //快慢指针法
        ListNode fast=head,slow=head;
        while (fast!=null&&fast.next!=null){
            //慢指针每次走一步
            slow=slow.next;
            //快指针每次走两步
            fast=fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=null;

        System.out.println(middleNode(node1));
    }
}
