import java.util.Arrays;

//给定一个非负整数数组 A，返回一个数组，在该数组中，
// A 的所有偶数元素之后跟着所有奇数元素。
public class SortArrayByParity {
    public static int[] sortArrayByParity(int[] A) {
        int[] B=new int[A.length];
        int end = A.length-1;
        int start=0;
            for (int i:A) {
                if (i% 2 != 0) {
                    B[end--] = i;
                }else {
                    B[start++]=i;
                }
            }
        return B;
    }

    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        System.out.println(Arrays.toString(sortArrayByParity(a)));
    }
}
