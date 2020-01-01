package 二叉树;

//二叉搜索树转换成一个排序的双向链表
//要求不能创建任何新的结点，只能调整树中结点指针的指向
public class ConvertLinkedList {
    static Node prev=null;
    public void _Convert(Node root){
        if(root==null)
            return;
        //中序遍历，只能中序遍历（顺序）
        _Convert(root.left);
        //处理当前结点
        root.left=prev;
        if(prev!=null)
            prev.right=root;
        prev=root;
        _Convert(root.right);
    }
    public Node Convert(Node pRootOfTree) {
        if(pRootOfTree==null)
            return null;
        //重置
        prev=null;
        //返回头，左边第一个
        _Convert( pRootOfTree);
        while( pRootOfTree.left!=null){
            pRootOfTree= pRootOfTree.left;
        }
        return  pRootOfTree;
    }
}
