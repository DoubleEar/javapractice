package 二叉树;

//判断两个二叉树是否相等
public class IsSame {
    public boolean isSameTree(Node p,Node q){
        if(p==null&&q==null)
            return true;
        if(p==null||q==null)
            return false;
        return p.value==q.value
                &&isSameTree(q.left,p.left)
                &&isSameTree(q.right,p.right);
    }
}
