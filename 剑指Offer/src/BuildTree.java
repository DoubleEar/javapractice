import java.util.HashMap;
import java.util.Map;

//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
public class BuildTree {
    /*
    static int curIndex=0;
    public TreeNode _buildTree(int[] preorder,int[]inorder,int inS,int inE){
        if(inS>inE)
            return null;
        int rootValue=curIndex;
        curIndex++;
        TreeNode root=new TreeNode(rootValue);
        if(inS==inE)
            return root;
        int i;
        //因为inS=inE的情况在前面已经判断过了，所以这里不需要再有等号了。
        for(i=inS;i<inE;i++){
            if(inorder[i]==rootValue)
                break;
        }

        root.left=_buildTree(preorder,inorder,inS,i-1);
        root.right=_buildTree(preorder,inorder,i+1,inE);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
            curIndex=0;
            return _buildTree(preorder,inorder,0,preorder.length-1);
    }
    */
    int[] po;
    //纪录中序遍历的value以及对应的下标。
    Map<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length==0)
            return null;
        po=preorder;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        //根的索引 树的左边界 树的右边界
        return _buildTree(0,0,inorder.length-1);
    }

    public TreeNode _buildTree(int preRoot,int inLeft,int inRight){
        if(inLeft>inRight)
            return null;
        //在前序数组中找到根对应的值创建节点。
        TreeNode root=new TreeNode(po[preRoot]);
        //找到根节点在中序数组中对应的索引，划分左右子树。
        int i=map.get(po[preRoot]);
        root.left=_buildTree(preRoot+1,inLeft,i-1);
        //右子树根节点的索引：根节点索引 + 左子树长度 + 1
        root.right=_buildTree(preRoot + (i - inLeft) + 1,i+1,inRight);
        return root;
    }
}
