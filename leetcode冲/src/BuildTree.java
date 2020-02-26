//根据一棵树的前序遍历与中序遍历构造二叉树。
public class BuildTree {
    static int curIndex=0;
    public TreeNode _buildTree(int[] pre,int[] in,int inS,int inE){
        if(inS>inE)
            return null;
        int rootValue=pre[curIndex++];
        TreeNode root=new TreeNode(rootValue);
        //区间中除过根结点，没有孩子结点
        if(inS==inE)
            return root;
        int i;
        //确定左右子树的区间
        //在中序遍历中确定根在区间中的位置
        for(i=inS;i<=inE;i++){
            if(in[i]==rootValue)
                break;
        }
        //左右子树的区间
        //左子树：[inS,i-1]
        //右子树：[i+1,inE]
        //构建左右子树
        root.left=_buildTree(pre,in,inS,i-1);
        root.right=_buildTree(pre,in,i+1,inE);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        curIndex=0;
        return _buildTree(preorder,inorder,0,preorder.length-1);
    }
}
