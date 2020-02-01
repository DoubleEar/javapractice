import java.util.ArrayList;
import java.util.List;

//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        /*List<List<Integer>> ans = new ArrayList<>();
        getAns(nums, 0, new ArrayList<>(), ans);
        return ans;
        */
        List<List<Integer>> ans = new ArrayList<>();
        int bit_nums = nums.length;
        int ans_nums = 1 << bit_nums; //执行 2 的 n 次方
        for (int i = 0; i < ans_nums; i++) {
            List<Integer> tmp = new ArrayList<>();
            int count = 0; //记录当前对应数组的哪一位
            int i_copy = i; //用来移位
            while (i_copy != 0) {
                if ((i_copy & 1) == 1) { //判断当前位是否是 1
                    tmp.add(nums[count]);
                }
                count++;
                i_copy = i_copy >> 1;//右移一位
            }
            ans.add(tmp);
        }
        return ans;
    }

   /* private static void getAns(int[] nums, int start, ArrayList<Integer> temp, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            getAns(nums, i + 1, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }
    */
    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        System.out.println(subsets(nums));
    }
}
