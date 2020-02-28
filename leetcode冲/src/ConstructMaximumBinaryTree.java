//1.二叉树的根是数组中的最大元素。
//2.左子树是通过数组中最大值左边部分构造出的最大二叉树。
//3.右子树是通过数组中最大值右边部分构造出的最大二叉树。
public class ConstructMaximumBinaryTree {
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return _construct(nums,0,nums.length);
    }
    private static TreeNode _construct(int[] nums, int left, int right) {
        if(left>=right)
            return null;
        //找到最大的值作为当前树的根
        int maxValue=maxIndex(nums,left,right);
        TreeNode root=new TreeNode(nums[maxValue]);
        //构建左子树
        root.left=_construct(nums,left,maxValue);
        //构建右子树
        root.right=_construct(nums,maxValue+1,right);
        return root;
    }
    private static int maxIndex(int[] nums,int l,int r){
        int maxValue=l;
        //如果当前值大于maxValue就交换下标
        for(int i=l;i<r;i++){
            if(nums[maxValue]<nums[i])
                maxValue=i;
        }
        //返回下标
        return maxValue;
    }

    public static void main(String[] args) {
        int[] nums={3,2,1,6,0,5};
        TreeNode result=constructMaximumBinaryTree(nums);
        System.out.println(PreorderTraversal.preorderTraversal(result));
    }
}
