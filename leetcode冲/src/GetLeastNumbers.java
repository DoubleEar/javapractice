import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//输入整数数组 arr ，找出其中最小的 k 个数。
public class GetLeastNumbers {
    public static int[] getLeastNumbers(int[] arr, int k) {

        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int nums:arr){
            pq.add(nums);

            if(pq.size()>k)
                pq.poll();
        }

        int[] res=new int[k];
        int i=0;
            while (!pq.isEmpty()) {
                    res[i++] = pq.poll();
        }
        return res;

        //quickSort(arr,0,arr.length-1);
        //return Arrays.copyOf(arr,k);
    }
    /*
    private static void quickSort(int[] arr,int left,int right) {
        if(left<right) {
            int mid = partion(arr, left, right);
            quickSort(arr, left, mid - 1);
            quickSort(arr, mid + 1, right);
        }
    }

    public static int partion(int[] arr,int left,int right){
        int key=arr[left];
        int start=left;
        while (left<right){
            while (left<right&&arr[right]>=key)
                right--;
            while (left<right&&arr[left]<=key)
                left++;
            swap(arr,left,right);
        }
        swap(arr,left,start);

        return left;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }
    */

    public static void main(String[] args) {
        int[] arr={3,4,2,1,7};
        System.out.println(Arrays.toString(getLeastNumbers(arr,3)));
    }
}
