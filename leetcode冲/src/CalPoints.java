import java.util.Stack;

//棒球比赛
//1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
//2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
//3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
//4. "C"（一个操作）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
public class CalPoints {
    public static int calPoints(String[] ops) {
        int sum=0;
        Stack<Integer> stack=new Stack<>();
        for(String s:ops){
            if(s.equals("+")){
                int top=stack.pop();
                int newTop=top+stack.peek();
                sum+=newTop;
                stack.push(top);
                stack.push(newTop);
            }else if(s.equals("D")){
                sum+=2*stack.peek();
                stack.push(2*stack.peek());
            }else if(s.equals("C")){
                sum-=stack.peek();
                stack.pop();
            }else{
                sum+=Integer.parseInt(s);
                stack.push(Integer.parseInt(s));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] s={ "5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints(s));
    }
}
