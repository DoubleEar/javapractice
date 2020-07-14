//二叉树的深度
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);

        return left>right?left+1:right+1;   //左or右子树的高度加当前根的高度
    }
}
