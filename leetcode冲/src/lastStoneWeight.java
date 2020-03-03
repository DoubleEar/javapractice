import java.util.Arrays;
import java.util.PriorityQueue;

//每一回合，从中选出两块最重的石头，然后将它们一起粉碎。
//重量相等两个石头一起粉碎，不相等新石头的重量为两者之差
public class lastStoneWeight {
    public static int lastStoneWeight(int[] stones) {
        /*
        PriorityQueue<Integer> pQ=new PriorityQueue<>((e1,e2)->e2-e1);
        for(int i=0;i<stones.length;i++){
            pQ.offer(stones[i]);
        }

        while (pQ.size()>1){
            int x=pQ.poll();
            int y=pQ.poll();
            int gap=Math.abs(x-y);
            if(gap!=0)
                pQ.offer(gap);
        }

        if(pQ.isEmpty())
            return 0;
        return pQ.peek();
        */

        int gap=0;
        for(int i=0;i<stones.length-1;i++){
            //每次操作后都对数组进行排序
            Arrays.sort(stones);
            gap=stones[stones.length-1]-stones[stones.length-2];
            //将倒数第二个元素赋值为零，排序后就到数组的最前面
            //最后一次进入循环时，如果将最后一个元素赋值为零，倒数第二个元素赋值为gap
            //数组将不会重新进行排序，直接返回最后一个元素，返回的是零。
            //所以必须将gap赋值给最后一个元素。
            stones[stones.length-2]=0;
            stones[stones.length-1]=gap;
        }
        //返回数组最后一个元素
        return stones[stones.length-1];
    }


    public static void main(String[] args) {
        int[] stones={2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }
}
