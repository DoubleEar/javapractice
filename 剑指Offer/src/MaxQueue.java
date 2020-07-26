//对列的最大值
public class MaxQueue {
    int[] queue;
    int qHead,qLast;
    int[] maxQueue;
    int mHead,mLast;

    public MaxQueue() {
        queue=new int[10000];
        maxQueue=new int[1000];
        qHead=qLast=mHead=mLast=0;
    }

    public int max_value() {
        return mHead==mLast?-1:maxQueue[mHead];
    }

    public void push_back(int value) {
        queue[qLast++]=value;
        while(mHead!=mLast&&maxQueue[mLast-1]<value){
            mLast--;
        }
        maxQueue[mLast++]=value;
    }

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
