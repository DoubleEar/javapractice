package 二叉树;

//判断一棵树是不是完全二叉树
import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteTree {
    public boolean levelOrder(Node root){
        Queue<Node> queue=new LinkedList<>();
        if(root!=null){
            queue.offer(root);
        }
        //获取队头元素
        while(!queue.isEmpty()) {
            Node topNode = queue.poll();
         //遇到第一个null结点，停止层序遍历
            if (topNode == null)
                break;
         //不管是否为空，全部入队
            queue.offer(topNode.right);
            queue.offer(topNode.left);
        }
        //剩余元素全部出队，如果有非空结点，不是完全二叉树
        while(!queue.isEmpty()){
            Node topNode = queue.poll();
            if (topNode == null)
                return false;
        }
        return true;
    }
}
