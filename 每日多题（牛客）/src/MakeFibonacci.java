import java.util.Scanner;
//输入一个数，输出能变为斐波那契数的最少步数。
public class MakeFibonacci {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int n=sc.nextInt();
            int fibOne=0;
            int fibTwo=1;
            int fib=0;
            //当当前的斐波那契数小于n时就继续循环。
            while (fib<n){
                fib=fibOne+fibTwo;
                fibOne=fibTwo;
                fibTwo=fib;
            }
            //判断n离前一个斐波那契数近还是后一个。
            System.out.println((n-fibOne)>(fibTwo-n)?fibTwo-n:n-fibOne);
        }
    }
}
