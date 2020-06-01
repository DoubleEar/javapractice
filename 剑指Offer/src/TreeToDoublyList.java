//二叉搜索树与双向链表
public class TreeToDoublyList {
    static TreeNode pLast=null;  //指向双向链表的尾结点
    public static TreeNode treeToDoublyList(TreeNode root) {
        if(root==null)
            return null;
        pLast=null; //静态变量重置

        inOrder(root);  //中序遍历

        TreeNode pHead=pLast;

        while (pHead!=null&&pHead.left!=null){  //从尾结点遍历到第一个节点
            pHead=pHead.left;
        }

        pLast.right=pHead;  //成为双向循环链表
        pHead.left=pLast;

        return pHead;
    }

    private static void inOrder(TreeNode root){
        if(root==null)
            return;
        TreeNode curNode=root;

        if(curNode.left!=null)  //处理左子树为双向循环链表
            inOrder(curNode.left);

        curNode.left=pLast;    //改变当前节点前驱的指向
        if(pLast!=null)
            pLast.right=curNode;    //改变当前节点后继的指向

        pLast=curNode;  //更新最后一个节点（处理当前节点）

        if(curNode.right!=null)     //处理右子树为双向循环链表
            inOrder(curNode.right);
    }

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(10);
        TreeNode t2=new TreeNode(6);
        TreeNode t3=new TreeNode(14);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(8);
        TreeNode t6=new TreeNode(12);
        TreeNode t7=new TreeNode(16);

        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t3.left=t6;
        t3.right=t7;

        System.out.println(treeToDoublyList(t1));
    }
}
