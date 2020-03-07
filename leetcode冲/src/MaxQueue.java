import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//请定义一个队列并实现函数 max_value 得到队列里的最大值
// 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。

public class MaxQueue {
    /*
    int[] queue;
    int qHead,qLast;
    int[] maxQueue;
    int mHead,mLast;
    */
    Queue<Integer> queue;
    Deque<Integer> deque;

    public MaxQueue(){
        /*
        queue=new int[10000];
        maxQueue=new int[1000];
        qHead=qLast=mHead=mLast=0;
        */
        queue=new LinkedList<>();   //队列：插入和删除
        deque=new LinkedList<>();   //双端队列：获取最大值
    }

    //获取最大值
    public int max_value(){
       return deque.size()>0?deque.peek():-1;
       //return mHead==mLast?-1:maxQueue[mHead];
    }

    //入队
    public void push_back(int value){
        /*
        queue[qLast++]=value;
        while(mHead!=mLast&&maxQueue[mLast-1]<value){
            mLast--;
        }
        maxQueue[mLast++]=value;
        */
        queue.offer(value);
        //将队尾小于元素的value移除掉，确保队头是最大值。
        while (deque.size()>0&&deque.peekLast()<value){
            deque.pollLast();
        }
        deque.offerLast(value);  //将value放在deque队尾
    }

    //出队
    public int pop_front(){
        /*
        if(qHead == qLast){
            // 队列为空
            return -1;
        }
        int res = queue[qHead];
        if(res == maxQueue[mHead]){
            mHead++;
        }
        qHead++;
        return res;
        */
        int temp=queue.size()>0?queue.poll():-1;//获取队头元素
        if(deque.size()>0 && temp==deque.peek()){
            deque.poll();  //如果出队的元素是当前最大值，将deque的队首出队
        }
        return temp;
    }

    public static void main(String[] args) {
        MaxQueue mq=new MaxQueue();
        mq.push_back(3);
        mq.push_back(7);
        mq.push_back(2);
        mq.push_back(9);

        int max=mq.max_value();
        System.out.println(max);

        int pop=mq.pop_front();
        System.out.println(pop);
    }
}
