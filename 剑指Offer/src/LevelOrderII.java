import java.util.*;
//从上到下打印二叉树 II
public class LevelOrderII {
    //从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印
    // 每一层打印到一行。
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> list=new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            for(int i=queue.size();i>0;i--){    //层：将这一层的val加到temp中
                TreeNode cur=queue.poll();
                temp.add(cur.val);
                if(cur.left!=null)
                    queue.offer(cur.left);
                if(cur.right!=null)
                    queue.offer(cur.right);
            }
            list.add(temp); //加入整个层
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
