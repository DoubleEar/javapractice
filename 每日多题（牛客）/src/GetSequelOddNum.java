import java.util.Scanner;
//给定一个整数 输出它的三次方 由相邻的奇数相加得来
/*
    1^3=1;
    2^3=3+5;
    3^3=7+9+11
 */
public class GetSequelOddNum {
    private static void getSequelOddNum(int n){
        int a=n*(n-1)+1;//计算开始的内个奇数
        System.out.print(a);
        for(int i=1;i<n;i++){
            System.out.print("+"+(a+=2));
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int n=sc.nextInt();
            getSequelOddNum(n);
        }
    }
}
