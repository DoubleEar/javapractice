import java.util.HashMap;
import java.util.Map;

//找出数组中出现次数大于  n/2  的元素。
public class MajorityElement {
    //方法一：HashMap
    public static int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (map.get(i) > nums.length / 2)
                return i;
        }
        return -1;
    }

    //方法二：排序。
    //要找出 > n/2的元素，经过排序后该元素一定占据数组的中间位置。
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static int partion(int[] arr,int left,int right){
        int key=arr[left];
        int start=left;
        while (left<right){
            //一定从后向前找第一个比key小的值，这样能保证相遇的点一定是比key小的值，最后交换不会有问题
            while(left<right&&arr[right]>=key)
                right--;
            //从前往后找第一个比key大的值
            while (left<right&&arr[left]<=key)
                left++;
            //直到找到符合条件的值，交换。
            swap(arr,left,right);
        }
        //把基准值和相遇的位置交换
        swap(arr,left,start);
        return left;
    }

    public static void quickSort(int[] arr,int left,int right){
        if (left<right) {
            int mid = partion(arr, left, right);
            quickSort(arr, left, mid - 1);
            quickSort(arr, mid + 1, right);
        }
    }
   public static int majorityElement2(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums[nums.length/2];
    }

    //方法三：摩尔根投票法。
    public static int majorityElement3(int[] nums) {
        int count=1;
        int res=nums[0];
        for(int i=1;i<nums.length;i++){
            //遇到相同的元素就投票
            if(res==nums[i])
                count++;
            //否则就减票（因为要找的元素过半，最终count经过抵消一定>=1）
            else if(--count==0) {
                res=nums[i];
                count=1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums={2,2,1,1,1,2,2};
        int[] copy=nums.clone();
        System.out.println(majorityElement1(nums));
        System.out.println(majorityElement2(nums));
        System.out.println(majorityElement3(copy));
    }
}
