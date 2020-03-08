import java.util.Arrays;

//给定不同面额的硬币 coins 和一个总金额 amount。
// 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
public class CoinChange {
    static int res=Integer.MAX_VALUE;
    public static int coinChange(int[] coins, int amount) {
        //先对硬币进行排序
        Arrays.sort(coins);
        //从最大面值的硬币开始统计
        find(coins,coins.length-1,amount,0);
        return res==Integer.MAX_VALUE?-1:res;
    }

    private static void find(int[] coins, int index, int amount, int count) {
        if(index<0)
            return;
        //总钱数除当前硬币面值，表示最多可以包含几个这样面值的硬币
        for(int i=amount/coins[index];i>=0;i--){
            //剩余的金额
            int remain=amount-coins[index]*i;
            //计数，计算硬币的个数
            int newCount=count+i;
            //如果没有剩余面值了（amount==0）
            if(remain==0) {
                res = Math.min(newCount, res);
                break;
            }
            //至少还要使用1枚硬币，需要的硬币面值一定比当前硬币面值小
            if(newCount+1>=res)
                break;
            //继续向前遍历
            find(coins,index-1,remain,newCount);
        }
    }

    public static void main(String[] args) {
        int[] coins={1,3,5};
        System.out.println(coinChange(coins,11));
    }
}
