//上楼梯
public class ClimbTheStairs {
    public static int countWays(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        if (n == 0 || n == 1 || n == 2 || n == 3) {
            return dp[n];
        }
        /*
            取模运算有这样一个性质：(a+b)%c = ((a%c)+(b%c))%c
            所以(a[i-1]+a[i-2])%1000000007就相当于(a[i-1]%X+a[i-2]%X)%X
            用X代替1000000007
            这样就使得a[i-1]、a[i-2]、a[i-1]+a[i-2]都没有溢出
            之后再与a[i-3]相加之后取模，使得全部结果没有溢出。
         */
            for (int i = 4; i <= n; i++) {
                dp[i] = ((dp[i - 1] + dp[i - 2]) % 1000000007 + dp[i - 3]) % 1000000007;
            }
            return dp[n];
    }

        public static void main (String[]args){
            int n = 4;
            System.out.println(countWays(n));
        }
    }
