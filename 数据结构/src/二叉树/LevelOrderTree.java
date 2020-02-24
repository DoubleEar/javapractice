package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//二叉树的分层遍历
public class LevelOrderTree {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);
        //外层循环，遍历层
        while (!queue.isEmpty()) {
            //取出队列所有元素
            int size = queue.size();
            List<Integer> rowNode = new ArrayList<>();
            //内层循环，遍历每一层的结点
            while (size > 0) {
                Node topNode = queue.poll();
                //放在同一行
                rowNode.add(topNode.value);
                //将左右孩子带入
                if (topNode.left != null)
                    queue.offer(topNode.left);
                if (topNode.right != null)
                    queue.offer(topNode.right);
                size--;
            }
            //将一行加入到list中
            list.add(rowNode);
        }
        return list;
    }
}
