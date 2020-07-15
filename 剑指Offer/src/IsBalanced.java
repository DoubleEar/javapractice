//平衡二叉树
//如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树
public class IsBalanced {
    /*
    //方法一：前序遍历+判断深度
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
    */

    //方法二：后序遍历（不用重复遍历）
    private boolean flag=true;
    public boolean isBalanced(TreeNode root) {
        recur(root);
        return flag;
    }
    //对二叉树做后序遍历，从底至顶返回子树深度，若判定某子树不是平衡树则 “剪枝” ，直接向上返回。
    private int recur(TreeNode root) {
        if(root==null||!flag)
            return 0;

       int left=recur(root.left);
       int right=recur(root.right);

       if(Math.abs(left-right)>1)
           flag=false;

        return 1+Math.max(left,right);
    }
}
