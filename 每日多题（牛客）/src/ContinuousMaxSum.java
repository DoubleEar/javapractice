import java.util.Scanner;
//连续最大和
//一个数组有 N 个元素，求连续子数组的最大和。
// 例如：[-1,2,1]，和最大的连续子数组为[2,1]，其和为 3
public class ContinuousMaxSum {
    private static int countMaxSum(int n,int[] res){
        int max=res[0];
        int sum=res[0];
        for(int i=1;i<n;i++){
            if(sum>0){
                sum+=res[i];
            }else{  //当前面累加的总和为负数的时候，把前面加的全部清零。重新计算
                sum=res[i];
            }
            //更新最大值
            if(sum>max)
                max=sum;
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int n=sc.nextInt();
            int[] res=new int[n];
            for(int i=0;i<n;i++){
                res[i]=sc.nextInt();
            }
            System.out.println(countMaxSum(n, res));
        }
    }
}
