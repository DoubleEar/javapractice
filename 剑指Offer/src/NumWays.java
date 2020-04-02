//青蛙跳台阶问题
public class NumWays {
    public static int numWays(int n) {
        /*
        if(n==0)
            return 1;
        if(n<=2)
            return n;
        int numOne=1;
        int numTwo=2;
        int numN=0;

        for(int i=3;i<=n;i++){
            numN=(numOne+numTwo)%1000000007;

            numOne=numTwo;
            numTwo=numN;
        }
        return numN;
        */

        if(n==0)
            return 1;
        if(n<=2)
            return n;
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2])%1000000007;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numWays(7));
    }
}
