package 排序;

//选择排序
public class SelectSort {
    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public static void selectSort(int[] nums){
        for(int i=nums.length-1;i>0;i--){
            //i表示未排序的最后位置
            int end=i;
            int maxValue=i;
            //从所有未排序元素中找到最大索引
            for(int j=end-1;j>=0;j--){
                if(nums[j]>nums[maxValue])
                    maxValue=j;
            }
            //将最大值放在无序序列的最后一个
            swap(nums,maxValue,end);
        }
    }


    //双向选择排序，选择小的放在最开始，选择大的放在最后
    public static void selectSort2(int[] nums){
        int begin=0;
        int end=nums.length-1;
        while(begin<end){
            int minIndex=begin;
            int maxIndex=end;
            //一个循环是一趟交换，要遍历[begin,end]所有的元素，符合条件就交换下标
            for(int i=begin;i<=end;i++){
                //最小值选最前面（保证稳定性）
                if(nums[i]<nums[minIndex])
                    minIndex=i;
                //最大值选最后面（保证稳定性）
                if(nums[i]>=nums[maxIndex])
                    maxIndex=i;
            }
            swap(nums,begin,minIndex);
            //如果最大值在起始位置。则经过上面的交换之后，最大值被移动到minIndex指向的位置
            if(maxIndex==begin){
                maxIndex=minIndex;
            }
            swap(nums,end,maxIndex);
            begin++;
            end--;
        }
    }
}
