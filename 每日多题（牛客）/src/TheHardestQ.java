import java.util.Scanner;
//给出加密后的字符串，输出原文字符串。
//密码字母：A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
//原文字母：V W X Y Z A B C D E F G H I J K L M N O P Q R S T U
public class TheHardestQ {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            String s=sc.nextLine();
            char[] c=s.toCharArray();
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<s.length();i++){
                if(c[i]>='A'&&c[i]<'F')
                    //注意转换为char类型
                    sb.append((char) (c[i]+21));
                else if(c[i]>='F'&&c[i]<='Z')
                    sb.append((char) (c[i]-5));
                else
                    sb.append(c[i]);
            }
            System.out.println(sb.toString());
        }
    }
}
