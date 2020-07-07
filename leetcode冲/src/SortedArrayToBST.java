// 将有序数组转换为二叉搜索树
//一个高度平衡二叉树是指一个二叉树每个节点
// 的左右两个子树的高度差的绝对值不超过 1。
public class SortedArrayToBST {
    //数组是二叉搜索树的中序遍历。
    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    private static TreeNode helper(int[] nums,int left,int right){
        if(left>right)
            return null;

        //以升序数组的中间元素作为根节点 root。
        int mid=(right+left)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=helper(nums,left,mid-1);
        root.right=helper(nums,mid+1,right);
        return root;
    }

    public static void main(String[] args) {
        int[] nums={-10,-3,0,5,9};
        System.out.println(sortedArrayToBST(nums));
    }
}
