package 二叉树;

//找到相应值的根
public class FindNode {
    public Node find(Node root,int value){
        if(root==null)
            return root;
        if(root.value==value)
            return root;
        Node node=find(root.left,value);
        //如果node不等于空，说明在左子树中找到了
        if(node!=null)
            //返回node即可
            return node;
        //在左子树中没找到，再在右子树中找
        return find(root.right,value);
    }
}
