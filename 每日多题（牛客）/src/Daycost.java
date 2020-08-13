//蜗牛到达井口所需天数
public class Daycost {
    /**
     * 蜗牛到达井口所需天数
     * @param len int整型 井深
     * @param m int整型 白天爬m米
     * @param n int整型 晚上滑下去n米
     * @return int整型
     */
    public static int daycost (int len, int m, int n) {
        int[] dp=new int[len];
        dp[0]=0;
        for(int i=1;i<len;i++){
            dp[i]=dp[i-1]+m;
            if(dp[i]<len)
                dp[i]-=n;
            else
              return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(daycost(10, 4, 3));
    }
}
