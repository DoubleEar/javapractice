import java.util.*;
//字符串中找到连续的最长数字串
public class LongestNumber {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            String str1="";
            String str=sc.nextLine();
            for(char ch:str.toCharArray()){
                //将不是数字的字符全部变成a
                if(ch>='0' && ch<='9'){
                    str1+=ch;
                }else{
                    str1+="a";
                }
            }
            //按a分割
            String[] s=str1.split("a");
            int max=0;//记录最长的连续数字串的长度
            for(int i=0;i<s.length;i++){
                max=s[i].length()>max?s[i].length():max;
            }
            for(int i=0;i<s.length;i++){
                if(s[i].length()==max)
                    System.out.println(s[i]);
            }
        }
    }
}


