import java.util.Scanner;
//三个空瓶子兑换一瓶汽水，如果有两个空瓶子，可以先借一瓶(兑换汽水的数量加一)喝完不兑换新的。
public class ChangeBottle {
    private static int Drink(int n){
        if(n<=0)
            return 0;
        else if(n==3)
            return 1;
        else if(n==2)
            return 1;
        else{
            int count;
            count=n/3;
            return count+Drink(n%3+count);
        }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n;
        while(s.hasNext())
        {
            n=s.nextInt();
            System.out.println(Drink(n));
        }
    }
}
