//对称的二叉树
public class IsSymmetric {
    private static boolean _isSymmetric(TreeNode left,TreeNode right){
        if(left==null&&right==null)
            return true;
        if(left==null||right==null)
            return false;

        //判断当前的节点是否相等 判断左边的左边与右边的右边 判断左边的右边与右边的左边
        return left.val==right.val
                &&_isSymmetric(left.left,right.right)
                &&_isSymmetric(left.right,right.left);
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return _isSymmetric(root.left,root.right);
    }

    public static void main(String[] args) {
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(2);
        TreeNode n4=new TreeNode(3);
        TreeNode n5=new TreeNode(4);
        TreeNode n6=new TreeNode(4);
        TreeNode n7=new TreeNode(3);

        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.left=n6;
        n3.right=n7;
        System.out.println(isSymmetric(n1));
    }
}
