//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
public class TreeToDoublyList {
    static TreeNode prev=null;
    //对于二叉搜索树，用中序遍历值是递增的
    public TreeNode InOrder(TreeNode root){
        if(root==null)
            return null;
        InOrder(root.left);
        //处理当前节点，将当前根的左边指向prev
        root.left=prev;
        //如果prev不为空，将prev的右边指向当前根
        if(prev!=null){
            prev.right=root;
        }
        //prev后移
        prev=root;
        InOrder(root.right);

        //从根的位置开始遍历，一直到最左边便是链表的头
        while(root.left!=null){
            root=root.left;
        }
        //返回链表的头
        return root;
    }
    public TreeNode treeToDoublyList(TreeNode root) {
        if(root==null)
            return null;
        prev=null;
        TreeNode newHead= InOrder(root);
        //用临时结点temp遍历到链表的尾部
        TreeNode temp=newHead;
        while(temp.right!=null){
            temp=temp.right;
        }
        //链表的尾部指向链表的头
        temp.right=newHead;
        //链表的头指向链表的尾，形成环形链表
        newHead.left=temp;
        return newHead;
    }
}
