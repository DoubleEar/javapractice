//不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合。
public class Massage {
    /*
    dp[i]数组表示前i个预约可以接到的最长预约时间
    对于每一个i，都可以选择接或不接
    接的话，就是dp[i-2]加自己nums[i]
    不接的话，就dp[i-1]不加自己
    */
    public static int massage(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums={2,1,3,1,5};
        System.out.println(massage(nums));
    }
}
