import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//木棒拼图
public class StickPuzzle {
    private static void lengthOfSide(int[][] temp,int n){
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(temp[i][0]==1){
                list.add(temp[i][1]);
            }else{
                //注意此时删除的时候要删除的是temp[i][1]对象而不是下标。
                //list.remove(int index);
                //list.remove(Object o);
                list.remove(new Integer(temp[i][1]));
            }

            if(judge(list)){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }

    private static boolean judge(List<Integer> list){
        if(list.size()<3)
            return false;
        else {
            Collections.sort(list); //对list中的所有元素进行排序
            int sum=0;
            int size=list.size()-1;
            //多边形->其余边的长度加起来大于任意剩余一条边的长度。
            //因为已经排过序 所以只用判断所有较小边长的和是否大于最大边即可
            for(int i=0;i<size;i++){
                sum+=list.get(i);
            }
            if(sum<=list.get(size)){
                return false;
            }else{
                return true;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int[][] temp=new int[n][2];
            for(int i=0;i<n;i++){
                temp[i][0]=sc.nextInt();
                temp[i][1]=sc.nextInt();
            }
            lengthOfSide(temp,n);
        }
    }
}
