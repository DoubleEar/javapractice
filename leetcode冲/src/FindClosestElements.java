import java.util.ArrayList;
import java.util.List;

//找到 K 个最接近 X 的元素
public class FindClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int size=arr.length;

        int left=0,right=size-1;
        //要从数组中移除的元素：数组的长度-要获取的元素个数。
        int removeNums=size-k;

        while (removeNums>0){
            //如果x离最左边的值更近，删除最右边的值。等于也删除最右边的元素。
            if(x-arr[left]<=arr[right]-x)
                right--;
            else
                left++;
            //更新要删除元素的个数
            removeNums--;
        }
        /*
        int size=arr.length;

        int left=0,right=size-k;
        while (left < right) {
            int mid = (left + right) >>> 1;
            // 尝试从长度为 k + 1（[mid,mid+k]） 的连续子区间删除一个元素
            // 从而定位最优化区间的左边界
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        */

        List<Integer> list=new ArrayList<>();
        for(int i=left;i<left+k;i++){
            list.add(arr[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        System.out.println(findClosestElements(arr,3,7));
    }
}
