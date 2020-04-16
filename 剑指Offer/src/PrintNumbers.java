import java.util.Arrays;

//打印从1到最大的n位数
//为了避免数值过大的情况，用数组保存。
public class PrintNumbers {
    public static int[] printNumbers(int n){
        int num=(int)Math.pow(10,n);
        int[] res=new int[num-1];
        for(int i=0;i<res.length;i++){
            res[i]=i+1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNumbers(1)));
    }
}
