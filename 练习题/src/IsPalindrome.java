//判断一个整数是否为回文数
//先将整数转置再与原数比较
public class IsPalindrome {
    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int cur=0;
        int num=x;
        while(num!=0){
            cur=cur*10+num%10;
            num=num/10;
        }
        return cur==x;
    }

    public static void main(String[] args) {
        int x=1234;
        int y=1221;
        System.out.println(isPalindrome(x));
        System.out.println(isPalindrome(y));
    }
}
