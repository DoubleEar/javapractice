//复制带有随机结点的链表
public class CopyRandomList {
    public static NewNode copyRandomList(NewNode head){
        if(head==null){
            return null;
        }
        //先将原来的链表next和val进行复制，将两个链表连成一个链表
        NewNode cur=head;
        while(cur!=null){
            NewNode node=new NewNode();
            node.val=cur.val;

            node.next=cur.next;
            cur.next=node;

            cur=node.next;
        }
        //处理random指向问题
        cur=head;
        while(cur!=null){
            if(cur.random!=null){
                cur.next.random=cur.random.next;
            }
            cur=cur.next.next;
        }
        //定义一个新的头结点，将两个链表分开
        cur=head;
        NewNode nHead=head.next;
        while (cur != null) {
            NewNode node = cur.next;

            cur.next = node.next;
            if (node.next != null) {
                node.next = node.next.next;
            }

            cur = cur.next;
        }

        return nHead;
    }
    public static void main(String[] args){
        NewNode n1 = new NewNode(1);
        NewNode n2 = new NewNode(2);
        NewNode n3 = new NewNode(3);
        NewNode n4 = new NewNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        n1.random = n2;
        n2.random = n1;
        n3.random = n3;

        NewNode nHead = copyRandomList(n1);
    }
}

