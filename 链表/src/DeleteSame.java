//删除有序链表相同值的结点
public class DeleteSame {
    public static void printLinkedList(Node head){
        Node cur=head;

        while(cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }
    public static Node deleteSame(Node head){
        if (head == null) {
            return head;
        }
        Node prev = new Node(0);
        Node fake = prev;
        prev.next = head;
        Node cur = head;
        Node next = head.next;
        while (next != null) {
            if (cur.val != next.val) {
                prev = prev.next;
                cur = cur.next;
                next = next.next;
            } else {
                while (next != null && cur.val == next.val) {
                    next = next.next;
                }
                //next可能是null
                //删除[cur,next)
                prev.next = next;
                cur = next;
                if (next != null) {
                    next = next.next;
                }
            }
        }
        return fake.next;
    }

    public static void main(String[] args) {
        Node n5 = new Node(6);
        Node n4 = new Node(5, n5);
        Node n3 = new Node(5, n4);
        Node n2 = new Node(3, n3);
        Node n1 = new Node(1, n2);

        Node result=deleteSame(n1);
        printLinkedList(result);
    }
}


