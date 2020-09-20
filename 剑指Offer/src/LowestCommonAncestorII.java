//二叉搜索树的最近公共祖先
public class LowestCommonAncestorII {
    private TreeNode preOrder(TreeNode root,TreeNode p,TreeNode q){
        if(root.val==p.val)     //根
            return p;
        else if(root.val==q.val)
            return q;

        if(root.val>p.val&&root.val>q.val)          //左
            return preOrder(root.left,p,q);
        else if(root.val<p.val&&root.val<q.val){    //右
            return preOrder(root.right,p,q);
        }else
            return root;    //两个子树位于根的两边
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||p==root||q==root)
            return root;
        return preOrder(root,p,q);  //前序遍历
    }
}
