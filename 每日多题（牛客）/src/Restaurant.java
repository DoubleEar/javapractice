import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
//餐馆
//输出一个整数,表示最大的总预计消费金额
class Customer implements Comparable<Customer>{
    public int peopleCount;     //客人的数量
    public int moneyCount;      //客人的最大消费金额

    public Customer(int peopleCount,int moneyCount){
        this.peopleCount=peopleCount;
        this.moneyCount=moneyCount;
    }

    @Override
    public int compareTo(Customer o) {  //按照客人的消费额进行从大到小排序。先接待消费额多的客人。
        if(o.moneyCount>this.moneyCount)
            return 1;
        else if(o.moneyCount<this.moneyCount)
            return -1;
        else
            return 0;
    }
}
public class Restaurant {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int n=sc.nextInt();     //n表示餐馆中有几张桌子
            int m=sc.nextInt();     //m表示有几位客人
            int[] desk=new int[n];  //数组记录每张桌子能容纳的最大人数
            for(int i=0;i<n;i++){
                desk[i]=sc.nextInt();
            }

            Arrays.sort(desk);  //将桌子的容纳人数从小到大排列
            PriorityQueue<Customer> pq=new PriorityQueue<Customer>();
            for(int i=0;i<m;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                if(desk[n-1]>=a)    //如果客人的人数大于桌子最大容纳量就offer
                    pq.offer(new Customer(a,b));
            }

            boolean[] used=new boolean[n];  //标记数组 当前桌子有没有客人
            long sum=0;     //所有客人消费总额
            int count=0;    //表示有多少桌子已经有客人了

            while (!pq.isEmpty()){
                Customer customer=pq.poll();
                for(int i=0;i<n;i++){
                    if(customer.peopleCount<=desk[i]&&!used[i]){
                        sum+=customer.moneyCount;
                        count++;
                        used[i]=true;
                        break;
                    }
                }
                if(n==count)    //当桌子坐满时就break
                    break;
            }
            System.out.println(sum);
        }
    }
}
