import java.util.Scanner;
//买苹果
public class BuyApple {
    private static int MethodCount(int n) {
        /*
        if (n % 6 == 0 && n % 8 == 0)
            return n / 8;
        else if (n % 2 == 0) {
            int a = n / 8;
            for (int i = a; i >=0; i--) {
                int res=n-(i * 8);
                if (res%6 == 0)
                    return i +res/6;
            }
            return -1;
        }else
            return -1;
            */
        if(n%2!=0||n==10||n<6)
            return -1;
        if(n%8==0)
            return n/8;
        ///对于10以上的偶数，只要对8取余数不为0，就要从前面的1或者2个8中拿出2个
        //因为余数是2或者4或者6。
        //如果余数是2，就从前两个8的代数中各取两个，使得余数为6.
        //如果余数是4，就从前一个8的代数中取两个，使得余数为6.
        //如果余数为6就正好。
        return 1+n/8;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int n=sc.nextInt();
            System.out.println(MethodCount(n));
        }
    }
}
