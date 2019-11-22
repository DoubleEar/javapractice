//判断一段文字是否为回文
public class PalindromeList {
    public static Node getMiddle(Node head){
        Node cur=head;
        int size=0;
        while(cur!=null){
            size++;
            cur=cur.next;
        }
        int steps=size/2;
        Node result=head;
        for(int i=0;i<steps;i++){
            result=result.next;
        }
        return result;
    }
    public static Node reverseList(Node head){
        Node cur=head;
        Node nHead=null;
        while(cur!=null){
            Node next=cur.next;

            cur.next=nHead;
            nHead=cur;

            cur=next;
        }
        return nHead;
    }
    public static boolean chkPalindromeList(Node head){
        Node middle=getMiddle(head);
        Node rHead=reverseList(middle);
        Node c1=head;
        Node c2=rHead;

        while(c1!=null&&c2!=null){
            if(c1.val!=c2.val){
                return false;
            }
            c1=c1.next;
            c2=c2.next;
        }
        return true;
    }
    public static void main(String[] args){

        Node n6=new Node(1);
        Node n5=new Node(2,n6);
        Node n4=new Node(3,n5);
        Node n3=new Node(3,n4);
        Node n2=new Node(2,n3);
        Node n1=new Node(1,n2);
       System.out.println(chkPalindromeList(n1));
    }
}
