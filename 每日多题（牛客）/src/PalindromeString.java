import java.util.Scanner;
//回文串
//给定一个字符串，向字符串中加一个字符进去，看能否构成回文串。
public class PalindromeString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            String s=sc.nextLine();
            char[] c=s.toCharArray();
            int flag=0;
            //双指针法
            int left=0,right=c.length-1;
            while (left<=right){
                if(c[left]!=c[right]){  //当前后字符串不相等时
                    if(left<=right&&c[left+1]==c[right]){   //判断下一位和最后一位是否相等
                        left++;
                        flag++;
                    }else if(left<=right&&c[left]==c[right-1]){ //判断前一位和第一位是否相等
                        right--;
                        flag++;
                    }else{
                        //如果还不相等，说明至少加两个字符才能构成回文串
                        flag+=2;
                        break;
                    }
                }else{
                    left++;
                    right--;
                }
            }
            if(flag>=2){    //判断
                System.out.println("No");
            }else{
                System.out.println("Yes");
            }
        }
    }
}
