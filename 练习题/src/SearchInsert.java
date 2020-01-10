//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
// 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//二分查找的变形题目
public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while(left <=right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums={1,3,4,6};
        System.out.println(searchInsert(nums,2));
    }
}
