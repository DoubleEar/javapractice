import java.util.HashMap;

//从中序与后序遍历序列构造二叉树
public class PostInBuildTree {
    //定义一个哈希表，存放中序遍历元素和索引的位置关系
    //从后序序列中拿到根节点后，要在中序序列中查找对应的位置,从而将数组分为左子树和右子树
     HashMap<Integer,Integer> memo = new HashMap<>();
     int[] post;
    public TreeNode _buildTree(int inS, int inE, int postS, int postE) {
        if(inE < inS || postE < postS)
            return null;

        int root = post[postE];
        //rootIn 根节点在中序遍历数组中的索引位置
        int rootIn = memo.get(root);

        TreeNode node = new TreeNode(root);
        //postE计算过程解释:后序数组的起始位置加上左子树长度-1 就是后序数组结束位置了
        // 左子树的长度 = 根节点索引(rootIn)-左子树(inS)
        node.left = _buildTree(inS, rootIn - 1, postS, postS + (rootIn - inS) - 1);
        node.right = _buildTree(rootIn + 1, inE, postS + (rootIn - inS), postE - 1);
        return node;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0;i < inorder.length; i++) {
            memo.put(inorder[i], i);
        }
        post = postorder;
        TreeNode root = _buildTree(0, inorder.length - 1, 0, post.length - 1);
        return root;
    }
}
