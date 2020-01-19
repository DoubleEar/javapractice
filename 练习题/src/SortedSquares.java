import java.util.Arrays;

//给定一个按非递减顺序排序的整数数组 A，
// 返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
public class SortedSquares {
    public static int[] sortedSquares(int[] A) {
        /*for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
        */
        int left=0;
        int right=A.length-1;
        int[] temp=new int[A.length];
        int currentIndex=right;
        while(left<=right) {
            if (Math.abs(A[left]) <= Math.abs(A[right])) {
                temp[currentIndex--] = (int) Math.pow(A[right], 2);
                right--;
            } else {
                temp[currentIndex--] = (int) Math.pow(A[left], 2);
                left++;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] A={-5,1,2,3,4,5};
        System.out.println(Arrays.toString(sortedSquares(A)));
    }
}
