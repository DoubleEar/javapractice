//剪绳子
public class CuttingRope {
    /*
   //动态规划法：子问题最优解的集合
    public static int cuttingRope(int n) {
        if(n<2)
            return 0;
        if(n==2)
            return 1;
        if(n==3)
            return 2;
        int[] products=new int[n+1];
        //以下初始化的元素存放的不是最大值，而是长度值。
        //因为他们不切比切之后更大，后面进行*的时候也更大。
        //为什么初始化到3呢？因为3>1*2。4=2*2 5<2*3。
        products[0]=0;
        products[1]=1;
        products[2]=2;
        products[3]=3;
        //子问题的最优解存储在products数组中，数组中的第i个元素表示
        // 把长度为i的绳子剪成若干段后各段长度乘积的最大值。
        for(int i=4;i<=n;i++){
            int max=0;
            //求出各种相乘可能中的最大值就是f(n)的最优解
            for(int j=1;j<=i/2;j++){
                int product=products[j]*products[i-j];
                if(product>max)
                    max=product;
            }
            //得到f(i)的最优解
            products[i]=max;
        }
        return products[n];
    }
    */
    public static int cuttingRope(int n) {
        if(n<2)
            return 0;
        if(n==2)
            return 1;
        if(n==3)
            return 2;
        //尽可能多的剪去长度为3的绳子段
        int timesOfTree=n/3;
        //当剩下的绳子长度为4时，就减成2*2
        if(n-timesOfTree*3==1)
            timesOfTree-=1;
        int timesOfTwo=(n-timesOfTree*3)/2;

        //3的timesOfTree次方   2的timesOfTwo次方
        return (int)Math.pow(3,timesOfTree)*(int)Math.pow(2,timesOfTwo);
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope(10));
    }
}
