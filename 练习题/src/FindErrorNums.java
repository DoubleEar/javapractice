import java.util.Arrays;

//你的任务是首先寻找到重复出现的整数，
// 再找到丢失的整数，将它们以数组的形式返回
public class FindErrorNums {
    public static int[] findErrorNums(int[] nums) {
        int flag = -1, missing = -1;
        for (int i = 1; i <= nums.length; i++) {
            int count = 0;
            //判断每一个数在数组中的个数
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i)
                    count++;
            }
            //如果存在重复的，将这个数值即i返回
            if (count == 2)
                flag = i;
            //如果没有这个数，证明这个数是被漏掉的，则返回
            else if (count == 0)
                missing = i;
        }
        return new int[] {flag, missing};
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,3,4};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }
}
