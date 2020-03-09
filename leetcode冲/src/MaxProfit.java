//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//计算买股票的最大利润，注意你不能在买入股票前卖出股票。
public class MaxProfit {
    public static int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;
        int i=prices[0];
        int maxProfit=0;
        for(int j=1;j<prices.length;j++){
            if(prices[j]>i){
                maxProfit=Math.max(maxProfit,prices[j]-i);
            }else
                i=prices[j];
        }
        return maxProfit;
        /*
        int maxProfit=0;
        for(int i=0;i<prices.length-1;i++){
            for(int j=1;j<prices.length;j++){
                if(prices[j]>prices[i])
                    maxProfit=Math.max(maxProfit,prices[j]-prices[i]);
            }
        }
        return maxProfit;
         */
    }


    public static void main(String[] args) {
        int[] prices={2,4,1,3,6,4,8};
        System.out.println(maxProfit(prices));
    }
}
