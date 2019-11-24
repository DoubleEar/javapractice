//找到两个链表相交的结点的值
public class Solution {
    public static int getLength(Node head){
        int count=0;
        Node cur=head;

        for(;cur!=null;cur=cur.next){
            count++;
        }
        return count;
    }
    public static Node Solution(Node headA,Node headB){
        int lenA=getLength(headA);
        int lenB=getLength(headB);
        int dis=lenA-lenB;

        Node longger=headA;
        Node shorter=headB;
        while(lenA<lenB){
            longger=headB;
            shorter=headA;
            dis=lenB-lenA;
        }

        for(int i=0;i<dis;i++){
            longger=longger.next;
        }
        while(longger!=shorter){
            longger=longger.next;
            shorter=shorter.next;
        }
        return longger;
    }
    public static void main(String[] args){
        Node n6=new Node(1);
        Node n5=new Node(2,n6);
        Node n4=new Node(3,n5);
        Node n3=new Node(3,n4);
        Node n2=new Node(2,n3);
        Node n1=new Node(1,n2);

        Node m2=new Node(5,n6);
        Node m1=new Node(3,m2);

        System.out.println(Solution(n1,m1));
    }
}
