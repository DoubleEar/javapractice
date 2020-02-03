//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
public class Reverse {
    public static int reverse(int x) {
        /*int a;
        long b = 0;
        while (x != 0) {
            a = x % 10;
            x = x / 10;
            b = b*10 + a;
        }
        if(b > Integer.MAX_VALUE || b < Integer.MIN_VALUE) {
            return 0;
        }
        return  (int)b;
    }
    */
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
    public static void main(String[] args) {
        int x=-321;
        System.out.println(reverse(x));
    }
}
