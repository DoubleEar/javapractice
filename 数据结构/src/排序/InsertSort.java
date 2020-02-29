package 排序;

//直接插入排序
public class InsertSort {
    public static void insertSort(int[] nums){
        //开始认为第零个元素是排好序的
        for(int i=0;i<nums.length-1;i++){
            int key=nums[i+1];
            //i表示已经排好序的最后一个位置
            int end=i;
            while (end>=0&&nums[end]>key){
                //把大的元素往后移动
                nums[end+1]=nums[end];
                //继续向前搜索
                end--;
            }
            //end:-1或者<=key的一个位置
            nums[end+1]=key;
        }
    }
    public static void insertSort2(int[] nums){
        // 有序区间: [0, i)
        // 无序区间: [i, array.length)
        for(int i=1;i<nums.length;i++){
            int key=nums[i];// 无序区间的第一个数
            int end=i-1;//已经排好序的最后一个位置
            while (end>=0&&nums[end]>key){
                nums[end+1]=nums[end];
                //继续向前搜索
                end--;
            }
            nums[end+1]=key;
        }
    }
}
