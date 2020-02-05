import java.util.Arrays;

//重塑矩阵
public class Matrix_Reshape {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] ret=new int[r][c];
        if(nums.length==0||nums.length*nums[0].length!=r*c)
            return nums;
        int cols=0;
        int rows=0;
        //int count=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                ret[rows][cols]=nums[i][j];
                //列++
                cols++;
                //当列与所需结果的列相等时，行++
                if(cols==c){
                    rows++;
                    cols=0;
                }

                //ret[count/c][count%c]=nums[i][j];
                //count++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] nums={{1,2,3},{4,5,6}};
        System.out.println(Arrays.deepToString(matrixReshape(nums,1,6)));
    }
}
