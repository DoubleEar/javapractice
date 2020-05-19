import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//从上到下打印二叉树 III
public class LevelOrderIII {
    /*
        即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印,
        第三行再按照从左到右的顺序打印，其他行以此类推。
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>(); //存放某一层的节点
        Stack<TreeNode> s2 = new Stack<>(); //存放某一层下一层的节点
        List<List<Integer>> list = new ArrayList<>();
        int n = 1;

        s1.push(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            //偶数层 从右向左打印 所以它的下一层从左向右打印 根据栈的先进后出的规律
            //存放子节点时应该先右孩子后左孩子
            if (n % 2 == 0) {
                for (int i = s2.size(); i > 0; i--) {
                    TreeNode cur = s2.pop();
                    temp.add(cur.val);
                    if (cur.right != null)
                        s1.push(cur.right);
                    if (cur.left != null)
                        s1.push(cur.left);
                }
                list.add(temp);
            } else {
                //奇数层 从左向左右打印 所以它的下一层从右向左打印 根据栈的先进后出的规律
                //存放子节点时应该先左孩子后右孩子
                for (int i = s1.size(); i > 0; i--) {
                    TreeNode cur = s1.pop();
                    temp.add(cur.val);
                    if (cur.left != null)
                        s2.push(cur.left);
                    if (cur.right != null)
                        s2.push(cur.right);
                }
                list.add(temp);
            }
            //更新层数
            n++;
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode n1=new TreeNode(3);
        TreeNode n2=new TreeNode(9);
        TreeNode n3=new TreeNode(20);
        TreeNode n4=new TreeNode(15);
        TreeNode n5=new TreeNode(7);

        n1.left=n2;
        n1.right=n3;
        n3.left=n4;
        n3.right=n5;

        System.out.println(levelOrder(n1));
    }
}
