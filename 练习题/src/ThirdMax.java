import java.util.TreeSet;

//给定一个非空数组，返回此数组中第三大的数。
// 如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
public class ThirdMax {
    public static int thirdMax(int[] nums) {
        if(nums==null||nums.length==0){
            throw new RuntimeException();
        }
        TreeSet<Integer> set=new TreeSet<>();
        for(Integer elem:nums){
            set.add(elem);
            if(set.size()>3)
                //移除最小的元素
                set.remove(set.first());
        }
        //元素个数小于3就返回数值最大的否则返回最小的
        return set.size()<3?set.last():set.first();
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        System.out.println(thirdMax(nums));
    }
}
