import java.util.Stack;

//二叉搜索树的后序遍历序列
public class VerifyPostorder {
    /*
    public static boolean verifyPostorder(int[] postorder) {
        int len=postorder.length-1;
        return postOrder(postorder,0,len);
    }

    //二叉搜索树，左孩子都小于根节点右孩子都大于根节点。
    private static boolean postOrder(int[] n,int i,int j){
        if(i>=j)    //说明此子树节点数量≤1无需判别正确性，因此直接返回true。
            return true;
        int p=i;
        //找出根节点的左孩子的边界
        while (n[p]<n[j])
            p++;
        int m=p;
        //找出根节点的右孩子的起始位置（数组中）
        while (n[p]>n[j])
            p++;

        //验证二叉树的合法性以及递归左右子树
        return p==j&&postOrder(n,i,m-1)&&postOrder(n,m,j-1);
    }
    */


    public static boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack=new Stack<>(); //维护一个单调栈
        int prevElem=Integer.MAX_VALUE; //表示上一个根节点的元素
        for(int i=postorder.length-1;i>=0;i--){ //相当于根右左
            if(postorder[i]>prevElem)   //左子树的值不可能大于右子树的值。
                return false;

            while (!stack.isEmpty()&&postorder[i]<stack.peek()){
                //数组元素小于栈顶元素，说明向左子树走了。
                //找到该左子树对应的根节点，将之前的元素全部弹出
                prevElem=stack.pop();
            }
            //新的节点入栈
            stack.push(postorder[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] n={5,7,6,9,11,10,8};
        System.out.println(verifyPostorder(n));
    }
}
