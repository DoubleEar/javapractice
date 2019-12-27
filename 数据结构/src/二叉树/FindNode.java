package 二叉树;

//找到相应值的根
public class FindNode {
    public Node find(Node root,int value){
        if(root==null)
            return root;
        if(root.value==value)
            return root;
        Node node=find(root.left,value);
        if(node!=null)
            return node;
        return find(root.left,value);
    }
}
