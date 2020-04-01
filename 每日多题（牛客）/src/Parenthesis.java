import java.util.Stack;
//判断是否为匹配的括号
public class Parenthesis {
    public static boolean chkParenthesis(String A, int n) {
        Stack stack=new Stack();
        char[] c=A.toCharArray();
        for(int i=0;i<n;i++){
            if(c[i]=='(')
                stack.push(c[i]);
            else if(c[i]==')'){
                if(stack.isEmpty()) {
                    return false;
                }else{
                    stack.pop();
                }
            }else
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String S="()";
        System.out.println(chkParenthesis(S,2));
    }
}
