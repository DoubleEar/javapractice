import java.util.Arrays;

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//二分查找变形
public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, 1};
        //首先确定左边目标值的下标
        int leftIdx = extremeInsertionIndex(nums, target, true);
        //如果下标等于数组的长度或者，以leftIdx为下标的值不等于目标值
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return result;
        }

        result[0] = leftIdx;
        //其次确定右边目标值的下标
        result[1] = extremeInsertionIndex(nums, target, false) - 1;
        return result;
    }

    private static int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int start = 0;
        int last = nums.length;

        while (start < last) {
            int mid = (start + last) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                last = mid;
            }
            else {
                start = mid+1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,4,5};
        System.out.println(Arrays.toString(searchRange(nums,4)));
    }
}
