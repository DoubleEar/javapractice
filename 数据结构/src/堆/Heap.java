package 堆;

import java.util.Arrays;

public class Heap {
    //向下调整为最大堆
    public static void shifDownBig(int[] arr,int size,int parent){
        int child=2*parent+1;
        //从parent节点开始，一直调整到叶子节点
        while(child<size){
            //从两个孩子中选一个值大的
            if(child+1<size && arr[child+1]>arr[child]) {
                child++;
            }
            //如果此孩子节点的值大于当前根的值，就交换
            if(arr[child]>arr[parent]){
                swap(arr,parent,child);
                //更新，继续向下调整
                parent=child;
                child=2*parent+1;
            }else{
                break;
            }
        }
    }
    //向下调整为最小堆
    public static void shifDownSmall(int[] arr,int size,int parent){
        int child=2*parent+1;
        //从parent节点开始，一直调整到叶子节点
        while(child<size){
            //从两个孩子中选一个值小的
            if(child+1<size && arr[child+1]<arr[child]) {
                child++;
            }
            //如果此孩子节点的值小于当前根的值，就交换
            if(arr[child]<arr[parent]){
                swap(arr,parent,child);
                //更新，继续向下调整
                parent=child;
                child=2*parent+1;
            }else{
                break;
            }
        }
    }
    //向上调整为最大堆
    public static void shifUpBig(int[] arr,int size,int child){
        int parent=(child-1)/2;
        //从孩子节点开始，一直调整到根节点
        while(child>0){
            //如果孩子节点的值大于当前根的值，就交换
            if(arr[child]>arr[parent]){
                swap(arr,child,parent);
                //更新，继续向上调整
                child=parent;
                parent=(child-1)/2;
            }else{
                break;
            }
        }
    }
    //向上调整为最小堆
    public static void shifUpSamll(int[] arr,int size,int child){
        int parent=(child-1)/2;
        //从孩子节点开始，一直调整到根节点
        while(child>0){
            //如果孩子节点的值小于当前根的值，就交换
            if(arr[child]<arr[parent]){
                swap(arr,child,parent);
                //更新，继续向上调整
                child=parent;
                parent=(child-1)/2;
            }else{
                break;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    //创建大根堆
    public static void creatHeapBig(int[] arr){
        //从最后一个非叶子节点开始遍历，将局部结构向下调整成大根堆。再整体向下调整。
        for(int i=(arr.length-2)/2;i>=0;i--){
            shifDownBig(arr,arr.length,i);
        }
    }

    //创建小根堆
    public static void creatHeapSmall(int[] arr){
        //从最后一个非叶子节点开始遍历，将局部结构向下调整成小根堆。再整体向下调整。
        for(int i=(arr.length-2)/2;i>=0;i--){
            shifDownSmall(arr,arr.length,i);
        }
    }

    public static void main(String[] args) {
        int[] arr={7,4,55,67,90,1,8,22};
        int[] copy=arr.clone();
        creatHeapBig(arr);
        System.out.println(Arrays.toString(arr));
        creatHeapSmall(copy);
        System.out.println(Arrays.toString(copy));
    }
}
