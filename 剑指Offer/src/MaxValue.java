//礼物的最大价值
public class MaxValue {
    /*
    public static int maxValue(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0&&j==0)
                    continue;
                else if(i==0)
                    grid[i][j]+=grid[i][j-1];
                else if(j==0)
                    grid[i][j]+=grid[i-1][j];
                else
                    grid[i][j]+=Math.max(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[row-1][col-1];
    }
    */

    public static int maxValue(int[][] grid) {
        /*
          当 i=0且j=0时,为起始元素；
          当 i=0且j≠0时,为矩阵第一行元素，只可从左边到达；
          当 i≠0且j=0时,为矩阵第一列元素，只可从上边到达；
          当 i≠0且j≠0时,可从左边或上边到达；
         */
        int row=grid.length;
        int col=grid[0].length;

        //初始化第一行：grid(i,j)+dp(i,j-1)
        for(int i=1;i<col;i++)
            grid[0][i]+=grid[0][i-1];

        //初始化第一列：grid(i,j)+dp(i-1,j)
        for(int i=1;i<row;i++)
            grid[i][0]+=grid[i-1][0];

        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                //grid(i,j)+max[dp(i-1,j),dp(i,j-1)]
                grid[i][j]+=Math.max(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[row-1][col-1];  //返回左下角的元素值
    }

    public static void main(String[] args) {
        int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(maxValue(grid));
    }
}
