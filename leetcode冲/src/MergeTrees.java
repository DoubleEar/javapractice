//如果两个节点重叠，那么将他们的值相加作为节点合并后的新值
// 否则不为 NULL 的节点将直接作为新二叉树的节点。
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null)
            return t2;
        if(t2==null)
            return t1;

        t1.val+=t2.val;
        t1.left=mergeTrees(t1.left,t2.left);
        t2.right=mergeTrees(t1.right,t2.right);
        return t1;
    }
}
