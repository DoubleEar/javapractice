import java.util.LinkedList;
import java.util.Queue;

//判断一颗树是否为完全二叉树
public class IsCompleteTree {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        if(root!=null)
            queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode cur=queue.poll();
            //遇到第一个null结点，停止层序遍历
            if(cur==null)
                break;
            //不管是否为空，全部入队
            queue.offer(cur.left);
            queue.offer(cur.right);
        }

        //剩余元素全部出队，如果有非空结点，不是完全二叉树
        while (!queue.isEmpty()){
            TreeNode topNode=queue.poll();
            if(topNode!=null)
                return false;
        }
        return true;
    }
}
