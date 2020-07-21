import java.util.Arrays;
//和为s的两个数字
//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int len=nums.length;
        int front=0;
        int behind=len-1;
        int[] res=new int[2];

        while (front<behind){
            long sum=nums[front]+nums[behind];

            if(sum==target){
                res[0]=nums[front];
                res[1]=nums[behind];
                return res;
            }else if(sum>target)    //若 sum>target 则behind指针向左移动
                behind--;
            else                    //若 sum<target 则front指针向右移动
                front++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={16,16,18,24,30,32};
        System.out.println(Arrays.toString(twoSum(nums,48)));
    }
}
