package 栈和队列;

import java.util.Arrays;
//用顺序表数组实现栈
public class Stack {
    private int[]array;
    private int maxSize;
    private int top=-1;//表示栈顶元素

    public  Stack(int maxSize ){
        array=new int[maxSize];
        this.maxSize=maxSize;
    }
    //入栈
    public void push(int value){
        /*if(size==array.length)
            array=Arrays.copyOf(array,2*size);
        array[size++]=value;
        */
        if(isFull()) {
            System.out.println("栈已满，不能入栈。");
            return;
        }
        top++;
        array[top]=value;
    }

    //出栈
    public int pop(){
        if(empty())
            throw new RuntimeException("栈空");
        int value=array[top];
        top--;
        return value;
    }

    //获取栈顶元素
    public int peek(){
        return array[top];
    }

    //查看栈中元素的个数
    public  int size(){
        return top+1;
    }

    //判断栈是否为空
    public boolean empty(){
       return top==-1;
    }

    //判断栈是否满
    public boolean isFull(){
        return top==maxSize-1;
    }

    public static void main(String[] args) {
        Stack stack=new Stack(5);
        System.out.println(stack.size());
        System.out.println(stack.empty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.isFull());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.empty());
        System.out.println("top="+stack.peek());
        System.out.println("遍历：");
        while(!stack.empty()) {
            System.out.printf("%d\t",stack.pop());
        }
    }
}
