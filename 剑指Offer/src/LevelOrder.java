import java.util.*;
//从上到下打印二叉树
public class LevelOrder {
    public static int[] levelOrder(TreeNode root) {
        if(root==null)
            return new int[0];

        Queue<TreeNode> queue=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode cur=queue.poll();

            list.add(cur.val);

            if(cur.left!=null) {
                queue.offer(cur.left);
            }
            if(cur.right!=null) {
                queue.offer(cur.right);
            }
        }

        int[] res=new int[list.size()];
        for(int i=0;i<res.length;i++){
            res[i]=list.get(i);
        }
        return res;
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

        System.out.println(Arrays.toString(levelOrder(n1)));
    }
}
