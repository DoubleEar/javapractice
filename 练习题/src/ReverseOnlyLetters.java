import java.util.Arrays;

//给定一个字符串 S，返回 “反转后的” 字符串，
// 其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
public class ReverseOnlyLetters {
    public static String reverseOnlyLetters(String S) {
        char[] arr=S.toCharArray();
        int start=0;
        int end=S.length()-1;
        /*while(start < end){
            //当第一个字符是字母时
            if('A' <= arr[start] && arr[start] <='Z' || arr[start] >='a' && arr[start] <= 'z'){
                //当最后一个字符是字母时
                if('A' <=arr[end] && arr[end] <='Z' || arr[end] >='a' && arr[end] <= 'z'){
                    //交换首尾字母
                    char c=arr[start];
                    arr[start]=arr[end];
                    arr[end]=c;
                    end--;
                    start++;
                }else {
                    //当第一个字符是字母，最后一个字符不是字母时
                    end--;
                }
            }else {
                //当第一个字符不是字母
                start++;
            }
        }
        */
        while(start < end){
            //当第一个字符是字母时
            if(checkChar(arr[start])){
                //当最后一个字符是字母时
                if(checkChar(arr[end])){
                    //交换首尾字母
                    char c=arr[start];
                    arr[start]=arr[end];
                    arr[end]=c;
                    end--;
                    start++;
                }else {
                    //当第一个字符是字母，最后一个字符不是字母时
                    end--;
                }
            }else {
                //当第一个字符不是字母
                start++;
            }
        }
        String result="";
        for(char x:arr){
            result += x;
        }
        return result;
    }

    private static boolean checkChar(char c) {
        return (c >= 65 && c <= 90) || (c >= 97&&c<=122);
    }

    public static void main(String[] args) {
        String s="Test1ng-Leet=code-Q!";
        System.out.println(reverseOnlyLetters(s));
    }
}
