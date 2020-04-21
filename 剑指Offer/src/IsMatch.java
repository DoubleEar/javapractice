//正则表达式匹配
public class IsMatch {
    public static boolean isMatch(String s, String p) {
        if(p.isEmpty())
            return s.isEmpty();
        //判断s和p的首字符是否匹配
        boolean first_match=(!s.isEmpty()&&s.charAt(0)==p.charAt(0))
                ||p.charAt(0)=='.';
        //如果p的下一个元素是*
        if(p.length()>=2&&p.charAt(1)=='*'){
            //两种情况：
            // 1.文本字符串不移动，模板字符串将*前面字符置0个，后移两位。
            // 2.文本字符串和模板字符串第一个字符如果匹配上,
            // 就将文本字符串后移一位，此时模板字符串不需要后移。
            // 因为可能需要继续使用*的功能。
            // (就是说如果文本字符串前n个字符都相同的情况)
            return  (isMatch(s,p.substring(2))||
                    (first_match&&isMatch(s.substring(1),p)));
        }else{
            //下一个元素不是*，就继续往后判断。
            return first_match&&isMatch(s.substring(1),p.substring(1));
        }
    }

    public static void main(String[] args) {
        System.out.println(isMatch("abb", "a*abb"));
    }
}
