package 二叉树;

//判断两个二叉树是否相等
public class IsSame {
    public boolean isSameTree(Node p,Node q){
        //同时为空
        if(p==null&&q==null)
            return true;
        //不同时为空
        if(p==null||q==null)
            return false;
        //根的值相同，根的左子树相同，根的右子树相同
        return p.value==q.value
                &&isSameTree(q.left,p.left)
                &&isSameTree(q.right,p.right);
    }
}
