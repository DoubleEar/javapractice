package 二叉树;

//判断一棵树是不是完全二叉树
import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteTree {
    public boolean levelOrder(Node root){
        Queue<Node> queue=new LinkedList<>();
        if(root!=null){
            queue.offer(root);
        }
        //获取队头元素
        while(!queue.isEmpty()) {
            Node topNode = queue.poll();
         //遇到第一个null结点，停止层序遍历
            if (topNode == null)
                break;
         //不管是否为空，全部入队
            queue.offer(topNode.right);
            queue.offer(topNode.left);
        }
        //剩余元素全部出队，如果有非空结点，不是完全二叉树
        while(!queue.isEmpty()){
            Node topNode = queue.poll();
            if (topNode != null)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Node root=new Node(1);
        Node n1=new Node(2);
        Node n2=new Node(3);
        Node n3=new Node(4);
        Node n4=new Node(5);
        Node n5=new Node(6);
        Node n6=new Node(7);
        Node n7=new Node(8);
        root.left=n1;
        root.right=n2;
        n1.left=n3;
        n1.right=n4;
        n2.left=n5;
        n2.right=n6;
        n4.right=n7;
        IsCompleteTree l=new IsCompleteTree();
        System.out.println(l.levelOrder(root));
    }

}
