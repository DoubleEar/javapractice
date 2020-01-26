import java.util.Arrays;
import java.util.Stack;

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。
//找出给定目标值在数组中的开始位置和结束位置。
public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        //Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack=new Stack<>();
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] == target)
                stack.add(i);
    }
        if (stack.size() == 2) {
            int[] a=new int[2];
            a[1]=stack.pop();
            a[0]=stack.peek();
            return a;
        }
        return new int[]{-1,1};
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,3,5};
        System.out.println(Arrays.toString(searchRange(nums,3)));
    }
}
