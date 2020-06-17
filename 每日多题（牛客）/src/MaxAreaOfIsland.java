//岛屿的最大面积
//计算每一片由陆地组成的岛屿的面积，取最大的。
public class MaxAreaOfIsland {

    private static int DFS(int[][] grid,int x,int y,int row,int col){
        if(x<0||x>=row||y<0||y>=col||grid[x][y]==0)
            return 0;

        grid[x][y]=0;

        int num=1;
        num+=DFS(grid,x-1,y,row,col);  //上
        num+=DFS(grid,x+1,y,row,col);  //下
        num+=DFS(grid,x,y-1,row,col);  //左
        num+=DFS(grid,x,y+1,row,col);  //右

        return num;
    }

    public static int maxAreaOfIsland(int[][] grid) {
        if(grid==null||grid.length==0)
            return 0;
        int row=grid.length;
        int col=grid[0].length;
        int res=0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    int area=DFS(grid,i,j,row,col);
                    res=area>res?area:res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid={{0,0,1,0,0,0,0,1,0,0,0,0,0},
                      {0,0,0,0,0,0,0,1,1,1,0,0,0},
                      {0,1,1,0,1,0,0,0,0,0,0,0,0},
                      {0,1,0,0,1,1,0,0,1,0,1,0,0},
                      {0,1,0,0,1,1,0,0,1,1,1,0,0},
                      {0,0,0,0,0,0,0,0,0,0,1,0,0},
                      {0,0,0,0,0,0,0,1,1,1,0,0,0},
                      {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        System.out.println(maxAreaOfIsland(grid));
    }
}
