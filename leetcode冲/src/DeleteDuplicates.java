public class DeleteDuplicates {
    //删除排序列表中的重复元素
    //1->2->2->3->4         1->2->3->4
    public static void printLinkedList(ListNode head){
        ListNode cur=head;

        while(cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode cur=head;
        ListNode next=head.next;
        while(next!=null){
            if(cur.val==next.val){
                next=next.next;
                cur.next=next;
            }else{
                cur=next;
                next=next.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode n5 = new ListNode(6,null);
        ListNode n4 = new ListNode(5, n5);
        ListNode n3 = new ListNode(5, n4);
        ListNode n2 = new ListNode(3, n3);
        ListNode n1 = new ListNode(1, n2);

        ListNode result=deleteDuplicates(n1);
        printLinkedList(result);
    }
}
