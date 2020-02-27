public class SwapPairs {
    public static void printLinkedList(ListNode head){
        ListNode cur=head;

        while(cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        //只剩一个节点或者没有节点时为递归终止条件
        if(head==null||head.next==null){
            return head;
        }
        //三个节点：要交换的两个节点和已经交换好的节点
        //每次只需要将前两个节点交换即可
        ListNode next=head.next;
        head.next=swapPairs(next.next);
        next.next=head;
        //交换了两个节点以后，返回后面内个节点，因为它是交换后的新头。
        return next;
    }

    public static void main(String[] args) {
        ListNode n4=new ListNode(4,null);
        ListNode n3=new ListNode(3,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1,n2);

        ListNode result=swapPairs(n1);
        printLinkedList(result);

    }
}
