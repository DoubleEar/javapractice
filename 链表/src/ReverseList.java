public class ReverseList {
    public static Node buildLinkedList(){
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        return n1;
    }
    public static void printLinkedList(Node head) {
        Node cur = head;

        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
    public static Node reverseList(Node head){
        Node cur=head;
        Node newHead=null;//新建一个链表，newhead是头节点
        while(cur!=null) {
            //把cur 头插 到 newhead 所代表的链表上去
            Node next=cur.next;
            cur.next=newHead;
            newHead=cur;
            cur=next;
        }
        return newHead;
        }
        public static void main(String[] args){
            Node head= buildLinkedList();
            head=reverseList(head);

            printLinkedList(head);
        }
    }

