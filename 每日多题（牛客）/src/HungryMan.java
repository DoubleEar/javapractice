import java.util.Scanner;
//饥饿的小易
public class HungryMan {
    /*思路：
      小易的移动方程
      f(x) = 4 * x + 3;
      g(x) = 8 * x + 7;

      计算可以得出规律：
      1.g(f(x)) = f(g(x))
      2.f(f(f(x))) = g(g(x)) 也就是三次f(x) = 两次g(x)

      有规律1 所以可以存在：ffggfggff = fffffgggg
      有规律2 所以可以存在：fffffgggg = ffgggggg

      可以得出一个最有策略：f的执行次数为0,1,2。-> x,4*x + 3,4(4*x+3) + 3
      在f的执行基础上求最小g的执行次数
     */

    private static long findShell(long n,long[] res,long m){
        //f(x)的三种执行结果
        res[0] = n;
        res[1] = (4*res[0] + 3) % m;
        res[2] = (4*res[1] + 3) % m;

        int minStep = 100000;
        long cur;
        int step;//执行的步数
        for (int i = 0; i < 3; i++){
            cur = res[i];
            step = i;
            while (cur != 0 && step < minStep){
                cur = (8 * cur + 7) % m;//执行g(x) 取模为零证明找到贝壳
                step++;
            }
            minStep = minStep < step ? minStep : step;
        }
        return minStep<100000? minStep :-1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            long n=sc.nextLong();
            int m = 1000000007;//可以被%的数
            long[] res = new long[3];

            System.out.println(findShell(n,res,m));
        }
    }
}
