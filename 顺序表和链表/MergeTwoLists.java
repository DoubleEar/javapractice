//按大小拼接两个链表
public class MergeTwoLists {
    public static void printLinkedList(Node head) {
        Node cur = head;

        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    private static Node mergeTwoLists(Node list1,Node list2){
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        //定义了两个引用遍历链表
        Node cur1=list1;
        Node cur2=list2;
        //新链表的头节点和尾节点，空链表所以都是null
        Node nHead=null;
        Node nLast=null;

        while(cur1!=null&&cur2!=null){
            if(cur1.val<=cur2.val){
                //把cur1尾插到新链表
                if(nHead==null){  //如果新链表为空（只有第一次才是空的）
                    nHead=cur1;
                }else{
                    nLast.next=cur1;
                }
                //更新新链表的尾节点是新插入的节点
                nLast=cur1;
                //让cur1后移一步
                cur1=cur1.next;
            }else{
                    if(nHead==null){
                        nHead=cur2;
                    }else{
                        nLast.next=cur2;
                    }
                nLast=cur2;
                cur2=cur2.next;
            }
        }

        //有一个链表为空
       if(cur1!=null){
            nLast.next=cur1;
       }else{
            nLast.next=cur2;
       }
       return nHead;
    }

    public static void main(String[] args){
        Node n5=new Node(5);
        Node n4=new Node(4,n5);
        Node n3=new Node(3,n4);
        Node n2=new Node(2,n3);
        Node n1=new Node(1,n2);
        //1 2 3 4 5

        Node m3=new Node(13);
        Node m2=new Node(7,m3);
        Node m1=new Node(0,m2);
        //0 7 13

        Node head=mergeTwoLists(n1,m1);
        printLinkedList(head);
    }
}
