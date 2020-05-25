import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//求和
public class Summation {
    static List<List<Integer>> res = new ArrayList<>(); //用来保存结果集
    static List<Integer> list = new ArrayList<>(); //用来保存每一次符合的结果

    public static void getSum(int index, int count, int n) {
        if(count == 0) {  //当
            res.add(new ArrayList<>(list)); //将结果增加到结果集中
        }
        else {
            for(int i = index; i <= count && i <= n; i++) {
                list.add(i);
                getSum(i + 1, count - i, n);

                //当return说明不符合条件->删除
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n, m;
        while(sc.hasNext()) {
            n = sc.nextInt();
            m = sc.nextInt();

            getSum(1, m, n);

            //输出每一个结果
            for(List<Integer> l : res) {
                int i = 0;
                for(; i < l.size() - 1; i++) {
                    System.out.print(l.get(i) + " ");
                }
                System.out.println(l.get(i));
            }
        }
    }
}
