//队列的最大值
//请定义一个队列并实现函数 max_value 得到队列里的最大值
// 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
//若队列为空，pop_front 和 max_value 需要返回 -1

/*
public class MaxQueue {
    int[] queue;        //普通队列
    int qHead,qLast;    //队列头 队列尾
    int[] maxQueue;     //存储最大值的队列
    int mHead,mLast;    //队列头 队里尾

    public MaxQueue() {
        queue=new int[10000];
        maxQueue=new int[1000];
        qHead=qLast=mHead=mLast=0;
    }

    //获取当前的最大值
    public int max_value() {
        return mHead==mLast?-1:maxQueue[mHead];
    }

    //尾插
    public void push_back(int value) {
        queue[qLast++]=value;
        while(mHead!=mLast&&maxQueue[mLast-1]<value){
            mLast--;
        }
        maxQueue[mLast++]=value;
    }

    //头删
    public int pop_front() {
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
    }
}
*/

import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {
    Queue<Integer> queue;
    LinkedList<Integer>  maxList;

    public MaxQueue(){
        queue=new LinkedList<>();
        maxList=new LinkedList<>();     //LinkedList是双端链表
    }

    //获取当前最大值
    public int max_value(){
        return maxList.size()==0?-1:maxList.getFirst();
    }

    //头删
    public int pop_front(){
        int res=queue.size()>0?queue.poll():-1;
        if(!maxList.isEmpty()&&maxList.getFirst()==res){
            maxList.removeFirst();
        }
        return res;
    }

    //尾插
    public void push_back(int value) {
        queue.add(value);
        while (!maxList.isEmpty()&&maxList.getLast()<value)
            maxList.removeLast();
        maxList.add(value);
    }
}