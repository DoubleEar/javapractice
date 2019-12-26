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
            System.out.println(topNode.value);
            //入队孩子结点
            if (topNode.right != null) {
                queue.offer(topNode.right);
            }
            if (topNode.left != null) {
                queue.offer(topNode.left);
            }
        }
    }
}
