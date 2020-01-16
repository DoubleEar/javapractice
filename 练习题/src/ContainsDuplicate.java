//给定一个整数数组，判断是否存在重复元素。(无负数)
public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        int[] arr=new int[10];
        int i;
        for( i=0;i<nums.length;i++){
            arr[nums[i]]++;
        }
        for(i=0;i<arr.length;i++){
            if(arr[i]>=2)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        System.out.println(containsDuplicate(nums));
    }
}
