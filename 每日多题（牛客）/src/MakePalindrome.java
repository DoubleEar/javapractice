import java.util.Scanner;
//将字符串a插进字符串b中，判断新的字符串是否为回文字符串。
public class MakePalindrome {
    public static boolean isPalindrome(String s){
        int left=0,right=s.length()-1;
        while (left<right){
            if(s.charAt(left)!=s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String a=s.nextLine();
        String b=s.nextLine();
        int count=0;
        for(int i=0;i<=a.length();i++){
            StringBuilder sb=new StringBuilder(a);
            sb.insert(i,b);
            if(isPalindrome(sb.toString()))
                    count++;
            }
        System.out.println(count);
    }
}
