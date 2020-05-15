//风口的猪—中国牛市
public class CalculateMax {
    /**
     * 计算你能获得的最大收益
     *
     * @param prices Prices[i]即第i天的股价
     * @return 整型
     */
    public static int calculateMax(int[] prices) {
        int len=prices.length;
        if(len<2)
            return 0;

        // dp[0]：什么都不操作
        // dp[1]：第 1 次买入一支股票
        // dp[2]：第 1 次卖出一支股票
        // dp[3]：第 2 次买入一支股票
        // dp[4]：第 2 次卖出一支股票
        int[] dp=new int[5];
        dp[1]=-prices[0];   //假定从第一支股票买起
        dp[3]=Integer.MIN_VALUE;    //状态3，必须等状态1，2发生才能发生。
        for(int i=1;i<len;i++){
            dp[0]=0;
            //第一次买入时的利润
            dp[1]=Math.max(dp[1],dp[0]-prices[i]);
            //第一次卖出时的利润
            dp[2]=Math.max(dp[2],dp[1]+prices[i]);
            //第二次买入时的利润
            dp[3]=Math.max(dp[3],dp[2]-prices[i]);
            //第二次卖出时的利润
            dp[4]=Math.max(dp[4],dp[3]+prices[i]);
        }
        return dp[4];

        /*
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;

        for (int curPrice : prices) {
            firstBuy = Math.max(firstBuy, -curPrice);
            firstSell = Math.max(firstSell, firstBuy + curPrice);
            secondBuy = Math.max(secondBuy,firstSell - curPrice);
            secondSell = Math.max(secondSell, secondBuy + curPrice);
        }
        return secondSell;
        */
    }

    public static void main(String[] args) {
        int[] n={3,3,5,0,0,3,1,4};
        System.out.println(calculateMax(n));
    }
}
