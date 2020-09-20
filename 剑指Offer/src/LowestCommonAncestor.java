import java.util.Stack;

//二叉树的最近公共祖先
public class LowestCommonAncestor {
    /*
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||p==root||q==root)
            return root;

        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);

        if(left==null&&right==null)
            return null;
        if(left==null)
            return right;
        if(right==null)
            return left;
        return root;    //if(root!=null&&right!=null)
    }
    */

    //方法二：保存路径法。
    private boolean getPath(TreeNode root,TreeNode node,Stack<TreeNode> path){
        if(root==null)
            return false;
        path.push(root);
        if(root==node)
            return true;
        if(getPath(root.left,node,path))
            return true;
        if(getPath(root.right,node,path))
            return true;

        path.pop(); //走到这意味着node没有在root的这颗子树中，就删掉。
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> path1=new Stack<>();
        Stack<TreeNode> path2=new Stack<>();
        getPath(root,p,path1);
        getPath(root,q,path2);

        while (path1.size()!=path2.size()){
            if(path1.size()>path2.size())
                path1.pop();
            else
                path2.pop();
        }

        //此时path1.size()==path2.size()
        while (path1.size()!=0){
            if(path1.peek()==path2.peek())
                return path1.peek();
            else{
                path1.pop();
                path2.pop();
            }
        }
        return path1.peek();
    }
}
