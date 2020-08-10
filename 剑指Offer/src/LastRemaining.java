import java.util.ArrayList;

//圆圈中最后剩下的数字
public class LastRemaining {
    /*
    //模拟环形链表，获取链表中最后一个数。
    public int lastRemaining(int n, int m) {
        //n代表一共有多少个数字，m代表每次删除第几个数
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(i);
        }

        int index=0;
        while (n>1){
            index=(index+m-1)%n;    //模拟环形链表
            list.remove(index);
            n--;
        }
        return list.get(0);
    }
    */

    //从后向前推
    public static int lastRemaining(int n, int m) {
        int ans=0;
        //ans代表从后往前顺序中每一轮删除的下标，i代表圆圈中的数字。
        //最后一轮圆圈中剩下2个数字，所以从2开始。
        for(int i=2;i<=n;i++){
            ans=(ans+m)%i;  //要删除的下标每次都会固定移动m
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(5, 3));
    }
}
