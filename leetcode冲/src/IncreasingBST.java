import java.util.ArrayList;
import java.util.List;

//按中序遍历重新排列树，使树中最左边的结点现在是树的根
// 并且每个结点没有左子结点，只有一个右子结点。
public class IncreasingBST {
    List<Integer> list=new ArrayList<>();
    public void inOrder(TreeNode root){
        if(root==null)
            return ;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
    public TreeNode increasingBST(TreeNode root) {
        //1.中序遍历该二叉树，并将该二叉树存到列表中
        inOrder(root);
        //2.构建新的二叉树
        if(list==null||list.size()==0)
            return null;
        TreeNode cur=new TreeNode(list.get(0));
        TreeNode res=cur;
        for(int i=1;i<list.size();i++){
            cur.right=new TreeNode(list.get(i));
            cur=cur.right;
        }
        return res;
    }
}
