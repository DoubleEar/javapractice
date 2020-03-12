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

        List<Integer> list=new ArrayList<>();
        for(int i=left;i<=right;i++){
            list.add(arr[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        System.out.println(findClosestElements(arr,3,7));
    }
}
