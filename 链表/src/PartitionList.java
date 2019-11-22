//链表分割，不改变原来链表中的顺序，将比X小的放在左边，比x大的放在右边
public class PartitionList {
    public static void printLinkedList(Node head) {
        Node cur = head;

        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    public static Node partition(Node head,int x){
        Node cur=head;
        Node sHead=null;
        Node sLast=null;
        Node bHead=null;
        Node bLast=null;
        while(cur!=null){
            if(cur.val<x){
                if(sHead==null){
                    sHead=cur;
                }else{
                    sLast.next=cur;
                }
                sLast=cur;
            }else{
                if(bHead==null){
                    bHead=cur;
                }else{
                    bLast.next=cur;
                }
                bLast=cur;
            }
            cur=cur.next;
        }
        //如果小链表的头节点为空
        if(sHead==null){
            return bHead;
        }
        //如果大链表的头节点为空
        if(bHead==null){
            return sHead;
        }
        sLast.next=bHead;
        bLast.next=null;

        return sHead;
    }

    public static void main(String[] args){
        Node n5=new Node(8);
        Node n4=new Node(9,n5);
        Node n3=new Node(3,n4);
        Node n2=new Node(7,n3);
        Node n1=new Node(1,n2);

        Node head=partition(n1,6);
        printLinkedList(head);
    }
}
