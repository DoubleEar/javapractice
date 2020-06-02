//两数相加
//给出两个 非空 的链表用来表示两个非负的整数。
// 其中，它们各自的位数是按照 逆序 的方式存储的，
// 并且它们的每个节点只能存储 一位 数字。
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode nHead=new ListNode(0); //哑节点
        ListNode p=l1,q=l2,cur=nHead;
        int carry=0;    //表示进位，只可能是0或1。9+9+1=19。

        while (p!=null||q!=null){
               int x=(p!=null)?p.val:0;   //若到达l1末尾，置为0。
               int y=(q!=null)?q.val:0;   //若到达l2末尾，置为0。
               int sum=x+y+carry;
               carry=sum/10;    //计算进位
               cur.next=new ListNode(sum%10);   //创建新结点

                //更新
               cur=cur.next;
               if(p!=null)
                   p=p.next;
               if(q!=null)
                   q=q.next;
        }

        if(carry!=0)
            cur.next=new ListNode(carry);

        return nHead.next;  //返回哑节点的下一位
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(2);
        ListNode l2=new ListNode(4);
        ListNode l3=new ListNode(3);
        l1.next=l2;
        l2.next=l3;
        l3.next=null;

        ListNode t1=new ListNode(5);
        ListNode t2=new ListNode(6);
        ListNode t3=new ListNode(4);
        t1.next=t2;
        t2.next=t3;
        t3.next=null;

        addTwoNumbers(l1,t1);
    }
}
