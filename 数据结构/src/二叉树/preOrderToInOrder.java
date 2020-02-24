package 二叉树;

//给定一颗二叉树前序遍历，输出该二叉树的中序遍历
//‘#’代表null
public class preOrderToInOrder {
    static int i=0; //静态变量，调用一次就在原值上修改一次
    //建树
    public static Node buildTree(String s){
        //如果不是‘#’证明该节点是根节点
        if(s.charAt(i)!='#'){
            //创建结点
            Node root=new Node(s.charAt(i));
            i++;    //i后移
            root.left=buildTree(s); //创建根节点的左子树
            i++;    //i后移
            root.right=buildTree(s);   //创建根节点的右子树
            return root;
        }
        return null;
    }
    //中序遍历
    public static void inOder(Node root){
        if(root!=null){
            inOder(root.left);
            System.out.print(root.val+"");
            inOder(root.right);
        }
    }

    public static void main(String[] args) {
        String s="ABC##DE#G##F###";
        //将静态变量的值清零
        i=0;
        Node root=buildTree(s);
        inOder(root);
    }
}
