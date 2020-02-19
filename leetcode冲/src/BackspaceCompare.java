import java.util.Stack;
//比较含退格的字符串,遇到#就将前面的字符串删除。
public class BackspaceCompare {
    public static boolean backspaceCompare(String S, String T) {
       /* Stack<Character> s1=new Stack<>();
        Stack<Character> s2=new Stack<>();
        char c1=' ',c2=' ';
        for(int i=0;i<S.length();i++){
            c1=S.charAt(i);
            if(c1!='#'){
                s1.push(c1);
            }else if(!s1.isEmpty()){
                s1.pop();
            }
        }
        for(int j=0;j<T.length();j++){
            c2=T.charAt(j);
            if(c2!='#'){
                s2.push(c2);
            }else if(!s2.isEmpty()){
                s2.pop();
            }
        }
        return s1.equals(s2);
        */
        return build(S).equals(build(T));
    }
    public static String build(String S) {
        Stack<Character> ans = new Stack();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }
    public static void main(String[] args) {
        String S="ab#c";
        String T="ad#c";
        System.out.println(backspaceCompare(S,T));
    }
}
