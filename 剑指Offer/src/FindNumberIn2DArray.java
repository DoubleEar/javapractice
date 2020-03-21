//二维数组中查找整数
public class FindNumberIn2DArray {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return false;
        int rows=matrix.length,cols=matrix[0].length;
        //从二维数组的右上角开始查找
        int row=0,col=cols-1;

        while (row<rows&&col>=0){
            int nums=matrix[row][col];
            if(nums==target)
                return true;
            //如果当前遍历到的数字大于target,遍历前一列。
            else if(nums>target)
                col--;
            //如果当前遍历到的数字小于target,遍历下一行。
            else
                row++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix={{1,4,7,11,15},
                        {2,5,8,12,19},
                        {3,6,9,16,22},
                        {10,13,14,17,24}};
        System.out.println(findNumberIn2DArray(matrix,5));
    }
}
