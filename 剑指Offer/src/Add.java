//不用加减乘除做加法
public class Add {
    public static int add(int a, int b) {
        int sum,carry;
        while (b!=0){
            sum=a^b;           //非进位的和
            carry=(a&b)<<1;    //进位
            a=sum;
            b=carry;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(add(2,3));
    }
}
