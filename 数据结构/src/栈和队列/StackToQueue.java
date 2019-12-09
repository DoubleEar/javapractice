package 栈和队列;

import java.util.Stack;
//定义两个栈，一个出栈一个入栈
public class StackToQueue {
    Stack<Integer>s1;
    Stack<Integer>s2;
    public StackToQueue(){
        s1=new Stack<>();
        s2=new Stack<>();
    }
    //将一个元素放到队列的队尾
    public void push(int x){
        s1.push(x);
    }
    //从队列首部移除元素
    public int pop(){
        int sz=s1.size();
        if(s2.isEmpty()) {
            for (int i = 0; i < sz; i++) {
                s2.push(s1.pop());
            }
        }
        int ret=s2.pop();
        return ret;
    }
    //返回队列首部的元素
    public int peek(){
        int sz=s1.size();
        if(s2.isEmpty()) {
            for (int i = 0; i < sz; i++) {
                s2.push(s1.pop());
            }
        }
        int ret=s2.peek();
        return ret;
    }
    //返回队列是否为空
    public boolean empty(){
            return s1.isEmpty()&&s2.isEmpty();
    }
}
