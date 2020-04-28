import java.util.Scanner;
//数字之和
public class SumOfNumbers {
    private static void getSum(int n,int pow){
        int res=0;
        while (n!=0){
            res+=n%10;
            n/=10;
        }
        System.out.print(res+" ");
        res=0;
        while (pow!=0){
            res+=pow%10;
            pow/=10;
        }
        System.out.print(res);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int n=sc.nextInt();
            int pow= (int) Math.pow(n,2);
            getSum(n,pow);
        }
    }
}
