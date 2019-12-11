package 栈和队列;

import java.util.Stack;
//定义两个栈，一个为正常栈，一个存放最小元素的栈。
public class MinStack {
    Stack<Integer> st1;
    Stack<Integer> st2;
    public MinStack(){
        st1=new Stack<>();
        st2=new Stack<>();
    }
    //将元素推入栈中
    public void push(int x){
        st1.push(x);
        if(st2.isEmpty()||x<=st2.peek())
            st2.push(x);
    }
    //删除栈顶元素
    public void pop(){
        int ret=st1.peek();
        if(ret==st2.peek()) {
            st2.pop();
        }
        st1.pop();
    }
    //获得栈顶元素
    public int top(){
        return st1.peek();
    }
    //检索栈中最小元素
    public int getMin(){
        return st2.peek();
    }
}
