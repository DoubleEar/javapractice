//股票的最大利润
public class MaxProfit {
    public static int maxProfit(int[] prices) {
        if(prices==null|| prices.length<2)
            return 0;
        int min=prices[0];
        int maxDiff=prices[1]-min;

        for(int i=2;i<prices.length;i++){
            if(prices[i-1]<min)
                min=prices[i-1];    //记住在i-1之前数字中的最小值

            int curDiff=prices[i]-min;
            if(curDiff>maxDiff)
                maxDiff=curDiff;
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
