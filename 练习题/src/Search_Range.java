import java.util.Arrays;

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。
// 找出给定目标值在数组中的开始位置和结束位置。
public class Search_Range {
   /* public static int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        // 从左往右找到与target相等的值
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                targetRange[0] = i;
                break;
            }
        }
        //如果没有找到与target相等的值返回i[-1,-1]
        if (targetRange[0] == -1) {
            return targetRange;
        }
        //从右往左找到第二个与target相等的值
        for (int j = nums.length-1; j >= 0; j--) {
            if (nums[j] == target) {
                targetRange[1] = j;
                break;
            }
        }
        return targetRange;
    }
    public static void main(String[] args) {
        int[] nums={1,2,3,4,3,5};
        System.out.println(Arrays.toString(searchRange(nums,3)));
    }
    */
   public static int[] searchRange(int[] nums, int target) {
       int[] res = {-1,-1};
       if(nums.length == 0)
           return res;
       //找到第一个与target相同的值的下标
       divide(res,nums,target,0,nums.length - 1,true);
       //找到第二个与target相同的值的下标
       divide(res,nums,target,0,nums.length - 1,false);
       return res;
   }
    public static void divide(int[] result,int[] nums,int target,int low,int high,boolean flag){
        if (low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] < target)
                divide(result,nums,target,mid + 1,high,flag);
            else if(nums[mid] > target)
                divide(result,nums,target,low,mid - 1,flag);
            //当nums[mid]==target时
            else {
                if(flag){
                    result[0] = mid;
                    //判断当前元素的前一位是否是目标元素
                    divide(result,nums,target,low,mid - 1,flag);
                }else {
                    result[1] = mid;
                    //判断当前元素的后一位是否为目标元素
                    divide(result,nums,target,mid + 1,high,flag);
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,4,5};
        System.out.println(Arrays.toString(searchRange(nums,4)));
    }
}
