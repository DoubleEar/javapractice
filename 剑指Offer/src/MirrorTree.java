public class MirrorTree {
    //二叉树的镜像
    public static void preOrder(TreeNode root){
        if(root==null)
            return;
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static TreeNode mirrorTree(TreeNode root) {
        if(root==null)
            return null;
        if(root.left==null&&root.right==null)
            return root;

        TreeNode cur=root.left;
        root.left=root.right;
        root.right=cur;

        if(root.left!=null) {
            mirrorTree(root.left);
        }
        if(root.right!=null) {
            mirrorTree(root.right);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;

        preOrder(mirrorTree(n1));
    }
}
