//统计二进制中1的个数
public class HammingWeight {
    public static int hammingWeight(int n) {
        /*
        方法一：让n不断的右移，最后一位与1&，如果是1，&的结果也一定是1。
        为避免负数造成死循环的情况，要无符号右移。
        int count=0;
        while (n!=0) {
            if ((n & 1) == 1)
                count++;
            n = n >>> 1;
        }
        return count;
        */

        //方法二：n为101010000
        //      n-1为101001111   每&一次就会消除n中的一个1，直到n为0。
        int res=0;
        while (n!=0){
            res++;
            n&=(n-1);
        }
        return res;
    }


    /*
    判断一个数是否是2的整数次方。->如果是，那么二进制表示中有且仅有一个1。
    if（n&（n-1）==0）{return true;}

    输入两个整数m，n。计算需要改变m的二进制中的多少位才能得到n。
    ->（1）将这两个数异或，不同的为1。（2）统计异或结果中有多少个1。
    int res=m^n;    int count=0;
    while(res!=0){  count++;    res&=(res-1);}  return count;
     */
    public static void main(String[] args) {
        System.out.println(hammingWeight(0000000000000000000000000001011));
    }
}
