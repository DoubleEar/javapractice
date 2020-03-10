//一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
//两结点之间的路径长度是以它们之间边的数目表示
public class DiameterOfBinaryTree {
    //res 取值为以经过某一根，左右子树的最大深度之和 leftDepth + rigthDepth
    static int res=0;
    public static int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return res;
    }
    public static int depth(TreeNode node){
        if(node==null)
            return 0;
        int left=depth(node.left);
        int right=depth(node.right);
        res=Math.max(res,left+right);
        //node为根节点的最大深度为 Math.max(leftDepth,rigthDepth) + 1
        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(5);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n3.right=n5;

        System.out.println(diameterOfBinaryTree(n1));
    }
}
