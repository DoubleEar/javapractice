//翻转单词顺序
//输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
public class ReverseWords {
    public static String reverseWords(String s) {
        if(s==null)
            return null;
        //输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
        s.trim();

        String[] str=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=str.length-1;i>=0;i--){
            //如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个
            if(str[i].equals(""))
                continue;
            else
                sb.append(str[i] + " ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s="We are  Student.";
        System.out.println(reverseWords(s));
    }
}
