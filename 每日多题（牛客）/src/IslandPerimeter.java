//岛屿的周长
//计算岛屿的周长。其中恰好只有一个岛屿。
public class IslandPerimeter {
    private static int DFS(int[][] grid,int x,int y,int row,int col){
        if(x<0||x>=row||y<0||y>=col)    //与网格边界相邻的周长+1
            return 1;

        if(grid[x][y]==0)      //与水域方格相邻的周长+1
            return 1;

        if(grid[x][y]!=1)      //不是陆地或者已经被遍历过
            return 0;

        grid[x][y]=2;          //标记遍历过的陆地

        return   DFS(grid,x-1,y,row,col)   //上
                +DFS(grid,x+1,y,row,col)   //下
                +DFS(grid,x,y-1,row,col)   //左
                +DFS(grid,x,y+1,row,col);  //右
    }

    public static int islandPerimeter(int[][] grid) {
        if(grid==null||grid.length==0)
            return 0;
        int row=grid.length;
        int col=grid[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1)
                    return DFS(grid,i,j,row,col);   //只有一个岛屿
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] grid={{0,1,0,0},
                      {1,1,1,0},
                      {0,1,0,0},
                      {1,1,0,0}};

        System.out.println(islandPerimeter(grid));
    }
}
