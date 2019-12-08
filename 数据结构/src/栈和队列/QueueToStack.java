package 栈和队列;

import java.util.LinkedList;
import java.util.Queue;

public class QueueToStack {
    Queue<Integer> queue;
    public QueueToStack() {
       queue = new LinkedList<>();
    }
    //插入元素
    public void push (int element){
        queue.offer(element);
    }

    //移除栈顶元素
    public int pop() {
        int sz = queue.size();
        while (sz > 1) {
            queue.offer(queue.poll());
            sz--;
        }
        int ret = queue.poll();
        return ret;
    }

    //获取栈顶元素
    public int top(){
        int sz=queue.size();
        while(sz>1){
            queue.offer(queue.poll());
            sz--;
        }
        int ret= queue.poll();
        queue.offer(ret);
        return ret;
    }
    //判断栈是否为空
    public boolean empty() {
        return queue.isEmpty();
    }

}
