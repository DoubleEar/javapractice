public class PartitionList1 {
    public static void printLinkedList(Node head){
        Node cur=head;

        while(cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }
    public static Node partitionList1(Node head,int x){
        //定义两个链表中自带一个结点
        //该节点没有业务含义
        //只是为了避免尾插时需要分情况讨论
        Node sHead=new Node(1);
        Node sLast=sHead;
        Node bHead=new Node(1);
        Node bLast=bHead;
        Node cur=head;
        while(cur!=null){
            if(cur.val<x){
                sLast.next=cur;
                sLast=cur;
            }else{
                bLast.next=cur;
                bLast=cur;
            }
            cur=cur.next;
        }
        //sHead所代表的链表（第一个结点是无效结点）
        //bHead所代表的链表（第一个结点是无效结点）
        sLast.next=bHead.next;
        bHead.next=null;

        return sHead.next;
    }

    public static void main(String[] args) {
        Node n5=new Node(8);
        Node n4=new Node(9,n5);
        Node n3=new Node(3,n4);
        Node n2=new Node(7,n3);
        Node n1=new Node(1,n2);

        Node head=partitionList1(n1,6);
        printLinkedList(head);
    }
}
