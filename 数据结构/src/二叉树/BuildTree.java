package 二叉树;

//根据一棵树的前序遍历与中序遍历构造二叉树。
public class BuildTree {
    static int curIdx=0;
    public Node _buildTree(int[] pre,int[] in,int inS,int inE){
        if(inS>inE)
            return null;
        int rootValue=pre[curIdx];
        curIdx++;
        Node root =new Node(rootValue);
        //区间中除过根结点，没有孩子结点
        if(inS==inE)
            return root;
        //确定左右子树的区间
        int i;
        for(i=inS;i<inE;i++){
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
    public Node buildTree(int[] preorder, int[] inorder) {
        //重置
        curIdx=0;
        return _buildTree(preorder,inorder,0,preorder.length-1);
    }
}
