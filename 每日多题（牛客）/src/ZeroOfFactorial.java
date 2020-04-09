import java.util.Scanner;
//计算n！结果中末尾包含几个0。
public class ZeroOfFactorial {
    /*
    //求n的阶乘。
    private static int NFactorial(int n){
        if(n<=2)
            return n;
        return n*NFactorial(n-1);
    }
    */

    /* 能被5整除的数的特征是：个位上是0或5的数。
       能被2整除的数的特征是个位上是：0,2,4,6,8的数。
       所以能同时被2和5整除的数的特征：个位数字一定只能是0。
       末尾0的个数就是指这个数总共有几个10因子，而10又能表示成2和5的乘积。
       假设m=n!，那么m中2的因子个数肯定大于5的因子个数(求有几个成对的2*5，由个数少的决定)
       所以m中5的因子个数即是所要求结果->计算n中包含几个5即可。
    */
    private static int countZero(int n){
        int count=0;
        while (n!=0){
            count+=n/5;
            n/=5;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int n=sc.nextInt();
            System.out.println(countZero(n));
        }
    }
}
