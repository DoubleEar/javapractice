import java.util.*;
//以升序序列返回最小的k个数
public class TheSmallestK {
    private static void getK(int[] res){
        int n=res.length;
        int k=res[n-1];
        //优先级队列。
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<n-1;i++){
            pq.add(res[i]);
        }
        for(int i=0;i<k;i++){
            System.out.print(pq.poll()+" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            String[] str=s.split(" ");
            int[] res=new int[str.length];
            for(int i=0;i<str.length;i++){
                res[i]=Integer.valueOf(str[i]);
            }
            getK(res);
        }
    }
}
