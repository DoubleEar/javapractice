import java.util.Scanner;
//求两个数的最小公倍数
public class LeastCommonMultiple {
    //用辗转相除法求两个数的最大公约数。
    private static int GCD(int x,int y){
        return x%y==0?y:GCD(y,x%y);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int res=GCD(a,b);
            int n=a*b;  //两个数的乘积等于L.C.M*G.C.D。
            System.out.println(n/res);
        }
    }
}
