package 二叉树;

//返回树的最大深度
public class MaxDepth {
    public static int maxDepth(Node root){
        //return root==null?0:Math.max(maxDepth(root.right),maxDepth(root.left))+1;
        if(root==null)
            return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return left>=right?1+left:1+right;
    }

    public static void main(String[] args) {
        Node root=new Node(1);
        Node n1=new Node(2);
        Node n2=new Node(3);
        Node n3=new Node(4);
        Node n4=new Node(5);
        Node n5=new Node(6);
        Node n6=new Node(7);
        Node n7=new Node(8);
        root.left=n1;
        root.right=n2;
        n1.left=n3;
        n1.right=n4;
        n2.left=n5;
        n2.right=n6;
        n4.right=n7;
        System.out.println(maxDepth(root));
    }
}
