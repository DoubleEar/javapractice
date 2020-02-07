//给定一个二进制数组， 计算其中最大连续1的个数。
public class FindMaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                //判断是否为1
                count += 1;
            } else {
                //更新最大连续的
                maxCount = Math.max(maxCount, count);
                // 将count清零
                count = 0;
            }
        }
        return Math.max(maxCount, count);
    }

    public static void main(String[] args) {
        int[] nums={1,0,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
