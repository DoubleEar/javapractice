import java.util.Arrays;
//将数组中的零移到数组最后，保持原数组顺序不变
public class MoveZeroes {
    public static int[] moveZeroes(int[] nums) {
        int cur=0;
        for(int num:nums){
            //先将不为零的元素放到数组的最开始
            if(num!=0){
                nums[cur++]=num;
            }
        }
        //再将后面的元素都设为零
        while(cur<nums.length){
            nums[cur++]=0;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums={1,0,2,3,0};
        System.out.println(Arrays.toString(moveZeroes(nums)));
}
}
