import java.util.Stack;
//移除所有数值等于 val 的元素，返回移除后数组的新长度。
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int a = 0;
        for (i = 0; i < nums.length; i++) {
            a = nums[i];
            if (a != val) {
                stack.push(a);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,1,5,1,8};
        System.out.println(removeElement(nums, 1));
    }
}
