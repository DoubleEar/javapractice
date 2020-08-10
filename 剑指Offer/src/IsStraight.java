import java.util.Arrays;

//扑克牌中的顺子
public class IsStraight {
    /*
    public static boolean isStraight(int[] nums) {
        //将大小王看作是0
        HashSet<Integer> repeat=new HashSet<>();
        int max=0,min=14;
        for(int num:nums){
            if(num==0)      //如果遇到0就跳过
                continue;
            max=Math.max(num,max);
            min=Math.min(num,min);
            if(!repeat.contains(num))   //出现重复就返回false
                return false;
            repeat.add(num);
        }
        return max-min<5;   //最大值和最小值的之间的差最大为4
    }
    */

    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==0)
                count++;
            else if(nums[i]==nums[i+1])
                return false;
        }
        return nums[nums.length-1]-nums[count]<5;   //nums[count]所代表的是，数组中出去大小王最小的值
    }

    public static void main(String[] args) {
        int[] nums={1,1,0,3,5};
        System.out.println(isStraight(nums));
    }
}
