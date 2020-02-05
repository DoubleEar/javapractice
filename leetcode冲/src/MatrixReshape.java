import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//重塑矩阵
public class MatrixReshape {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] ret=new int[r][c];
        if(nums.length==0||nums.length*nums[0].length!=r*c){
            return nums;
        }
        int count=0;
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                queue.add(nums[i][j]);
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                ret[i][j]=queue.remove();
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][]nums={{1,2,3},{4,5,6}};
        System.out.print(Arrays.deepToString(matrixReshape(nums,1,6)));
    }
}
