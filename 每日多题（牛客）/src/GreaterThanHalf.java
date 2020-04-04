import java.util.Scanner;
//输出出现次数大于等于n/2的数。
//排序，如果该数占整个数组数的一般以上，那么排完序一定在中间。
public class GreaterThanHalf {
    private static void quickSort(int[] arr,int left,int right){
        if(left<right){
            int mid=partion(arr,left,right);
            quickSort(arr,left,mid-1);
            quickSort(arr,mid+1,right);
        }
    }
    private static int partion(int[] arr,int left,int right){
        //每次以第一个位置的值作为基准值，返回
        int key=arr[left];
        int start=left;
        while (left<right){
            while (left<right&&arr[right]>=key)
                right--;
            while (left<right&&arr[left]<=key)
                left++;
            swap(arr,left,right);
        }
        swap(arr,left,start);
        return left;
    }
    private static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            String s=sc.nextLine();
            String[] str=s.split(" ");
            int n=str.length;
            int[] nums=new int[n];
            int index=0;
            while (index<n){
                nums[index]=Integer.valueOf(str[index]);
                index++;
            }
            quickSort(nums,0,n-1);
            System.out.println(nums[n/2]);
        }
    }
}
