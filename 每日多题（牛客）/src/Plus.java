//有两个用链表表示的整数，每个结点包含一个数位。
// 这些数位是反向存放的，也就是个位排在链表的首部。
// 编写函数对这两个整数求和，并用链表形式返回结果。
public class Plus {
    private static void printLinkedList(ListNode node){
        ListNode cur=node;

        while (cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
    }

    public static ListNode plusAB(ListNode a, ListNode b) {
        ListNode cur1=a;
        ListNode cur2=b;
        ListNode nHead=new ListNode(-1);
        ListNode cur=nHead;


        int sum=0;
        while (cur1!=null||cur2!=null) {
            if(cur1!=null&&cur2!=null){
                sum+=(cur1.val+cur2.val);
                cur.next=new ListNode(sum%10);
                cur=cur.next;
                cur1=cur1.next;
                cur2=cur2.next;
                sum/=10;
            }else if(cur1!=null){
                sum+=cur1.val;
                cur.next=new ListNode(sum%10);
                cur=cur.next;
                cur1=cur1.next;
                sum/=10;
            }else{
                sum+=cur2.val;
                cur.next=new ListNode(sum%10);
                cur=cur.next;
                cur2=cur2.next;
                sum/=10;
            }
        }

        //判断是否还有进位
        if(sum>0){
            cur.next=new ListNode(sum);
        }
        return nHead.next;
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(7);
        ListNode n2=new ListNode(4);
        ListNode n3=new ListNode(0);
        ListNode n4=new ListNode(7);
        ListNode n5=new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=null;

        ListNode m1=new ListNode(2);
        ListNode m2=new ListNode(7);
        ListNode m3=new ListNode(2);
        ListNode m4=new ListNode(3);
        ListNode m5=new ListNode(4);
        m1.next=m2;
        m2.next=m3;
        m3.next=m4;
        m4.next=m5;
        m5.next=null;

        printLinkedList(plusAB(n1,m1));
    }
}
