import java.util.Stack;
//包含min函数的栈
public class MinStack {
    Stack<Integer> s;
    Stack<Integer> min;

    public MinStack() {
        s = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        /*
        if(min.isEmpty()||x<min.peek()){
            min.push(x);
        }else
            min.push(min.peek());

        s.push(x);
        */

        s.push(x);
        if (min.isEmpty() || x <= min.peek()) {
            min.push(x);
        }
    }

    public void pop() {
        /*
        if(!min.isEmpty()&&!s.isEmpty()){
            min.pop();
            s.pop();
        }
        */

        if (s.pop().equals(min.peek())) {
            min.pop();
        }
    }

    public int top() {
        return s.peek();
    }

    public int min() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.min());
    }
}
