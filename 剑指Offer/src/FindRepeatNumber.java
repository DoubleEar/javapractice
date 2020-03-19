import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


//找出数组中重复的数字。
public class FindRepeatNumber {
    public static int findRepeatNumber(int[] nums) {
        int i=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

            if(map.get(nums[i])>1)
                break;
        }
        return nums[i];

        /*
        Set<Integer> set=new HashSet<>();
        int repeat=-1;
        for(int i:nums){
            if(!set.add(i)){
                repeat=i;
                break;
            }
        }
        return repeat;
        */
    }

    public static void main(String[] args) {
        int[] nums={1,6,8,9,3,1};
        System.out.println(findRepeatNumber(nums));
    }
}
