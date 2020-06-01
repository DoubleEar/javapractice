import java.util.LinkedList;
import java.util.Queue;
//二叉树的序列化与反序列化
public class Codec {
    //序列化二叉树
    public static String serialize(TreeNode root) {
        if(root==null)
            return "[]";

        StringBuilder sb=new StringBuilder("[");
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){   //层序遍历
            TreeNode node=queue.poll();
            if(node!=null) {
                sb.append(node.val+",");
                queue.offer(node.left);
                queue.offer(node.right);
            }else
                sb.append("null,");
        }
        sb.deleteCharAt(sb.length()-1); //删除最后一个逗号
        sb.append("]");

        return sb.toString();
    }

    //反序列化二叉树
    public static TreeNode deserialize(String data) {
       if(data.equals("[]"))
           return null;

       //截取方括号内的字符串并用逗号分割成字符数组
       String[] s=data.substring(1,data.length()-1).split(",");
       Queue<TreeNode> queue=new LinkedList<>();

       //第一个为根节点
       TreeNode root=new TreeNode(Integer.parseInt(s[0]));
       queue.offer(root);
       int index=1;

       while (!queue.isEmpty()){
           TreeNode node=queue.poll();

           if(!s[index].equals("null")){    //当前遍历到的节点不为空
               node.left=new TreeNode(Integer.parseInt(s[index]));
               queue.offer(node.left);
           }
           index++; //注意下标更新只能在这，因为当前节点为空时不进入if语句。

           if(!s[index].equals("null")){    //当前遍历到的节点不为空
               node.right=new TreeNode(Integer.parseInt(s[index]));
               queue.offer(node.right);
           }
           index++;
       }

       return root;
    }

    public static void main(String[] args) {
        String s="[1,2,3,null,null,4,5]";
        deserialize(s);

        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        t1.left=t2;
        t1.right=t3;
        t3.left=t4;
        t4.right=t5;

        System.out.println(serialize(t1));

    }
}
