//把数字翻译成字符串
public class TranslateNum {
    /*
        状态定义：dp[i]代表以i为结尾的数字的翻译方案数量。
        转移方程：（1）i-1和i-2可以被翻译成一组  dp[i]=dp[i−1]+dp[i−2]
                  （2）不能翻译为一组 dp[i]=dp[i−1]
        两个数字可以被翻译的为一组的区间为[10,25]。
     */
    public static int translateNum(int num) {
        String s=String.valueOf(num);   //为了方便获取每一位数字。
        int[] dp=new int[s.length()+1];
        dp[0]=1;    //当有2个数字时，会遍历到dp[0]。
        dp[1]=1;    //当有1个数字时，只有一种转换方法。

        for(int i=2;i<=s.length();i++){
            String temp=s.substring(i-2,i);
            //判断两个数字是否可以一起转换
            if(temp.compareTo("10")>=0&&temp.compareTo("25")<=0)
                dp[i]=dp[i-1]+dp[i-2];
            else
                dp[i]=dp[i-1];
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(translateNum(12258));
    }
}
