import java.util.Stack;

//用两个栈实现队列的出队入队
public class CQueue {
    Stack<Integer> s1;//存储数据
    Stack<Integer> s2;//维护栈
    int size;
    public CQueue() {
        s1=new Stack();
        s2=new Stack();
        size=0;
    }

    //入队
    public void appendTail(int value) {
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(value);
        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }
        size++;
    }

    //出队
    public int deleteHead() {
        if(s1.isEmpty())
            return -1;
        size--;
        return s1.pop();
    }

    public static void main(String[] args) {
        CQueue cq=new CQueue();
        cq.appendTail(1);
        cq.appendTail(2);
        cq.appendTail(3);
        cq.appendTail(4);
        cq.appendTail(5);
        System.out.println(cq.deleteHead());
        System.out.println(cq.deleteHead());
    }
}
