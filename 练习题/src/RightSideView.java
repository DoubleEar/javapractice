import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
public class RightSideView {
    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> ret = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    ret.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right !=null) {
                    queue.add(node.right);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode n1=new TreeNode(2);
        TreeNode n2=new TreeNode(3);
        TreeNode n3=new TreeNode(4);
        TreeNode n4=new TreeNode(5);
        TreeNode n5=new TreeNode(6);
        TreeNode n6=new TreeNode(7);
        TreeNode n7=new TreeNode(8);
        root.left=n1;
        root.right=n2;
        n1.left=n3;
        n1.right=n4;
        n2.left=n5;
        n2.right=n6;
        n4.right=n7;

        System.out.println(rightSideView(root));
    }
}
