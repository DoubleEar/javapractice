//数组中的逆序对
public class ReversePairs {
    public static int count=0;
    public static int reversePairs(int[] nums) {
        int len=nums.length;
        if(nums==null||len==0)
            return 0;
        mergeSort(nums,0,len-1);

        return count;
    }

    //分组
    private static void mergeSort(int[] nums,int left, int right) {
        if(left>=right)
            return;
        int mid=(left+right)/2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);

        //合并两个数组的前提是两个数组有序
        mergeInternal(nums,left,mid,right);
    }

    //归并排序并计算逆序对
    private static void mergeInternal(int[] nums,int left, int mid, int right) {
        int[] temp=new int[right-left+1];
        int index=0;
        int i=left;     //指向第一个数组的第一个元素
        int j=mid+1;    //指向第二个数组的第一个元素

        while (i<=mid&&j<=right){
            if(nums[i]<=nums[j])
                temp[index++]=nums[i++];
            else {
                //第一个数组中的某一个元素大于第二个数组中的某一元素，说明第一个数组中
                //该元素到数组最后一个元素都大于第二个数组中的某一元素。
                count+=mid-i+1;
                temp[index++]=nums[j++];
            }
        }

        //增加剩余元素到temp
        while (i<=mid)
            temp[index++]=nums[i++];
        while (j<=right)
            temp[index++]=nums[j++];

        //更新nums当前的排序
        for (int k = 0; k < temp.length; k++) {
            nums[left++] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] nums={7,5,6,4};
        System.out.println(reversePairs(nums));
    }
}
