//求一个环形链表的结点的值
public class RoundList {
    public static Node roundList(Node head){
        if(head==null){
            return null;
        }
        Node fast=head;
        Node slow=head;
        //刚开始时fast与slow就相等，所以必须先循环一次
        do{
            fast=fast.next;
            if(fast==null){
                return null;
            }
            fast=fast.next;
            if(fast==null){
                return null;
            }
            slow=slow.next;
        }while(fast!=slow);

        Node c1=head;
        Node c2=slow;
        while(c1!=c2){
            c1=c1.next;
            c2=c2.next;
        }
        return c1;
    }
    public static void main(String[] args){
        Node n6=new Node(4);
        Node n5=new Node(2,n6);
        Node n4=new Node(3,n5);
        Node n3=new Node(3,n4);
        Node n2=new Node(2,n3);
        Node n1=new Node(1,n2);
        n6.next=n2;

        System.out.println(roundList(n1));
    }
}
