//原地删除排序数组中的重复项
public class RemoveDuplicates {
    /*
    首先注意数组是有序的，那么重复的元素一定会相邻。
    要求删除重复元素，实际上就是将不重复的元素移到数组的左侧。
    p,q往后移动，如果遇到值不相等的元素就将nums[q]的值赋给nums[p]的下一个元素。
    如果相邻的两个元素不相等也不用进行复制的操作。
     */
    public static int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int p=0,q=1;//快慢指针
        while (q<nums.length){
            //如果nums[p]与nums[q]指向的不是相同的元素
            if(nums[p]!=nums[q]){
                //并且p和q主键最少差一个元素
                if(q-p>1)
                    //就将nums[q]的值赋给p的下一个元素
                    nums[p+1]=nums[q];
                p++;
            }
            //q前移
            q++;
        }
        return p+1;
    }

    public static void main(String[] args) {
        int[] nums={1,1,3,4,4,5,5,6,6,7,8,9};
        System.out.println(removeDuplicates(nums));
    }
}
