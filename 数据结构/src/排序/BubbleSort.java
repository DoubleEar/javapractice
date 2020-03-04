package 排序;

import 堆.Heap;

//冒泡排序
public class BubbleSort {
    public static void bubbleSort(int[] arr){
        //未排序元素的个数
        int len=arr.length;
        while (len>0){
            //flag为true已经有序
            boolean flag=true;
            //一轮排序
            for(int i=0;i<len-1;i++){
                if(arr[i]>arr[i+1]) {
                    Heap.swap(arr, i, i + 1);
                    flag=false;
                }
            }
            if(flag)
                break;
            len--;
        }
    }
}
