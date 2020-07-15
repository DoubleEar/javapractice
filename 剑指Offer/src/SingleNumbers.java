import java.util.Arrays;
//数组中数字出现的次数
public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        int res=0;
        //将数组中的所有数都异或，结果就是两个只出现一次的数的异或结果。
        for(int i=0;i<nums.length;i++){
            res^=nums[i];
        }

        int indexOf1=findFirstBitIs1(res);  //找到res中第一个是1的位置

        int a=0,b=0;
        for(int i=0;i<nums.length;i++){     //将nums中的所有数分为两个数组，再进行异或。
            if(isBit1(nums[i],indexOf1))
                a^=nums[i];
            else
                b^=nums[i];
        }

        return new int[]{a,b};  //返回两个数组异或后的结果
    }

    private boolean isBit1(int num, int indexOf1) {     //用indexOf1这位是不是1，来将nums分为两个数组。
        num=num>>indexOf1;
        return (num&1)==1;
    }

    private int findFirstBitIs1(int num) {  //两个不同的数异或后的结果中为1的位置，之前一定不同。
                                            //因此可以将两个只出现一次的数通过这一位分开。
        int indexBit=0;
        while ((num&1)==0){
            num=num>>1;
            indexBit++;
        }
        return indexBit;
    }

    public static void main(String[] args) {
        SingleNumbers sn=new SingleNumbers();
        int[] nums={2,4,3,6,3,2,5,5};
        System.out.println(Arrays.toString(sn.singleNumbers(nums)));
    }
}
