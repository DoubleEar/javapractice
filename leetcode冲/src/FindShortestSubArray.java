import java.util.HashMap;
import java.util.Map;

//找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
public class FindShortestSubArray {
    public static int findShortestSubArray(int[] nums) {
        //用来纪录每个元素出现的个数
        Map<Integer,Integer> numbers= new HashMap<>();
        //用来纪录元素第一次出现的位置（索引）
        Map<Integer,Integer>  first= new HashMap<>();
        //用来纪录元素最后一次出现的位置（索引）
        Map<Integer,Integer>  last= new HashMap<>();
        for(int i = 0;i<nums.length;i++)
        {
            //如果numbers中没有num[i]时，则value默认为0再加一
            numbers.put(nums[i],numbers.getOrDefault(nums[i],0)+1);
            //key值不重复，value一直在更新。
            last.put(nums[i],i);
            //如果first中不包括nums[i]，就put。
            if(!first.containsKey(nums[i]))
            {
                first.put(nums[i],i);
            }
        }

        int maxCnt = 0;
        //求出数组的度
        for (int num : nums) {
            //get(num)——>value即每个元素出现的个数
            maxCnt = Math.max(maxCnt, numbers.get(num));
        }

        //求最大度的各个元素之间的距离，选择距离最小的
        int ret = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int cnt = numbers.get(num);
            //如果不等于数组的度就继续往后遍历
            if (cnt != maxCnt)
                continue;
            ret = Math.min(ret, last.get(num) - first.get(num) + 1);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,2,3,4,4};
        System.out.println(findShortestSubArray(nums));
    }
}
