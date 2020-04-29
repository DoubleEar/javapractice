import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//找x
public class FindX {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int[] nums=new int[n];
            Map<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<n;i++){
                nums[i]=sc.nextInt();
                map.put(nums[i],i);
            }
            int x=sc.nextInt();

            if (map.containsKey(x)) {
                System.out.println(map.get(x));
                return;
            } else {
                System.out.println(-1);
                return;
            }
        }
    }
}
