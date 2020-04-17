//二叉树的镜像
public class MirrorBinaryTree {
    public static TreeNode Mirror(TreeNode root) {
        //虽然每一层的左右节点被交换，但是左右节点自己的左右节点没有变。
        //再从左右节点为根开始继续交换即可
        if(root==null)
            return null;
        TreeNode cur=root.left;
        root.left=root.right;
        root.right=cur;
        if(root.left!=null){
            Mirror(root.left);
        }
        if(root.right!=null){
            Mirror(root.right);
        }

        return root;
    }
    private static void printTreeNode(TreeNode root){
        if(root==null)
            return;
        else{
            //左子树
            printTreeNode(root.left);
            //根
            System.out.print(root.val+" ");
            //右子树
            printTreeNode(root.right);
        }
    }
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(8);
        TreeNode t2=new TreeNode(6);
        TreeNode t3=new TreeNode(10);
        TreeNode t4=new TreeNode(5);
        TreeNode t5=new TreeNode(7);
        TreeNode t6=new TreeNode(9);
        TreeNode t7=new TreeNode(11);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t3.left=t6;
        t3.right=t7;

        printTreeNode(Mirror(t1));
    }
}
