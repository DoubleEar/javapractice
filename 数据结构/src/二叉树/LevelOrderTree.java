package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//分层遍历
public class LevelOrderTree {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);
        while (!queue.isEmpty()) {
            //取出队列所有元素
            int size = queue.size();
            List<Integer> rowNode = new ArrayList<>();
            while (size > 0) {
                Node topNode = queue.poll();
                //放在同一行
                rowNode.add(topNode.value);
                if (topNode.left != null)
                    queue.offer(topNode.left);
                if (topNode.right != null)
                    queue.offer(topNode.right);
                size--;
            }
            list.add(rowNode);
        }
        return list;
    }
}
