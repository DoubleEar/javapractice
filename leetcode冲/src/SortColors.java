import java.util.Arrays;
//使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
public class SortColors {
    /*
    主要是交换最大值2与最小值0的位置，采用快速排序的思想。
    left代表最后一个最小的元素的下一个元素
    right代表最新的最大的元素的前一个元素
     */
    public static int[] sortColors(int[] nums) {
        int left=0,cur=0;
        int right=nums.length-1;
        while (cur<=right){
            if(nums[cur]==0){
                //如果cur当前遍历到的元素是0，就与left交换。
                swap(nums,cur,left);
                //cur继续向前遍历
                cur++;
                //left指向最后一个值为0的下一个元素
                left++;
            }else if(nums[cur]==2){
                ////如果cur当前遍历到的元素是2，就与right交换。
                swap(nums,cur,right);
                //right指向最新值为2的前一个元素。
                //因为这时cur要判断交换过来的元素是0还是1，所以cur不能执行++的操作。
                right--;
            }else{
                //当cur遍历到的元素值为1时，不用管，继续向后遍历。
                cur++;
            }
        }
        return nums;
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int[] nums={1,2,2,0,1};
        System.out.println(Arrays.toString(sortColors(nums)));
    }
}
