import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

//复制带有随机指针的链表
public class CopyRandomList {
    public static Node copyRandomList(Node head) {
        if(head==null)
            return null;
        Map<Node,Node> map=new HashMap<>();
        //定义新链表的头与尾节点
        Node newH,newT;
        newH=newT=null;
        Node cur=head;

        while(cur!=null){
            //先创建要复制的节点
            Node node=new Node(cur.val);
            if(newH==null)
                newH=newT=node;
            else{
                newT.next=node;
                //更新尾节点
                newT=newT.next;
            }
            //将节点加入到map中，形成一一映射的关系
            map.put(cur,node);
            cur=cur.next;
        }

        //从头开始复制随机指针的链表
        cur=head;
        newT=newH;
        while (cur!=null){
            if(cur.random!=null){
                newT.random=map.get(cur.random);
            }else{
                newT.random=null;
            }
            //更新
            cur=cur.next;
            newT=newT.next;
        }
        return newH;
    }


    /*
    public static Node copyRandomList(Node head) {
        if(head==null)
            return null;
        //拷贝节点
        Node cur=head;
        while (cur!=null){
            Node next=cur.next;
            Node node=new Node(cur.val);
            cur.next=node;
            node.next=next;
            cur=next;
        }

        //复制随机指针
        cur=head;
        Node node;
        while (cur!=null){
            node=cur.next;
            Node next=node.next;
            if(cur.random!=null){
                node.random=cur.random.next;
            }else
                node.random=null;
            cur=next;
        }

        //拆分链表
        cur=head;
        Node newHead=head.next;
        node=newHead;
        while (cur!=null){
            Node next=node.next;
            cur.next=next;
            if(next!=null) {
                node.next =next.next;
            }
            cur=next;
            node=node.next;
        }
        return newHead;
    }
    */
}
