import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//隔两个数删除一个数
public class LastRemaining {
    public static int lastRemaining(int n, int m) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        int index=0;
        while (n>1){
            index=(index+m)%n;  //注意，m代表隔两个数删除一个数。
            //index=(index+m-1)%n;//这里m代表删除第3个数（相当于隔两个数删除一个数，要审题。）
            list.remove(index);
            n--;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int n=sc.nextInt();
            if(n>1000)
                n=999;
            System.out.println(lastRemaining(n,2));
        }
    }
}
