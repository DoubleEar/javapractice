import java.util.Scanner;
//神奇的口袋
public class MagicPocket {
    static int[]nums;//每件物品的重量
    static int count;//不同物品的数目
    private static int MethodCount(int i,int sumWeight){
        if(i==count)
            return 0;
        //该物品的重量刚好等于40，先加一再往后遍历。
        if(nums[i]==sumWeight)
            return 1+MethodCount(i+1,sumWeight);
        //该物品的重量小于40，分两路遍历。
        //（1）以i为首遍历   （2）以i+1为首遍历
        else if(nums[i]<sumWeight)
            return MethodCount(i+1,sumWeight-nums[i])
                    +MethodCount(i+1,sumWeight);
        //该物品的数量大于40，直接往后遍历。
        else
            return MethodCount(i+1,sumWeight);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            count=sc.nextInt();
            nums=new int[count];
            for(int i=0;i<count;i++){
                nums[i]=sc.nextInt();
            }
            //i表示当前取出物品的重量
            System.out.println(MethodCount(0,40));
        }
    }
}
