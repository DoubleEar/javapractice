import java.util.Stack;

//把二叉搜索树转换为累加树
//注意二叉搜索树的性质，结合性质做。（右根左）
public class ConvertBST {
    static int sum=0;
    public static TreeNode convertBST(TreeNode root) {
        /*
        if(root!=null){
            convertBST(root.right);
            sum+=root.val;
            root.val=sum;
            convertBST(root.left);
        }
        return root;
        */
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while (!stack.isEmpty()||cur!=null){
            while (cur!=null){
                stack.push(cur);
                cur=cur.right;
            }
            cur=stack.pop();
            sum+=cur.val;
            cur.val=sum;

            cur=cur.left;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode n1=new TreeNode(20);
        TreeNode n2=new TreeNode(15);
        TreeNode n3=new TreeNode(27);
        n1.left=n2;
        n1.right=n3;

        TreeNode result=convertBST(n1);
        System.out.println(PreorderTraversal.preorderTraversal(result));
    }
}
