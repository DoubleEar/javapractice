import java.util.Arrays;

//给定一个整数数组，你需要寻找一个连续的子数组，
// 如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
public class FindUnsortedSubarray {
    public static int findUnsortedSubarray(int[] nums) {
        /*
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    //纪录最右边边界的元素坐标
                    r = Math.max(r, j);
                    //纪录最左边边界的元素坐标
                    l = Math.min(l, i);
                }
            }
        }
        return r - l < 0 ? 0 : r - l+1;
        */
        int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = snums.length, end = 0;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
            //纪录最左边边界元素的坐标
                start = Math.min(start, i);
            //纪录最右边边界元素的坐标
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start+1 : 0);
        /*
        int len = nums.length;
        int max = nums[0];
        int min = nums[len-1];
        int l = 0, r = -1;
        for(int i=0;i<len;i++){
            if(max>nums[i]){
                r = i;
            }else{
                max = nums[i];
            }
            if(min<nums[len-i-1]){
                l = len-i-1;
            }else{
                min = nums[len-i-1];
            }
        }
        return r-l+1;
        */
    }

    public static void main(String[] args) {
        int[] nums={2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(nums));
    }
}
