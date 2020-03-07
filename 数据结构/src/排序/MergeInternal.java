package 排序;

public class MergeInternal {
    //非递归对元素进行分组
    public static  void mergeNoR(int[] arr){
        int[] temp=new int[arr.length];
        //i要归并的元素的个数
        for(int i=1;i<arr.length;i*=2){
            //j下一次元素起始位置
            for(int j=0;j<arr.length;j+=2*i){
                int left=j;
                int mid=j+i-1;
                //当最后一个元素时单个的时候，即不用归并
                if(mid>=arr.length-1){
                    continue;
                }
                int right=j+2*i-1;
                //当元素个数不完整时，比如四个元素进行归并，只有三个元素的情况。
                if(right>=arr.length){
                    right=arr.length-1;
                }
                mergeInternal(arr,left,mid,right,temp);
            }
        }
    }

    //递归对元素进行分组
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left>=right)
            return;
        //分组/分解
        int mid=(left+right)/2;
        mergeSort(arr,left,mid,temp);
        mergeSort(arr,mid+1,right,temp);
        //归并：前提条件----->小组数据已经有序
        mergeInternal(arr,left,mid,right,temp);
    }

    //归并排序----->合并两个有序序列，不能原地合并
    public static void mergeInternal(int[] arr, int left, int mid, int right, int[] temp) {
        int begin1=left,end1=mid;
        int begin2=mid+1,end2=right;
        int index=left;
        while (begin1<=end1&&begin2<=end2){
            //<:不稳定
            //<=:稳定
            if(arr[begin1]<=arr[begin2]){
                temp[index++]=arr[begin1++];
            }else {
                temp[index++]=arr[begin2++];
            }
        }
        //判断是否有剩余元素
        while (begin1<=end1){
            temp[index++]=arr[begin1++];
        }
        while (begin2<=end2){
            temp[index++]=arr[begin2++];
        }
        //拷贝
        for(int i=left;i<=right;i++){
            arr[i]=temp[i];
        }

    }

    //封装一个全新的数组
    public static void merge(int[] arr){
        int[] temp=new int[arr.length];
        //mergeSort(arr,0,arr.length-1,temp);
        mergeNoR(arr);
    }
}
