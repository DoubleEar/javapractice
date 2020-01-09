//原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
//拷贝赋值
public class Remove_Element {
    public static int removeElement(int[] nums, int val) {
        int a=0;
        for(int num:nums){
            if(num!=val){
                nums[a]=num;
                a++;
            }
        }
        return a;
    }
}
