import java.util.Stack;
//平衡字符串的分割
public class BalanceString {
    public static int Spilt(String s){
        Stack<Character> s1=new Stack<>();
        int size=0;
        for(char c:s.toCharArray()) {
            //如果栈为空，入栈
            if (s1.isEmpty()) {
                s1.push(c);
            //栈不为空，并且当前元素等于栈顶元素，入栈
            } else if (c == s1.peek()) {
                s1.push(c);
            //栈不为空，并且当前元素不等于栈顶元素，出栈
            } else{
                s1.pop();
             //如果栈为空则匹配的
                if(s1.isEmpty()){
                    size++;
                }
            }
        }
        return size;
    }

    public static void main(String[] args) {
        System.out.println(Spilt("LLLRRR"));
        System.out.println(Spilt("LRLRLR"));
        System.out.println(Spilt("LLRRLR"));
    }
}
