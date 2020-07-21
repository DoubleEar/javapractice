import java.util.HashMap;
import java.util.Map;
//数组中数字出现的次数 II
public class SingleNumberII {
    /*
    //方法一：哈希表
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(int num:nums){
            if(map.get(num)==1)
                return num;
        }
        return -1;
    }
    */

    public static int singleNumber(int[] nums) {
        int[] bitNum=new int[32];
        for(int num:nums){
            for(int i=0;i<32;i++){  //存储顺序是由低位到高位
                bitNum[i]+=num&1;
                num>>>=1;    //无符号右移一位
            }
        }

        int res=0,m=3;
        //利用左移操作和或运算,可将bitNum数组中各二进位的值恢复到数字res 上。
        for(int i=0;i<32;i++){  //从高位开始遍历
            res <<=1;
            res|=bitNum[31-i]%m;    //出现3次相同的数，那么二进制表示的每一位相加都可以被3整除。
                                    // | ->只要余数不是0，那么表示只出现一次的数二进制对应的那一位为1。
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={3,15,3,3};
        System.out.println(singleNumber(nums));
    }
}
