//最长上升子序列
public class LengthOfLIS {
    public static int lengthOfLIS(int[] nums) {
        //保存从左到右遍历数组所得的最长上升子序列。
        int[] tails = new int[nums.length];
        //记录目前最长上升子序列的长度。
        int res = 0;
        for(int num : nums) {
            //i表示数组tails的起始位置，j表示数组tails最后一个元素位置。
            int i = 0, j = res;
            //因为tails数组是有序的所以可以通过二分查找来更新。
            while(i < j) {
                //找到中间元素的下标
                int m = (i + j) / 2;
                //当前元素大，直接尾插。
                if(tails[m] < num)
                    i = m + 1;
                else
                    //否则在tails中找到第一个比当前元素小的数。
                    //将第一个比当前元素小的数后一个位置设置成当前元素。
                    j = m;
            }

            tails[i] = num;
            if(res == j)
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={0,8,4,12,2};
        System.out.println(lengthOfLIS(nums));
    }
}
