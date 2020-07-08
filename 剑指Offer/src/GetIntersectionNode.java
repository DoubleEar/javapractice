import java.util.Stack;

//两个链表的第一个公共节点
public class GetIntersectionNode {
    /*
    //方法一：使用辅助栈，从尾结点开始遍历。
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)
            return null;

        Stack<ListNode> s1=new Stack<>();
        Stack<ListNode> s2=new Stack<>();

        ListNode cur=headA;
        while (cur!=null){
            s1.push(cur);
            cur=cur.next;
        }
        cur=headB;
        while (cur!=null){
            s2.push(cur);
            cur=cur.next;
        }

        while (!s1.isEmpty()&&!s2.isEmpty()&&s1.peek()==s2.peek()){
            s1.pop();
            s2.pop();
        }
        return s1.peek().next;
    }
    */

    /*
    private static int getLen(ListNode node){
        ListNode cur=node;
        int size=0;
        while (cur!=null){
            size++;
            cur=cur.next;
        }
        return size;
    }

    //方法二:快慢指针法获取长度
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=getLen(headA);
        int lenB=getLen(headB);
        int dis=lenA-lenB;

        ListNode headLong=headA;
        ListNode headShort=headB;
        if(lenB>lenA){
            headLong=headB;
            headShort=headA;
            dis=lenB-lenA;
        }

        for(int i=0;i<dis;i++){ //让长的链表先走dis步
            headLong=headLong.next;
        }

        while (headLong!=null&&headShort!=null&&headLong!=headShort){
            headLong=headLong.next;
            headShort=headShort.next;
        }

        return headLong;
    }
    */

    //方法三：双指针法
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA=headA,pB=headB;
        while (pA!=pB){     //没有公共节点的情况：走完A,B两个链表的长度和，都为null时跳出循环。
            pA=pA==null?headB:pA.next;
            pB=pB==null?headA:pB.next;
        }
        return pA;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(4);
        ListNode l2=new ListNode(1);
        ListNode l3=new ListNode(8);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=null;

        ListNode n1=new ListNode(5);
        ListNode n2=new ListNode(0);
        ListNode n3=new ListNode(1);
        n1.next=n2;
        n2.next=n3;
        n3.next=null;

        System.out.println(getIntersectionNode(l1,n1));
    }
}
