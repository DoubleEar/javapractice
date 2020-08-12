import java.util.Scanner;
//验证字符串
/*
给定一个字符串 S，如果 S 满足以下要求中的任意一个则返回 true，否则返回 false:
1. 全部都是大写字母，比如 "BILIBILI"
2. 全部都是小写字母，比如 "bilibili"
3. 首字母大写，比如 "Bilibili"
 */
public class ValidationString {
    public static void main(String[] arg){
        Scanner in = new Scanner(System.in);
        char[] read = in.nextLine().toCharArray();
        boolean flag = (read[0]>='A') && (read[0]<='Z');

        //第一个为小写，则说明合法字符串全部是小写
        if(!flag){
            //当剩余字符串中出现大写时，返回false
            for(int i=1;i<read.length;i++){
                if(read[i]<'a' || read[i]>'z'){
                    System.out.println("false");
                    return;
                }
            }
            System.out.println("true");
        }else{
            //第一个字符是大写
            boolean big = false;
            boolean small = false;
            for(int i=1;i<read.length;i++){
                if(read[i]>='a' && read[i]<='z'){
                    small =true;
                }
                if(read[i]>='A' && read[i]<='Z'){
                    big = true;
                }
            }
            //若全部大写，则big==true，small==false；
            //若首字母大写其他都是小写，则big==false，small==true；
            //若非法，则big==true,small == true;
            if(big && small){
                System.out.println("false");
            }else{
                System.out.println("true");
            }
        }

    }
}
