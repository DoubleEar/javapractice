import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//给定一个整数数组，判断是否存在重复元素。
public class Contains_Duplicate {
    public static boolean containsDuplicate(int[] nums) {
        /*Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
        */
        //如果是实现了Set接口的集合类，具备的特点： 无序，不可重复。
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i : nums) {
            set.add(i);
        }
        return nums.length != set.size();
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        System.out.println(containsDuplicate(nums));
    }
}
