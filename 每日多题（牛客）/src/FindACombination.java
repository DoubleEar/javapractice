import java.util.Scanner;
//找到数组中加上1~top某一个数的和大于数组中最大值的组合
//组合为数组中的某个数+最小的增加数
public class FindACombination {
    private static void calculateRes(int top,int[] nums,int max){
        int[] add=new int[top+1];
        for(int a=0;a<=top;a++){
            add[a]=a;
        }
        for(int i=0;i<nums.length;i++){
            for(int j=1;j<add.length;j++){
                if(nums[i]+add[j]>max) {
                    System.out.println(nums[i] + " " + add[j]);
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int top=sc.nextInt();
            int n=sc.nextInt();
            int[] nums=new int[n];
            int max=0;
            for(int i=0;i<n;i++){
                nums[i]=sc.nextInt();
                if(nums[i]>max)
                    max=nums[i];
            }

            calculateRes(top,nums,max);
        }
    }
}
