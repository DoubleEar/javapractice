import java.util.Stack;

//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
public class LowestCommonAncestor {
    /*
    //判断p，q在不在同一边
    public static boolean find(TreeNode root,TreeNode node){
        //前序遍历，判断结点在树的左边还是右边还是树的根本身
        if(root==null)
            return false;
        if(root==node)
            return true;
        if(find(root.left,node))
            return true;
        return find(root.right,node);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean pL=false,pR=false,qL=false,qR=false;
        //某一个结点等于当前树的根，直接返回。
        if(root==p||root==q){
            return root;
        }
        //判断p是否在树的左边
        if(find(root.left,p)){
            pL=true;
        }else {
            pR=true;
        }
        //判断q是否在树的左边
        if(find(root.left,q)){
            qL=true;
        }else {
            qR=true;
        }
        //如果p，q在树的同一边，则继续查找
        if(pL&&qL){
            return lowestCommonAncestor(root.left,p,q);
        }else if(pR&&qR){
            return lowestCommonAncestor(root.right,p,q);
        //如果p，q在树的两边，只有根是他们的最近公共祖先
        }else {
            return root;
        }
    }
    */

    //保存根结点到p，q的路径
    public static boolean getPath(TreeNode root, TreeNode node, Stack<TreeNode> s){
        if(root==null)
            return false;
        //先把当前根入栈
        s.push(root);
        if(root==node)
            return true;
        //node在当前根的左边
        if(getPath(root.left,node,s))
            return true;
        //node在当前根的右边
        if(getPath(root.right,node,s))
            return true;
        //以上三种情况都不满足，说明该结点不应在路径中，出栈
        s.pop();
        return false;
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> path1=new Stack<>();
        Stack<TreeNode> path2=new Stack<>();
        getPath(root,p,path1);
        getPath(root,q,path2);
        //裁剪路径，使得p，q路径一样长
        while (path1.size()!=path2.size()){
            if(path1.size()>path2.size()){
                path1.pop();
            }else {
                path2.pop();
            }
        }
        while(path1.size()!=0){
            //比较两个栈顶元素是否相等
            if(path1.peek()==path2.peek()){
                break;
            }else{
                //不相等则出栈
                path1.pop();
                path2.pop();
            }
        }
        return path1.peek();
    }
}
