// 数值的整数次方
//a^n   n为偶数：a^(n/2)*a^(n/2)
//      n为奇数:a^((n-1)/2)*a^((n-1)/2)*a
public class MyPow {
    public static double myPow(double x, int n) {
        long num = n;
        return pow(x,num);
    }
    public static double pow(double x,long n) {
        if (n == 0) {
            return 1;// 假定0的0次方也为1
        }
        if(n == 1) {
            return x;
        }
        if(n > 1) {
            double result = pow(x,n>>1);// x>>1就是exp/2，但是位运算效率更高
            result = result * result;
            if((n % 2) == 1) {// n & 1 可以判断奇偶，=1为奇数，比%效率更高
                result = result * x;
            }
            return result;
        }
        if(n < 0) {
            n = -n;
            double result = pow(x,n);
            return 1/result;
        }
        throw new IllegalArgumentException("出现异常！");
    }
    public static void main(String[] args) {
        System.out.println(myPow(0.00001,2147483647));
    }
}
