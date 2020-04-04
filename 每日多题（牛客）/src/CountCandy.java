import java.util.Scanner;
//计算糖果ABC的个数
//已知A-B B-C A+B B+C的值
public class CountCandy {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            String s=sc.nextLine();
            String[] str=s.split(" ");
            int len=str.length;
            int[] nums=new int[len];
            int index=0;
            while (index<len){
                nums[index]=Integer.valueOf(str[index]);
                index++;
            }
            //判断2倍的A，B是否为奇数或者负数
            if((nums[0]+nums[2])%2!=0||(nums[0]+nums[2])<0
                    ||(nums[1]+nums[3])%2!=0||(nums[1]+nums[3])<0){
                System.out.println("No");
                break;
            }
            int A=(nums[0]+nums[2])/2;
            int B=(nums[1]+nums[3])/2;
            if(nums[3]<B){
                System.out.println("No");
                break;
            }
            int C=nums[3]-B;
            System.out.println(A+" "+B+" "+C);
        }
    }
}
