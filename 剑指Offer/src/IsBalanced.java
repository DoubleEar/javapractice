//平衡二叉树
//如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树
public class IsBalanced {
    private int getHeight(TreeNode root){
        if(root==null)
            return 0;
        int left=getHeight(root.left);
        int right=getHeight(root.right);

        return left>right?left+1:right+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;

        int left=getHeight(root.left);
        int right=getHeight(root.right);

        //判断当前的根是否满足平衡二叉树，在递归左孩子右孩子。
        return Math.abs(left-right)<2
                &&isBalanced(root.left)
                &&isBalanced(root.right);
    }
}
