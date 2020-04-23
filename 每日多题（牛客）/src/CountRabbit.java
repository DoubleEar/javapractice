import java.util.Scanner;
//有一只兔子，从出生后第3个月起每个月都生一只兔子
// 小兔子长到第三个月后每个月又生一只兔子
// 假如兔子都不死，问每个月的兔子总数为多少？

public class CountRabbit {
    //斐波那契数变形
    private static int getTotalNumber(int n){
        /*
        if(n==1||n==2)
            return 1;
        if(n==3)
            return 2;
        //返回上一个月兔子总数以及到本月能生的兔子数之和。
        return getTotalNumber(n-1)+getTotalNumber(n-2);
        */

        if(n==1||n==2)
            return 1;
        if(n==3)
            return 2;
        int[] dp=new int[n];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;

        for(int i=2;i<n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int n=sc.nextInt();
            System.out.println(getTotalNumber(n));
        }
    }
}
