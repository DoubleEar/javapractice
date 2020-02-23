package 二叉树;

//返回树的最大深度
public class MaxDepth {
    public int maxDepth(Node root){
        //return root==null?0:Math.max(maxDepth(root.right),maxDepth(root.left))+1;
        if(root==null)
            return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return left>=right?1+left:1+right;
    }
}
