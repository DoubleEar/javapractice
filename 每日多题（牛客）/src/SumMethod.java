import java.util.Scanner;

//数字和为sum的方法数
public class SumMethod {
    //0 1背包问题
    private static long countMethod(int n,int sum,int[] nums){
        long[] res=new long[sum+1];
        res[0]=1;   //当sum为0时：放入背包的方法一种 —> 不放入。
        for(int i=0;i<n;i++){
            for(int j=sum;j>=nums[i];j--){  //背包容量小于当前重量时，不能放入。
                //res[j]:与nums[i]相加等于res[j]的放入背包的方法+当前放入背包的方法
                res[j]=res[j-nums[i]]+res[j];
            }
        }
        return res[sum];
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int sum=sc.nextInt();
            int[] nums=new int[n];
            for(int i=0;i<n;i++){
                nums[i]=sc.nextInt();
            }
            System.out.println(countMethod(n, sum, nums));
        }
    }
}
