package 二叉树;

import java.util.ArrayList;
import java.util.List;

//中序遍历并把它们存入顺序表中
public class InOrder {
    public void inOrder(Node root,List<Integer> list) {
        if (root != null) {
            inOrder(root.left, list);
            list.add(root.value);
            inOrder(root.right, list);
        }
    }
       public List<Integer> inOderTree(Node root){
            List<Integer> list= new ArrayList<>();
            inOrder(root,list);
            return list;
    }

}












