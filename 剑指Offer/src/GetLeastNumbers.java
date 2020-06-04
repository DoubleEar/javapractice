import java.util.Arrays;
import java.util.PriorityQueue;

//最小的k个数
public class GetLeastNumbers {
    public static int[] getLeastNumbers(int[] arr, int k) {
        //方法一：建大堆
        /*
        if(k>arr.length||k<1||arr.length==0){
            return new int[0];
        }

        //实现大根堆保证时间复杂度事O(NlogK)
        PriorityQueue<Integer> pq=new PriorityQueue<>((v1, v2) -> v2 - v1);

        for(int num:arr){
            if(pq.size()<k){
                pq.offer(num);
            }else if(num<pq.peek()){
                pq.poll();
                pq.offer(num);
            }
        }

        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=pq.poll();
        }
        return res;
        */

        //方法二：快排思想
        if(k>arr.length||k<1||arr.length==0) {
            return new int[0];
        }

        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSort(arr,0,arr.length-1,k-1);
    }

    private static int[] quickSort(int[] arr,int left,int right,int k){
        int j=partition(arr,left,right);

        if(j==k)
            return Arrays.copyOf(arr,j+1);  //newLength代表的是新数组的长度不是下标

        //如果 j 比 k 大的话，那么我们下次切分只要遍历数组 (0~k-1)的元素就行啦
        // 反之如果 j 比 k 小的话，那下次切分只要遍历数组 (k+1～n) 的元素就行啦
        return j>k?quickSort(arr,left,j-1,k):quickSort(arr,j+1,right,k);
    }

    private static int partition(int[] arr,int left,int right){
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

    private static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int[] arr={5,4,8,9,0,3,4,1};
        System.out.println(Arrays.toString(getLeastNumbers(arr, 3)));
    }
}
