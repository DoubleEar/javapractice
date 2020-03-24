import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//从尾到头打印链表
public class ReversePrint {

    static List<Integer> list=new ArrayList<>();
    public static int[] reversePrint(ListNode head) {
        /*
        if(head==null)
            return new int[]{};
        Stack<Integer> stack=new Stack<>();
        ListNode cur=head;
        int size=0;
        while (cur!=null){
            size++;
            stack.push(cur.val);
            cur=cur.next;
        }

        int[] res=new int[size];
        int index=0;
        while (!stack.isEmpty()){
            res[index++]=stack.pop();
        }
        return res;
        */

        recur(head);
        int[] res=new int[list.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private static void recur(ListNode head) {
        if(head==null)
            return;
        recur(head.next);
        list.add(head.val);
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);

        n1.next=n2;
        n2.next=n3;
        n3.next=null;

        System.out.println(Arrays.toString(reversePrint(n1)));
    }
}
