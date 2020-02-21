package 栈和队列;

import java.util.Stack;
//逆波兰表达式（后缀表达式）
public class PoLandNation {
    public static  int calculate(String[] tokens){
        Stack<Integer> stack=new Stack<>();
        for(String s:tokens){
            if(s.equals("+")){
                stack.push(stack.pop()+stack.pop());
            }else if(s.equals("*")){
                stack.push(stack.pop()*stack.pop());
            }else if(s.equals("-")){
                int res=stack.pop();
                stack.push(stack.pop()-res);
            }else if(s.equals("/")){
                int res=stack.pop();
                stack.push(stack.pop()/res);
            }else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] s={"4","5","*","8","-","60","+","8","2","/","+"};
        System.out.println(calculate(s));
    }
}
