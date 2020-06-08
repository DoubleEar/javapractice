//最小路径和
// 给定一个m*n的网格，网格用非负数填充，找到一条从左上角到右下角的短路径。
// 注：每次只能向下或者向右移动。
public class MinPathSum {
    public static int minPathSum (int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;

        if(row==0||col==0)
            return 0;

        //初始化第0列 F(i,0) = F(i-1,0) + (i,0)
        for(int i=1;i<row;i++){
            grid[i][0]=grid[i-1][0]+grid[i][0];
        }
        //初始化第0行 F(0,i) = F(0,i-1) + (0,i)  
        for(int i=1;i<col;i++){
            grid[0][i]=grid[0][i-1]+grid[0][i];
        }

        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                //状态方程  F(i,j) = min{F(i-1,j) , F(i,j-1)} + (i,j)
                grid[i][j]=Math.min(grid[i-1][j],grid[i][j-1])+grid[i][j];
            }
        }
        //返回值
        //F(m-1,n-1)
        return grid[row-1][col-1];
    }

    public static void main(String[] args) {
        int[][] grid={{1,2},{5,6},{1,1}};
        System.out.println(minPathSum(grid));
    }
}
