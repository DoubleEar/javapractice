public class MoreThanHalf {
    //数组中出现次数超过一半的数字
    private static void quickSort(int[] arr,int left,int right){
        if(left<right){
            int mid=partition(arr,left,right);
            quickSort(arr,left,mid);
            quickSort(arr,mid+1,right);
        }
    }

    private static int partition(int[] arr,int left,int right){
        int start=left;
        int key=arr[left];
        while (left<right) {
            while (left < right && arr[right] >= key)
                right--;
            while (left < right && arr[left] <= key)
                left++;

            swap(arr, left, right);
        }
        swap(arr,start,left);
        return left;
    }

    private static void swap(int[] arr,int left,int right){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }

    public static int MoreThanHalfNum(int [] array) {
        int len=array.length;
        quickSort(array,0,len-1);
        int n=array[len/2]; //找到数组中出现次数最多的数
        int count=0;
        for(int cur:array){ //判断有没有超过数组个数的一半
            if(cur==n)
                count++;
        }
        return count>len/2?n:0;
    }

    public static void main(String[] args) {
        int[] arr={1,2,1,1,3,1};
        System.out.println(MoreThanHalfNum(arr));
    }
}
