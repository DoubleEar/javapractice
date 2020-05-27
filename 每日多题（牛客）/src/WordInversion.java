import java.util.Scanner;
//单词倒置
//单词只由大小写组成，其余的字符视为分割符。
public class WordInversion {
    private static void inversion(String s){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(!(s.charAt(i)>='A'&&s.charAt(i)<='Z'||s.charAt(i)>='a'&&s.charAt(i)<='z')){
                sb.append(' ');
            }else
                sb.append(s.charAt(i));
        }
        //用空格分割单词
        String[] str=sb.toString().split(" ");

        sb.setLength(0);
        for(int i=str.length-1;i>=0;i--){
            sb.append(str[i]+" ");
        }

        //除去字符串两边的空字符
        System.out.println(sb.toString().trim());
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            String s=sc.nextLine();

            inversion(s);
        }
    }
}
