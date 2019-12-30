package 二叉树;

//判断一个树是否是另一个树的子树
public class IsSonTree {
    public boolean isSameTree(Node p,Node q){
        if(p==null&&q==null)
            return true;
        if(p==null||q==null)
            return false;
        return p.value==q.value
                &&isSameTree(q.left,p.left)
                &&isSameTree(q.right,p.right);
    }

    public boolean isSonTree(Node p,Node q){
        if(p==null)
            return false;
       if(isSameTree(p,q))
           return true;
       if(isSonTree(p.left,q))
           return true;
       return isSonTree(p.right,q);
    }
}
