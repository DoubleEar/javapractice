import java.util.Scanner;

//年会抽奖
public class AnnualMeetingLottery {
    //分子：所有抽不到自己名字的可能->错排
    /*
        第一步，把第n个元素放在一个位置，比如位置k，一共有n-1种方法；
        第二步，放编号为k的元素，这时有两种情况：把它放到位置n，那么，对于剩下的n-1个元素，
        由于第k个元素放到了位置n，剩下n-2个元素就有D(n-2)种方法；
        第k个元素不把它放到位置n，这时，对于这n-1个元素，有D(n-1)种方法；
     */
    private static double literal(int n){
        if(n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }else{
            return (n-1)*(literal(n-1)+literal(n-2));
        }
    }

    //分母：所有抽签的可能n！
    private static double factorial(int n){
        double res=1;
        while (n>1){
            res*=n;
            n--;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int n=sc.nextInt();
            double n1=literal(n);
            double n2=factorial(n);
            double res=(n1/n2)*100;
            System.out.println(String.format("%.2f", res) + "%");
        }
    }
}
