//搜索 m x n 矩阵 matrix 中的一个目标值 target
public class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        /*for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==target)
                    return true;
            }
        }
        return false;
        */
        int row=matrix.length-1;
        int col=0;
        while(row>=0&&col<matrix[0].length) {
            //从行开始从后往前搜索
            if (matrix[row][col] > target) {
                row--;
            //从列开始从前后往后搜索
            } else if(matrix[row][col] < target) {
                col++;
            }else{
            //找到了
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix={
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}};
        System.out.println(searchMatrix(matrix,7));
    }
}

