package 二叉树;
//二叉链
    class Node {
    char value;
    Node left;
    Node right;

    public Node(char value) {
        this.value = value;
        left = right = null;
    }
}
public class BinaryTree{
    public static int size=0;
    public static int leafsize=0;
    //前序遍历：根 左子树 右子树
    public void preOrder(Node root){
        //终止条件：空树
        if(root==null)
            return;
        else{
            //根
            System.out.print(root.value);
            //左子树
            preOrder(root.left);
            //右子树
            preOrder(root.right);
        }

    }
    //中序遍历：左子树 根 右子树
    public void inOrder(Node root){
        if(root==null)
            return;
        else{
        //左子树
        preOrder(root.left);
        //根
         System.out.print(root.value);
        //右子树
        preOrder(root.right);
        }
    }
    //后序遍历：左子树 右子树 根
    public void postOrder(Node root){
        if(root==null)
            return;
        else{
            //左子树
            preOrder(root.left);
            //右子树
            preOrder(root.right);
            //根
            System.out.print(root.value);
        }
    }

    //求整棵树的节点
    public void getSize1(Node root) {
        if (root == null)
            return;
            //左子树
           getSize1(root.left);
            //右子树
            getSize1(root.right);
            size++;
        }

        //求整棵树的节点
     public int getSize2(Node root){
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null)
            return 1;
        //整棵树的结点：点当前结点+左右子树结点的个数
        return getSize2(root.left)+getSize2(root.right)+1;
     }

     //求叶子节点的个数
     public void getLeafSize1(Node root){
        if(root==null)
            return;
        if(root.left==null&&root.right==null) {
            leafsize++;
            return;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
     }

    //求叶子节点的个数
    public int getLeafSize2(Node root){
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null)
            return 1;
        //整棵树的叶子结点：左右子树叶子之和
        return getLeafSize2(root.left)+getLeafSize2(root.right);
    }

    //获取第k层节点的个数
    public int getKSize(Node root,int k){
        if(root==null)
            return 0;
        if(k==1)
            return 1;
        return getKSize(root.left,k-1)+getKSize(root.right,k-1);
    }

    //构建一棵树
    public static Node buildBtree(){
        Node root=new Node('A');
        Node n1=new Node('B');
        Node n2=new Node('C');
        Node n3=new Node('D');
        Node n4=new Node('E');
        Node n5=new Node('F');
        Node n6=new Node('G');
        Node n7=new Node('H');
        root.left=n1;
        root.right=n2;
        n1.left=n3;
        n1.right=n4;
        n2.left=n5;
        n2.right=n6;
        n4.right=n7;
        return root;
    }

    public static void main(String[] args) {
        BinaryTree btree=new BinaryTree();
        Node root=buildBtree();
        btree.preOrder(root);
        System.out.println();
        btree.inOrder(root);
        System.out.println();
        btree.postOrder(root);
        System.out.println();
        btree.getSize1(root);
        System.out.println(size);
        System.out.println(btree.getSize2(root));
        btree.getLeafSize1(root);
        System.out.println(leafsize);
        System.out.println(btree.getLeafSize2(root));
        System.out.println(btree.getKSize(root,1));
        System.out.println(btree.getKSize(root,2));
        System.out.println(btree.getKSize(root,3));
        System.out.println(btree.getKSize(root,4));
    }
}
