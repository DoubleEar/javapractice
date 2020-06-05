import java.util.Scanner;
//输入一个数，输出能变为斐波那契数的最少步数。
public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            int fibOne=0;
            int fibTwo=1;
            int fibCur=0;
            //当当前的斐波那契数小于n时就继续循环。
            while (fibCur<n){
                fibCur=fibOne+fibTwo;
                fibOne=fibTwo;
                fibTwo=fibCur;
            }
            //判断n离前一个斐波那契数近还是后一个。
            int a=n-fibOne;
            int b=fibTwo-n;
            if(a>b){
                System.out.println(b);
            }else{
                System.out.println(a);
            }
        }
    }
}
