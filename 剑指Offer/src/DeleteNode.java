//删除链表的节点
public class DeleteNode {
    //public static ListNode deleteNode(ListNode head, int val) {
        /*
        if(head==null)
            return null;
        if(head.val==val)
            return head.next;
        ListNode cur=head.next;
        ListNode prev=head;
        while (cur!=null){
            if(cur.val==val)
                prev.next=cur.next;
            prev=cur;
            cur=cur.next;
        }
        return head;
        */

        /*
        if(head==null)
            return null;
        if(head.val==val)
            return head.next;
        ListNode cur=head;
        while (cur!=null&&cur.next.val!=val){
            cur=cur.next;
        }
        if(cur.next!=null)
            cur.next=cur.next.next;
        return head;
        */

        public static ListNode deleteNode(ListNode pHead, ListNode pToBeDeleted) {
            // 健壮性判断
            if (pHead == null || pToBeDeleted == null)
                return null;
            // 正常执行
        /*
        1. sp:链表只有一个节点, 如果头节点是要删除的节点，头指针指向null即可
        2. sp:删除最后一个节点, 找出倒数第二个节点并让该节点指向null
        3. 令待删节点的value等于待删节点下一个节点的value, 并令待删节点指向下一个节点的下一个节点
         */
            //1.
            if (pHead.next == null) {
                if(pHead.val==pToBeDeleted.val) {
                    pHead = null;
                }
                return pHead;
            }

            //2.
            ListNode temp = pHead;
            if (pToBeDeleted.next == null) {
                while (temp.next != pToBeDeleted)
                    temp = temp.next;
                temp.next = null;
            }

            //3.
            temp = pToBeDeleted.next;
            pToBeDeleted.val = temp.val;
            pToBeDeleted.next = temp.next;

            return pHead;
        }

    public static void printListNode(ListNode head){
        ListNode cur=head;
        while (cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(4);
        ListNode n2=new ListNode(5);
        ListNode n3=new ListNode(1);
        ListNode n4=new ListNode(9);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=null;

        printListNode(deleteNode(n1,n2));
    }
}
