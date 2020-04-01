//求第N个斐波那契数。
public class Fib {
    public static int fib(int n){
        //非递归
        /*
        if(n<=0)
            return 0;
        if(n==1)
            return 1;
        int fibOne=0;
        int fibTwo=1;
        int fibN=0;

        for(int i=2;i<=n;i++){
            fibN=fibOne+fibTwo;

            fibOne=fibTwo;
            fibTwo=fibN%1000000007;
        }
        return fibTwo;
        */

        if(n<=0)
            return 0;
        if(n==1)
            return 1;
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2])%1000000007;
        }
        return dp[n];

        /*
        //递归
        if(n<=0)
            return 0;
        if(n==1)
            return 1;
        return fib(n-1)+fib(n-2);
        */
    }

    public static void main(String[] args) {
        System.out.println(fib(45));
    }
}
