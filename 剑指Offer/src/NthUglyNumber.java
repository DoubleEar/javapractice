//丑数
//我们把只包含质因子 2、3 和 5 的数称作丑数。求按从小到大的顺序的第 n 个丑数。
public class NthUglyNumber {
    /*
        丑数只包含因子2，3，5（丑数只能被2，3，5整除），因此有：丑数=某较小丑数*某因子。（10=2*5）
        Xa为首个乘以2后大于Xn的丑数     Xb为首个乘以3后大于Xn的丑数    Xc为首个乘以5后大于Xn的丑数
        下一个丑数Xn+1=Math.min(Xa*2,Xb*3,Xc*5)。
     */
    public static int nthUglyNumber(int n) {
        int a=0,b=0,c=0;    //先设置a,b,c，指向第一个丑数1。
                            // a指向*2的得到的丑数的某一个下标。
                            // b指向*3的得到的丑数的某一个下标。
                            // c指向*5的得到的丑数的某一个下标。
        int[] dp=new int[n];
        dp[0]=1;

        for(int i=1;i<n;i++){
            int n2=dp[a]*2,n3=dp[b]*3,n5=dp[c]*5;
            dp[i]=Math.min(Math.min(n2,n3),n5);
            //独立判断dp[i]与dp[a]*2,dp[b]*3,dp[c]*5的大小关系，更新索引。
            //若相等，对应的索引加1。
            if(dp[i]==n2)   //每次生成新的丑数n2，更新a。
                a++;
            if (dp[i]==n3)  //每次生成新的丑数n3，更新b。
                b++;
            if(dp[i]==n5)   //每次生成新的丑数n4，更新c。
                c++;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(9));
    }
}
