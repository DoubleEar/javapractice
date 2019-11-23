//找出一个链表中间的那个数，如果是偶数，返回后面那个。
public class MiddleNode {
    public static Node middleNode(Node head){
        Node cur = head;
        int size=0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        int steps=size/2;
        Node result=head;
        for(int i=0;i<steps;i++){
            result=result.next;
        }
        return result;
    }
    public static void main(String[] args){
        Node n6=new Node(6);
        Node n5=new Node(5,n6);
        Node n4=new Node(4,n5);
        Node n3=new Node(3,n4);
        Node n2=new Node(2,n3);
        Node n1=new Node(1,n2);

        System.out.println(middleNode(n1));
    }
}
