import java.util.Arrays;
//调整数组顺序使奇数位于偶数前面
public class Exchange {
    private static void swap(int[] nums,int begin,int end){
        int temp=nums[begin];
        nums[begin]=nums[end];
        nums[end]=temp;
    }

    public static int[] exchange(int[] nums) {
        if(nums==null||nums.length==0)
            return nums;
        //双指针法
        int len=nums.length;
        int begin=0;
        int end=len-1;

        while (begin<end){
            //从前往后找偶数
            while (begin<end&&nums[begin]%2!=0)
                begin++;
            //从后往前找奇数
            while (begin<end&&nums[end]%2==0)
                end--;
            //奇数
            swap(nums,begin,end);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        System.out.println(Arrays.toString(exchange(nums)));
    }
}
