//给定一个整数数组 A，只有我们可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
public class CanThreePartsEqualSum {
    public static boolean canThreePartsEqualSum(int[] A) {
        int total=0;
        //求数组的和
        for(int num:A){
            total+=num;
        }
        //求出平均值
        int average=total/3;
        int j=0;
        total=0;
        for(int i=0;i<A.length;i++){
            total+=A[i];
            if(total==average){
                j++;
                total=0;
            }
        }
        return j==3 && total==0;
    }

    public static void main(String[] args) {
        int[] A={0,2,1,-6,6,-7,9,1,2,0,1};
        System.out.println(canThreePartsEqualSum(A));
    }
}
