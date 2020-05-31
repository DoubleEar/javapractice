import java.util.ArrayList;
import java.util.List;
// 二叉树中和为某一值的路径
public class PathSum {
    static List<List<Integer>> lists=new ArrayList<>(); //保存所有路径的结果集
    static List<Integer> list=new ArrayList<>();    //当前符合的路径
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        lists.clear();  //静态变量记得重置，有多个测试用例。
        list.clear();

        if(root==null)
            return new ArrayList<>();

        getPath(root,0,sum);

        return lists;
    }

    private static void getPath(TreeNode root,int curNum,int sum){
        list.add(root.val); //先将根加入list
        curNum+=root.val;   //当前值 ＋ 遍历到的根的值

        //判断是否为叶子节点
        boolean isLeaf=root.left==null&&root.right==null;

        if(curNum==sum&&isLeaf){    //符合条件
            lists.add(new ArrayList<>(list));
        }

        if(root.left!=null)
            getPath(root.left,curNum,sum);
        if(root.right!=null)
            getPath(root.right,curNum,sum);

        //当该叶子节点返回父节点前，删除。
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        TreeNode n1=new TreeNode(10);
        TreeNode n2=new TreeNode(5);
        TreeNode n3=new TreeNode(12);
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(7);

        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;

        System.out.println(pathSum(n1,22));
    }
}
