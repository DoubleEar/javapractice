//判断一棵树是否为另一颗树的子树
public class IsSubtree {
    public boolean isSameTree(TreeNode p,TreeNode q){
        if(p==null&&q==null)
            return true;
        if(p==null||q==null)
            return false;
        return q.val==p.val&&isSameTree(q.left,p.left)&&isSameTree(p.right,q.right);
    }
    public boolean isSubTree(TreeNode s, TreeNode t) {
        if(s==null)
            return false;
        //判断当前两颗树是否相等
        if(isSameTree(s,t))
            return true;
        //判断s的左子树是否包含以t为根的树
        if(isSubTree(s.left,t))
            return true;
        //判断s的右子树是否包含以t为根的树
        return isSubTree(s.right,t);
    }
}
