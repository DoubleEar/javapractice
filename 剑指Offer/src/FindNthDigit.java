//数字序列中某一位的数字
//数字以0123456789101112131415…的格式序列化到一个字符序列中。
// 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
//求出第n位对应的数字
public class FindNthDigit {
    public static int findNthDigit(int n) {
        int digit=1;    //从一位数开始
        long start=1;   //防止数字过大
        long count=9;

        while (n>count){    //确定n所在数字的位数，记为digit。
            n-=count;
            digit+=1;
            start*=10;
            count=start*digit*9;
        }

        long num=start+(n-1)/digit;     //确定n所在的数字
        int d=(n-1)%digit;      //确定n是num中的哪一位

        return Long.toString(num).charAt(d)-'0';
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(1000000000));
    }
}
