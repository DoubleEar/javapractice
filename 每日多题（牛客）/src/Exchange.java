import java.util.Arrays;
//无缓存的交换两个数
public class Exchange {
    public static int[] exchangeAB(int[] AB) {
        //A==>A^B^B
        AB[0]=AB[0]^AB[1];
        AB[1]=AB[0]^AB[1];
        AB[0]=AB[0]^AB[1];

        return AB;
    }

    public static void main(String[] args) {
        int[] AB={1,2};
        System.out.println(Arrays.toString(exchangeAB(AB)));
    }
}
