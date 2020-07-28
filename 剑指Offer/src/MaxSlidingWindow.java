import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
//滑动窗口的最大值
public class MaxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0||k==0)
            return new int[0];
        Deque<Integer> deque=new LinkedList<>();    //单调队列
        int[] res=new int[nums.length-k+1];
        for(int i=0;i<k;i++){   //还未形成窗口时
            while (!deque.isEmpty()&&deque.peekLast()<nums[i])
                deque.removeLast();
            deque.add(nums[i]);
        }
        res[0]=deque.peekFirst();
        for(int i=k;i<nums.length;i++){
            if(deque.peekFirst()==nums[i-k])    // 队首元素 deque[0]=被删除元素 nums[i - 1]
                deque.removeFirst();            // 则删除该元素，因为窗口要向后滑动了
            while (!deque.isEmpty()&&deque.peekLast()<nums[i])  //删除deque内所有<nums[j]的元素，以保持deque递减
                deque.removeLast();
            deque.addLast(nums[i]);         //将 nums[j]添加至deque尾部
            res[i-k+1]=deque.peekFirst();   //将窗口最大值(即队首元素 deque[0])添加至列表res
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums,3)));
    }
}
