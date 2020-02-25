//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
//平衡二叉树：二叉树中任意节点的左右子树的深度相差不超过1。
public class IsBalanced {
    private static int getHeight(TreeNode root){
        return root==null?0:Math.max(getHeight(root.right),getHeight(root.left))+1;
    }
    public static boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        int left=getHeight(root.left);
        int right=getHeight(root.right);
        return Math.abs(left-right)<2
                &&isBalanced(root.left)
                &&isBalanced(root.right);
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
        System.out.println(isBalanced(root));
    }
}
