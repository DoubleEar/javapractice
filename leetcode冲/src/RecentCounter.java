import java.util.LinkedList;
import java.util.Queue;

//返回从 3000 毫秒前到现在的 ping 数。保证每次对 ping 的调用都使用比之前更大的 t 值
//任何处于 [t - 3000, t] 时间范围之内的 ping 都将会被计算在内，包括当前（指 t 时刻）的 ping。
//注意队列的首元素就是时间最小的元素
public class RecentCounter {
    Queue<Integer> queue;
    public RecentCounter(){
        queue=new LinkedList<>();
    }
    public int ping(int t) {
        queue.add(t);
        //如果队列首元素不在当前元素的前3000毫秒的范围内，就将首元素poll
        while(queue.peek()<t-3000){
            queue.poll();
        }
        return queue.size();
    }
}
