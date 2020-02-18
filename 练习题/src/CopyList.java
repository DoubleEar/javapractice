//链表的复制
public class CopyList {
    public static void printLinkedList(Node head){
        Node cur=head;
        while(cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }
    public static Node copy(Node head){
        Node nHead=null;
        Node nLast=null;

        Node cur=head;
        while(cur!=null){
            Node node=new Node(cur.val);
            if(nHead==null){
                nHead=node;
            }else{
                nLast.next=node;
            }
            nLast=node;

            cur=cur.next;
        }
        return nHead;
    }
    public static void main(String[] args){
        Node n3=new Node(6);
        Node n2=new Node(3,n3);
        Node n1=new Node(2,n2);

        printLinkedList(copy(n1));
    }
}
