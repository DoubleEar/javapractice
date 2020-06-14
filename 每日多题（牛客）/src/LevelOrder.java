import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//N叉树的层序遍历
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class LevelOrder {
    //给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();    //获取当前层的元素个数
            List<Integer> list = new ArrayList<>(); //存放每一层的元素

            while (size-- != 0) {
                Node cur = queue.poll();
                list.add(cur.val);

                if (cur.children != null) {     //将每个元素的孩子带入队列中
                    for (Node child : cur.children) {
                        if (child != null)
                            queue.offer(child);
                    }
                }
            }

            //新层有元素则加入lists
            if (!list.isEmpty())
                lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        Node n1=new Node(1);
        Node n2=new Node(3);
        Node n3=new Node(2);
        Node n4=new Node(4);
        Node n5=new Node(4);
        Node n6=new Node(6);

        List<Node> children1=new ArrayList<>();
        children1.add(n2);
        children1.add(n3);
        children1.add(n4);

        List<Node> children2=new ArrayList<>();
        children2.add(n5);
        children2.add(n6);

        n1.children=children1;
        n2.children=children2;

        levelOrder(n1);

    }
}
