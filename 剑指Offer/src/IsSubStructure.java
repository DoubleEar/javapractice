//树的子结构
public class IsSubStructure {
    //判断两颗子树是否相等
    public static Boolean isPartSame(TreeNode A,TreeNode B){
        //B==null相当于B树遍历结束，返回true。
       if(B==null)
            return true;
       //全部遍历完，没有找到与B的相等的节点。
       if(A==null)
           return false;
       if(A.val==B.val)
           return isPartSame(A.left,B.left)&&isPartSame(A.right,B.right);
       else
           return false;

    }
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null||B==null)
            return false;
        //如果当前节点不等于B，就遍历当前节点的左孩子、右孩子。
        if(!isPartSame(A,B))
            return isSubStructure(A.left,B) || isSubStructure(A.right,B);
        return true;
    }

    public static void main(String[] args) {
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;

        TreeNode n5=new TreeNode(3);

        System.out.println(isSubStructure(n1, n5));
    }
}
