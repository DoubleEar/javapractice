package 二叉树;

//判断一棵树是否为平衡二叉树
public class IsBalanced {
    public boolean isBanlancedTree(Node root){
        if(root==null)
            return true;
        int left=getHeight(root.left);
        int right=getHeight(root.right);
        return  Math.abs(left-right)<2
                &&isBanlancedTree(root.right)
                &&isBanlancedTree(root.left);
    }

    private int getHeight(Node root) {
        return root==null?0:Math.max(getHeight(root.right),getHeight(root.left))+1;
    }
}
