//翻转单词顺序
public class ReverseWords {
    public static String reverseWords(String s) {
        String[] str=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=str.length-1;i>=0;i--){
            if(str[i].equals(""))   //遇到空格就跳过
                continue;
            sb.append(str[i]+" ");
        }
        return sb.toString().trim();    //去掉首位的空字符串
    }

    public static void main(String[] args) {
        String s="a good   example";
        System.out.println(reverseWords(s));
    }
}
