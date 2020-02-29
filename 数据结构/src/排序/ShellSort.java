package 排序;

//希尔排序
public class ShellSort {
    public static void shellSort(int[] nums){
        //对数据进行分组
        //每组数据进行插入排序：逻辑分组
        //同一组数据他们之间的间隔不一定为1
        int gap=nums.length;
        //当gap等于1时说明已经排好序
        while (gap>1){
            //可以除3也可以除2，加1避免gap为0的情况漏掉最后一次插入排序,所以加1
            gap=gap/3+1;
            //i表示排好序的最后一个
            for(int i=0;i<nums.length-gap;i++){
                int end=i;
                int key=nums[end+gap];
                while (end>=0&&nums[end]>key){
                    nums[end+gap]=nums[end];
                    end-=gap;
                }
                nums[end+gap]=key;
            }
        }
    }
}
