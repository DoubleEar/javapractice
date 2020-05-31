import java.util.LinkedHashMap;
import java.util.Map;
//复杂链表的复制
public class CopyRandomList {
    /*
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;

        //先将原来的链表next和val进行复制，将两个链表连成一个链表
        Node cur=head;
        while (cur!=null){
            Node node=new Node(cur.val);    //创建新节点

            node.next=cur.next;
            cur.next=node;

            cur=node.next;

        }

        //处理random指向问题
        cur=head;
        while (cur!=null){
            Node next=cur.next;
            if(cur.random!=null){   //原始链表上N的random指向S，因为N的next指向N'，
                                    // 同样S的next指向S'，那么复制出来的N'的random指向S'。
                next.random=cur.random.next;
            }
            cur=next.next;
        }

        //定义一个新的头结点，将两个链表分开
        cur=head;
        Node newNode=head.next;
        while (cur!=null){
            Node node=cur.next;

            cur.next=node.next;
            if(node.next!=null){
                node.next=node.next.next;
            }

            cur=cur.next;
        }

        return newNode;
    }
    */

    public static Node copyRandomList(Node head) {
        if(head==null)
            return null;
        Map<Node,Node> map=new LinkedHashMap<>();   //将<N,N'>的配对信息放入一个哈希表中

        Node newH,newT; //定义新链表的头与尾节点
        newH=newT=null;
        Node cur=head;

        while (cur!=null){
            //先创建要复制的节点
            Node node=new Node(cur.val);
            if(newH==null)
                newH=newT=node;
            else {
                newT.next = node;
                //更新尾节点
                newT=node;
            }

            //将节点加入到map中，形成一一映射的关系
            map.put(cur,node);
            cur=cur.next;
        }

         //从哈希表中找到对应关系
         cur=head;
         newT=newH;
         while (cur!=null){
             if(cur.random!=null) {
                 newT.random = map.get(cur.random);
             }else
                 newT.random=null;

             //更新
             cur=cur.next;
             newT=newT.next;
         }

        return newH;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        n1.random = n2;
        n2.random = n1;
        n3.random = n3;

        copyRandomList(n1);
    }
}
