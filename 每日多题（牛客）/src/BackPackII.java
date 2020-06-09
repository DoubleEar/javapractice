//背包问题
//有 n 个物品和一个大小为 m 的背包。给定数组 A 表示每个物品的大小和数组 V 表示每个物品的价值。
//问多能装入背包的总价值是多大？
public class BackPackII {
    // 状态：F(i, j): 前i个物品放入大小为j的背包中所获得的大价值
    //1.装不下
    //2.能装下
    //  （1）选择放  （2）选择不放

    /*
    public static int backPackII(int m, int[] A, int[] V) {
        int n=A.length;
        if(m==0||n==0)
            return 0;

        int[][] maxValue=new int[n+1][m+1];

        //初始化0行0列：第0行和第0列都为0，表示没有装物品时的价值都为0
        for(int i=0;i<=n;i++){
            maxValue[i][0]=0;
        }
        for(int i=0;i<=m;i++){
            maxValue[0][i]=0;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(A[i-1]>j){
                    //装不下：此时的价值与前i-1个的价值是一样的。
                    maxValue[i][j]=maxValue[i-1][j];
                }else{
                    // 如果可以装入：需要在两种选择中找大的
                    // F(i, j) = max{F(i-1,j), F(i-1, j - A[i]) + V[i]}
                    int newValue=maxValue[i-1][j-A[i-1]]+V[i-1];
                    maxValue[i][j]=Math.max(newValue,maxValue[i-1][j]);
                }
            }
        }
        return maxValue[n][m];
    }
    */
    public static int backPackII(int m, int[] A, int[] V) {
        //如果是一维向量，需要从后向前计算
        // 因为后面的元素更新需要依靠前面的元素未更新（模拟二维矩阵的上一行的 值）的值
        int n = A.length;
        if (m == 0 || n == 0)
            return 0;

        //多加一列，用于设置初始条件，因为第一件商品要用到前面的初始值
        int[] maxValue = new int[m + 1];
        //初始化所有位置为0，第一行都为0，初始条件
        for (int i = 0; i <= m; i++) {
            maxValue[i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = m; j > 0; j--) {
                //如果第i个商品大于j,说明放不下， 所以(i,j)的价值和(i-1,j)相同                
                // 如果可以装下，分两种情况，装或者不装
                // 如果不装，则即为(i-1, j)
                // 如果装，需要腾出放第i个物品大小的空间
                // j - A[i],装入之后的价值即为(i - 1, j - A[i-1]) + 第i个商品的价值V[i]                //后在装与不装中选出大的价值
                if (A[i - 1] <= j) {
                    int newValue = maxValue[j - A[i - 1]] + V[i - 1];
                    maxValue[j] = Math.max(newValue, maxValue[j]);
                }
            }
        }
        return maxValue[m];
    }

    public static void main(String[] args) {
        int m=4;
        int[] A={1,3,3};
        int[] V={1,4,5};
        System.out.println(backPackII(m, A, V));
    }
}
