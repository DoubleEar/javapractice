import java.util.Stack;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
public class IsValid {
    public static boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
            }else if(!stack.isEmpty()){
                char temp=stack.peek();
                if(temp=='('&&c==')'){
                    stack.pop();
                }else if(temp=='{'&&c=='}'){
                    stack.pop();
                }else if(temp=='['&&c==']'){
                    stack.pop();
                }
                else {
                    return false;
                }
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s="(])";
        System.out.println(isValid(s));
    }
}
