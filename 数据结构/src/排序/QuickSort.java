package 排序;

import 堆.Heap;

//快速排序
public class QuickSort {
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
            Heap.swap(arr,left,right);
        }
        //把基准值和相遇的位置交换
        Heap.swap(arr,left,start);
        return left;
    }

    public static void quickSort(int[] arr,int left,int right){
        if (left<right) {
            int mid = partion(arr, left, right);
            quickSort(arr, left, mid - 1);
            quickSort(arr, mid + 1, right);
        }
    }
}
