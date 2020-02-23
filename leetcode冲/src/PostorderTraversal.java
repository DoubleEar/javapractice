import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {
    public static void postOrder(TreeNode root,List<Integer> list){
        if(root!=null){
            postOrder(root.left,list);
            postOrder(root.right,list);
            list.add(root.val);
        }
    }
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        postOrder(root,list);
        return list;
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode n1=new TreeNode(2);
        TreeNode n2=new TreeNode(3);
        TreeNode n3=new TreeNode(4);
        TreeNode n4=new TreeNode(5);
        TreeNode n5=new TreeNode(6);
        TreeNode n6=new TreeNode(7);
        TreeNode n7=new TreeNode(8);
        root.left=n1;
        root.right=n2;
        n1.left=n3;
        n1.right=n4;
        n2.left=n5;
        n2.right=n6;
        n4.right=n7;
        System.out.println(postorderTraversal(root));
    }
}
