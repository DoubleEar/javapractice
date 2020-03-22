import java.util.Arrays;

//给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
//返回使  A 中的每个值都是唯一的 最少操作次数。
public class MinIncrementForUnique {
    public static int minIncrementForUnique(int[] A) {
        if (A.length<2)return 0;
        //排序
        Arrays.sort(A);
        int ans=0,curMax=A[0];
        //遍历
        for (int i = 1; i < A.length; i++) {
            //A[i]小于等于curMax,需要增加到大于curMax
            if (A[i]<=curMax){
                //增加curMax-A[i]次A[i]=curMax，要想唯一，必须多增加一次。
                ans+=curMax-A[i]+1;
                //将A[i]更新为当前调整后的值
                A[i]=curMax+1;
            }
            //更新curMax
            curMax=Math.max(curMax,A[i]);
        }
        return ans;

        /*
        int[] count = new int[40000];
        int max = 0;
        for (int a : A) {
            count[a]++; // 计数
            max = Math.max(max, a); // 计算数组中的最大值
        }

        int res = 0;
        for (int j = 0; j < max; j++) {
            if (count[j] > 1) {
                // 有 count[j] - 1 个数需要增加
                res += count[j] - 1;
                count[j+1] += count[j] - 1;
            }
        }

        // count[max] 单独计算，是因为可能超出 40000 的边界
        if (count[max] > 1) {
            int d = count[max] - 1;
            // 有 d 个数需要增加
            // 分别增加为 max + 1, max + 2, ... max + d
            // 使用等差数列公式求和
            res += (1 + d) * d / 2;
        }

        return res;
        */
    }

    public static void main(String[] args) {
        int[] A={1,3,2,3,2,4};
        System.out.println(minIncrementForUnique(A));
    }
}
