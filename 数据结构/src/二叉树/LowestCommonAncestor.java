package 二叉树;

import java.util.Stack;

//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
public class LowestCommonAncestor {
    //方法一看结点位于根的左边还是右边
    /*public boolean find(Node root,Node node){
        if(root==null)
            return false;
        if(root==node)
            return true;
        if(find(root.left,node))
            return true;
        return find(root.right,node);

    }
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        boolean pL=false;
        boolean pR=false;
        boolean qL=false;
        boolean qR=false;
        if(root==null)
            return root;
        if(root==p||root==q)
            return root;
        if(find(root.left,p)){
            pL=true;
        }else{
            pR=true;
        }
        if(find(root.left,q)){
            qL=true;
        }else{
            qR=true;
        }
        //同一边
        if(pL&&qL){
            return lowestCommonAncestor(root.left,p,q);
        }else if(pR&&qR){
            return lowestCommonAncestor(root.right,p,q);
        }else{
         //两边
            return root;
        }
    }
    */
    //方法二保存路径
    public static boolean getPath(Node root, Node node, Stack<Node> st) {
        if (root == null)
            return false;
        //入栈
        st.push(root);
        if (root == node) {
            //结束
            return true;
        }
        if (getPath(root.left, node, st))
            return true;
        if (getPath(root.right, node, st))
            return true;
        //出栈
        st.pop();
        return false;
    }

    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        Stack<Node> path1 = new Stack<>();
        Stack<Node> path2 = new Stack<>();
        getPath(root, p, path1);
        getPath(root, q, path2);
        //裁剪路径
        while (path1.size() != path2.size()) {
            if (path1.size() > path2.size()) {
                path1.pop();
            } else {
                path2.pop();
            }
        }
            while (path1.size() != 0) {
                if (path1.peek().equals(path2.peek())) {
                    break;
                } else {
                    path1.pop();
                    path2.pop();
                }
            }
        return path1.peek();
    }

    public static void main(String[] args) {
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);

        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;

        Node n6=new Node(6);
        System.out.println(lowestCommonAncestor(n1,n4,n5));
    }
}
