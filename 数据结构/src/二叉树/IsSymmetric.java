package 二叉树;

//给定一个二叉树，检查它是否是镜像对称的
public class IsSymmetric {
    public boolean _isSymmetric(Node left,Node right) {
        //判断到叶子节点
        if(left==null&&right==null)
            return true;
        if(left==null||right==null)
            return false;
        //首先判断根的值是否相同
        //再判断左子树的左边与右子树的右边是否相同
        //再判断左子树的右边与右子树的左边是否相同
        return left.value==right.value
                &&_isSymmetric(left.left,right.right)
                &&_isSymmetric(left.right,right.left);
    }
    public boolean isSymmetric(Node root) {
        if (root == null)
            return true;
        return _isSymmetric(root.left, root.right);
    }
}
