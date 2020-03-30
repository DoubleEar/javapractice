//在一个数组中找到第K个大的数。
public class Finder {
    public int findKth(int[] a, int n, int K) {
        quickSort(a,0,n-1);
        return a[K-1];
    }
    private void swap(int[] arr,int left,int right){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }

    private void quickSort(int[] arr,int left,int right){
        if(left<right){
            //mid代表基准值最终停留的下标
            int mid=partion(arr,left,right);
            //按照基准值进行分割
            quickSort(arr,left,mid-1);
            quickSort(arr,mid+1,right);
        }
    }
    //前后遍历法
    private int partion(int[] arr,int left,int right){
        int key=arr[left];
        int prev=left;
        int cur=left+1;
        while (cur<=right){
            if(arr[cur]>key&&++prev!=cur)
                swap(arr,cur,prev);
            cur++;
        }
        swap(arr,prev,left);
        return prev;
    }

    public static void main(String[] args) {
        int[] arr={1,3,5,2,2,6};
        Finder f=new Finder();
        System.out.println(f.findKth(arr, 6, 2));
    }
}
