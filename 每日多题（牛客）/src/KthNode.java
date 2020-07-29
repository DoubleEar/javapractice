import java.util.Stack;
//给定一棵二叉搜索树，请找出其中的第k小的结点。
public class KthNode {
    TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot==null||k<0)
            return null;
        int count=0;
        TreeNode cur=pRoot;
        Stack<TreeNode> stack=new Stack<>();
        //采用中序遍历
        while (!stack.isEmpty()||cur!=null){
            while (cur!=null){  //遍历左子树
                stack.push(cur);
                cur=cur.left;
            }

            cur=stack.pop();    //遍历当前节点（根）
            count++;
            if(count==k)
                return cur;

            cur=cur.right;      //遍历右子树
        }
        return null;
    }
}
