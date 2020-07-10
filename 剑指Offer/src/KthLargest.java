import java.util.ArrayList;
import java.util.List;
//二叉搜索树的第k大节点
public class KthLargest {
    /*
    public int kthLargest(TreeNode root, int k) {
        List<Integer> list=new ArrayList<>();
        inOrder(root,list);
        return list.get(list.size()-k);
    }

    private List<Integer> inOrder(TreeNode root,List<Integer> list){
        if(root==null)
            return null;

        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);

        return list;
    }
    */

    int res=0,count=0;
    public int kthLargest(TreeNode root, int k) {
        this.count=k;   //k不能随着迭代的变化而变化，所以引入count。
        inOrder(root);
        return res;
    }

    //中序遍历的倒序
    private void inOrder(TreeNode root){
        if(root==null)
            return;
        //右
        inOrder(root.right);

        //根
        if(count==0)    //已经找到res了
            return;
        if(--count==0) {
            res = root.val;
            return;
        }

        //左
        inOrder(root.left);
    }
}
