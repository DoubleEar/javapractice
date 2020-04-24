//判断一棵树是否为平衡二叉树
public class Balance {
    //求出每个根左子树或右子树的高度
    private static int getLen(TreeNode node){
        return node==null?0:
                Math.max(getLen(node.left),getLen(node.right))+1;
    }

    public static boolean isBalance(TreeNode root) {
        if(root==null)
            return true;
        int left=getLen(root.left);
        int right=getLen(root.right);

        return Math.abs(left-right)<2
                &&isBalance(root.left)
                &&isBalance(root.right);
    }

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);

        t1.left=t2;
        t1.right=t3;

        System.out.println(isBalance(t1));

    }
}
