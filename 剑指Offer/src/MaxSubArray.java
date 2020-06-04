//连续子数组的最大和
public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        //方法一
        /*
        int curSum=0;
        int maxSum=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            if(curSum<=0)   //如果前面子数组的和没有当前的元素值大，就抛弃。
                curSum=nums[i];
            else
                curSum+=nums[i];

            if(curSum>maxSum)   //更新maxSum
                maxSum=curSum;
        }
        return maxSum;
        */

        //方法二：动态规划
        /*
        当 dp[i−1]>0时：执行 dp[i]=dp[i−1]+nums[i]
        当 dp[i−1]≤0时：执行 dp[i]=nums[i]
         */

        /*
        //直接修改原数组
        int maxSum=nums[0];
        for(int i=1;i<nums.length;i++){
            nums[i]+=Math.max(nums[i-1],0);
            maxSum=Math.max(maxSum,nums[i]);
        }
        return maxSum;
        */

        //没有修改原数组
        int res=nums[0];
        int cur;  //用于记录dp[i]的值 i从1开始。
        int prev=nums[0];   //用于记录dp[i-1]的值。

        for(int i=1;i<nums.length;i++){
            cur=prev>0?(nums[i]+prev):nums[i];
            res=cur>res?cur:res;
            prev=cur;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={1,-2,3,10,-4,7,2,-5};
        System.out.println(maxSubArray(nums));
    }
}
