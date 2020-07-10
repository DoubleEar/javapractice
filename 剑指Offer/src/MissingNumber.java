//0～n-1中缺失的数字
//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
// 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
public class MissingNumber {
    public static int missingNumber(int[] nums) {
        //如果出现，那么该数与该数的下标相同。
        int i=0,j=nums.length-1;
        while (i<=j){
            int mid=(i+j)/2;
            if (nums[mid] == mid)   //当前数与当前下标相同，那么之前所有数也符合规则，向后找。
                i = mid + 1;
            else
                j = mid - 1;
        }
        return i;   //当找到不符合的数时，走的是else，所有return i。
    }

    public static void main(String[] args) {
        int[] nums={0,1,3,4,5,6};
        System.out.println(missingNumber(nums));
    }
}
