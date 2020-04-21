//找到微信红包金额超过一半的金额。
// 若没有金额超过总数的一半，返回0。
public class RedPacket {
    private static void swap(int[] arr,int left,int right){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }

    private static void quickSort(int[] arr,int left,int right){
        if(left<right){
            int mid=partition(arr,left,right);
            quickSort(arr,left,mid-1);
            quickSort(arr,mid+1,right);
        }
    }

    private static int partition(int[] arr, int left, int right){
        int key=arr[left];
        int start=left;
        while (left<right){
            while (left<right&&arr[right]>=key)
                right--;
            while (left<right&&arr[left]<=key)
                left++;
            swap(arr,left,right);
        }
        swap(arr,start,left);
        return left;
    }

    public static int getValue(int[] gifts, int n) {
        quickSort(gifts,0,n-1);
        int res=gifts[n/2];//目标金额
        int count=0;
        for(int i=0;i<n;i++){
            if(gifts[i]==res)
                count++;
        }
        return count<=n/2?0:res;
    }

    public static void main(String[] args) {
        int[] gifts={1,4,5,4,3,4,1,4,2,4};
        System.out.println(getValue(gifts,10));
    }
}
