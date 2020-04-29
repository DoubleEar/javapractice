//反转链表
public class ReverseList {
        public static void printListNode(ListNode head) {
            ListNode cur = head;
            while (cur != null) {
                System.out.print(cur.val + " ");
                cur = cur.next;
            }
        }

        public static ListNode reverseList(ListNode head) {
            if (head == null)
                return null;
            if (head.next == null) {
                return head;
            }

            ListNode cur = head;    //记录当前节点
            ListNode prev = null;   //记录当前节点的上一个节点
            ListNode newH = null;   //记录原链表的最后一个节点即新链表的头
            while (cur!= null) {
                ListNode next = cur.next;   //当前节点的下一个节点

                if (next== null) {  //如果走到链表的最后一个节点
                    newH = cur;
                }

                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return newH;
        }

        public static void main(String[] args) {
            ListNode n1 = new ListNode(1);
            ListNode n2 = new ListNode(2);
            ListNode n3 = new ListNode(3);
            ListNode n4 = new ListNode(4);
            ListNode n5 = new ListNode(5);

            n1.next = n2;
            n2.next = n3;
            n3.next = n4;
            n4.next = n5;
            n5.next = null;

            printListNode(reverseList(n1));
        }
    }
