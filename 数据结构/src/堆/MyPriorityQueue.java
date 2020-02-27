package 堆;

import java.util.Arrays;

public class MyPriorityQueue {
    int[] arr=new int[10];
    int size;

    //入队
    public void offer(int value){
        if(size==arr.length)
            arr=Arrays.copyOf(arr,arr.length*2);
        //尾插
        arr[size++]=value;
        //向上调整成最小堆
        Heap.shifUpSamll(arr,size,size-1);
    }

    //出队
    public int poll(){
        if(size>0){
            int peek=arr[0];
            //交换队头队尾元素
            Heap.swap(arr,0,size-1);
            //删除队尾元素（此时出队的是最小元素）
            --size;
            //向下调整为小堆
            Heap.shifDownSmall(arr,size,0);
            return peek;
        }
        return -1;
    }

    //判空
    public boolean isEmpty(){
        return size==0;
    }

    //获取队头元素
    public int peek(){
        return arr[0];
    }
}
