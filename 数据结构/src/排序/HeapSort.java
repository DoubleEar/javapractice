package 排序;

public class HeapSort {
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void shifDownBig(int[] arr,int size,int parent){
        int child=parent*2+1;
        while(child<size){
            if(child+1<size&&arr[child+1]>arr[child]){
                child++;
            }
            if(arr[child]>arr[parent]){
                swap(arr,child,parent);
                parent=child;
                child=parent*2+1;
            }else{
                break;
            }
        }
    }

    public static void creatHeap(int[] arr){
        int len=arr.length;
        for(int i=(arr.length-2)/2;i>=0;i--){
            shifDownBig(arr,len,i);
        }
        int end=len-1;
        //交换向下调整交替执行
        while(end>0){
            swap(arr,0,end);
            shifDownBig(arr,end,0);
            end--;
        }
    }
}
