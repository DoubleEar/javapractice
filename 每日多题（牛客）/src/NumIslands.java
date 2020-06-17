//岛屿的数量
public class NumIslands {
    /*
       给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
       岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
       此外，你可以假设该网格的四条边均被水包围。

       岛屿是由陆地构成的。所以从周围计算，只要是可以连通的陆地都可以构成岛屿。
     */
    static int[][] direction={{-1,0},{1,0},{0,-1},{0,1}};
    private static void DFS(char[][] grid,int[][] visited,int x,int y,int row,int col){
        visited[x][y]=1;

        for(int i=0;i<4;i++){
            int newX=x+direction[i][0];
            int newY=y+direction[i][1];

            if(newX<0||newX>=row||newY<0||newY>=col)
                continue;

            //是岛屿并且没有被遍历过
            if(grid[newX][newY]=='1'&&visited[newX][newY]==0)
                DFS(grid,visited,newX,newY,row,col);
        }
    }

    public static int numIslands(char[][] grid) {
        if(grid==null)
            return 0;
        int row=grid.length;
        int col=grid[0].length;
        int res=0;
        int[][] visited=new int[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'&&visited[i][j]==0){
                    res++;      //当有一块陆地时就说明可以拼成一个岛屿
                    DFS(grid,visited,i,j,row,col);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] grid={{'1','1','1','1','0'},
                       {'1','1','0','1','0'},
                       {'1','1','0','0','0'},
                       {'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }
}
