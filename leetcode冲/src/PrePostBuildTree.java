//根据前序和后序遍历构造二叉树
    public class PrePostBuildTree {
    //前序遍历的第一个结点与后序遍历的最后一个结点一定是整棵树的根
    //前序遍历的第二个结点是左子树的根节点，在后续遍历中找到这个结点
    //后序遍历头到这个结点就是左子树，之后是右子树（除了最后一个结点）
    public TreeNode buildTree(int[] pre,int[] post,int preS,int preE,int postS,int postE){
        if(postS>postE)
            return null;
        //从前序遍历中拿到当前树的根节点
        TreeNode root=new TreeNode(pre[preS]);
        //如果起始位置与结束位置相同时，证明没有孩子。此节点为叶子节点。
        if(postS==postE)
            return root;
        //从前序遍历的第二个结点开始
        int rootValue=pre[preS+1];
        //在后序遍历中找到根结点的位置
        for(int i=postS;i<=postE;i++){
            if(post[i]==rootValue){
                //左子树的长度
                int length=i-postS+1;
                root.left=buildTree(pre,post,preS+1,preS+length,postS,i);
                root.right=buildTree(pre,post,preS+length+1,preE,i+1,postE-1);
                return root;
            }
        }
        return null;
    }
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return buildTree(pre,post,0,pre.length-1,0,post.length-1);
    }
}
