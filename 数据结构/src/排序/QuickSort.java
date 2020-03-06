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
            //直到找到符合条件的值，交换。
            Heap.swap(arr,left,right);
        }
        //把基准值和相遇的位置交换
        Heap.swap(arr,left,start);
        return left;
    }

    public static int partion2(int[] arr,int left,int right){
        //获取基准值
        int key=arr[left];
        //挖坑填坑
        while(left<right){
            //从右边找第一个小于key的数，填左边的坑
            while(left<right&&arr[right]>=key)
                right--;
            //填坑
            arr[left]=arr[right];
            //从左边找第一个大于key的数，填右边的坑
            while (left<right&&arr[left]<=key)
                left++;
            //填坑
            arr[right]=arr[left];
        }
        //填基准值到当前相遇的位置
        arr[left]=key;
        return left;
    }

    public static int getMid(int[] arr,int left,int right){
        int mid=(left+right)/2;
        if(arr[mid]>arr[left]){
            if(arr[mid]<arr[right]){
                return mid;
            }else{
                //arr[mid]>arr[left]  >arr[right]
                if(arr[left]>arr[right]){
                    return left;
                }else {
                    return right;
                }
            }
        }else {
            if (arr[mid] > arr[left]) {
                return mid;
            } else if (arr[left] < arr[right]) {
                //arr[mid] <arr[left]   <arr[right]
                return left;
            } else {
                return right;
            }
        }
    }

    public static int partion3(int[] arr,int left,int right){
        //int mid=getMid(arr,left,right);
        //Heap.swap(arr,left,mid);
        int key=arr[left];
        int prev=left;//表示的是最后一个小于key的值，循环结束后，与key值交换。
        int cur=left+1;
        while (cur<=right){
            //如果cur找到下一个小于key的位置，并且prev与cur之间有大于key的值，就交换key与prev。
            if(arr[cur]<key&&++prev!=cur){
                Heap.swap(arr,cur,prev);
            }
            cur++;
        }
        //交换key与prev的值
        Heap.swap(arr,prev,left);
        return left;
    }

    public static void quickSort(int[] arr,int left,int right){
        if (left<right) {
            //int mid = partion(arr, left, right);
            //quickSort(arr, left, mid - 1);
            //quickSort(arr, mid + 1, right);

            //int mid2= partion2(arr, left, right);
            //quickSort(arr, left, mid2 - 1);
            //quickSort(arr, mid2 + 1, right);

            int mid3 = partion3(arr, left, right);
            quickSort(arr, left, mid3 - 1);
            quickSort(arr, mid3 + 1, right);
        }
    }
}
