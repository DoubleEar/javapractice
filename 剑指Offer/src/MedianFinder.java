import java.util.PriorityQueue;
//数据流中的中位数
public class MedianFinder {
    /*
        将数值分为两个部分，左边的数都小于右边的数。如果为偶数，那么中位数就是左边的
        最大值与右边的最小值的和除2。所以左边的数字都放在大堆里，右边的数字都放在小堆
        里。并且大根堆与小根堆的size之差不能超过一。
     */
    PriorityQueue<Integer> min,max;
    int size;
    public MedianFinder() {
        min=new PriorityQueue<>();  //小根堆 用来保存数值大的部分
        max=new PriorityQueue<>((v1,v2)->v2-v1);    //大根堆 用来保存数值小的部分
        size=0;
    }

    /*
    public void addNum(int num) {
        //这样避免了小根堆中的数字还要小于大根堆中的数。
        if(min.size()!=max.size()){
            min.offer(num);
            max.offer(min.poll());
        }else{
        //这样避免了大根堆中的数字还要大于大根堆中的数。
            max.offer(num);
            min.offer(max.poll());
        }
    }
    */

    public void addNum(int num) {
        size++;
        if((size&1)==1){    //如果当前的数字个数是奇数
            min.offer(num);
            max.offer(min.poll());
        }else {
            max.offer(num);
            min.offer(max.poll());
        }
    }

    /*
    public double findMedian() {
        if(max.size()!=min.size()){     //数字的总和为奇数
            return min.peek();
        }else{
            return (min.peek()+max.peek())/2.0;
        }
    }
    */

    public double findMedian() {
        if((size&1)==1){    //数字的总和为奇数
            return max.peek();
        }else
            return (min.peek()+max.peek())/2.0;
    }

    public static void main(String[] args) {
        MedianFinder mf=new MedianFinder();
        mf.addNum(5);
        mf.addNum(2);
        mf.addNum(4);
        mf.addNum(3);
        mf.addNum(1);

        double res=mf.findMedian();
        System.out.println(res);
    }
}
