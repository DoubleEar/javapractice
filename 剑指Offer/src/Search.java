//在排序数组中查找数字 I
public class Search {
    /*
    //统计一个数字在排序数组中出现的次数。
    //时间复杂度O(log(n))
    public static int search(int[] nums, int target) {
        int res=0;
        int len=nums.length;
        if(nums!=null&&nums.length>0){
            int first=GetFirstK(nums,len,target,0,len-1);
            int last=GetLastK(nums,len,target,0,len-1);

            if(first>-1&&last>-1)
                res=last-first+1;
        }
        return res;
    }

    //二分查找找到target开始出现的下标
    private static int GetFirstK(int[] nums, int len, int target, int left, int right) {
        if(left>right)
            return -1;

        int middleIndex=(left+right)/2;
        int middleData=nums[middleIndex];

        if (middleData == target) {
            if (middleIndex > 0 && nums[middleIndex - 1] != target || middleIndex == 0)
                return middleIndex;
            else
                //第一个k肯定在数组的前半段，要在数组的前半段找第一个k的下标。
                right = middleIndex - 1;
        } else if (middleData > target)
            right = middleIndex - 1;
        else
            left = middleIndex + 1;

        return GetFirstK(nums, len, target, left, right);
    }

    //二分查找找到target最后出现的下标
    private static int GetLastK(int[] nums, int len, int target, int left, int right) {
        if(left>right)
            return -1;

        int middleIndex=(left+right)/2;
        int middleData=nums[middleIndex];

        if(middleData==target) {
            if (middleIndex < len - 1 && nums[middleIndex + 1] != target || middleIndex == len - 1)
                return middleIndex;
            else    //最后一个k肯定在数组的后半段，要在数组的后半段找最后一个k的下标。
                left = middleIndex + 1;
        } else if (middleData > target)
            right = middleIndex - 1;
        else
            left = middleIndex + 1;

        return GetLastK(nums, len, target, left, right);
    }
    */

    public static int search(int[] nums, int target) {
        //可以分别二分查找target,target - 1的右边界，将两结果相减并返回即可。
        return helper(nums,target)-helper(nums,target-1);
    }

    //寻找target的右边界
    private static int helper(int[] nums,int target){
        int i=0,j=nums.length-1;
        while (i<=j){
            int mid=(i+j)/2;
            if(nums[mid]<=target)   //将nums[mid]==target进行合并，如果nums[mid]是target的右边界
                                    //之后的数一定都比target大，只会走else。
                i=mid+1;
            else
                j=mid-1;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums={7,7,7,8,8,10};
        System.out.println(search(nums,7));
    }
}
