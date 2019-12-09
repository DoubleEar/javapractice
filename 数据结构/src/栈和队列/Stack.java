package 栈和队列;

import java.util.Arrays;
//用顺序表实现栈
public class Stack {
    private int[]array;
    private int size;
    int n;
    public  Stack(int n){
        array=new int[n];
        size=0;
    }
    public void push(int value){
        if(size==array.length)
            array=Arrays.copyOf(array,2*size);
        array[size++]=value;
    }

    public void pop(){
        if(size>0)
            size--;
    }

    public int peek(){
        return array[size-1];
    }

    public  int size(){
        return size;
    }

    public boolean empty(){
        if(size==0)
        return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Stack stack=new Stack(2);
        System.out.println(stack.size());
        System.out.println(stack.empty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.size());
        System.out.println(stack.empty());
        System.out.println("top="+stack.peek());
        System.out.println("遍历：");
        while(!stack.empty()) {
            System.out.print(stack.peek());
            stack.pop();
        }
    }
}
