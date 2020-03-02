import java.util.LinkedList;
import java.util.Queue;

//求二叉树最大宽度。树的宽度是所有层中的最大宽度。
//每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
public class WidthOfBinaryTree {
    public static int widthOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        //用来存放每一层的节点个数
       Queue<TreeNode> queue=new LinkedList<>();
       //用来存放对应节点的下标
       LinkedList<Integer> list=new LinkedList<>();
       queue.offer(root);
       //假定根节点的下标为0。
        //0
        //0 1
        //0 1 2
       list.add(0);
       //保存没一层节点的个数。并用于返回
       int res=1;
       while (!queue.isEmpty()){
           int count=queue.size();
           for(int i=count-1;i>=0;i--){
               TreeNode cur=queue.poll();
               int curIndex=list.removeFirst();
               //将二叉树的下标存储到list中，根节点下标为 0，
               // 左子树结点为 2 * i，右子树下标为 2 * i+1
               if(cur.left!=null) {
                   queue.offer(cur.left);
                   list.add(curIndex * 2);
               }
               if(cur.right!=null) {
                   queue.offer(cur.right);
                   list.add(curIndex*2+1);
               }
           }
           //更新res的值（size等于1，树的宽度也为1，没必要更新）
           if(list.size()>1)
              res= Math.max(res,list.getLast()-list.getFirst()+1);
       }
    return res;
    }

    public static void main(String[] args) {
        TreeNode n1=new TreeNode(20);
        TreeNode n2=new TreeNode(15);
        TreeNode n3=new TreeNode(27);
        TreeNode n4=new TreeNode(29);
        TreeNode n5=new TreeNode(38);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n3.right=n5;

        System.out.println(widthOfBinaryTree(n1));
    }
}
