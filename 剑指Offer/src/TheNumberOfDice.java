//骰子的点数
public class TheNumberOfDice {
    //我们可以把n个骰子的点数分解为n-1个骰子的点数加上一个骰子的点数。
    public static double[] twoSum(int n) {
        double pre[]={1/6d,1/6d,1/6d,1/6d,1/6d,1/6d};   //初始化数据，一个骰子的和只能是1~6。
        for(int i=2;i<=n;i++){
            double tmp[]=new double[5*i+1]; //构建n个骰子能构成的所有和的数组
            for(int j=0;j<pre.length;j++)   //拿上一次计算的结果的点数 和 1~6每一个点数都相加，算出概率
                for(int x=0;x<6;x++)
                    //使得n-1点数概率数组和分解出的骰子点数概率数组元素两两相乘，并将乘积结果加到n点数概率数组上。
                    tmp[j+x]+=pre[j]/6;
            pre=tmp;    //pre[]为n-1个骰子的点数概率数组，更新prev。
        }
        return pre;
    }

    public static void main(String[] args) {
        System.out.println(twoSum(2));
    }
}
