package 二叉树;


import java.util.Queue;
import java.util.LinkedList;

//层序遍历
public class LevelOrder {
    public void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        //获取队头元素
        while (!queue.isEmpty()) {
            Node topNode = queue.poll();
            System.out.printf("%d\t",topNode.value);
            //入队孩子结点
            if (topNode.left != null) {
                queue.offer(topNode.left);
            }
            if (topNode.right != null) {
                queue.offer(topNode.right);
            }
        }
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
        LevelOrder l=new LevelOrder();
        l.levelOrder(root);
    }
}
