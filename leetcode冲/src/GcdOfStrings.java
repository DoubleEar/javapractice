//字符串的最大公因子
public class GcdOfStrings {
    public static String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1))
            return "";
        //截取字符串的部分内容
        return str1.substring(0,god(str1.length(),str2.length()));
    }

    //利用辗转相除法求最大公因数。传入字符串的长度
    private static int god(int a, int b) {
        return b==0?a:god(b,a%b);
    }

    public static void main(String[] args) {
        String s1="ABCABC";
        String s2="ABC";
        System.out.println(gcdOfStrings(s1,s2));
    }
}
